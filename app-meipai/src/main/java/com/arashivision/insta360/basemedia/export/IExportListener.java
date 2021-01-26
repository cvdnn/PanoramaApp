package com.arashivision.insta360.basemedia.export;

public interface IExportListener {
    void onCancel(int i2);

    void onComplete(int i2);

    void onError(int i2, int i3, String str);
}
