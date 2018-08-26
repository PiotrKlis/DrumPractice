package com.drumpractice.domain.usecase;

import com.drumpractice.domain.ExerciseSetRepository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public class FetchSelectedExerciseId {

    private final ExerciseSetRepository exerciseSetRepository;

    @Inject
    protected FetchSelectedExerciseId(@NonNull ExerciseSetRepository exerciseSetRepository) {
        this.exerciseSetRepository = exerciseSetRepository;
    }

    public Single<Integer> execute() {
        return exerciseSetRepository.getSelectedExerciseId();
    }

}
