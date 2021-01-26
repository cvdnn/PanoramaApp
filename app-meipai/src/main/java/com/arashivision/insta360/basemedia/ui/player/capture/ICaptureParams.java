package com.arashivision.insta360.basemedia.ui.player.capture;

import a.a.a.a.e.a.d;
import a.a.a.a.e.a.e.k.a;
import a.a.a.a.e.a.e.k.b;
import a.a.a.a.e.a.e.k.f;
import a.a.a.a.e.a.e.k.g;
import a.a.a.a.e.a.e.k.j;
import com.arashivision.graphicpath.render.source.AssetInfo;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;

public interface ICaptureParams extends d, a, f, j, b, g, Cloneable {
    /* bridge */ /* synthetic */ b clone();

    ICaptureParams clone();

    int getCameraFacing();

    String getCameraType();

    Constraint getConstraint();

    int[] getConstraintRatio();

    int getFitMode();

    int getFps();

    int getGyroType();

    long getPreviewDelayNs();

    int getRotateDegree();

    int[] getScreenRatio();

    int getStabType();

    boolean isRotateEnabled();

    boolean isRotateScreenRatioEnabled();

    void setAssetInfo(AssetInfo assetInfo);

    void setCameraFacing(int i2);

    void setCameraType(String str);

    void setConstraint(Constraint constraint);

    void setConstraintRatio(int[] iArr);

    void setDualStream(boolean z);

    void setFileType(FileType fileType);

    void setFitMode(int i2);

    void setFps(int i2);

    void setGyroType(int i2);

    void setInstaMedia(boolean z);

    void setPreviewDelayNs(long j2);

    void setRotateDegree(int i2);

    void setRotateEnabled(boolean z);

    void setRotateScreenRatioEnabled(boolean z);

    void setScreenRatio(int[] iArr);

    void setStabType(int i2);

    void updateStabilizer(int i2);
}
