package com.piotrklis.drumpractice.model;


import java.util.List;

public class ExerciseSet {

    private List<Exercise> exercise;
    private String name;

    public ExerciseSet(List<Exercise> exercise, String name) {
        this.exercise = exercise;
        this.name = name;
    }


    public List<Exercise> getExercise() {
        return exercise;
    }

    public void setExercise(List<Exercise> exercise) {
        this.exercise = exercise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
