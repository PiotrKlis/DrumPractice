package com.mobileapps.pk.external.data;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobileapps.pk.domain.model.ExerciseSet;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.Single;

public class JsonDataLoader {

    private static final String FOLDER_NAME = "exercises";
    private static final String STORED_FAQ_NAME = "exercises_sets.json";
    private final StringFileReader fileReader;
    private final Gson gson;
    private final Context context;

    public JsonDataLoader(StringFileReader fileReader, Gson gson, Context context) {
        this.fileReader = fileReader;
        this.gson = gson;
        this.context = context;
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
        File folder = getRootFaqFolder();
        return new File(folder, STORED_FAQ_NAME);
    }

    private File getRootFaqFolder() {
        return context.getDir(FOLDER_NAME, Context.MODE_PRIVATE);
    }

}
