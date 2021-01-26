package e.c.b.g;

import android.content.Context;

public final class i implements Runnable {
    public i(Context context) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a6 A[SYNTHETIC, Splitter:B:40:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae A[Catch:{ Exception -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b8 A[SYNTHETIC, Splitter:B:50:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c0 A[Catch:{ Exception -> 0x00bc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = e.c.b.e.i.f()     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            java.lang.String r3 = "sync json is "
            r2.<init>(r3)     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            r2.append(r1)     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            e.c.b.f.a.b(r2)     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            java.lang.String r3 = e.c.b.d.b()     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x009b, all -> 0x0096 }
            java.lang.String r3 = "POST"
            r2.setRequestMethod(r3)     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
            r3 = 1
            r2.setDoInput(r3)     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
            r2.setDoOutput(r3)     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
            r4 = 0
            r2.setUseCaches(r4)     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
            r2.setInstanceFollowRedirects(r3)     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
            java.lang.String r3 = "User-Agent"
            java.lang.String r5 = "sync"
            java.lang.String r5 = e.c.b.e.i.a(r5, r0)     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
            r2.setRequestProperty(r3, r5)     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
            r3 = 8000(0x1f40, float:1.121E-41)
            r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
            r2.setReadTimeout(r3)     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
            java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
            java.io.OutputStream r5 = r2.getOutputStream()     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
            r3.writeBytes(r1)     // Catch:{ Exception -> 0x008e }
            r3.flush()     // Catch:{ Exception -> 0x008e }
            r3.close()     // Catch:{ Exception -> 0x008e }
            int r0 = r2.getResponseCode()     // Catch:{ Exception -> 0x008e }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L_0x007c
            android.content.SharedPreferences$Editor r0 = e.c.b.e.h.f5907b     // Catch:{ Exception -> 0x008e }
            if (r0 == 0) goto L_0x0076
            java.lang.String r1 = "used_count"
            r0.putInt(r1, r4)     // Catch:{ Exception -> 0x008e }
            android.content.SharedPreferences$Editor r0 = e.c.b.e.h.f5907b     // Catch:{ Exception -> 0x008e }
            e.c.b.e.i.a(r0, r4)     // Catch:{ Exception -> 0x008e }
            goto L_0x0076
        L_0x0074:
            r0 = move-exception
            goto L_0x00b6
        L_0x0076:
            java.lang.String r0 = "#### ^@^ sync ok!"
        L_0x0078:
            e.c.b.f.a.a(r0)     // Catch:{ Exception -> 0x008e }
            goto L_0x007f
        L_0x007c:
            java.lang.String r0 = "#### T^T sync failed!"
            goto L_0x0078
        L_0x007f:
            r2.disconnect()     // Catch:{ Exception -> 0x008e }
            r3.close()     // Catch:{ Exception -> 0x0089 }
            r2.disconnect()     // Catch:{ Exception -> 0x0089 }
            return
        L_0x0089:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x00c8 }
            return
        L_0x008e:
            r0 = move-exception
            goto L_0x009f
        L_0x0090:
            r1 = move-exception
            r3 = r0
            goto L_0x0099
        L_0x0093:
            r1 = move-exception
            r3 = r0
            goto L_0x009e
        L_0x0096:
            r1 = move-exception
            r2 = r0
            r3 = r2
        L_0x0099:
            r0 = r1
            goto L_0x00b6
        L_0x009b:
            r1 = move-exception
            r2 = r0
            r3 = r2
        L_0x009e:
            r0 = r1
        L_0x009f:
            java.lang.String r1 = "sync connect to server error!"
            e.c.b.f.a.a(r1, r0)     // Catch:{ all -> 0x0074 }
            if (r3 == 0) goto L_0x00ac
            r3.close()     // Catch:{ Exception -> 0x00aa }
            goto L_0x00ac
        L_0x00aa:
            r0 = move-exception
            goto L_0x00b2
        L_0x00ac:
            if (r2 == 0) goto L_0x00b5
            r2.disconnect()     // Catch:{ Exception -> 0x00aa }
            goto L_0x00b5
        L_0x00b2:
            r0.printStackTrace()     // Catch:{ Exception -> 0x00c8 }
        L_0x00b5:
            return
        L_0x00b6:
            if (r3 == 0) goto L_0x00be
            r3.close()     // Catch:{ Exception -> 0x00bc }
            goto L_0x00be
        L_0x00bc:
            r1 = move-exception
            goto L_0x00c4
        L_0x00be:
            if (r2 == 0) goto L_0x00c7
            r2.disconnect()     // Catch:{ Exception -> 0x00bc }
            goto L_0x00c7
        L_0x00c4:
            r1.printStackTrace()     // Catch:{ Exception -> 0x00c8 }
        L_0x00c7:
            throw r0     // Catch:{ Exception -> 0x00c8 }
        L_0x00c8:
            r0 = move-exception
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.g.i.run():void");
    }
}
