package com.drumpractice.external.helpers;

import java.io.IOException;
import java.io.InputStream;

public interface InputStreamProvider {
    InputStream openInputStream() throws IOException;
}
