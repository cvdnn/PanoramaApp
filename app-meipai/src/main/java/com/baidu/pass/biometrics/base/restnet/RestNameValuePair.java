package com.baidu.pass.biometrics.base.restnet;

import e.a.a.a.a;
import java.io.Serializable;

public class RestNameValuePair implements Serializable {
    public static final long serialVersionUID = 847806714499261896L;
    public String name;
    public String value;

    public RestNameValuePair() {
        this(null, null);
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder a2 = a.a("name = ");
        a2.append(this.name);
        a2.append(", value = ");
        a2.append(this.value);
        return a2.toString();
    }

    public RestNameValuePair(String str, String str2) {
        this.name = str;
        this.value = str2;
    }
}
