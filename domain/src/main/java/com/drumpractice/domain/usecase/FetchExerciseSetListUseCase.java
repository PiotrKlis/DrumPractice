package com.drumpractice.domain.usecase;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.model.ExerciseSet;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class FetchExerciseSetListUseCase {


    private final ExerciseSetRepository exerciseSetRepository;

    @Inject
    public FetchExerciseSetListUseCase(ExerciseSetRepository exerciseSetRepository) {
        this.exerciseSetRepository = exerciseSetRepository;
    }

    public Observable<List<ExerciseSet>> execute() {
        return exerciseSetRepository.getExerciseSets();
    }
}
