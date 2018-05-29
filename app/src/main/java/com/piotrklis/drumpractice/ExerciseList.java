package com.piotrklis.drumpractice;


import java.util.List;

public class ExerciseList {

    Exercise exercise;
    List<Exercise> exerciseList;
    String name;

    public ExerciseList(Exercise exercise, List<Exercise> exerciseList, String name) {
        this.exercise = exercise;
        this.exerciseList = exerciseList;
        this.name = name;
    }


    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
