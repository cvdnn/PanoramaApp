package com.arashivision.onecamera.appusb;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.mobstat.Config;
import e.a.a.a.a;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

public class AppUsbService {
    public static final String APP_SERVICE_ACTION_USB_PERMISSION = "AppUsbService.USB_PERMISSION";
    public static final int MSG_ADD_OBSERVER = 0;
    public static final int MSG_CLOSE_DEVICE = 3;
    public static final int MSG_GET_DEVICE = 4;
    public static final int MSG_OPEN_DEVICE = 2;
    public static final int MSG_QUIT = 20;
    public static final int MSG_REMOVE_OBSERVER = 1;
    public static final int MSG_SYS_DEVICE_ATTACHED = 10;
    public static final int MSG_SYS_DEVICE_DETACHED = 11;
    public static final String TAG = "AppUsbService";
    public static final Object mLoadSyncObject = new Object();
    public static boolean mLoaded;
    public static File mUsbSysRootDir;
    public Context mAppContext;
    public ArrayList<ConnectionInfo> mConnections = new ArrayList<>();
    public Handler mDefaultObserverHandler;
    public int mFakeBusNum = 1;
    public int mFakeDevNum = 1;
    public volatile boolean mIsRunning;
    public final ArrayList<ObserverInfo> mObserverLists = new ArrayList<>();
    public UsbDevice mPermPendingDevice;
    public UsbPermission mPermissionState;
    public final Object mPermissionSyncObj = new Object();
    public File mUsbDir;
    public Handler mUsbHandler;
    public UsbManager mUsbManager;
    public UsbBroadcastReceiver mUsbReceiver;
    public HandlerThread mUsbThread;

    public static class BusDev {
        public int busNum;
        public int devNum;

        public BusDev(int i2, int i3) {
            this.busNum = i2;
            this.devNum = i3;
        }
    }

    public static class ConnectionInfo {
        public UsbDeviceConnection con;
        public File devDir;
        public UsbDevice device;

        public ConnectionInfo(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
            this.device = usbDevice;
            this.con = usbDeviceConnection;
        }
    }

    public static class ObserverInfo {
        public DeviceFilter filter;
        public UsbObserver observer;

        public ObserverInfo(DeviceFilter deviceFilter, UsbObserver usbObserver) {
            this.filter = deviceFilter;
            this.observer = usbObserver;
        }
    }

    public static class UsbBroadcastReceiver extends BroadcastReceiver {
        public WeakReference<AppUsbService> mAppUsbService;

        public UsbBroadcastReceiver(AppUsbService appUsbService) {
            this.mAppUsbService = new WeakReference<>(appUsbService);
        }

