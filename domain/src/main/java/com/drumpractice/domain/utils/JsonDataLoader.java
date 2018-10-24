package com.drumpractice.domain.utils;

import javax.inject.Inject;

import io.reactivex.Maybe;

public interface JsonDataLoader {
    Maybe loadBundledData();
}
