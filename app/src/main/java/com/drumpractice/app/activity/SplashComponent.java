package com.drumpractice.app.activity;

import android.content.Context;

import com.drumpractice.app.DrumPracticeApp;
import com.drumpractice.domain.ExerciseSetRepository;
import com.drumpractice.domain.utils.JsonDataLoader;
import com.drumpractice.external.JsonDataLoaderImpl;
import com.drumpractice.external.StringFileReader;
import com.drumpractice.external.helpers.BundledDataLoader;
import com.drumpractice.external.helpers.DtoDataLoader;
import com.drumpractice.external.helpers.InputStreamProvider;
import com.drumpractice.external.helpers.RawAssetInputStreamProvider;
import com.drumpractice.external.repository.ExerciseSetLocalDataSource;
import com.drumpractice.external.repository.ExerciseSetRepositoryImpl;
import com.drumpractice.external.storage.JsonDataStorage;
import com.drumpractice.external.storage.StringFileStorage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.piotrklis.drumpractice.R;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Component(modules = {SplashComponent.SplashModule.class})
public interface SplashComponent {

    SplashViewModel splashViewModel();

    @Module
    class SplashModule {

        private final int EXERCISES_SETS_JSON_RESOURCE = R.raw.exercises_sets;

        private final DrumPracticeApp application;

        public SplashModule(DrumPracticeApp application) {
            this.application = application;
        }

        @Provides
        Context provideApplicationContext() {
            return this.application;
        }

        @Provides
        JsonDataLoader provideJsonDataLoader(JsonDataStorage jsonDataStorage, ExerciseSetRepository exerciseSetRepository, DtoDataLoader dtoDataLoader) {
            return new JsonDataLoaderImpl(jsonDataStorage, exerciseSetRepository, dtoDataLoader);
        }

        @Provides
        ExerciseSetRepository provideExerciseSetRepository(ExerciseSetLocalDataSource exerciseSetLocalDataSource) {
            return new ExerciseSetRepositoryImpl(exerciseSetLocalDataSource);
        }

        @Provides
        JsonDataStorage provideJsonDataStorage(StringFileReader stringFileReader, Gson gson) {
            return new JsonDataStorage(stringFileReader, gson);
        }

        @Provides
        StringFileReader provideStringFileReader() {
            return new StringFileStorage();
        }

        @Provides
        Gson provideGson() {
            return new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        }

        @Provides
        DtoDataLoader provideDtoDataLoader(InputStreamProvider inputStreamProvider) {
            return new BundledDataLoader(inputStreamProvider);
        }

        @Provides
        InputStreamProvider provideInputStreamProvider(Context context) {
            return new RawAssetInputStreamProvider(EXERCISES_SETS_JSON_RESOURCE, context);
        }

    }
}
