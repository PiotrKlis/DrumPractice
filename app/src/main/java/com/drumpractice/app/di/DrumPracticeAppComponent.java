package com.drumpractice.app.di;

import android.content.Context;
import android.support.annotation.NonNull;

import com.drumpractice.app.DrumPracticeApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Singleton
@Component(modules = {DrumPracticeAppComponent.DrumPracticeAppModule.class})
public interface DrumPracticeAppComponent {
    Context getContext();

    @Module
    public class DrumPracticeAppModule {

        private final DrumPracticeApp application;

        public DrumPracticeAppModule(@NonNull final DrumPracticeApp application) {
            this.application = application;
        }

        @Provides
        Context provideApplicationContext() {
            return this.application;
        }
    }

}
