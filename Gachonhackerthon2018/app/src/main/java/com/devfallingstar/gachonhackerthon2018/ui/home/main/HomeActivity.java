package com.devfallingstar.gachonhackerthon2018.ui.home.main;

import android.os.Bundle;

import com.devfallingstar.gachonhackerthon2018.R;
import com.devfallingstar.gachonhackerthon2018.basic.activities.BasicActivity;
import com.devfallingstar.gachonhackerthon2018.basic.intefaces.ui.BasicActivityInterface;

public class HomeActivity extends BasicActivity implements BasicActivityInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public void initializeUI() {

    }
}
