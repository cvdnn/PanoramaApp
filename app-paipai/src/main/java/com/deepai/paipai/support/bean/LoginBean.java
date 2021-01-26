package com.deepai.paipai.support.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {
    private String code;
    private DataBean data;
    private String msg;

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg2) {
        this.msg = msg2;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code2) {
        this.code = code2;
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean data2) {
        this.data = data2;
    }
}
