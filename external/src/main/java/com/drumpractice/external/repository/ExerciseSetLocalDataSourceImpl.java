package com.drumpractice.external.repository;

import com.drumpractice.external.entities.ExerciseSetEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.realm.Realm;

public class ExerciseSetLocalDataSourceImpl implements ExerciseSetLocalDataSource {
    public Observable<ExerciseSetEntity> findFirst() {
        return Observable.fromCallable(() -> {
            try (Realm realm = getRealmConnection()) {
                return realm.copyFromRealm(realm.where(ExerciseSetEntity.class).findFirst());
            } catch (Throwable ex) {
                throw ex;
            }
        });
    }

    @Override
    public Observable<List<ExerciseSetEntity>> getAllExerciseSets() {
        return Observable.fromCallable(() -> {
            try (Realm realm = getRealmConnection()) {
                return realm.copyFromRealm(realm.where(ExerciseSetEntity.class).findAll());
            } catch (Throwable ex) {
                throw ex;
            }
        });
    }

    private Realm getRealmConnection() {
        return Realm.getDefaultInstance();
    }

    @Override
    public Single<Boolean> isEmpty() {
        return Single.fromCallable(() -> {
            try (Realm realm = getRealmConnection()) {
                return realm.isEmpty();
            } catch (Throwable ex) {
                throw ex;
            }
        });
    }

    @Override
    public void clear(Class<ExerciseSetEntity> entity) {
        try (Realm r = getRealmConnection()) {
            if (r.isInTransaction()) {
                r.delete(entity);
            } else {
                r.executeTransaction(realm -> {
                    realm.delete(entity);
                });
            }
        } catch (Throwable ex) {
            throw ex;
        }
    }

    @Override
    public Boolean insert(List<ExerciseSetEntity> entity) {
        try (Realm r = getRealmConnection()) {
            if (r.isInTransaction()) {
                r.insert(entity);
            } else {
                r.insert(entity);
            }
            return true;
        } catch (Throwable ex) {
            throw ex;
        }
    }
}

