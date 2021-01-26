package e.g.a.a.u;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* compiled from: Month */
public final class n implements Comparable<n>, Parcelable {
    public static final Creator<n> CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    public final Calendar f8367a;

    /* renamed from: b reason: collision with root package name */
    public final String f8368b;

    /* renamed from: c reason: collision with root package name */
    public final int f8369c;

    /* renamed from: d reason: collision with root package name */
    public final int f8370d = this.f8367a.get(1);

    /* renamed from: e reason: collision with root package name */
    public final int f8371e = this.f8367a.getMaximum(7);

    /* renamed from: f reason: collision with root package name */
    public final int f8372f = this.f8367a.getActualMaximum(5);

    /* compiled from: Month */
    public static class a implements Creator<n> {
        public Object createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            Calendar e2 = e.c.f.n.n.e();
            e2.set(1, readInt);
            e2.set(2, readInt2);
            return new n(e2);
        }

        public Object[] newArray(int i2) {
            return new n[i2];
        }
    }

    public n(Calendar calendar) {
        calendar.set(5, 1);
        Calendar a2 = e.c.f.n.n.a(calendar);
        this.f8367a = a2;
        this.f8369c = a2.get(2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM, yyyy", Locale.getDefault());
        simpleDateFormat.setTimeZone(e.c.f.n.n.c());
        this.f8368b = simpleDateFormat.format(this.f8367a.getTime());
        this.f8367a.getTimeInMillis();
    }

    public int a() {
        int firstDayOfWeek = this.f8367a.get(7) - this.f8367a.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f8371e : firstDayOfWeek;
    }

    public int b(n nVar) {
        if (this.f8367a instanceof GregorianCalendar) {
            return (nVar.f8369c - this.f8369c) + ((nVar.f8370d - this.f8370d) * 12);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (!(this.f8369c == nVar.f8369c && this.f8370d == nVar.f8370d)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8369c), Integer.valueOf(this.f8370d)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f8370d);
        parcel.writeInt(this.f8369c);
    }

    /* renamed from: a */
    public int compareTo(n nVar) {
        return this.f8367a.compareTo(nVar.f8367a);
    }

    public n a(int i2) {
        Calendar a2 = e.c.f.n.n.a(this.f8367a);
        a2.add(2, i2);
        return new n(a2);
    }
}
