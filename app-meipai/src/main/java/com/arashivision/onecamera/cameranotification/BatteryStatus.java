package com.arashivision.onecamera.cameranotification;

public class BatteryStatus {
    public int battery_level;
    public int battery_scale;
    public int power_type;

    private void setBatteryLevel(int i2) {
        this.battery_level = i2;
    }

    private void setBatteryScale(int i2) {
        this.battery_scale = i2;
    }

    private void setPowerType(int i2) {
        this.power_type = i2;
    }
}
