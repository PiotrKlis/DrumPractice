package com.drumpractice.external.repository;

import com.drumpractice.external.entities.ExerciseSetEntity;

import io.reactivex.Observable;
import io.realm.Realm;

public class ExerciseSetLocalDataSource {
    public Observable<ExerciseSetEntity> findFirst() {
        return Observable.fromCallable(() -> {
            try (Realm realm = getRealmConnection()) {
                return realm.copyFromRealm(realm.where(ExerciseSetEntity.class).findFirst());
            } catch (Throwable ex) {
                throw ex;
            }
        });
    }

    private Realm getRealmConnection() {
        return Realm.getDefaultInstance();
    }
}

