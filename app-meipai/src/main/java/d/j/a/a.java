package d.j.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

/* compiled from: AbsSavedState */
public abstract class a implements Parcelable {
    public static final Creator<a> CREATOR = new b();

    /* renamed from: b reason: collision with root package name */
    public static final a f5011b = new C0045a();

    /* renamed from: a reason: collision with root package name */
    public final Parcelable f5012a;

    /* renamed from: d.j.a.a$a reason: collision with other inner class name */
    /* compiled from: AbsSavedState */
    public static class C0045a extends a {
        public C0045a() {
            super((C0045a) null);
        }
    }

    /* compiled from: AbsSavedState */
    public static class b implements ClassLoaderCreator<a> {
        public Object createFromParcel(Parcel parcel) {
            if (parcel.readParcelable(null) == null) {
                return a.f5011b;
            }
            throw new IllegalStateException("superState must be null");
        }

        public Object[] newArray(int i2) {
            return new a[i2];
        }

        public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f5011b;
            }
            throw new IllegalStateException("superState must be null");
        }
    }

    public /* synthetic */ a(C0045a aVar) {
        this.f5012a = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f5012a, i2);
    }

    public a(Parcelable parcelable) {
        if (parcelable != null) {
            if (parcelable == f5011b) {
                parcelable = null;
            }
            this.f5012a = parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = f5011b;
        }
        this.f5012a = readParcelable;
    }
}
