package com.drumpractice.external.dto;

import com.google.gson.annotations.SerializedName;

public class ExerciseDto {
    @SerializedName("Time")
    private int time;
    @SerializedName("ExerciseName")
    private String name;
    @SerializedName("Image")
    private int image;
    @SerializedName("Id")
    private int id;

    public int getId() {
        return id;
    }

    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
