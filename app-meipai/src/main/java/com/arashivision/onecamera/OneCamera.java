package com.arashivision.onecamera;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.arashivision.onecamera.OneCameraImplement.OpenState;
import com.arashivision.onecamera.camerarequest.CalibrateGyro;
import com.arashivision.onecamera.camerarequest.CheckAuthorization;
import com.arashivision.onecamera.camerarequest.ConnectToBTPeripheral;
import com.arashivision.onecamera.camerarequest.DeleteFiles;
import com.arashivision.onecamera.camerarequest.DisconnectBTPeripheral;
import com.arashivision.onecamera.camerarequest.GetConnectedBTPeripheral;
import com.arashivision.onecamera.camerarequest.GetFileExtra;
import com.arashivision.onecamera.camerarequest.GetFileList;
import com.arashivision.onecamera.camerarequest.GetGyro;
import com.arashivision.onecamera.camerarequest.GetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.ScanBTPeripheral;
import com.arashivision.onecamera.camerarequest.SetFileExtra;
import com.arashivision.onecamera.camerarequest.SetTimelapseOptions;
import com.arashivision.onecamera.camerarequest.StartTimelapse;
import com.arashivision.onecamera.camerarequest.StopTimelapse;
import com.arashivision.onecamera.camerarequest.TakePicture;
import com.arashivision.onecamera.camerarequest.TestSDCardSpeed;
import com.arashivision.onecamera.cameraresponse.GetGyroResp;
import com.arashivision.onecamera.render.RenderMode;
import com.arashivision.onestream.Gyro.OneLatestIDR;
import com.arashivision.onestream.PlayerBackend;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import e.a.a.a.a;
import java.util.List;

public class OneCamera {
    public static final String TAG = "OneCamera";
    public Handler mHandler = new Handler(this.mHandlerThread.getLooper());
    public HandlerThread mHandlerThread;
    public OneCameraImplement mImpl;
    public Looper mLooper = this.mHandlerThread.getLooper();
    public boolean mReleased;

    public interface Task<T> {
        T run();
    }

