package com.drumpractice.app.activity;

import android.support.annotation.NonNull;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.JsonDataLoader;

import java.io.IOException;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import io.reactivex.Single;

public class SplashViewModel {

    private final Single<Boolean> shouldShowSplash;
    private final JsonDataLoader jsonDataLoader;

    @Inject
    SplashViewModel(@NonNull final ExerciseSetRepository exerciseSetRepository,
                    @Nonnull final JsonDataLoader jsonDataLoader) {
        this.shouldShowSplash = exerciseSetRepository.isDatabaseEmpty();
        this.jsonDataLoader = jsonDataLoader;
    }

    Single<Boolean> shouldLoadJsonData() {
        return shouldShowSplash;
    }

    Single<Boolean> loadJsonDataToDB() throws IOException {
        return jsonDataLoader.saveBundledExerciseSets();
    }
}
