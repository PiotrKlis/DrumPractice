package com.drumpractice.domain.model;


public class Exercise {

    private long time;
    private String name;
    private int image;
    private int id;

    public Exercise() {
    }

    public Exercise(int time, String name, int image) {
        this.time = time;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTime() {

        return time;
    }

    public void setTime(long time) {
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
