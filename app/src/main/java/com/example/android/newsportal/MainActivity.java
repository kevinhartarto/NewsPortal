package com.example.android.newsportal;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.relex.circleindicator.CircleIndicator;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage= 0;
    private static final Integer[] images = {R.drawable.ship, R.drawable.soerabaja, R.drawable.windmill};
    private static final String[] titles = {"Kapal jadul jadi kenangan", "Game buatan mahasiswa", "Ayo terbang ke Eropa"};
    private ArrayList<Integer> arrImages = new ArrayList<Integer>();
    private ArrayList<String> arrNewsTitle =  new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //carousel initialization
        initSlider();
    }

    private void initSlider(){
        //getting images for carousel
        for(int i = 0; i < images.length;i++)
            arrImages.add(images[i]);

        //getting newstitle for the carousel
        for (int i = 0; i < titles.length; i++)
            arrNewsTitle.add(titles[i]);

        mPager = (ViewPager) findViewById(R.id.pager); mPager.setAdapter(new SliderAdapter(arrImages, MainActivity.this, arrNewsTitle));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == images.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }
}
