package com.drumpractice.external.repository;

import com.drumpractice.domain.model.ExerciseSet;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;

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
    public Single<List<ExerciseSet>> getExerciseSets() {
        return null;
    }

    @Override
    public Single<List<ExerciseSet>> saveExerciseSets() {
        return null;
    }
}
