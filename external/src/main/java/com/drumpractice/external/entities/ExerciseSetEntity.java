package com.drumpractice.external.entities;


import io.realm.RealmList;
import io.realm.RealmObject;

public class ExerciseSetEntity extends RealmObject {
    private int id;
    private String name;
    private int tempo;
    private RealmList<ExerciseEntity> exercises;
    public ExerciseSetEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public RealmList<ExerciseEntity> getExercises() {
        return exercises;
    }

    public void setExercises(RealmList<ExerciseEntity> exercises) {
        this.exercises = exercises;
    }
}
