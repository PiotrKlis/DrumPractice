package com.drumpractice.app.activity;

import com.drumpractice.app.JsonLoaderComponent.JsonLoaderModule;
import com.drumpractice.app.di.DrumPracticeAppComponent.DrumPracticeAppModule;

import dagger.Component;
import dagger.Module;

@Component(modules = {SplashComponent.SplashModule.class, JsonLoaderModule.class, DrumPracticeAppModule.class})
public interface SplashComponent {

    SplashViewModel splashViewModel();

    @Module
    class SplashModule {
    }
}
