package com.drumpractice.external.helpers;

import com.drumpractice.external.dto.ExerciseSetDto;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Maybe;

public class BundledDataLoader implements DtoDataLoader {

    private static final String CHARSET_NAME = "UTF-8";
    private final InputStreamProvider exercisesSetsInputStreamProvider;

    public BundledDataLoader(InputStreamProvider exercisesSetsInputStreamProvider) {
        this.exercisesSetsInputStreamProvider = exercisesSetsInputStreamProvider;
    }

    @Override
    public Maybe<List<ExerciseSetDto>> loadExerciseSetsFromBundle() {
        return Maybe.fromCallable(() -> {
            InputStream inputStream = exercisesSetsInputStreamProvider.openInputStream();
            List<ExerciseSetDto> exerciseSets = readListFromStream(ExerciseSetDto.class, inputStream);
            inputStream.close();
            return exerciseSets;
        });
    }

    private <T> List<T> readListFromStream(Type type, InputStream inputStream) throws UnsupportedEncodingException {
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, CHARSET_NAME));
        return new GsonBuilder()
                .create()
                .fromJson(reader, TypeToken.getParameterized(ArrayList.class, type).getType());
    }
}
