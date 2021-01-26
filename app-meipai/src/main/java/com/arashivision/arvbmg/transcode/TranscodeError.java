package com.arashivision.arvbmg.transcode;

public class TranscodeError {
    public String desc;
    public String domain;
    public int errorCode;

    public static class TranscodeErrorCode {
        public static final int ERROR_AUDIO_STEP = -411;
        public static final int ERROR_CLOSEINPUT = -402;
        public static final int ERROR_GETFD = -407;
        public static final int ERROR_OPENINPUT = -401;
        public static final int ERROR_OPENMUX = -404;
        public static final int ERROR_RELEASEMUX = -406;
        public static final int ERROR_SETINPUTSOURCE = -403;
        public static final int ERROR_SETINPUT_AUDIOSOURCE = -408;
        public static final int ERROR_TRANSCODESLEEP = -405;
        public static final int ERROR_VIDEO_MEDIACODEC_SETUP = -409;
        public static final int ERROR_VIDEO_STEP = -410;
    }

    public TranscodeError(int i2) {
        this(i2, null, null);
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDomain() {
        return this.domain;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public TranscodeError(int i2, String str, String str2) {
        this.errorCode = i2;
        this.domain = str;
        this.desc = str2;
    }
}
