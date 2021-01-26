package com.arashivision.ble;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.arashivision.onecamera.Options;
import com.arashivision.onecamera.PhotoOptions;
import com.arashivision.onecamera.TaskWaiter;
import com.arashivision.onecamera.camerarequest.CalibrateGyro;
import com.arashivision.onecamera.camerarequest.CheckAuthorization;
import com.arashivision.onecamera.camerarequest.GetMiniThumbnail;
import com.arashivision.onecamera.camerarequest.GetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.SetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.StartTimelapse;
import com.arashivision.onecamera.camerarequest.StopTimelapse;
import com.arashivision.onecamera.camerarequest.TakePicture;
import com.arashivision.onecamera.camerarequest.TestSDCardSpeed;
import e.a.a.a.a;
import java.util.List;

public class OneBle {
    public static final String TAG = "OneBle";
    public Handler mHandler = new Handler(this.mHandlerThread.getLooper());
    public HandlerThread mHandlerThread;
    public OneBleImplement mImpl;
    public Looper mLooper = this.mHandlerThread.getLooper();
    public boolean mRecordStarted;
    public boolean mReleased;

    public interface Task<T> {
        T run();
    }

    public OneBle(final Context context, final OneBleCallbacks oneBleCallbacks, final Handler handler) {
        HandlerThread handlerThread = new HandlerThread("OneBle");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        syncExecute(new Runnable() {
            public void run() {
                OneBle oneBle = OneBle.this;
                oneBle.mImpl = new OneBleImplement(oneBle.mLooper, context, oneBleCallbacks, handler);
            }
        });
    }

