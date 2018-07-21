package com.drumpractice.external.dto;

import com.google.gson.annotations.SerializedName;

public class ExerciseDto {
    @SerializedName("Time")
    private int time;
    @SerializedName("ExerciseName")
    private String name;
    @SerializedName("Image")
    private int image;
}
