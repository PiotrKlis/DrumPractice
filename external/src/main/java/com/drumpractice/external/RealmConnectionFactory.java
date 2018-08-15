package com.drumpractice.external;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmConnectionFactory implements DbConnectionFactory<Realm> {
    private static final int DB_SCHEMA_VERSION = 1;

    public static void initializeRealm(Context context) {
        Realm.init(context);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(DB_SCHEMA_VERSION)
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }

    @Override
    public Realm getDatabaseConnection() {
        return Realm.getDefaultInstance();
    }
}
