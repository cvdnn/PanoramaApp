package com.arashivision.graphicpath.render.source;

import com.arashivision.insbase.nativeref.NativeBuffer;
import java.nio.charset.StandardCharsets;

public class MetadataValue {
    public NativeBuffer mBufferValue;

    public MetadataValue(NativeBuffer nativeBuffer) {
        this.mBufferValue = nativeBuffer;
    }

    public NativeBuffer getBuffer() {
        return this.mBufferValue;
    }

    public byte[] getBufferOfBytes() {
        NativeBuffer nativeBuffer = this.mBufferValue;
        return nativeBuffer.get(0, (int) nativeBuffer.size(), new byte[((int) this.mBufferValue.size())], 0);
    }

    public String getString() {
        return new String(getBufferOfBytes(), StandardCharsets.UTF_8);
    }

    public void setBuffer(NativeBuffer nativeBuffer) {
        this.mBufferValue = nativeBuffer;
    }

    public void setBufferOfBytes(byte[] bArr, int i2) {
        NativeBuffer createEmptyBuffer = NativeBuffer.createEmptyBuffer((long) (bArr.length - i2));
        this.mBufferValue = createEmptyBuffer;
        createEmptyBuffer.set(0, (int) createEmptyBuffer.size(), bArr, i2);
    }

    public void setString(String str) {
        setBufferOfBytes(str.getBytes(StandardCharsets.UTF_8), 0);
    }

    public MetadataValue(byte[] bArr, int i2) {
        setBufferOfBytes(bArr, i2);
    }

    public MetadataValue(String str) {
        setString(str);
    }
}
