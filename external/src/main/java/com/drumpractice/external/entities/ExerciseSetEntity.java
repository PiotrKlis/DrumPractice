package com.drumpractice.external.entities;


import io.realm.RealmList;
import io.realm.RealmObject;

public class ExerciseSetEntity extends RealmObject {
    private String exerciseSetName;
    private int tempo;
    private RealmList<ExerciseEntity> exercises;

    public ExerciseSetEntity() {

    }

    public String getExerciseSetName() {
        return exerciseSetName;
    }

    public void setExerciseSetName(String exerciseSetName) {
        this.exerciseSetName = exerciseSetName;
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
