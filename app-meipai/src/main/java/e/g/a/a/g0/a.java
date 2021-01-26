package e.g.a.a.g0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import d.e.h;

/* compiled from: ExtendableSavedState */
public class a extends d.j.a.a {
    public static final Creator<a> CREATOR = new C0107a();

    /* renamed from: c reason: collision with root package name */
    public final h<String, Bundle> f8158c;

    /* renamed from: e.g.a.a.g0.a$a reason: collision with other inner class name */
    /* compiled from: ExtendableSavedState */
    public static class C0107a implements ClassLoaderCreator<a> {
        public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }

        public Object[] newArray(int i2) {
            return new a[i2];
        }

        public Object createFromParcel(Parcel parcel) {
            return new a(parcel, null, null);
        }
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f8158c = new h<>();
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("ExtendableSavedState{");
        a2.append(Integer.toHexString(System.identityHashCode(this)));
        a2.append(" states=");
        a2.append(this.f8158c);
        a2.append("}");
        return a2.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f5012a, i2);
        int i3 = this.f8158c.f4602c;
        parcel.writeInt(i3);
        String[] strArr = new String[i3];
        Bundle[] bundleArr = new Bundle[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            strArr[i4] = (String) this.f8158c.c(i4);
            bundleArr[i4] = (Bundle) this.f8158c.e(i4);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public /* synthetic */ a(Parcel parcel, ClassLoader classLoader, C0107a aVar) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f8158c = new h<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f8158c.put(strArr[i2], bundleArr[i2]);
        }
    }
}
