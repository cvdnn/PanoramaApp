package com.arashivision.sdkmedia.export;

public interface IExportCallback {
    void onCancel();

    void onFail();

    void onProgress(float f2);

    void onSuccess();
}
