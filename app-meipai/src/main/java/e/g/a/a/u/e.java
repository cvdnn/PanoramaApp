package e.g.a.a.u;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import e.c.f.n.n;
import e.g.a.a.h;
import e.g.a.a.i;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: DaysOfWeekAdapter */
public class e extends BaseAdapter {

    /* renamed from: d reason: collision with root package name */
    public static final int f8334d = (VERSION.SDK_INT >= 26 ? 4 : 1);

    /* renamed from: a reason: collision with root package name */
    public final Calendar f8335a;

    /* renamed from: b reason: collision with root package name */
    public final int f8336b;

    /* renamed from: c reason: collision with root package name */
    public final int f8337c = this.f8335a.getFirstDayOfWeek();

    public e() {
        Calendar e2 = n.e();
        this.f8335a = e2;
        this.f8336b = e2.getMaximum(7);
    }

    public int getCount() {
        return this.f8336b;
    }

    public Object getItem(int i2) {
        int i3 = this.f8336b;
        if (i2 >= i3) {
            return null;
        }
        int i4 = i2 + this.f8337c;
        if (i4 > i3) {
            i4 -= i3;
        }
        return Integer.valueOf(i4);
    }

    public long getItemId(int i2) {
        return 0;
    }

    @SuppressLint({"WrongConstant"})
    public View getView(int i2, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(h.mtrl_calendar_day_of_week, viewGroup, false);
        }
        Calendar calendar = this.f8335a;
        int i3 = i2 + this.f8337c;
        int i4 = this.f8336b;
        if (i3 > i4) {
            i3 -= i4;
        }
        calendar.set(7, i3);
        textView.setText(this.f8335a.getDisplayName(7, f8334d, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(i.mtrl_picker_day_of_week_column_header), new Object[]{this.f8335a.getDisplayName(7, 2, Locale.getDefault())}));
        return textView;
    }
}
