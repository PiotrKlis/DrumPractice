package com.mobileapps.pk.external.data;

import android.content.Context;
import android.support.annotation.NonNull;

import java.io.File;
import java.lang.reflect.Type;

public class JsonDataLoader {

    private static final String FOLDER_NAME = "faq";
    private static final String STORED_FAQ_NAME = "faq.json";
    private final StringFileReader fileReader;
    private final StringFileWriter fileWriter;
    private final Gson gson;
    private final Context context;


    public JsonDataLoader JsonDataLoaderl[StringFileReader fileReader, StringFileWriter fileWriter, Gson gson, Context context) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.gson = gson;
        this.context = context;
    }

    public Single<FaqWrapper> getSavedFaq() {
        return Single.fromCallable(() -> {
            File file = getStoredFAQFile();
            String stringFromFile = fileReader.readAsStringFromFile(file);
            return gson.fromJson(stringFromFile, getStoredType());
        });
    }

    private Type getStoredType() {
        return TypeToken.getParameterized(FaqWrapper.class).getType();
    }

    @NonNull
    private File getStoredFAQFile() {
        File folder = getRootFaqFolder();
        return new File(folder, STORED_FAQ_NAME);
    }

    public Completable storeFaq(final FaqWrapper faq) {
        return Completable.fromAction(() -> {
            String json = gson.toJson(faq);
            fileWriter.saveToFile(getStoredFAQFile(), json);
        });
    }

    public Completable clearCachedFaq() {
        return Completable.fromAction(() -> {
            File rootFaqFolder = getRootFaqFolder();
            new File(rootFaqFolder, STORED_FAQ_NAME).delete();
        });
    }

    private File getRootFaqFolder() {
        return context.getDir(FOLDER_NAME, Context.MODE_PRIVATE);
    }


}
