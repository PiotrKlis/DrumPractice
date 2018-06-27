package com.mobileapps.pk.external.data.helpers;

import java.io.IOException;
import java.io.InputStream;

public interface InputStreamProvider {
    InputStream openInputStream() throws IOException;
}
