package com.example.uas.models;

public class Post {
    private String userId, id, title, body;

    public Post(String userId, String id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
}
