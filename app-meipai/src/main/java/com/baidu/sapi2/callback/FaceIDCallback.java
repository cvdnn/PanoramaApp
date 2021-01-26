package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;

public abstract class FaceIDCallback<R extends SapiResult> {
    public abstract void onFailure(R r);

    public abstract void onSuccess(R r);
}
