package com.baidu.sapi2.views;

import android.content.BroadcastReceiver;
import com.baidu.sapi2.callback.RequestSMSCallback;

/* compiled from: SmsLoginView */
public class j extends RequestSMSCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SmsLoginView f3219a;

    public j(SmsLoginView smsLoginView) {
        this.f3219a = smsLoginView;
    }

    public void receiverResult(BroadcastReceiver broadcastReceiver) {
        this.f3219a.r = broadcastReceiver;
    }
}
