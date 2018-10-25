package com.drumpractice.external.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExerciseSetDto {
    @SerializedName("ExerciseSetName")
    private String name;
    @SerializedName("Tempo")
    private int tempo;
    @SerializedName("Exercises")
    private List<ExerciseDto> exercises;
    @SerializedName("Id")
    private int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTempo() {
        return tempo;
    }

    public List<ExerciseDto> getExercises() {
        return exercises;
    }
}
