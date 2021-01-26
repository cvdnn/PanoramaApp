package com.arashivision.graphicpath.insmedia.previewer2;

import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.insbase.nativeref.NativeObjectRef;
import e.a.a.a.a;
import java.util.Arrays;

public class VideoTimePicker extends NativeObjectRef {

    public static class VideoTimeSequence {
        public double[] timeMsSeqs;

        public VideoTimeSequence(int i2) {
            this.timeMsSeqs = new double[i2];
        }

        public double[] getTsSeqs() {
            return this.timeMsSeqs;
        }

        public String toString() {
            double[] dArr = this.timeMsSeqs;
            int length = dArr != null ? dArr.length : 0;
            StringBuilder a2 = a.a("VideoTimeSequence length(");
            a2.append(String.valueOf(length));
            a2.append("): ");
            a2.append(Arrays.toString(this.timeMsSeqs));
            return a2.toString();
        }
    }

    static {
        RenderLibsLoader.load();
    }

    public VideoTimePicker(long j2) {
        super(j2, "VideoTimePicker");
    }

    public static native long createNativeWrap();

    private native int nativeCalculate(PreviewerSource previewerSource);

    private native double[] nativeGetClipResult(int i2, double[] dArr);

    private native int nativeGetClipResultSize(int i2);

    private native int nativeGetResultSize();

    public int calculate(PreviewerSource previewerSource) {
        return nativeCalculate(previewerSource);
    }

    public VideoTimeSequence[] getResult() {
        int nativeGetResultSize = nativeGetResultSize();
        VideoTimeSequence[] videoTimeSequenceArr = new VideoTimeSequence[nativeGetResultSize];
        for (int i2 = 0; i2 < nativeGetResultSize; i2++) {
            int nativeGetClipResultSize = nativeGetClipResultSize(i2);
            videoTimeSequenceArr[i2] = new VideoTimeSequence(nativeGetClipResultSize);
            if (nativeGetClipResultSize > 0) {
                nativeGetClipResult(i2, videoTimeSequenceArr[i2].getTsSeqs());
            }
        }
        return videoTimeSequenceArr;
    }

    public VideoTimePicker() {
        this(createNativeWrap());
    }
}
