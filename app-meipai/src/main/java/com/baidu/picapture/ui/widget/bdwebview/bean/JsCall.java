package com.baidu.picapture.ui.widget.bdwebview.bean;

import androidx.annotation.Keep;

@Keep
public class JsCall {
    public Integer callbackId;
    public String data;
    public String name;

    public JsCall(String str, String str2, Integer num) {
        this.name = str;
        this.data = str2;
        this.callbackId = num;
    }
}
