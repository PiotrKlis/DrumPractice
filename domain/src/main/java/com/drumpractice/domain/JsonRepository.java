package com.drumpractice.domain;

import io.reactivex.Observable;

public interface JsonRepository {

    Observable<Boolean> loadBundleData();

}
