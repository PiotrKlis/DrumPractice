package com.drumpractice.app.viewmodel;

import com.drumpractice.app.model.ExerciseSet;
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
    public ExerciseViewModel(@NonNull final FetchExercisesUseCase fetchExercisesUseCase1) {
        this.fetchExercisesUseCase = fetchExercisesUseCase1;
    }

}
