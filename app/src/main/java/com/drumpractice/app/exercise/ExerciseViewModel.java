package com.drumpractice.app.exercise;

import com.drumpractice.app.exercise_list.ExerciseSet;
import com.drumpractice.domain.usecase.FetchExercisesUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public class ExerciseViewModel {

    private final FetchExercisesUseCase fetchExercisesUseCase;
    private Observable<List<ExerciseSet>> exercises;
    private Observable<Throwable> errors;

    @Inject
    public ExerciseViewModel(@NonNull final FetchExercisesUseCase fetchExercisesUseCase) {
        this.fetchExercisesUseCase = fetchExercisesUseCase;
    }

}
