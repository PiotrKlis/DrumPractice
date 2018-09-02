package com.drumpractice.domain.usecase;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.model.ExerciseSet;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public class FetchExerciseSetUseCase {

    private final ExerciseSetRepository exerciseSetRepository;

    @Inject
    protected FetchExerciseSetUseCase(@NonNull ExerciseSetRepository exerciseSetRepository) {
        this.exerciseSetRepository = exerciseSetRepository;
    }

    public Observable<ExerciseSet> execute() {
        return exerciseSetRepository.getCurrentExerciseSet();
    }
}
