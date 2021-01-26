package e.c.f.f;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: CallArgs */
public class c implements Parcelable {
    public static final Creator<c> CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    public int f6932a;

    /* renamed from: b reason: collision with root package name */
    public int f6933b;

    /* renamed from: c reason: collision with root package name */
    public String f6934c;

    /* renamed from: d reason: collision with root package name */
    public Object[] f6935d;

    /* renamed from: e reason: collision with root package name */
    public Object[] f6936e;

    /* renamed from: f reason: collision with root package name */
    public Object f6937f;

    /* compiled from: CallArgs */
    public static class a implements Creator<c> {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new c[i2];
        }
    }

    public c() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6932a);
        parcel.writeInt(this.f6933b);
        parcel.writeString(this.f6934c);
        parcel.writeArray(this.f6936e);
        parcel.writeArray(this.f6935d);
        parcel.writeValue(this.f6937f);
    }

    public c(Parcel parcel) {
        this.f6932a = parcel.readInt();
        this.f6933b = parcel.readInt();
        this.f6934c = parcel.readString();
        this.f6936e = parcel.readArray(c.class.getClassLoader());
        this.f6935d = parcel.readArray(c.class.getClassLoader());
        this.f6937f = parcel.readValue(c.class.getClassLoader());
    }
}
