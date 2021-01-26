package e.c.f.b;

public final class a {

    /* renamed from: a reason: collision with root package name */
    public static String f6913a;

    /* JADX WARNING: Can't wrap try/catch for region: R(9:9|(4:10|11|12|13)|16|18|19|(1:21)(2:22|(2:24|25))|26|27|(3:29|30|31)(5:32|33|34|35|(2:37|38)(7:39|40|41|44|45|46|(5:48|49|50|53|54)))) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0064 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a A[Catch:{ all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(android.content.Context r12) {
        /*
            java.lang.Class<e.c.f.b.a> r0 = e.c.f.b.a.class
            monitor-enter(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = f6913a     // Catch:{ all -> 0x00d1 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00d1 }
            if (r2 != 0) goto L_0x0011
            java.lang.String r12 = f6913a     // Catch:{ all -> 0x00d1 }
            monitor-exit(r0)
            return r12
        L_0x0011:
            r2 = 86400000(0x5265c00, double:4.2687272E-316)
            r4 = 0
            java.lang.String r5 = "leroadcfg"
            r6 = 4
            android.content.SharedPreferences r5 = r12.getSharedPreferences(r5, r6)     // Catch:{ all -> 0x0021 }
            android.content.SharedPreferences$Editor r4 = r5.edit()     // Catch:{ all -> 0x0022 }
            goto L_0x0022
        L_0x0021:
            r5 = r4
        L_0x0022:
            java.lang.String r1 = ""
            r6 = 10
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0064 }
            java.lang.String r9 = "dd_v_d_t"
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0064 }
            long r9 = r5.getLong(r9, r10)     // Catch:{ all -> 0x0064 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0064 }
            long r9 = r9.longValue()     // Catch:{ all -> 0x0064 }
            long r7 = r7 - r9
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0042
            goto L_0x0064
        L_0x0042:
            java.lang.String r2 = "dd_v_d"
            java.lang.String r2 = r5.getString(r2, r1)     // Catch:{ all -> 0x0064 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0064 }
            if (r3 != 0) goto L_0x0064
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x0064 }
            java.lang.String r5 = "MzAyMTIxMDJkaWN1ZGlhYg=="
            byte[] r5 = r5.getBytes()     // Catch:{ all -> 0x0064 }
            byte[] r2 = android.util.Base64.decode(r2, r6)     // Catch:{ all -> 0x0064 }
            byte[] r2 = e.c.d.n.e.d(r5, r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r5 = "UTF-8"
            r3.<init>(r2, r5)     // Catch:{ all -> 0x0064 }
            r1 = r3
        L_0x0064:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00d1 }
            if (r2 != 0) goto L_0x006e
            f6913a = r1     // Catch:{ all -> 0x00d1 }
            monitor-exit(r0)
            return r1
        L_0x006e:
            java.lang.String r2 = "android.permission.READ_PHONE_STATE"
            int r3 = android.os.Process.myPid()     // Catch:{ all -> 0x00d1 }
            int r5 = android.os.Process.myUid()     // Catch:{ all -> 0x00d1 }
            int r2 = r12.checkPermission(r2, r3, r5)     // Catch:{ all -> 0x00d1 }
            r3 = -1
            if (r2 != r3) goto L_0x0081
            monitor-exit(r0)
            return r1
        L_0x0081:
            java.lang.String r2 = "phone"
            java.lang.Object r12 = r12.getSystemService(r2)     // Catch:{ all -> 0x008e }
            android.telephony.TelephonyManager r12 = (android.telephony.TelephonyManager) r12     // Catch:{ all -> 0x008e }
            java.lang.String r12 = r12.getDeviceId()     // Catch:{ all -> 0x008e }
            goto L_0x0090
        L_0x008e:
            java.lang.String r12 = ""
        L_0x0090:
            r1 = r12
            f6913a = r1     // Catch:{ all -> 0x00d1 }
            boolean r12 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00d1 }
            if (r12 != 0) goto L_0x00d1
            java.lang.String r12 = "dd_v_d"
            java.lang.String r2 = "UTF-8"
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x00b5 }
            java.lang.String r5 = "MzAyMTIxMDJkaWN1ZGlhYg=="
            byte[] r5 = r5.getBytes()     // Catch:{ all -> 0x00b5 }
            byte[] r7 = r1.getBytes(r2)     // Catch:{ all -> 0x00b5 }
            byte[] r5 = e.c.d.n.e.a(r5, r7)     // Catch:{ all -> 0x00b5 }
            byte[] r5 = android.util.Base64.encode(r5, r6)     // Catch:{ all -> 0x00b5 }
            r3.<init>(r5, r2)     // Catch:{ all -> 0x00b5 }
            goto L_0x00b7
        L_0x00b5:
            java.lang.String r3 = ""
        L_0x00b7:
            r4.putString(r12, r3)     // Catch:{ all -> 0x00d1 }
            r4.commit()     // Catch:{ all -> 0x00d1 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d1 }
            java.lang.Long r12 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00d1 }
            java.lang.String r2 = "dd_v_d_t"
            long r5 = r12.longValue()     // Catch:{ all -> 0x00d1 }
            r4.putLong(r2, r5)     // Catch:{ all -> 0x00d1 }
            r4.commit()     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            monitor-exit(r0)
            return r1
        L_0x00d3:
            r12 = move-exception
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.b.a.a(android.content.Context):java.lang.String");
    }
}
