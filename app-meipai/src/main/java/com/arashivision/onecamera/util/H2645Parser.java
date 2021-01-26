package com.arashivision.onecamera.util;

import java.util.LinkedList;

public abstract class H2645Parser {
    public static final String TAG = "OneH2645Parser";
    public byte[] mCsd;
    public LinkedList<Payload> mParseBufQueue = new LinkedList<>();
    public byte[] mPps;
    public SPSCallback mSPSCallback;
    public byte[] mSps;
    public byte[] mVps;

    public enum FrameType {
        IDR,
        IFrame,
        Other
    }

    public static class H2645Frame {
        public byte[] data;
        public int offset;
        public int size;
        public FrameType type;

        public boolean isIDR() {
            return this.type == FrameType.IDR;
        }
    }

    public static class NalPos {
        public int end;
        public int start;
    }

    public static class Nalu {
        public byte[] buf;
        public int offset;
        public int size;
        public NaluType type;
    }

    public enum NaluType {
        UNKNOWN,
        VPS,
        SPS,
        PPS,
        SEI,
        DELIMITER,
        CODED_NON_IDR_SLICE,
        CODED_IDR_SLICE
    }

    public static class Payload {
        public byte[] buf;
        public int offset;
        public boolean oneNaluFound;
        public int size;
    }

    public interface SPSCallback {
        void onSpsUpdate(int i2, int i3, int i4, float f2);
    }

    public static byte[] dupBytes(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return bArr2;
    }

    public void feedData(byte[] bArr, int i2, int i3) {
        Payload payload = new Payload();
        payload.buf = bArr;
        payload.offset = i2;
        payload.size = i3;
        payload.oneNaluFound = false;
        this.mParseBufQueue.add(payload);
    }

    public abstract boolean findNalUnit(byte[] bArr, int i2, int i3, NalPos nalPos, boolean z);

    public byte[] getCsdData() {
        return this.mCsd;
    }

    public abstract NaluType naluType(byte[] bArr, int i2);

    public void parseSps() {
        if (this.mSPSCallback != null) {
            int[] iArr = new int[2];
            int[] iArr2 = {-1};
            float[] fArr = new float[1];
            if (spsParse(this.mSps, iArr, iArr2, fArr) == 0) {
                this.mSPSCallback.onSpsUpdate(iArr[0], iArr[1], iArr2[0], fArr[0]);
            }
        }
    }

    public abstract boolean readFrame(H2645Frame h2645Frame);

    public abstract boolean readNalu(Nalu nalu);

    public void reset() {
        this.mParseBufQueue.clear();
        this.mVps = null;
        this.mSps = null;
        this.mPps = null;
        this.mCsd = null;
    }

    public void setOriginalCSD(byte[] bArr) {
        this.mCsd = bArr;
    }

    public void setSpsCallback(SPSCallback sPSCallback) {
        this.mSPSCallback = sPSCallback;
    }

    public abstract int spsParse(byte[] bArr, int[] iArr, int[] iArr2, float[] fArr);
}
