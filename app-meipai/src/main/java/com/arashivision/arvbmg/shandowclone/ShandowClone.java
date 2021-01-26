package com.arashivision.arvbmg.shandowclone;

import com.arashivision.arvbmg.exporter.FrameExporterSample;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.render.util.Stabilizer;
import java.util.List;

public class ShandowClone extends BMGNativeObjectRef {
    public boolean isRelease;

    public ShandowClone() {
        this(nativeCreateObj());
    }

    public static native long nativeCreateObj();

    private native void nativeFinishProcess();

    private native long nativeGetFrame(FrameExporterSample frameExporterSample);

    private native boolean nativeInit(String[] strArr, ShandowCloneCfg shandowCloneCfg, Stabilizer stabilizer);

    private native long[] nativeInputTracks(List<TrackTarget> list);

    private native boolean nativeIsCircleMove();

    private native int nativeMoveDirection();

    private native boolean nativePrepareExportInfo(ShandowCloneExportInfo shandowCloneExportInfo);

    private native void nativeProcessShadow(FrameExporterSample frameExporterSample);

    private native void nativeRelease();

    private native void nativeSetDebug(boolean z);

    public void finalize() throws Throwable {
        if (!this.isRelease) {
            release();
            this.isRelease = true;
        }
        super.finalize();
    }

    public void finishProcess() {
        nativeFinishProcess();
    }

    public FrameExporterSample getFrame(FrameExporterSample frameExporterSample) {
        long nativeGetFrame = nativeGetFrame(frameExporterSample);
        if (nativeGetFrame == -1) {
            return null;
        }
        return new FrameExporterSample(nativeGetFrame);
    }

    public int getMoveDirection() {
        return nativeMoveDirection();
    }

    public boolean init(String[] strArr, ShandowCloneCfg shandowCloneCfg) {
        return nativeInit(strArr, shandowCloneCfg, shandowCloneCfg.stabilizer);
    }

    public long[] inputTrackTargets(List<TrackTarget> list) {
        return nativeInputTracks(list);
    }

    public boolean isCircleMove() {
        return nativeIsCircleMove();
    }

    public boolean prepareExportInfo(ShandowCloneExportInfo shandowCloneExportInfo) {
        return nativePrepareExportInfo(shandowCloneExportInfo);
    }

    public void processShadow(FrameExporterSample frameExporterSample) {
        nativeProcessShadow(frameExporterSample);
    }

    public void release() {
        nativeRelease();
    }

    public void setDebug(boolean z) {
        nativeSetDebug(z);
    }

    public ShandowClone(long j2) {
        super(j2, "ShandowClone");
        this.isRelease = false;
    }
}
