package com.drumpractice.app.activity;

import android.support.annotation.NonNull;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.utils.JsonDataLoader;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public class SplashViewModel {

    private final Maybe<Boolean> shouldShowSplash;

    @Inject
    public SplashViewModel(@NonNull final JsonDataLoader jsonDataLoader,
                           @NonNull final ExerciseSetRepository exerciseSetRepository) {
        shouldShowSplash = exerciseSetRepository.isDatabaseEmpty()
                .flatMap(isDatabaseEmpty -> {
                    if (isDatabaseEmpty) {
                        jsonDataLoader.loadBundledData();
                        return Observable.just(true);
                    } else {
                        return Observable.just(false);
                    }
                }).singleElement();
    }

    public Maybe<Boolean> loadBundledData() {
        return shouldShowSplash;
    }
}
