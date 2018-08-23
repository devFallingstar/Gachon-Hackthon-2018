package com.devfallingstar.gachonhackerthon2018.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.devfallingstar.gachonhackerthon2018.R;
import com.devfallingstar.gachonhackerthon2018.ui.home.main.HomeActivity;
import com.devfallingstar.gachonhackerthon2018.ui.login.main.LoginActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
