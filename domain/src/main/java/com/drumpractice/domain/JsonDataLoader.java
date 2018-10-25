package com.drumpractice.domain;

import java.io.IOException;

import io.reactivex.Single;

public interface JsonDataLoader {
    Single<Boolean> saveBundledExerciseSets() throws IOException;
}
