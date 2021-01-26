package e.c.b.e;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import e.c.b.f.a;
import e.c.b.g.g;
import e.c.b.g.i;
import java.util.Date;
import java.util.List;

public final class d implements ActivityLifecycleCallbacks {
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        StringBuilder sb = new StringBuilder("onActivityCreated:");
        sb.append(activity.toString());
        a.b(sb.toString());
    }

    public final void onActivityDestroyed(Activity activity) {
        StringBuilder sb = new StringBuilder("onActivityDestroyed:");
        sb.append(activity.toString());
        a.b(sb.toString());
    }

    public final void onActivityPaused(Activity activity) {
        StringBuilder sb = new StringBuilder("##onActivityPaused ");
        sb.append(activity.getClass().getName());
        a.b(sb.toString());
        if (c.f5901h) {
            h.a(activity);
            if (h.f5906a != null && h.f5907b != null) {
                h.f5907b.putLong("used_last_time", System.currentTimeMillis());
                i.a(h.f5907b, false);
            }
        }
    }

    public final void onActivityResumed(Activity activity) {
        StringBuilder sb = new StringBuilder("##onActivityResumed ");
        sb.append(activity.getClass().getName());
        a.b(sb.toString());
        c.f5901h = true;
        h.a(activity);
        if (e.c.b.d.F) {
            return;
        }
        if (h.f5906a == null || h.f5907b == null) {
            a.c("MobclickAgent init error!! applife upload failed!");
            return;
        }
        a.a("MobclickAgent init success!");
        if (System.currentTimeMillis() - h.f5906a.getLong("used_last_time", 0) > StatisticConfig.MIN_UPLOAD_INTERVAL) {
            String str = "used_count";
            h.f5907b.putInt(str, h.f5906a.getInt(str, 0) + 1);
            i.a(h.f5907b, false);
            g.f5941b.execute(new i(activity));
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        StringBuilder sb = new StringBuilder("onActivitySaveInstanceState:");
        sb.append(activity.toString());
        a.b(sb.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x005c, code lost:
        if ((((java.util.Date) ((java.util.List) e.c.b.e.c.f5895b.get(r0 - 1)).get(1)).getTime() - ((java.util.Date) r4.get(2)).getTime()) > e.c.b.d.f5886j) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityStarted(android.app.Activity r7) {
        /*
            r6 = this;
            e.c.b.e.c.f5894a = r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 3
            r0.<init>(r1)
            java.lang.Class r2 = r7.getClass()
            java.lang.String r2 = r2.getName()
            r0.add(r2)
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            r0.add(r2)
            e.c.b.f.b<java.util.List> r2 = e.c.b.e.c.f5895b
            r2.add(r0)
            e.c.b.f.b<java.util.List> r0 = e.c.b.e.c.f5895b
            int r0 = r0.size()
            r2 = 2
            r3 = 1
            if (r0 < r2) goto L_0x005e
            e.c.b.f.b<java.util.List> r4 = e.c.b.e.c.f5895b
            int r5 = r0 + -2
            java.lang.Object r4 = r4.get(r5)
            java.util.List r4 = (java.util.List) r4
            int r5 = r4.size()
            if (r5 != r1) goto L_0x0063
            java.lang.Object r1 = r4.get(r2)
            java.util.Date r1 = (java.util.Date) r1
            e.c.b.f.b<java.util.List> r2 = e.c.b.e.c.f5895b
            int r0 = r0 - r3
            java.lang.Object r0 = r2.get(r0)
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r0.get(r3)
            java.util.Date r0 = (java.util.Date) r0
            long r4 = r0.getTime()
            long r0 = r1.getTime()
            long r4 = r4 - r0
            long r0 = e.c.b.d.f5886j
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0063
        L_0x005e:
            int r0 = e.c.b.e.c.f5898e
            int r0 = r0 + r3
            e.c.b.e.c.f5898e = r0
        L_0x0063:
            int r0 = e.c.b.e.c.f5899f
            int r0 = r0 + r3
            int r0 = r0 % 100
            e.c.b.e.c.f5899f = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "onActivityStarted:"
            r0.<init>(r1)
            java.lang.String r7 = r7.toString()
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            e.c.b.f.a.b(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.e.d.onActivityStarted(android.app.Activity):void");
    }

    public final void onActivityStopped(Activity activity) {
        Activity activity2 = c.f5894a;
        if (!(activity2 == null || activity == null || activity2.hashCode() != activity.hashCode())) {
            c.f5894a = null;
        }
        int i2 = c.f5899f - c.f5900g;
        int size = c.f5895b.size();
        if (i2 < 0) {
            i2 += 100;
        }
        if (i2 > 0 && size >= i2) {
            List list = (List) c.f5895b.get(size - i2);
            if (list.size() == 2) {
                list.add(new Date());
            }
        }
        c.f5900g = (c.f5900g + 1) % 100;
        StringBuilder sb = new StringBuilder("onActivityStopped:");
        sb.append(activity.toString());
        a.b(sb.toString());
    }
}
