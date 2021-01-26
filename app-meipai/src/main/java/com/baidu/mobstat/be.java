package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.bk.b;
import e.a.a.a.a;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class be implements b {
    public void a(View view, boolean z, Activity activity) {
        View view2 = view;
        Activity activity2 = activity;
        if (activity2 != null && view2 != null) {
            ar.a(view2, activity2);
            String str = "; activity:";
            String str2 = "; content:";
            String str3 = "OnEvent view:";
            if (bd.c().b() && z) {
                bd c2 = bd.c();
                StringBuilder a2 = a.a(str3);
                a2.append(view.getClass().getName());
                a2.append(str2);
                a2.append(bj.h(view));
                a2.append(str);
                a2.append(activity.getClass().getName());
                c2.a(a2.toString());
            }
            if (bh.c().b()) {
                bh c3 = bh.c();
                StringBuilder a3 = a.a(str3);
                a3.append(view.getClass().getName());
                a3.append(str2);
                a3.append(bj.h(view));
                a3.append(str);
                a3.append(activity.getClass().getName());
                c3.a(a3.toString());
            }
            JSONArray a4 = bj.a(activity2, view2);
            String f2 = bj.f(view);
            Map g2 = bj.g(view);
            String a5 = bj.a(view);
            Context applicationContext = activity.getApplicationContext();
            String str4 = "";
            long currentTimeMillis = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            String name = activity.getClass().getName();
            String str5 = "";
            if (z) {
                BDStatCore.instance().onEvent(applicationContext, str4, a5, 1, currentTimeMillis, a4, jSONArray, name, str5, f2, g2);
            }
            JSONObject a6 = a(activity2, view2, az.a().b());
            String a7 = a(activity2, view2);
            aw.a().a(applicationContext, str4, bj.k(view), 1, currentTimeMillis, name, a4, str5, jSONArray, f2, g2, a6, a7);
        }
    }

    private JSONObject a(Activity activity, View view, PointF pointF) {
        if (pointF == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float f2 = pointF.x - ((float) iArr[0]);
        float f3 = pointF.y - ((float) iArr[1]);
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        float b2 = ah.b(activity, f2);
        float b3 = ah.b(activity, f3);
        float a2 = (float) ah.a(activity, (float) bj.o(view));
        float a3 = (float) ah.a(activity, (float) bj.p(view));
        if (a2 == 0.0f || a3 == 0.0f) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            jSONObject.put(Config.EVENT_HEAT_X, decimalFormat.format((double) b2));
            jSONObject.put("y", decimalFormat.format((double) b3));
            jSONObject.put(Config.EVENT_HEAT_XP, decimalFormat.format((double) ((b2 * 100.0f) / a2)));
            jSONObject.put(Config.EVENT_HEAT_YP, decimalFormat.format((double) ((b3 * 100.0f) / a3)));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String a(Activity activity, View view) {
        String str = "";
        if (!(activity == null || view == null)) {
            View a2 = bj.a(view, activity);
            View n = bj.n(a2);
            if (n == null) {
                return str;
            }
            String a3 = at.a().a(activity, a2, n);
            if (!TextUtils.isEmpty(a3)) {
                str = a3;
            }
        }
        return str;
    }
}
