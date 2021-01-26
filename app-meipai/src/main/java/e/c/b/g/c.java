package e.c.b.g;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import e.c.b.d;
import e.c.b.e.Utils;
import e.c.b.f.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c extends a {

    /* renamed from: b reason: collision with root package name */
    public ActivityManager f5924b = null;

    /* renamed from: c reason: collision with root package name */
    public int f5925c = -100;

    public c(Context context) {
        super(context);
        this.f5924b = (ActivityManager) context.getSystemService("activity");
    }

    public static Map<String, Object> a(ProcessErrorStateInfo processErrorStateInfo, String str) {
        byte[] n;
        String str2 = "(";
        String str3 = "ANR";
        String str4 = "N/A";
        HashMap hashMap = new HashMap();
        try {
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            String str5 = "errorOriLine";
            String str6 = "errorLine";
            String str7 = "mainThread";
            if (stackTrace != null) {
                if (stackTrace.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                    }
                    hashMap.put(str7, sb.toString());
                    hashMap.put(str6, stackTrace[0].toString());
                    str4 = stackTrace[0].toString();
                    hashMap.put(str5, str4);
                    hashMap.put("apiType", str3);
                    hashMap.put("errorType", str3);
                    String str8 = "";
                    if (processErrorStateInfo.shortMsg != null && processErrorStateInfo.shortMsg.contains(str2)) {
                        str8 = processErrorStateInfo.shortMsg.substring(0, processErrorStateInfo.shortMsg.indexOf(str2));
                    }
                    hashMap.put("type", str8);
                    hashMap.put("anrMsg", processErrorStateInfo.longMsg);
                    hashMap.put("processId", Integer.valueOf(processErrorStateInfo.pid));
                    hashMap.put("processName", processErrorStateInfo.processName);
                    hashMap.put(LogBuilder.KEY_TIME, Long.valueOf(System.currentTimeMillis()));
                    hashMap.put("threadList", Utils.e());
                    n = Utils.n(str);
                    if (n != null || n.length <= 0) {
                        StringBuilder sb2 = new StringBuilder("read trace file error! ");
                        sb2.append(str);
                        a.c(sb2.toString());
                    } else {
                        hashMap.put(Config.TRACE_PART, Base64.encodeToString(n, 0));
                    }
                    return hashMap;
                }
            }
            hashMap.put(str7, str4);
            hashMap.put(str6, str4);
            hashMap.put(str5, str4);
            hashMap.put("apiType", str3);
            hashMap.put("errorType", str3);
            String str82 = "";
            str82 = processErrorStateInfo.shortMsg.substring(0, processErrorStateInfo.shortMsg.indexOf(str2));
            hashMap.put("type", str82);
            hashMap.put("anrMsg", processErrorStateInfo.longMsg);
            hashMap.put("processId", Integer.valueOf(processErrorStateInfo.pid));
            hashMap.put("processName", processErrorStateInfo.processName);
            hashMap.put(LogBuilder.KEY_TIME, Long.valueOf(System.currentTimeMillis()));
            hashMap.put("threadList", Utils.e());
        } catch (Exception e2) {
            a.a("封装anr数据失败!", e2);
        }
        try {
            n = Utils.n(str);
            if (n != null) {
            }
            StringBuilder sb22 = new StringBuilder("read trace file error! ");
            sb22.append(str);
            a.c(sb22.toString());
        } catch (Exception e3) {
            a.a("wrap trace to anrRecord error!", e3);
        } catch (OutOfMemoryError e4) {
            a.c(e4.getMessage());
        }
        return hashMap;
    }

    public final ProcessErrorStateInfo a() {
        try {
            List<ProcessErrorStateInfo> processesInErrorState = this.f5924b.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        return processErrorStateInfo;
                    }
                }
            }
        } catch (Exception e2) {
            a.a("getProcessErrorStateInfo error!", e2);
        }
        return null;
    }

    public final void a(String str) {
        if (this.f5925c != Process.myPid()) {
            this.f5925c = Process.myPid();
            try {
                a.a("anr trace logic thread.");
                boolean b2 = b(str);
                long nanoTime = System.nanoTime();
                while (true) {
                    if (b2) {
                        break;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    b2 = b(str);
                    if ((System.nanoTime() - nanoTime) / 1000000 > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                        a.d("anr trace logic timeout!");
                        break;
                    }
                }
            } catch (Exception e3) {
                a.a("processErrorStateInfo error!", e3);
            }
        }
    }

    public final boolean b(String str) {
        try {
            ProcessErrorStateInfo a2 = a();
            if (a2 == null) {
                return false;
            }
            if (a2.pid == Process.myPid()) {
                a.a("anr info catched...");
                Map a3 = a(a2, str);
                if (d.H != null) {
                    d.H.a(a3);
                }
                Map a4 = Utils.a(this.f5922a, (Throwable) null, false);
                ((HashMap) a4).putAll(a3);
                Utils.a(a4);
                Utils.a(this.f5922a, Utils.b(a4));
                Utils.i();
                if (Utils.g()) {
                    a.a("begin to upload anr info...");
                    g.a(false, this.f5922a);
                }
            } else {
                StringBuilder sb = new StringBuilder("Anr occur! But not the current pid!");
                sb.append(Process.myPid());
                a.a(sb.toString());
            }
            a.a("getLogcatErrorInfo return true");
            return true;
        } catch (Exception e2) {
            a.a("getLogcatErrorInfo error!", e2);
            return true;
        } catch (OutOfMemoryError e3) {
            a.c(e3.getMessage());
            return true;
        }
    }
}
