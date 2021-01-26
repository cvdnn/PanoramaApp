package e.g.b.c0;

import java.math.BigDecimal;

/* compiled from: LazilyParsedNumber */
public final class q extends Number {

    /* renamed from: a reason: collision with root package name */
    public final String f8498a;

    public q(String str) {
        this.f8498a = str;
    }

    public double doubleValue() {
        return Double.parseDouble(this.f8498a);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        String str = this.f8498a;
        String str2 = qVar.f8498a;
        if (str != str2 && !str.equals(str2)) {
            z = false;
        }
        return z;
    }

    public float floatValue() {
        return Float.parseFloat(this.f8498a);
    }

    public int hashCode() {
        return this.f8498a.hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return (int) java.lang.Long.parseLong(r2.f8498a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        return new java.math.BigDecimal(r2.f8498a).intValue();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int intValue() {
        /*
            r2 = this;
            java.lang.String r0 = r2.f8498a     // Catch:{ NumberFormatException -> 0x0007 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0007 }
            return r0
        L_0x0007:
            java.lang.String r0 = r2.f8498a     // Catch:{ NumberFormatException -> 0x000f }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x000f }
            int r0 = (int) r0
            return r0
        L_0x000f:
            java.math.BigDecimal r0 = new java.math.BigDecimal
            java.lang.String r1 = r2.f8498a
            r0.<init>(r1)
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.c0.q.intValue():int");
    }

    public long longValue() {
        try {
            return Long.parseLong(this.f8498a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f8498a).longValue();
        }
    }

    public String toString() {
        return this.f8498a;
    }
}
