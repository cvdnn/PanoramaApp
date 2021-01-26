package e.g.a.a.u;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

/* compiled from: CalendarConstraints */
public final class a implements Parcelable {
    public static final Creator<a> CREATOR = new C0112a();

    /* renamed from: a reason: collision with root package name */
    public final n f8314a;

    /* renamed from: b reason: collision with root package name */
    public final n f8315b;

    /* renamed from: c reason: collision with root package name */
    public final n f8316c;

    /* renamed from: d reason: collision with root package name */
    public final b f8317d;

    /* renamed from: e reason: collision with root package name */
    public final int f8318e;

    /* renamed from: f reason: collision with root package name */
    public final int f8319f;

    /* renamed from: e.g.a.a.u.a$a reason: collision with other inner class name */
    /* compiled from: CalendarConstraints */
    public static class C0112a implements Creator<a> {
        public Object createFromParcel(Parcel parcel) {
            a aVar = new a((n) parcel.readParcelable(n.class.getClassLoader()), (n) parcel.readParcelable(n.class.getClassLoader()), (n) parcel.readParcelable(n.class.getClassLoader()), (b) parcel.readParcelable(b.class.getClassLoader()), null);
            return aVar;
        }

        public Object[] newArray(int i2) {
            return new a[i2];
        }
    }

    /* compiled from: CalendarConstraints */
    public interface b extends Parcelable {
        boolean a(long j2);
    }

    public /* synthetic */ a(n nVar, n nVar2, n nVar3, b bVar, C0112a aVar) {
        this.f8314a = nVar;
        this.f8315b = nVar2;
        this.f8316c = nVar3;
        this.f8317d = bVar;
        if (nVar.f8367a.compareTo(nVar3.f8367a) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (nVar3.f8367a.compareTo(nVar2.f8367a) <= 0) {
            this.f8319f = nVar.b(nVar2) + 1;
            this.f8318e = (nVar2.f8370d - nVar.f8370d) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f8314a.equals(aVar.f8314a) || !this.f8315b.equals(aVar.f8315b) || !this.f8316c.equals(aVar.f8316c) || !this.f8317d.equals(aVar.f8317d)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8314a, this.f8315b, this.f8316c, this.f8317d});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f8314a, 0);
        parcel.writeParcelable(this.f8315b, 0);
        parcel.writeParcelable(this.f8316c, 0);
        parcel.writeParcelable(this.f8317d, 0);
    }
}
