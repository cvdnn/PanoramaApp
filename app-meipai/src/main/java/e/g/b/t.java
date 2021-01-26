package e.g.b;

import e.g.b.c0.q;
import java.math.BigInteger;

/* compiled from: JsonPrimitive */
public final class t extends o {

    /* renamed from: b reason: collision with root package name */
    public static final Class<?>[] f8586b = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: a reason: collision with root package name */
    public Object f8587a;

    public t(Boolean bool) {
        a((Object) bool);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        if (r0 != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof java.lang.Character
            if (r0 == 0) goto L_0x0011
            java.lang.Character r8 = (java.lang.Character) r8
            char r8 = r8.charValue()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r7.f8587a = r8
            goto L_0x003c
        L_0x0011:
            boolean r0 = r8 instanceof java.lang.Number
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0036
            boolean r0 = r8 instanceof java.lang.String
            if (r0 == 0) goto L_0x001d
        L_0x001b:
            r0 = r2
            goto L_0x0034
        L_0x001d:
            java.lang.Class r0 = r8.getClass()
            java.lang.Class<?>[] r3 = f8586b
            int r4 = r3.length
            r5 = r1
        L_0x0025:
            if (r5 >= r4) goto L_0x0033
            r6 = r3[r5]
            boolean r6 = r6.isAssignableFrom(r0)
            if (r6 == 0) goto L_0x0030
            goto L_0x001b
        L_0x0030:
            int r5 = r5 + 1
            goto L_0x0025
        L_0x0033:
            r0 = r1
        L_0x0034:
            if (r0 == 0) goto L_0x0037
        L_0x0036:
            r1 = r2
        L_0x0037:
            e.c.f.n.n.a(r1)
            r7.f8587a = r8
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.t.a(java.lang.Object):void");
    }

    public float b() {
        return this.f8587a instanceof Number ? h().floatValue() : Float.parseFloat(g());
    }

    public int c() {
        return this.f8587a instanceof Number ? h().intValue() : Integer.parseInt(g());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        if (this.f8587a == null) {
            if (tVar.f8587a != null) {
                z = false;
            }
            return z;
        } else if (a(this) && a(tVar)) {
            if (h().longValue() != tVar.h().longValue()) {
                z = false;
            }
            return z;
        } else if (!(this.f8587a instanceof Number) || !(tVar.f8587a instanceof Number)) {
            return this.f8587a.equals(tVar.f8587a);
        } else {
            double doubleValue = h().doubleValue();
            double doubleValue2 = tVar.h().doubleValue();
            if (doubleValue != doubleValue2 && (!Double.isNaN(doubleValue) || !Double.isNaN(doubleValue2))) {
                z = false;
            }
            return z;
        }
    }

    public String g() {
        Object obj = this.f8587a;
        if (obj instanceof Number) {
            return h().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        return (String) obj;
    }

    public Number h() {
        Object obj = this.f8587a;
        return obj instanceof String ? new q((String) this.f8587a) : (Number) obj;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f8587a == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = h().longValue();
        } else {
            Object obj = this.f8587a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(h().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public t(Number number) {
        a((Object) number);
    }

    public t(String str) {
        a((Object) str);
    }

    public boolean a() {
        Object obj = this.f8587a;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return Boolean.parseBoolean(g());
    }

    public static boolean a(t tVar) {
        Object obj = tVar.f8587a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }
}
