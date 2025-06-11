package com.suvarna.headlessdpc;

import android.app.Activity;
import android.os.Bundle;

public class PolicyComplianceActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setResult(Activity.RESULT_OK);
        finish();
    }
}
