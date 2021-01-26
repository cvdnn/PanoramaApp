package com.baidubce.services.bos;

import g.z;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

public class BosObjectInputStream extends FilterInputStream {
    public z httpResponse;

    public BosObjectInputStream(InputStream inputStream, z zVar) {
        super(inputStream);
        this.httpResponse = zVar;
    }

    public void close() throws IOException {
        try {
            super.close();
        } catch (SocketException unused) {
        }
    }
}
