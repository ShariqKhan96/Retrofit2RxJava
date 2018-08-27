package com.webxert.retrofit2rxjava.Model;

/**
 * Created by hp on 8/9/2018.
 */

public class Post {

    public int id;
    public String title;


    public Post() {
    }

    public Post(int id, String title) {

        this.id = id;
        this.title = title;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
