package e.c.f.n;

/* compiled from: TDIDUtil */
public final class l {
    public static byte[] a(int i2) {
        return new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
    }

    public static byte[] a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length() / 2;
        char[] charArray = lowerCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            String str2 = "0123456789abcdef";
            bArr[i2] = (byte) (((byte) str2.indexOf(charArray[i3 + 1])) | (((byte) str2.indexOf(charArray[i3])) << 4));
        }
        return bArr;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b0, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        e.c.f.c.d();
        r10 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(android.content.Context r10) {
        /*
            java.lang.String r0 = ""
            r1 = 32
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)
            java.lang.String r2 = e.c.f.n.c.f(r10)     // Catch:{ all -> 0x0011 }
            java.lang.String r10 = e.c.f.n.c.e(r10)     // Catch:{ all -> 0x0012 }
            goto L_0x0016
        L_0x0011:
            r2 = r0
        L_0x0012:
            e.c.f.c.d()     // Catch:{ all -> 0x00b0 }
            r10 = r0
        L_0x0016:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00b0 }
            r4 = 1
            if (r3 == 0) goto L_0x0025
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x0025
            r3 = r4
            goto L_0x0041
        L_0x0025:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x0036
            java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00b0 }
            r3 = 33
            goto L_0x0041
        L_0x0036:
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x003f
            r3 = 17
            goto L_0x0041
        L_0x003f:
            r3 = 49
        L_0x0041:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            java.lang.String r6 = "baidu.sofire"
            r5.<init>(r6)     // Catch:{ all -> 0x00b0 }
            r5.append(r2)     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x00b0 }
            e.c.f.c.a()     // Catch:{ all -> 0x00b0 }
            byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x00b0 }
            r5 = 0
            java.lang.String r2 = e.c.f.n.c.a(r2, r5)     // Catch:{ all -> 0x00b0 }
            byte[] r2 = a(r2)     // Catch:{ all -> 0x00b0 }
            boolean r6 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00b0 }
            if (r6 == 0) goto L_0x0073
            java.util.UUID r10 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x00b0 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00b0 }
            long r6 = e.c.d.n.e.a(r10)     // Catch:{ all -> 0x00b0 }
        L_0x0071:
            int r10 = (int) r6     // Catch:{ all -> 0x00b0 }
            goto L_0x0078
        L_0x0073:
            long r6 = e.c.d.n.e.a(r10)     // Catch:{ all -> 0x00b0 }
            goto L_0x0071
        L_0x0078:
            byte[] r10 = a(r10)     // Catch:{ all -> 0x00b0 }
            r6 = 9
            byte[] r7 = new byte[r6]     // Catch:{ all -> 0x00b0 }
            java.util.UUID r8 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x00b0 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00b0 }
            java.lang.String r9 = "-"
            java.lang.String r0 = r8.replace(r9, r0)     // Catch:{ all -> 0x00b0 }
            byte[] r0 = a(r0)     // Catch:{ all -> 0x00b0 }
            java.lang.System.arraycopy(r0, r5, r7, r5, r6)     // Catch:{ all -> 0x00b0 }
            r0 = 2
            byte[] r6 = new byte[r0]     // Catch:{ all -> 0x00b0 }
            r6[r5] = r5     // Catch:{ all -> 0x00b0 }
            r6[r4] = r0     // Catch:{ all -> 0x00b0 }
            byte[] r0 = new byte[r4]     // Catch:{ all -> 0x00b0 }
            r0[r5] = r3     // Catch:{ all -> 0x00b0 }
            r1.put(r2)     // Catch:{ all -> 0x00b0 }
            r1.put(r10)     // Catch:{ all -> 0x00b0 }
            r1.put(r7)     // Catch:{ all -> 0x00b0 }
            r1.put(r6)     // Catch:{ all -> 0x00b0 }
            r1.put(r0)     // Catch:{ all -> 0x00b0 }
            goto L_0x00b3
        L_0x00b0:
            e.c.f.c.d()
        L_0x00b3:
            byte[] r10 = r1.array()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.l.a(android.content.Context):byte[]");
    }
}
