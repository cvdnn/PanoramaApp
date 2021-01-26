package com.arashivision.camera.options;

import com.baidu.mobstat.Config;
import com.sina.weibo.sdk.constant.WBConstants;

public enum CaptureResolution {
    CAPTURE_1504P_100FPS(r0.mWidth, r0.mHeight, r0.mFps, r0.mBitrate),
    CAPTURE_1920P(r1.mWidth, r1.mHeight, r1.mFps, r1.mBitrate),
    CAPTURE_1920P_50FPS(r1.mWidth, r1.mHeight, r1.mFps, r1.mBitrate),
    CAPTURE_1920P_60FPS(r1.mWidth, r1.mHeight, r1.mFps, r1.mBitrate),
    CAPTURE_2880P(r1.mWidth, r1.mHeight, r1.mFps, r1.mBitrate),
    CAPTURE_720P(1440, 720, 30, 40),
    CAPTURE_960P(WBConstants.SDK_NEW_PAY_VERSION, 960, 30, 40),
    CAPTURE_1088P(2176, 1088, 30, 40),
    CAPTURE_1280P(2560, 1280, 30, 40),
    CAPTURE_1520P(3040, 1520, 30, 40);
    
    public int mBitrate;
    public int mFps;
    public int mHeight;
    public int mWidth;

    /* access modifiers changed from: public */
    CaptureResolution(int i2, int i3, int i4, int i5) {
        this.mWidth = i2;
        this.mHeight = i3;
        this.mFps = i4;
        this.mBitrate = i5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mWidth);
        sb.append(Config.EVENT_HEAT_X);
        sb.append(this.mHeight);
        return sb.toString();
    }
}
