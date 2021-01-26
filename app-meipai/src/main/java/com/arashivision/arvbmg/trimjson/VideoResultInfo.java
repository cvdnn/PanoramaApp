package com.arashivision.arvbmg.trimjson;

import e.a.a.a.a;

public class VideoResultInfo {
    public String jsonStr;
    public String name;
    public int type;

    public void setJsonStr(String str) {
        this.jsonStr = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public String toString() {
        StringBuilder a2 = a.a("VideoResultInfo{jsonStr='");
        a2.append(this.jsonStr.length());
        a2.append('\'');
        a2.append(", type=");
        a2.append(this.type);
        a2.append(", name='");
        a2.append(this.name);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }
}
