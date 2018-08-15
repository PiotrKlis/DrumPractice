package com.drumpractice.external;

import com.drumpractice.domain.utils.JsonDataLoader;
import com.drumpractice.external.helpers.BundledDataLoader;
import com.drumpractice.external.repository.ExerciseSetRepositoryImpl;
import com.drumpractice.external.storage.JsonDataStorage;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Observable;


public class JsonDataLoaderImpl implements JsonDataLoader {
    private final JsonDataStorage jsonDataStorage;
    private final ExerciseSetRepositoryImpl exerciseSetRepository;
    private final BundledDataLoader bundledDataLoader;

    @Inject
    public JsonDataLoaderImpl(JsonDataStorage jsonDataStorage, ExerciseSetRepositoryImpl exerciseSetRepository, BundledDataLoader bundledDataLoader) {
        this.jsonDataStorage = jsonDataStorage;
        this.exerciseSetRepository = exerciseSetRepository;
        this.bundledDataLoader = bundledDataLoader;
    }

    @Override
    public Observable loadData() {
        return exerciseSetRepository.isDatabaseEmpty()
                .map(isDatabaseEmpty -> {
                    if (isDatabaseEmpty) {
                        return bundledDataLoader.loadExerciseSetsFromBundle();
                    } else {
                        return Maybe.just(false);
                    }
                });
    }
}
