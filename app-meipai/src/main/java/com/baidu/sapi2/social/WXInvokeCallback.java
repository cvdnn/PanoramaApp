package com.baidu.sapi2.social;

import android.content.Intent;
import com.baidu.sapi2.NoProguard;

public abstract class WXInvokeCallback implements NoProguard {
    public abstract void onResult(int i2, Intent intent);
}
