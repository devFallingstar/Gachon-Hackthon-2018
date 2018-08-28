package com.devfallingstar.gachonhackerthon2018.ui.home.main;

import android.graphics.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.devfallingstar.gachonhackerthon2018.R;
import com.devfallingstar.gachonhackerthon2018.basic.activities.BasicActivity;
import com.devfallingstar.gachonhackerthon2018.basic.intefaces.ui.BasicActivityInterface;
import com.devfallingstar.gachonhackerthon2018.ui.home.main.fragment.CameraFragment;
import com.devfallingstar.gachonhackerthon2018.ui.home.main.fragment.HomeFragment;
import com.devfallingstar.gachonhackerthon2018.ui.home.main.fragment.MypageFragment;
import com.devfallingstar.gachonhackerthon2018.ui.mypage.sub.MyArticlesFragment;
import com.devfallingstar.gachonhackerthon2018.ui.mypage.sub.MyPicturesFragment;

public class HomeActivity extends BasicActivity implements BasicActivityInterface,
        HomeFragment.OnFragmentInteractionListener,
        CameraFragment.OnFragmentInteractionListener,
        MypageFragment.OnFragmentInteractionListener,
        MyPicturesFragment.OnFragmentInteractionListener,
        MyArticlesFragment.OnFragmentInteractionListener{
    BottomNavigationView bottomNavigationView;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.navigation_view);

       transaction = getSupportFragmentManager().beginTransaction();
       transaction.replace(R.id.frame_container, HomeFragment.newInstance("Home", "arg2"));
       transaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.navigation_mypage:
                        selectedFragment = MypageFragment.newInstance("Mypage", "arg3");
                        break;
                    case R.id.navigation_home:
                        selectedFragment = HomeFragment.newInstance("Home", "arg2");
                        break;
                    case R.id.navigation_camera:
                        selectedFragment = CameraFragment.newInstance("Camera", "arg2");
                        break;
                    default:
                        selectedFragment = HomeFragment.newInstance("Home", "arg2");
                        break;
                }
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, selectedFragment);
                transaction.commit();
                return true;
            }
        });
    }

    @Override
    public void initializeUI() {
    }
    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

}