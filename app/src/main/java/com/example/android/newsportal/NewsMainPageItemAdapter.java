package com.example.android.newsportal;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by KEVIN on 10/21/2017.
 */

public class NewsMainPageItemAdapter extends ArrayAdapter<News> {

    public NewsMainPageItemAdapter( Context context, ArrayList<News> data) {
        super(context, R.layout.news_item_list_1, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        News news = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_item_list_1, parent, false);


        ImageView gambar = (ImageView) convertView.findViewById(R.id.imageView_newsImage);
        TextView judul = (TextView) convertView.findViewById(R.id.textView_Title);
        TextView waktu = (TextView) convertView.findViewById(R.id.textView_time);

        gambar.setImageResource(news.getImage());
        judul.setText(news.getTitle());
        waktu.setText(news.getCategories()+" | "+news.getTime());

        return convertView;
    }
}
