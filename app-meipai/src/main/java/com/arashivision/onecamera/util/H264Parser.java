package com.arashivision.onecamera.util;

import android.util.Log;
import com.arashivision.onecamera.util.H2645Parser.FrameType;
import com.arashivision.onecamera.util.H2645Parser.H2645Frame;
import com.arashivision.onecamera.util.H2645Parser.NalPos;
import com.arashivision.onecamera.util.H2645Parser.Nalu;
import com.arashivision.onecamera.util.H2645Parser.NaluType;
import com.arashivision.onecamera.util.H2645Parser.Payload;
import java.util.ListIterator;

public class H264Parser extends H2645Parser {
    public static final String TAG = "OneH264Parser";

    public boolean findNalUnit(byte[] bArr, int i2, int i3, NalPos nalPos, boolean z) {
        int i4 = i3 + i2;
        if (i2 + 4 >= i4) {
            return false;
        }
        do {
            if ((bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 1) || (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 0 && bArr[i2 + 3] == 1)) {
                nalPos.start = i2;
                if (bArr[i2 + 2] != 1) {
                    i2++;
                }
                int i5 = i2 + 3;
                NaluType naluType = naluType(bArr, nalPos.start);
                if (!(naluType == NaluType.DELIMITER || naluType == NaluType.SEI || naluType == NaluType.SPS || naluType == NaluType.PPS)) {
                    nalPos.end = i4;
                }
                while (true) {
                    int i6 = i5 + 2;
                    if (i6 >= i4) {
                        if (!z) {
                            return false;
                        }
                        nalPos.end = i4;
                        return true;
                    } else if (!((bArr[i5] == 0 && bArr[i5 + 1] == 0 && bArr[i6] == 1) || (bArr[i5] == 0 && bArr[i5 + 1] == 0 && bArr[i6] == 0))) {
                        i5++;
                    }
                }
                nalPos.end = i5;
                return true;
            }
            i2++;
        } while (i2 + 4 < i4);
        return false;
    }

    public NaluType naluType(byte[] bArr, int i2) {
        byte b2 = bArr[bArr[i2 + 2] == 0 ? i2 + 4 : i2 + 3] & 31;
        if (b2 == 9) {
            return NaluType.DELIMITER;
        }
        if (b2 == 6) {
            return NaluType.SEI;
        }
        if (b2 == 7) {
            return NaluType.SPS;
        }
        if (b2 == 8) {
            return NaluType.PPS;
        }
        if (b2 == 1) {
            return NaluType.CODED_NON_IDR_SLICE;
        }
        if (b2 == 5) {
            return NaluType.CODED_IDR_SLICE;
        }
        return NaluType.UNKNOWN;
    }

    public boolean readFrame(H2645Frame h2645Frame) {
        Nalu nalu = new Nalu();
        while (readNalu(nalu)) {
            NaluType naluType = nalu.type;
            if (naluType == NaluType.SPS || naluType == NaluType.PPS) {
                if (this.mCsd == null) {
                    NaluType naluType2 = nalu.type;
                    if (naluType2 == NaluType.SPS) {
                        this.mSps = H2645Parser.dupBytes(nalu.buf, nalu.offset, nalu.size);
                        parseSps();
                    } else if (naluType2 == NaluType.PPS) {
                        this.mPps = H2645Parser.dupBytes(nalu.buf, nalu.offset, nalu.size);
                    }
                    byte[] bArr = this.mSps;
                    if (bArr != null) {
                        byte[] bArr2 = this.mPps;
                        if (bArr2 != null) {
                            byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
                            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                            byte[] bArr4 = this.mPps;
                            System.arraycopy(bArr4, 0, bArr3, this.mSps.length, bArr4.length);
                            this.mCsd = bArr3;
                        }
                    }
                }
            } else if (naluType == NaluType.CODED_IDR_SLICE) {
                byte[] bArr5 = this.mCsd;
                if (bArr5 != null) {
                    byte[] bArr6 = new byte[(bArr5.length + nalu.size)];
                    h2645Frame.data = bArr6;
                    System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
                    System.arraycopy(nalu.buf, nalu.offset, h2645Frame.data, this.mCsd.length, nalu.size);
                    h2645Frame.offset = 0;
                    h2645Frame.size = this.mCsd.length + nalu.size;
                    h2645Frame.type = FrameType.IDR;
                    return true;
                }
                Log.e(TAG, " mCsd null, iframe?");
                int i2 = nalu.size;
                byte[] bArr7 = new byte[i2];
                h2645Frame.data = bArr7;
                System.arraycopy(nalu.buf, nalu.offset, bArr7, 0, i2);
                h2645Frame.offset = 0;
                h2645Frame.size = nalu.size;
                h2645Frame.type = FrameType.IFrame;
                return true;
            } else if (!(naluType == NaluType.DELIMITER || naluType == NaluType.SEI)) {
                int i3 = nalu.size;
                byte[] bArr8 = new byte[i3];
                h2645Frame.data = bArr8;
                System.arraycopy(nalu.buf, nalu.offset, bArr8, 0, i3);
                h2645Frame.offset = 0;
                h2645Frame.size = nalu.size;
                h2645Frame.type = FrameType.Other;
                return true;
            }
        }
        return false;
    }

    public boolean readNalu(Nalu nalu) {
        ListIterator listIterator = this.mParseBufQueue.listIterator();
        NalPos nalPos = new NalPos();
        while (listIterator.hasNext()) {
            Payload payload = (Payload) listIterator.next();
            if (!findNalUnit(payload.buf, payload.offset, payload.size, nalPos, true)) {
                if (!payload.oneNaluFound) {
                    Log.w(TAG, "payload is not NAL unit, dropped");
                }
                listIterator.remove();
            } else {
                byte[] bArr = payload.buf;
                nalu.buf = bArr;
                int i2 = nalPos.start;
                nalu.offset = i2;
                nalu.size = nalPos.end - i2;
                nalu.type = naluType(bArr, i2);
                int i3 = payload.offset + payload.size;
                int i4 = nalPos.end;
                payload.size = i3 - i4;
                payload.offset = i4;
                payload.oneNaluFound = true;
                return true;
            }
        }
        return false;
    }

    public int spsParse(byte[] bArr, int[] iArr, int[] iArr2, float[] fArr) {
        return SPSPPSParser.nativeParse(this.mSps, iArr, iArr2, fArr);
    }
}
