package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExceptionAnalysis {

    /* renamed from: a reason: collision with root package name */
    public static ExceptionAnalysis f1400a = new ExceptionAnalysis();

    /* renamed from: b reason: collision with root package name */
    public boolean f1401b = false;

    /* renamed from: c reason: collision with root package name */
    public Context f1402c;

    /* renamed from: d reason: collision with root package name */
    public HeadObject f1403d = new HeadObject();

    /* renamed from: e reason: collision with root package name */
    public String f1404e;
    public Callback mCallback;

    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    public ExceptionAnalysis() {
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.TRACE_APPLICATION_SESSION, 0);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put(Config.TRACE_FAILED_CNT, 0);
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    public static ExceptionAnalysis getInstance() {
        return f1400a;
    }

    public void openExceptionAnalysis(Context context, boolean z) {
        if (context != null) {
            this.f1402c = context.getApplicationContext();
        }
        if (this.f1402c != null && !this.f1401b) {
            this.f1401b = true;
            ad.a().a(this.f1402c);
            if (!z) {
                NativeCrashHandler.init(this.f1402c);
            }
        }
    }

    public void saveCrashInfo(Context context, Throwable th, boolean z) {
        if (context != null) {
            this.f1402c = context.getApplicationContext();
        }
        if (this.f1402c != null) {
            String th2 = th.toString();
            int i2 = 0;
            String str = "";
            if (!TextUtils.isEmpty(th2)) {
                try {
                    String[] split = th2.split(Config.TRACE_TODAY_VISIT_SPLIT);
                    str = split.length > 1 ? split[0] : th2;
                } catch (Exception unused) {
                }
            }
            String str2 = TextUtils.isEmpty(str) ? th2 : str;
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String obj = stringWriter.toString();
            if (!z) {
                i2 = th instanceof Exception ? 11 : th instanceof Error ? 12 : 13;
            }
            saveCrashInfo(this.f1402c, System.currentTimeMillis(), obj, str2, 0, i2);
        }
    }

    public void setCrashExtraInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            this.f1404e = str;
        }
    }

    public ExceptionAnalysis(Callback callback) {
        this.mCallback = callback;
    }

    @SuppressLint({"NewApi"})
    private JSONObject a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.EXCEPTION_MEMORY_TOTAL, memoryInfo.totalMem);
            jSONObject.put(Config.EXCEPTION_MEMORY_FREE, memoryInfo.availMem);
            jSONObject.put(Config.EXCEPTION_MEMORY_LOW, memoryInfo.lowMemory ? 1 : 0);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void saveCrashInfo(Context context, long j2, String str, String str2, int i2, int i3) {
        BDStatCore.instance().autoTrackSessionEndTime(context);
        if (context != null && str != null && !str.trim().equals("")) {
            try {
                StringBuilder sb = new StringBuilder(str);
                if (!TextUtils.isEmpty(this.f1404e)) {
                    sb.append("\n");
                    sb.append("ExtraInfo:");
                    sb.append(this.f1404e);
                }
                String appVersionName = CooperService.instance().getAppVersionName(context);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("t", j2);
                jSONObject.put("c", sb.toString());
                jSONObject.put("y", str2);
                jSONObject.put("v", appVersionName);
                jSONObject.put(Config.EXCEPTION_CRASH_TYPE, i2);
                jSONObject.put("mem", a(context));
                jSONObject.put(Config.EXCEPTION_CRASH_CHANNEL, i3);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                this.f1403d.installHeader(context, jSONObject2);
                jSONObject2.put("ss", 0);
                jSONObject2.put(Config.SEQUENCE_INDEX, 0);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(Config.HEADER_PART, jSONObject2);
                jSONObject3.put(Config.PRINCIPAL_PART, new JSONArray());
                jSONObject3.put(Config.EVENT_PART, new JSONArray());
                jSONObject3.put(Config.EXCEPTION_PART, jSONArray);
                jSONObject3.put(Config.TRACE_PART, a());
                if (this.mCallback != null) {
                    this.mCallback.onCallback(jSONObject3);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Config.PREFIX_SEND_DATA);
                sb2.append(System.currentTimeMillis());
                bo.a(context, sb2.toString(), jSONObject3.toString(), false);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("dump exception, exception: ");
                sb3.append(str);
                bc.c().a(sb3.toString());
            } catch (Exception unused) {
            }
        }
    }
}
