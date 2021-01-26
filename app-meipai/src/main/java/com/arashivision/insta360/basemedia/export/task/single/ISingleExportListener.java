package com.arashivision.insta360.basemedia.export.task.single;

import com.arashivision.insta360.basemedia.export.IExportListener;

public interface ISingleExportListener extends IExportListener {
    void onFileSizeChanged(int i2, String str, long j2);

    void onNotify(int i2);

    void onProgress(int i2, float f2);
}
