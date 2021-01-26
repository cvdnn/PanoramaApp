package d.n.a;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* compiled from: BackStackState */
public final class b implements Parcelable {
    public static final Creator<b> CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    public final int[] f5091a;

    /* renamed from: b reason: collision with root package name */
    public final ArrayList<String> f5092b;

    /* renamed from: c reason: collision with root package name */
    public final int[] f5093c;

    /* renamed from: d reason: collision with root package name */
    public final int[] f5094d;

    /* renamed from: e reason: collision with root package name */
    public final int f5095e;

    /* renamed from: f reason: collision with root package name */
    public final int f5096f;

    /* renamed from: g reason: collision with root package name */
    public final String f5097g;

    /* renamed from: h reason: collision with root package name */
    public final int f5098h;

    /* renamed from: i reason: collision with root package name */
    public final int f5099i;

    /* renamed from: j reason: collision with root package name */
    public final CharSequence f5100j;
    public final int k;
    public final CharSequence l;
    public final ArrayList<String> m;
    public final ArrayList<String> n;
    public final boolean o;

    /* compiled from: BackStackState */
    public static class a implements Creator<b> {
        public Object createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        public Object[] newArray(int i2) {
            return new b[i2];
        }
    }

    public b(a aVar) {
        int size = aVar.f5189a.size();
        this.f5091a = new int[(size * 5)];
        if (aVar.f5196h) {
            this.f5092b = new ArrayList<>(size);
            this.f5093c = new int[size];
            this.f5094d = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                d.n.a.q.a aVar2 = (d.n.a.q.a) aVar.f5189a.get(i2);
                int i4 = i3 + 1;
                this.f5091a[i3] = aVar2.f5199a;
                ArrayList<String> arrayList = this.f5092b;
                Fragment fragment = aVar2.f5200b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f5091a;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.f5201c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f5202d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.f5203e;
                int i8 = i7 + 1;
                iArr[i7] = aVar2.f5204f;
                this.f5093c[i2] = aVar2.f5205g.ordinal();
                this.f5094d[i2] = aVar2.f5206h.ordinal();
                i2++;
                i3 = i8;
            }
            this.f5095e = aVar.f5194f;
            this.f5096f = aVar.f5195g;
            this.f5097g = aVar.f5197i;
            this.f5098h = aVar.t;
            this.f5099i = aVar.f5198j;
            this.f5100j = aVar.k;
            this.k = aVar.l;
            this.l = aVar.m;
            this.m = aVar.n;
            this.n = aVar.o;
            this.o = aVar.p;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f5091a);
        parcel.writeStringList(this.f5092b);
        parcel.writeIntArray(this.f5093c);
        parcel.writeIntArray(this.f5094d);
        parcel.writeInt(this.f5095e);
        parcel.writeInt(this.f5096f);
        parcel.writeString(this.f5097g);
        parcel.writeInt(this.f5098h);
        parcel.writeInt(this.f5099i);
        TextUtils.writeToParcel(this.f5100j, parcel, 0);
        parcel.writeInt(this.k);
        TextUtils.writeToParcel(this.l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.f5091a = parcel.createIntArray();
        this.f5092b = parcel.createStringArrayList();
        this.f5093c = parcel.createIntArray();
        this.f5094d = parcel.createIntArray();
        this.f5095e = parcel.readInt();
        this.f5096f = parcel.readInt();
        this.f5097g = parcel.readString();
        this.f5098h = parcel.readInt();
        this.f5099i = parcel.readInt();
        this.f5100j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.k = parcel.readInt();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }
}
