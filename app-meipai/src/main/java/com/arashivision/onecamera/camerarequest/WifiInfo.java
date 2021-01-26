package com.arashivision.onecamera.camerarequest;

import e.a.a.a.a;

public class WifiInfo {
    public int channel;
    public int mode;
    public String pwd;
    public String ssid;

    public int getChannel() {
        return this.channel;
    }

    public int getMode() {
        return this.mode;
    }

    public String getPwd() {
        return this.pwd;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setChannel(int i2) {
        this.channel = i2;
    }

    public void setMode(int i2) {
        this.mode = i2;
    }

    public void setPwd(String str) {
        this.pwd = str;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public String toString() {
        StringBuilder a2 = a.a("WifiInfo{ssid=");
        a2.append(this.ssid);
        a2.append(", pwd=");
        a2.append(this.pwd);
        a2.append(", channel=");
        a2.append(this.channel == 0 ? "2.4G" : "5G");
        a2.append(", mode=");
        int i2 = this.mode;
        String str = i2 == 0 ? "AP" : 1 == i2 ? "sta" : "p2p";
        a2.append(str);
        return a2.toString();
    }
}
