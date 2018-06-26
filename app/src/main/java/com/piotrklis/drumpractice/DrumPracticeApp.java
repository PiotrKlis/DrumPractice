package com.piotrklis.drumpractice;

import android.app.Application;

import io.reactivex.plugins.RxJavaPlugins;

public class DrumPracticeApp extends Application {


    private static DrumPracticeApp context;
    private static PriorityPassAppComponent applicationComponent;

    public static PriorityPassAppComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static DrumPracticeApp getContext() {
        return context;
    }

    private void initializeInjector() {
        applicationComponent = DaggerPriorityPassAppComponent.builder()
                .priorityPassAppModule(new PriorityPassAppModule(this))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initializeInjector();
        initializeRxErrorHandling();
        applicationComponent.getActivityLifecycleMonitor().start();
        //initializeRealm();
    }

//    private void initializeRealm() {
//        RealmConnectionFactory.initializeRealm(this);
//    }

    private void initializeRxErrorHandling() {
        RxJavaPlugins.setErrorHandler(new RxErrorHandler());
    }

}
