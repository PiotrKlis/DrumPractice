package com.drumpractice.external.entities;


import io.realm.RealmList;
import io.realm.RealmObject;

public class ExerciseSetEntity extends RealmObject {
    private String exerciseSetName;
    private int tempo;
    private RealmList<ExerciseEntity> exercises;

    public ExerciseSetEntity() {

    }
}
