package com.drumpractice.external.repository;

import com.drumpractice.domain.model.ExerciseSet;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class ExerciseSetRepositoryImpl implements ExerciseSetRepository {


    @Override
    public Observable<Boolean> isDatabaseEmpty() {
//        return mAirportLocalDataSource.findFirst()
//                .map(airportEntity -> false)
//                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Boolean>>() {
//                    @Override
//                    public ObservableSource<? extends Boolean> apply(Throwable throwable) throws Exception {
//                        return Observable.just(true);
//                    }
//                });
        return null;
    }

    @Override
    public Single<List<ExerciseSet>> getExerciseSets() {
        return null;
    }

    @Override
    public Single<List<ExerciseSet>> saveExerciseSets() {
        return null;
    }
}
