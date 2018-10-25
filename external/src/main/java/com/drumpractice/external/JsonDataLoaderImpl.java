package com.drumpractice.external;

import com.drumpractice.domain.JsonDataLoader;
import com.drumpractice.external.dto.ExerciseSetDto;
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
        List<ExerciseSetEntity> entity = mapDtosToEntities(List < ExerciseSetDto > exerciseSetDtos);
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
    }

    private ExerciseSetEntity mapToExternal(ExerciseSetDto dto) {
        ExerciseSetEntity entity = new ExerciseSetEntity();
    }
}
