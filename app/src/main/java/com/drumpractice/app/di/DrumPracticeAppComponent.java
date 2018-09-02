package com.drumpractice.app.di;

import android.content.Context;

import com.drumpractice.external.helpers.BundledDataLoader;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DrumPracticeAppModule.class})
public interface DrumPracticeAppComponent {
    Context getContext();

    Gson getGson();

    BundledDataLoader getBundledDataLoader();
}
