package com.drumpractice.external;

import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.model.ExerciseSet;
import com.drumpractice.domain.utils.JsonDataLoader;
import com.drumpractice.external.dto.ExerciseSetDto;
import com.drumpractice.external.helpers.BundledDataLoader;
import com.drumpractice.external.helpers.DtoDataLoader;
import com.drumpractice.external.repository.ExerciseSetRepositoryImpl;
import com.drumpractice.external.storage.JsonDataStorage;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;


public class JsonDataLoaderImpl implements JsonDataLoader {
    private final JsonDataStorage jsonDataStorage;
    private final ExerciseSetRepository exerciseSetRepository;
    private final DtoDataLoader dtoDataLoader;

    @Inject
    public JsonDataLoaderImpl(JsonDataStorage jsonDataStorage, ExerciseSetRepository exerciseSetRepository, DtoDataLoader dtoDataLoader) {
        this.jsonDataStorage = jsonDataStorage;
        this.exerciseSetRepository = exerciseSetRepository;
        this.dtoDataLoader = dtoDataLoader;
    }

    @Override
    public Maybe loadBundledData() {
        return dtoDataLoader.loadExerciseSetsFromBundle()
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
