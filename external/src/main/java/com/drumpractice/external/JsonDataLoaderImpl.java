package com.drumpractice.external;

import com.drumpractice.domain.model.ExerciseSet;
import com.drumpractice.domain.utils.JsonDataLoader;
import com.drumpractice.external.dto.ExerciseSetDto;
import com.drumpractice.external.helpers.BundledDataLoader;
import com.drumpractice.external.repository.ExerciseSetRepositoryImpl;
import com.drumpractice.external.storage.JsonDataStorage;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;


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
    public Maybe loadBundledData() {
        return bundledDataLoader.loadExerciseSetsFromBundle()
                .map(this::mapToDomain);
    }

    private List<ExerciseSet> mapToDomain(List<ExerciseSetDto> exerciseSetDtos) {
        List<ExerciseSet> setList = new ArrayList<>();

        for (ExerciseSetDto dto : exerciseSetDtos) {
            ExerciseSet exerciseSet = new ExerciseSet();
            exerciseSet.setId(dto.getId());
            exerciseSet.setExercise(dto.getExercises());
            exerciseSet.setName(dto.getExerciseSetName());
            exerciseSet.setTempo(dto.getTempo());
            setList.add(exerciseSet);
        }
        return setList;
    }
}
