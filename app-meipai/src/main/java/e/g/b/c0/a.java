package e.g.b.c0;

import e.c.f.n.n;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: $Gson$Types */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public static final Type[] f8474a = new Type[0];

    /* renamed from: e.g.b.c0.a$a reason: collision with other inner class name */
    /* compiled from: $Gson$Types */
    public static final class C0116a implements GenericArrayType, Serializable {

        /* renamed from: a reason: collision with root package name */
        public final Type f8475a;

        public C0116a(Type type) {
            this.f8475a = a.a(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && a.a(this, (GenericArrayType) obj);
        }

        public Type getGenericComponentType() {
            return this.f8475a;
        }

        public int hashCode() {
            return this.f8475a.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(a.d(this.f8475a));
            sb.append("[]");
            return sb.toString();
        }
    }

    /* compiled from: $Gson$Types */
    public static final class b implements ParameterizedType, Serializable {

        /* renamed from: a reason: collision with root package name */
        public final Type f8476a;

        /* renamed from: b reason: collision with root package name */
        public final Type f8477b;

        /* renamed from: c reason: collision with root package name */
        public final Type[] f8478c;

        public b(Type type, Type type2, Type... typeArr) {
            Type type3;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                n.a(z);
            }
            if (type == null) {
                type3 = null;
            } else {
                type3 = a.a(type);
            }
            this.f8476a = type3;
            this.f8477b = a.a(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.f8478c = typeArr2;
            int length = typeArr2.length;
            for (int i2 = 0; i2 < length; i2++) {
                n.a(this.f8478c[i2]);
                a.b(this.f8478c[i2]);
                Type[] typeArr3 = this.f8478c;
                typeArr3[i2] = a.a(typeArr3[i2]);
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && a.a(this, (ParameterizedType) obj);
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.f8478c.clone();
        }

        public Type getOwnerType() {
            return this.f8476a;
        }

        public Type getRawType() {
            return this.f8477b;
        }

        public int hashCode() {
            int hashCode = Arrays.hashCode(this.f8478c) ^ this.f8477b.hashCode();
            Type type = this.f8476a;
            return hashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            int length = this.f8478c.length;
            if (length == 0) {
                return a.d(this.f8477b);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(a.d(this.f8477b));
            sb.append("<");
            sb.append(a.d(this.f8478c[0]));
            for (int i2 = 1; i2 < length; i2++) {
                sb.append(", ");
                sb.append(a.d(this.f8478c[i2]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* compiled from: $Gson$Types */
    public static final class c implements WildcardType, Serializable {

        /* renamed from: a reason: collision with root package name */
        public final Type f8479a;

        /* renamed from: b reason: collision with root package name */
        public final Type f8480b;

        public c(Type[] typeArr, Type[] typeArr2) {
            Class<Object> cls = Object.class;
            boolean z = true;
            n.a(typeArr2.length <= 1);
            n.a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                n.a(typeArr2[0]);
                a.b(typeArr2[0]);
                if (typeArr[0] != cls) {
                    z = false;
                }
                n.a(z);
                this.f8480b = a.a(typeArr2[0]);
                this.f8479a = cls;
                return;
            }
            n.a(typeArr[0]);
            a.b(typeArr[0]);
            this.f8480b = null;
            this.f8479a = a.a(typeArr[0]);
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && a.a(this, (WildcardType) obj);
        }

        public Type[] getLowerBounds() {
            Type type = this.f8480b;
            if (type == null) {
                return a.f8474a;
            }
            return new Type[]{type};
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.f8479a};
        }

        public int hashCode() {
            Type type = this.f8480b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f8479a.hashCode() + 31);
        }

        public String toString() {
            if (this.f8480b != null) {
                StringBuilder a2 = e.a.a.a.a.a("? super ");
                a2.append(a.d(this.f8480b));
                return a2.toString();
            } else if (this.f8479a == Object.class) {
                return "?";
            } else {
                StringBuilder a3 = e.a.a.a.a.a("? extends ");
                a3.append(a.d(this.f8479a));
                return a3.toString();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [e.g.b.c0.a$a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type a(java.lang.reflect.Type r3) {
        /*
            boolean r0 = r3 instanceof java.lang.Class
            if (r0 == 0) goto L_0x001b
            java.lang.Class r3 = (java.lang.Class) r3
            boolean r0 = r3.isArray()
            if (r0 == 0) goto L_0x001a
            e.g.b.c0.a$a r0 = new e.g.b.c0.a$a
            java.lang.Class r3 = r3.getComponentType()
            java.lang.reflect.Type r3 = a(r3)
            r0.<init>(r3)
            r3 = r0
        L_0x001a:
            return r3
        L_0x001b:
            boolean r0 = r3 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L_0x0033
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
            e.g.b.c0.a$b r0 = new e.g.b.c0.a$b
            java.lang.reflect.Type r1 = r3.getOwnerType()
            java.lang.reflect.Type r2 = r3.getRawType()
            java.lang.reflect.Type[] r3 = r3.getActualTypeArguments()
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0033:
            boolean r0 = r3 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x0043
            java.lang.reflect.GenericArrayType r3 = (java.lang.reflect.GenericArrayType) r3
            e.g.b.c0.a$a r0 = new e.g.b.c0.a$a
            java.lang.reflect.Type r3 = r3.getGenericComponentType()
            r0.<init>(r3)
            return r0
        L_0x0043:
            boolean r0 = r3 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x0057
            java.lang.reflect.WildcardType r3 = (java.lang.reflect.WildcardType) r3
            e.g.b.c0.a$c r0 = new e.g.b.c0.a$c
            java.lang.reflect.Type[] r1 = r3.getUpperBounds()
            java.lang.reflect.Type[] r3 = r3.getLowerBounds()
            r0.<init>(r1, r3)
            return r0
        L_0x0057:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.c0.a.a(java.lang.reflect.Type):java.lang.reflect.Type");
    }

    public static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        n.a(cls2.isAssignableFrom(cls));
        return a(type, cls, a(type, cls, cls2));
    }

    public static Class<?> c(Type type) {
        String str;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            n.a(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(c(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return c(((WildcardType) type).getUpperBounds()[0]);
            }
            if (type == null) {
                str = "null";
            } else {
                str = type.getClass().getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
            sb.append(type);
            sb.append("> is of type ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static String d(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static void b(Type type) {
        n.a(!(type instanceof Class) || !((Class) type).isPrimitive());
    }

    public static boolean a(Type type, Type type2) {
        boolean z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            if (!(ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                z = false;
            }
            return z;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                z = false;
            }
            return z;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || !typeVariable.getName().equals(typeVariable2.getName())) {
                z = false;
            }
            return z;
        }
    }

    public static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (interfaces[i2] == cls2) {
                    return cls.getGenericInterfaces()[i2];
                }
                if (cls2.isAssignableFrom(interfaces[i2])) {
                    return a(cls.getGenericInterfaces()[i2], interfaces[i2], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return a(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        return a(type, cls, type2, new HashSet());
    }

    /* JADX WARNING: type inference failed for: r0v21, types: [e.g.b.c0.a$a] */
    /* JADX WARNING: type inference failed for: r10v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type a(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10, java.util.Collection<java.lang.reflect.TypeVariable> r11) {
        /*
        L_0x0000:
            boolean r0 = r10 instanceof java.lang.reflect.TypeVariable
            r1 = 0
            if (r0 == 0) goto L_0x004e
            r0 = r10
            java.lang.reflect.TypeVariable r0 = (java.lang.reflect.TypeVariable) r0
            boolean r2 = r11.contains(r0)
            if (r2 == 0) goto L_0x000f
            return r10
        L_0x000f:
            r11.add(r0)
            java.lang.reflect.GenericDeclaration r10 = r0.getGenericDeclaration()
            boolean r2 = r10 instanceof java.lang.Class
            if (r2 == 0) goto L_0x001d
            java.lang.Class r10 = (java.lang.Class) r10
            goto L_0x001e
        L_0x001d:
            r10 = 0
        L_0x001e:
            if (r10 != 0) goto L_0x0021
            goto L_0x004a
        L_0x0021:
            java.lang.reflect.Type r2 = a(r8, r9, r10)
            boolean r3 = r2 instanceof java.lang.reflect.ParameterizedType
            if (r3 == 0) goto L_0x004a
            java.lang.reflect.TypeVariable[] r10 = r10.getTypeParameters()
            int r3 = r10.length
        L_0x002e:
            if (r1 >= r3) goto L_0x0044
            r4 = r10[r1]
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0041
            java.lang.reflect.ParameterizedType r2 = (java.lang.reflect.ParameterizedType) r2
            java.lang.reflect.Type[] r10 = r2.getActualTypeArguments()
            r10 = r10[r1]
            goto L_0x004b
        L_0x0041:
            int r1 = r1 + 1
            goto L_0x002e
        L_0x0044:
            java.util.NoSuchElementException r8 = new java.util.NoSuchElementException
            r8.<init>()
            throw r8
        L_0x004a:
            r10 = r0
        L_0x004b:
            if (r10 != r0) goto L_0x0000
            return r10
        L_0x004e:
            boolean r0 = r10 instanceof java.lang.Class
            if (r0 == 0) goto L_0x006c
            r0 = r10
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r2 = r0.isArray()
            if (r2 == 0) goto L_0x006c
            java.lang.Class r10 = r0.getComponentType()
            java.lang.reflect.Type r8 = a(r8, r9, r10, r11)
            if (r10 != r8) goto L_0x0066
            goto L_0x006b
        L_0x0066:
            e.g.b.c0.a$a r0 = new e.g.b.c0.a$a
            r0.<init>(r8)
        L_0x006b:
            return r0
        L_0x006c:
            boolean r0 = r10 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x0083
            java.lang.reflect.GenericArrayType r10 = (java.lang.reflect.GenericArrayType) r10
            java.lang.reflect.Type r0 = r10.getGenericComponentType()
            java.lang.reflect.Type r8 = a(r8, r9, r0, r11)
            if (r0 != r8) goto L_0x007d
            goto L_0x0082
        L_0x007d:
            e.g.b.c0.a$a r10 = new e.g.b.c0.a$a
            r10.<init>(r8)
        L_0x0082:
            return r10
        L_0x0083:
            boolean r0 = r10 instanceof java.lang.reflect.ParameterizedType
            r2 = 1
            if (r0 == 0) goto L_0x00c3
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type r0 = r10.getOwnerType()
            java.lang.reflect.Type r3 = a(r8, r9, r0, r11)
            if (r3 == r0) goto L_0x0096
            r0 = r2
            goto L_0x0097
        L_0x0096:
            r0 = r1
        L_0x0097:
            java.lang.reflect.Type[] r4 = r10.getActualTypeArguments()
            int r5 = r4.length
        L_0x009c:
            if (r1 >= r5) goto L_0x00b7
            r6 = r4[r1]
            java.lang.reflect.Type r6 = a(r8, r9, r6, r11)
            r7 = r4[r1]
            if (r6 == r7) goto L_0x00b4
            if (r0 != 0) goto L_0x00b2
            java.lang.Object r0 = r4.clone()
            r4 = r0
            java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
            r0 = r2
        L_0x00b2:
            r4[r1] = r6
        L_0x00b4:
            int r1 = r1 + 1
            goto L_0x009c
        L_0x00b7:
            if (r0 == 0) goto L_0x00c2
            java.lang.reflect.Type r8 = r10.getRawType()
            e.g.b.c0.a$b r10 = new e.g.b.c0.a$b
            r10.<init>(r3, r8, r4)
        L_0x00c2:
            return r10
        L_0x00c3:
            boolean r0 = r10 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x0121
            java.lang.reflect.WildcardType r10 = (java.lang.reflect.WildcardType) r10
            java.lang.reflect.Type[] r0 = r10.getLowerBounds()
            java.lang.reflect.Type[] r3 = r10.getUpperBounds()
            int r4 = r0.length
            if (r4 != r2) goto L_0x00fa
            r3 = r0[r1]
            java.lang.reflect.Type r8 = a(r8, r9, r3, r11)
            r9 = r0[r1]
            if (r8 == r9) goto L_0x0121
            boolean r9 = r8 instanceof java.lang.reflect.WildcardType
            if (r9 == 0) goto L_0x00e9
            java.lang.reflect.WildcardType r8 = (java.lang.reflect.WildcardType) r8
            java.lang.reflect.Type[] r8 = r8.getLowerBounds()
            goto L_0x00ee
        L_0x00e9:
            java.lang.reflect.Type[] r9 = new java.lang.reflect.Type[r2]
            r9[r1] = r8
            r8 = r9
        L_0x00ee:
            e.g.b.c0.a$c r9 = new e.g.b.c0.a$c
            java.lang.reflect.Type[] r10 = new java.lang.reflect.Type[r2]
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r10[r1] = r11
            r9.<init>(r10, r8)
            return r9
        L_0x00fa:
            int r0 = r3.length
            if (r0 != r2) goto L_0x0121
            r0 = r3[r1]
            java.lang.reflect.Type r8 = a(r8, r9, r0, r11)     // Catch:{ all -> 0x011f }
            r9 = r3[r1]
            if (r8 == r9) goto L_0x0121
            boolean r9 = r8 instanceof java.lang.reflect.WildcardType
            if (r9 == 0) goto L_0x0112
            java.lang.reflect.WildcardType r8 = (java.lang.reflect.WildcardType) r8
            java.lang.reflect.Type[] r8 = r8.getUpperBounds()
            goto L_0x0117
        L_0x0112:
            java.lang.reflect.Type[] r9 = new java.lang.reflect.Type[r2]
            r9[r1] = r8
            r8 = r9
        L_0x0117:
            e.g.b.c0.a$c r9 = new e.g.b.c0.a$c
            java.lang.reflect.Type[] r10 = f8474a
            r9.<init>(r8, r10)
            return r9
        L_0x011f:
            r8 = move-exception
            throw r8
        L_0x0121:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.c0.a.a(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.Collection):java.lang.reflect.Type");
    }
}
