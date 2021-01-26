package e.c.d.d.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: IPCEvent */
public class c implements Parcelable {
    public static final Creator<c> CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    public String f6000a;

    /* renamed from: b reason: collision with root package name */
    public String f6001b;

    /* compiled from: IPCEvent */
    public static class a implements Creator<c> {
        public Object createFromParcel(Parcel parcel) {
            return new c(parcel, (a) null);
        }

        public Object[] newArray(int i2) {
            return new c[i2];
        }
    }

    public c(String str, String str2) {
        this.f6000a = str;
        this.f6001b = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6000a);
        parcel.writeString(this.f6001b);
    }

    public /* synthetic */ c(Parcel parcel, a aVar) {
        this.f6000a = parcel.readString();
        this.f6001b = parcel.readString();
    }
}
