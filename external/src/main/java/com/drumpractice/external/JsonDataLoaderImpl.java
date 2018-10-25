package com.drumpractice.external;

import android.support.annotation.NonNull;

import com.drumpractice.domain.JsonDataLoader;
import com.drumpractice.external.dto.ExerciseDto;
import com.drumpractice.external.dto.ExerciseSetDto;
import com.drumpractice.external.entities.ExerciseEntity;
import com.drumpractice.external.entities.ExerciseSetEntity;
import com.drumpractice.external.helpers.InputStreamProvider;
import com.drumpractice.external.repository.ExerciseSetLocalDataSource;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import io.realm.RealmList;


public class JsonDataLoaderImpl implements JsonDataLoader {

    private static final String CHARSET_NAME = "UTF-8";
    private final InputStreamProvider exercisesSetsInputStreamProvider;
    private final ExerciseSetLocalDataSource exerciseSetLocalDataSource;

    @Inject
    public JsonDataLoaderImpl(@Nonnull final InputStreamProvider exercisesSetsInputStreamProvider, ExerciseSetLocalDataSource exerciseSetLocalDataSource) {
        this.exercisesSetsInputStreamProvider = exercisesSetsInputStreamProvider;
        this.exerciseSetLocalDataSource = exerciseSetLocalDataSource;
    }

    @Override
    public void loadBundledExerciseSets() throws IOException {
        InputStream inputStream = exercisesSetsInputStreamProvider.openInputStream();
        List<ExerciseSetDto> exerciseSetDtos = readListFromStream(ExerciseSetDto.class, inputStream);
        List<ExerciseSetEntity> entity = mapDtosToEntities(exerciseSetDtos);
        exerciseSetLocalDataSource.insert(entity);

        inputStream.close();
    }

    private <T> List<T> readListFromStream(Type type, InputStream inputStream) throws UnsupportedEncodingException {
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, CHARSET_NAME));
        return new GsonBuilder()
                .create()
                .fromJson(reader, TypeToken.getParameterized(ArrayList.class, type).getType());
    }

    List<ExerciseSetEntity> mapDtosToEntities(List<ExerciseSetDto> dtos) {
        List<ExerciseSetEntity> entities = new ArrayList<>();
        for (ExerciseSetDto dto : dtos) {
            entities.add(mapToExternal(dto));
        }
        return entities;
    }

    private ExerciseSetEntity mapToExternal(ExerciseSetDto dto) {
        ExerciseSetEntity setEntities = new ExerciseSetEntity();
        setEntities.setName(dto.getName());
        setEntities.setTempo(dto.getTempo());

        RealmList<ExerciseEntity> exerciseEntities = getExerciseEntities(dto);
        setEntities.setExercises(exerciseEntities);

        return setEntities;
    }

    @NonNull
    private RealmList<ExerciseEntity> getExerciseEntities(ExerciseSetDto dto) {
        List<ExerciseDto> exerciseDtos = dto.getExercises();
        RealmList<ExerciseEntity> exerciseEntities = new RealmList<>();

        for (ExerciseDto exerciseDto : exerciseDtos) {
            ExerciseEntity exercise = new ExerciseEntity();
            exercise.setImage(exerciseDto.getImage());
            exercise.setName(exerciseDto.getName());
            exercise.setTime(exerciseDto.getTime());
            exerciseEntities.add(exercise);
        }
        return exerciseEntities;
    }
}
