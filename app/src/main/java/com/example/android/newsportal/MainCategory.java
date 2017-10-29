package com.example.android.newsportal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 10/29/2017.
 */

public class MainCategory extends AppCompatActivity {
    private ArrayList<News> arrNews = new ArrayList<News>();

    TextView judulKategori;
    ListView listBerita;
    NewsMainPageItemAdapter newsAdapter;
    ImageView hamburgertop, hamburgerside;
    LinearLayout sidebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_main);

        judulKategori = (TextView) findViewById(R.id.judulKategori);
        listBerita = (ListView) findViewById(R.id.listView_beritaTerkini);

        sidebar(hamburgertop, hamburgerside, sidebar);
        initNews();
    }

    public void sidebar(ImageView hamburgertop, ImageView hamburgerside, LinearLayout sidebar) {
        hamburgertop = (ImageView) findViewById(R.id.hamburgertop);
        hamburgerside = (ImageView) findViewById(R.id.hamburgerside);
        sidebar = (LinearLayout) findViewById(R.id.sidebar);

        final LinearLayout finalSidebar = sidebar;
        hamburgertop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalSidebar.setVisibility(View.VISIBLE);
            }
        });

        hamburgerside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalSidebar.setVisibility(View.GONE);
            }
        });
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
        listBerita.setAdapter(newsAdapter);
    }
}
