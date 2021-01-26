package com.arashivision.onestream;

import java.util.LinkedList;

public class AdtsParser {
    public byte[] mCsd;
    public LinkedList<Frame> mFrames = new LinkedList<>();
    public LinkedList<Payload> mInputs = new LinkedList<>();
    public long mNativeInstance;

    public static class Frame {
        public byte[] data;
        public int offset;
        public int size;

        public Frame(byte[] bArr, int i2, int i3) {
            this.data = bArr;
            this.offset = i2;
            this.size = i3;
        }
    }

    public static class Payload {
        public byte[] data;
        public int offset;
        public int size;

        public Payload(byte[] bArr, int i2, int i3) {
            this.data = bArr;
            this.offset = i2;
            this.size = i3;
        }
    }

    public AdtsParser() {
        nativeInit();
    }

    private native byte[] nativeExtraData();

    private native int nativeInit();

    private native byte[][] nativeParse(byte[] bArr, int i2, int i3);

    private void parseInputs() {
        while (!this.mInputs.isEmpty()) {
            Payload payload = (Payload) this.mInputs.removeFirst();
            byte[][] nativeParse = nativeParse(payload.data, payload.offset, payload.size);
            if (!(nativeParse == null || nativeParse.length == 0)) {
                for (byte[] bArr : nativeParse) {
                    this.mFrames.add(new Frame(bArr, 0, bArr.length));
                }
            }
        }
    }

    public byte[] csd() {
        if (this.mCsd == null) {
            parseInputs();
            this.mCsd = nativeExtraData();
        }
        return this.mCsd;
    }

    public void feedData(byte[] bArr, int i2, int i3) {
        this.mInputs.add(new Payload(bArr, i2, i3));
    }

    public Frame readFrame() {
        if (this.mFrames.isEmpty()) {
            parseInputs();
        }
        if (this.mFrames.isEmpty()) {
            return null;
        }
        return (Frame) this.mFrames.removeFirst();
    }
}
