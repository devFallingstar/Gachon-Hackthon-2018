package com.devfallingstar.gachonhackerthon2018.ui.login.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.devfallingstar.gachonhackerthon2018.R;
import com.devfallingstar.gachonhackerthon2018.ui.home.main.HomeActivity;

public class LoginActivity extends AppCompatActivity {
    Button test_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        test_btn = findViewById(R.id.to_activity_login);

        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}