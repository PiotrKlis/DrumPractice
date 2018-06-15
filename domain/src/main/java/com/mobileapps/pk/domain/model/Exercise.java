package com.mobileapps.pk.domain.model;


public class Exercise {

    private int time;
    private String name;
    private int image;

    public Exercise() {
    }

    public Exercise(int time, String name, int image) {
        this.time = time;
        this.name = name;
        this.image = image;
    }

    public int getTime() {

        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