    public OneCamera(final Context context, final OneCallbacks oneCallbacks, final Handler handler) {
        HandlerThread handlerThread = new HandlerThread("OneCamera");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl = new OneCameraImplement(OneCamera.this.mLooper, context, oneCallbacks, handler);
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
                StringBuilder a2 = a.a("[CameraWrapper] OneCameraImplement execute error: ");
                a2.append(thArr[0]);
                Log.e("OneCamera", a2.toString());
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
            StringBuilder a2 = a.a("[CameraWrapper] OneCameraImplement execute error: ");
            a2.append(tArr[0]);
            Log.e("OneCamera", a2.toString());
            ((Throwable) tArr[0]).printStackTrace();
            throw new RuntimeException((Throwable) tArr[0]);
        }
        throw new RuntimeException("Camera released");
    }

    private void waitNoncancelableTaskComplete() {
        while (((Boolean) syncExecuteTask(new Task() {
            public Boolean run() {
                return Boolean.valueOf(OneCamera.this.mImpl.isNoncancelableTaskRunning());
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
                jArr[0] = OneCamera.this.mImpl.calibrateGyro(calibrateGyro);
            }
        });
        return jArr[0];
    }

    public synchronized long cancelAuthorization() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.cancelAuthorization();
            }
        });
        return jArr[0];
    }

    public synchronized void captureStillImage(final TakePicture takePicture) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.captureStillImage(takePicture);
            }
        });
    }

    public synchronized void captureStillImageWithouStorage(final String str, final boolean z, final TakePicture takePicture) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.captureStillImageWithouStorage(str, z, takePicture);
            }
        });
    }

    public synchronized long checkAuthorization(final CheckAuthorization checkAuthorization) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.checkAuthorization(checkAuthorization);
            }
        });
        return jArr[0];
    }

    public synchronized void close(final Object obj) {
        waitNoncancelableTaskComplete();
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.close(obj);
            }
        });
    }

    public synchronized long closeCameraOled() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.closeCameraOled();
            }
        });
        return jArr[0];
    }

    public synchronized long closeCameraWifi() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.closeCameraWifi();
            }
        });
        return jArr[0];
    }

    public long closeIperf() {
        final long[] jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.closeIperf();
            }
        });
        return jArr[0];
    }

    public synchronized long connectBleDevice(final ConnectToBTPeripheral connectToBTPeripheral) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.connectBT(connectToBTPeripheral);
            }
        });
        return jArr[0];
    }

    public synchronized long deleteFileList(final DeleteFiles deleteFiles) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.deleteFileList(deleteFiles);
            }
        });
        return jArr[0];
    }

    public synchronized long disconnectBleDevice(final DisconnectBTPeripheral disconnectBTPeripheral) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.disConnectBT(disconnectBTPeripheral);
            }
        });
        return jArr[0];
    }

    public synchronized long eraseSDCard() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.eraseSDCard();
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
                jArr[0] = OneCamera.this.mImpl.getAllOptionsAsync();
            }
        });
        return jArr[0];
    }

    public synchronized long getConntectBleDevice(final GetConnectedBTPeripheral getConnectedBTPeripheral) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.getConnectBT(getConnectedBTPeripheral);
            }
        });
        return jArr[0];
    }

    public synchronized float[] getCurrentGyroMatrix() {
        return (float[]) syncExecuteTask(new Task<float[]>() {
            public float[] run() {
                return OneCamera.this.mImpl.getCurrentGyroMatrix();
            }
        });
    }

    public synchronized long getFileExtra(final GetFileExtra getFileExtra) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.getFileExtra(getFileExtra);
            }
        });
        return jArr[0];
    }

    public synchronized long getFileInfoList() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.getFileInfoList();
            }
        });
        return jArr[0];
    }

    public synchronized long getFileList(final GetFileList getFileList) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.getFileList(getFileList);
            }
        });
        return jArr[0];
    }

    @Deprecated
    public synchronized GetGyroResp getGyro(final GetGyro getGyro) {
        final GetGyroResp[] getGyroRespArr;
        getGyroRespArr = new GetGyroResp[1];
        syncExecute(new Runnable() {
            public void run() {
                getGyroRespArr[0] = OneCamera.this.mImpl.getGyro(getGyro);
            }
        });
        return getGyroRespArr[0];
    }

    public long getGyroAsync(final GetGyro getGyro) {
        final long[] jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.getGyroAsync(getGyro);
            }
        });
        return jArr[0];
    }

    public long getIperfAverage() {
        final long[] jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.getIperfAverage();
            }
        });
        return jArr[0];
    }

    public synchronized OneLatestIDR getLatestIDRFrame() {
        return (OneLatestIDR) syncExecuteTask(new Task<OneLatestIDR>() {
            public OneLatestIDR run() {
                return OneCamera.this.mImpl.getLatestIDRFrame();
            }
        });
    }

    public synchronized long getOptionsAsync(final List<String> list) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.getOptionsAsync(list);
            }
        });
        return jArr[0];
    }

    public synchronized long getPhotoOptionsAsync(final int i2) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.getPhotoOptionsAsync(i2);
            }
        });
        return jArr[0];
    }

    public synchronized int getPreviewHeight() {
        return ((Integer) syncExecuteTask(new Task<Integer>() {
            public Integer run() {
                return Integer.valueOf(OneCamera.this.mImpl.getPreviewHeight());
            }
        })).intValue();
    }

    public synchronized int getPreviewWidth() {
        return ((Integer) syncExecuteTask(new Task<Integer>() {
            public Integer run() {
                return Integer.valueOf(OneCamera.this.mImpl.getPreviewWidth());
            }
        })).intValue();
    }

    public synchronized long getRecordStatus() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.getCaptureStatus();
            }
        });
        return jArr[0];
    }

    public OpenState getStatus() {
        return this.mImpl.getStatus();
    }

    public synchronized Object getSurface() {
        return syncExecuteTask(new Task<Object>() {
            public Object run() {
                return OneCamera.this.mImpl.getSurface();
            }
        });
    }

    public synchronized Object getSurface2() {
        return syncExecuteTask(new Task<Object>() {
            public Object run() {
                return OneCamera.this.mImpl.getSurface2();
            }
        });
    }

    public synchronized long getSyncCaptureMode() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.getSyncCaptureMode();
            }
        });
        return jArr[0];
    }

    public synchronized long getTimelapseOptionsAsync(final GetTimelapseOptions getTimelapseOptions) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.getTimelapseOptionAsync(getTimelapseOptions);
            }
        });
        return jArr[0];
    }

    public synchronized int getTunelPort() {
        final int[] iArr;
        iArr = new int[1];
        syncExecute(new Runnable() {
            public void run() {
                iArr[0] = OneCamera.this.mImpl.getTunelPort();
            }
        });
        return iArr[0];
    }

    public synchronized void open(final String str) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.open(str);
            }
        });
    }

    public synchronized long openCameraOled() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.openCameraOled();
            }
        });
        return jArr[0];
    }

    public synchronized long openCameraWifi() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.openCameraWifi();
            }
        });
        return jArr[0];
    }

    public long openIperf(final int i2) {
        final long[] jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.openIperf(i2);
            }
        });
        return jArr[0];
    }

    public synchronized void openWifi(String str, int i2, String str2, short s) {
        final String str3 = str;
        final int i3 = i2;
        final String str4 = str2;
        final short s2 = s;
        AnonymousClass8 r0 = new Runnable() {
            public void run() {
                OneCamera.this.mImpl.openWifi(str3, i3, str4, s2);
            }
        };
        syncExecute(r0);
    }

    public synchronized void reboot() {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.reboot();
            }
        });
    }

    public synchronized void release() {
        String str = "OneCamera";
        StringBuilder sb = new StringBuilder();
        sb.append("release OneCamera: \n");
        sb.append(stackTraceToString(Thread.currentThread().getStackTrace()));
        Log.i(str, sb.toString());
        if (!this.mReleased) {
            waitNoncancelableTaskComplete();
            syncExecute(new Runnable() {
                public void run() {
                    OneCamera.this.mImpl.release();
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

    public synchronized void resetRecord(final Object obj) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.resetRecord(obj);
            }
        });
    }

    public synchronized long scanBleDevice(final ScanBTPeripheral scanBTPeripheral) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.scanBT(scanBTPeripheral);
            }
        });
        return jArr[0];
    }

    public synchronized void sendHeartBeat() {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.sendHeartBeat();
            }
        });
    }

    @Deprecated
    public synchronized void setAudioParam(boolean z, int i2, int i3, int i4) {
        final boolean z2 = z;
        final int i5 = i2;
        final int i6 = i3;
        final int i7 = i4;
        AnonymousClass18 r0 = new Runnable() {
            public void run() {
                OneCamera.this.mImpl.setAudioParam(z2, i5, i6, i7);
            }
        };
        syncExecute(r0);
    }

    public synchronized void setAudioSource(final AudioSource audioSource) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.setAudioSource(audioSource);
            }
        });
    }

    public void setCameraDevMode(final boolean z) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.setCameraDevMode(z);
            }
        });
    }

    public synchronized long setFileExtra(final SetFileExtra setFileExtra) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.setFileExtra(setFileExtra);
            }
        });
        return jArr[0];
    }

    public synchronized long setGPSData(final byte[] bArr) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.setGPSData(bArr);
            }
        });
        return jArr[0];
    }

    public synchronized void setGyroRebaseMatrix(final float[] fArr) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.setGyroRebaseMatrix(fArr);
            }
        });
    }

    public synchronized void setInfoUpdateListener(final Handler handler, final InfoUpdateListener infoUpdateListener) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.setInfoUpdateListener(handler, infoUpdateListener);
            }
        });
    }

    public synchronized long setOptionsAsync(final Options options) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.setOptionsAsync(options);
            }
        });
        return jArr[0];
    }

    public synchronized long setPhotoOptionsAsync(final int i2, final PhotoOptions photoOptions) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.setPhotoOptionsAsync(i2, photoOptions);
            }
        });
        return jArr[0];
    }

    public void setPipeline(final ICameraPreviewPipeline iCameraPreviewPipeline) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.setPipeline(iCameraPreviewPipeline);
            }
        });
    }

    public void setPlayerBackend(final PlayerBackend playerBackend) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.setPlayerBackend(playerBackend);
            }
        });
    }

    public synchronized void setPreviewDeltaNs(final long j2) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.setPreviewDeltaNs(j2);
            }
        });
    }

    public long setStandByMode(final int i2) {
        final long[] jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.setSyncStandByMode(i2);
            }
        });
        return jArr[0];
    }

    public void setSupportStreaming(final boolean z) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.setSupportStreaming(z);
            }
        });
    }

    public synchronized void setSurface(final Object obj) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.setSurface(obj);
            }
        });
    }

    public synchronized long setSyncCaptureMode(final int i2) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.setSyncCaptureMode(i2);
            }
        });
        return jArr[0];
    }

    public synchronized long setTimelapseOptionsAsync(final SetTimelapseOptions setTimelapseOptions) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.setTimelapseOptionAsync(setTimelapseOptions);
            }
        });
        return jArr[0];
    }

    public synchronized void setVideoParam(int i2, int i3, int i4, int i5, boolean z) {
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        final int i9 = i5;
        final boolean z2 = z;
        AnonymousClass11 r0 = new Runnable() {
            public void run() {
                OneCamera.this.mImpl.setVideoParam(i6, i7, i8, i9, z2);
            }
        };
        syncExecute(r0);
    }

    public long startBluetoothStatusTest() {
        final long[] jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.startBluetoothStatusTest();
            }
        });
        return jArr[0];
    }

    public synchronized int startBulletTime() {
        final int[] iArr;
        iArr = new int[1];
        syncExecute(new Runnable() {
            public void run() {
                iArr[0] = OneCamera.this.mImpl.startBulletTime();
            }
        });
        return iArr[0];
    }

    public synchronized void startHdrCapture() {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.startHdrCapture();
            }
        });
    }

    public long startLedTest() {
        final long[] jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.startLedTest();
            }
        });
        return jArr[0];
    }

    public synchronized int startRecord() {
        final int[] iArr;
        iArr = new int[1];
        syncExecute(new Runnable() {
            public void run() {
                iArr[0] = OneCamera.this.mImpl.startCaptureWithStorage();
            }
        });
        return iArr[0];
    }

    public synchronized void startRecordWithoutStorage(final StartCaptureWithoutStorage startCaptureWithoutStorage) {
        if (this.mImpl.getAVExtraData(startCaptureWithoutStorage)) {
            syncExecute(new Runnable() {
                public void run() {
                    OneCamera.this.mImpl.startCaptureWithoutStorage(startCaptureWithoutStorage);
                }
            });
        }
    }

    public long startSpeakerTest() {
        final long[] jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.startSpeakerTest();
            }
        });
        return jArr[0];
    }

    public synchronized long startStreaming(final StartStreamingParam startStreamingParam) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.startStreaming(startStreamingParam);
            }
        });
        return jArr[0];
    }

    public synchronized void startTimeplapse(final StartTimelapse startTimelapse) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.startTimeplapse(startTimelapse);
            }
        });
    }

    public long startWifiStatusTest() {
        final long[] jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.startWifiStatusTest();
            }
        });
        return jArr[0];
    }

    public synchronized void stopBulletTime(final byte[] bArr) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.stopBulletTime(bArr);
            }
        });
    }

    public synchronized void stopHdrCapture(final byte[] bArr) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.stopHdrCapture(bArr);
            }
        });
    }

    public synchronized void stopRecord(final byte[] bArr) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.stopRecord(bArr);
            }
        });
    }

    public synchronized long stopStreaming(final Object obj) {
        final long[] jArr;
        jArr = new long[1];
        waitNoncancelableTaskComplete();
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.stopStreaming(obj);
            }
        });
        return jArr[0];
    }

    public synchronized void stopTimeplapse(final StopTimelapse stopTimelapse) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.stopTimeplapse(stopTimelapse);
            }
        });
    }

    public synchronized void suggestApplyGyroStabilizer(final boolean z, final boolean z2) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.suggestApplyGyroStabilizer(z, z2);
            }
        });
    }

    public synchronized void switchRenderMode(final RenderMode renderMode) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.switchRenderMode(renderMode);
            }
        });
    }

    public synchronized long syncCaptureStatus() {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.syncCaptureStatus();
            }
        });
        return jArr[0];
    }

    public synchronized void takePhoto(final int i2, final int i3, final String str) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.takePhoto(i2, i3, str);
            }
        });
    }

    public synchronized long testSDCardSpeed(final TestSDCardSpeed testSDCardSpeed) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.testSDCardSpeed(testSDCardSpeed);
            }
        });
        return jArr[0];
    }

    public synchronized void updatePanoOffset(final String str) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.updatePanoOffset(str);
            }
        });
    }

    public synchronized long getPhotoOptionsAsync(final int i2, final List<String> list) {
        final long[] jArr;
        jArr = new long[1];
        syncExecute(new Runnable() {
            public void run() {
                jArr[0] = OneCamera.this.mImpl.getPhotoOptionsAsync(i2, list);
            }
        });
        return jArr[0];
    }

    public synchronized void setSurface(final Object obj, final Object obj2) {
        syncExecute(new Runnable() {
            public void run() {
                OneCamera.this.mImpl.setSurface(obj, obj2);
            }
        });
    }
}
