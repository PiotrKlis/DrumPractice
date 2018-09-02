package com.drumpractice.domain.usecase;

import com.drumpractice.domain.ExerciseSetRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public class FetchCurrentExercisSeteIdUseCase {

    private final ExerciseSetRepository exerciseSetRepository;

    @Inject
    protected FetchCurrentExercisSeteIdUseCase(@NonNull ExerciseSetRepository exerciseSetRepository) {
        this.exerciseSetRepository = exerciseSetRepository;
    }

    public Observable<Integer> execute() {
        return exerciseSetRepository.getSelectedExerciseId();
    }

}
