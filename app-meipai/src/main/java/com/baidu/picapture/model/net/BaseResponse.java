package com.baidu.picapture.model.net;

public class BaseResponse<T> {
    public T data;
    public int error_code;
    public String error_msg;
    public int http_code;

    public T getData() {
        return this.data;
    }

    public int getError_code() {
        return this.error_code;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public int getHttp_code() {
        return this.http_code;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setError_code(int i2) {
        this.error_code = i2;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }

    public void setHttp_code(int i2) {
        this.http_code = i2;
    }
}
