package com.mobileapps.pk.external.data.helpers;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.RawRes;

import java.io.IOException;
import java.io.InputStream;

public class RawAssetInputStreamProvider implements InputStreamProvider {

    @RawRes
    private final int rawResID;
    private final Context context;

    public RawAssetInputStreamProvider(int rawResID, Context context) {
        this.rawResID = rawResID;
        this.context = context;
    }

    @Override
    public InputStream openInputStream() throws IOException {
        return getResources().openRawResource(rawResID);
    }

    private Resources getResources() {
        Configuration conf = context.getResources().getConfiguration();
        Context localizedContext = context.createConfigurationContext(conf);
        return localizedContext.getResources();
    }
}
