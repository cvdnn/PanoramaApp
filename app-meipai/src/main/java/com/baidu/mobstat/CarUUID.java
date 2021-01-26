package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.Process;
import android.system.Os;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class CarUUID {

    /* renamed from: a reason: collision with root package name */
    public static final Pattern f1381a = Pattern.compile("(\\w{32})");

    public static String a(Context context) {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String b(Context context) {
        return a(context.getFileStreamPath("libdueros_uuid.so"));
    }

    public static String c(Context context) {
        if (!c(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            return null;
        }
        return a(new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".dueros_uuid"));
    }

    public static String d(Context context) {
        List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(0);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        for (ApplicationInfo applicationInfo2 : installedApplications) {
            if (!applicationInfo.packageName.equals(applicationInfo2.packageName)) {
                String a2 = a(new File(new File(applicationInfo2.dataDir, "files"), "libdueros_uuid.so"));
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }

    public static String optUUID(Context context) {
        String b2 = b(context);
        if (b2 != null) {
            return b2;
        }
        String c2 = c(context);
        if (c2 != null) {
            a(context, c2);
            return c2;
        }
        String d2 = d(context);
        if (d2 != null) {
            a(context, d2);
            b(context, d2);
            return d2;
        }
        String a2 = a(context);
        if (a2 == null) {
            return "";
        }
        a(context, a2);
        b(context, a2);
        return a2;
    }

    public static boolean a(Context context, String str) {
        String str2 = "libdueros_uuid.so";
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(str2, 0);
            if (a(fileOutputStream, str)) {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                File fileStreamPath = context.getFileStreamPath(str2);
                if (a(new File(applicationInfo.dataDir), 457) && a(fileStreamPath, 484)) {
                    z = true;
                }
                bu.a(fileOutputStream);
                return z;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            bu.a(null);
            throw th;
        }
        bu.a(fileOutputStream);
        return false;
    }

    public static boolean b(Context context, String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        if (!c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return false;
        }
        File file = new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".dueros_uuid");
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                boolean a2 = a(fileOutputStream, str);
                bu.a(fileOutputStream);
                return a2;
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
                bu.a(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                bu.a(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
            bu.a(fileOutputStream2);
            return false;
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
            bu.a(fileOutputStream);
            throw th;
        }
    }

    public static boolean c(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.Closeable, java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v4
  assigns: [?[OBJECT, ARRAY], ?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
  uses: [java.lang.String, java.io.Closeable]
  mth insns count: 26
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0039
            boolean r1 = r5.exists()
            if (r1 == 0) goto L_0x0039
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0035, all -> 0x0030 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0035, all -> 0x0030 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0036, all -> 0x002d }
            int r2 = r1.read(r5)     // Catch:{ Exception -> 0x0036, all -> 0x002d }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0036, all -> 0x002d }
            r4 = 0
            r3.<init>(r5, r4, r2)     // Catch:{ Exception -> 0x0036, all -> 0x002d }
            java.util.regex.Pattern r5 = f1381a     // Catch:{ Exception -> 0x0036, all -> 0x002d }
            java.util.regex.Matcher r5 = r5.matcher(r3)     // Catch:{ Exception -> 0x0036, all -> 0x002d }
            boolean r5 = r5.matches()     // Catch:{ Exception -> 0x0036, all -> 0x002d }
            if (r5 == 0) goto L_0x0029
            r0 = r3
        L_0x0029:
            com.baidu.mobstat.bu.a(r1)
            return r0
        L_0x002d:
            r5 = move-exception
            r0 = r1
            goto L_0x0031
        L_0x0030:
            r5 = move-exception
        L_0x0031:
            com.baidu.mobstat.bu.a(r0)
            throw r5
        L_0x0035:
            r1 = r0
        L_0x0036:
            com.baidu.mobstat.bu.a(r1)
        L_0x0039:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.CarUUID.a(java.io.File):java.lang.String");
    }

    public static boolean a(FileOutputStream fileOutputStream, String str) {
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean a(File file, int i2) {
        try {
            Os.chmod(file.getAbsolutePath(), i2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
