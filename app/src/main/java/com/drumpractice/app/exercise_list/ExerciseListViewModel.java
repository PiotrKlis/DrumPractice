package com.drumpractice.app.exercise_list;

import com.drumpractice.domain.model.ExerciseSet;
import com.drumpractice.domain.usecase.FetchExerciseSetListUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

class ExerciseListViewModel {

    private Observable<List<ExerciseSet>> exerciseSets;
    private Observable<Throwable> errors;

    @Inject
    ExerciseListViewModel(FetchExerciseSetListUseCase fetchExerciseSetListUseCase) {
        PublishSubject<Irrelevant> exerciseSetsTrigger = PublishSubject.create();
        Observable<Notification<List<ExerciseSet>>> materializedExerciseSets = exerciseSetsTrigger
                .startWith(Irrelevant.INSTANCE)
                .flatMap(__ -> fetchExerciseSetListUseCase.execute())
                .materialize()
                .share();

        this.exerciseSets = materializedExerciseSets
                .filter(Notification::isOnNext)
                .map(Notification::getValue);

        this.errors = materializedExerciseSets
                .filter(Notification::isOnError)
                .map(Notification::getError);
    }

    public Observable<List<ExerciseSet>> getExerciseSets() {
        return exerciseSets;
    }

    private enum Irrelevant {INSTANCE}

}
