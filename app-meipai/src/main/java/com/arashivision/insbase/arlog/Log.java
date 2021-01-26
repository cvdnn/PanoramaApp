package com.arashivision.insbase.arlog;

import com.arashivision.insbase.NativeLibsLoader;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import java.io.IOException;

public class Log {
    public static final int LEVEL_DEBUG = 3;
    public static final int LEVEL_ERROR = 6;
    public static final int LEVEL_INFO = 4;
    public static final int LEVEL_VERBOSE = 2;
    public static final int LEVEL_WARN = 5;
    public static String sLogFile;

    static {
        NativeLibsLoader.load();
        configure(true, false, null, false, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009c, code lost:
        if (r12 == null) goto L_0x00b1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a8 A[SYNTHETIC, Splitter:B:44:0x00a8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void collectLog(java.lang.String r10, int r11, int r12) throws java.io.IOException {
        /*
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c4 }
            r0.<init>(r10)     // Catch:{ IOException -> 0x00c4 }
            java.util.Locale r10 = java.util.Locale.getDefault()
            r1 = 6
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = android.os.Build.MODEL
            r3 = 0
            r1[r3] = r2
            r2 = 1
            java.lang.String r4 = android.os.Build.PRODUCT
            r1[r2] = r4
            r2 = 2
            java.lang.String r4 = android.os.Build.DEVICE
            r1[r2] = r4
            r2 = 3
            java.lang.String r4 = android.os.Build.MANUFACTURER
            r1[r2] = r4
            r2 = 4
            int r4 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1[r2] = r4
            r2 = 5
            java.lang.String r4 = getCpuName()
            r1[r2] = r4
            java.lang.String r2 = "model:%s, product:%s, device:%s, manufacturer:%s, android version:%d, soc model:%s\n\n"
            java.lang.String r10 = java.lang.String.format(r10, r2, r1)
            byte[] r10 = r10.getBytes()
            r0.write(r10)
            java.lang.String r10 = sLogFile     // Catch:{ all -> 0x00ba }
            r1 = 0
            if (r10 == 0) goto L_0x004f
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = sLogFile     // Catch:{ all -> 0x00ba }
            r10.<init>(r4)     // Catch:{ all -> 0x00ba }
            long r4 = r10.length()     // Catch:{ all -> 0x00ba }
            goto L_0x0050
        L_0x004f:
            r4 = r1
        L_0x0050:
            long r6 = (long) r11     // Catch:{ all -> 0x00ba }
            long r6 = r6 - r4
            long r8 = (long) r12     // Catch:{ all -> 0x00ba }
            long r6 = java.lang.Math.max(r6, r8)     // Catch:{ all -> 0x00ba }
            int r10 = (int) r6     // Catch:{ all -> 0x00ba }
            int r10 = collectLogcat(r0, r10)     // Catch:{ all -> 0x00ba }
            int r11 = r11 - r10
            if (r11 > 0) goto L_0x0068
            r0.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0067:
            return
        L_0x0068:
            int r10 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r10 <= 0) goto L_0x00b1
            r10 = 0
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0096, all -> 0x0094 }
            java.lang.String r1 = sLogFile     // Catch:{ IOException -> 0x0096, all -> 0x0094 }
            r12.<init>(r1)     // Catch:{ IOException -> 0x0096, all -> 0x0094 }
            long r10 = (long) r11
            long r10 = java.lang.Math.min(r10, r4)     // Catch:{ IOException -> 0x0092 }
            long r4 = r4 - r10
            r12.skip(r4)     // Catch:{ IOException -> 0x0092 }
            r10 = 16384(0x4000, float:2.2959E-41)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x0092 }
        L_0x0081:
            int r11 = r12.read(r10)     // Catch:{ IOException -> 0x0092 }
            r1 = -1
            if (r11 != r1) goto L_0x008e
        L_0x0088:
            r12.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x00b1
        L_0x008c:
            r10 = move-exception
            goto L_0x009f
        L_0x008e:
            r0.write(r10, r3, r11)     // Catch:{ IOException -> 0x0092 }
            goto L_0x0081
        L_0x0092:
            r10 = move-exception
            goto L_0x0099
        L_0x0094:
            r11 = move-exception
            goto L_0x00a6
        L_0x0096:
            r11 = move-exception
            r12 = r10
            r10 = r11
        L_0x0099:
            r10.printStackTrace()     // Catch:{ all -> 0x00a3 }
            if (r12 == 0) goto L_0x00b1
            goto L_0x0088
        L_0x009f:
            r10.printStackTrace()     // Catch:{ all -> 0x00ba }
            goto L_0x00b1
        L_0x00a3:
            r10 = move-exception
            r11 = r10
            r10 = r12
        L_0x00a6:
            if (r10 == 0) goto L_0x00b0
            r10.close()     // Catch:{ IOException -> 0x00ac }
            goto L_0x00b0
        L_0x00ac:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x00ba }
        L_0x00b0:
            throw r11     // Catch:{ all -> 0x00ba }
        L_0x00b1:
            r0.close()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00b9
        L_0x00b5:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00b9:
            return
        L_0x00ba:
            r10 = move-exception
            r0.close()     // Catch:{ IOException -> 0x00bf }
            goto L_0x00c3
        L_0x00bf:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00c3:
            throw r10
        L_0x00c4:
            r11 = move-exception
            java.io.IOException r12 = new java.io.IOException
            java.lang.String r0 = "failed create output file: "
            java.lang.String r10 = e.a.a.a.a.a(r0, r10)
            r12.<init>(r10, r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.arlog.Log.collectLog(java.lang.String, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r6 = new java.lang.StringBuilder();
        r6.append("[Log.java]");
        r6.append(r2);
        e(r1, r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0062, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ec, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ed, code lost:
        r9.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f6, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f8, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f9, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002f, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0105, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0106, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0124, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0030, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0125, code lost:
        r9.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012a, code lost:
        w(r1, r0);
        r2.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0033, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r5 = new java.lang.StringBuilder();
        r5.append("failed run logcat: ");
        r5.append(r2);
        r2 = r5.toString();
        r5 = r2.getBytes();
        r9.write(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004d, code lost:
        r5 = r5.length + 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:15:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x002f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0120 A[SYNTHETIC, Splitter:B:57:0x0120] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0134 A[SYNTHETIC, Splitter:B:66:0x0134] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int collectLogcat(java.io.FileOutputStream r9, int r10) {
        /*
            java.lang.String r0 = "[Log.java] destroy process"
            java.lang.String r1 = "Insta360"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r3 = "logcat"
            r2.add(r3)
            java.lang.String r3 = "-d"
            r2.add(r3)
            java.lang.String r3 = "-v"
            r2.add(r3)
            java.lang.String r3 = "threadtime"
            r2.add(r3)
            r3 = 0
            r4 = 0
            java.lang.ProcessBuilder r5 = new java.lang.ProcessBuilder     // Catch:{ IOException -> 0x0033, all -> 0x002f }
            r5.<init>(r2)     // Catch:{ IOException -> 0x0033, all -> 0x002f }
            r2 = 1
            java.lang.ProcessBuilder r2 = r5.redirectErrorStream(r2)     // Catch:{ IOException -> 0x0033, all -> 0x002f }
            java.lang.Process r2 = r2.start()     // Catch:{ IOException -> 0x0033, all -> 0x002f }
            r5 = r4
            goto L_0x0063
        L_0x002f:
            r9 = move-exception
            r2 = r3
            goto L_0x0132
        L_0x0033:
            r2 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0105, all -> 0x002f }
            r5.<init>()     // Catch:{ IOException -> 0x0105, all -> 0x002f }
            java.lang.String r6 = "failed run logcat: "
            r5.append(r6)     // Catch:{ IOException -> 0x0105, all -> 0x002f }
            r5.append(r2)     // Catch:{ IOException -> 0x0105, all -> 0x002f }
            java.lang.String r2 = r5.toString()     // Catch:{ IOException -> 0x0105, all -> 0x002f }
            byte[] r5 = r2.getBytes()     // Catch:{ IOException -> 0x0105, all -> 0x002f }
            r9.write(r5)     // Catch:{ IOException -> 0x0105, all -> 0x002f }
            int r5 = r5.length     // Catch:{ IOException -> 0x0105, all -> 0x002f }
            int r5 = r5 + r4
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0102, all -> 0x002f }
            r6.<init>()     // Catch:{ IOException -> 0x0102, all -> 0x002f }
            java.lang.String r7 = "[Log.java]"
            r6.append(r7)     // Catch:{ IOException -> 0x0102, all -> 0x002f }
            r6.append(r2)     // Catch:{ IOException -> 0x0102, all -> 0x002f }
            java.lang.String r2 = r6.toString()     // Catch:{ IOException -> 0x0102, all -> 0x002f }
            e(r1, r2)     // Catch:{ IOException -> 0x0102, all -> 0x002f }
            r2 = r3
        L_0x0063:
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00ff }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00ff }
            java.io.InputStream r8 = r2.getInputStream()     // Catch:{ IOException -> 0x00ff }
            r7.<init>(r8)     // Catch:{ IOException -> 0x00ff }
            r6.<init>(r7)     // Catch:{ IOException -> 0x00ff }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            r3.<init>()     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
        L_0x0076:
            java.lang.String r7 = r6.readLine()     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            if (r7 == 0) goto L_0x0085
            r3.append(r7)     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            r7 = 10
            r3.append(r7)     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            goto L_0x0076
        L_0x0085:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            r7.<init>()     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            java.lang.String r8 = "[Log.java] available log size: "
            r7.append(r8)     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            int r8 = r3.length()     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            r7.append(r8)     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            i(r1, r7)     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            int r7 = r3.length()     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            int r10 = java.lang.Math.min(r7, r10)     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            if (r10 > 0) goto L_0x00b6
            r6.close()     // Catch:{ IOException -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00af:
            w(r1, r0)
            r2.destroy()
            return r5
        L_0x00b6:
            int r7 = r3.length()     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            int r7 = r7 - r10
            java.lang.String r10 = r3.substring(r7)     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            byte[] r10 = r10.getBytes()     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            int r3 = r10.length     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            r9.write(r10, r4, r3)     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            int r10 = r10.length     // Catch:{ IOException -> 0x00fb, all -> 0x00f8 }
            int r4 = r5 + r10
            java.lang.String r10 = "\n"
            byte[] r10 = r10.getBytes()     // Catch:{ IOException -> 0x00f6, all -> 0x00f8 }
            r9.write(r10)     // Catch:{ IOException -> 0x00f6, all -> 0x00f8 }
            java.lang.String r10 = "################################################################################################################\n"
            byte[] r10 = r10.getBytes()     // Catch:{ IOException -> 0x00f6, all -> 0x00f8 }
            r9.write(r10)     // Catch:{ IOException -> 0x00f6, all -> 0x00f8 }
            java.lang.String r10 = "\n\n\n\n"
            byte[] r10 = r10.getBytes()     // Catch:{ IOException -> 0x00f6, all -> 0x00f8 }
            r9.write(r10)     // Catch:{ IOException -> 0x00f6, all -> 0x00f8 }
        L_0x00e5:
            r2.waitFor()     // Catch:{ InterruptedException -> 0x00f1 }
            r6.close()     // Catch:{ IOException -> 0x00ec }
            goto L_0x0130
        L_0x00ec:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x0130
        L_0x00f1:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ IOException -> 0x00f6, all -> 0x00f8 }
            goto L_0x00e5
        L_0x00f6:
            r9 = move-exception
            goto L_0x00fd
        L_0x00f8:
            r9 = move-exception
            r3 = r6
            goto L_0x0132
        L_0x00fb:
            r9 = move-exception
            r4 = r5
        L_0x00fd:
            r3 = r6
            goto L_0x0107
        L_0x00ff:
            r9 = move-exception
        L_0x0100:
            r4 = r5
            goto L_0x0107
        L_0x0102:
            r9 = move-exception
            r2 = r3
            goto L_0x0100
        L_0x0105:
            r9 = move-exception
            r2 = r3
        L_0x0107:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0131 }
            r10.<init>()     // Catch:{ all -> 0x0131 }
            java.lang.String r5 = "[Log.java] write log file failed: "
            r10.append(r5)     // Catch:{ all -> 0x0131 }
            r10.append(r9)     // Catch:{ all -> 0x0131 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0131 }
            e(r1, r10)     // Catch:{ all -> 0x0131 }
            r9.printStackTrace()     // Catch:{ all -> 0x0131 }
            if (r3 == 0) goto L_0x0128
            r3.close()     // Catch:{ IOException -> 0x0124 }
            goto L_0x0128
        L_0x0124:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0128:
            if (r2 == 0) goto L_0x0130
            w(r1, r0)
            r2.destroy()
        L_0x0130:
            return r4
        L_0x0131:
            r9 = move-exception
        L_0x0132:
            if (r3 == 0) goto L_0x013c
            r3.close()     // Catch:{ IOException -> 0x0138 }
            goto L_0x013c
        L_0x0138:
            r10 = move-exception
            r10.printStackTrace()
        L_0x013c:
            if (r2 == 0) goto L_0x0144
            w(r1, r0)
            r2.destroy()
        L_0x0144:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.arlog.Log.collectLogcat(java.io.FileOutputStream, int):int");
    }

    public static void configure(boolean z, boolean z2, String str, boolean z3, boolean z4) {
        if (z2) {
            sLogFile = str;
        }
        nativeConfigure(z, z2, str, z3, z4);
    }

    public static int d(String str, String str2) {
        return nativeWriteLog(3, str, str2);
    }

    public static int e(String str, String str2) {
        return nativeWriteLog(6, str, str2);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r6v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v4
  assigns: []
  uses: []
  mth insns count: 98
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
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a3 A[SYNTHETIC, Splitter:B:60:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ad A[SYNTHETIC, Splitter:B:65:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00bb A[SYNTHETIC, Splitter:B:73:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00c5 A[SYNTHETIC, Splitter:B:78:0x00c5] */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCpuName() {
        /*
            java.lang.String r0 = "Hardware"
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0089, all -> 0x0086 }
            java.lang.String r3 = "/proc/cpuinfo"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0089, all -> 0x0086 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0084 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0084 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x0084 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0084 }
            r4 = r1
        L_0x0015:
            java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x0081, all -> 0x007e }
            if (r5 == 0) goto L_0x004c
            boolean r6 = r5.startsWith(r0)     // Catch:{ IOException -> 0x0081, all -> 0x007e }
            if (r6 != 0) goto L_0x0029
            java.lang.String r6 = "model name"
            boolean r6 = r5.startsWith(r6)     // Catch:{ IOException -> 0x0081, all -> 0x007e }
            if (r6 == 0) goto L_0x0015
        L_0x0029:
            java.lang.String r6 = ":"
            int r6 = r5.indexOf(r6)     // Catch:{ IOException -> 0x0081, all -> 0x007e }
            r7 = -1
            if (r6 == r7) goto L_0x0015
            int r6 = r6 + 1
            java.lang.String r6 = r5.substring(r6)     // Catch:{ IOException -> 0x0081, all -> 0x007e }
            java.lang.String r6 = r6.trim()     // Catch:{ IOException -> 0x0081, all -> 0x007e }
            boolean r7 = r6.isEmpty()     // Catch:{ IOException -> 0x0081, all -> 0x007e }
            if (r7 != 0) goto L_0x0015
            boolean r5 = r5.startsWith(r0)     // Catch:{ IOException -> 0x0081, all -> 0x007e }
            if (r5 == 0) goto L_0x004a
            r1 = r6
            goto L_0x0015
        L_0x004a:
            r4 = r6
            goto L_0x0015
        L_0x004c:
            if (r1 == 0) goto L_0x005f
            r3.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0056:
            r2.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x005e:
            return r1
        L_0x005f:
            if (r4 == 0) goto L_0x0072
            r3.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0069:
            r2.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0071:
            return r4
        L_0x0072:
            r3.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x007a
        L_0x0076:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007a:
            r2.close()     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00b5
        L_0x007e:
            r0 = move-exception
            r1 = r3
            goto L_0x00b9
        L_0x0081:
            r0 = move-exception
            r1 = r3
            goto L_0x008b
        L_0x0084:
            r0 = move-exception
            goto L_0x008b
        L_0x0086:
            r0 = move-exception
            r2 = r1
            goto L_0x00b9
        L_0x0089:
            r0 = move-exception
            r2 = r1
        L_0x008b:
            java.lang.String r3 = "Insta360"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r4.<init>()     // Catch:{ all -> 0x00b8 }
            java.lang.String r5 = "Log: failed open /proc/cpuinfo: "
            r4.append(r5)     // Catch:{ all -> 0x00b8 }
            r4.append(r0)     // Catch:{ all -> 0x00b8 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00b8 }
            e(r3, r0)     // Catch:{ all -> 0x00b8 }
            if (r1 == 0) goto L_0x00ab
            r1.close()     // Catch:{ IOException -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00ab:
            if (r2 == 0) goto L_0x00b5
            r2.close()     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00b5
        L_0x00b1:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b5:
            java.lang.String r0 = ""
            return r0
        L_0x00b8:
            r0 = move-exception
        L_0x00b9:
            if (r1 == 0) goto L_0x00c3
            r1.close()     // Catch:{ IOException -> 0x00bf }
            goto L_0x00c3
        L_0x00bf:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00c3:
            if (r2 == 0) goto L_0x00cd
            r2.close()     // Catch:{ IOException -> 0x00c9 }
            goto L_0x00cd
        L_0x00c9:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00cd:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.arlog.Log.getCpuName():java.lang.String");
    }

    public static int i(String str, String str2) {
        return nativeWriteLog(4, str, str2);
    }

    public static native void nativeConfigure(boolean z, boolean z2, String str, boolean z3, boolean z4);

    public static native int nativeWriteLog(int i2, String str, String str2);

    public static void postLog(String str, String str2) throws IOException {
        new MultipartUtility(str2).addFilePart(SdkConfigOptions.KEY_SO_FILE, str).commit();
    }

    public static int v(String str, String str2) {
        return nativeWriteLog(2, str, str2);
    }

    public static int w(String str, String str2) {
        return nativeWriteLog(5, str, str2);
    }

    public static void collectLog(String str, int i2) throws IOException {
        collectLog(str, i2, 40960);
    }
}
