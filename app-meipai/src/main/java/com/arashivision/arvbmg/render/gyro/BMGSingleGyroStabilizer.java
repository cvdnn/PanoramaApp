package com.arashivision.arvbmg.render.gyro;

import com.arashivision.graphicpath.render.source.Asset;

public class BMGSingleGyroStabilizer extends BMGStabilizer {
    public BMGSingleGyroStabilizer(long j2) {
        super(j2);
    }

    public static native BMGSingleGyroStabilizer nativeResolveSingleStabilizer(Asset asset, ResolveGyroOptions resolveGyroOptions);

    public static BMGSingleGyroStabilizer resolveSingleStabilizer(Asset asset, ResolveGyroOptions resolveGyroOptions) {
        return nativeResolveSingleStabilizer(asset, resolveGyroOptions);
    }
}
