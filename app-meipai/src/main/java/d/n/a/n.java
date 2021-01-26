package d.n.a;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* compiled from: FragmentManagerState */
public final class n implements Parcelable {
    public static final Creator<n> CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    public ArrayList<p> f5167a;

    /* renamed from: b reason: collision with root package name */
    public ArrayList<String> f5168b;

    /* renamed from: c reason: collision with root package name */
    public b[] f5169c;

    /* renamed from: d reason: collision with root package name */
    public String f5170d = null;

    /* renamed from: e reason: collision with root package name */
    public int f5171e;

    /* compiled from: FragmentManagerState */
    public static class a implements Creator<n> {
        public Object createFromParcel(Parcel parcel) {
            return new n(parcel);
        }

        public Object[] newArray(int i2) {
            return new n[i2];
        }
    }

    public n() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f5167a);
        parcel.writeStringList(this.f5168b);
        parcel.writeTypedArray(this.f5169c, i2);
        parcel.writeString(this.f5170d);
        parcel.writeInt(this.f5171e);
    }

    public n(Parcel parcel) {
        this.f5167a = parcel.createTypedArrayList(p.CREATOR);
        this.f5168b = parcel.createStringArrayList();
        this.f5169c = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f5170d = parcel.readString();
        this.f5171e = parcel.readInt();
    }
}
