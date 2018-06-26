package com.piotrklis.drumpractice.di;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.piotrklis.drumpractice.DrumPracticeApp;
import com.piotrklis.drumpractice.R;

import javax.inject.Singleton;

import dagger.Provides;

class DrumPracticeAppModule {

    private final DrumPracticeApp application;
    private final String EXERCISES_SETS_JSON_RESOURCE = R.raw.;

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

        InputStreamProvider airportsInputStreamProvider = new RawAssetInputStreamProvider(
                context, AIRPORTS_JSON_RESOURCES);

        return new BundledDataLoader(airportsInputStreamProvider, loungesInputStreamProvider);
    }

}
