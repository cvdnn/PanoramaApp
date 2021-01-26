package e.c.b.f;

import android.util.Log;
import com.baidu.mobstat.Config;
import e.c.b.d;

public final class a {
    public static int a(String str) {
        if (!d.A) {
            return -1;
        }
        return Log.i("CRAB", e(str));
    }

    public static int a(String str, Throwable th) {
        if (!d.A) {
            return -1;
        }
        return Log.e("CRAB", e(str), th);
    }

    public static int b(String str) {
        if (!d.A) {
            return -1;
        }
        return Log.d("CRAB", e(str));
    }

    public static int c(String str) {
        if (!d.A) {
            return -1;
        }
        return Log.e("CRAB", e(str));
    }

    public static int d(String str) {
        if (!d.A) {
            return -1;
        }
        return Log.w("CRAB", e(str));
    }

    public static String e(String str) {
        String str2;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null) {
            int length = stackTrace.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals("com.baidu.crabsdk.util.BLog")) {
                    StringBuilder sb = new StringBuilder("[");
                    sb.append(Thread.currentThread().getName());
                    sb.append("(");
                    sb.append(Thread.currentThread().getId());
                    sb.append("): ");
                    sb.append(stackTraceElement.getFileName());
                    sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
                    sb.append(stackTraceElement.getLineNumber());
                    sb.append("]");
                    str2 = sb.toString();
                    break;
                }
                i2++;
            }
        }
        str2 = null;
        return str2 == null ? str : e.a.a.a.a.a(str2, " - ", str);
    }
}
