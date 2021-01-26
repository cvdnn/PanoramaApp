package com.arashivision.graphicpath.render.util;

import com.arashivision.graphicpath.render.source.Asset;
import com.arashivision.graphicpath.render.source.ResolveGyroOptions;

public class SingleGyroStabilizer extends Stabilizer {
    public SingleGyroStabilizer(long j2) {
        super(j2, "SingleGyroStabilizer");
    }

    public static native SingleGyroStabilizer nativeResolveSingleStabilizer(Asset asset, ResolveGyroOptions resolveGyroOptions);

    public static SingleGyroStabilizer resolveSingleStabilizer(Asset asset, ResolveGyroOptions resolveGyroOptions) {
        return nativeResolveSingleStabilizer(asset, resolveGyroOptions);
    }
}
