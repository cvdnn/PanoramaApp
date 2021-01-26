package com.baidu.picapture.hardware.panorama.beans;

public class OSCState {
    public String fingerprint;
    public StateBean state;

    public static class StateBean {
        public float batteryLevel;
        public String storageUri;

        public float getBatteryLevel() {
            return this.batteryLevel;
        }

        public String getStorageUri() {
            return this.storageUri;
        }

        public void setBatteryLevel(int i2) {
            this.batteryLevel = (float) i2;
        }

        public void setStorageUri(String str) {
            this.storageUri = str;
        }
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public StateBean getState() {
        return this.state;
    }

    public void setFingerprint(String str) {
        this.fingerprint = str;
    }

    public void setState(StateBean stateBean) {
        this.state = stateBean;
    }
}
