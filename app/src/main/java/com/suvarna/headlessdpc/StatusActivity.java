package com.suvarna.headlessdpc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class StatusActivity extends Activity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String message = getIntent().getStringExtra("status_message");

        TextView statusView = new TextView(this);
        statusView.setTextSize(18);
        statusView.setPadding(32, 100, 32, 32);
        statusView.setText("Provisioning status:\n\n" + message);

        setContentView(statusView);
    }
}
