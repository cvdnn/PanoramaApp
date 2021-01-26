package d.h.h;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import d.e.h;
import d.h.h.c.C0037c;
import d.r.d.o;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: FontsContractCompat */
public class b {

    /* renamed from: a reason: collision with root package name */
    public static final d.e.f<String, Typeface> f4832a = new d.e.f<>(16);

    /* renamed from: b reason: collision with root package name */
    public static final c f4833b = new c("fonts", 10, o.TARGET_SEEK_SCROLL_DISTANCE_PX);

    /* renamed from: c reason: collision with root package name */
    public static final Object f4834c = new Object();

    /* renamed from: d reason: collision with root package name */
    public static final h<String, ArrayList<C0037c<g>>> f4835d = new h<>();

    /* renamed from: e reason: collision with root package name */
    public static final Comparator<byte[]> f4836e = new d();

    /* compiled from: FontsContractCompat */
    public static class a implements Callable<g> {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Context f4837a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ a f4838b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ int f4839c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ String f4840d;

        public a(Context context, a aVar, int i2, String str) {
            this.f4837a = context;
            this.f4838b = aVar;
            this.f4839c = i2;
            this.f4840d = str;
        }

        public Object call() throws Exception {
            g a2 = b.a(this.f4837a, this.f4838b, this.f4839c);
            Typeface typeface = a2.f4851a;
            if (typeface != null) {
                b.f4832a.a(this.f4840d, typeface);
            }
            return a2;
        }
    }

    /* renamed from: d.h.h.b$b reason: collision with other inner class name */
    /* compiled from: FontsContractCompat */
    public static class C0036b implements C0037c<g> {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ d.h.e.b.g f4841a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ Handler f4842b;

        public C0036b(d.h.e.b.g gVar, Handler handler) {
            this.f4841a = gVar;
            this.f4842b = handler;
        }

        public void a(Object obj) {
            g gVar = (g) obj;
            if (gVar == null) {
                this.f4841a.a(1, this.f4842b);
                return;
            }
            int i2 = gVar.f4852b;
            if (i2 == 0) {
                this.f4841a.a(gVar.f4851a, this.f4842b);
            } else {
                this.f4841a.a(i2, this.f4842b);
            }
        }
    }

    /* compiled from: FontsContractCompat */
    public static class c implements C0037c<g> {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ String f4843a;

