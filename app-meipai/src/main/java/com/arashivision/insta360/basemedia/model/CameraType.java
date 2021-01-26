package com.arashivision.insta360.basemedia.model;

import com.arashivision.graphicpath.render.base.InstaCameraName;

public enum CameraType {
    ONE(InstaCameraName.One),
    ONEX(InstaCameraName.OneX),
    ONEX2("Insta360 ONE X2"),
    EVO(InstaCameraName.EVO),
    AKIKO("Insta360 OneR"),
    GO(InstaCameraName.GO),
    NANOS(InstaCameraName.NanoS),
    UNKNOWN("");
    
    public final String type;

    /* access modifiers changed from: public */
    CameraType(String str) {
        this.type = str;
    }

    public static CameraType getForType(String str) {
        CameraType[] values;
        for (CameraType cameraType : values()) {
            if (cameraType.type.equals(str)) {
                return cameraType;
            }
        }
        return UNKNOWN;
    }
}
