package com.drumpractice.external.repository;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.model.ExerciseSet;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class ExerciseSetRepositoryImpl implements ExerciseSetRepository {

    private final ExerciseSetLocalDataSource exerciseSetLocalDataSource;

    @Inject
    public ExerciseSetRepositoryImpl(ExerciseSetLocalDataSource exerciseSetLocalDataSource) {
        this.exerciseSetLocalDataSource = exerciseSetLocalDataSource;
    }

    @Override
    public Single<Boolean> isDatabaseEmpty() {
        return exerciseSetLocalDataSource.findFirst()
                .map(exerciseSetEntity -> false)
                .onErrorResumeNext(throwable -> Single.just(true));
    }

    @Override
    public Observable<List<ExerciseSet>> getExerciseSets() {
        return null;
    }

    @Override
    public Observable<ExerciseSet> getCurrentExerciseSet() {

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
