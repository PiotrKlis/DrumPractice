package com.drumpractice.domain.model;

import java.util.List;

public class ExerciseSet {
    private int id;
    private List<Exercise> exercise;
    private String name;
    private int tempo;

    public ExerciseSet(int id, List<Exercise> exercise, String name, int tempo) {
        this.id = id;
        this.exercise = exercise;
        this.name = name;
        this.tempo = tempo;
    }

    public ExerciseSet() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