        public void onReceive(Context context, Intent intent) {
            AppUsbService appUsbService = (AppUsbService) this.mAppUsbService.get();
            if (appUsbService != null) {
                String action = intent.getAction();
                boolean equals = AppUsbService.APP_SERVICE_ACTION_USB_PERMISSION.equals(action);
                String str = Config.DEVICE_PART;
                if (equals) {
                    appUsbService.onPermission((UsbDevice) intent.getParcelableExtra(str), intent.getBooleanExtra("permission", false));
                } else {
                    boolean equals2 = "android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action);
                    String str2 = AppUsbService.TAG;
                    if (equals2) {
                        UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra(str);
                        StringBuilder a2 = a.a("device attached: ");
                        a2.append(AppUsbService.deviceName(usbDevice));
                        Log.i(str2, a2.toString());
                        appUsbService.onDeviceAttached(usbDevice);
                    } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                        UsbDevice usbDevice2 = (UsbDevice) intent.getParcelableExtra(str);
                        StringBuilder a3 = a.a("device detached: ");
                        a3.append(AppUsbService.deviceName(usbDevice2));
                        Log.i(str2, a3.toString());
                        appUsbService.onDeviceDetached(usbDevice2);
                    }
                }
            }
        }
    }

    public static class UsbHandler extends Handler {
        public WeakReference<AppUsbService> mAppUsbService;

        public UsbHandler(AppUsbService appUsbService, Looper looper) {
            super(looper);
            this.mAppUsbService = new WeakReference<>(appUsbService);
        }

        public void handleMessage(Message message) {
            AppUsbService appUsbService = (AppUsbService) this.mAppUsbService.get();
            if (appUsbService != null) {
                appUsbService.handleRequest(message);
            }
        }
    }

    public enum UsbPermission {
        WaitingGrant,
        Granted,
        Deny
    }

    public AppUsbService(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mUsbManager = (UsbManager) applicationContext.getSystemService("usb");
        this.mDefaultObserverHandler = new Handler(this.mAppContext.getMainLooper());
        this.mUsbReceiver = new UsbBroadcastReceiver(this);
        this.mIsRunning = true;
        loadOnce(this.mAppContext);
        try {
            File createTempFile = File.createTempFile("usb-", "", mUsbSysRootDir);
            this.mUsbDir = createTempFile;
            createTempFile.delete();
            if (this.mUsbDir.mkdir()) {
                HandlerThread handlerThread = new HandlerThread("UsbThread");
                this.mUsbThread = handlerThread;
                handlerThread.start();
                this.mUsbHandler = new UsbHandler(this, this.mUsbThread.getLooper());
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(APP_SERVICE_ACTION_USB_PERMISSION);
                intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
                intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
                this.mAppContext.registerReceiver(this.mUsbReceiver, intentFilter);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("failed create directory: ");
            sb.append(this.mUsbDir.toString());
            throw new IOException(sb.toString());
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void closeConnection(ConnectionInfo connectionInfo) {
        try {
            deleteFile(connectionInfo.devDir);
            connectionInfo.con.close();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void createFile(File file, String str, String str2) throws IOException {
        createFile(file, str, str2.getBytes("utf-8"));
    }

    private void createFsNode(ConnectionInfo connectionInfo) throws IOException {
        BusDev fakeBusDev = fakeBusDev();
        File file = this.mUsbDir;
        StringBuilder sb = new StringBuilder();
        sb.append(fakeBusDev.busNum);
        sb.append("-");
        sb.append(fakeBusDev.devNum);
        File file2 = new File(file, sb.toString());
        file2.mkdir();
        connectionInfo.devDir = file2;
        createFile(file2, "busnum", Integer.toString(fakeBusDev.busNum));
        createFile(file2, "devnum", Integer.toString(fakeBusDev.devNum));
        createFile(file2, "speed", Integer.toString(480));
        createFile(file2, "descriptors", connectionInfo.con.getRawDescriptors());
        createFile(file2, "dev_fd", Integer.toString(connectionInfo.con.getFileDescriptor()));
    }

    public static void deleteFile(File file) throws IOException {
        if (file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File deleteFile : listFiles) {
                    deleteFile(deleteFile);
                }
            }
        }
        if (!file.delete() && file.exists()) {
            throw new IOException(a.a("Failed to delete file: ", file));
        }
    }

    public static String deviceName(UsbDevice usbDevice) {
        return String.format(Locale.getDefault(), "%x:%x", new Object[]{Integer.valueOf(usbDevice.getVendorId()), Integer.valueOf(usbDevice.getProductId())});
    }

    private void doAddObserver(DeviceFilter deviceFilter, UsbObserver usbObserver) {
        Iterator it = this.mObserverLists.iterator();
        while (it.hasNext()) {
            ObserverInfo observerInfo = (ObserverInfo) it.next();
            if (observerInfo.filter == deviceFilter && observerInfo.observer == usbObserver) {
                return;
            }
        }
        this.mObserverLists.add(new ObserverInfo(deviceFilter, usbObserver));
    }

    private void doCloseDevice(UsbDevice usbDevice) {
        String str;
        Iterator it = this.mConnections.iterator();
        int i2 = 0;
        while (true) {
            boolean hasNext = it.hasNext();
            str = TAG;
            if (!hasNext) {
                break;
            }
            ConnectionInfo connectionInfo = (ConnectionInfo) it.next();
            if (usbDevice == connectionInfo.device) {
                closeConnection(connectionInfo);
                it.remove();
                i2++;
                StringBuilder a2 = a.a("device closed: ");
                a2.append(deviceName(usbDevice));
                Log.i(str, a2.toString());
            }
        }
        if (i2 == 1) {
            return;
        }
        if (i2 == 0) {
            Log.w(str, "no matched device to close");
            StringBuilder sb = new StringBuilder();
            sb.append("total connection: ");
            sb.append(this.mConnections.size());
            Log.i(str, sb.toString());
            for (int i3 = 0; i3 < this.mConnections.size(); i3++) {
                StringBuilder a3 = a.a("con ", i3, Config.TRACE_TODAY_VISIT_SPLIT);
                a3.append(((ConnectionInfo) this.mConnections.get(i3)).device.hashCode());
                a3.append(deviceName(((ConnectionInfo) this.mConnections.get(i3)).device));
                Log.i(str, a3.toString());
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("closed ");
        sb2.append(i2);
        sb2.append(" usb connection");
        Log.w(str, sb2.toString());
    }

    private UsbDevice doGetDevice(DeviceFilter deviceFilter) {
        StringBuilder a2 = a.a("mUsbManager.getDeviceList() size ");
        a2.append(this.mUsbManager.getDeviceList().size());
        Log.d(TAG, a2.toString());
        for (UsbDevice usbDevice : this.mUsbManager.getDeviceList().values()) {
            if (deviceFilter.filter(usbDevice)) {
                return usbDevice;
            }
        }
        return null;
    }

    private void doOpenDevice(UsbDevice usbDevice) {
        if (this.mUsbManager.hasPermission(usbDevice)) {
            openGrantedDevice(usbDevice);
            return;
        }
        StringBuilder a2 = a.a("request permission: ");
        a2.append(deviceName(usbDevice));
        String sb = a2.toString();
        String str = TAG;
        Log.i(str, sb);
        boolean requestAndWaitPermission = requestAndWaitPermission(usbDevice);
        StringBuilder a3 = a.a("permission ");
        a3.append(requestAndWaitPermission ? "granted" : "deny");
        Log.i(str, a3.toString());
        if (requestAndWaitPermission) {
            openGrantedDevice(usbDevice);
        } else {
            notifyOpenResult(usbDevice, null, UsbError.ERR_PERMISSION);
        }
    }

    private void doQuit() {
        Iterator it = this.mConnections.iterator();
        if (it.hasNext()) {
            ConnectionInfo connectionInfo = (ConnectionInfo) it.next();
            closeConnection(connectionInfo);
            StringBuilder a2 = a.a("quiting... close connection: ");
            a2.append(connectionInfo.device);
            Log.i(TAG, a2.toString());
            it.remove();
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            myLooper.quit();
        }
    }

    private void doRemoveObserver(DeviceFilter deviceFilter, UsbObserver usbObserver) {
        Iterator it = this.mObserverLists.iterator();
        while (it.hasNext()) {
            ObserverInfo observerInfo = (ObserverInfo) it.next();
            if (observerInfo.filter == deviceFilter && observerInfo.observer == usbObserver) {
                it.remove();
            }
        }
    }

    private void executeObserverCb(UsbObserver usbObserver, Runnable runnable) {
        Handler handler = usbObserver.getHandler();
        if (handler == null) {
            handler = this.mDefaultObserverHandler;
        }
        handler.post(runnable);
    }

    private BusDev fakeBusDev() {
        BusDev busDev = new BusDev(this.mFakeBusNum, this.mFakeDevNum);
        int i2 = this.mFakeDevNum + 1;
        this.mFakeDevNum = i2;
        if (i2 >= 255) {
            this.mFakeBusNum++;
            this.mFakeDevNum = 0;
        }
        return busDev;
    }

    /* access modifiers changed from: private */
    public void handleRequest(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            Object[] objArr = (Object[]) message.obj;
            doAddObserver((DeviceFilter) objArr[0], (UsbObserver) objArr[1]);
            ((CountDownLatch) objArr[2]).countDown();
        } else if (i2 == 1) {
            Object[] objArr2 = (Object[]) message.obj;
            doRemoveObserver((DeviceFilter) objArr2[0], (UsbObserver) objArr2[1]);
            ((CountDownLatch) objArr2[2]).countDown();
        } else if (i2 == 2) {
            doOpenDevice((UsbDevice) message.obj);
        } else if (i2 == 3) {
            Object[] objArr3 = (Object[]) message.obj;
            doCloseDevice((UsbDevice) objArr3[0]);
            ((CountDownLatch) objArr3[1]).countDown();
        } else if (i2 == 4) {
            Object[] objArr4 = (Object[]) message.obj;
            CountDownLatch countDownLatch = (CountDownLatch) objArr4[1];
            objArr4[2] = doGetDevice((DeviceFilter) objArr4[0]);
            countDownLatch.countDown();
        } else if (i2 == 10) {
            notifyDeviceAttached((UsbDevice) message.obj);
        } else if (i2 == 11) {
            notifyDeviceDetached((UsbDevice) message.obj);
        } else if (i2 == 20) {
            doQuit();
        }
    }

    public static boolean isTheSameDevice(UsbDevice usbDevice, UsbDevice usbDevice2) {
        return usbDevice == usbDevice2 || (usbDevice.getVendorId() == usbDevice2.getVendorId() && usbDevice.getProductId() == usbDevice2.getProductId() && usbDevice.getDeviceClass() == usbDevice2.getDeviceClass() && usbDevice.getDeviceSubclass() == usbDevice2.getDeviceSubclass() && usbDevice.getDeviceProtocol() == usbDevice2.getDeviceProtocol() && usbDevice.getInterfaceCount() == usbDevice2.getInterfaceCount());
    }

    private void loadOnce(Context context) {
        synchronized (mLoadSyncObject) {
            if (!mLoaded) {
                try {
                    mUsbSysRootDir = new File(context.getFilesDir(), "usb_sys");
                    String str = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("clean usb sys root directory ");
                    sb.append(mUsbSysRootDir.getAbsolutePath());
                    Log.i(str, sb.toString());
                    deleteFile(mUsbSysRootDir);
                    mUsbSysRootDir.mkdir();
                    if (mUsbSysRootDir.isDirectory()) {
                        mLoaded = true;
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("failed create path: ");
                    sb2.append(mUsbSysRootDir.toString());
                    throw new IOException(sb2.toString());
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
    }

    private void notifyDeviceAttached(final UsbDevice usbDevice) {
        synchronized (this.mObserverLists) {
            Iterator it = this.mObserverLists.iterator();
            while (it.hasNext()) {
                ObserverInfo observerInfo = (ObserverInfo) it.next();
                final DeviceFilter deviceFilter = observerInfo.filter;
                final UsbObserver usbObserver = observerInfo.observer;
                if (deviceFilter.filter(usbDevice)) {
                    executeObserverCb(usbObserver, new Runnable() {
                        public void run() {
                            usbObserver.onDeviceAttached(usbDevice, deviceFilter);
                        }
                    });
                }
            }
        }
    }

    private void notifyDeviceDetached(final UsbDevice usbDevice) {
        synchronized (this.mObserverLists) {
            Iterator it = this.mObserverLists.iterator();
            while (it.hasNext()) {
                ObserverInfo observerInfo = (ObserverInfo) it.next();
                final DeviceFilter deviceFilter = observerInfo.filter;
                final UsbObserver usbObserver = observerInfo.observer;
                if (deviceFilter.filter(usbDevice)) {
                    executeObserverCb(usbObserver, new Runnable() {
                        public void run() {
                            usbObserver.onDeviceDetached(usbDevice, deviceFilter);
                        }
                    });
                }
            }
        }
    }

    private void notifyOpenResult(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, int i2) {
        synchronized (this.mObserverLists) {
            Iterator it = this.mObserverLists.iterator();
            while (it.hasNext()) {
                ObserverInfo observerInfo = (ObserverInfo) it.next();
                final DeviceFilter deviceFilter = observerInfo.filter;
                UsbObserver usbObserver = observerInfo.observer;
                if (deviceFilter.filter(usbDevice)) {
                    final UsbObserver usbObserver2 = usbObserver;
                    final UsbDevice usbDevice2 = usbDevice;
                    final UsbDeviceConnection usbDeviceConnection2 = usbDeviceConnection;
                    final int i3 = i2;
                    AnonymousClass1 r3 = new Runnable() {
                        public void run() {
                            usbObserver2.onDeviceOpenComplete(usbDevice2, usbDeviceConnection2, deviceFilter, i3);
                        }
                    };
                    executeObserverCb(usbObserver, r3);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onDeviceAttached(UsbDevice usbDevice) {
        Handler handler = this.mUsbHandler;
        handler.sendMessage(handler.obtainMessage(10, usbDevice));
    }

    /* access modifiers changed from: private */
    public void onDeviceDetached(UsbDevice usbDevice) {
        synchronized (this.mPermissionSyncObj) {
            if (this.mPermissionState == UsbPermission.WaitingGrant && isTheSameDevice(usbDevice, this.mPermPendingDevice)) {
                Log.i(TAG, "device detached, but the device is waiting grant permission, as deny");
                this.mPermissionState = UsbPermission.Deny;
                this.mPermissionSyncObj.notifyAll();
            }
        }
        Handler handler = this.mUsbHandler;
        handler.sendMessage(handler.obtainMessage(11, usbDevice));
    }

    /* access modifiers changed from: private */
    public void onPermission(UsbDevice usbDevice, boolean z) {
        StringBuilder a2 = a.a("onPermission: ");
        a2.append(deviceName(usbDevice));
        a2.append(" ");
        a2.append(z ? "granted" : "deny");
        Log.i(TAG, a2.toString());
        synchronized (this.mPermissionSyncObj) {
            if (this.mPermissionState != UsbPermission.WaitingGrant || !isTheSameDevice(usbDevice, this.mPermPendingDevice)) {
                Log.i(TAG, "device is not requesting permission, ignored");
            } else {
                this.mPermissionState = z ? UsbPermission.Granted : UsbPermission.Deny;
                this.mPermissionSyncObj.notifyAll();
            }
        }
    }

    private void openGrantedDevice(UsbDevice usbDevice) {
        if (this.mUsbManager.hasPermission(usbDevice)) {
            UsbDeviceConnection openDevice = this.mUsbManager.openDevice(usbDevice);
            if (openDevice == null) {
                notifyOpenResult(usbDevice, null, UsbError.ERR_CONNECTION);
                return;
            }
            ConnectionInfo connectionInfo = new ConnectionInfo(usbDevice, openDevice);
            try {
                createFsNode(connectionInfo);
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("usb fs dir: ");
                sb.append(connectionInfo.devDir.getAbsolutePath());
                Log.i(str, sb.toString());
                this.mConnections.add(connectionInfo);
                notifyOpenResult(usbDevice, openDevice, 0);
            } catch (IOException unused) {
                notifyOpenResult(usbDevice, null, UsbError.ERR_UNKNOWN);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private boolean requestAndWaitPermission(UsbDevice usbDevice) {
        boolean z = true;
        if (this.mUsbManager.hasPermission(usbDevice)) {
            return true;
        }
        synchronized (this.mPermissionSyncObj) {
            if (this.mPermPendingDevice == null) {
                this.mPermPendingDevice = usbDevice;
                this.mPermissionState = UsbPermission.WaitingGrant;
                this.mUsbManager.requestPermission(usbDevice, PendingIntent.getBroadcast(this.mAppContext, 0, new Intent(APP_SERVICE_ACTION_USB_PERMISSION), 0));
                while (this.mPermissionState == UsbPermission.WaitingGrant && this.mIsRunning) {
                    try {
                        this.mPermissionSyncObj.wait(100);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                if (!this.mIsRunning) {
                    this.mPermPendingDevice = null;
                    this.mPermissionState = UsbPermission.Deny;
                }
                if (this.mPermissionState != UsbPermission.Granted) {
                    z = false;
                }
                this.mPermPendingDevice = null;
            } else {
                throw new RuntimeException("request permission in bad state");
            }
        }
        return z;
    }

    public void addObserver(DeviceFilter deviceFilter, UsbObserver usbObserver) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Object[] objArr = {deviceFilter, usbObserver, countDownLatch};
        Handler handler = this.mUsbHandler;
        handler.sendMessage(handler.obtainMessage(0, objArr));
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void closeDevice(UsbDevice usbDevice) {
        StringBuilder a2 = a.a("close device: ");
        a2.append(deviceName(usbDevice));
        Log.i(TAG, a2.toString());
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Object[] objArr = {usbDevice, countDownLatch};
        Handler handler = this.mUsbHandler;
        handler.sendMessage(handler.obtainMessage(3, objArr));
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void finalize() throws Throwable {
        if (this.mIsRunning) {
            Log.i(TAG, "finalizing: app usb service not released, force release");
            release();
        }
        super.finalize();
    }

    public UsbDevice getDevice(DeviceFilter deviceFilter) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Object[] objArr = {deviceFilter, countDownLatch, null};
        Handler handler = this.mUsbHandler;
        handler.sendMessage(handler.obtainMessage(4, objArr));
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return (UsbDevice) objArr[2];
    }

    public String getUsbSysPath() {
        return this.mUsbDir.getAbsolutePath();
    }

    public void openDevice(UsbDevice usbDevice) {
        Handler handler = this.mUsbHandler;
        handler.sendMessage(handler.obtainMessage(2, usbDevice));
    }

    public void release() {
        if (this.mIsRunning) {
            String str = TAG;
            Log.i(str, "release app usb service");
            this.mIsRunning = false;
            this.mAppContext.unregisterReceiver(this.mUsbReceiver);
            Handler handler = this.mUsbHandler;
            handler.sendMessage(handler.obtainMessage(20));
            try {
                this.mUsbThread.quitSafely();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.mUsbThread = null;
            try {
                deleteFile(this.mUsbDir);
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            Log.i(str, "app usb service released");
        }
    }

    public void removeObserver(DeviceFilter deviceFilter, UsbObserver usbObserver) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Object[] objArr = {deviceFilter, usbObserver, countDownLatch};
        Handler handler = this.mUsbHandler;
        handler.sendMessage(handler.obtainMessage(1, objArr));
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f A[SYNTHETIC, Splitter:B:13:0x001f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createFile(java.io.File r3, java.lang.String r4, byte[] r5) throws java.io.IOException {
        /*
            r2 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r3, r4)
            r3 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0019 }
            r4.<init>(r0)     // Catch:{ all -> 0x0019 }
            r4.write(r5)     // Catch:{ all -> 0x0017 }
            r4.close()     // Catch:{ IOException -> 0x0012 }
            goto L_0x0016
        L_0x0012:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0016:
            return
        L_0x0017:
            r3 = move-exception
            goto L_0x001d
        L_0x0019:
            r4 = move-exception
            r1 = r4
            r4 = r3
            r3 = r1
        L_0x001d:
            if (r4 == 0) goto L_0x0027
            r4.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0027:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onecamera.appusb.AppUsbService.createFile(java.io.File, java.lang.String, byte[]):void");
    }
}
