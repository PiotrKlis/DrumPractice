package com.drumpractice.domain;

import com.drumpractice.domain.model.ExerciseSet;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface ExerciseSetRepository {

    Observable<Boolean> isDatabaseEmpty();

    Observable<List<ExerciseSet>> getExerciseSets();

    Observable<ExerciseSet> getCurrentExerciseSet();

    Observable<List<ExerciseSet>> saveExerciseSets(List<ExerciseSet> exerciseSets);

    Observable<Integer> getSelectedExerciseId();

    Observable<Integer> setSelectedExerciseId();

    void clear();
}
