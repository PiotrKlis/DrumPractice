package com.drumpractice.external;

import com.drumpractice.domain.JsonDataLoader;
import com.drumpractice.domain.JsonRepository;
import com.drumpractice.external.repository.ExerciseSetLocalDataSource;

import io.reactivex.Observable;

public class JsonRepositoryImplementation implements JsonRepository {

    private final ExerciseSetLocalDataSource exerciseSetLocalDataSource;
    private final JsonDataLoader jsonDataLoader;

    public JsonRepositoryImplementation(ExerciseSetLocalDataSource exerciseSetLocalDataSource, JsonDataLoader jsonDataLoader) {
        this.exerciseSetLocalDataSource = exerciseSetLocalDataSource;
        this.jsonDataLoader = jsonDataLoader;
    }


    @Override
    public Observable<Boolean> loadBundleData() {
        return null;
    }
}
