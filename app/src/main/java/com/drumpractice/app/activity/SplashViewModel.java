package com.drumpractice.app.activity;

import android.support.annotation.NonNull;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.utils.JsonDataLoader;

import javax.inject.Inject;

import io.reactivex.Single;

public class SplashViewModel {

    private final Single<Boolean> shouldShowSplash;

    @Inject
    public SplashViewModel(@NonNull final JsonDataLoader jsonDataLoader,
                           @NonNull final ExerciseSetRepository exerciseSetRepository) {
        shouldShowSplash = exerciseSetRepository.isDatabaseEmpty()
                .map(isDatabaseEmpty -> isDatabaseEmpty);
    }

    public Single<Boolean> shouldLoadJsonData() {
        return shouldShowSplash;
    }

    public void loadJsonDataToDB() {
    }
}
