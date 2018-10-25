package com.drumpractice.external.repository;


import com.drumpractice.external.entities.ExerciseSetEntity;

import java.util.List;

import io.reactivex.Observable;

public interface ExerciseSetLocalDataSource {
    Observable<Boolean> isEmpty();

    void clear(Class<ExerciseSetEntity> entity);

    void insert(List<ExerciseSetEntity> entity);

    Observable<ExerciseSetEntity> findFirst();

}
