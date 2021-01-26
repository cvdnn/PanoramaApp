package com.baidu.mobstat;

import android.content.Context;

public class GetReverse {

    /* renamed from: a reason: collision with root package name */
    public static ICooperService f1415a;

    public static ICooperService getCooperService(Context context) {
        if (f1415a == null) {
            f1415a = CooperService.instance();
        }
        return f1415a;
    }
}
