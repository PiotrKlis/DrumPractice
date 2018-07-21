package com.drumpractice.external;

import android.support.annotation.NonNull;

import com.drumpractice.domain.model.ExerciseSet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.Single;

public class JsonDataStorage {

    private static final String STORED_FILE_NAME = "exercises_sets.json";
    private final StringFileReader fileReader;
    private final Gson gson;

    public JsonDataStorage(StringFileReader fileReader, Gson gson) {
        this.fileReader = fileReader;
        this.gson = gson;
    }

    public Single<List<ExerciseSet>> getSavedExerciseSets() {
        return Single.fromCallable(() -> {
            File file = getStoredFAQFile();
            String stringFromFile = fileReader.readAsStringFromFile(file);
            return gson.fromJson(stringFromFile, getStoredType());
        });
    }

    private Type getStoredType() {
        return TypeToken.getParameterized(ExerciseSet.class).getType();
    }

    @NonNull
    private File getStoredFAQFile() {
        return new File(STORED_FILE_NAME);
    }
}
