package com.piotrklis.drumpractice;

import android.app.Application;

import com.piotrklis.drumpractice.di.DaggerDrumPracticeAppComponent;
import com.piotrklis.drumpractice.di.DrumPracticeAppComponent;
import com.piotrklis.drumpractice.di.DrumPracticeAppModule;

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
        initializeRxErrorHandling();
        //applicationComponent.getActivityLifecycleMonitor().start();
        //initializeRealm();
    }

//    private void initializeRealm() {
//        RealmConnectionFactory.initializeRealm(this);
//    }

    private void initializeRxErrorHandling() {
       // RxJavaPlugins.setErrorHandler(new RxErrorHandler());
    }

}
