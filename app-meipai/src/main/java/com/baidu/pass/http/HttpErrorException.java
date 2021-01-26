package com.baidu.pass.http;

public class HttpErrorException extends Exception {
    public int statusCode;

    public HttpErrorException() {
    }

    public HttpErrorException(int i2, String str) {
        super(str);
        this.statusCode = i2;
    }
}
