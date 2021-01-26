package e.g.b.d0;

import e.g.b.c0.a.C0116a;
import e.g.b.c0.a.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: TypeToken */
public class a<T> {

    /* renamed from: a reason: collision with root package name */
    public final Class<? super T> f8537a;

    /* renamed from: b reason: collision with root package name */
    public final Type f8538b;

    /* renamed from: c reason: collision with root package name */
    public final int f8539c;

    public a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            Type a2 = e.g.b.c0.a.a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
            this.f8538b = a2;
            this.f8537a = e.g.b.c0.a.c(a2);
            this.f8539c = this.f8538b.hashCode();
            return;
        }
        throw new RuntimeException("Missing type parameter.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.reflect.Type r9, java.lang.reflect.ParameterizedType r10, java.util.Map<java.lang.String, java.lang.reflect.Type> r11) {
        /*
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r10.equals(r9)
            r2 = 1
            if (r1 == 0) goto L_0x000c
            return r2
        L_0x000c:
            java.lang.Class r1 = e.g.b.c0.a.c(r9)
            r3 = 0
            boolean r4 = r9 instanceof java.lang.reflect.ParameterizedType
            if (r4 == 0) goto L_0x0018
            r3 = r9
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
        L_0x0018:
            if (r3 == 0) goto L_0x008d
            java.lang.reflect.Type[] r9 = r3.getActualTypeArguments()
            java.lang.reflect.TypeVariable[] r4 = r1.getTypeParameters()
            r5 = r0
        L_0x0023:
            int r6 = r9.length
            if (r5 >= r6) goto L_0x0045
            r6 = r9[r5]
            r7 = r4[r5]
        L_0x002a:
            boolean r8 = r6 instanceof java.lang.reflect.TypeVariable
            if (r8 == 0) goto L_0x003b
            java.lang.reflect.TypeVariable r6 = (java.lang.reflect.TypeVariable) r6
            java.lang.String r6 = r6.getName()
            java.lang.Object r6 = r11.get(r6)
            java.lang.reflect.Type r6 = (java.lang.reflect.Type) r6
            goto L_0x002a
        L_0x003b:
            java.lang.String r7 = r7.getName()
            r11.put(r7, r6)
            int r5 = r5 + 1
            goto L_0x0023
        L_0x0045:
            java.lang.reflect.Type r9 = r3.getRawType()
            java.lang.reflect.Type r4 = r10.getRawType()
            boolean r9 = r9.equals(r4)
            if (r9 == 0) goto L_0x0089
            java.lang.reflect.Type[] r9 = r3.getActualTypeArguments()
            java.lang.reflect.Type[] r3 = r10.getActualTypeArguments()
            r4 = r0
        L_0x005c:
            int r5 = r9.length
            if (r4 >= r5) goto L_0x0087
            r5 = r9[r4]
            r6 = r3[r4]
            boolean r7 = r6.equals(r5)
            if (r7 != 0) goto L_0x0080
            boolean r7 = r5 instanceof java.lang.reflect.TypeVariable
            if (r7 == 0) goto L_0x007e
            java.lang.reflect.TypeVariable r5 = (java.lang.reflect.TypeVariable) r5
            java.lang.String r5 = r5.getName()
            java.lang.Object r5 = r11.get(r5)
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x007e
            goto L_0x0080
        L_0x007e:
            r5 = r0
            goto L_0x0081
        L_0x0080:
            r5 = r2
        L_0x0081:
            if (r5 != 0) goto L_0x0084
            goto L_0x0089
        L_0x0084:
            int r4 = r4 + 1
            goto L_0x005c
        L_0x0087:
            r9 = r2
            goto L_0x008a
        L_0x0089:
            r9 = r0
        L_0x008a:
            if (r9 == 0) goto L_0x008d
            return r2
        L_0x008d:
            java.lang.reflect.Type[] r9 = r1.getGenericInterfaces()
            int r3 = r9.length
        L_0x0092:
            if (r0 >= r3) goto L_0x00a5
            r4 = r9[r0]
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>(r11)
            boolean r4 = a(r4, r10, r5)
            if (r4 == 0) goto L_0x00a2
            return r2
        L_0x00a2:
            int r0 = r0 + 1
            goto L_0x0092
        L_0x00a5:
            java.lang.reflect.Type r9 = r1.getGenericSuperclass()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>(r11)
            boolean r9 = a(r9, r10, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.d0.a.a(java.lang.reflect.Type, java.lang.reflect.ParameterizedType, java.util.Map):boolean");
    }

    public static a<?> get(Type type) {
        return new a<>(type);
    }

    public static a<?> getArray(Type type) {
        return new a<>(new C0116a(type));
    }

    public static a<?> getParameterized(Type type, Type... typeArr) {
        return new a<>(new b(null, type, typeArr));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && e.g.b.c0.a.a(this.f8538b, ((a) obj).f8538b);
    }

    public final Class<? super T> getRawType() {
        return this.f8537a;
    }

    public final Type getType() {
        return this.f8538b;
    }

    public final int hashCode() {
        return this.f8539c;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    public final String toString() {
        return e.g.b.c0.a.d(this.f8538b);
    }

    public static <T> a<T> get(Class<T> cls) {
        return new a<>(cls);
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.reflect.Type, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [int] */
    /* JADX WARNING: type inference failed for: r0v3, types: [int] */
    /* JADX WARNING: type inference failed for: r0v4, types: [boolean] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r6v11, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r6v13, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r6v14, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r6v15, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r6v17, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r6v21 */
    /* JADX WARNING: type inference failed for: r6v22 */
    /* JADX WARNING: type inference failed for: r6v23 */
    /* JADX WARNING: type inference failed for: r6v24 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.reflect.Type, code=null, for r6v0, types: [java.lang.reflect.Type, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v5
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], int]
  uses: [boolean, ?[int, byte, short, char], ?[int, short, byte, char], int]
  mth insns count: 83
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
    /* JADX WARNING: Unknown variable types count: 8 */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isAssignableFrom(java.lang.reflect.Type r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.reflect.Type r1 = r5.f8538b
            boolean r1 = r1.equals(r6)
            r2 = 1
            if (r1 == 0) goto L_0x000e
            return r2
        L_0x000e:
            java.lang.reflect.Type r1 = r5.f8538b
            boolean r3 = r1 instanceof java.lang.Class
            if (r3 == 0) goto L_0x001f
            java.lang.Class<? super T> r0 = r5.f8537a
            java.lang.Class r6 = e.g.b.c0.a.c(r6)
            boolean r6 = r0.isAssignableFrom(r6)
            return r6
        L_0x001f:
            boolean r3 = r1 instanceof java.lang.reflect.ParameterizedType
            if (r3 == 0) goto L_0x002f
            java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            boolean r6 = a(r6, r1, r0)
            return r6
        L_0x002f:
            boolean r3 = r1 instanceof java.lang.reflect.GenericArrayType
            if (r3 == 0) goto L_0x0078
            java.lang.Class<? super T> r1 = r5.f8537a
            java.lang.Class r3 = e.g.b.c0.a.c(r6)
            boolean r1 = r1.isAssignableFrom(r3)
            if (r1 == 0) goto L_0x0077
            java.lang.reflect.Type r1 = r5.f8538b
            java.lang.reflect.GenericArrayType r1 = (java.lang.reflect.GenericArrayType) r1
            java.lang.reflect.Type r1 = r1.getGenericComponentType()
            boolean r3 = r1 instanceof java.lang.reflect.ParameterizedType
            if (r3 == 0) goto L_0x0073
            boolean r3 = r6 instanceof java.lang.reflect.GenericArrayType
            if (r3 == 0) goto L_0x0056
            java.lang.reflect.GenericArrayType r6 = (java.lang.reflect.GenericArrayType) r6
            java.lang.reflect.Type r6 = r6.getGenericComponentType()
            goto L_0x0067
        L_0x0056:
            boolean r3 = r6 instanceof java.lang.Class
            if (r3 == 0) goto L_0x0067
            java.lang.Class r6 = (java.lang.Class) r6
        L_0x005c:
            boolean r3 = r6.isArray()
            if (r3 == 0) goto L_0x0067
            java.lang.Class r6 = r6.getComponentType()
            goto L_0x005c
        L_0x0067:
            java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            boolean r6 = a(r6, r1, r3)
            goto L_0x0074
        L_0x0073:
            r6 = r2
        L_0x0074:
            if (r6 == 0) goto L_0x0077
            r0 = r2
        L_0x0077:
            return r0
        L_0x0078:
            r6 = 3
            java.lang.Class[] r3 = new java.lang.Class[r6]
            java.lang.Class<java.lang.Class> r4 = java.lang.Class.class
            r3[r0] = r4
            java.lang.Class<java.lang.reflect.ParameterizedType> r4 = java.lang.reflect.ParameterizedType.class
            r3[r2] = r4
            r2 = 2
            java.lang.Class<java.lang.reflect.GenericArrayType> r4 = java.lang.reflect.GenericArrayType.class
            r3[r2] = r4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unexpected type. Expected one of: "
            r2.<init>(r4)
        L_0x008f:
            if (r0 >= r6) goto L_0x00a2
            r4 = r3[r0]
            java.lang.String r4 = r4.getName()
            r2.append(r4)
            java.lang.String r4 = ", "
            r2.append(r4)
            int r0 = r0 + 1
            goto L_0x008f
        L_0x00a2:
            java.lang.String r6 = "but got: "
            r2.append(r6)
            java.lang.Class r6 = r1.getClass()
            java.lang.String r6 = r6.getName()
            r2.append(r6)
            java.lang.String r6 = ", for type token: "
            r2.append(r6)
            java.lang.String r6 = r1.toString()
            r2.append(r6)
            r6 = 46
            r2.append(r6)
            java.lang.AssertionError r6 = new java.lang.AssertionError
            java.lang.String r0 = r2.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.d0.a.isAssignableFrom(java.lang.reflect.Type):boolean");
    }

    public a(Type type) {
        if (type != null) {
            Type a2 = e.g.b.c0.a.a(type);
            this.f8538b = a2;
            this.f8537a = e.g.b.c0.a.c(a2);
            this.f8539c = this.f8538b.hashCode();
            return;
        }
        throw null;
    }

    @Deprecated
    public boolean isAssignableFrom(a<?> aVar) {
        return isAssignableFrom(aVar.getType());
    }
}
