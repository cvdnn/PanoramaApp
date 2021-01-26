package com.arashivision.onecamera.appusb;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.os.Handler;

public class UsbObserver {
    public Handler getHandler() {
        return null;
    }

    public void onDeviceAttached(UsbDevice usbDevice, DeviceFilter deviceFilter) {
    }

    public void onDeviceDetached(UsbDevice usbDevice, DeviceFilter deviceFilter) {
    }

    public void onDeviceOpenComplete(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, DeviceFilter deviceFilter, int i2) {
    }
}
