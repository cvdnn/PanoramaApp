package e.g.a.a.u;

import android.widget.BaseAdapter;
import e.c.f.n.n;
import java.util.Calendar;

/* compiled from: MonthAdapter */
public class o extends BaseAdapter {

    /* renamed from: e reason: collision with root package name */
    public static final int f8373e = n.e().getMaximum(4);

    /* renamed from: a reason: collision with root package name */
    public final n f8374a;

    /* renamed from: b reason: collision with root package name */
    public final d<?> f8375b;

    /* renamed from: c reason: collision with root package name */
    public c f8376c;

    /* renamed from: d reason: collision with root package name */
    public final a f8377d;

    public o(n nVar, d<?> dVar, a aVar) {
        this.f8374a = nVar;
        this.f8375b = dVar;
        this.f8377d = aVar;
    }

    public int a() {
        return this.f8374a.a();
    }

    public int b() {
        return (this.f8374a.a() + this.f8374a.f8372f) - 1;
    }

    public int getCount() {
        return a() + this.f8374a.f8372f;
    }

    public long getItemId(int i2) {
        return (long) (i2 / this.f8374a.f8371e);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r8, android.view.View r9, android.view.ViewGroup r10) {
        /*
            r7 = this;
            android.content.Context r0 = r10.getContext()
            e.g.a.a.u.c r1 = r7.f8376c
            if (r1 != 0) goto L_0x000f
            e.g.a.a.u.c r1 = new e.g.a.a.u.c
            r1.<init>(r0)
            r7.f8376c = r1
        L_0x000f:
            r0 = r9
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r9 != 0) goto L_0x0026
            android.content.Context r9 = r10.getContext()
            android.view.LayoutInflater r9 = android.view.LayoutInflater.from(r9)
            int r0 = e.g.a.a.h.mtrl_calendar_day
            android.view.View r9 = r9.inflate(r0, r10, r1)
            r0 = r9
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0026:
            int r9 = r7.a()
            int r9 = r8 - r9
            r10 = 1
            if (r9 < 0) goto L_0x00db
            e.g.a.a.u.n r2 = r7.f8374a
            int r3 = r2.f8372f
            if (r9 < r3) goto L_0x0037
            goto L_0x00db
        L_0x0037:
            int r9 = r9 + r10
            r0.setTag(r2)
            java.lang.String r2 = java.lang.String.valueOf(r9)
            r0.setText(r2)
            e.g.a.a.u.n r2 = r7.f8374a
            java.util.Calendar r2 = r2.f8367a
            java.util.Calendar r2 = e.c.f.n.n.a(r2)
            r3 = 5
            r2.set(r3, r9)
            long r2 = r2.getTimeInMillis()
            e.g.a.a.u.n r9 = r7.f8374a
            int r9 = r9.f8370d
            e.g.a.a.u.n r4 = new e.g.a.a.u.n
            java.util.Calendar r5 = e.c.f.n.n.d()
            r4.<init>(r5)
            int r4 = r4.f8370d
            java.lang.String r5 = "UTC"
            r6 = 24
            if (r9 != r4) goto L_0x009e
            java.util.Locale r9 = java.util.Locale.getDefault()
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r6) goto L_0x0086
            java.lang.String r4 = "MMMEd"
            android.icu.text.DateFormat r9 = android.icu.text.DateFormat.getInstanceForSkeleton(r4, r9)
            android.icu.util.TimeZone r4 = android.icu.util.TimeZone.getTimeZone(r5)
            r9.setTimeZone(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r2)
            java.lang.String r9 = r9.format(r4)
            goto L_0x009a
        L_0x0086:
            java.text.DateFormat r9 = java.text.DateFormat.getDateInstance(r1, r9)
            java.util.TimeZone r4 = e.c.f.n.n.c()
            r9.setTimeZone(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r2)
            java.lang.String r9 = r9.format(r4)
        L_0x009a:
            r0.setContentDescription(r9)
            goto L_0x00d4
        L_0x009e:
            java.util.Locale r9 = java.util.Locale.getDefault()
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r6) goto L_0x00bd
            java.lang.String r4 = "yMMMEd"
            android.icu.text.DateFormat r9 = android.icu.text.DateFormat.getInstanceForSkeleton(r4, r9)
            android.icu.util.TimeZone r4 = android.icu.util.TimeZone.getTimeZone(r5)
            r9.setTimeZone(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r2)
            java.lang.String r9 = r9.format(r4)
            goto L_0x00d1
        L_0x00bd:
            java.text.DateFormat r9 = java.text.DateFormat.getDateInstance(r1, r9)
            java.util.TimeZone r4 = e.c.f.n.n.c()
            r9.setTimeZone(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r2)
            java.lang.String r9 = r9.format(r4)
        L_0x00d1:
            r0.setContentDescription(r9)
        L_0x00d4:
            r0.setVisibility(r1)
            r0.setEnabled(r10)
            goto L_0x00e3
        L_0x00db:
            r9 = 8
            r0.setVisibility(r9)
            r0.setEnabled(r1)
        L_0x00e3:
            java.lang.Long r8 = r7.getItem(r8)
            if (r8 != 0) goto L_0x00eb
            goto L_0x016e
        L_0x00eb:
            e.g.a.a.u.a r9 = r7.f8377d
            e.g.a.a.u.a$b r9 = r9.f8317d
            long r2 = r8.longValue()
            boolean r9 = r9.a(r2)
            if (r9 == 0) goto L_0x0164
            r0.setEnabled(r10)
            e.g.a.a.u.d<?> r9 = r7.f8375b
            java.util.Collection r9 = r9.l()
            java.util.Iterator r9 = r9.iterator()
        L_0x0106:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0144
            java.lang.Object r10 = r9.next()
            java.lang.Long r10 = (java.lang.Long) r10
            long r1 = r10.longValue()
            long r3 = r8.longValue()
            java.util.Calendar r10 = e.c.f.n.n.e()
            r10.setTimeInMillis(r3)
            java.util.Calendar r10 = e.c.f.n.n.a(r10)
            long r3 = r10.getTimeInMillis()
            java.util.Calendar r10 = e.c.f.n.n.e()
            r10.setTimeInMillis(r1)
            java.util.Calendar r10 = e.c.f.n.n.a(r10)
            long r1 = r10.getTimeInMillis()
            int r10 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r10 != 0) goto L_0x0106
            e.g.a.a.u.c r8 = r7.f8376c
            e.g.a.a.u.b r8 = r8.f8327b
            r8.a(r0)
            goto L_0x016e
        L_0x0144:
            java.util.Calendar r9 = e.c.f.n.n.d()
            long r9 = r9.getTimeInMillis()
            long r1 = r8.longValue()
            int r8 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x015c
            e.g.a.a.u.c r8 = r7.f8376c
            e.g.a.a.u.b r8 = r8.f8328c
            r8.a(r0)
            goto L_0x016e
        L_0x015c:
            e.g.a.a.u.c r8 = r7.f8376c
            e.g.a.a.u.b r8 = r8.f8326a
            r8.a(r0)
            goto L_0x016e
        L_0x0164:
            r0.setEnabled(r1)
            e.g.a.a.u.c r8 = r7.f8376c
            e.g.a.a.u.b r8 = r8.f8332g
            r8.a(r0)
        L_0x016e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.a.a.u.o.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public boolean hasStableIds() {
        return true;
    }

    public Long getItem(int i2) {
        if (i2 < this.f8374a.a() || i2 > b()) {
            return null;
        }
        n nVar = this.f8374a;
        int a2 = (i2 - nVar.a()) + 1;
        Calendar a3 = n.a(nVar.f8367a);
        a3.set(5, a2);
        return Long.valueOf(a3.getTimeInMillis());
    }
}
