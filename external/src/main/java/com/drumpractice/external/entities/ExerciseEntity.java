package com.drumpractice.external.entities;

import io.realm.RealmObject;

public class ExerciseEntity extends RealmObject {
    private int id;
    private long time;
    private String name;
    private int image;
    public ExerciseEntity() {

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
