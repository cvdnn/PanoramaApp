package com.arashivision.onecamera.util;

import android.util.Log;
import com.arashivision.onecamera.util.H2645Parser.FrameType;
import com.arashivision.onecamera.util.H2645Parser.H2645Frame;
import com.arashivision.onecamera.util.H2645Parser.NalPos;
import com.arashivision.onecamera.util.H2645Parser.Nalu;
import com.arashivision.onecamera.util.H2645Parser.NaluType;
import com.arashivision.onecamera.util.H2645Parser.Payload;
import e.a.a.a.a;
import java.util.ListIterator;

public class H265Parser extends H2645Parser {
    public static final String TAG = "OneH265Parser";

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
                if (!(naluType == NaluType.DELIMITER || naluType == NaluType.SEI || naluType == NaluType.SPS || naluType == NaluType.PPS || naluType == NaluType.VPS)) {
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
        int i3 = (bArr[bArr[i2 + 2] == 0 ? i2 + 4 : i2 + 3] & Byte.MAX_VALUE) >> 1;
        if (i3 == 32) {
            return NaluType.VPS;
        }
        if (i3 == 33) {
            return NaluType.SPS;
        }
        if (i3 == 34) {
            return NaluType.PPS;
        }
        if (i3 == 1) {
            return NaluType.CODED_NON_IDR_SLICE;
        }
        if (i3 == 19 || i3 == 20) {
            return NaluType.CODED_IDR_SLICE;
        }
        if (i3 == 39 || i3 == 40) {
            return NaluType.SEI;
        }
        return NaluType.UNKNOWN;
    }

    public boolean readFrame(H2645Frame h2645Frame) {
        Nalu nalu = new Nalu();
        while (readNalu(nalu)) {
            NaluType naluType = nalu.type;
            if (naluType != NaluType.SPS && naluType != NaluType.PPS && naluType != NaluType.VPS) {
                NaluType naluType2 = NaluType.CODED_IDR_SLICE;
                String str = TAG;
                if (naluType == naluType2) {
                    byte[] bArr = this.mCsd;
                    if (bArr != null) {
                        byte[] bArr2 = new byte[(bArr.length + nalu.size)];
                        h2645Frame.data = bArr2;
                        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                        System.arraycopy(nalu.buf, nalu.offset, h2645Frame.data, this.mCsd.length, nalu.size);
                        h2645Frame.offset = 0;
                        h2645Frame.size = this.mCsd.length + nalu.size;
                        h2645Frame.type = FrameType.IDR;
                    } else {
                        Log.e(str, "h265 mCsd null, iframe?");
                        int i2 = nalu.size;
                        byte[] bArr3 = new byte[i2];
                        h2645Frame.data = bArr3;
                        System.arraycopy(nalu.buf, nalu.offset, bArr3, 0, i2);
                        h2645Frame.offset = 0;
                        h2645Frame.size = nalu.size;
                        h2645Frame.type = FrameType.IFrame;
                    }
                    return true;
                } else if (naluType == NaluType.CODED_NON_IDR_SLICE) {
                    int i3 = nalu.size;
                    byte[] bArr4 = new byte[i3];
                    h2645Frame.data = bArr4;
                    System.arraycopy(nalu.buf, nalu.offset, bArr4, 0, i3);
                    h2645Frame.offset = 0;
                    h2645Frame.size = nalu.size;
                    h2645Frame.type = FrameType.Other;
                    return true;
                } else {
                    StringBuilder a2 = a.a(" non-nal nalu.type ");
                    a2.append(nalu.type);
                    Log.e(str, a2.toString());
                }
            } else if (this.mCsd == null) {
                NaluType naluType3 = nalu.type;
                if (naluType3 == NaluType.VPS) {
                    this.mVps = H2645Parser.dupBytes(nalu.buf, nalu.offset, nalu.size);
                } else if (naluType3 == NaluType.SPS) {
                    this.mSps = H2645Parser.dupBytes(nalu.buf, nalu.offset, nalu.size);
                    parseSps();
                } else if (naluType3 == NaluType.PPS) {
                    this.mPps = H2645Parser.dupBytes(nalu.buf, nalu.offset, nalu.size);
                }
                byte[] bArr5 = this.mVps;
                if (bArr5 != null) {
                    byte[] bArr6 = this.mSps;
                    if (bArr6 != null) {
                        byte[] bArr7 = this.mPps;
                        if (bArr7 != null) {
                            byte[] bArr8 = new byte[(bArr5.length + bArr6.length + bArr7.length)];
                            System.arraycopy(bArr5, 0, bArr8, 0, bArr5.length);
                            byte[] bArr9 = this.mSps;
                            System.arraycopy(bArr9, 0, bArr8, this.mVps.length, bArr9.length);
                            byte[] bArr10 = this.mPps;
                            System.arraycopy(bArr10, 0, bArr8, this.mVps.length + this.mSps.length, bArr10.length);
                            this.mCsd = bArr8;
                        }
                    }
                }
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
        return SPSPPSParser.nativeParseH265(this.mSps, iArr, iArr2, fArr);
    }
}
