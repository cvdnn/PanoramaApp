package com.arashivision.camera.options;

import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface;
import com.baidu.sapi2.SapiAccountManager;
import com.sina.weibo.sdk.constant.WBConstants;
import com.youth.banner.config.BannerConfig;

public enum CameraStreamResolution {
    CAMERA_STREAM_1504P_100FPS(3008, 1504, 100, 40, true, 13),
    CAMERA_STREAM_1920P(3840, WBConstants.SDK_NEW_PAY_VERSION, 30, 40, true, 0),
    CAMERA_STREAM_1920P_50FPS(3840, WBConstants.SDK_NEW_PAY_VERSION, 50, 40, true, 12),
    CAMERA_STREAM_1920P_60FPS(3840, WBConstants.SDK_NEW_PAY_VERSION, 60, 40, true, 11),
    CAMERA_STREAM_2880P(5760, 2880, 30, 40, true, 10),
    CAMERA_STREAM_360P(720, 360, 30, 40, true, 17),
    CAMERA_STREAM_240P(480, SapiAccountManager.VERSION_CODE, 30, 40, true, 18),
    CAMERA_STREAM_640320_30P(CameraInterface.DEFAULT_PREVIEW_WIDTH, 320, 30, 40, true, 36),
    CAMERA_STREAM_1024512_30P(1024, 512, 30, 40, true, 35),
    CAMERA_STREAM_38402160_60P(3840, 2160, 60, 40, true, 23),
    CAMERA_STREAM_38402160_30P(3840, 2160, 30, 40, true, 24),
    CAMERA_STREAM_27201530_100P(2720, 1530, 100, 40, true, 25),
    CAMERA_STREAM_19201080_200P(WBConstants.SDK_NEW_PAY_VERSION, 1080, 200, 40, true, 26),
    CAMERA_STREAM_19201080_240P(WBConstants.SDK_NEW_PAY_VERSION, 1080, SapiAccountManager.VERSION_CODE, 40, true, 27),
    CAMERA_STREAM_19201080_120P(WBConstants.SDK_NEW_PAY_VERSION, 1080, 120, 40, true, 28),
    CAMERA_STREAM_19201080_30P(WBConstants.SDK_NEW_PAY_VERSION, 1080, 30, 40, true, 28),
    CAMERA_STREAM_54723078_30P(5472, 3078, 30, 40, true, 30),
    CAMERA_STREAM_40003000_30P(4000, BannerConfig.LOOP_TIME, 30, 40, true, 31),
    CAMERA_STREAM_854640_30P(854, CameraInterface.DEFAULT_PREVIEW_WIDTH, 30, 40, true, 32),
    CAMERA_STREAM_720406_30P(720, 406, 30, 40, true, 33),
    CAMERA_STREAM_424240_15P(424, SapiAccountManager.VERSION_CODE, 15, 40, true, 34),
    CAMERA_STREAM_53122988_30P(5312, 2988, 30, 40, true, 37),
    CAMERA_STREAM_27201530_60P(2720, 1530, 60, 40, true, 38),
    CAMERA_STREAM_27201530_30P(2720, 1530, 30, 40, true, 39),
    CAMERA_STREAM_19201080_60P(WBConstants.SDK_NEW_PAY_VERSION, 1080, 60, 40, true, 40),
    CAMERA_STREAM_27202040_30P(2720, 2040, 30, 40, true, 41),
    CAMERA_STREAM_19201440_30P(WBConstants.SDK_NEW_PAY_VERSION, 1440, 30, 40, true, 42),
    CAMERA_STREAM_1280720_30P(1280, 720, 30, 40, true, 43),
    CAMERA_STREAM_1280960_30P(1280, 960, 30, 40, true, 44),
    CAMERA_STREAM_1152768_30P(1152, 768, 30, 40, true, 45),
    CAMERA_STREAM_53122988_25P(5312, 2988, 25, 40, true, 46),
    CAMERA_STREAM_53122988_24P(5312, 2988, 24, 40, true, 47),
    CAMERA_STREAM_38402160_25P(3840, 2160, 25, 40, true, 48),
    CAMERA_STREAM_38402160_24P(3840, 2160, 24, 40, true, 49),
    CAMERA_STREAM_27201530_25P(2720, 1530, 25, 40, true, 50),
    CAMERA_STREAM_27201530_24P(2720, 1530, 24, 40, true, 51),
    CAMERA_STREAM_19201080_25P(WBConstants.SDK_NEW_PAY_VERSION, 1080, 25, 40, true, 52),
    CAMERA_STREAM_19201080_24P(WBConstants.SDK_NEW_PAY_VERSION, 1080, 24, 40, true, 53),
    CAMERA_STREAM_40003000_25P(4000, BannerConfig.LOOP_TIME, 25, 40, true, 54),
    CAMERA_STREAM_40003000_24P(4000, BannerConfig.LOOP_TIME, 24, 40, true, 55),
    CAMERA_STREAM_27202040_25P(2720, 2040, 25, 40, true, 56),
    CAMERA_STREAM_27202040_24P(2720, 2040, 24, 40, true, 57),
    CAMERA_STREAM_19201440_25P(WBConstants.SDK_NEW_PAY_VERSION, 1440, 25, 40, true, 58),
    CAMERA_STREAM_19201440_24P(WBConstants.SDK_NEW_PAY_VERSION, 1440, 24, 40, true, 59),
    CAMERA_STREAM_720P(1440, 720, 30, 40, true, 9),
    CAMERA_STREAM_960P(WBConstants.SDK_NEW_PAY_VERSION, 960, 30, 40, true, 2),
    CAMERA_STREAM_1088P(2176, 1088, 30, 40, true, 16),
    CAMERA_STREAM_1280P(2560, 1280, 30, 40, true, 1),
    CAMERA_STREAM_1520P(3040, 1520, 30, 40, true, 15);
    
    public int mBitrate;
    public boolean mCanBeUsedForPreview;
    public int mFps;
    public int mHeight;
    public int mVideoResolutionId;
    public int mWidth;

    /* access modifiers changed from: public */
    CameraStreamResolution(int i2, int i3, int i4, int i5, boolean z, int i6) {
        this.mWidth = i2;
        this.mHeight = i3;
        this.mFps = i4;
        this.mBitrate = i5;
        this.mCanBeUsedForPreview = z;
        this.mVideoResolutionId = i6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mWidth);
        sb.append(Config.EVENT_HEAT_X);
        sb.append(this.mHeight);
        return sb.toString();
    }
}
