package com.mobileapps.pk.external.data;

import java.io.File;
import java.io.IOException;

public interface StringFileReader {
    String readAsStringFromFile(File file) throws IOException;

}
