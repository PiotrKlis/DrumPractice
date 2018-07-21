package com.drumpractice.external.dto;

import com.drumpractice.domain.model.Exercise;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExerciseSetDto {
    @SerializedName("ExerciseSetName")
    private String exerciseSetName;
    @SerializedName("Tempo")
    private int tempo;
    @SerializedName("Exercises")
    private List<Exercise> exercises;
}
