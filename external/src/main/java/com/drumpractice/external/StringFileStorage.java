package com.drumpractice.external;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.inject.Inject;

public class StringFileStorage implements StringFileReader {

    @Inject
    public StringFileStorage() {
    }

    @Override
    public String readAsStringFromFile(File file) throws IOException {
        if (!file.exists()) {
            return "";
        }
        final String result;
        try (InputStream inputStream = new FileInputStream(file)) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String receiveString;
            StringBuilder stringBuilder = new StringBuilder();

            while ((receiveString = bufferedReader.readLine()) != null) {
                stringBuilder.append(receiveString);
            }
            result = stringBuilder.toString();
        }
        return result;
    }
}
