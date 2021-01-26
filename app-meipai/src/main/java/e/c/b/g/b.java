package e.c.b.g;

import android.content.Context;
import com.baidubce.BceConfig;
import com.sina.weibo.sdk.statistic.LogBuilder;
import e.c.b.e.Utils;
import e.c.b.f.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Map;

public final class b extends a {

    /* renamed from: b reason: collision with root package name */
    public boolean f5923b = false;

    public b(Context context) {
        super(context);
    }

    public static void a(Map<String, Object> map) {
        String str;
        String str2;
        Map<String, Object> map2 = map;
        String str3 = "(";
        String str4 = "Reason:";
        String str5 = "Activity pause timed out";
        String str6 = "Timeout executing service";
        String str7 = "Input event dispatching timed out";
        StringBuilder sb = new StringBuilder();
        try {
            String str8 = (String) map2.get(LogBuilder.KEY_TIME);
            if (str8 != null) {
                String substring = str8.substring(5);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d -v time", null, new File(BceConfig.BOS_DELIMITER)).getInputStream()), 8192);
                String b2 = Utils.b();
                int i2 = 0;
                boolean z = true;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    int i3 = i2 + 1;
                    if (i2 >= Integer.MAX_VALUE) {
                        break;
                    }
                    if (z) {
                        if (readLine.compareTo(substring) >= 0) {
                            z = false;
                        } else {
                            i2 = i3;
                        }
                    }
                    String str9 = "type";
                    if (readLine.contains(str7)) {
                        map2.put(str9, str7);
                    }
                    if (readLine.contains(str6)) {
                        map2.put(str9, str6);
                    }
                    if (readLine.contains(str5)) {
                        map2.put(str9, str5);
                    }
                    if (readLine.contains(str4)) {
                        String[] split = readLine.split(str4);
                        str2 = str4;
                        if (split.length == 2) {
                            map2.put("reason", split[1].trim());
                            if (split[1].trim().contains(str3)) {
                                int indexOf = split[1].trim().indexOf(str3);
                                if (indexOf > 0) {
                                    map2.put(str9, split[1].trim().substring(0, indexOf));
                                    if (readLine.contains("ActivityManager") || readLine.contains(b2)) {
                                        sb.append(readLine);
                                        sb.append("\n");
                                    }
                                    i2 = i3;
                                    str4 = str2;
                                }
                            }
                        }
                    } else {
                        str2 = str4;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                    i2 = i3;
                    str4 = str2;
                }
            }
        } catch (Exception e2) {
            e = e2;
            str = "putAnrLogcat error!";
            a.a(str, e);
        } catch (OutOfMemoryError e3) {
            e = e3;
            str = "putAnrLogcat oom!";
            a.a(str, e);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r14v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r18v0 */
    /* JADX WARNING: type inference failed for: r11v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r20v0 */
    /* JADX WARNING: type inference failed for: r11v5 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r24v0 */
    /* JADX WARNING: type inference failed for: r22v0 */
    /* JADX WARNING: type inference failed for: r23v5 */
    /* JADX WARNING: type inference failed for: r23v6 */
    /* JADX WARNING: type inference failed for: r22v1 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r22v2 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r22v3 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r0v28, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r1v27 */
    /* JADX WARNING: type inference failed for: r1v28, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r11v9, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v29, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r14v22 */
    /* JADX WARNING: type inference failed for: r14v23, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r14v24, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r14v28 */
    /* JADX WARNING: type inference failed for: r18v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r14v29 */
    /* JADX WARNING: type inference failed for: r18v4 */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: type inference failed for: r18v5 */
    /* JADX WARNING: type inference failed for: r18v6 */
    /* JADX WARNING: type inference failed for: r14v32 */
    /* JADX WARNING: type inference failed for: r1v35 */
    /* JADX WARNING: type inference failed for: r11v15, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v36 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v17, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v12, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r11v23 */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r22v4 */
    /* JADX WARNING: type inference failed for: r6v10 */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r11v24 */
    /* JADX WARNING: type inference failed for: r22v5 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r22v6 */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: type inference failed for: r26v0 */
    /* JADX WARNING: type inference failed for: r23v15 */
    /* JADX WARNING: type inference failed for: r22v7 */
    /* JADX WARNING: type inference failed for: r8v14, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v46, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r22v8 */
    /* JADX WARNING: type inference failed for: r6v14, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: type inference failed for: r21v3 */
    /* JADX WARNING: type inference failed for: r22v9 */
    /* JADX WARNING: type inference failed for: r21v4 */
    /* JADX WARNING: type inference failed for: r26v1 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r26v2 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r22v10 */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: type inference failed for: r6v15 */
    /* JADX WARNING: type inference failed for: r22v11 */
    /* JADX WARNING: type inference failed for: r22v12 */
    /* JADX WARNING: type inference failed for: r22v13 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r6v17 */
    /* JADX WARNING: type inference failed for: r22v14 */
    /* JADX WARNING: type inference failed for: r8v19, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v22, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARNING: type inference failed for: r26v3 */
    /* JADX WARNING: type inference failed for: r8v23 */
    /* JADX WARNING: type inference failed for: r8v32 */
    /* JADX WARNING: type inference failed for: r11v28 */
    /* JADX WARNING: type inference failed for: r6v21 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r22v15 */
    /* JADX WARNING: type inference failed for: r8v36 */
    /* JADX WARNING: type inference failed for: r23v27 */
    /* JADX WARNING: type inference failed for: r0v57 */
    /* JADX WARNING: type inference failed for: r26v4 */
    /* JADX WARNING: type inference failed for: r11v33, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r26v5 */
    /* JADX WARNING: type inference failed for: r22v16 */
    /* JADX WARNING: type inference failed for: r23v28 */
    /* JADX WARNING: type inference failed for: r0v58 */
    /* JADX WARNING: type inference failed for: r8v43 */
    /* JADX WARNING: type inference failed for: r8v44 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: type inference failed for: r11v34 */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: type inference failed for: r22v17 */
    /* JADX WARNING: type inference failed for: r23v29 */
    /* JADX WARNING: type inference failed for: r22v18 */
    /* JADX WARNING: type inference failed for: r22v19 */
    /* JADX WARNING: type inference failed for: r22v20 */
    /* JADX WARNING: type inference failed for: r8v45 */
    /* JADX WARNING: type inference failed for: r22v21 */
    /* JADX WARNING: type inference failed for: r6v24 */
    /* JADX WARNING: type inference failed for: r22v22 */
    /* JADX WARNING: type inference failed for: r8v46 */
    /* JADX WARNING: type inference failed for: r6v25 */
    /* JADX WARNING: type inference failed for: r6v26 */
    /* JADX WARNING: type inference failed for: r8v47 */
    /* JADX WARNING: type inference failed for: r2v25 */
    /* JADX WARNING: type inference failed for: r8v48 */
    /* JADX WARNING: type inference failed for: r8v49 */
    /* JADX WARNING: type inference failed for: r8v50 */
    /* JADX WARNING: type inference failed for: r8v51 */
    /* JADX WARNING: type inference failed for: r8v52 */
    /* JADX WARNING: type inference failed for: r8v53 */
    /* JADX WARNING: type inference failed for: r8v54 */
    /* JADX WARNING: type inference failed for: r8v55 */
    /* JADX WARNING: type inference failed for: r2v26 */
    /* JADX WARNING: type inference failed for: r2v27 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: type inference failed for: r14v45 */
    /* JADX WARNING: type inference failed for: r14v46 */
    /* JADX WARNING: type inference failed for: r1v45 */
    /* JADX WARNING: type inference failed for: r2v29 */
    /* JADX WARNING: type inference failed for: r2v30 */
    /* JADX WARNING: type inference failed for: r2v31 */
    /* JADX WARNING: type inference failed for: r2v32 */
    /* JADX WARNING: type inference failed for: r8v56 */
    /* JADX WARNING: type inference failed for: r8v57 */
    /* JADX WARNING: type inference failed for: r11v35 */
    /* JADX WARNING: type inference failed for: r6v27 */
    /* JADX WARNING: type inference failed for: r2v33 */
    /* JADX WARNING: type inference failed for: r6v28 */
    /* JADX WARNING: type inference failed for: r2v34 */
    /* JADX WARNING: type inference failed for: r22v23 */
    /* JADX WARNING: type inference failed for: r6v29 */
    /* JADX WARNING: type inference failed for: r22v24 */
    /* JADX WARNING: type inference failed for: r26v6 */
    /* JADX WARNING: type inference failed for: r8v58 */
    /* JADX WARNING: type inference failed for: r6v30 */
    /* JADX WARNING: type inference failed for: r26v7 */
    /* JADX WARNING: type inference failed for: r8v59 */
    /* JADX WARNING: type inference failed for: r26v8 */
    /* JADX WARNING: type inference failed for: r8v60 */
    /* JADX WARNING: type inference failed for: r22v25 */
    /* JADX WARNING: type inference failed for: r22v26 */
    /* JADX WARNING: type inference failed for: r8v61 */
    /* JADX WARNING: type inference failed for: r22v27 */
    /* JADX WARNING: type inference failed for: r22v28 */
    /* JADX WARNING: type inference failed for: r22v29 */
    /* JADX WARNING: type inference failed for: r8v62 */
    /* JADX WARNING: type inference failed for: r22v30 */
    /* JADX WARNING: type inference failed for: r22v31 */
    /* JADX WARNING: type inference failed for: r8v63 */
    /* JADX WARNING: type inference failed for: r22v32 */
    /* JADX WARNING: type inference failed for: r23v30 */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01ff, code lost:
        r0 = e;
        r22 = r22;
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x020f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0210, code lost:
        r8 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0242, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0243, code lost:
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0267, code lost:
        r3 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:?, code lost:
        r15.put(r3, r1);
        r0 = r1.split(r13);
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0272, code lost:
        if (r1 >= r0.length) goto L_0x0282;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x027a, code lost:
        if (c(r0[r1]) == false) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x027c, code lost:
        r1 = r0[r1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x027f, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0282, code lost:
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0284, code lost:
        r11 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x028a, code lost:
        if (r1.equals(r11) == false) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x028c, code lost:
        r18 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0290, code lost:
        if (r0.length <= 1) goto L_0x0298;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0292, code lost:
        r1 = r0[1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0296, code lost:
        r18 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0298, code lost:
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x029a, code lost:
        r14 = r0.length - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x029f, code lost:
        if (r14 <= 0) goto L_0x02af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02a7, code lost:
        if (c(r0[r14]) == false) goto L_0x02ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02a9, code lost:
        r14 = r0[r14];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02ac, code lost:
        r14 = r14 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02af, code lost:
        r14 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02b4, code lost:
        if (r14.equals(r11) == false) goto L_0x02be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x02b7, code lost:
        if (r0.length <= 0) goto L_0x02be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x02b9, code lost:
        r14 = r0[r0.length - 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x02be, code lost:
        r11 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:?, code lost:
        r15.put(r11, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x02c3, code lost:
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:?, code lost:
        r15.put(r1, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x02c8, code lost:
        r14 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x02ca, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x02cc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x02cd, code lost:
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x02cf, code lost:
        r14 = r11;
        r8 = r8;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x02d1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x02d2, code lost:
        r1 = r16;
        r14 = r17;
        r8 = r8;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x02e5, code lost:
        r0 = e;
        r8 = r8;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x02e7, code lost:
        r0 = e;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x02e8, code lost:
        r1 = r16;
        r14 = r17;
        r3 = r19;
        r8 = r8;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x02ef, code lost:
        r0 = e;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x02f9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x02fa, code lost:
        r1 = r16;
        r14 = r17;
        r3 = r19;
        r2 = r20;
        r8 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0322, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0323, code lost:
        r1 = "内存溢出了！";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a5, code lost:
        r15.put(r10, r12);
        r15.put(r9, r12);
        r15.put(r7, r8);
        r15.put(r5, r0);
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b6, code lost:
        if (r6 == null) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00be, code lost:
        if (r6.contains("DALVIK THREADS") != false) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c0, code lost:
        r0.append(r6);
        r0.append(r13);
        r6 = r4.readLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cc, code lost:
        r23 = r3;
        r11 = r8;
        r1 = r16;
        r14 = r17;
        r6 = r18;
        r3 = r19;
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r6 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r15.put(r3, r6);
        r2.add(r6);
        r0 = new java.lang.StringBuilder();
        r11 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ef, code lost:
        r21 = r6;
        r26 = r26;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f1, code lost:
        r14 = 0;
        r26 = r26;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r6 = r4.readLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f6, code lost:
        if (r6 == null) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f8, code lost:
        r22 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r8 = r6.contains("----- end ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0100, code lost:
        if (r8 != 0) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0108, code lost:
        r23 = r3;
        r3 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010c, code lost:
        if (r6.contains("prio") == false) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0114, code lost:
        if (r6.contains("tid") == false) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0117, code lost:
        if (r14 <= 1) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0119, code lost:
        r1.add(r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0124, code lost:
        if (r11.length() <= 0) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0126, code lost:
        r2.add(r11.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012d, code lost:
        r0.setLength(0);
        r11.setLength(0);
        r11.append(r6);
        r11.append(r13);
        r8 = java.util.regex.Pattern.compile("\".*\"").matcher(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0148, code lost:
        if (r8.find() == false) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x014a, code lost:
        r6 = r8.group().replace("\"", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0154, code lost:
        r0.append(r6);
        r0.append(r13);
        r8 = r22;
        r3 = r23;
        r26 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0160, code lost:
        r22 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0161, code lost:
        r8 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0167, code lost:
        if (r6.startsWith(r8) == false) goto L_0x0175;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0169, code lost:
        r0.append(r6.replace(r8, r3));
        r0.append(r13);
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0175, code lost:
        r11.append(r6);
        r11.append(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x017b, code lost:
        r26 = r8;
        r8 = r22;
        r3 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0183, code lost:
        r23 = r3;
        r22 = r22;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0186, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0187, code lost:
        r23 = r3;
        r22 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x018a, code lost:
        r23 = r3;
        r22 = r8;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x018e, code lost:
        r6 = r21;
        r22 = r22;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0191, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0192, code lost:
        r23 = r3;
        r22 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0196, code lost:
        r1 = r16;
        r14 = r17;
        r3 = r19;
        r2 = r20;
        r6 = r21;
        r22 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01a1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01a2, code lost:
        r23 = r3;
        r21 = r6;
        r22 = r8;
        r6 = r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v4
  assigns: []
  uses: []
  mth insns count: 468
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
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0322 A[ExcHandler: OutOfMemoryError (e java.lang.OutOfMemoryError), Splitter:B:41:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0349 A[Catch:{ Exception -> 0x03c0 }] */
    /* JADX WARNING: Unknown variable types count: 76 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.Object> b(java.lang.String r27) {
        /*
            java.lang.String r0 = "  at "
            java.lang.String r1 = "errorOriLine"
            java.lang.String r2 = "errorLine"
            java.lang.String r3 = "anrMsg"
            java.lang.String r4 = "mainThread"
            java.lang.String r5 = "time"
            java.lang.String r6 = "traceList"
            java.lang.String r7 = "pid"
            java.lang.String r8 = "threadList"
            java.lang.String r9 = "errorType"
            java.lang.String r10 = "apiType"
            java.lang.String r11 = "-----"
            java.lang.String r12 = "ANR"
            java.lang.String r13 = "\n"
            java.lang.String r14 = "N/A"
            java.util.HashMap r15 = new java.util.HashMap
            r15.<init>()
            r16 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r17 = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r18 = r14
            java.io.FileInputStream r14 = new java.io.FileInputStream     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0322 }
            r19 = r4
            r4 = r27
            r14.<init>(r4)     // Catch:{ Exception -> 0x0315, OutOfMemoryError -> 0x0322 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0315, OutOfMemoryError -> 0x0322 }
            r20 = r6
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0307, OutOfMemoryError -> 0x0322 }
            r6.<init>(r14)     // Catch:{ Exception -> 0x0307, OutOfMemoryError -> 0x0322 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0307, OutOfMemoryError -> 0x0322 }
            java.lang.String r6 = r4.readLine()     // Catch:{ Exception -> 0x0307, OutOfMemoryError -> 0x0322 }
            java.lang.String r14 = e.c.b.e.i.b()     // Catch:{ Exception -> 0x0307, OutOfMemoryError -> 0x0322 }
            r24 = r8
            r22 = r18
            r23 = r22
            r21 = 0
        L_0x0058:
            if (r6 == 0) goto L_0x01d7
            boolean r25 = r6.startsWith(r11)     // Catch:{ Exception -> 0x01c4, OutOfMemoryError -> 0x0322 }
            if (r25 == 0) goto L_0x0097
            boolean r25 = r6.endsWith(r11)     // Catch:{ Exception -> 0x01c4, OutOfMemoryError -> 0x0322 }
            if (r25 == 0) goto L_0x0097
            java.lang.String r8 = " pid "
            boolean r8 = r6.contains(r8)     // Catch:{ Exception -> 0x01c4, OutOfMemoryError -> 0x0322 }
            if (r8 == 0) goto L_0x0097
            java.lang.String r8 = " at "
            boolean r8 = r6.contains(r8)     // Catch:{ Exception -> 0x01c4, OutOfMemoryError -> 0x0322 }
            if (r8 == 0) goto L_0x0097
            int r8 = r21 + 1
            r25 = r11
            r11 = 5
            if (r8 <= r11) goto L_0x0082
            r4.close()     // Catch:{ Exception -> 0x01c4, OutOfMemoryError -> 0x0322 }
            r0 = 0
            return r0
        L_0x0082:
            java.lang.String r11 = "----- pid | at | -----$"
            java.lang.String[] r11 = r6.split(r11)     // Catch:{ Exception -> 0x01c4, OutOfMemoryError -> 0x0322 }
            r21 = r8
            int r8 = r11.length     // Catch:{ Exception -> 0x01c4, OutOfMemoryError -> 0x0322 }
            r26 = r0
            r0 = 3
            if (r8 < r0) goto L_0x009b
            r0 = 1
            r22 = r11[r0]     // Catch:{ Exception -> 0x01c4, OutOfMemoryError -> 0x0322 }
            r0 = 2
            r23 = r11[r0]     // Catch:{ Exception -> 0x01c4, OutOfMemoryError -> 0x0322 }
            goto L_0x009b
        L_0x0097:
            r26 = r0
            r25 = r11
        L_0x009b:
            r8 = r22
            r0 = r23
            boolean r11 = r6.contains(r14)     // Catch:{ Exception -> 0x01be, OutOfMemoryError -> 0x0322 }
            if (r11 == 0) goto L_0x01a9
            r15.put(r10, r12)     // Catch:{ Exception -> 0x01be, OutOfMemoryError -> 0x0322 }
            r15.put(r9, r12)     // Catch:{ Exception -> 0x01be, OutOfMemoryError -> 0x0322 }
            r15.put(r7, r8)     // Catch:{ Exception -> 0x01be, OutOfMemoryError -> 0x0322 }
            r15.put(r5, r0)     // Catch:{ Exception -> 0x01be, OutOfMemoryError -> 0x0322 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01be, OutOfMemoryError -> 0x0322 }
            r0.<init>()     // Catch:{ Exception -> 0x01be, OutOfMemoryError -> 0x0322 }
        L_0x00b6:
            if (r6 == 0) goto L_0x00db
            java.lang.String r11 = "DALVIK THREADS"
            boolean r11 = r6.contains(r11)     // Catch:{ Exception -> 0x00cb, OutOfMemoryError -> 0x0322 }
            if (r11 != 0) goto L_0x00db
            r0.append(r6)     // Catch:{ Exception -> 0x00cb, OutOfMemoryError -> 0x0322 }
            r0.append(r13)     // Catch:{ Exception -> 0x00cb, OutOfMemoryError -> 0x0322 }
            java.lang.String r6 = r4.readLine()     // Catch:{ Exception -> 0x00cb, OutOfMemoryError -> 0x0322 }
            goto L_0x00b6
        L_0x00cb:
            r0 = move-exception
            r23 = r3
            r11 = r8
            r1 = r16
            r14 = r17
            r6 = r18
            r3 = r19
            r2 = r20
            goto L_0x01d3
        L_0x00db:
            java.lang.String r6 = r0.toString()     // Catch:{ Exception -> 0x01be, OutOfMemoryError -> 0x0322 }
            r15.put(r3, r6)     // Catch:{ Exception -> 0x01a1, OutOfMemoryError -> 0x0322 }
            r2.add(r6)     // Catch:{ Exception -> 0x01a1, OutOfMemoryError -> 0x0322 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a1, OutOfMemoryError -> 0x0322 }
            r0.<init>()     // Catch:{ Exception -> 0x01a1, OutOfMemoryError -> 0x0322 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a1, OutOfMemoryError -> 0x0322 }
            r11.<init>()     // Catch:{ Exception -> 0x01a1, OutOfMemoryError -> 0x0322 }
            r21 = r6
        L_0x00f1:
            r14 = 0
        L_0x00f2:
            java.lang.String r6 = r4.readLine()     // Catch:{ Exception -> 0x0191, OutOfMemoryError -> 0x0322 }
            if (r6 == 0) goto L_0x018a
            r22 = r8
            java.lang.String r8 = "----- end "
            boolean r8 = r6.contains(r8)     // Catch:{ Exception -> 0x0186, OutOfMemoryError -> 0x0322 }
            if (r8 != 0) goto L_0x0183
            java.lang.String r8 = "prio"
            boolean r8 = r6.contains(r8)     // Catch:{ Exception -> 0x0186, OutOfMemoryError -> 0x0322 }
            r23 = r3
            java.lang.String r3 = ""
            if (r8 == 0) goto L_0x0161
            java.lang.String r8 = "tid"
            boolean r8 = r6.contains(r8)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            if (r8 == 0) goto L_0x0161
            r8 = 1
            if (r14 <= r8) goto L_0x0120
            java.lang.String r8 = r0.toString()     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            r1.add(r8)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
        L_0x0120:
            int r8 = r11.length()     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            if (r8 <= 0) goto L_0x012d
            java.lang.String r8 = r11.toString()     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            r2.add(r8)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
        L_0x012d:
            r8 = 0
            r0.setLength(r8)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            r11.setLength(r8)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            r11.append(r6)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            r11.append(r13)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            java.lang.String r8 = "\".*\""
            java.util.regex.Pattern r8 = java.util.regex.Pattern.compile(r8)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            java.util.regex.Matcher r8 = r8.matcher(r6)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            boolean r14 = r8.find()     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            if (r14 == 0) goto L_0x0154
            java.lang.String r6 = r8.group()     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            java.lang.String r8 = "\""
            java.lang.String r6 = r6.replace(r8, r3)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
        L_0x0154:
            r0.append(r6)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            r0.append(r13)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            r8 = r22
            r3 = r23
            goto L_0x00f1
        L_0x015f:
            r0 = move-exception
            goto L_0x0196
        L_0x0161:
            r8 = r26
            boolean r25 = r6.startsWith(r8)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            if (r25 == 0) goto L_0x0175
            java.lang.String r3 = r6.replace(r8, r3)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            r0.append(r3)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            r0.append(r13)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            int r14 = r14 + 1
        L_0x0175:
            r11.append(r6)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            r11.append(r13)     // Catch:{ Exception -> 0x015f, OutOfMemoryError -> 0x0322 }
            r26 = r8
            r8 = r22
            r3 = r23
            goto L_0x00f2
        L_0x0183:
            r23 = r3
            goto L_0x018e
        L_0x0186:
            r0 = move-exception
            r23 = r3
            goto L_0x0196
        L_0x018a:
            r23 = r3
            r22 = r8
        L_0x018e:
            r6 = r21
            goto L_0x01db
        L_0x0191:
            r0 = move-exception
            r23 = r3
            r22 = r8
        L_0x0196:
            r1 = r16
            r14 = r17
            r3 = r19
            r2 = r20
            r6 = r21
            goto L_0x01d1
        L_0x01a1:
            r0 = move-exception
            r23 = r3
            r21 = r6
            r22 = r8
            goto L_0x0200
        L_0x01a9:
            r23 = r3
            r22 = r8
            r8 = r26
            java.lang.String r6 = r4.readLine()     // Catch:{ Exception -> 0x01bc, OutOfMemoryError -> 0x0322 }
            r3 = r23
            r11 = r25
            r23 = r0
            r0 = r8
            goto L_0x0058
        L_0x01bc:
            r0 = move-exception
            goto L_0x01c7
        L_0x01be:
            r0 = move-exception
            r23 = r3
            r22 = r8
            goto L_0x01c7
        L_0x01c4:
            r0 = move-exception
            r23 = r3
        L_0x01c7:
            r1 = r16
            r14 = r17
            r6 = r18
        L_0x01cd:
            r3 = r19
            r2 = r20
        L_0x01d1:
            r11 = r22
        L_0x01d3:
            r8 = r24
            goto L_0x0336
        L_0x01d7:
            r23 = r3
            r6 = r18
        L_0x01db:
            int r0 = r1.size()     // Catch:{ Exception -> 0x02f9, OutOfMemoryError -> 0x0322 }
            java.lang.String r3 = "###"
            if (r0 <= 0) goto L_0x0214
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020f, OutOfMemoryError -> 0x0322 }
            r0.<init>()     // Catch:{ Exception -> 0x020f, OutOfMemoryError -> 0x0322 }
            java.util.Iterator r8 = r1.iterator()     // Catch:{ Exception -> 0x020f, OutOfMemoryError -> 0x0322 }
        L_0x01ec:
            boolean r11 = r8.hasNext()     // Catch:{ Exception -> 0x020f, OutOfMemoryError -> 0x0322 }
            if (r11 == 0) goto L_0x0205
            java.lang.Object r11 = r8.next()     // Catch:{ Exception -> 0x01ff, OutOfMemoryError -> 0x0322 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x01ff, OutOfMemoryError -> 0x0322 }
            r0.append(r11)     // Catch:{ Exception -> 0x01ff, OutOfMemoryError -> 0x0322 }
            r0.append(r3)     // Catch:{ Exception -> 0x01ff, OutOfMemoryError -> 0x0322 }
            goto L_0x01ec
        L_0x01ff:
            r0 = move-exception
        L_0x0200:
            r1 = r16
            r14 = r17
            goto L_0x01cd
        L_0x0205:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x020f, OutOfMemoryError -> 0x0322 }
            r8 = r24
            r15.put(r8, r0)     // Catch:{ Exception -> 0x02ef, OutOfMemoryError -> 0x0322 }
            goto L_0x0216
        L_0x020f:
            r0 = move-exception
            r8 = r24
            goto L_0x02f0
        L_0x0214:
            r8 = r24
        L_0x0216:
            int r0 = r2.size()     // Catch:{ Exception -> 0x02ef, OutOfMemoryError -> 0x0322 }
            if (r0 <= 0) goto L_0x0247
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0242, OutOfMemoryError -> 0x0322 }
            r0.<init>()     // Catch:{ Exception -> 0x0242, OutOfMemoryError -> 0x0322 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0242, OutOfMemoryError -> 0x0322 }
        L_0x0225:
            boolean r11 = r2.hasNext()     // Catch:{ Exception -> 0x0242, OutOfMemoryError -> 0x0322 }
            if (r11 == 0) goto L_0x0238
            java.lang.Object r11 = r2.next()     // Catch:{ Exception -> 0x02ef, OutOfMemoryError -> 0x0322 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x02ef, OutOfMemoryError -> 0x0322 }
            r0.append(r11)     // Catch:{ Exception -> 0x02ef, OutOfMemoryError -> 0x0322 }
            r0.append(r3)     // Catch:{ Exception -> 0x02ef, OutOfMemoryError -> 0x0322 }
            goto L_0x0225
        L_0x0238:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0242, OutOfMemoryError -> 0x0322 }
            r2 = r20
            r15.put(r2, r0)     // Catch:{ Exception -> 0x02e7, OutOfMemoryError -> 0x0322 }
            goto L_0x0249
        L_0x0242:
            r0 = move-exception
            r2 = r20
            goto L_0x02e8
        L_0x0247:
            r2 = r20
        L_0x0249:
            int r0 = r1.size()     // Catch:{ Exception -> 0x02e7, OutOfMemoryError -> 0x0322 }
            if (r0 <= 0) goto L_0x02d7
            java.util.Iterator r0 = r1.iterator()     // Catch:{ Exception -> 0x02e7, OutOfMemoryError -> 0x0322 }
        L_0x0253:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x02e7, OutOfMemoryError -> 0x0322 }
            if (r1 == 0) goto L_0x02d7
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x02e7, OutOfMemoryError -> 0x0322 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x02e7, OutOfMemoryError -> 0x0322 }
            java.lang.String r3 = "main\n"
            boolean r3 = r1.startsWith(r3)     // Catch:{ Exception -> 0x02e7, OutOfMemoryError -> 0x0322 }
            if (r3 == 0) goto L_0x0253
            r3 = r19
            r15.put(r3, r1)     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            java.lang.String[] r0 = r1.split(r13)     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            r1 = 1
        L_0x0271:
            int r11 = r0.length     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            if (r1 >= r11) goto L_0x0282
            r11 = r0[r1]     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            boolean r11 = c(r11)     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            if (r11 == 0) goto L_0x027f
            r1 = r0[r1]     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            goto L_0x0284
        L_0x027f:
            int r1 = r1 + 1
            goto L_0x0271
        L_0x0282:
            r1 = r18
        L_0x0284:
            r11 = r18
            boolean r14 = r1.equals(r11)     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            if (r14 == 0) goto L_0x0296
            int r14 = r0.length     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            r18 = r1
            r1 = 1
            if (r14 <= r1) goto L_0x0298
            r14 = r0[r1]     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            r1 = r14
            goto L_0x029a
        L_0x0296:
            r18 = r1
        L_0x0298:
            r1 = r18
        L_0x029a:
            int r14 = r0.length     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            r18 = 1
            int r14 = r14 + -1
        L_0x029f:
            if (r14 <= 0) goto L_0x02af
            r18 = r0[r14]     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            boolean r18 = c(r18)     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            if (r18 == 0) goto L_0x02ac
            r14 = r0[r14]     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            goto L_0x02b0
        L_0x02ac:
            int r14 = r14 + -1
            goto L_0x029f
        L_0x02af:
            r14 = r11
        L_0x02b0:
            boolean r11 = r14.equals(r11)     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            if (r11 == 0) goto L_0x02be
            int r11 = r0.length     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            if (r11 <= 0) goto L_0x02be
            int r11 = r0.length     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
            r14 = 1
            int r11 = r11 - r14
            r14 = r0[r11]     // Catch:{ Exception -> 0x02d1, OutOfMemoryError -> 0x0322 }
        L_0x02be:
            r11 = r17
            r15.put(r11, r1)     // Catch:{ Exception -> 0x02cc, OutOfMemoryError -> 0x0322 }
            r1 = r16
            r15.put(r1, r14)     // Catch:{ Exception -> 0x02ca, OutOfMemoryError -> 0x0322 }
            r14 = r11
            goto L_0x02dd
        L_0x02ca:
            r0 = move-exception
            goto L_0x02cf
        L_0x02cc:
            r0 = move-exception
            r1 = r16
        L_0x02cf:
            r14 = r11
            goto L_0x0304
        L_0x02d1:
            r0 = move-exception
            r1 = r16
            r14 = r17
            goto L_0x0304
        L_0x02d7:
            r1 = r16
            r14 = r17
            r3 = r19
        L_0x02dd:
            r4.close()     // Catch:{ Exception -> 0x02e5, OutOfMemoryError -> 0x0322 }
            a(r15)     // Catch:{ Exception -> 0x02e5, OutOfMemoryError -> 0x0322 }
            goto L_0x03c5
        L_0x02e5:
            r0 = move-exception
            goto L_0x0304
        L_0x02e7:
            r0 = move-exception
        L_0x02e8:
            r1 = r16
            r14 = r17
            r3 = r19
            goto L_0x0304
        L_0x02ef:
            r0 = move-exception
        L_0x02f0:
            r1 = r16
            r14 = r17
            r3 = r19
            r2 = r20
            goto L_0x0304
        L_0x02f9:
            r0 = move-exception
            r1 = r16
            r14 = r17
            r3 = r19
            r2 = r20
            r8 = r24
        L_0x0304:
            r11 = r22
            goto L_0x0336
        L_0x0307:
            r0 = move-exception
            r23 = r3
            r1 = r16
            r14 = r17
            r11 = r18
            r3 = r19
            r2 = r20
            goto L_0x0335
        L_0x0315:
            r0 = move-exception
            r23 = r3
            r2 = r6
            r1 = r16
            r14 = r17
            r11 = r18
            r3 = r19
            goto L_0x0335
        L_0x0322:
            r0 = move-exception
            java.lang.String r1 = "内存溢出了！"
        L_0x0325:
            e.c.b.f.a.a(r1, r0)
            goto L_0x03c5
        L_0x032a:
            r0 = move-exception
            r23 = r3
            r3 = r4
            r2 = r6
            r1 = r16
            r14 = r17
            r11 = r18
        L_0x0335:
            r6 = r11
        L_0x0336:
            java.lang.String r4 = "读取traces.txt文件失败!"
            e.c.b.f.a.a(r4, r0)
            android.os.Looper r4 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x03c0 }
            java.lang.Thread r4 = r4.getThread()     // Catch:{ Exception -> 0x03c0 }
            java.lang.StackTraceElement[] r4 = r4.getStackTrace()     // Catch:{ Exception -> 0x03c0 }
            if (r4 == 0) goto L_0x03c5
            r16 = r1
            int r1 = r4.length     // Catch:{ Exception -> 0x03c0 }
            if (r1 <= 0) goto L_0x03c5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c0 }
            r1.<init>()     // Catch:{ Exception -> 0x03c0 }
            r19 = r3
            r17 = r14
            r14 = 0
        L_0x0358:
            int r3 = r4.length     // Catch:{ Exception -> 0x03c0 }
            if (r14 >= r3) goto L_0x036a
            r3 = r4[r14]     // Catch:{ Exception -> 0x03c0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x03c0 }
            r1.append(r3)     // Catch:{ Exception -> 0x03c0 }
            r1.append(r13)     // Catch:{ Exception -> 0x03c0 }
            int r14 = r14 + 1
            goto L_0x0358
        L_0x036a:
            r15.put(r10, r12)     // Catch:{ Exception -> 0x03c0 }
            r15.put(r9, r12)     // Catch:{ Exception -> 0x03c0 }
            r15.put(r7, r11)     // Catch:{ Exception -> 0x03c0 }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x03c0 }
            java.lang.Long r3 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x03c0 }
            r15.put(r5, r3)     // Catch:{ Exception -> 0x03c0 }
            r3 = r23
            r15.put(r3, r6)     // Catch:{ Exception -> 0x03c0 }
            java.lang.String r3 = e.c.b.e.i.e()     // Catch:{ Exception -> 0x03c0 }
            r15.put(r8, r3)     // Catch:{ Exception -> 0x03c0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c0 }
            java.lang.String r5 = "读取trace文件失败：\n"
            r3.<init>(r5)     // Catch:{ Exception -> 0x03c0 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x03c0 }
            r3.append(r0)     // Catch:{ Exception -> 0x03c0 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x03c0 }
            r15.put(r2, r0)     // Catch:{ Exception -> 0x03c0 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x03c0 }
            r1 = r19
            r15.put(r1, r0)     // Catch:{ Exception -> 0x03c0 }
            r1 = 0
            r0 = r4[r1]     // Catch:{ Exception -> 0x03c0 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c0 }
            r2 = r17
            r15.put(r2, r0)     // Catch:{ Exception -> 0x03c0 }
            r0 = r4[r1]     // Catch:{ Exception -> 0x03c0 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03c0 }
            r1 = r16
            r15.put(r1, r0)     // Catch:{ Exception -> 0x03c0 }
            goto L_0x03c5
        L_0x03c0:
            r0 = move-exception
            java.lang.String r1 = "7.0+封装anr数据失败!"
            goto L_0x0325
        L_0x03c5:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.g.b.b(java.lang.String):java.util.Map");
    }

    public static boolean c(String str) {
        String[] strArr = {"android.", "java.", "dalvik.", "com.android."};
        for (int i2 = 0; i2 < 4; i2++) {
            if (str.startsWith(strArr[i2])) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0073, code lost:
        e.c.b.f.a.b("===line.contains(tracesWroteLog)===");
        r12 = b(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007e, code lost:
        if (e.c.b.d.H == null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0080, code lost:
        e.c.b.d.H.a(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
        r1 = e.c.b.e.i.a(r11.f5922a, (java.lang.Throwable) null, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008c, code lost:
        if (r12 == null) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0092, code lost:
        if (r12.size() != 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        ((java.util.HashMap) r1).putAll(r12);
        e.c.b.e.i.a(r1);
        e.c.b.e.i.a(r11.f5922a, e.c.b.e.i.b(r1));
        e.c.b.e.i.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ae, code lost:
        if (e.c.b.e.i.g() == false) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b0, code lost:
        e.c.b.f.a.b("===uploadAnr===");
        e.c.b.g.g.a(false, r11.f5922a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bb, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "===readLog()==="
            e.c.b.f.a.b(r0)
            boolean r0 = r11.f5923b
            if (r0 == 0) goto L_0x000a
            return
        L_0x000a:
            r0 = 1
            r11.f5923b = r0
            r0 = 0
            java.lang.String r1 = "===readingTrace==="
            e.c.b.f.a.b(r1)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            java.lang.String r1 = "MM-dd HH:mm:ss.SSS"
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            java.lang.String r1 = "Wrote stack traces to '/data/anr/traces.txt'"
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            r4 = 27
            if (r3 < r4) goto L_0x0024
            java.lang.String r1 = "Wrote stack traces to '[tombstoned]'"
        L_0x0024:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            java.lang.Long r5 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            java.lang.String r2 = r2.format(r5)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            java.lang.Runtime r5 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            java.lang.String r6 = "logcat -v time"
            java.lang.Process r5 = r5.exec(r6)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            r7.<init>(r5)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            r5 = 8192(0x2000, float:1.14794E-41)
            r6.<init>(r7, r5)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
        L_0x004a:
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            long r7 = r7 - r3
            r9 = 30000(0x7530, double:1.4822E-319)
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x00c6
            java.lang.String r5 = r6.readLine()     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            if (r5 == 0) goto L_0x00c6
            int r7 = r5.length()     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            r8 = 18
            if (r7 < r8) goto L_0x00c6
            java.lang.String r7 = r5.substring(r0, r8)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            int r7 = r7.compareTo(r2)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            if (r7 < 0) goto L_0x004a
            boolean r5 = r5.contains(r1)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            if (r5 == 0) goto L_0x004a
            java.lang.String r1 = "===line.contains(tracesWroteLog)==="
            e.c.b.f.a.b(r1)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            java.util.Map r12 = b(r12)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            e.c.b.b r1 = e.c.b.d.H     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            if (r1 == 0) goto L_0x0085
            e.c.b.b r1 = e.c.b.d.H     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            r1.a(r12)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
        L_0x0085:
            android.content.Context r1 = r11.f5922a     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            r2 = 0
            java.util.Map r1 = e.c.b.e.i.a(r1, r2, r0)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            if (r12 == 0) goto L_0x00bb
            int r2 = r12.size()     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            if (r2 != 0) goto L_0x0095
            goto L_0x00bb
        L_0x0095:
            r2 = r1
            java.util.HashMap r2 = (java.util.HashMap) r2
            r2.putAll(r12)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            e.c.b.e.i.a(r1)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            java.lang.String r12 = e.c.b.e.i.b(r1)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            android.content.Context r1 = r11.f5922a     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            e.c.b.e.i.a(r1, r12)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            e.c.b.e.i.i()     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            boolean r12 = e.c.b.e.i.g()     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            if (r12 == 0) goto L_0x00c6
            java.lang.String r12 = "===uploadAnr==="
            e.c.b.f.a.b(r12)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            android.content.Context r12 = r11.f5922a     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            e.c.b.g.g.a(r0, r12)     // Catch:{ Exception -> 0x00c0, OutOfMemoryError -> 0x00bc }
            goto L_0x00c6
        L_0x00bb:
            return
        L_0x00bc:
            r12 = move-exception
            java.lang.String r1 = "内存溢出了！"
            goto L_0x00c3
        L_0x00c0:
            r12 = move-exception
            java.lang.String r1 = "ANR Log"
        L_0x00c3:
            e.c.b.f.a.a(r1, r12)
        L_0x00c6:
            r11.f5923b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.g.b.a(java.lang.String):void");
    }
}
