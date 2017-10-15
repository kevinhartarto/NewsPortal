package com.example.android.newsportal;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage= 0;
    private static final Integer[] images = {R.drawable.ship, R.drawable.soerabaja, R.drawable.windmill};
    private ArrayList<Integer> arrImages = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        for(int i = 0; i < images.length;i++)
            arrImages.add(images[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
    }
}
