package com.baidubce.internal;

import com.baidubce.BceClientException;
import com.baidubce.util.CheckUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RestartableFileInputStream extends RestartableInputStream {
    public File file;
    public FileInputStream input;

    public RestartableFileInputStream(File file2) throws FileNotFoundException {
        CheckUtils.isNotNull(file2, "file should not be null.");
        this.file = file2;
        this.input = new FileInputStream(file2);
    }

    public void close() throws IOException {
        this.input.close();
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return this.input.read(bArr, i2, i3);
    }

    public void restart() {
        try {
            this.input.close();
            this.input = new FileInputStream(this.file);
        } catch (IOException e2) {
            throw new BceClientException("Fail to restart.", e2);
        }
    }

    public int read() throws IOException {
        return this.input.read();
    }
}
