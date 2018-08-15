package com.drumpractice.app;

import android.app.Application;

import com.drumpractice.app.di.DaggerDrumPracticeAppComponent;
import com.drumpractice.app.di.DrumPracticeAppComponent;
import com.drumpractice.app.di.DrumPracticeAppModule;
import com.drumpractice.external.RealmConnectionFactory;

import io.reactivex.plugins.RxJavaPlugins;

public class DrumPracticeApp extends Application {


    private static DrumPracticeApp context;
    private static DrumPracticeAppComponent applicationComponent;

    public static DrumPracticeAppComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static DrumPracticeApp getContext() {
        return context;
    }

    private void initializeInjector() {
        applicationComponent = DaggerDrumPracticeAppComponent.builder()
                .drumPracticeAppModule(new DrumPracticeAppModule(this))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initializeInjector();
        initializeRealm();
    }

    private void initializeRealm() {
        RealmConnectionFactory.initializeRealm(this);
    }
}
