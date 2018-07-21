package com.drumpractice.external;

import com.drumpractice.domain.utils.JsonDataLoader;
import com.drumpractice.external.repository.ExerciseSetRepositoryImpl;

import io.reactivex.Observable;


public class JsonDataLoaderImpl implements JsonDataLoader {

    private final JsonDataStorage jsonDataStorage;
    private final ExerciseSetRepositoryImpl exerciseSetRepository;

    public JsonDataLoaderImpl(JsonDataStorage jsonDataStorage1, ExerciseSetRepositoryImpl exerciseSetRepository) {
        this.jsonDataStorage = jsonDataStorage1;
        this.exerciseSetRepository = exerciseSetRepository;
    }

    @Override
    public Observable loadData() {
        return exerciseSetRepository.isDatabaseEmpty()
                .flatMap(isDatabaseEmpty -> {
                    if (isDatabaseEmpty) {
                        //return persistLatest(mBundleDataLoader);
                        return Observable.just(true);
                    } else {
                        return Observable.just(true);
                    }
                });
    }
}
