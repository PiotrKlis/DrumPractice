package com.drumpractice.external.repository;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.model.ExerciseSet;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class ExerciseSetRepositoryImpl implements ExerciseSetRepository {

    private final ExerciseSetLocalDataSource exerciseSetLocalDataSource;

    public ExerciseSetRepositoryImpl(ExerciseSetLocalDataSource exerciseSetLocalDataSource) {
        this.exerciseSetLocalDataSource = exerciseSetLocalDataSource;
    }

    @Override
    public Observable<Boolean> isDatabaseEmpty() {
        return exerciseSetLocalDataSource.findFirst()
                .map(exerciseSetEntity -> false)
                .onErrorResumeNext(throwable -> {
                    return Observable.just(true);
                });
    }

    @Override
    public Observable<List<ExerciseSet>> getExerciseSets() {
        return null;
    }

    @Override
    public Observable<ExerciseSet> getSelectedExercise(int numberOfExerciseSet) {
        return null;
    }

    @Override
    public Observable<List<ExerciseSet>> saveExerciseSets() {
        return null;
    }

    @Override
    public Observable<Integer> getSelectedExerciseId() {
        return null;
    }

    @Override
    public Observable<Integer> setSelectedExerciseId() {
        return null;
    }
}
