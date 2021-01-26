package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.NormalizeGuestAccountResult;

public interface NormalizeGuestAccountCallback {
    void onFailure(NormalizeGuestAccountResult normalizeGuestAccountResult);

    void onSuccess(NormalizeGuestAccountResult normalizeGuestAccountResult);
}
