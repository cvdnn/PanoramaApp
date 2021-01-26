package com.deepai.paipai.support.bean;

import java.io.Serializable;
import java.util.List;

public class MyworksBean implements Serializable {
    private String code;
    private List<IndexPhotoBean> data;
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

    public List<IndexPhotoBean> getData() {
        return this.data;
    }

    public void setData(List<IndexPhotoBean> data2) {
        this.data = data2;
    }
}
