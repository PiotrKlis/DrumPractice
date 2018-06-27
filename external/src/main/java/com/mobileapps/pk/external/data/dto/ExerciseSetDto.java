package com.mobileapps.pk.external.data.dto;

import com.google.gson.annotations.SerializedName;
import com.mobileapps.pk.domain.model.Exercise;

import java.util.List;

public class ExerciseSetDto {
    @SerializedName("ExerciseSetName")
    private String exerciseSetName;
    @SerializedName("Tempo")
    private int tempo;
    @SerializedName("Exercises")
    private List<Exercise> exercises;
}
