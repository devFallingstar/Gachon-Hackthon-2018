package com.devfallingstar.gachonhackerthon2018.ui.functional.detail;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.devfallingstar.gachonhackerthon2018.R;
import com.devfallingstar.gachonhackerthon2018.ui.functional.write.ArticleWriteActivity;
import com.devfallingstar.gachonhackerthon2018.ui.home.main.HomeActivity;

import java.util.ArrayList;

public class PictureWithArticleActivity extends AppCompatActivity{
    private ListView artiList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_with_arti);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.article_item);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.back:
                Intent homeIntent = new Intent(this, HomeActivity.class);
                startActivity(homeIntent);
                return true;
            case R.id.write:
                Intent writeInent = new Intent(this, ArticleWriteActivity.class);
                startActivity(writeInent);
                return true;
            default:
                return false;
        }
    }
}
