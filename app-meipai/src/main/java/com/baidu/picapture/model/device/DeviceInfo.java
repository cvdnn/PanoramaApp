package com.baidu.picapture.model.device;

public class DeviceInfo {
    public static final int DEVICE_STATUS_CONNECTED = 2;
    public static final int DEVICE_STATUS_CONNECTING = 1;
    public static final int DEVICE_STATUS_DISCONNECT = 3;
    public static final int DEVICE_STATUS_ONLINE = 0;
    public String mAddress;
    public int mDeviceStatus = 0;
    public String mName;

    public DeviceInfo() {
        String str = "";
        this.mName = str;
        this.mAddress = str;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getDeviceStatus() {
        return this.mDeviceStatus;
    }

    public String getName() {
        return this.mName;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setDeviceStatus(int i2) {
        this.mDeviceStatus = i2;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
