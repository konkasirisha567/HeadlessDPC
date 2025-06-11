package com.suvarna.headlessdpc;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;


public class MyDeviceAdminReceiver extends DeviceAdminReceiver {


    @Override
    public void onEnabled(Context context, Intent intent) {
        try {
            DevicePolicyManager dpm = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
            ComponentName adminComponent = new ComponentName(context, MyDeviceAdminReceiver.class);

            // Block uninstallation of your DMS app
            dpm.setUninstallBlocked(adminComponent, "com.softhealth.dms", true);

            // Hide Google Play Store
            dpm.setApplicationHidden(adminComponent, "com.android.vending", true);

            // Hide YouTube
            dpm.setApplicationHidden(adminComponent, "com.google.android.youtube", true);

            // Restrict Chrome to allow only one website
            Bundle chromeConfig = new Bundle();
            chromeConfig.putStringArray("URLBlacklist", new String[] { "*" });
            chromeConfig.putStringArray("URLWhitelist", new String[] { "https://softhealth.co.in/" });
            dpm.setApplicationRestrictions(adminComponent, "com.android.chrome", chromeConfig);

            // Block installing apps from unknown sources
            dpm.addUserRestriction(adminComponent, UserManager.DISALLOW_INSTALL_UNKNOWN_SOURCES);

            // Show success message
            showStatus(context, "Device provisioning complete. Policies applied.");

        } catch (Exception e) {
            e.printStackTrace();
            showStatus(context, "Provisioning failed:\n" + e.getMessage());
        }
    }

    private void showStatus(Context context, String message) {
        Intent statusIntent = new Intent(context, StatusActivity.class);
        statusIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        statusIntent.putExtra("status_message", message);
        context.startActivity(statusIntent);
    }

}
