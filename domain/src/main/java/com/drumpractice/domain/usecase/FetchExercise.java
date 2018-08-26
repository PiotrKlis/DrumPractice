package com.drumpractice.domain.usecase;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.model.ExerciseSet;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public class FetchExercise {

    private final ExerciseSetRepository exerciseSetRepository;

    @Inject
    protected FetchExercise(@NonNull ExerciseSetRepository exerciseSetRepository) {
        this.exerciseSetRepository = exerciseSetRepository;
    }

    public Single<ExerciseSet> execute(int numberOfExerciseSet) {
        return exerciseSetRepository.getSelectedExercise(numberOfExerciseSet);
    }
}
