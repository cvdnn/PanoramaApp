package com.baidu.picapture.nativeapi;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a;
import com.tencent.connect.common.Constants;
import e.c.f.n.n;
import e.i.a.c;
import e.i.a.e;
import e.i.a.f;
import e.i.a.g;
import e.i.a.h.l.b;
import e.i.a.h.l.c.b.C0130b;
import g.d0.h.t;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Download {

    /* renamed from: a reason: collision with root package name */
    public Context f1960a;

    /* renamed from: b reason: collision with root package name */
    public Map<String, a> f1961b = new Hashtable();

    /* renamed from: c reason: collision with root package name */
    public Map<String, c> f1962c = new Hashtable();

    /* renamed from: d reason: collision with root package name */
    public Map<String, String> f1963d = new Hashtable();

    /* renamed from: e reason: collision with root package name */
    public e.i.a.a f1964e = new b() {
        public void blockEnd(c cVar, int i2, e.i.a.h.d.a aVar, f fVar) {
        }

        public void connectEnd(c cVar, int i2, int i3, Map<String, List<String>> map) {
        }

        public void connectStart(c cVar, int i2, Map<String, List<String>> map) {
        }

        public void infoReady(c cVar, e.i.a.h.d.c cVar2, boolean z, C0130b bVar) {
            long d2 = cVar2.d();
            if (d2 <= 0) {
                cVar.f();
                Download.this.b(0, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, cVar.a(1).toString(), "");
            }
            cVar.a(3, Long.valueOf(d2));
        }

        public void progress(c cVar, long j2, f fVar) {
            String obj = cVar.a(1).toString();
            int longValue = (int) ((j2 * 100) / ((Long) cVar.a(3)).longValue());
            if (((Integer) cVar.a(0)).intValue() < longValue) {
                Download.this.b(longValue, "1", obj, cVar.a(2).toString());
                cVar.a(0, Integer.valueOf(longValue));
            }
        }

        public void progressBlock(c cVar, int i2, long j2, f fVar) {
        }

        public void taskEnd(c cVar, e.i.a.h.e.a aVar, Exception exc, f fVar) {
            g a2 = n.a(cVar);
            g gVar = g.COMPLETED;
            if (a2 == gVar) {
                a2 = gVar;
            } else {
                e.i.a.h.g.b bVar = e.a().f8664a;
                if (bVar.e(cVar)) {
                    a2 = g.PENDING;
                } else if (bVar.f(cVar)) {
                    a2 = g.RUNNING;
                }
            }
            a2.toString();
            aVar.toString();
            Download download = Download.this;
            if (download != null) {
                String obj = cVar.a(1).toString();
                if (exc != null) {
                    exc.toString();
                }
                int ordinal = aVar.ordinal();
                if (ordinal != 0) {
                    String str = "";
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal != 5) {
                                download.b(0, Constants.VIA_REPORT_TYPE_WPA_STATE, obj, str);
                            }
                        }
                    }
                    if (exc != null) {
                        if (exc instanceof SocketTimeoutException) {
                            download.b(0, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, obj, str);
                        } else if (exc instanceof t) {
                            download.b(0, Constants.VIA_REPORT_TYPE_SET_AVATAR, obj, str);
                        } else if (exc instanceof UnknownHostException) {
                            download.b(0, "13", obj, str);
                        } else if (exc instanceof IOException) {
                            download.b(0, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, obj, str);
                        } else {
                            download.b(0, "20", obj, str);
                        }
                    }
                } else {
                    String obj2 = cVar.a(1).toString();
                    download.b(100, "0", obj2, cVar.a(2).toString());
                    cVar.f();
                    if (!download.f1963d.isEmpty()) {
                        String str2 = (String) download.f1963d.get(obj2);
                        if (!TextUtils.isEmpty(str2)) {
                            MediaScannerConnection.scanFile(download.f1960a, new String[]{str2}, null, null);
                            download.f1963d.remove(obj2);
                        }
                    }
                }
                Download download2 = Download.this;
                String obj3 = cVar.a(1).toString();
                if (!download2.f1962c.isEmpty()) {
                    download2.f1962c.remove(obj3);
                }
                if (!download2.f1961b.isEmpty()) {
                    download2.f1961b.remove(obj3);
                    return;
                }
                return;
            }
            throw null;
        }

        public void taskStart(c cVar) {
        }
    };

    /* renamed from: com.baidu.picapture.nativeapi.Download$2 reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a reason: collision with root package name */
        public static final /* synthetic */ int[] f1966a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|7|8|9|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0025 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                e.i.a.h.e.a[] r0 = e.i.a.h.e.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1966a = r0
                r1 = 1
                e.i.a.h.e.a r2 = e.i.a.h.e.a.COMPLETED     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f1966a     // Catch:{ NoSuchFieldError -> 0x0016 }
                e.i.a.h.e.a r2 = e.i.a.h.e.a.CANCELED     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r2] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r0 = 3
                int[] r2 = f1966a     // Catch:{ NoSuchFieldError -> 0x001d }
                e.i.a.h.e.a r3 = e.i.a.h.e.a.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r1 = 4
                r2 = 5
                int[] r3 = f1966a     // Catch:{ NoSuchFieldError -> 0x0025 }
                e.i.a.h.e.a r4 = e.i.a.h.e.a.PRE_ALLOCATE_FAILED     // Catch:{ NoSuchFieldError -> 0x0025 }
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0025 }
            L_0x0025:
                int[] r3 = f1966a     // Catch:{ NoSuchFieldError -> 0x002b }
                e.i.a.h.e.a r4 = e.i.a.h.e.a.FILE_BUSY     // Catch:{ NoSuchFieldError -> 0x002b }
                r3[r0] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r0 = f1966a     // Catch:{ NoSuchFieldError -> 0x0032 }
                e.i.a.h.e.a r2 = e.i.a.h.e.a.SAME_TASK_BUSY     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.picapture.nativeapi.Download.AnonymousClass2.<clinit>():void");
        }
    }

    public Download(Context context) {
        this.f1960a = context;
    }

    public final String a(int i2, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("progress", i2);
            jSONObject.put("errorCode", str);
            jSONObject.put("downloadId", str2);
            jSONObject.put("relativePath", str3);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.toString();
            return null;
        }
    }

    public final void b(int i2, String str, String str2, String str3) {
        if (!this.f1961b.isEmpty()) {
            a aVar = (a) this.f1961b.get(str2);
            if (aVar != null) {
                aVar.a(a(i2, str, str2, str3));
            }
        }
    }

    @JavascriptInterface
    public void cancel(String str, a aVar) {
        if (str == null) {
            try {
                aVar.a("3");
            } catch (Exception e2) {
                e2.toString();
                aVar.a("4");
            }
        } else {
            String str2 = "2";
            if (!this.f1962c.isEmpty()) {
                if (this.f1962c.containsKey(str)) {
                    c cVar = (c) this.f1962c.get(str);
                    if (cVar == null) {
                        aVar.a(str2);
                        this.f1962c.remove(str);
                        return;
                    } else if (!str.equals(cVar.a(1).toString())) {
                        aVar.a("5");
                        return;
                    } else {
                        cVar.f();
                        aVar.a("0");
                        this.f1962c.remove(str);
                        return;
                    }
                }
            }
            aVar.a(str2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d A[Catch:{ all -> 0x00f2, Exception -> 0x017e }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b A[Catch:{ all -> 0x00f2, Exception -> 0x017e }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085 A[Catch:{ all -> 0x00f2, Exception -> 0x017e }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ff A[Catch:{ all -> 0x00f2, Exception -> 0x017e }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0107 A[Catch:{ all -> 0x00f2, Exception -> 0x017e }] */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start(java.lang.String r30, com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a r31) {
        /*
            r29 = this;
            r1 = r29
            r2 = r31
            java.lang.String r0 = "overwrite"
            java.lang.String r3 = "to"
            java.lang.String r4 = "url"
            java.lang.String r5 = ""
            java.lang.String r6 = e.c.b.e.i.k()
            r7 = 0
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x017e }
            r9 = r30
            r8.<init>(r9)     // Catch:{ Exception -> 0x017e }
            boolean r9 = r8.has(r4)     // Catch:{ Exception -> 0x017e }
            if (r9 == 0) goto L_0x0174
            boolean r9 = r8.isNull(r4)     // Catch:{ Exception -> 0x017e }
            if (r9 != 0) goto L_0x0174
            java.lang.String r9 = r8.getString(r4)     // Catch:{ Exception -> 0x017e }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x017e }
            if (r9 == 0) goto L_0x0030
            goto L_0x0174
        L_0x0030:
            java.lang.String r11 = r8.getString(r4)     // Catch:{ Exception -> 0x017e }
            boolean r4 = r8.has(r3)     // Catch:{ Exception -> 0x017e }
            if (r4 == 0) goto L_0x016a
            boolean r4 = r8.isNull(r3)     // Catch:{ Exception -> 0x017e }
            if (r4 != 0) goto L_0x016a
            java.lang.String r4 = r8.getString(r3)     // Catch:{ Exception -> 0x017e }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x017e }
            if (r4 == 0) goto L_0x004c
            goto L_0x016a
        L_0x004c:
            java.lang.String r3 = r8.getString(r3)     // Catch:{ Exception -> 0x017e }
            boolean r4 = r8.has(r0)     // Catch:{ Exception -> 0x017e }
            if (r4 == 0) goto L_0x0062
            boolean r4 = r8.isNull(r0)     // Catch:{ Exception -> 0x017e }
            if (r4 == 0) goto L_0x005d
            goto L_0x0062
        L_0x005d:
            boolean r0 = r8.getBoolean(r0)     // Catch:{ Exception -> 0x017e }
            goto L_0x0063
        L_0x0062:
            r0 = r7
        L_0x0063:
            java.lang.String r4 = e.c.d.n.e.n(r3)     // Catch:{ Exception -> 0x017e }
            int r8 = r4.lastIndexOf(r3)     // Catch:{ Exception -> 0x017e }
            if (r0 != 0) goto L_0x0071
            java.lang.String r4 = e.c.d.n.e.d(r4)     // Catch:{ Exception -> 0x017e }
        L_0x0071:
            java.lang.String r0 = e.c.d.n.e.e(r4)     // Catch:{ Exception -> 0x017e }
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x017e }
            if (r9 == 0) goto L_0x0085
            java.lang.String r0 = "5"
            java.lang.String r0 = r1.a(r7, r0, r5, r5)     // Catch:{ Exception -> 0x017e }
            r2.a(r0)     // Catch:{ Exception -> 0x017e }
            return
        L_0x0085:
            int r9 = r4.length()     // Catch:{ Exception -> 0x017e }
            int r10 = r0.length()     // Catch:{ Exception -> 0x017e }
            int r9 = r9 - r10
            java.lang.String r9 = r4.substring(r7, r9)     // Catch:{ Exception -> 0x017e }
            boolean r10 = e.c.d.n.e.m(r9)     // Catch:{ Exception -> 0x017e }
            if (r10 != 0) goto L_0x009b
            e.c.d.n.e.b(r9)     // Catch:{ Exception -> 0x017e }
        L_0x009b:
            java.lang.String r10 = "DCIM"
            boolean r3 = r3.startsWith(r10)     // Catch:{ Exception -> 0x017e }
            if (r3 == 0) goto L_0x00a8
            java.util.Map<java.lang.String, java.lang.String> r3 = r1.f1963d     // Catch:{ Exception -> 0x017e }
            r3.put(r6, r4)     // Catch:{ Exception -> 0x017e }
        L_0x00a8:
            java.util.Map<java.lang.String, com.baidu.picapture.ui.widget.bdwebview.NativeBridge$a> r3 = r1.f1961b     // Catch:{ Exception -> 0x017e }
            r3.put(r6, r2)     // Catch:{ Exception -> 0x017e }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x017e }
            r3.<init>(r9)     // Catch:{ Exception -> 0x017e }
            android.net.Uri r3 = android.net.Uri.fromFile(r3)     // Catch:{ Exception -> 0x017e }
            r9 = 4096(0x1000, float:5.74E-42)
            r18 = 16384(0x4000, float:2.2959E-41)
            r19 = 65536(0x10000, float:9.18355E-41)
            r21 = 2000(0x7d0, float:2.803E-42)
            r22 = 1
            r23 = 0
            boolean r10 = e.i.a.h.c.b(r3)     // Catch:{ Exception -> 0x017e }
            r20 = 0
            if (r10 == 0) goto L_0x00f7
            e.i.a.e r10 = e.i.a.e.a()     // Catch:{ Exception -> 0x017e }
            android.content.Context r10 = r10.f8671h     // Catch:{ Exception -> 0x017e }
            android.content.ContentResolver r12 = r10.getContentResolver()     // Catch:{ Exception -> 0x017e }
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r3
            android.database.Cursor r10 = r12.query(r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x017e }
            if (r10 == 0) goto L_0x00f7
            r10.moveToFirst()     // Catch:{ all -> 0x00f2 }
            java.lang.String r12 = "_display_name"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ all -> 0x00f2 }
            java.lang.String r12 = r10.getString(r12)     // Catch:{ all -> 0x00f2 }
            r10.close()     // Catch:{ Exception -> 0x017e }
            goto L_0x00f9
        L_0x00f2:
            r0 = move-exception
            r10.close()     // Catch:{ Exception -> 0x017e }
            throw r0     // Catch:{ Exception -> 0x017e }
        L_0x00f7:
            r12 = r20
        L_0x00f9:
            boolean r10 = e.i.a.h.c.a(r0)     // Catch:{ Exception -> 0x017e }
            if (r10 == 0) goto L_0x0107
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r22)     // Catch:{ Exception -> 0x017e }
            r24 = r0
            r0 = r12
            goto L_0x0109
        L_0x0107:
            r24 = r20
        L_0x0109:
            r25 = 200(0xc8, float:2.8E-43)
            r27 = 0
            r15 = 1
            java.lang.Integer r28 = java.lang.Integer.valueOf(r15)     // Catch:{ Exception -> 0x017e }
            e.i.a.c r14 = new e.i.a.c     // Catch:{ Exception -> 0x017e }
            r13 = 0
            r20 = 0
            r26 = 0
            r10 = r14
            r12 = r3
            r3 = r14
            r14 = r9
            r9 = r15
            r15 = r18
            r16 = r19
            r17 = r21
            r18 = r22
            r19 = r25
            r21 = r0
            r22 = r27
            r25 = r28
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ Exception -> 0x017e }
            java.util.Map<java.lang.String, e.i.a.c> r0 = r1.f1962c     // Catch:{ Exception -> 0x017e }
            r0.put(r6, r3)     // Catch:{ Exception -> 0x017e }
            java.lang.String r0 = r4.substring(r8)     // Catch:{ Exception -> 0x017e }
            r3.a(r9, r6)     // Catch:{ Exception -> 0x017e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x017e }
            r3.a(r7, r4)     // Catch:{ Exception -> 0x017e }
            r4 = 2
            r3.a(r4, r0)     // Catch:{ Exception -> 0x017e }
            r0 = 3
            r8 = 100
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x017e }
            r3.a(r0, r4)     // Catch:{ Exception -> 0x017e }
            e.i.a.a r0 = r1.f1964e     // Catch:{ Exception -> 0x017e }
            r3.q = r0     // Catch:{ Exception -> 0x017e }
            e.i.a.e r0 = e.i.a.e.a()     // Catch:{ Exception -> 0x017e }
            e.i.a.h.g.b r0 = r0.f8664a     // Catch:{ Exception -> 0x017e }
            java.util.concurrent.atomic.AtomicInteger r4 = r0.f8798h     // Catch:{ Exception -> 0x017e }
            r4.incrementAndGet()     // Catch:{ Exception -> 0x017e }
            r0.b(r3)     // Catch:{ Exception -> 0x017e }
            java.util.concurrent.atomic.AtomicInteger r0 = r0.f8798h     // Catch:{ Exception -> 0x017e }
            r0.decrementAndGet()     // Catch:{ Exception -> 0x017e }
            goto L_0x018b
        L_0x016a:
            java.lang.String r0 = "2"
            java.lang.String r0 = r1.a(r7, r0, r5, r5)     // Catch:{ Exception -> 0x017e }
            r2.a(r0)     // Catch:{ Exception -> 0x017e }
            return
        L_0x0174:
            java.lang.String r0 = "3"
            java.lang.String r0 = r1.a(r7, r0, r5, r5)     // Catch:{ Exception -> 0x017e }
            r2.a(r0)     // Catch:{ Exception -> 0x017e }
            return
        L_0x017e:
            r0 = move-exception
            r0.toString()
            java.lang.String r0 = "4"
            java.lang.String r0 = r1.a(r7, r0, r5, r5)
            r2.a(r0)
        L_0x018b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.picapture.nativeapi.Download.start(java.lang.String, com.baidu.picapture.ui.widget.bdwebview.NativeBridge$a):void");
    }
}
