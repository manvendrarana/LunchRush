package com.owenbryan.a3p971project.YelpFusion;


public class Business {

    private Category [] categories;
    private double latitude;
    private double longitude;
    private String displayPhone;
    private String id;
    private String name;
    private String url;
    private Location location;
    private String phone;
    private double rating;
    private int reviewCount;

    public Business ()
    {

    }

    public Business(Category[] categories, double latitude, double longitude, String displayPhone, String id, String name, String url, Location location, String phone, double rating, int reviewCount) {
        this.categories = categories;
        this.latitude = latitude;
        this.longitude = longitude;
        this.displayPhone = displayPhone;
        this.id = id;
        this.name = name;
        this.url = url;
        this.location = location;
        this.phone = phone;
        this.rating = rating;
        this.reviewCount = reviewCount;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDisplayPhone() {
        return displayPhone;
    }

    public void setDisplayPhone(String displayPhone) {
        this.displayPhone = displayPhone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }
}
