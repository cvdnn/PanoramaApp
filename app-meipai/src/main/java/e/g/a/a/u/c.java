package e.g.a.a.u;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import e.c.f.n.n;
import e.g.a.a.b;
import e.g.a.a.k;

/* compiled from: CalendarStyle */
public final class c {

    /* renamed from: a reason: collision with root package name */
    public final b f8326a;

    /* renamed from: b reason: collision with root package name */
    public final b f8327b;

    /* renamed from: c reason: collision with root package name */
    public final b f8328c;

    /* renamed from: d reason: collision with root package name */
    public final b f8329d;

    /* renamed from: e reason: collision with root package name */
    public final b f8330e;

    /* renamed from: f reason: collision with root package name */
    public final b f8331f;

    /* renamed from: g reason: collision with root package name */
    public final b f8332g;

    /* renamed from: h reason: collision with root package name */
    public final Paint f8333h;

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(n.a(context, b.materialCalendarStyle, f.class.getCanonicalName()), k.MaterialCalendar);
        this.f8326a = b.a(context, obtainStyledAttributes.getResourceId(k.MaterialCalendar_dayStyle, 0));
        this.f8332g = b.a(context, obtainStyledAttributes.getResourceId(k.MaterialCalendar_dayInvalidStyle, 0));
        this.f8327b = b.a(context, obtainStyledAttributes.getResourceId(k.MaterialCalendar_daySelectedStyle, 0));
        this.f8328c = b.a(context, obtainStyledAttributes.getResourceId(k.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList a2 = n.a(context, obtainStyledAttributes, k.MaterialCalendar_rangeFillColor);
        this.f8329d = b.a(context, obtainStyledAttributes.getResourceId(k.MaterialCalendar_yearStyle, 0));
        this.f8330e = b.a(context, obtainStyledAttributes.getResourceId(k.MaterialCalendar_yearSelectedStyle, 0));
        this.f8331f = b.a(context, obtainStyledAttributes.getResourceId(k.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f8333h = paint;
        paint.setColor(a2.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
