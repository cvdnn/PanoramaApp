package com.arashivision.arvbmg.bulletmotion;

import e.a.a.a.a;

public class BulletMixInfo {
    public float angle = 360.0f;
    public String cachePath;
    public int fps;
    public String url;

    public float getAngle() {
        return this.angle;
    }

    public String getCachePath() {
        return this.cachePath;
    }

    public int getFps() {
        return this.fps;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        StringBuilder a2 = a.a("BulletMixInfo{url='");
        a.a(a2, this.url, '\'', ", fps=");
        a2.append(this.fps);
        a2.append(", angle=");
        a2.append(this.angle);
        a2.append('}');
        return a2.toString();
    }
}
