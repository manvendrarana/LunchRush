package com.owenbryan.a3p971project.YelpFusion;

public class Review {

    private String id;
    private String text;
    private String url;
    private int rating;
    private String timeCreated;

    public Review() {
    }

    public Review(String id, String text, String url, int rating, String timeCreated) {
        this.id = id;
        this.text = text;
        this.url = url;
        this.rating = rating;
        this.timeCreated = timeCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }
}
