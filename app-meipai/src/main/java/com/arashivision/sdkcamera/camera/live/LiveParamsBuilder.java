package com.arashivision.sdkcamera.camera.live;

import e.a.a.a.a;

public class LiveParamsBuilder {

    /* renamed from: 刻槒唱镧詴 reason: contains not printable characters */
    public int f266 = 0;

    /* renamed from: 垡玖 reason: contains not printable characters */
    public boolean f267 = true;

    /* renamed from: 旞莍癡 reason: contains not printable characters */
    public long f268 = -1;

    /* renamed from: 灞酞輀攼嵞漁綬迹 reason: contains not printable characters */
    public int f269 = 0;

    /* renamed from: 肌緭 reason: contains not printable characters */
    public String f270;

    /* renamed from: 葋申湋骶映鍮秄憁鎓羭 reason: contains not printable characters */
    public int f271 = 0;

    /* renamed from: 鞈鵚主瀭孩濣痠閕讠陲檓敐 reason: contains not printable characters */
    public int f272 = 0;

    public int getBitrate() {
        return this.f269;
    }

    public int getFps() {
        return this.f272;
    }

    public int getHeight() {
        return this.f271;
    }

    public long getNetId() {
        return this.f268;
    }

    public String getRtmp() {
        return this.f270;
    }

    public int getWidth() {
        return this.f266;
    }

    public boolean isPanorama() {
        return this.f267;
    }

    public LiveParamsBuilder setBitrate(int i2) {
        this.f269 = i2;
        return this;
    }

    public LiveParamsBuilder setFps(int i2) {
        this.f272 = i2;
        return this;
    }

    public LiveParamsBuilder setHeight(int i2) {
        this.f271 = i2;
        return this;
    }

    public LiveParamsBuilder setNetId(long j2) {
        this.f268 = j2;
        return this;
    }

    public LiveParamsBuilder setPanorama(boolean z) {
        this.f267 = z;
        return this;
    }

    public LiveParamsBuilder setRtmp(String str) {
        this.f270 = str;
        return this;
    }

    public LiveParamsBuilder setWidth(int i2) {
        this.f266 = i2;
        return this;
    }

    public String toString() {
        StringBuilder a2 = a.a("url: ");
        a2.append(this.f270);
        a2.append(", width: ");
        a2.append(this.f266);
        a2.append(", height: ");
        a2.append(this.f271);
        a2.append(", fps: ");
        a2.append(this.f272);
        a2.append(", bitrate: ");
        a2.append(this.f269);
        a2.append(", isPanorama: ");
        a2.append(this.f267);
        a2.append(", netId: ");
        a2.append(this.f268);
        return a2.toString();
    }
}
