package com.drumpractice.app.exercise;

import com.drumpractice.app.exercise_list.ExerciseSet;
import com.drumpractice.domain.usecase.FetchExercise;
import com.drumpractice.domain.usecase.FetchSelectedExerciseId;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.subjects.PublishSubject;

public class ExerciseViewModel {

    @Inject
    private final FetchExercise fetchExercise;
    @Inject
    private final FetchSelectedExerciseId fetchSelectedExerciseId;
    private final Single<Integer> exerciseSetId;
    private Single<List<ExerciseSet>> exercises;
    private Single<Throwable> errors;

    @Inject
    public ExerciseViewModel(@NonNull final FetchExercise fetchExercise,
                             @NonNull final FetchSelectedExerciseId fetchSelectedExerciseId) {
        PublishSubject<Irrelevant> exerciseSelectedTrigger = PublishSubject.create();
        Single<Notification<Integer>> materializedExerciseId = exerciseSelectedTrigger
                .startWith(Irrelevant.INSTANCE)
                .flatMap(__ -> fetchSelectedExerciseId.execute())
                .materialize()
                .share();

        this.exerciseSetId = materializedExerciseId
                .filter(Notification::isOnNext)
                .map(Notification::getValue);
        

        PublishSubject<Irrelevant> exerciseTrigger = PublishSubject.create();
        Single<Notification<List<ExerciseSet>>> materializedExercises = exerciseTrigger
                .startWith(Irrelevant.INSTANCE)
                .flatMap(__ -> fetchExercise.execute())
                .materialize()
                .share();

        this.fetchExercise = fetchExercise;
        this.fetchSelectedExerciseId = fetchSelectedExerciseId;

    }

    public Single<ExerciseSet> getExerciseSet() {
        return null;
    }

    private enum Irrelevant {INSTANCE}

}
