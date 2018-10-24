package com.drumpractice.external.repository;

import com.drumpractice.external.entities.ExerciseSetEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.realm.Realm;

public class ExerciseSetLocalDataSource {
    @Inject
    public ExerciseSetLocalDataSource() {

    }

    public Single<ExerciseSetEntity> findFirst() {
        return Single.fromCallable(() -> {
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

