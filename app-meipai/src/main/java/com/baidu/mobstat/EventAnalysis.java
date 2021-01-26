package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Config.EventViewType;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class EventAnalysis {

    /* renamed from: a reason: collision with root package name */
    public Map<String, a> f1396a = new HashMap();

    public static class a {

        /* renamed from: a reason: collision with root package name */
        public String f1397a;

        /* renamed from: b reason: collision with root package name */
        public String f1398b;

        /* renamed from: c reason: collision with root package name */
        public long f1399c;

        public a() {
        }
    }

    private void a(Context context, long j2, String str, String str2, int i2, long j3, long j4, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        Context context2 = context;
        Context context3 = context;
        DataCore.instance().putEvent(context3, getEvent(context, j2, str, str2, i2, j3, j4, "", "", 0, 0, extraInfo, map, z));
        DataCore.instance().flush(context3);
    }

    public static boolean b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !new JSONObject().toString().equals(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str2) || new JSONArray().toString().equals(str2)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void doEventMerge(org.json.JSONArray r24, org.json.JSONObject r25) {
        /*
            r1 = r25
            java.lang.String r0 = "s"
            com.baidu.mobstat.Config$EventViewType r2 = com.baidu.mobstat.Config.EventViewType.EDIT
            r2.getValue()
            java.lang.String r2 = "ss"
            long r2 = r1.optLong(r2)     // Catch:{ JSONException -> 0x00c3 }
            java.lang.String r4 = "i"
            java.lang.String r4 = r1.getString(r4)     // Catch:{ JSONException -> 0x00c3 }
            java.lang.String r5 = "l"
            java.lang.String r5 = r1.getString(r5)     // Catch:{ JSONException -> 0x00c3 }
            java.lang.String r6 = "t"
            long r6 = r1.getLong(r6)     // Catch:{ JSONException -> 0x00c3 }
            r8 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r6 / r8
            java.lang.String r6 = r1.optString(r0)     // Catch:{ JSONException -> 0x00c3 }
            java.lang.String r9 = "at"
            int r15 = r1.optInt(r9)     // Catch:{ JSONException -> 0x00c3 }
            java.lang.String r9 = "h"
            java.lang.String r9 = r1.optString(r9)     // Catch:{ JSONException -> 0x00c3 }
            r10 = 3
            java.lang.String r11 = "h3"
            java.lang.String r12 = "h2"
            java.lang.String r13 = ""
            r14 = 0
            if (r15 == r10) goto L_0x004d
            org.json.JSONArray r10 = r1.optJSONArray(r12)     // Catch:{ JSONException -> 0x00c3 }
            org.json.JSONArray r11 = r1.optJSONArray(r11)     // Catch:{ JSONException -> 0x00c3 }
            r17 = r13
            r18 = r17
            goto L_0x005b
        L_0x004d:
            java.lang.String r10 = r1.optString(r12)     // Catch:{ JSONException -> 0x00c3 }
            java.lang.String r11 = r1.optString(r11)     // Catch:{ JSONException -> 0x00c3 }
            r17 = r10
            r18 = r11
            r10 = r14
            r11 = r10
        L_0x005b:
            java.lang.String r12 = "p"
            java.lang.String r12 = r1.optString(r12)     // Catch:{ JSONException -> 0x00c3 }
            java.lang.String r13 = "p2"
            java.lang.String r13 = r1.optString(r13)     // Catch:{ JSONException -> 0x00c3 }
            java.lang.String r14 = "rn"
            java.lang.String r14 = r1.optString(r14)     // Catch:{ JSONException -> 0x00c3 }
            r16 = r15
            java.lang.String r15 = "v"
            int r15 = r1.optInt(r15)     // Catch:{ JSONException -> 0x00c3 }
            r19 = r0
            java.lang.String r0 = "ext"
            java.lang.String r0 = r1.optString(r0)     // Catch:{ JSONException -> 0x00c3 }
            r20 = r15
            java.lang.String r15 = "attribute"
            java.lang.String r15 = r1.optString(r15)     // Catch:{ JSONException -> 0x00c3 }
            r21 = r14
            java.lang.String r14 = "h5"
            int r22 = r1.optInt(r14)     // Catch:{ JSONException -> 0x00c3 }
            java.lang.String r14 = "sign"
            java.lang.String r23 = r1.optString(r14)     // Catch:{ JSONException -> 0x00c3 }
            java.lang.String r14 = "d"
            int r14 = r1.getInt(r14)     // Catch:{ JSONException -> 0x009a }
            goto L_0x009b
        L_0x009a:
            r14 = 0
        L_0x009b:
            if (r14 != 0) goto L_0x00b3
            boolean r0 = b(r0, r15)
            if (r0 != 0) goto L_0x00b3
            r0 = r24
            r1 = r25
            r14 = r21
            r15 = r20
            r19 = r22
            r20 = r23
            a(r0, r1, r2, r4, r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            goto L_0x00c3
        L_0x00b3:
            int r0 = r24.length()
            java.lang.String r2 = "0"
            r3 = r19
            r1.put(r3, r2)     // Catch:{  }
            r2 = r24
            r2.put(r0, r1)     // Catch:{  }
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.EventAnalysis.doEventMerge(org.json.JSONArray, org.json.JSONObject):void");
    }

    public static JSONObject getEvent(Context context, long j2, String str, String str2, int i2, long j3, long j4, String str3, String str4, int i3, int i4, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        return getEvent(context, j2, str, str2, i2, j3, j4, str3, null, null, str4, null, null, i3, i4, extraInfo, map, "", "", z);
    }

    public void flushEvent(Context context, long j2, String str, String str2, int i2, long j3, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        Context context2 = context;
        String str6 = "";
        Context context3 = context;
        DataCore.instance().putEvent(context3, getEvent(context, j2, str, str2, i2, j3, 0, str6, jSONArray, jSONArray2, str3, str4, str5, EventViewType.EDIT.getValue(), 2, null, map, "", "", z));
        DataCore.instance().flush(context3);
    }

    public void onEvent(Context context, long j2, String str, String str2, int i2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        a(context, j2, str, str2, i2, j3, 0, extraInfo, map, z);
    }

    public void onEventDuration(Context context, long j2, String str, String str2, long j3, long j4, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        if (j4 > 0) {
            a(context, j2, str, str2, 1, j3, j4, extraInfo, map, z);
        }
    }

    public void onEventEnd(Context context, long j2, String str, String str2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        String str3 = str;
        String str4 = str2;
        String a2 = a(str3, str4);
        a aVar = (a) this.f1396a.get(a2);
        if (aVar == null) {
            bc c2 = bc.c();
            StringBuilder sb = new StringBuilder();
            sb.append("[WARNING] eventId: ");
            sb.append(str3);
            sb.append(", with label: ");
            sb.append(str4);
            sb.append(" is not started or alread ended");
            c2.b(sb.toString());
        } else if ((str3 == null || str3.equals(aVar.f1397a)) && (str4 == null || str4.equals(aVar.f1398b))) {
            this.f1396a.remove(a2);
            long j4 = j3 - aVar.f1399c;
            if (j4 < 0) {
                bc.c().b("[WARNING] onEventEnd must be invoked after onEventStart");
            }
            onEventDuration(context, j2, str, str2, aVar.f1399c, j4, extraInfo, map, z);
        } else {
            bc.c().b("[WARNING] eventId/label pair not match");
        }
    }

    public void onEventStart(Context context, String str, String str2, long j2) {
        a aVar = new a();
        aVar.f1399c = j2;
        aVar.f1397a = str;
        aVar.f1398b = str2;
        String a2 = a(str, str2);
        if (this.f1396a.containsKey(a2)) {
            bc c2 = bc.c();
            StringBuilder sb = new StringBuilder();
            sb.append("[WARNING] eventId: ");
            sb.append(str);
            sb.append(", with label: ");
            sb.append(str2);
            sb.append(" is duplicated, older is removed");
            c2.b(sb.toString());
        }
        this.f1396a.put(a2, aVar);
    }

    public static JSONObject getEvent(Context context, long j2, String str, String str2, int i2, long j3, long j4, String str3, JSONArray jSONArray, JSONArray jSONArray2, String str4, String str5, String str6, int i3, int i4, ExtraInfo extraInfo, Map<String, String> map, String str7, String str8, boolean z) {
        return getEvent(context, j2, str, str2, i2, j3, j4, str3, jSONArray, jSONArray2, str4, str5, str6, i3, i4, extraInfo, map, str7, str8, z, null, "");
    }

    public void onEvent(Context context, long j2, String str, String str2, int i2, long j3, String str3, String str4, int i3, boolean z) {
        a(context, j2, str, str2, i2, j3, 0, str3, str4, i3);
    }

    public static JSONObject getEvent(Context context, long j2, String str, String str2, int i2, long j3, long j4, String str3, JSONArray jSONArray, JSONArray jSONArray2, String str4, String str5, String str6, int i3, int i4, ExtraInfo extraInfo, Map<String, String> map, String str7, String str8, boolean z, JSONObject jSONObject, String str9) {
        int i5 = i4;
        JSONObject jSONObject2 = jSONObject;
        String str10 = "v";
        JSONObject jSONObject3 = new JSONObject();
        long j5 = j2;
        try {
            jSONObject3.put("ss", j2);
            String str11 = str;
            jSONObject3.put("i", str);
            String str12 = str2;
            jSONObject3.put("l", str2);
            int i6 = i2;
            jSONObject3.put("c", i2);
            jSONObject3.put("t", j3);
            jSONObject3.put("d", j4);
            jSONObject3.put("h", str3);
            String str13 = Config.EVENT_H5_VIEW_HIERARCHY;
            String str14 = Config.EVENT_NATIVE_VIEW_HIERARCHY;
            if (i5 != 3) {
                jSONObject3.put(str14, jSONArray);
                jSONObject3.put(str13, jSONArray2);
            } else {
                jSONObject3.put(str14, str7);
                jSONObject3.put(str13, str8);
            }
            jSONObject3.put("p", str4);
            jSONObject3.put(Config.EVENT_H5_PAGE, str5);
            jSONObject3.put(Config.EVENT_VIEW_RES_NAME, str6);
            jSONObject3.put(str10, i3);
            jSONObject3.put("at", i5);
            jSONObject3.put("h5", z ? 1 : 0);
            if (!(extraInfo == null || extraInfo.dumpToJson().length() == 0)) {
                jSONObject3.put("ext", extraInfo.dumpToJson());
            }
            if (map != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Entry entry : map.entrySet()) {
                    String str15 = (String) entry.getKey();
                    String str16 = (String) entry.getValue();
                    if (!TextUtils.isEmpty(str15)) {
                        if (!TextUtils.isEmpty(str16)) {
                            if (!a(str16, 1024)) {
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put(Config.APP_KEY, str15);
                                jSONObject4.put(str10, str16);
                                jSONArray3.put(jSONObject4);
                            }
                        }
                    }
                }
                if (jSONArray3.length() != 0) {
                    jSONObject3.put(Config.EVENT_ATTR, jSONArray3);
                }
            }
            if (!(jSONObject2 == null || jSONObject.length() == 0)) {
                JSONArray jSONArray4 = new JSONArray();
                jSONArray4.put(jSONObject2);
                jSONObject3.put(Config.EVENT_HEAT_POINT, jSONArray4);
            }
            jSONObject3.put("sign", TextUtils.isEmpty(str9) ? "" : str9);
        } catch (Exception unused) {
        }
        return jSONObject3;
    }

    public void onEvent(Context context, long j2, String str, String str2, int i2, long j3, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        flushEvent(context, j2, str, str2, i2, j3, jSONArray, jSONArray2, str3, str4, str5, map, z);
    }

    private void a(Context context, long j2, String str, String str2, int i2, long j3, long j4, String str3, String str4, int i3) {
        Context context2 = context;
        Context context3 = context;
        DataCore.instance().putEvent(context3, getEvent(context, j2, str, str2, i2, j3, j4, str3, str4, i3, 1, null, null, false));
        DataCore.instance().flush(context3);
    }

    private String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("__sdk_");
        sb.append(str);
        sb.append("$|$");
        sb.append(str2);
        return sb.toString();
    }

    public static boolean a(String str, int i2) {
        int i3;
        boolean z = false;
        if (str == null) {
            return false;
        }
        try {
            i3 = str.getBytes().length;
        } catch (Exception unused) {
            i3 = 0;
        }
        if (i3 > i2) {
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001a, code lost:
        if (r2.equals(r8) != false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0162, code lost:
        if (r4.equalsIgnoreCase(r5) != false) goto L_0x0169;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(org.json.JSONArray r30, org.json.JSONObject r31, long r32, java.lang.String r34, java.lang.String r35, java.lang.String r36, long r37, java.lang.String r39, org.json.JSONArray r40, org.json.JSONArray r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, int r45, int r46, java.lang.String r47, java.lang.String r48, int r49, java.lang.String r50) {
        /*
            r0 = r30
            r1 = r31
            r2 = r36
            java.lang.String r3 = "t"
            java.lang.String r4 = "c"
            int r5 = r30.length()
            java.lang.String r6 = "0|"
            java.lang.String r7 = "s"
            java.lang.String r8 = ""
            if (r2 == 0) goto L_0x001c
            boolean r2 = r2.equals(r8)     // Catch:{ JSONException -> 0x001f }
            if (r2 == 0) goto L_0x001f
        L_0x001c:
            r1.put(r7, r6)     // Catch:{ JSONException -> 0x001f }
        L_0x001f:
            r10 = r5
            r9 = 0
        L_0x0021:
            if (r9 >= r5) goto L_0x0284
            org.json.JSONObject r11 = r0.getJSONObject(r9)     // Catch:{ JSONException -> 0x0253 }
            java.lang.String r12 = "ss"
            long r12 = r11.optLong(r12)     // Catch:{ JSONException -> 0x0253 }
            java.lang.String r14 = "i"
            java.lang.String r14 = r11.getString(r14)     // Catch:{ JSONException -> 0x0253 }
            java.lang.String r15 = "l"
            java.lang.String r15 = r11.getString(r15)     // Catch:{ JSONException -> 0x0253 }
            long r16 = r11.getLong(r3)     // Catch:{ JSONException -> 0x0253 }
            r18 = 3600000(0x36ee80, double:1.7786363E-317)
            long r16 = r16 / r18
            java.lang.String r2 = "d"
            int r2 = r11.getInt(r2)     // Catch:{ JSONException -> 0x004b }
            r18 = r6
            goto L_0x004e
        L_0x004b:
            r18 = r6
            r2 = 0
        L_0x004e:
            java.lang.String r6 = "h"
            java.lang.String r6 = r11.optString(r6)     // Catch:{ JSONException -> 0x0245 }
            r19 = r10
            java.lang.String r10 = "p"
            java.lang.String r10 = r11.optString(r10)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r0 = "p2"
            java.lang.String r0 = r11.optString(r0)     // Catch:{ JSONException -> 0x022e }
            r20 = r5
            java.lang.String r5 = "rn"
            java.lang.String r5 = r11.optString(r5)     // Catch:{ JSONException -> 0x0220 }
            r21 = r9
            java.lang.String r9 = "v"
            int r9 = r11.optInt(r9)     // Catch:{ JSONException -> 0x020a }
            r22 = r3
            java.lang.String r3 = "at"
            int r3 = r11.optInt(r3)     // Catch:{ JSONException -> 0x01f5 }
            r23 = r8
            java.lang.String r8 = "h3"
            r25 = r7
            java.lang.String r7 = "h2"
            r26 = 0
            r1 = 3
            if (r3 == r1) goto L_0x0099
            org.json.JSONArray r26 = r11.optJSONArray(r7)     // Catch:{ JSONException -> 0x01e3 }
            org.json.JSONArray r1 = r11.optJSONArray(r8)     // Catch:{ JSONException -> 0x01e3 }
            r24 = r4
            r8 = r26
            r4 = r1
            r1 = r23
            r26 = r1
            goto L_0x00a8
        L_0x0099:
            java.lang.String r1 = r11.optString(r7)     // Catch:{ JSONException -> 0x01e3 }
            java.lang.String r7 = r11.optString(r8)     // Catch:{ JSONException -> 0x01e3 }
            r24 = r4
            r4 = r26
            r8 = r4
            r26 = r7
        L_0x00a8:
            java.lang.String r7 = "ext"
            java.lang.String r7 = r11.optString(r7)     // Catch:{ JSONException -> 0x01cd }
            r27 = r1
            java.lang.String r1 = "attribute"
            java.lang.String r1 = r11.optString(r1)     // Catch:{ JSONException -> 0x01cd }
            r28 = r3
            java.lang.String r3 = "h5"
            int r3 = r11.optInt(r3)     // Catch:{ JSONException -> 0x01cd }
            r29 = r3
            java.lang.String r3 = "sign"
            java.lang.String r3 = r11.optString(r3)     // Catch:{ JSONException -> 0x01cd }
            int r16 = (r16 > r37 ? 1 : (r16 == r37 ? 0 : -1))
            if (r16 != 0) goto L_0x01cd
            if (r2 == 0) goto L_0x00ce
            goto L_0x01cd
        L_0x00ce:
            boolean r1 = b(r7, r1)     // Catch:{ JSONException -> 0x01cd }
            if (r1 == 0) goto L_0x00d6
            goto L_0x01cd
        L_0x00d6:
            int r1 = (r12 > r32 ? 1 : (r12 == r32 ? 0 : -1))
            if (r1 != 0) goto L_0x01cd
            r1 = r34
            boolean r2 = r14.equals(r1)     // Catch:{ JSONException -> 0x01cd }
            if (r2 == 0) goto L_0x01cd
            r2 = r35
            boolean r7 = r15.equals(r2)     // Catch:{ JSONException -> 0x01cd }
            if (r7 == 0) goto L_0x01cd
            r7 = r39
            boolean r6 = r6.equals(r7)     // Catch:{ JSONException -> 0x01cd }
            if (r6 == 0) goto L_0x01cd
            r6 = r42
            boolean r10 = r10.equals(r6)     // Catch:{ JSONException -> 0x01cd }
            if (r10 == 0) goto L_0x01cd
            r10 = r43
            boolean r0 = r0.equals(r10)     // Catch:{ JSONException -> 0x01c8 }
            if (r0 == 0) goto L_0x01c8
            r0 = r40
            boolean r8 = a(r8, r0)     // Catch:{ JSONException -> 0x01c8 }
            if (r8 == 0) goto L_0x01c8
            r8 = r41
            boolean r4 = a(r4, r8)     // Catch:{ JSONException -> 0x01c5 }
            if (r4 == 0) goto L_0x01c5
            r4 = r44
            boolean r5 = r5.equals(r4)     // Catch:{ JSONException -> 0x01c5 }
            if (r5 == 0) goto L_0x01c5
            r5 = r45
            if (r9 != r5) goto L_0x01c5
            r9 = r46
            r12 = r28
            if (r12 != r9) goto L_0x01c2
            r12 = r47
            r13 = r27
            boolean r13 = r13.equals(r12)     // Catch:{ JSONException -> 0x01bf }
            if (r13 == 0) goto L_0x01bf
            r13 = r48
            r14 = r26
            boolean r14 = r14.equals(r13)     // Catch:{ JSONException -> 0x01bc }
            if (r14 == 0) goto L_0x01bc
            r14 = r49
            r15 = r29
            if (r15 != r14) goto L_0x01b9
            r15 = r50
            boolean r3 = r3.equals(r15)     // Catch:{ JSONException -> 0x01b6 }
            if (r3 == 0) goto L_0x01b6
            r3 = r31
            r0 = r24
            int r16 = r3.getInt(r0)     // Catch:{ JSONException -> 0x01df }
            int r17 = r11.getInt(r0)     // Catch:{ JSONException -> 0x01df }
            int r1 = r16 + r17
            r2 = r25
            java.lang.String r4 = r11.optString(r2)     // Catch:{ JSONException -> 0x0270 }
            r5 = r23
            if (r4 == 0) goto L_0x0169
            boolean r16 = r4.equalsIgnoreCase(r5)     // Catch:{ JSONException -> 0x0165 }
            if (r16 == 0) goto L_0x016b
            goto L_0x0169
        L_0x0165:
            r23 = r5
            goto L_0x0270
        L_0x0169:
            r4 = r18
        L_0x016b:
            r23 = r5
            r5 = r22
            long r16 = r3.getLong(r5)     // Catch:{ JSONException -> 0x01b2 }
            long r24 = r11.getLong(r5)     // Catch:{ JSONException -> 0x01b2 }
            long r16 = r16 - r24
            r24 = 0
            int r22 = (r16 > r24 ? 1 : (r16 == r24 ? 0 : -1))
            if (r22 >= 0) goto L_0x0184
            r22 = r5
            r5 = r24
            goto L_0x0188
        L_0x0184:
            r22 = r5
            r5 = r16
        L_0x0188:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0270 }
            r7.<init>()     // Catch:{ JSONException -> 0x0270 }
            r7.append(r4)     // Catch:{ JSONException -> 0x0270 }
            r7.append(r5)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r4 = "|"
            r7.append(r4)     // Catch:{ JSONException -> 0x0270 }
            java.lang.String r4 = r7.toString()     // Catch:{ JSONException -> 0x0270 }
            r11.remove(r0)     // Catch:{ JSONException -> 0x01ae }
            r11.put(r0, r1)     // Catch:{ JSONException -> 0x01ae }
            r11.put(r2, r4)     // Catch:{ JSONException -> 0x01ae }
            a(r11, r3)     // Catch:{ JSONException -> 0x01ae }
            r0 = r20
            r9 = r21
            goto L_0x028a
        L_0x01ae:
            r19 = r21
            goto L_0x0270
        L_0x01b2:
            r22 = r5
            goto L_0x0270
        L_0x01b6:
            r3 = r31
            goto L_0x01dd
        L_0x01b9:
            r3 = r31
            goto L_0x01db
        L_0x01bc:
            r3 = r31
            goto L_0x01d9
        L_0x01bf:
            r3 = r31
            goto L_0x01d7
        L_0x01c2:
            r3 = r31
            goto L_0x01d5
        L_0x01c5:
            r3 = r31
            goto L_0x01d3
        L_0x01c8:
            r3 = r31
            r8 = r41
            goto L_0x01d3
        L_0x01cd:
            r3 = r31
            r8 = r41
            r10 = r43
        L_0x01d3:
            r9 = r46
        L_0x01d5:
            r12 = r47
        L_0x01d7:
            r13 = r48
        L_0x01d9:
            r14 = r49
        L_0x01db:
            r15 = r50
        L_0x01dd:
            r0 = r24
        L_0x01df:
            r2 = r25
            goto L_0x0270
        L_0x01e3:
            r3 = r31
            r8 = r41
            r10 = r43
            r9 = r46
            r12 = r47
            r13 = r48
            r14 = r49
            r15 = r50
            r0 = r4
            goto L_0x01df
        L_0x01f5:
            r10 = r43
            r9 = r46
            r12 = r47
            r13 = r48
            r14 = r49
            r15 = r50
            r3 = r1
            r0 = r4
            r2 = r7
            r23 = r8
            r8 = r41
            goto L_0x0270
        L_0x020a:
            r10 = r43
            r9 = r46
            r12 = r47
            r13 = r48
            r14 = r49
            r15 = r50
            r22 = r3
            r0 = r4
            r2 = r7
            r23 = r8
            r8 = r41
            goto L_0x026f
        L_0x0220:
            r10 = r43
            r12 = r47
            r13 = r48
            r14 = r49
            r15 = r50
            r22 = r3
            r0 = r4
            goto L_0x023d
        L_0x022e:
            r10 = r43
            r12 = r47
            r13 = r48
            r14 = r49
            r15 = r50
            r22 = r3
            r0 = r4
            r20 = r5
        L_0x023d:
            r2 = r7
            r23 = r8
            r21 = r9
            r8 = r41
            goto L_0x026d
        L_0x0245:
            r12 = r47
            r13 = r48
            r14 = r49
            r15 = r50
            r22 = r3
            r0 = r4
            r20 = r5
            goto L_0x0262
        L_0x0253:
            r12 = r47
            r13 = r48
            r14 = r49
            r15 = r50
            r22 = r3
            r0 = r4
            r20 = r5
            r18 = r6
        L_0x0262:
            r2 = r7
            r23 = r8
            r21 = r9
            r19 = r10
            r8 = r41
            r10 = r43
        L_0x026d:
            r9 = r46
        L_0x026f:
            r3 = r1
        L_0x0270:
            int r1 = r21 + 1
            r4 = r0
            r9 = r1
            r7 = r2
            r1 = r3
            r6 = r18
            r10 = r19
            r5 = r20
            r3 = r22
            r8 = r23
            r0 = r30
            goto L_0x0021
        L_0x0284:
            r3 = r1
            r19 = r10
            r0 = r5
            r9 = r19
        L_0x028a:
            if (r9 >= r0) goto L_0x028d
            return
        L_0x028d:
            r1 = r30
            r1.put(r0, r3)     // Catch:{ JSONException -> 0x0292 }
        L_0x0292:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.EventAnalysis.a(org.json.JSONArray, org.json.JSONObject, long, java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, org.json.JSONArray, org.json.JSONArray, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, int, java.lang.String):void");
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            JSONArray jSONArray = new JSONArray();
            String str = Config.EVENT_HEAT_POINT;
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (!(optJSONArray == null || optJSONArray.length() == 0)) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    try {
                        jSONArray.put(optJSONArray.getJSONObject(i2));
                    } catch (Exception unused) {
                    }
                }
            }
            if (jSONArray.length() < 10) {
                JSONArray optJSONArray2 = jSONObject2.optJSONArray(str);
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        try {
                            jSONArray.put(optJSONArray2.getJSONObject(i3));
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            if (jSONArray.length() != 0) {
                try {
                    jSONObject.put(str, jSONArray);
                } catch (Exception unused3) {
                }
            }
        }
    }

    public static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || !jSONArray.toString().equals(jSONArray2.toString())) ? false : true;
    }
}
