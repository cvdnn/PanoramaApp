package com.baidu.sapi2.shell.listener;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.shell.result.WebAuthResult;

public abstract class WebAuthListener implements SapiCallback<WebAuthResult> {
    public void beforeSuccess(SapiAccount sapiAccount) {
    }

    public void onFinish() {
    }

    public void onStart() {
    }
}
