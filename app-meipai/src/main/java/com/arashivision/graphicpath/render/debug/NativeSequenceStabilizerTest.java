package com.arashivision.graphicpath.render.debug;

import com.arashivision.graphicpath.render.HybridRender;
import com.arashivision.graphicpath.render.util.SequenceStabilizer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class NativeSequenceStabilizerTest {
    public static native void CheckIfOutofBoundryTest(SequenceStabilizer sequenceStabilizer);

    public static native void caputreImgageTest(HybridRender hybridRender, int i2, int i3, String str);

    public static byte[] convertDoubleToByte(double[] dArr) {
        byte[] bArr = new byte[(dArr.length * 8)];
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (double putDouble : dArr) {
            order.putDouble(putDouble);
        }
        return bArr;
    }
}
