package com.baidu.picapture.ui.widget.bdwebview.bean;

import androidx.annotation.Keep;

@Keep
public class Router {
    public String host;
    public String prefix;
    public String version;

    public String getHost() {
        return this.host;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getVersion() {
        return this.version;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
