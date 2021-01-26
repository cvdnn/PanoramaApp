package com.baidu.picapture.hardware.ble;

import e.g.b.b0.b;
import java.util.List;

public class BleHistoryBean {
    public List<DevicesBean> devices;
    @b("last_address")
    public String lastAddress;

    public static class DevicesBean {
        public String address;
        public String name;

        public String getAddress() {
            return this.address;
        }

        public String getName() {
            return this.name;
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public List<DevicesBean> getDevices() {
        return this.devices;
    }

    public String getLastAddress() {
        return this.lastAddress;
    }

    public void setDevices(List<DevicesBean> list) {
        this.devices = list;
    }

    public void setLastAddress(String str) {
        this.lastAddress = str;
    }
}
