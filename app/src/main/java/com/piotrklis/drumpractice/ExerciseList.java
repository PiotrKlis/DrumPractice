package com.piotrklis.drumpractice;


import java.util.List;

public class ExerciseList {

    private Exercise exercise;
    private String name;

    public ExerciseList(Exercise exercise, List<Exercise> exerciseList, String name) {
        this.exercise = exercise;
        this.name = name;
    }


    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
