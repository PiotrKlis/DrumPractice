package com.drumpractice.external.repository;

import android.support.annotation.NonNull;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.model.Exercise;
import com.drumpractice.domain.model.ExerciseSet;
import com.drumpractice.external.entities.ExerciseEntity;
import com.drumpractice.external.entities.ExerciseSetEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.realm.RealmList;

public class ExerciseSetRepositoryImpl implements ExerciseSetRepository {

    private final ExerciseSetLocalDataSource exerciseSetLocalDataSource;

    @Inject
    public ExerciseSetRepositoryImpl(ExerciseSetLocalDataSource exerciseSetLocalDataSource) {
        this.exerciseSetLocalDataSource = exerciseSetLocalDataSource;
    }

    @Override
    public Single<Boolean> isDatabaseEmpty() {
        return exerciseSetLocalDataSource.isEmpty()
                .map(isEmpty -> isEmpty);
    }

    @Override
    public Observable<List<ExerciseSet>> getExerciseSets() {
        return exerciseSetLocalDataSource.getAllExerciseSets().map(this::mapToDomain);
    }

    private List<ExerciseSet> mapToDomain(List<ExerciseSetEntity> exerciseSetEntities) {
        List<ExerciseSet> domainListOfExerciseSets = new ArrayList<>();
        for (ExerciseSetEntity entities : exerciseSetEntities) {
            ExerciseSet domainExerciseSet = new ExerciseSet();
            domainExerciseSet.setId(entities.getId());
            domainExerciseSet.setName(entities.getName());
            domainExerciseSet.setTempo(entities.getTempo());
            domainExerciseSet.setExercise(getExercises(entities));

            domainListOfExerciseSets.add(domainExerciseSet);
        }
        return domainListOfExerciseSets;
    }

    @NonNull
    private List<Exercise> getExercises(ExerciseSetEntity entities) {
        RealmList<ExerciseEntity> listOfExerciseEnttities = entities.getExercises();
        List<Exercise> domainListOfExercises = new ArrayList<>();

        for (ExerciseEntity entity : listOfExerciseEnttities) {
            Exercise exercise = new Exercise();
            exercise.setTime(entity.getTime());
            exercise.setName(entity.getName());
            exercise.setId(entity.getId());
            exercise.setId(entity.getId());
            domainListOfExercises.add(exercise);
        }
        return domainListOfExercises;
    }

    @Override
    public Observable<ExerciseSet> getCurrentExerciseSet() {

        return null;
    }

    @Override
    public Observable<Integer> getSelectedExerciseId() {
        return null;
    }

    @Override
    public Observable<Integer> setSelectedExerciseId() {
        return null;
    }

    @Override
    public void clear() {
        exerciseSetLocalDataSource.clear(ExerciseSetEntity.class);
    }
}
