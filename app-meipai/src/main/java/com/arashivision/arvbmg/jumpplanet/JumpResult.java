package com.arashivision.arvbmg.jumpplanet;

import e.a.a.a.a;
import java.util.Arrays;

public class JumpResult {
    public int code;
    public float[] quats;
    public long timestamp;

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setQuats(float[] fArr) {
        this.quats = fArr;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public String toString() {
        StringBuilder a2 = a.a("JumpResult{code=");
        a2.append(this.code);
        a2.append(", timestamp=");
        a2.append(this.timestamp);
        a2.append(", quats=");
        a2.append(Arrays.toString(this.quats));
        a2.append('}');
        return a2.toString();
    }
}
