package com.arashivision.camera.exception;

public class OpenException extends RuntimeException {
    public OpenException(String str) {
        super(str);
    }

    public OpenException() {
    }

    public OpenException(Throwable th) {
        super(th);
    }

    public OpenException(String str, Throwable th) {
        super(str, th);
    }
}
