package com.baidu.sofire.ac;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.core.ApkInfo;
import e.c.f.c;
import e.c.f.f.d;
import e.c.f.f.e;
import e.c.f.f.g;
import e.c.f.n.a;
import e.c.f.n.k;
import e.c.f.n.m;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class FH {
    public static final int INVOKE_METHOD_ERROR_DEFULT = -1;
    public static final int INVOKE_METHOD_ERROR_ILLGEAL_METHOD_NAME = -3;
    public static final int INVOKE_METHOD_ERROR_JSON = -2;
    public static final int INVOKE_METHOD_ERROR_METHOD_NOT_FOUND = -4;
    public static final int INVOKE_METHOD_ERROR_MUTI_METHOD = -5;
    public static final int INVOKE_METHOD_ERROR_PARAM_MISMATCH = -6;
    public static final int INVOKE_METHOD_SUCCESS = 0;
    public static final int TYPE_VERSION = 1;

    public static void bc(Context context, boolean z) {
        String str = "leroadcfg";
        Editor editor = null;
        try {
            editor = context.getSharedPreferences(str, 4).edit();
            context.getSharedPreferences(str, 4).edit();
            context.getSharedPreferences("re_po_rt", 4).edit();
        } catch (Throwable th) {
            th.getMessage();
            c.c();
        }
        editor.putBoolean("s_c_c", z);
        editor.commit();
    }

    public static boolean call(int i2, String str) {
        return call(i2, str, null);
    }

    public static Pair<Integer, Object> callSync(int i2, String str) {
        return callSync(i2, str, null, new Object[0]);
    }

    public static String gd(Context context) {
        try {
            c.a();
            Pair a2 = e.a("gtdid", (Class<?>[]) null, new Object[0]);
            if (((Integer) a2.first).intValue() == 0 && !TextUtils.isEmpty((String) a2.second)) {
                return (String) a2.second;
            }
            if (TextUtils.isEmpty(e.f6954b)) {
                e.f6954b = k.a(context).b();
            }
            if (TextUtils.isEmpty(e.f6954b)) {
                e.f6954b = k.a(context).a();
            }
            m.a().a(new e.c(context, e.f6954b));
            return e.f6954b;
        } catch (Throwable unused) {
            c.d();
            return "";
        }
    }

    public static Object getPInfo(int i2, int i3) {
        String str = "";
        if (i3 != 1 || i2 <= 0) {
            return str;
        }
        try {
            g gVar = g.f6978g;
            if (gVar == null) {
                return str;
            }
            List<ApkInfo> a2 = gVar.a();
            if (a2 != null) {
                if (a2.size() > 0) {
                    for (ApkInfo apkInfo : a2) {
                        if (apkInfo.key == i2) {
                            if (apkInfo.versionName == null) {
                                return str;
                            }
                            return apkInfo.versionName;
                        }
                    }
                }
            }
            return str;
        } catch (Throwable unused) {
            c.d();
            return str;
        }
    }

    public static String getVersion(Context context) {
        return "3.3.9.8.2";
    }

    public static String gt(Context context, String str, String str2, int i2, String str3) {
        Class<String> cls = String.class;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    int i3 = 2;
                    Pair a2 = e.a(100067, "retrieveToken", (Class<?>[]) new Class[]{cls, cls, Integer.TYPE, cls}, str, str2, Integer.valueOf(i2), str3);
                    if (((Integer) a2.first).intValue() == 0) {
                        String str4 = (String) a2.second;
                        c.a();
                        if (!TextUtils.isEmpty(str4)) {
                            return str4;
                        }
                        return a.a(context, 9);
                    }
                    new StringBuilder("gt failed ").append(a2.first);
                    c.a();
                    if (((Integer) a2.first).intValue() != 4) {
                        if (((Integer) a2.first).intValue() != 3) {
                            if (((Integer) a2.first).intValue() == 5 || ((Integer) a2.first).intValue() == 11) {
                                return a.a(context, 7);
                            }
                            return a.a(context, 8);
                        }
                    }
                    String[] e2 = a.e(context);
                    StringBuilder sb = new StringBuilder("gt method try ");
                    sb.append(e2[0]);
                    sb.append(" : ");
                    sb.append(e2[1]);
                    e.a(context, 0, e2[0], e2[1], 100067);
                    if (((Integer) a2.first).intValue() == 3) {
                        i3 = 5;
                    }
                    return a.a(context, i3);
                }
            } catch (Throwable unused) {
                c.d();
            }
        }
        return a.a(context, 8);
    }

    public static String gz(Context context) {
        return e.a(context);
    }

    public static String gzfi(Context context, String str, int i2, String str2) {
        return e.a(context, str, i2, str2);
    }

    public static void init(Context context, String str, String str2, int... iArr) {
        e.a(context, 0, str, str2, iArr);
    }

    public static void initDelay(Context context, int i2, String str, String str2, int... iArr) {
        e.a(context, i2, str, str2, iArr);
    }

    public static Pair<Integer, String> invokeMethod(Context context, String str) {
        Method method;
        Method[] methods;
        String str2 = "callSync";
        Class<String> cls = String.class;
        String str3 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                String optString = jSONObject.optString("f");
                if (!TextUtils.isEmpty(optString) && !com.baidu.sapi2.outsdk.c.l.equals(optString) && !"initDelay".equals(optString)) {
                    if (!"call".equals(optString)) {
                        Class<FH> cls2 = FH.class;
                        JSONArray optJSONArray = jSONObject.optJSONArray("p");
                        if (optString.equals(str2)) {
                            if (d.f6939f == null && context != null) {
                                d.f6939f = context.getApplicationContext();
                            }
                            if (optJSONArray != null && optJSONArray.length() == 2) {
                                method = cls2.getMethod("callSync", new Class[]{Integer.TYPE, cls});
                            } else if (optJSONArray != null && optJSONArray.length() < 2) {
                                return new Pair<>(Integer.valueOf(-6), str3);
                            } else {
                                method = cls2.getMethod("callSync", new Class[]{Integer.TYPE, cls, Class[].class, Object[].class});
                            }
                        } else if (!optString.equals("gzfi")) {
                            Method method2 = null;
                            int i2 = 0;
                            for (Method method3 : cls2.getMethods()) {
                                if (optString.equals(method3.getName())) {
                                    if (method2 == null) {
                                        method2 = method3;
                                    }
                                    i2++;
                                }
                            }
                            if (i2 > 0) {
                                if (method2 != null) {
                                    if (i2 >= 2) {
                                        return new Pair<>(Integer.valueOf(-5), str3);
                                    }
                                    method = method2;
                                }
                            }
                            return new Pair<>(Integer.valueOf(-4), str3);
                        } else if (optJSONArray != null && optJSONArray.length() == 2) {
                            method = cls2.getMethod("gzfi", new Class[]{Context.class, cls, Integer.TYPE});
                        } else if (optJSONArray == null || optJSONArray.length() != 3) {
                            return new Pair<>(Integer.valueOf(-6), str3);
                        } else {
                            method = cls2.getMethod("gzfi", new Class[]{Context.class, cls, Integer.TYPE, cls});
                        }
                        Object[] parseParams = parseParams(optString, context, optJSONArray, 0, method.getParameterTypes());
                        if (str2.equals(optString)) {
                            Pair pair = (Pair) method.invoke(null, parseParams);
                            if (((Integer) pair.first).intValue() != 0) {
                                return new Pair<>(pair.first, str3);
                            }
                            Object obj = pair.second;
                            if (obj == null) {
                                return new Pair<>(Integer.valueOf(0), str3);
                            }
                            return new Pair<>(Integer.valueOf(0), obj.toString());
                        }
                        Object invoke = method.invoke(null, parseParams);
                        if (invoke == null) {
                            return new Pair<>(Integer.valueOf(0), str3);
                        }
                        return new Pair<>(Integer.valueOf(0), invoke.toString());
                    }
                }
                return new Pair<>(Integer.valueOf(-3), str3);
            } catch (IllegalArgumentException unused) {
                c.d();
                return new Pair<>(Integer.valueOf(-6), str3);
            } catch (Throwable unused2) {
                c.d();
                return new Pair<>(Integer.valueOf(-1), str3);
            }
        } catch (Throwable unused3) {
            c.d();
            return new Pair<>(Integer.valueOf(-2), str3);
        }
    }

    public static boolean isInitSuc(int i2) {
        try {
            e.c.f.d.a aVar = e.c.f.d.a.f6914f;
            if (aVar == null) {
                return false;
            }
            ApkInfo a2 = aVar.a(i2);
            if (a2 == null) {
                return false;
            }
            if (a2.initStatus != 1) {
                return false;
            }
            g gVar = g.f6978g;
            if (gVar == null) {
                return false;
            }
            if (gVar.c(a2.packageName) != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            c.d();
            return false;
        }
    }

    public static boolean parseBoolean(String str) throws IllegalArgumentException {
        if ("T".equals(str)) {
            return true;
        }
        if ("F".equals(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder("parse boolean fail:");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public static byte parseByte(String str) throws IllegalArgumentException {
        try {
            int intValue = Integer.valueOf(str).intValue();
            if (intValue <= 127 && intValue >= -128) {
                return (byte) intValue;
            }
            throw new IllegalArgumentException("parse byte fail");
        } catch (Throwable unused) {
            c.d();
            StringBuilder sb = new StringBuilder("parse byte fail:");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static char parseChar(String str) throws IllegalArgumentException {
        try {
            if (str.length() == 1) {
                return str.charAt(0);
            }
            throw new IllegalArgumentException("parse char fail");
        } catch (Throwable unused) {
            c.d();
            StringBuilder sb = new StringBuilder("parse char fail:");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static Class[] parseClassArray(String str) throws IllegalArgumentException {
        try {
            int length = str.length();
            Class[] clsArr = new Class[length];
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt == 'F') {
                    clsArr[i2] = Float.TYPE;
                } else if (charAt == 'Z') {
                    clsArr[i2] = Boolean.TYPE;
                } else if (charAt == 'I') {
                    clsArr[i2] = Integer.TYPE;
                } else if (charAt == 'J') {
                    clsArr[i2] = Long.TYPE;
                } else if (charAt == 'S') {
                    clsArr[i2] = Short.TYPE;
                } else if (charAt != 'T') {
                    switch (charAt) {
                        case 'B':
                            clsArr[i2] = Byte.TYPE;
                            break;
                        case 'C':
                            clsArr[i2] = Character.TYPE;
                            break;
                        case 'D':
                            clsArr[i2] = Double.TYPE;
                            break;
                        default:
                            throw new IllegalArgumentException("parse classArray fail");
                    }
                } else {
                    clsArr[i2] = String.class;
                }
            }
            return clsArr;
        } catch (Throwable unused) {
            c.d();
            StringBuilder sb = new StringBuilder("parse classArray fail:");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static double parseDouble(String str) throws IllegalArgumentException {
        try {
            return Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
            c.d();
            StringBuilder sb = new StringBuilder("parse double fail:");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static float parseFloat(String str) throws IllegalArgumentException {
        try {
            return Float.valueOf(str).floatValue();
        } catch (Throwable unused) {
            c.d();
            StringBuilder sb = new StringBuilder("parse float fail:");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static int parseInt(String str) throws IllegalArgumentException {
        try {
            return Integer.valueOf(str).intValue();
        } catch (Throwable unused) {
            c.d();
            StringBuilder sb = new StringBuilder("parse int fail:");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static long parseLong(String str) throws IllegalArgumentException {
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable unused) {
            c.d();
            StringBuilder sb = new StringBuilder("parse long fail:");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0016 A[Catch:{ all -> 0x01f9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object[] parseParams(java.lang.String r8, android.content.Context r9, org.json.JSONArray r10, int r11, java.lang.Class[] r12) throws java.lang.IllegalArgumentException {
        /*
            java.lang.String r0 = "callSync"
            boolean r8 = r0.equals(r8)     // Catch:{ all -> 0x01f9 }
            r0 = 0
            if (r12 == 0) goto L_0x000f
            int r1 = r12.length     // Catch:{ all -> 0x01f9 }
            if (r1 != 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            int r1 = r12.length     // Catch:{ all -> 0x01f9 }
            goto L_0x0010
        L_0x000f:
            r1 = r0
        L_0x0010:
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x01f9 }
            r3 = 0
            r4 = r3
        L_0x0014:
            if (r0 >= r1) goto L_0x01f8
            if (r12 == 0) goto L_0x01f0
            r5 = r12[r0]     // Catch:{ all -> 0x01f9 }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x01f9 }
            if (r6 == 0) goto L_0x003a
            if (r9 == 0) goto L_0x0028
            r2[r0] = r9     // Catch:{ all -> 0x01f9 }
            goto L_0x01dc
        L_0x0028:
            android.content.Context r5 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x01f9 }
            if (r5 == 0) goto L_0x0032
            android.content.Context r5 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x01f9 }
            r2[r0] = r5     // Catch:{ all -> 0x01f9 }
            goto L_0x01dc
        L_0x0032:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f9 }
            java.lang.String r9 = "method request context"
            r8.<init>(r9)     // Catch:{ all -> 0x01f9 }
            throw r8     // Catch:{ all -> 0x01f9 }
        L_0x003a:
            if (r10 == 0) goto L_0x01e8
            java.lang.String r6 = r10.optString(r11)     // Catch:{ all -> 0x01f9 }
            java.lang.Class r7 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x01f9 }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 != 0) goto L_0x01ca
            java.lang.Class<java.lang.Boolean> r7 = java.lang.Boolean.class
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 == 0) goto L_0x0052
            goto L_0x01ca
        L_0x0052:
            java.lang.Class r7 = java.lang.Byte.TYPE     // Catch:{ all -> 0x01f9 }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 != 0) goto L_0x01b1
            java.lang.Class<java.lang.Byte> r7 = java.lang.Byte.class
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 == 0) goto L_0x0064
            goto L_0x01b1
        L_0x0064:
            java.lang.Class r7 = java.lang.Character.TYPE     // Catch:{ all -> 0x01f9 }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 == 0) goto L_0x0086
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x01f9 }
            if (r5 != 0) goto L_0x007e
            char r5 = parseChar(r6)     // Catch:{ all -> 0x01f9 }
            java.lang.Character r5 = java.lang.Character.valueOf(r5)     // Catch:{ all -> 0x01f9 }
            r2[r0] = r5     // Catch:{ all -> 0x01f9 }
            goto L_0x01da
        L_0x007e:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f9 }
            java.lang.String r9 = "char not support null String"
            r8.<init>(r9)     // Catch:{ all -> 0x01f9 }
            throw r8     // Catch:{ all -> 0x01f9 }
        L_0x0086:
            java.lang.Class r7 = java.lang.Short.TYPE     // Catch:{ all -> 0x01f9 }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 != 0) goto L_0x0198
            java.lang.Class<java.lang.Short> r7 = java.lang.Short.class
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 == 0) goto L_0x0098
            goto L_0x0198
        L_0x0098:
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x01f9 }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 != 0) goto L_0x017f
            java.lang.Class<java.lang.Integer> r7 = java.lang.Integer.class
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 == 0) goto L_0x00aa
            goto L_0x017f
        L_0x00aa:
            java.lang.Class r7 = java.lang.Long.TYPE     // Catch:{ all -> 0x01f9 }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 != 0) goto L_0x0166
            java.lang.Class<java.lang.Long> r7 = java.lang.Long.class
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 == 0) goto L_0x00bc
            goto L_0x0166
        L_0x00bc:
            java.lang.Class r7 = java.lang.Float.TYPE     // Catch:{ all -> 0x01f9 }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 != 0) goto L_0x014c
            java.lang.Class<java.lang.Float> r7 = java.lang.Float.class
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 == 0) goto L_0x00ce
            goto L_0x014c
        L_0x00ce:
            java.lang.Class r7 = java.lang.Double.TYPE     // Catch:{ all -> 0x01f9 }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 != 0) goto L_0x0132
            java.lang.Class<java.lang.Double> r7 = java.lang.Double.class
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 == 0) goto L_0x00df
            goto L_0x0132
        L_0x00df:
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 == 0) goto L_0x00eb
            r2[r0] = r6     // Catch:{ all -> 0x01f9 }
            goto L_0x01da
        L_0x00eb:
            java.lang.Class<java.lang.Class[]> r7 = java.lang.Class[].class
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x01f9 }
            if (r7 == 0) goto L_0x0110
            if (r8 == 0) goto L_0x0108
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x01f9 }
            if (r4 == 0) goto L_0x0100
            r2[r0] = r3     // Catch:{ all -> 0x01f9 }
            r4 = r3
            goto L_0x01da
        L_0x0100:
            java.lang.Class[] r4 = parseClassArray(r6)     // Catch:{ all -> 0x01f9 }
            r2[r0] = r4     // Catch:{ all -> 0x01f9 }
            goto L_0x01da
        L_0x0108:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f9 }
            java.lang.String r9 = "only callSync support Class[]"
            r8.<init>(r9)     // Catch:{ all -> 0x01f9 }
            throw r8     // Catch:{ all -> 0x01f9 }
        L_0x0110:
            java.lang.Class<java.lang.Object[]> r6 = java.lang.Object[].class
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x01f9 }
            if (r5 == 0) goto L_0x01dc
            if (r8 == 0) goto L_0x012a
            if (r4 != 0) goto L_0x0120
            r2[r0] = r3     // Catch:{ all -> 0x01f9 }
            goto L_0x01dc
        L_0x0120:
            java.lang.String r5 = ""
            java.lang.Object[] r5 = parseParams(r5, r9, r10, r11, r4)     // Catch:{ all -> 0x01f9 }
            r2[r0] = r5     // Catch:{ all -> 0x01f9 }
            goto L_0x01dc
        L_0x012a:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f9 }
            java.lang.String r9 = "only callSync support Object[]"
            r8.<init>(r9)     // Catch:{ all -> 0x01f9 }
            throw r8     // Catch:{ all -> 0x01f9 }
        L_0x0132:
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x01f9 }
            if (r5 != 0) goto L_0x0144
            double r5 = parseDouble(r6)     // Catch:{ all -> 0x01f9 }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ all -> 0x01f9 }
            r2[r0] = r5     // Catch:{ all -> 0x01f9 }
            goto L_0x01da
        L_0x0144:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f9 }
            java.lang.String r9 = "double not support null String"
            r8.<init>(r9)     // Catch:{ all -> 0x01f9 }
            throw r8     // Catch:{ all -> 0x01f9 }
        L_0x014c:
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x01f9 }
            if (r5 != 0) goto L_0x015e
            float r5 = parseFloat(r6)     // Catch:{ all -> 0x01f9 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ all -> 0x01f9 }
            r2[r0] = r5     // Catch:{ all -> 0x01f9 }
            goto L_0x01da
        L_0x015e:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f9 }
            java.lang.String r9 = "float not support null String"
            r8.<init>(r9)     // Catch:{ all -> 0x01f9 }
            throw r8     // Catch:{ all -> 0x01f9 }
        L_0x0166:
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x01f9 }
            if (r5 != 0) goto L_0x0177
            long r5 = parseLong(r6)     // Catch:{ all -> 0x01f9 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x01f9 }
            r2[r0] = r5     // Catch:{ all -> 0x01f9 }
            goto L_0x01da
        L_0x0177:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f9 }
            java.lang.String r9 = "long not support null String"
            r8.<init>(r9)     // Catch:{ all -> 0x01f9 }
            throw r8     // Catch:{ all -> 0x01f9 }
        L_0x017f:
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x01f9 }
            if (r5 != 0) goto L_0x0190
            int r5 = parseInt(r6)     // Catch:{ all -> 0x01f9 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x01f9 }
            r2[r0] = r5     // Catch:{ all -> 0x01f9 }
            goto L_0x01da
        L_0x0190:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f9 }
            java.lang.String r9 = "int not support null String"
            r8.<init>(r9)     // Catch:{ all -> 0x01f9 }
            throw r8     // Catch:{ all -> 0x01f9 }
        L_0x0198:
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x01f9 }
            if (r5 != 0) goto L_0x01a9
            short r5 = parseShort(r6)     // Catch:{ all -> 0x01f9 }
            java.lang.Short r5 = java.lang.Short.valueOf(r5)     // Catch:{ all -> 0x01f9 }
            r2[r0] = r5     // Catch:{ all -> 0x01f9 }
            goto L_0x01da
        L_0x01a9:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f9 }
            java.lang.String r9 = "short not support null String"
            r8.<init>(r9)     // Catch:{ all -> 0x01f9 }
            throw r8     // Catch:{ all -> 0x01f9 }
        L_0x01b1:
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x01f9 }
            if (r5 != 0) goto L_0x01c2
            byte r5 = parseByte(r6)     // Catch:{ all -> 0x01f9 }
            java.lang.Byte r5 = java.lang.Byte.valueOf(r5)     // Catch:{ all -> 0x01f9 }
            r2[r0] = r5     // Catch:{ all -> 0x01f9 }
            goto L_0x01da
        L_0x01c2:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f9 }
            java.lang.String r9 = "byte not support null String"
            r8.<init>(r9)     // Catch:{ all -> 0x01f9 }
            throw r8     // Catch:{ all -> 0x01f9 }
        L_0x01ca:
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x01f9 }
            if (r5 != 0) goto L_0x01e0
            boolean r5 = parseBoolean(r6)     // Catch:{ all -> 0x01f9 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x01f9 }
            r2[r0] = r5     // Catch:{ all -> 0x01f9 }
        L_0x01da:
            int r11 = r11 + 1
        L_0x01dc:
            int r0 = r0 + 1
            goto L_0x0014
        L_0x01e0:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f9 }
            java.lang.String r9 = "boolean not support null String"
            r8.<init>(r9)     // Catch:{ all -> 0x01f9 }
            throw r8     // Catch:{ all -> 0x01f9 }
        L_0x01e8:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f9 }
            java.lang.String r9 = "request params but get null"
            r8.<init>(r9)     // Catch:{ all -> 0x01f9 }
            throw r8     // Catch:{ all -> 0x01f9 }
        L_0x01f0:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01f9 }
            java.lang.String r9 = "parameterTypes null"
            r8.<init>(r9)     // Catch:{ all -> 0x01f9 }
            throw r8     // Catch:{ all -> 0x01f9 }
        L_0x01f8:
            return r2
        L_0x01f9:
            r8 = move-exception
            e.c.f.c.d()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r8 = r8.getMessage()
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.FH.parseParams(java.lang.String, android.content.Context, org.json.JSONArray, int, java.lang.Class[]):java.lang.Object[]");
    }

    public static short parseShort(String str) throws IllegalArgumentException {
        try {
            return Short.valueOf(str).shortValue();
        } catch (Throwable unused) {
            c.d();
            StringBuilder sb = new StringBuilder("parse short fail:");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static void setAgreePolicy(Context context, boolean z) {
        Editor editor = null;
        String str = "leroadcfg";
        try {
            context.getSharedPreferences(str, 4).edit();
            editor = context.getSharedPreferences(str, 4).edit();
            context.getSharedPreferences("re_po_rt", 4).edit();
        } catch (Throwable unused) {
            c.d();
            return;
        }
        editor.putBoolean("s_a_pl", z);
        editor.commit();
    }

    public static String xgz(Context context, String str) {
        int i2;
        String str2;
        try {
            Pair a2 = e.a("xgz", (Class<?>[]) new Class[]{String.class}, str);
            if (((Integer) a2.first).intValue() == 0 && !TextUtils.isEmpty((String) a2.second)) {
                return (String) a2.second;
            }
            i2 = ((Integer) a2.first).intValue() == 0 ? 502 : ((Integer) a2.first).intValue();
            try {
                str2 = new JSONObject().put("rc", i2).put("z", e.a(context)).toString();
            } catch (Throwable unused) {
                c.d();
                str2 = "";
            }
            return str2;
        } catch (Throwable unused2) {
            c.d();
            i2 = 501;
        }
    }

    public static boolean call(int i2, String str, Callback callback) {
        return call(i2, str, callback, null, new Object[0]);
    }

    public static Pair<Integer, Object> callSync(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        return e.a(i2, str, clsArr, objArr);
    }

    public static String gzfi(Context context, String str, int i2) {
        return e.a(context, str, i2, (String) null);
    }

    public static boolean call(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        return call(i2, str, null, clsArr, objArr);
    }

    public static boolean call(int i2, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        return e.a(i2, str, callback, clsArr, objArr);
    }
}
