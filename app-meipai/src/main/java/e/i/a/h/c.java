package e.i.a.h;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.StatFs;
import android.util.SparseArray;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidubce.http.Headers;
import e.i.a.e;
import e.i.a.h.d.f;
import e.i.a.h.d.g;
import e.i.a.h.f.b.C0122b;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadFactory;

/* compiled from: Util */
public class c {

    /* renamed from: a reason: collision with root package name */
    public static C0120c f8692a = new b();

    /* compiled from: Util */
    public static class a implements ThreadFactory {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ String f8693a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean f8694b;

        public a(String str, boolean z) {
            this.f8693a = str;
            this.f8694b = z;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f8693a);
            thread.setDaemon(this.f8694b);
            return thread;
        }
    }

    /* compiled from: Util */
    public static class b implements C0120c {
    }

    /* renamed from: e.i.a.h.c$c reason: collision with other inner class name */
    /* compiled from: Util */
    public interface C0120c {
    }

    public static void a(String str, String str2) {
    }

    public static boolean a(long j2, long j3) {
        return j2 == j3;
    }

    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static long b(String str) {
        long j2 = -1;
        if (str == null) {
            return -1;
        }
        try {
            j2 = Long.parseLong(str);
        } catch (NumberFormatException unused) {
        }
        return j2;
    }

    public static void b(String str, String str2) {
    }

    public static boolean c(Uri uri) {
        return uri.getScheme().equals(SdkConfigOptions.KEY_SO_FILE);
    }

    public static ThreadFactory a(String str, boolean z) {
        return new a(str, z);
    }

    public static boolean b(ConnectivityManager connectivityManager) {
        boolean z = true;
        if (connectivityManager == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
            z = false;
        }
        return z;
    }

    public static long a(StatFs statFs) {
        return statFs.getAvailableBytes();
    }

    public static g a(Context context) {
        try {
            return (g) Class.forName("com.liulishuo.okdownload.core.breakpoint.BreakpointStoreOnSQLite").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return new f(new SparseArray(), new ArrayList(), new HashMap());
        }
    }

    public static boolean b(Uri uri) {
        return uri.getScheme().equals(Config.LAUNCH_CONTENT);
    }

    public static void b(Map<String, List<String>> map, e.i.a.h.f.a aVar) throws IOException {
        if (map.containsKey("If-Match") || map.containsKey(Headers.RANGE)) {
            throw new IOException("If-Match and Range only can be handle by internal!");
        }
        a(map, aVar);
    }

    public static g a(g gVar) {
        try {
            gVar = (g) gVar.getClass().getMethod("createRemitSelf", new Class[0]).invoke(gVar, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Get final download store is ");
        sb.append(gVar);
        sb.toString();
        return gVar;
    }

    public static e.i.a.h.f.a.b a() {
        try {
            return (e.i.a.h.f.a.b) Class.forName("com.liulishuo.okdownload.core.connection.DownloadOkHttp3Connection$a").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return new C0122b();
        }
    }

    public static boolean a(String str) {
        return e.a().f8671h.checkCallingOrSelfPermission(str) == 0;
    }

    public static long a(Uri uri) {
        Cursor query = e.a().f8671h.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            return 0;
        }
        try {
            query.moveToFirst();
            return query.getLong(query.getColumnIndex("_size"));
        } finally {
            query.close();
        }
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        boolean z = true;
        if (connectivityManager == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            z = false;
        }
        return z;
    }

    public static void a(Map<String, List<String>> map, e.i.a.h.f.a aVar) {
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            for (String a2 : (List) entry.getValue()) {
                aVar.a(str, a2);
            }
        }
    }
}
