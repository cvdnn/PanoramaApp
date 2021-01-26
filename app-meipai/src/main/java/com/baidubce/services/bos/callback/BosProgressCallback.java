package com.baidubce.services.bos.callback;

import com.baidubce.callback.BceProgressCallback;
import com.baidubce.model.AbstractBceRequest;

public abstract class BosProgressCallback<T extends AbstractBceRequest> implements BceProgressCallback<T> {
    @Deprecated
    public void onProgress(long j2, long j3) {
    }

    public void onProgress(T t, long j2, long j3) {
        onProgress(j2, j3);
    }
}
