package com.example.android.newsportal;

/**
 * Created by KEVIN on 10/21/2017.
 */

public class News {

    private int id;
    private int image;
    private String title;
    private String content;
    private String time;
    private String penulis;
    private String categories;

    public News(int id, int image, String title, String content, String time, String penulis, String categories) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.content = content;
        this.time = time;
        this.penulis = penulis;
        this.categories = categories;
    }

    public News(int image, String title, String time) {
        this.image = image;
        this.title = title;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
