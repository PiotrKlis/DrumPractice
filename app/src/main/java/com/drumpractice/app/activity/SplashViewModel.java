package com.drumpractice.app.activity;

import android.support.annotation.NonNull;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.JsonDataLoader;

import java.io.IOException;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.processors.PublishProcessor;

public class SplashViewModel {

    private final Single<Boolean> shouldShowSplash;
    private final JsonDataLoader jsonDataLoader;
    private PublishProcessor finishScreen = PublishProcessor.create();

    @Inject
    SplashViewModel(@NonNull final ExerciseSetRepository exerciseSetRepository,
                    @Nonnull final JsonDataLoader jsonDataLoader) {
        this.shouldShowSplash = exerciseSetRepository.isDatabaseEmpty();
        this.jsonDataLoader = jsonDataLoader;
    }

    Single<Boolean> shouldLoadJsonData() {
        return shouldShowSplash;
    }

    void loadJsonDataToDB() throws IOException {
        jsonDataLoader.saveBundledExerciseSets()
                .subscribe(isFinished -> finishScreen.onNext(true));
    }

    public Observable<Boolean> finishScreen() {
        return finishScreen.toObservable();
    }
}
