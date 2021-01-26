package e.c.d.d.d;

import com.baidu.picapture.common.share.ShareEntity;

/* compiled from: ShareController */
public abstract class a {

    /* renamed from: e.c.d.d.d.a$a reason: collision with other inner class name */
    /* compiled from: ShareController */
    public interface C0065a {
        void a(String str);
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [android.graphics.Bitmap] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v6, types: [android.graphics.Bitmap] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.graphics.Bitmap, ?[OBJECT, ARRAY]]
  uses: [android.graphics.Bitmap, ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.io.InputStream]
  mth insns count: 57
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
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0057 A[SYNTHETIC, Splitter:B:29:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c A[Catch:{ IOException -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0064 A[SYNTHETIC, Splitter:B:37:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006c A[Catch:{ IOException -> 0x0068 }] */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap a(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r2.<init>(r8)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            java.io.InputStream r8 = r2.openStream()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r2 = 1024(0x400, float:1.435E-42)
            r1.<init>(r8, r2)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
            r8.<init>()     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
            r3.<init>(r8, r2)     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x0044 }
        L_0x0020:
            int r4 = r1.read(r2)     // Catch:{ IOException -> 0x0044 }
            r5 = -1
            r6 = 0
            if (r4 == r5) goto L_0x002c
            r3.write(r2, r6, r4)     // Catch:{ IOException -> 0x0044 }
            goto L_0x0020
        L_0x002c:
            r3.flush()     // Catch:{ IOException -> 0x0044 }
            byte[] r8 = r8.toByteArray()     // Catch:{ IOException -> 0x0044 }
            int r2 = r8.length     // Catch:{ IOException -> 0x0044 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r8, r6, r2)     // Catch:{ IOException -> 0x0044 }
            r1.close()     // Catch:{ IOException -> 0x003f }
            r3.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x005f
        L_0x003f:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x005f
        L_0x0044:
            r8 = move-exception
            goto L_0x0052
        L_0x0046:
            r8 = move-exception
            r3 = r0
            goto L_0x0061
        L_0x0049:
            r8 = move-exception
            r3 = r0
            goto L_0x0052
        L_0x004c:
            r8 = move-exception
            r3 = r0
            goto L_0x0062
        L_0x004f:
            r8 = move-exception
            r1 = r0
            r3 = r1
        L_0x0052:
            r8.printStackTrace()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x005a
            r1.close()     // Catch:{ IOException -> 0x003f }
        L_0x005a:
            if (r3 == 0) goto L_0x005f
            r3.close()     // Catch:{ IOException -> 0x003f }
        L_0x005f:
            return r0
        L_0x0060:
            r8 = move-exception
        L_0x0061:
            r0 = r1
        L_0x0062:
            if (r0 == 0) goto L_0x006a
            r0.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x006a
        L_0x0068:
            r0 = move-exception
            goto L_0x0070
        L_0x006a:
            if (r3 == 0) goto L_0x0073
            r3.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x0073
        L_0x0070:
            r0.printStackTrace()
        L_0x0073:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.d.d.a.a(java.lang.String):android.graphics.Bitmap");
    }

    public abstract void a(ShareEntity shareEntity, C0065a aVar);
}
