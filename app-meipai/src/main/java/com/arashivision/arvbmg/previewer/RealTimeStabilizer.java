package com.arashivision.arvbmg.previewer;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.graphicpath.render.Stabilization.ExposureRawItem;
import com.arashivision.graphicpath.render.Stabilization.GyroRawItem;
import com.arashivision.graphicpath.render.Stabilization.RealTimeExposureRawData;
import com.arashivision.graphicpath.render.Stabilization.RealTimeGyroRawData;
import com.arashivision.graphicpath.render.source.Source;
import com.arashivision.graphicpath.render.util.SequenceStabilizer;

public class RealTimeStabilizer {
    public Handler mHandler = new Handler(this.mHandlerThread.getLooper());
    public HandlerThread mHandlerThread;
    public RealTimeExposureRawData mRealTimeExposureRawData;
    public RealTimeGyroRawData mRealTimeGyroRawData;
    public boolean mReleased;
    public SequenceStabilizer mSequenceStabilizer;

    public RealTimeStabilizer(int i2, int i3, String str, long j2, int i4, int i5) {
        HandlerThread handlerThread = new HandlerThread("RealTimeStabilizer");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mRealTimeGyroRawData = RealTimeGyroRawData.CreateRealTimeGyroRawData(i3);
        RealTimeExposureRawData CreateRealTimeExposureRawData = RealTimeExposureRawData.CreateRealTimeExposureRawData(0);
        this.mRealTimeExposureRawData = CreateRealTimeExposureRawData;
        SequenceStabilizer createSequenceStabilizer2 = Source.createSequenceStabilizer2(this.mRealTimeGyroRawData, CreateRealTimeExposureRawData, i2, i3, i4, i5);
        this.mSequenceStabilizer = createSequenceStabilizer2;
        createSequenceStabilizer2.setSourceOffset(str);
        this.mSequenceStabilizer.setBidirectionOptimize(false);
        this.mSequenceStabilizer.setBatchConsumeCount(50);
        setDelayTimeMs(j2);
    }

    public void feedExposure(long j2, double d2) {
        ExposureRawItem exposureRawItem = new ExposureRawItem();
        exposureRawItem.timestamp = j2;
        exposureRawItem.shutterSpeeds = d2;
        this.mRealTimeExposureRawData.Feed(exposureRawItem);
    }

    public void feedGyro(byte[] bArr) {
        this.mRealTimeGyroRawData.Feed(GyroRawItem.FromByteArray(bArr));
        this.mHandler.post(new Runnable() {
            public void run() {
                RealTimeStabilizer.this.mSequenceStabilizer.loadRealTimeData();
            }
        });
    }

    public void finalize() throws Throwable {
        if (this.mReleased) {
            super.finalize();
            return;
        }
        throw new IllegalStateException("RealTImeStabilizer not release before finalize ");
    }

    public RealTimeExposureRawData getRealTimeExposureRawData() {
        return this.mRealTimeExposureRawData;
    }

    public SequenceStabilizer getSequenceStabilizer() {
        return this.mSequenceStabilizer;
    }

    public void release() {
        if (!this.mReleased) {
            this.mReleased = true;
            this.mHandlerThread.quit();
            try {
                this.mHandlerThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.mHandlerThread = null;
            this.mHandler = null;
        }
    }

    public void setDelayTimeMs(long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(" previewDeltaNs is ");
        sb.append(j2);
        Log.i(BMGConstants.TAG, sb.toString());
        this.mSequenceStabilizer.setDelayTimeMs((float) (j2 / 1000000));
    }
}
