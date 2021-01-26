package com.arashivision.onecamera.exception;

import java.io.IOException;

public class CameraIOException extends IOException {
    public CameraIOException(String str) {
        super(str);
    }

    public CameraIOException() {
    }

    public CameraIOException(Throwable th) {
        super(th);
    }

    public CameraIOException(String str, Throwable th) {
        super(str, th);
    }
}
