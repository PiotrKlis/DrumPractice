package com.drumpractice.app.di;

import android.content.Context;
import android.support.annotation.NonNull;

import com.drumpractice.app.DrumPracticeApp;
import com.drumpractice.external.helpers.BundledDataLoader;
import com.drumpractice.external.helpers.InputStreamProvider;
import com.drumpractice.external.helpers.RawAssetInputStreamProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.piotrklis.drumpractice.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DrumPracticeAppModule {

    private final DrumPracticeApp application;
    private final int EXERCISES_SETS_JSON_RESOURCE = R.raw.exercises_sets;

    public DrumPracticeAppModule(@NonNull final DrumPracticeApp application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
    }

    @Provides
    BundledDataLoader provideBundledDataLoader(Context context) {
        InputStreamProvider exerciseSetsInputStreamProvider = new RawAssetInputStreamProvider(EXERCISES_SETS_JSON_RESOURCE, context);
        return new BundledDataLoader(exerciseSetsInputStreamProvider);
    }
}