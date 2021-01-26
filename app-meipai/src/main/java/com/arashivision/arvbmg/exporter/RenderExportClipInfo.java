package com.arashivision.arvbmg.exporter;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;

public class RenderExportClipInfo extends BMGNativeObjectRef {
    public RenderExportClipInfo(RenderModel renderModel, int i2, boolean z, boolean z2, float f2, float f3, boolean z3, float f4, int i3, boolean z4) {
        this(createNativeWrap(renderModel, i2, z, z2, f2, f3, z3, f4, i3, z4));
    }

    public static native long createNativeWrap(RenderModel renderModel, int i2, boolean z, boolean z2, float f2, float f3, boolean z3, float f4, int i3, boolean z4);

    public RenderExportClipInfo(long j2) {
        super(j2, "RenderExportClipInfo");
    }
}
