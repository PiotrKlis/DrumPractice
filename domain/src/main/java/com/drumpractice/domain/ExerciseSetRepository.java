package com.drumpractice.domain;

import com.drumpractice.domain.model.ExerciseSet;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface ExerciseSetRepository {

    Observable<Boolean> isDatabaseEmpty();

    Single<List<ExerciseSet>> getExerciseSets();

    Single<ExerciseSet> getSelectedExercise(int numberOfExerciseSet);

    Single<List<ExerciseSet>> saveExerciseSets();

    Single<Integer> getSelectedExerciseId();

    Single<Integer> setSelectedExerciseId();
}