        public c(String str) {
            this.f4843a = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
            if (r0 >= r1.size()) goto L_0x002c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            ((d.h.h.c.C0037c) r1.get(r0)).a(r5);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
            r0 = 0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(d.h.h.b.g r5) {
            /*
                r4 = this;
                java.lang.Object r0 = d.h.h.b.f4834c
                monitor-enter(r0)
                d.e.h<java.lang.String, java.util.ArrayList<d.h.h.c$c<d.h.h.b$g>>> r1 = d.h.h.b.f4835d     // Catch:{ all -> 0x002d }
                java.lang.String r2 = r4.f4843a     // Catch:{ all -> 0x002d }
                java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x002d }
                java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ all -> 0x002d }
                if (r1 != 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                return
            L_0x0011:
                d.e.h<java.lang.String, java.util.ArrayList<d.h.h.c$c<d.h.h.b$g>>> r2 = d.h.h.b.f4835d     // Catch:{ all -> 0x002d }
                java.lang.String r3 = r4.f4843a     // Catch:{ all -> 0x002d }
                r2.remove(r3)     // Catch:{ all -> 0x002d }
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                r0 = 0
            L_0x001a:
                int r2 = r1.size()
                if (r0 >= r2) goto L_0x002c
                java.lang.Object r2 = r1.get(r0)
                d.h.h.c$c r2 = (d.h.h.c.C0037c) r2
                r2.a(r5)
                int r0 = r0 + 1
                goto L_0x001a
            L_0x002c:
                return
            L_0x002d:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: d.h.h.b.c.a(d.h.h.b$g):void");
        }
    }

    /* compiled from: FontsContractCompat */
    public static class d implements Comparator<byte[]> {
        public int compare(Object obj, Object obj2) {
            int i2;
            int i3;
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = (byte[]) obj2;
            if (bArr.length != bArr2.length) {
                i3 = bArr.length;
                i2 = bArr2.length;
            } else {
                int i4 = 0;
                while (i4 < bArr.length) {
                    if (bArr[i4] != bArr2[i4]) {
                        i3 = bArr[i4];
                        i2 = bArr2[i4];
                    } else {
                        i4++;
                    }
                }
                return 0;
            }
            return i3 - i2;
        }
    }

    /* compiled from: FontsContractCompat */
    public static class e {

        /* renamed from: a reason: collision with root package name */
        public final int f4844a;

        /* renamed from: b reason: collision with root package name */
        public final f[] f4845b;

        public e(int i2, f[] fVarArr) {
            this.f4844a = i2;
            this.f4845b = fVarArr;
        }
    }

    /* compiled from: FontsContractCompat */
    public static class f {

        /* renamed from: a reason: collision with root package name */
        public final Uri f4846a;

        /* renamed from: b reason: collision with root package name */
        public final int f4847b;

        /* renamed from: c reason: collision with root package name */
        public final int f4848c;

        /* renamed from: d reason: collision with root package name */
        public final boolean f4849d;

        /* renamed from: e reason: collision with root package name */
        public final int f4850e;

        public f(Uri uri, int i2, int i3, boolean z, int i4) {
            if (uri != null) {
                this.f4846a = uri;
                this.f4847b = i2;
                this.f4848c = i3;
                this.f4849d = z;
                this.f4850e = i4;
                return;
            }
            throw null;
        }
    }

    /* compiled from: FontsContractCompat */
    public static final class g {

        /* renamed from: a reason: collision with root package name */
        public final Typeface f4851a;

        /* renamed from: b reason: collision with root package name */
        public final int f4852b;

        public g(Typeface typeface, int i2) {
            this.f4851a = typeface;
            this.f4852b = i2;
        }
    }

    public static g a(Context context, a aVar, int i2) {
        try {
            e a2 = a(context, (CancellationSignal) null, aVar);
            int i3 = a2.f4844a;
            int i4 = -3;
            if (i3 == 0) {
                Typeface a3 = d.h.f.c.f4810a.a(context, (CancellationSignal) null, a2.f4845b, i2);
                if (a3 != null) {
                    i4 = 0;
                }
                return new g(a3, i4);
            }
            if (i3 == 1) {
                i4 = -2;
            }
            return new g(null, i4);
        } catch (NameNotFoundException unused) {
            return new g(null, -1);
        }
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.Throwable, android.graphics.Typeface, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v4, types: [d.h.h.b$b] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.graphics.Typeface] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.graphics.Typeface] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0070, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0081, code lost:
        r3 = f4833b;
        r4 = new d.h.h.b.c(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0088, code lost:
        if (r3 == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008a, code lost:
        r3.b(new d.h.h.d(r3, r1, new android.os.Handler(), r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0097, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0098, code lost:
        throw r2;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v1, types: [java.lang.Throwable, android.graphics.Typeface, java.lang.Object]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
  uses: [java.lang.Object, java.lang.Throwable, android.graphics.Typeface, ?[OBJECT, ARRAY]]
  mth insns count: 65
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
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface a(android.content.Context r2, d.h.h.a r3, d.h.e.b.g r4, android.os.Handler r5, boolean r6, int r7, int r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r3.f4831f
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            d.e.f<java.lang.String, android.graphics.Typeface> r1 = f4832a
            java.lang.Object r1 = r1.a(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0026
            if (r4 == 0) goto L_0x0025
            r4.a(r1)
        L_0x0025:
            return r1
        L_0x0026:
            if (r6 == 0) goto L_0x0041
            r1 = -1
            if (r7 != r1) goto L_0x0041
            d.h.h.b$g r2 = a(r2, r3, r8)
            if (r4 == 0) goto L_0x003e
            int r3 = r2.f4852b
            if (r3 != 0) goto L_0x003b
            android.graphics.Typeface r3 = r2.f4851a
            r4.a(r3, r5)
            goto L_0x003e
        L_0x003b:
            r4.a(r3, r5)
        L_0x003e:
            android.graphics.Typeface r2 = r2.f4851a
            return r2
        L_0x0041:
            d.h.h.b$a r1 = new d.h.h.b$a
            r1.<init>(r2, r3, r8, r0)
            r2 = 0
            if (r6 == 0) goto L_0x0054
            d.h.h.c r3 = f4833b     // Catch:{ InterruptedException -> 0x0053 }
            java.lang.Object r3 = r3.a(r1, r7)     // Catch:{ InterruptedException -> 0x0053 }
            d.h.h.b$g r3 = (d.h.h.b.g) r3     // Catch:{ InterruptedException -> 0x0053 }
            android.graphics.Typeface r2 = r3.f4851a     // Catch:{ InterruptedException -> 0x0053 }
        L_0x0053:
            return r2
        L_0x0054:
            if (r4 != 0) goto L_0x0058
            r3 = r2
            goto L_0x005d
        L_0x0058:
            d.h.h.b$b r3 = new d.h.h.b$b
            r3.<init>(r4, r5)
        L_0x005d:
            java.lang.Object r4 = f4834c
            monitor-enter(r4)
            d.e.h<java.lang.String, java.util.ArrayList<d.h.h.c$c<d.h.h.b$g>>> r5 = f4835d     // Catch:{ all -> 0x0099 }
            java.lang.Object r5 = r5.getOrDefault(r0, r2)     // Catch:{ all -> 0x0099 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x0099 }
            if (r5 == 0) goto L_0x0071
            if (r3 == 0) goto L_0x006f
            r5.add(r3)     // Catch:{ all -> 0x0099 }
        L_0x006f:
            monitor-exit(r4)     // Catch:{ all -> 0x0099 }
            return r2
        L_0x0071:
            if (r3 == 0) goto L_0x0080
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0099 }
            r5.<init>()     // Catch:{ all -> 0x0099 }
            r5.add(r3)     // Catch:{ all -> 0x0099 }
            d.e.h<java.lang.String, java.util.ArrayList<d.h.h.c$c<d.h.h.b$g>>> r3 = f4835d     // Catch:{ all -> 0x0099 }
            r3.put(r0, r5)     // Catch:{ all -> 0x0099 }
        L_0x0080:
            monitor-exit(r4)     // Catch:{ all -> 0x0099 }
            d.h.h.c r3 = f4833b
            d.h.h.b$c r4 = new d.h.h.b$c
            r4.<init>(r0)
            if (r3 == 0) goto L_0x0098
            android.os.Handler r5 = new android.os.Handler
            r5.<init>()
            d.h.h.d r6 = new d.h.h.d
            r6.<init>(r3, r1, r5, r4)
            r3.b(r6)
            return r2
        L_0x0098:
            throw r2
        L_0x0099:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0099 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d.h.h.b.a(android.content.Context, d.h.h.a, d.h.e.b.g, android.os.Handler, boolean, int, int):android.graphics.Typeface");
    }

    public static Map<Uri, ByteBuffer> a(Context context, f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (f fVar : fVarArr) {
            if (fVar.f4850e == 0) {
                Uri uri = fVar.f4846a;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, a.a.a.a.b.a.a(context, cancellationSignal, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.pm.ProviderInfo] */
    /* JADX WARNING: type inference failed for: r7v2, types: [d.h.h.b$f[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [android.content.pm.ProviderInfo] */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v2, types: [d.h.h.b$f[], android.database.Cursor]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
  uses: [?[OBJECT, ARRAY], ?[int, boolean, OBJECT, ARRAY, byte, short, char], android.database.Cursor, d.h.h.b$f[]]
  mth insns count: 162
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
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static d.h.h.b.e a(android.content.Context r20, android.os.CancellationSignal r21, d.h.h.a r22) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r0 = r22
            android.content.pm.PackageManager r1 = r20.getPackageManager()
            android.content.res.Resources r2 = r20.getResources()
            java.lang.String r3 = r0.f4826a
            r4 = 0
            android.content.pm.ProviderInfo r5 = r1.resolveContentProvider(r3, r4)
            if (r5 == 0) goto L_0x01b4
            java.lang.String r6 = r5.packageName
            java.lang.String r7 = r0.f4827b
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0193
            java.lang.String r3 = r5.packageName
            r6 = 64
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r3, r6)
            android.content.pm.Signature[] r1 = r1.signatures
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r6 = r4
        L_0x002d:
            int r7 = r1.length
            if (r6 >= r7) goto L_0x003c
            r7 = r1[r6]
            byte[] r7 = r7.toByteArray()
            r3.add(r7)
            int r6 = r6 + 1
            goto L_0x002d
        L_0x003c:
            java.util.Comparator<byte[]> r1 = f4836e
            java.util.Collections.sort(r3, r1)
            java.util.List<java.util.List<byte[]>> r1 = r0.f4829d
            if (r1 == 0) goto L_0x0046
            goto L_0x004c
        L_0x0046:
            int r1 = r0.f4830e
            java.util.List r1 = a.a.a.a.b.a.a(r2, r1)
        L_0x004c:
            r2 = r4
        L_0x004d:
            int r6 = r1.size()
            r7 = 0
            r8 = 1
            if (r2 >= r6) goto L_0x0095
            java.util.ArrayList r6 = new java.util.ArrayList
            java.lang.Object r9 = r1.get(r2)
            java.util.Collection r9 = (java.util.Collection) r9
            r6.<init>(r9)
            java.util.Comparator<byte[]> r9 = f4836e
            java.util.Collections.sort(r6, r9)
            int r9 = r3.size()
            int r10 = r6.size()
            if (r9 == r10) goto L_0x0070
            goto L_0x0089
        L_0x0070:
            r9 = r4
        L_0x0071:
            int r10 = r3.size()
            if (r9 >= r10) goto L_0x008e
            java.lang.Object r10 = r3.get(r9)
            byte[] r10 = (byte[]) r10
            java.lang.Object r11 = r6.get(r9)
            byte[] r11 = (byte[]) r11
            boolean r10 = java.util.Arrays.equals(r10, r11)
            if (r10 != 0) goto L_0x008b
        L_0x0089:
            r6 = r4
            goto L_0x008f
        L_0x008b:
            int r9 = r9 + 1
            goto L_0x0071
        L_0x008e:
            r6 = r8
        L_0x008f:
            if (r6 == 0) goto L_0x0092
            goto L_0x0096
        L_0x0092:
            int r2 = r2 + 1
            goto L_0x004d
        L_0x0095:
            r5 = r7
        L_0x0096:
            if (r5 != 0) goto L_0x009e
            d.h.h.b$e r0 = new d.h.h.b$e
            r0.<init>(r8, r7)
            return r0
        L_0x009e:
            java.lang.String r1 = r5.authority
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.net.Uri$Builder r3 = new android.net.Uri$Builder
            r3.<init>()
            java.lang.String r5 = "content"
            android.net.Uri$Builder r3 = r3.scheme(r5)
            android.net.Uri$Builder r3 = r3.authority(r1)
            android.net.Uri r3 = r3.build()
            android.net.Uri$Builder r6 = new android.net.Uri$Builder
            r6.<init>()
            android.net.Uri$Builder r5 = r6.scheme(r5)
            android.net.Uri$Builder r1 = r5.authority(r1)
            java.lang.String r5 = "file"
            android.net.Uri$Builder r1 = r1.appendPath(r5)
            android.net.Uri r1 = r1.build()
            android.content.ContentResolver r9 = r20.getContentResolver()     // Catch:{ all -> 0x018c }
            java.lang.String r10 = "_id"
            java.lang.String r11 = "file_id"
            java.lang.String r12 = "font_ttc_index"
            java.lang.String r13 = "font_variation_settings"
            java.lang.String r14 = "font_weight"
            java.lang.String r15 = "font_italic"
            java.lang.String r16 = "result_code"
            java.lang.String[] r11 = new java.lang.String[]{r10, r11, r12, r13, r14, r15, r16}     // Catch:{ all -> 0x018c }
            java.lang.String r12 = "query = ?"
            java.lang.String[] r13 = new java.lang.String[r8]     // Catch:{ all -> 0x018c }
            java.lang.String r0 = r0.f4828c     // Catch:{ all -> 0x018c }
            r13[r4] = r0     // Catch:{ all -> 0x018c }
            r14 = 0
            r10 = r3
            r15 = r21
            android.database.Cursor r7 = r9.query(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x018c }
            if (r7 == 0) goto L_0x0179
            int r0 = r7.getCount()     // Catch:{ all -> 0x018c }
            if (r0 <= 0) goto L_0x0179
            java.lang.String r0 = "result_code"
            int r0 = r7.getColumnIndex(r0)     // Catch:{ all -> 0x018c }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x018c }
            r2.<init>()     // Catch:{ all -> 0x018c }
            java.lang.String r5 = "_id"
            int r5 = r7.getColumnIndex(r5)     // Catch:{ all -> 0x018c }
            java.lang.String r6 = "file_id"
            int r6 = r7.getColumnIndex(r6)     // Catch:{ all -> 0x018c }
            java.lang.String r9 = "font_ttc_index"
            int r9 = r7.getColumnIndex(r9)     // Catch:{ all -> 0x018c }
            java.lang.String r10 = "font_weight"
            int r10 = r7.getColumnIndex(r10)     // Catch:{ all -> 0x018c }
            java.lang.String r11 = "font_italic"
            int r11 = r7.getColumnIndex(r11)     // Catch:{ all -> 0x018c }
        L_0x0126:
            boolean r12 = r7.moveToNext()     // Catch:{ all -> 0x018c }
            if (r12 == 0) goto L_0x0179
            r12 = -1
            if (r0 == r12) goto L_0x0136
            int r13 = r7.getInt(r0)     // Catch:{ all -> 0x018c }
            r19 = r13
            goto L_0x0138
        L_0x0136:
            r19 = r4
        L_0x0138:
            if (r9 == r12) goto L_0x0141
            int r13 = r7.getInt(r9)     // Catch:{ all -> 0x018c }
            r16 = r13
            goto L_0x0143
        L_0x0141:
            r16 = r4
        L_0x0143:
            if (r6 != r12) goto L_0x014e
            long r13 = r7.getLong(r5)     // Catch:{ all -> 0x018c }
            android.net.Uri r13 = android.content.ContentUris.withAppendedId(r3, r13)     // Catch:{ all -> 0x018c }
            goto L_0x0156
        L_0x014e:
            long r13 = r7.getLong(r6)     // Catch:{ all -> 0x018c }
            android.net.Uri r13 = android.content.ContentUris.withAppendedId(r1, r13)     // Catch:{ all -> 0x018c }
        L_0x0156:
            r15 = r13
            if (r10 == r12) goto L_0x015e
            int r13 = r7.getInt(r10)     // Catch:{ all -> 0x018c }
            goto L_0x0160
        L_0x015e:
            r13 = 400(0x190, float:5.6E-43)
        L_0x0160:
            r17 = r13
            if (r11 == r12) goto L_0x016d
            int r12 = r7.getInt(r11)     // Catch:{ all -> 0x018c }
            if (r12 != r8) goto L_0x016d
            r18 = r8
            goto L_0x016f
        L_0x016d:
            r18 = r4
        L_0x016f:
            d.h.h.b$f r12 = new d.h.h.b$f     // Catch:{ all -> 0x018c }
            r14 = r12
            r14.<init>(r15, r16, r17, r18, r19)     // Catch:{ all -> 0x018c }
            r2.add(r12)     // Catch:{ all -> 0x018c }
            goto L_0x0126
        L_0x0179:
            if (r7 == 0) goto L_0x017e
            r7.close()
        L_0x017e:
            d.h.h.b$f[] r0 = new d.h.h.b.f[r4]
            java.lang.Object[] r0 = r2.toArray(r0)
            d.h.h.b$f[] r0 = (d.h.h.b.f[]) r0
            d.h.h.b$e r1 = new d.h.h.b$e
            r1.<init>(r4, r0)
            return r1
        L_0x018c:
            r0 = move-exception
            if (r7 == 0) goto L_0x0192
            r7.close()
        L_0x0192:
            throw r0
        L_0x0193:
            android.content.pm.PackageManager$NameNotFoundException r1 = new android.content.pm.PackageManager$NameNotFoundException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Found content provider "
            r2.append(r4)
            r2.append(r3)
            java.lang.String r3 = ", but package was not "
            r2.append(r3)
            java.lang.String r0 = r0.f4827b
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x01b4:
            android.content.pm.PackageManager$NameNotFoundException r0 = new android.content.pm.PackageManager$NameNotFoundException
            java.lang.String r1 = "No package found for authority: "
            java.lang.String r1 = e.a.a.a.a.a(r1, r3)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.h.h.b.a(android.content.Context, android.os.CancellationSignal, d.h.h.a):d.h.h.b$e");
    }
}
