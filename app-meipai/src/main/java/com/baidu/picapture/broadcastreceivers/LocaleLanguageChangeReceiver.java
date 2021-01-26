package com.baidu.picapture.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.picapture.model.device.LanguageUtils;
import e.c.d.n.e;
import i.b.a.c;

public class LocaleLanguageChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        intent.getAction();
        if (intent.getAction().equals("android.intent.action.LOCALE_CHANGED")) {
            String d2 = e.d();
            if (d2 == null || d2.equals(LanguageUtils.AUTO)) {
                LanguageUtils.setIsSystemLanguageChange(true);
                c.b().a((Object) new e.c.d.g.c(LanguageUtils.getSystemLanguageValue(LanguageUtils.getSystemLanguage())));
            }
        }
    }
}
