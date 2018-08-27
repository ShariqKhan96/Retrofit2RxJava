package com.webxert.retrofit2rxjava.Model;

import java.util.List;

/**
 * Created by hp on 8/9/2018.
 */

public class RootObject
{
    public List<Post> posts;
    public List<Comment> comments;
    public Profile profile;

    public RootObject() {
    }

    public RootObject(List<Post> posts, List<Comment> comments, Profile profile) {
        this.posts = posts;
        this.comments = comments;
        this.profile = profile;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}