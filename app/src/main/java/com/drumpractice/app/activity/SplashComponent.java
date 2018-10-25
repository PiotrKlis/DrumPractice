package com.drumpractice.app.activity;

import com.drumpractice.app.JsonLoaderComponent.JsonLoaderModule;
import com.drumpractice.app.di.DrumPracticeAppComponent.DrumPracticeAppModule;
import com.drumpractice.external.repository.ExerciseSetLocalDataSource;
import com.drumpractice.external.repository.ExerciseSetLocalDataSourceImpl;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Component(modules = {SplashComponent.SplashModule.class, JsonLoaderModule.class, DrumPracticeAppModule.class})
public interface SplashComponent {

    SplashViewModel splashViewModel();

    @Module
    class SplashModule {


        @Provides
        ExerciseSetLocalDataSource exerciseSetLocalDataSource() {
            return new ExerciseSetLocalDataSourceImpl();
        }
    }
}
