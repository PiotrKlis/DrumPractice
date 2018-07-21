package com.drumpractice.domain.model;

import java.util.List;

public class ExerciseSet {
    private List<Exercise> exercise;
    private String name;
    private int tempo;

    public ExerciseSet(List<Exercise> exercise, String name, int tempo) {
        this.exercise = exercise;
        this.name = name;
        this.tempo = tempo;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
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
