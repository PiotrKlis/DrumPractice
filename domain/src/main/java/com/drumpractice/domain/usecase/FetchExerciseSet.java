package com.drumpractice.domain.usecase;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.model.ExerciseSet;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public class FetchExerciseSet {

    private final ExerciseSetRepository exerciseSetRepository;

    @Inject
    protected FetchExerciseSet(@NonNull ExerciseSetRepository exerciseSetRepository) {
        this.exerciseSetRepository = exerciseSetRepository;
    }

    public Observable<ExerciseSet> fetchExerciseSet(int numberOfExerciseSet) {
        return exerciseSetRepository.getSelectedExercise(numberOfExerciseSet);
    }
}
