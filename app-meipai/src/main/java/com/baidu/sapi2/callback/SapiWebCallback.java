package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;

public interface SapiWebCallback<R extends SapiResult> {
    void onFinish(R r);
}
