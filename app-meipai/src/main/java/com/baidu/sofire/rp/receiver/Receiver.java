package com.baidu.sofire.rp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import e.c.f.c;
import e.c.f.i;
import e.c.f.n.a;
import e.c.f.n.b;

public class Receiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action) && action.equals("com.b.r.p")) {
                    i iVar = new i(context);
                    int i2 = iVar.i();
                    new StringBuilder().append(i2);
                    c.a();
                    a.a(context, (long) (i2 * 3600000));
                    b.a(context).b();
                    iVar.f7012f.putLong("re_last_ofline_time", System.currentTimeMillis());
                    iVar.f7012f.commit();
                }
            } catch (Throwable unused) {
                c.d();
            }
        }
    }
}
