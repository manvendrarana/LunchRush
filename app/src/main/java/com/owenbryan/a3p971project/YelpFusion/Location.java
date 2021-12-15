package com.owenbryan.a3p971project.YelpFusion;

public class Location {

    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String country;
    private String state;
    private String zipCode;
    private String [] displayAddress;

    public Location () {}

    public Location(String address1, String address2, String address3, String city, String country, String state, String zipCode, String[] displayAddress) {
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.country = country;
        this.state = state;
        this.zipCode = zipCode;
        this.displayAddress = displayAddress;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String[] getDisplayAddress() {
        return displayAddress;
    }

    public void setDisplayAddress(String[] displayAddress) {
        this.displayAddress = displayAddress;
    }
}
