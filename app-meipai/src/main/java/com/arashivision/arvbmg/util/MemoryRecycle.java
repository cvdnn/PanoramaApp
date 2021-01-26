package com.arashivision.arvbmg.util;

public class MemoryRecycle {
    static {
        ARVBMGLibsLoader.load();
    }

    public static native long recycleMemory(long j2, long j3, int i2);
}
