package com.drumpractice.external;

import com.drumpractice.domain.JsonDataLoader;
import com.drumpractice.domain.JsonRepository;
import com.drumpractice.external.dto.ExerciseSetDto;
import com.drumpractice.external.repository.ExerciseSetLocalDataSource;

import java.io.IOException;
import java.util.List;

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
        return exerciseSetLocalDataSource.isDatabaseEmpty()
                .flatMap(isEmpty -> {
                    if (isEmpty) {
                        return saveDataToDB();
                    } else {
                        return Observable.just(false);
                    }
                });
    }

    private Observable<Boolean> saveDataToDB() throws IOException {
        Observable<List<ExerciseSetDto>> exerciseSetDtos = jsonDataLoader.loadBundledExerciseSets().toObservable();
        if (exerciseSetDtos != null && !exerciseSetDtos.isEmpty()) {
            return Observable.defer(() -> {
                return .insert(data);
            });
        } else {
            return Observable.empty();
        }
    }
}
