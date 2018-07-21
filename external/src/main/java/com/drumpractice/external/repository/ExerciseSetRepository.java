package com.drumpractice.external.repository;

import com.drumpractice.domain.model.ExerciseSet;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface ExerciseSetRepository {

    Observable<Boolean> isDatabaseEmpty();

    Single<List<ExerciseSet>> getExerciseSets();

    Single<List<ExerciseSet>> saveExerciseSets();
}
