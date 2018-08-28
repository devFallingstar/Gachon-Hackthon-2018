package com.devfallingstar.gachonhackerthon2018.helper.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.devfallingstar.gachonhackerthon2018.ui.mypage.sub.MyArticlesFragment;
import com.devfallingstar.gachonhackerthon2018.ui.mypage.sub.MyPicturesFragment;

public class MypagePageAdapter extends FragmentPagerAdapter {
    public static int PAGE_NUMBERR = 2;
    public MypagePageAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return MyArticlesFragment.newInstance("User's article", "arg2");
            case 1:
                return MyPicturesFragment.newInstance("User's pictures", "arg2");
            default:
                return null;
        }
    }
    @Override
    public int getCount(){
        return PAGE_NUMBERR;
    }
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Articles";
            case 1:
                return "Pictures";
            default:
                return null;
        }
    }
}