package com.example.android.newsportal;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import me.relex.circleindicator.CircleIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] images = {R.drawable.ship, R.drawable.soerabaja, R.drawable.windmill};
    private static final String[] titles = {"Kapal jadul jadi kenangan", "Game buatan mahasiswa", "Ayo terbang ke Eropa"};
    private ArrayList<Integer> arrImages = new ArrayList<Integer>();
    private ArrayList<String> arrNewsTitle = new ArrayList<String>();
    private ArrayList<News> arrNews = new ArrayList<News>();

    ListView kontenBerita;
    NewsMainPageItemAdapter newsAdapter;
    ImageView hamburgertop, hamburgerside;
    LinearLayout sidebar;
    TextView appname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Carousel initialization
        initSlider();

        //News Content initialization
        kontenBerita = (ListView) findViewById(R.id.listView_beritaTerkini);

        hamburgertop = (ImageView) findViewById(R.id.hamburgertop);
        hamburgerside = (ImageView) findViewById(R.id.hamburgerside);
        sidebar = (LinearLayout) findViewById(R.id.sidebar);
        appname = (TextView) findViewById(R.id.appname);

        hamburgertop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sidebar.setVisibility(View.VISIBLE);
            }
        });

        hamburgerside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sidebar.setVisibility(View.GONE);
            }
        });


        initNews();
    }

    private void initSlider() {
        //getting images for carousel
        for (int i = 0; i < images.length; i++)
            arrImages.add(images[i]);

        //getting newstitle for the carousel
        for (int i = 0; i < titles.length; i++)
            arrNewsTitle.add(titles[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SliderAdapter(arrImages, MainActivity.this, arrNewsTitle));
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

    public void initNews() {
        //dummy data
        News berita1 = new News(1, R.drawable.ship, "Kapal jadul jadi kenangan", "masih kosong", "21-Oktober-2017", "kevin", "nasional");
        News berita2 = new News(2, R.drawable.soerabaja, "Game buatan mahasiswa", "masih kosong", "21-Oktober-2017", "kevin", "entertaiment");
        News berita3 = new News(3, R.drawable.windmill, "Ayo terbang ke Eropa", "masih kosong", "21-Oktober-2017", "kevin", "lifestyle");
        News berita4 = new News(4, R.drawable.windmill, "Ayo terbang ke Eropa", "masih kosong", "21-Oktober-2017", "kevin", "lifestyle");
        News berita5 = new News(5, R.drawable.windmill, "Ayo terbang ke Eropa", "masih kosong", "21-Oktober-2017", "kevin", "lifestyle");

        arrNews.add(berita1);
        arrNews.add(berita2);
        arrNews.add(berita3);
        arrNews.add(berita4);
        arrNews.add(berita5);
        newsAdapter = new NewsMainPageItemAdapter(this, arrNews);
        kontenBerita.setAdapter(newsAdapter);
    }
}
