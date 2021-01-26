package com.arashivision.camera;

public class InstaCameraConstants {

    public enum RecordingType {
        Camera,
        Origin,
        ReEncoded
    }

    public static class StrategyType {
        public static final int BLE_TYPE = 1;
        public static final int OTG_TYPE = 3;
        public static final int WIFI_TYPE = 2;
    }
}
