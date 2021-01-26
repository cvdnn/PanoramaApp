package e.h.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

/* compiled from: SavedState */
public class e extends BaseSavedState {
    public static final Creator<e> CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    public float f8627a;

    /* renamed from: b reason: collision with root package name */
    public float f8628b;

    /* renamed from: c reason: collision with root package name */
    public float f8629c;

    /* renamed from: d reason: collision with root package name */
    public int f8630d;

    /* renamed from: e reason: collision with root package name */
    public float f8631e;

    /* renamed from: f reason: collision with root package name */
    public float f8632f;

    /* compiled from: SavedState */
    public static class a implements Creator<e> {
        public Object createFromParcel(Parcel parcel) {
            return new e(parcel, null);
        }

        public Object[] newArray(int i2) {
            return new e[i2];
        }
    }

    public e(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.f8627a);
        parcel.writeFloat(this.f8628b);
        parcel.writeFloat(this.f8629c);
        parcel.writeInt(this.f8630d);
        parcel.writeFloat(this.f8631e);
        parcel.writeFloat(this.f8632f);
    }

    public /* synthetic */ e(Parcel parcel, a aVar) {
        super(parcel);
        this.f8627a = parcel.readFloat();
        this.f8628b = parcel.readFloat();
        this.f8629c = parcel.readFloat();
        this.f8630d = parcel.readInt();
        this.f8631e = parcel.readFloat();
        this.f8632f = parcel.readFloat();
    }
}