    public static String stackTraceToString(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    private void syncExecute(final Runnable runnable) {
        if (!this.mReleased) {
            final Throwable[] thArr = new Throwable[1];
            final TaskWaiter taskWaiter = new TaskWaiter();
            this.mHandler.post(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        thArr[0] = th;
                    }
                    taskWaiter.done();
                }
            });
            taskWaiter.await();
            if (thArr[0] != null) {
                StringBuilder a2 = a.a("[CameraWrapper] OneBleImplement execute error: ");
                a2.append(thArr[0]);
                e.e.a.h.a.a(a2.toString());
                thArr[0].printStackTrace();
                throw new RuntimeException(thArr[0]);
            }
            return;
        }
        throw new RuntimeException("Camera released");
    }

    private <T> T syncExecuteTask(final Task task) {
        if (!this.mReleased) {
            final T[] tArr = new Object[2];
            final TaskWaiter taskWaiter = new TaskWaiter();
            this.mHandler.post(new Runnable() {
                public void run() {
                    try {
                        tArr[1] = task.run();
                    } catch (Throwable th) {
                        tArr[0] = th;
                    }
                    taskWaiter.done();
                }
            });
            taskWaiter.await();
            if (tArr[0] == null) {
                return tArr[1];
            }
            StringBuilder a2 = a.a("[CameraWrapper] OneBleImplement execute error: ");
            a2.append(tArr[0]);
            e.e.a.h.a.a(a2.toString());
            ((Throwable) tArr[0]).printStackTrace();
            throw new RuntimeException((Throwable) tArr[0]);
        }
        throw new RuntimeException("Camera released");
    }

    private void waitNoncancelableTaskComplete() {
        while (((Boolean) syncExecuteTask(new Task() {
            public Boolean run() {
                return Boolean.valueOf(OneBle.this.mImpl.isNoncancelableTaskRunning());
            }
        })).booleanValue()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public synchronized long calibrateGyro(final CalibrateGyro calibrateGyro) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.calibrateGyro(calibrateGyro);
            }
        });
        return jArr[0];
    }

    public synchronized long cancelAuthorization() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.cancelAuthorization();
            }
        });
        return jArr[0];
    }

    public synchronized void cancelScan() {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.cancelScan(true);
            }
        });
    }

    public synchronized void captureStillImage(final TakePicture takePicture, final int i2) {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.captureStillImage(takePicture, i2);
            }
        });
    }

    public synchronized long checkAuthorization(final CheckAuthorization checkAuthorization) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.checkAuthorization(checkAuthorization);
            }
        });
        return jArr[0];
    }

    public synchronized long closeCameraOled() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.closeCameraOled();
            }
        });
        return jArr[0];
    }

    public synchronized long closeCameraWifi() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.closeCameraWifi();
            }
        });
        return jArr[0];
    }

    public synchronized void closeConnect() {
        waitNoncancelableTaskComplete();
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.closeConnect();
            }
        });
    }

    public synchronized long eraseSDCard() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.eraseSDCard();
            }
        });
        return jArr[0];
    }

    public void finalize() throws Throwable {
        if (!this.mReleased) {
            release();
        }
        super.finalize();
    }

    public synchronized long getAllOptionsAsync() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.getAllOptionsAsync();
            }
        });
        return jArr[0];
    }

    public synchronized void getFileInfoList() {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.getFileInfoList();
            }
        });
    }

    public synchronized long getMiniThumbnail(final GetMiniThumbnail getMiniThumbnail) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.getMiniThumbnail(getMiniThumbnail);
            }
        });
        return jArr[0];
    }

    public synchronized long getOptionsAsync(final List<String> list) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.getOptionsAsync(list);
            }
        });
        return jArr[0];
    }

    public synchronized long getPhotoOptionsAsync(final int i2) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.getPhotoOptionsAsync(i2);
            }
        });
        return jArr[0];
    }

    public synchronized long getRecordStatus() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.getCaptureStatus();
            }
        });
        return jArr[0];
    }

    public synchronized long getTimelapseOptionsAsync(final GetTimelapseOptions getTimelapseOptions) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.getTimelapseOptionAsync(getTimelapseOptions);
            }
        });
        return jArr[0];
    }

    public boolean isSupport() {
        final boolean[] zArr = new boolean[1];
        syncExecute(new Runnable() {
            public void run() {
                zArr[0] = OneBle.this.mImpl.isSupportBle();
            }
        });
        return zArr[0];
    }

    public synchronized long openCameraOled() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.openCameraOled();
            }
        });
        return jArr[0];
    }

    public synchronized long openCameraWifi() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.openCameraWifi();
            }
        });
        return jArr[0];
    }

    public synchronized boolean readRssi() {
        boolean[] zArr;
        zArr = new boolean[1];
        syncExecute(new Runnable() {
            public void run() {
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append("readRssi result ");
        sb.append(zArr[0]);
        e.e.a.h.a.b(sb.toString());
        return zArr[0];
    }

    public synchronized void reboot() {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.reboot();
            }
        });
    }

    public void recoverCamera() {
        syncExecute(new Runnable() {
            public void run() {
            }
        });
    }

    public synchronized void release() {
        StringBuilder sb = new StringBuilder();
        sb.append("release OneBle: \n");
        sb.append(stackTraceToString(Thread.currentThread().getStackTrace()));
        e.e.a.h.a.b(sb.toString());
        if (!this.mReleased) {
            waitNoncancelableTaskComplete();
            syncExecute(new Runnable() {
                public void run() {
                    OneBle.this.mImpl.release();
                }
            });
            this.mHandlerThread.quit();
            try {
                this.mHandlerThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.mHandlerThread = null;
            this.mReleased = true;
        }
    }

    public synchronized void requestMtu(final int i2) {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.requestMtu(i2);
            }
        });
    }

    public synchronized void resetRecord() {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.resetRecord();
            }
        });
    }

    public synchronized void scanAndConnect(final String str, final String str2, final boolean z) {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.scanAndConnect(str, str2, z);
            }
        });
    }

    public synchronized void scanDevice() {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.scanDevice();
            }
        });
    }

    public synchronized void setInfoUpdateListener(final Handler handler, final BleInfoUpdateListener bleInfoUpdateListener) {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.setBleInfoUpdateListener(handler, bleInfoUpdateListener);
            }
        });
    }

    public synchronized long setOptionsAsync(final Options options) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.setOptionsAsync(options);
            }
        });
        return jArr[0];
    }

    public synchronized long setPhotoOptionsAsync(final int i2, final PhotoOptions photoOptions) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.setPhotoOptionsAsync(i2, photoOptions);
            }
        });
        return jArr[0];
    }

    public synchronized long setTimelapseOptionsAsync(final SetTimelapseOptions setTimelapseOptions) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.setTimelapseOptionAsync(setTimelapseOptions);
            }
        });
        return jArr[0];
    }

    public void startBroadCast(final int i2, final byte b2, final String str) {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.startBroadCast(i2, b2, str);
            }
        });
    }

    public synchronized void startBulletTime() {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.startBulletTime();
            }
        });
    }

    public synchronized int startRecord() {
        final int[] iArr;
        iArr = new int[1];
        syncExecute(new Runnable() {
            public void run() {
                iArr[0] = OneBle.this.mImpl.startCaptureWithStorage();
            }
        });
        return iArr[0];
    }

    public synchronized void startTimeplapse(final StartTimelapse startTimelapse, final int i2) {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.startTimeplapse(startTimelapse, i2);
            }
        });
    }

    public void stopBroadCast() {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.stopBroadCast();
            }
        });
    }

    public synchronized void stopBulletTime(final byte[] bArr) {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.stopBulletTime(bArr);
            }
        });
    }

    public synchronized void stopRecord(final byte[] bArr) {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.stopRecord(bArr);
            }
        });
    }

    public synchronized void stopTimeplapse(final StopTimelapse stopTimelapse) {
        syncExecute(new Runnable() {
            public void run() {
                OneBle.this.mImpl.stopTimeplapse(stopTimelapse);
            }
        });
    }

    public synchronized long syncCaptureStatus() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.syncCaptureStatus();
            }
        });
        return jArr[0];
    }

    public void takeHdrCapture() {
        TakePicture takePicture = new TakePicture();
        takePicture.extra_metadata = null;
        int[] iArr = new int[3];
        takePicture.aeb_ev_bias = iArr;
        iArr[0] = 0;
        iArr[1] = 1;
        iArr[2] = 2;
        captureStillImage(takePicture, 0);
    }

    public synchronized long testSDCardSpeed(final TestSDCardSpeed testSDCardSpeed) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.testSDCardSpeed(testSDCardSpeed);
            }
        });
        return jArr[0];
    }

    public synchronized long getPhotoOptionsAsync(final int i2, final List<String> list) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneBle.this.mImpl.getPhotoOptionsAsync(i2, list);
            }
        });
        return jArr[0];
    }
}
