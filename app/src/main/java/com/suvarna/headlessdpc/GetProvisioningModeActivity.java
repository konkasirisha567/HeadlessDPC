package com.suvarna.headlessdpc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build;

public class GetProvisioningModeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            Intent resultData = new Intent();
            resultData.putExtra("android.app.extra.PROVISIONING_MODE", "managed_device");
            setResult(Activity.RESULT_OK, resultData);
        } else {
            setResult(Activity.RESULT_CANCELED);
        }

        finish();
    }
}
