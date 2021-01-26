package d.r.d;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.f;
import d.h.j.c;
import d.h.j.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdapterHelper */
public class a implements d.r.d.q.a {

    /* renamed from: a reason: collision with root package name */
    public c<b> f5299a = new d(30);

    /* renamed from: b reason: collision with root package name */
    public final ArrayList<b> f5300b = new ArrayList<>();

    /* renamed from: c reason: collision with root package name */
    public final ArrayList<b> f5301c = new ArrayList<>();

    /* renamed from: d reason: collision with root package name */
    public final C0053a f5302d;

    /* renamed from: e reason: collision with root package name */
    public final boolean f5303e;

    /* renamed from: f reason: collision with root package name */
    public final q f5304f;

    /* renamed from: g reason: collision with root package name */
    public int f5305g = 0;

    /* renamed from: d.r.d.a$a reason: collision with other inner class name */
    /* compiled from: AdapterHelper */
    public interface C0053a {
    }

    /* compiled from: AdapterHelper */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public int f5306a;

        /* renamed from: b reason: collision with root package name */
        public int f5307b;

        /* renamed from: c reason: collision with root package name */
        public Object f5308c;

        /* renamed from: d reason: collision with root package name */
        public int f5309d;

        public b(int i2, int i3, int i4, Object obj) {
            this.f5306a = i2;
            this.f5307b = i3;
            this.f5309d = i4;
            this.f5308c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i2 = this.f5306a;
            if (i2 != bVar.f5306a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f5309d - this.f5307b) == 1 && this.f5309d == bVar.f5307b && this.f5307b == bVar.f5309d) {
                return true;
            }
            if (this.f5309d != bVar.f5309d || this.f5307b != bVar.f5307b) {
                return false;
            }
            Object obj2 = this.f5308c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f5308c)) {
                    return false;
                }
            } else if (bVar.f5308c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f5306a * 31) + this.f5307b) * 31) + this.f5309d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i2 = this.f5306a;
            String str = i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add";
            sb.append(str);
            sb.append(",s:");
            sb.append(this.f5307b);
            sb.append("c:");
            sb.append(this.f5309d);
            sb.append(",p:");
            sb.append(this.f5308c);
            sb.append("]");
            return sb.toString();
        }
    }

    public a(C0053a aVar) {
        this.f5302d = aVar;
        this.f5303e = false;
        this.f5304f = new q(this);
    }

    public void a() {
        int size = this.f5301c.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((f) this.f5302d).a((b) this.f5301c.get(i2));
        }
        a((List<b>) this.f5301c);
        this.f5305g = 0;
    }

    public final int b(int i2, int i3) {
        for (int size = this.f5301c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f5301c.get(size);
            int i4 = bVar.f5306a;
            if (i4 == 8) {
                int i5 = bVar.f5307b;
                int i6 = bVar.f5309d;
                if (i5 >= i6) {
                    int i7 = i6;
                    i6 = i5;
                    i5 = i7;
                }
                if (i2 < i5 || i2 > i6) {
                    int i8 = bVar.f5307b;
                    if (i2 < i8) {
                        if (i3 == 1) {
                            bVar.f5307b = i8 + 1;
                            bVar.f5309d++;
                        } else if (i3 == 2) {
                            bVar.f5307b = i8 - 1;
                            bVar.f5309d--;
                        }
                    }
                } else {
                    int i9 = bVar.f5307b;
                    if (i5 == i9) {
                        if (i3 == 1) {
                            bVar.f5309d++;
                        } else if (i3 == 2) {
                            bVar.f5309d--;
                        }
                        i2++;
                    } else {
                        if (i3 == 1) {
                            bVar.f5307b = i9 + 1;
                        } else if (i3 == 2) {
                            bVar.f5307b = i9 - 1;
                        }
                        i2--;
                    }
                }
            } else {
                int i10 = bVar.f5307b;
                if (i10 <= i2) {
                    if (i4 == 1) {
                        i2 -= bVar.f5309d;
                    } else if (i4 == 2) {
                        i2 += bVar.f5309d;
                    }
                } else if (i3 == 1) {
                    bVar.f5307b = i10 + 1;
                } else if (i3 == 2) {
                    bVar.f5307b = i10 - 1;
                }
            }
        }
        for (int size2 = this.f5301c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f5301c.get(size2);
            if (bVar2.f5306a == 8) {
                int i11 = bVar2.f5309d;
                if (i11 == bVar2.f5307b || i11 < 0) {
                    this.f5301c.remove(size2);
                    if (!this.f5303e) {
                        bVar2.f5308c = null;
                        this.f5299a.a(bVar2);
                    }
                }
            } else if (bVar2.f5309d <= 0) {
                this.f5301c.remove(size2);
                if (!this.f5303e) {
                    bVar2.f5308c = null;
                    this.f5299a.a(bVar2);
                }
            }
        }
        return i2;
    }

    public boolean c() {
        return this.f5300b.size() > 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:189:0x0009 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r16 = this;
            r0 = r16
            d.r.d.q r1 = r0.f5304f
            java.util.ArrayList<d.r.d.a$b> r2 = r0.f5300b
            r3 = 0
            if (r1 == 0) goto L_0x02d6
        L_0x0009:
            int r4 = r2.size()
            r5 = 1
            int r4 = r4 - r5
            r7 = 0
        L_0x0010:
            r8 = 8
            r9 = -1
            if (r4 < 0) goto L_0x0026
            java.lang.Object r10 = r2.get(r4)
            d.r.d.a$b r10 = (d.r.d.a.b) r10
            int r10 = r10.f5306a
            if (r10 != r8) goto L_0x0022
            if (r7 == 0) goto L_0x0023
            goto L_0x0027
        L_0x0022:
            r7 = r5
        L_0x0023:
            int r4 = r4 + -1
            goto L_0x0010
        L_0x0026:
            r4 = r9
        L_0x0027:
            r7 = 4
            r10 = 2
            if (r4 == r9) goto L_0x01ec
            int r8 = r4 + 1
            java.lang.Object r11 = r2.get(r4)
            d.r.d.a$b r11 = (d.r.d.a.b) r11
            java.lang.Object r12 = r2.get(r8)
            d.r.d.a$b r12 = (d.r.d.a.b) r12
            int r13 = r12.f5306a
            if (r13 == r5) goto L_0x01b8
            if (r13 == r10) goto L_0x00b1
            if (r13 == r7) goto L_0x0042
            goto L_0x0009
        L_0x0042:
            int r6 = r11.f5309d
            int r9 = r12.f5307b
            if (r6 >= r9) goto L_0x004d
            int r9 = r9 + -1
            r12.f5307b = r9
            goto L_0x0063
        L_0x004d:
            int r10 = r12.f5309d
            int r9 = r9 + r10
            if (r6 >= r9) goto L_0x0063
            int r10 = r10 + -1
            r12.f5309d = r10
            d.r.d.q$a r6 = r1.f5398a
            int r9 = r11.f5307b
            java.lang.Object r10 = r12.f5308c
            d.r.d.a r6 = (d.r.d.a) r6
            d.r.d.a$b r5 = r6.a(r7, r9, r5, r10)
            goto L_0x0064
        L_0x0063:
            r5 = r3
        L_0x0064:
            int r6 = r11.f5307b
            int r9 = r12.f5307b
            if (r6 > r9) goto L_0x006f
            int r9 = r9 + 1
            r12.f5307b = r9
            goto L_0x0087
        L_0x006f:
            int r10 = r12.f5309d
            int r9 = r9 + r10
            if (r6 >= r9) goto L_0x0087
            int r9 = r9 - r6
            d.r.d.q$a r10 = r1.f5398a
            int r6 = r6 + 1
            java.lang.Object r13 = r12.f5308c
            d.r.d.a r10 = (d.r.d.a) r10
            d.r.d.a$b r6 = r10.a(r7, r6, r9, r13)
            int r7 = r12.f5309d
            int r7 = r7 - r9
            r12.f5309d = r7
            goto L_0x0088
        L_0x0087:
            r6 = r3
        L_0x0088:
            r2.set(r8, r11)
            int r7 = r12.f5309d
            if (r7 <= 0) goto L_0x0093
            r2.set(r4, r12)
            goto L_0x00a5
        L_0x0093:
            r2.remove(r4)
            d.r.d.q$a r7 = r1.f5398a
            d.r.d.a r7 = (d.r.d.a) r7
            boolean r8 = r7.f5303e
            if (r8 != 0) goto L_0x00a5
            r12.f5308c = r3
            d.h.j.c<d.r.d.a$b> r7 = r7.f5299a
            r7.a(r12)
        L_0x00a5:
            if (r5 == 0) goto L_0x00aa
            r2.add(r4, r5)
        L_0x00aa:
            if (r6 == 0) goto L_0x0009
            r2.add(r4, r6)
            goto L_0x0009
        L_0x00b1:
            int r7 = r11.f5307b
            int r9 = r11.f5309d
            if (r7 >= r9) goto L_0x00c5
            int r13 = r12.f5307b
            if (r13 != r7) goto L_0x00c3
            int r13 = r12.f5309d
            int r9 = r9 - r7
            if (r13 != r9) goto L_0x00c3
            r6 = r5
            r7 = 0
            goto L_0x00d5
        L_0x00c3:
            r6 = 0
            goto L_0x00d1
        L_0x00c5:
            int r13 = r12.f5307b
            int r14 = r9 + 1
            if (r13 != r14) goto L_0x00d3
            int r13 = r12.f5309d
            int r7 = r7 - r9
            if (r13 != r7) goto L_0x00d3
            r6 = r5
        L_0x00d1:
            r7 = r6
            goto L_0x00d5
        L_0x00d3:
            r7 = r5
            r6 = 0
        L_0x00d5:
            int r9 = r11.f5309d
            int r13 = r12.f5307b
            if (r9 >= r13) goto L_0x00e0
            int r13 = r13 + -1
            r12.f5307b = r13
            goto L_0x0105
        L_0x00e0:
            int r14 = r12.f5309d
            int r13 = r13 + r14
            if (r9 >= r13) goto L_0x0105
            int r14 = r14 + -1
            r12.f5309d = r14
            r11.f5306a = r10
            r11.f5309d = r5
            int r4 = r12.f5309d
            if (r4 != 0) goto L_0x0009
            r2.remove(r8)
            d.r.d.q$a r4 = r1.f5398a
            d.r.d.a r4 = (d.r.d.a) r4
            boolean r5 = r4.f5303e
            if (r5 != 0) goto L_0x0009
            r12.f5308c = r3
            d.h.j.c<d.r.d.a$b> r4 = r4.f5299a
            r4.a(r12)
            goto L_0x0009
        L_0x0105:
            int r5 = r11.f5307b
            int r9 = r12.f5307b
            if (r5 > r9) goto L_0x0110
            int r9 = r9 + 1
            r12.f5307b = r9
            goto L_0x0128
        L_0x0110:
            int r13 = r12.f5309d
            int r9 = r9 + r13
            if (r5 >= r9) goto L_0x0128
            int r9 = r9 - r5
            d.r.d.q$a r13 = r1.f5398a
            int r5 = r5 + 1
            d.r.d.a r13 = (d.r.d.a) r13
            d.r.d.a$b r5 = r13.a(r10, r5, r9, r3)
            int r9 = r11.f5307b
            int r10 = r12.f5307b
            int r9 = r9 - r10
            r12.f5309d = r9
            goto L_0x0129
        L_0x0128:
            r5 = r3
        L_0x0129:
            if (r6 == 0) goto L_0x0142
            r2.set(r4, r12)
            r2.remove(r8)
            d.r.d.q$a r4 = r1.f5398a
            d.r.d.a r4 = (d.r.d.a) r4
            boolean r5 = r4.f5303e
            if (r5 != 0) goto L_0x0009
            r11.f5308c = r3
            d.h.j.c<d.r.d.a$b> r4 = r4.f5299a
            r4.a(r11)
            goto L_0x0009
        L_0x0142:
            if (r7 == 0) goto L_0x0173
            if (r5 == 0) goto L_0x015c
            int r6 = r11.f5307b
            int r7 = r5.f5307b
            if (r6 <= r7) goto L_0x0151
            int r7 = r5.f5309d
            int r6 = r6 - r7
            r11.f5307b = r6
        L_0x0151:
            int r6 = r11.f5309d
            int r7 = r5.f5307b
            if (r6 <= r7) goto L_0x015c
            int r7 = r5.f5309d
            int r6 = r6 - r7
            r11.f5309d = r6
        L_0x015c:
            int r6 = r11.f5307b
            int r7 = r12.f5307b
            if (r6 <= r7) goto L_0x0167
            int r7 = r12.f5309d
            int r6 = r6 - r7
            r11.f5307b = r6
        L_0x0167:
            int r6 = r11.f5309d
            int r7 = r12.f5307b
            if (r6 <= r7) goto L_0x01a1
            int r7 = r12.f5309d
            int r6 = r6 - r7
            r11.f5309d = r6
            goto L_0x01a1
        L_0x0173:
            if (r5 == 0) goto L_0x018b
            int r6 = r11.f5307b
            int r7 = r5.f5307b
            if (r6 < r7) goto L_0x0180
            int r7 = r5.f5309d
            int r6 = r6 - r7
            r11.f5307b = r6
        L_0x0180:
            int r6 = r11.f5309d
            int r7 = r5.f5307b
            if (r6 < r7) goto L_0x018b
            int r7 = r5.f5309d
            int r6 = r6 - r7
            r11.f5309d = r6
        L_0x018b:
            int r6 = r11.f5307b
            int r7 = r12.f5307b
            if (r6 < r7) goto L_0x0196
            int r7 = r12.f5309d
            int r6 = r6 - r7
            r11.f5307b = r6
        L_0x0196:
            int r6 = r11.f5309d
            int r7 = r12.f5307b
            if (r6 < r7) goto L_0x01a1
            int r7 = r12.f5309d
            int r6 = r6 - r7
            r11.f5309d = r6
        L_0x01a1:
            r2.set(r4, r12)
            int r6 = r11.f5307b
            int r7 = r11.f5309d
            if (r6 == r7) goto L_0x01ae
            r2.set(r8, r11)
            goto L_0x01b1
        L_0x01ae:
            r2.remove(r8)
        L_0x01b1:
            if (r5 == 0) goto L_0x0009
            r2.add(r4, r5)
            goto L_0x0009
        L_0x01b8:
            int r5 = r11.f5309d
            int r7 = r12.f5307b
            if (r5 >= r7) goto L_0x01c0
            r6 = r9
            goto L_0x01c1
        L_0x01c0:
            r6 = 0
        L_0x01c1:
            int r5 = r11.f5307b
            int r7 = r12.f5307b
            if (r5 >= r7) goto L_0x01c9
            int r6 = r6 + 1
        L_0x01c9:
            int r5 = r12.f5307b
            int r7 = r11.f5307b
            if (r5 > r7) goto L_0x01d4
            int r5 = r12.f5309d
            int r7 = r7 + r5
            r11.f5307b = r7
        L_0x01d4:
            int r5 = r12.f5307b
            int r7 = r11.f5309d
            if (r5 > r7) goto L_0x01df
            int r5 = r12.f5309d
            int r7 = r7 + r5
            r11.f5309d = r7
        L_0x01df:
            int r5 = r12.f5307b
            int r5 = r5 + r6
            r12.f5307b = r5
            r2.set(r4, r12)
            r2.set(r8, r11)
            goto L_0x0009
        L_0x01ec:
            java.util.ArrayList<d.r.d.a$b> r1 = r0.f5300b
            int r1 = r1.size()
            r2 = 0
        L_0x01f3:
            if (r2 >= r1) goto L_0x02d0
            java.util.ArrayList<d.r.d.a$b> r4 = r0.f5300b
            java.lang.Object r4 = r4.get(r2)
            d.r.d.a$b r4 = (d.r.d.a.b) r4
            int r11 = r4.f5306a
            if (r11 == r5) goto L_0x02c9
            if (r11 == r10) goto L_0x026b
            if (r11 == r7) goto L_0x020e
            if (r11 == r8) goto L_0x0209
            goto L_0x02cc
        L_0x0209:
            r0.b(r4)
            goto L_0x02cc
        L_0x020e:
            int r11 = r4.f5307b
            int r12 = r4.f5309d
            int r12 = r12 + r11
            r15 = r9
            r13 = r11
            r14 = 0
        L_0x0216:
            if (r11 >= r12) goto L_0x024a
            d.r.d.a$a r6 = r0.f5302d
            androidx.recyclerview.widget.RecyclerView$f r6 = (androidx.recyclerview.widget.RecyclerView.f) r6
            androidx.recyclerview.widget.RecyclerView$d0 r6 = r6.a(r11)
            if (r6 != 0) goto L_0x0238
            boolean r6 = r0.a(r11)
            if (r6 == 0) goto L_0x0229
            goto L_0x0238
        L_0x0229:
            if (r15 != r5) goto L_0x0236
            java.lang.Object r6 = r4.f5308c
            d.r.d.a$b r6 = r0.a(r7, r13, r14, r6)
            r0.b(r6)
            r13 = r11
            r14 = 0
        L_0x0236:
            r15 = 0
            goto L_0x0246
        L_0x0238:
            if (r15 != 0) goto L_0x0245
            java.lang.Object r6 = r4.f5308c
            d.r.d.a$b r6 = r0.a(r7, r13, r14, r6)
            r0.a(r6)
            r13 = r11
            r14 = 0
        L_0x0245:
            r15 = r5
        L_0x0246:
            int r14 = r14 + r5
            int r11 = r11 + 1
            goto L_0x0216
        L_0x024a:
            int r6 = r4.f5309d
            if (r14 == r6) goto L_0x025f
            java.lang.Object r6 = r4.f5308c
            boolean r11 = r0.f5303e
            if (r11 != 0) goto L_0x025b
            r4.f5308c = r3
            d.h.j.c<d.r.d.a$b> r11 = r0.f5299a
            r11.a(r4)
        L_0x025b:
            d.r.d.a$b r4 = r0.a(r7, r13, r14, r6)
        L_0x025f:
            if (r15 != 0) goto L_0x0266
            r0.a(r4)
            goto L_0x02cc
        L_0x0266:
            r0.b(r4)
            goto L_0x02cc
        L_0x026b:
            int r6 = r4.f5307b
            int r11 = r4.f5309d
            int r11 = r11 + r6
            r12 = r6
            r14 = r9
            r13 = 0
        L_0x0273:
            if (r12 >= r11) goto L_0x02ac
            d.r.d.a$a r15 = r0.f5302d
            androidx.recyclerview.widget.RecyclerView$f r15 = (androidx.recyclerview.widget.RecyclerView.f) r15
            androidx.recyclerview.widget.RecyclerView$d0 r15 = r15.a(r12)
            if (r15 != 0) goto L_0x0294
            boolean r15 = r0.a(r12)
            if (r15 == 0) goto L_0x0286
            goto L_0x0294
        L_0x0286:
            if (r14 != r5) goto L_0x0291
            d.r.d.a$b r14 = r0.a(r10, r6, r13, r3)
            r0.b(r14)
            r14 = r5
            goto L_0x0292
        L_0x0291:
            r14 = 0
        L_0x0292:
            r15 = 0
            goto L_0x02a1
        L_0x0294:
            if (r14 != 0) goto L_0x029f
            d.r.d.a$b r14 = r0.a(r10, r6, r13, r3)
            r0.a(r14)
            r14 = r5
            goto L_0x02a0
        L_0x029f:
            r14 = 0
        L_0x02a0:
            r15 = r5
        L_0x02a1:
            if (r14 == 0) goto L_0x02a7
            int r12 = r12 - r13
            int r11 = r11 - r13
            r13 = r5
            goto L_0x02a9
        L_0x02a7:
            int r13 = r13 + 1
        L_0x02a9:
            int r12 = r12 + r5
            r14 = r15
            goto L_0x0273
        L_0x02ac:
            int r11 = r4.f5309d
            if (r13 == r11) goto L_0x02bf
            boolean r11 = r0.f5303e
            if (r11 != 0) goto L_0x02bb
            r4.f5308c = r3
            d.h.j.c<d.r.d.a$b> r11 = r0.f5299a
            r11.a(r4)
        L_0x02bb:
            d.r.d.a$b r4 = r0.a(r10, r6, r13, r3)
        L_0x02bf:
            if (r14 != 0) goto L_0x02c5
            r0.a(r4)
            goto L_0x02cc
        L_0x02c5:
            r0.b(r4)
            goto L_0x02cc
        L_0x02c9:
            r0.b(r4)
        L_0x02cc:
            int r2 = r2 + 1
            goto L_0x01f3
        L_0x02d0:
            java.util.ArrayList<d.r.d.a$b> r1 = r0.f5300b
            r1.clear()
            return
        L_0x02d6:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d.r.d.a.d():void");
    }

    public void c(b bVar) {
        if (!this.f5303e) {
            bVar.f5308c = null;
            this.f5299a.a(bVar);
        }
    }

    public final void a(b bVar) {
        int i2;
        int i3 = bVar.f5306a;
        if (i3 == 1 || i3 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int b2 = b(bVar.f5307b, i3);
        int i4 = bVar.f5307b;
        int i5 = bVar.f5306a;
        if (i5 == 2) {
            i2 = 0;
        } else if (i5 == 4) {
            i2 = 1;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("op should be remove or update.");
            sb.append(bVar);
            throw new IllegalArgumentException(sb.toString());
        }
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.f5309d; i7++) {
            int b3 = b((i2 * i7) + bVar.f5307b, bVar.f5306a);
            int i8 = bVar.f5306a;
            if (i8 == 2 ? b3 == b2 : i8 == 4 && b3 == b2 + 1) {
                i6++;
            } else {
                b a2 = a(bVar.f5306a, b2, i6, bVar.f5308c);
                a(a2, i4);
                if (!this.f5303e) {
                    a2.f5308c = null;
                    this.f5299a.a(a2);
                }
                if (bVar.f5306a == 4) {
                    i4 += i6;
                }
                i6 = 1;
                b2 = b3;
            }
        }
        Object obj = bVar.f5308c;
        if (!this.f5303e) {
            bVar.f5308c = null;
            this.f5299a.a(bVar);
        }
        if (i6 > 0) {
            b a3 = a(bVar.f5306a, b2, i6, obj);
            a(a3, i4);
            if (!this.f5303e) {
                a3.f5308c = null;
                this.f5299a.a(a3);
            }
        }
    }

    public void a(b bVar, int i2) {
        ((f) this.f5302d).a(bVar);
        int i3 = bVar.f5306a;
        if (i3 == 2) {
            C0053a aVar = this.f5302d;
            int i4 = bVar.f5309d;
            f fVar = (f) aVar;
            RecyclerView.this.offsetPositionRecordsForRemove(i2, i4, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.f1014c += i4;
        } else if (i3 == 4) {
            C0053a aVar2 = this.f5302d;
            f fVar2 = (f) aVar2;
            RecyclerView.this.viewRangeUpdate(i2, bVar.f5309d, bVar.f5308c);
            RecyclerView.this.mItemsChanged = true;
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public final void b(b bVar) {
        this.f5301c.add(bVar);
        int i2 = bVar.f5306a;
        if (i2 == 1) {
            C0053a aVar = this.f5302d;
            f fVar = (f) aVar;
            RecyclerView.this.offsetPositionRecordsForInsert(bVar.f5307b, bVar.f5309d);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        } else if (i2 == 2) {
            C0053a aVar2 = this.f5302d;
            f fVar2 = (f) aVar2;
            RecyclerView.this.offsetPositionRecordsForRemove(bVar.f5307b, bVar.f5309d, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        } else if (i2 == 4) {
            ((f) this.f5302d).a(bVar.f5307b, bVar.f5309d, bVar.f5308c);
        } else if (i2 == 8) {
            C0053a aVar3 = this.f5302d;
            f fVar3 = (f) aVar3;
            RecyclerView.this.offsetPositionRecordsForMove(bVar.f5307b, bVar.f5309d);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown update op type for ");
            sb.append(bVar);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public final boolean a(int i2) {
        int size = this.f5301c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = (b) this.f5301c.get(i3);
            int i4 = bVar.f5306a;
            if (i4 == 8) {
                if (a(bVar.f5309d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = bVar.f5307b;
                int i6 = bVar.f5309d + i5;
                while (i5 < i6) {
                    if (a(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public void b() {
        a();
        int size = this.f5300b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.f5300b.get(i2);
            int i3 = bVar.f5306a;
            if (i3 == 1) {
                ((f) this.f5302d).a(bVar);
                C0053a aVar = this.f5302d;
                f fVar = (f) aVar;
                RecyclerView.this.offsetPositionRecordsForInsert(bVar.f5307b, bVar.f5309d);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            } else if (i3 == 2) {
                ((f) this.f5302d).a(bVar);
                C0053a aVar2 = this.f5302d;
                int i4 = bVar.f5307b;
                int i5 = bVar.f5309d;
                f fVar2 = (f) aVar2;
                RecyclerView.this.offsetPositionRecordsForRemove(i4, i5, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.f1014c += i5;
            } else if (i3 == 4) {
                ((f) this.f5302d).a(bVar);
                ((f) this.f5302d).a(bVar.f5307b, bVar.f5309d, bVar.f5308c);
            } else if (i3 == 8) {
                ((f) this.f5302d).a(bVar);
                C0053a aVar3 = this.f5302d;
                f fVar3 = (f) aVar3;
                RecyclerView.this.offsetPositionRecordsForMove(bVar.f5307b, bVar.f5309d);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        }
        a((List<b>) this.f5300b);
        this.f5305g = 0;
    }

    public int a(int i2, int i3) {
        int size = this.f5301c.size();
        while (i3 < size) {
            b bVar = (b) this.f5301c.get(i3);
            int i4 = bVar.f5306a;
            if (i4 == 8) {
                int i5 = bVar.f5307b;
                if (i5 == i2) {
                    i2 = bVar.f5309d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (bVar.f5309d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = bVar.f5307b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = bVar.f5309d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += bVar.f5309d;
                }
            }
            i3++;
        }
        return i2;
    }

    public b a(int i2, int i3, int i4, Object obj) {
        b bVar = (b) this.f5299a.a();
        if (bVar == null) {
            return new b(i2, i3, i4, obj);
        }
        bVar.f5306a = i2;
        bVar.f5307b = i3;
        bVar.f5309d = i4;
        bVar.f5308c = obj;
        return bVar;
    }

    public void a(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            c((b) list.get(i2));
        }
        list.clear();
    }
}
