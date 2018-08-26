package com.drumpractice.app.exercise;

import com.drumpractice.app.exercise_list.ExerciseSet;
import com.drumpractice.domain.usecase.FetchExerciseSet;
import com.drumpractice.domain.usecase.FetchSelectedExerciseId;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.subjects.PublishSubject;

public class ExerciseViewModel {

    @Inject
    private final FetchExerciseSet fetchExerciseSet;
    @Inject
    private final FetchSelectedExerciseId fetchSelectedExerciseId;
    private Observable<ExerciseSet> exerciseSet;
    private Observable<Integer> id;
    private Single<Throwable> errors;

    @Inject
    public ExerciseViewModel(@NonNull final FetchExerciseSet fetchExerciseSet,
                             @NonNull final FetchSelectedExerciseId fetchSelectedExerciseId) {
        PublishSubject<Irrelevant> exerciseSelectedTrigger = PublishSubject.create();
        Observable<Notification<Integer>> materializedExerciseId = exerciseSelectedTrigger
                .startWith(Irrelevant.INSTANCE)
                .flatMap(__ -> fetchSelectedExerciseId.fetchId())
                .materialize()
                .share();

        this.id = materializedExerciseId
                .filter(Notification::isOnNext)
                .map(Notification::getValue);

        this.exerciseSet = materializedExerciseId
                .filter(Notification::isOnNext)
                .map(Notification::getValue)
                .flatMap(id -> fetchExerciseSet.fetchExerciseSet(id));

        this.exerciseSet = fetchSelectedExerciseId
                .fetchId()
                .flatMap(id -> fetchExerciseSet.fetchExerciseSet(id));

        this.exerciseSet = id.flatMap(id -> fetchExerciseSet.fetchExerciseSet(id));

        this.fetchExerciseSet = fetchExerciseSet;
        this.fetchSelectedExerciseId = fetchSelectedExerciseId;

    }

    public Observable<ExerciseSet> getExerciseSet() {
        return null;
    }

    private enum Irrelevant {INSTANCE}

}
