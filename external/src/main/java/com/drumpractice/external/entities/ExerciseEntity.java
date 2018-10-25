package com.drumpractice.external.entities;

import io.realm.RealmObject;

public class ExerciseEntity extends RealmObject {

    private long time;
    private String name;
    private int image;

    public ExerciseEntity() {

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
