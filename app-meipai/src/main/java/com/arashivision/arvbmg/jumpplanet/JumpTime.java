package com.arashivision.arvbmg.jumpplanet;

import e.a.a.a.a;

public class JumpTime {
    public long trimEnd;
    public long trimStart;

    public void setTrimEnd(long j2) {
        this.trimEnd = j2;
    }

    public void setTrimStart(long j2) {
        this.trimStart = j2;
    }

    public String toString() {
        StringBuilder a2 = a.a("JumpTime{trimStrat=");
        a2.append(this.trimStart);
        a2.append(", trimEnd=");
        a2.append(this.trimEnd);
        a2.append('}');
        return a2.toString();
    }
}
