package com.yarncostingindia.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yarncostingindia.R;

public class LauncherHelper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_helper);
        SharedPreferences appdata = PreferenceManager.getDefaultSharedPreferences(this);
        boolean nameNumberEntered = appdata.getBoolean("nameNumberEntered",false);

        if(!nameNumberEntered)
        {
            Intent myIntent = new Intent(LauncherHelper.this, Authentication.class);
            LauncherHelper.this.startActivity(myIntent);
            finish();
        }
        else
        {
            Intent myIntent = new Intent(LauncherHelper.this, MainActivity.class);
            LauncherHelper.this.startActivity(myIntent);
            finish();
        }
    }
}
