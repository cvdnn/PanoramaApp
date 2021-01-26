package com.arashivision.camera.command;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.util.Log;
import com.arashivision.camera.listener.ICameraConnectionListener;
import com.arashivision.onecamera.OneDriver;
import com.arashivision.onecamera.appusb.AppUsbService;
import com.arashivision.onecamera.appusb.DeviceFilter;
import com.arashivision.onecamera.appusb.UsbObserver;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public class OpenUsbCmd extends UsbObserver implements InstaCmdExe {
    public static final String TAG = "com.arashivision.camera.command.OpenUsbCmd";
    public static final int VENDOR_ID_ONE2_UB = 11802;
    public static final int VENDOR_ID_ONE_UB = 16981;
    public final ArrayList<ICameraConnectionListener> mCameraConnectionListener;
    public DeviceFilter mDeviceFilter;
    public OneDriver mDriver;
    public final AppUsbService mUsbService;

    public OpenUsbCmd(Context context, AppUsbService appUsbService, ArrayList<ICameraConnectionListener> arrayList) {
        AnonymousClass1 r1 = new DeviceFilter() {
            public boolean filter(UsbDevice usbDevice) {
                return OpenUsbCmd.this.isDeviceSupport(usbDevice);
            }
        };
        this.mDeviceFilter = r1;
        this.mUsbService = appUsbService;
        appUsbService.addObserver(r1, this);
        this.mCameraConnectionListener = arrayList;
    }

    /* access modifiers changed from: private */
    public boolean isDeviceSupport(UsbDevice usbDevice) {
        int vendorId = usbDevice.getVendorId();
        boolean z = true;
        if (!(vendorId == 16981 || vendorId == 11802 || (usbDevice.getInterfaceCount() > 0 && usbDevice.getInterface(0).getInterfaceClass() == 14))) {
            z = false;
        }
        String str = TAG;
        StringBuilder a2 = a.a("device support ? ");
        a2.append(z ? "yes" : "no");
        a2.append(", vendor id: ");
        a2.append(vendorId);
        a2.append("(");
        a2.append(vendorId);
        a2.append(")");
        Log.i(str, a2.toString());
        String str2 = TAG;
        StringBuilder a3 = a.a("device.getInterfaceCount() ");
        a3.append(usbDevice.getInterfaceCount());
        Log.i(str2, a3.toString());
        if (usbDevice.getInterfaceCount() > 0) {
            String str3 = TAG;
            StringBuilder a4 = a.a("device.getInterface(0).getInterfaceClass(): ");
            a4.append(usbDevice.getInterface(0).getInterfaceClass());
            Log.i(str3, a4.toString());
        }
        return z;
    }

    public Object exeCmd(OneDriver oneDriver) {
        UsbDevice device = this.mUsbService.getDevice(this.mDeviceFilter);
        if (device == null) {
            Log.e(TAG, "no device found");
            return null;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("device opening : ");
        sb.append(device);
        Log.d(str, sb.toString());
        this.mDriver = oneDriver;
        this.mUsbService.openDevice(device);
        return null;
    }

    public void onDeviceOpenComplete(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, DeviceFilter deviceFilter, int i2) {
        super.onDeviceOpenComplete(usbDevice, usbDeviceConnection, deviceFilter, i2);
        a.b("device open complete :", i2, TAG);
        if (i2 == 0) {
            OneDriver oneDriver = this.mDriver;
            if (oneDriver != null) {
                oneDriver.open(this.mUsbService.getUsbSysPath());
            }
            Iterator it = this.mCameraConnectionListener.iterator();
            while (it.hasNext()) {
                ((ICameraConnectionListener) it.next()).onCameraConnect();
            }
        }
    }
}
