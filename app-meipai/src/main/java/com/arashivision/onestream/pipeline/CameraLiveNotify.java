package com.arashivision.onestream.pipeline;

public final class CameraLiveNotify {

    public static class ErrorCode {
        public static final int AUDIO_FILTER_OPEN = -1003;
        public static final int AUDIO_FILTER_REC = -1002;
        public static final int AUDIO_FILTER_SEND = -1001;
        public static final int CAMERA_FINISH_WRITE = -1007;
        public static final int CAMERA_START_WRITER = -1004;
        public static final int CAMERA_WRITE_AUDIO = -1006;
        public static final int CAMERA_WRITE_VIDEO = -1005;
        public static final int NO_ERROR = 0;
    }

    public static class NotifyType {
        public static final int FAIL = -100;
        public static final int FPS = 100;
        public static final int START = 200;
    }
}
