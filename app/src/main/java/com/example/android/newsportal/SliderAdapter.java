package com.example.android.newsportal;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KEVIN on 10/15/2017.
 */

public class SliderAdapter extends PagerAdapter{

    //private variables
    private ArrayList<Integer> images;
    private LayoutInflater inflater;
    private ArrayList<String> arrNewsTitle;
    private Context context;

    //constructor
    public SliderAdapter(ArrayList<Integer> images, Context context, ArrayList<String> arrNewsTitle) {
        this.context = context;
        this.images = images;
        this.inflater = LayoutInflater.from(context);
        this.arrNewsTitle = arrNewsTitle;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.slider, view, false);
        ImageView myImage = (ImageView) myImageLayout
                .findViewById(R.id.image);
        TextView newsTitle = (TextView) myImageLayout.findViewById(R.id.textView_newsTitle);
        myImage.setImageResource(images.get(position));
        newsTitle.setText(arrNewsTitle.get(position));
        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
