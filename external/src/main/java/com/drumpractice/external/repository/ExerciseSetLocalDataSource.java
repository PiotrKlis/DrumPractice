package com.drumpractice.external.repository;


import com.drumpractice.external.entities.ExerciseSetEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface ExerciseSetLocalDataSource {
    Single<Boolean> isEmpty();

    void clear(Class<ExerciseSetEntity> entity);

    Boolean insert(List<ExerciseSetEntity> entity);

    Observable<ExerciseSetEntity> findFirst();

    Observable<List<ExerciseSetEntity>> getAllExerciseSets();
}
