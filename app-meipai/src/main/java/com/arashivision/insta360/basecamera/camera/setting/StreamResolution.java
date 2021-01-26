package com.arashivision.insta360.basecamera.camera.setting;

import com.baidu.sapi2.SapiAccountManager;
import com.sina.weibo.sdk.constant.WBConstants;
import com.youth.banner.config.BannerConfig;

public enum StreamResolution {
    STREAM_5760_2880_30FPS(5760, 2880, 30, 40, 10),
    STREAM_5760_2880_25FPS(5760, 2880, 25, 40, 19),
    STREAM_5760_2880_24FPS(5760, 2880, 24, 40, 20),
    STREAM_3840_1920_50FPS(3840, WBConstants.SDK_NEW_PAY_VERSION, 50, 40, 12),
    STREAM_3840_1920_30FPS(3840, WBConstants.SDK_NEW_PAY_VERSION, 30, 40, 0),
    STREAM_3008_1504_100FPS(3008, 1504, 100, 40, 13),
    STREAM_2560_1280_30FPS(2560, 1280, 30, 40, 1),
    STREAM_2176_1088_30FPS(2176, 1088, 30, 40, 16),
    STREAM_1920_960_30FPS(WBConstants.SDK_NEW_PAY_VERSION, 960, 30, 40, 2),
    STREAM_1440_720_30FPS(1440, 720, 30, 40, 9),
    STREAM_720_360_30FPS(720, 360, 30, 40, 17),
    STREAM_480_240_30FPS(480, SapiAccountManager.VERSION_CODE, 30, 40, 18),
    STREAM_5312_2988_30FPS(5312, 2988, 30, 40, 37),
    STREAM_5312_2988_25FPS(5312, 2988, 25, 40, 46),
    STREAM_5312_2988_24FPS(5312, 2988, 24, 40, 47),
    STREAM_3840_2160_60FPS(3840, 2160, 60, 40, 23),
    STREAM_3840_2160_30FPS(3840, 2160, 30, 40, 24),
    STREAM_3840_2160_25FPS(3840, 2160, 25, 40, 48),
    STREAM_3840_2160_24FPS(3840, 2160, 24, 40, 49),
    STREAM_2720_1530_100FPS(2720, 1530, 100, 40, 25),
    STREAM_2720_1530_60FPS(2720, 1530, 60, 40, 38),
    STREAM_2720_1530_30FPS(2720, 1530, 30, 40, 39),
    STREAM_2720_1530_25FPS(2720, 1530, 25, 40, 50),
    STREAM_2720_1530_24FPS(2720, 1530, 24, 40, 51),
    STREAM_1920_1080_200FPS(WBConstants.SDK_NEW_PAY_VERSION, 1080, 200, 40, 26),
    STREAM_1920_1080_120FPS(WBConstants.SDK_NEW_PAY_VERSION, 1080, 120, 40, 28),
    STREAM_1920_1080_60FPS(WBConstants.SDK_NEW_PAY_VERSION, 1080, 60, 40, 40),
    STREAM_1920_1080_30FPS(WBConstants.SDK_NEW_PAY_VERSION, 1080, 30, 40, 29),
    STREAM_1920_1080_25FPS(WBConstants.SDK_NEW_PAY_VERSION, 1080, 25, 40, 52),
    STREAM_1920_1080_24FPS(WBConstants.SDK_NEW_PAY_VERSION, 1080, 24, 40, 53),
    STREAM_1280_720_30FPS(1280, 720, 30, 40, 43),
    STREAM_424_240_15FPS(424, SapiAccountManager.VERSION_CODE, 15, 40, 34),
    STREAM_4000_3000_30FPS(4000, BannerConfig.LOOP_TIME, 30, 40, 31),
    STREAM_4000_3000_25FPS(4000, BannerConfig.LOOP_TIME, 25, 40, 54),
    STREAM_4000_3000_24FPS(4000, BannerConfig.LOOP_TIME, 24, 40, 55),
    STREAM_2720_2040_30FPS(2720, 2040, 30, 40, 41),
    STREAM_2720_2040_25FPS(2720, 2040, 25, 40, 56),
    STREAM_2720_2040_24FPS(2720, 2040, 24, 40, 57),
    STREAM_1920_1440_30FPS(WBConstants.SDK_NEW_PAY_VERSION, 1440, 30, 40, 42),
    STREAM_1920_1440_25FPS(WBConstants.SDK_NEW_PAY_VERSION, 1440, 25, 40, 52),
    STREAM_1920_1440_24FPS(WBConstants.SDK_NEW_PAY_VERSION, 1440, 24, 40, 53),
    STREAM_1280_960_30FPS(1280, 960, 30, 40, 44),
    STREAM_1152_768_30FPS(1152, 768, 30, 40, 45);
    
    public int bitrate;
    public int fps;
    public int height;
    public int valueInCamera;
    public int width;

    /* access modifiers changed from: public */
    StreamResolution(int i2, int i3, int i4, int i5, int i6) {
        this.width = i2;
        this.height = i3;
        this.fps = i4;
        this.bitrate = i5;
        this.valueInCamera = i6;
    }

    public static StreamResolution getFromResolution(int i2, int i3, int i4) {
        StreamResolution[] values;
        for (StreamResolution streamResolution : values()) {
            if (streamResolution.width == i2 && streamResolution.height == i3 && streamResolution.fps == i4) {
                return streamResolution;
            }
        }
        return null;
    }
}
