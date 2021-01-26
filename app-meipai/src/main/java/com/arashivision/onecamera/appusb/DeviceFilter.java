package com.arashivision.onecamera.appusb;

import android.hardware.usb.UsbDevice;

public interface DeviceFilter {
    boolean filter(UsbDevice usbDevice);
}
