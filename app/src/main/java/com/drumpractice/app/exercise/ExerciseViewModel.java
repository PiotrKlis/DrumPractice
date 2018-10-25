package com.drumpractice.app.exercise;

import com.drumpractice.domain.model.ExerciseSet;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class ExerciseViewModel {

    private Observable<ExerciseSet> exerciseSet;
    private Observable<Integer> integerObservable;
    private Single<Throwable> errors;
    private int id;

    @Inject
    public ExerciseViewModel() {
        //(@NonNull final FetchExerciseSetUseCase fetchExerciseSetUseCase) {
//        PublishSubject<Irrelevant> exerciseSetTrigger = PublishSubject.create();
//        Observable<Notification<ExerciseSet>> materializedExerciseSet = exerciseSetTrigger
//                .startWith(Irrelevant.INSTANCE)
//                .flatMap(__ -> fetchExerciseSetUseCase.execute())
//                .materialize()
//                .share();
//
//        this.exerciseSet = materializedExerciseSet
//                .filter(Notification::isOnNext)
//                .map(Notification::getValue);

    }

    public Observable<ExerciseSet> getExerciseSet() {
        return null;
    }

    private enum Irrelevant {INSTANCE}

}
