package com.arashivision.arvbmg.rolling;

import e.a.a.a.a;
import java.util.Arrays;

public class RollingTrimInfo {
    public int code;
    public RollingTime[] times;

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setTimes(RollingTime[] rollingTimeArr) {
        this.times = rollingTimeArr;
    }

    public String toString() {
        StringBuilder a2 = a.a("RollingTrimInfo{code=");
        a2.append(this.code);
        a2.append(", times=");
        a2.append(Arrays.toString(this.times));
        a2.append('}');
        return a2.toString();
    }
}
