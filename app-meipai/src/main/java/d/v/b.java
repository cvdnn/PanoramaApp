package d.v;

import android.os.Parcel;
import android.util.SparseIntArray;
import d.e.a;
import java.lang.reflect.Method;

/* compiled from: VersionedParcelParcel */
public class b extends a {

    /* renamed from: d reason: collision with root package name */
    public final SparseIntArray f5604d;

    /* renamed from: e reason: collision with root package name */
    public final Parcel f5605e;

    /* renamed from: f reason: collision with root package name */
    public final int f5606f;

    /* renamed from: g reason: collision with root package name */
    public final int f5607g;

    /* renamed from: h reason: collision with root package name */
    public final String f5608h;

    /* renamed from: i reason: collision with root package name */
    public int f5609i;

    /* renamed from: j reason: collision with root package name */
    public int f5610j;
    public int k;

    public b(Parcel parcel) {
        Parcel parcel2 = parcel;
        this(parcel2, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    public boolean a(int i2) {
        while (true) {
            boolean z = true;
            if (this.f5610j < this.f5607g) {
                int i3 = this.k;
                if (i3 == i2) {
                    return true;
                }
                if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                    return false;
                }
                this.f5605e.setDataPosition(this.f5610j);
                int readInt = this.f5605e.readInt();
                this.k = this.f5605e.readInt();
                this.f5610j += readInt;
            } else {
                if (this.k != i2) {
                    z = false;
                }
                return z;
            }
        }
    }

    public void b(int i2) {
        a();
        this.f5609i = i2;
        this.f5604d.put(i2, this.f5605e.dataPosition());
        this.f5605e.writeInt(0);
        this.f5605e.writeInt(i2);
    }

    public b(Parcel parcel, int i2, int i3, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f5604d = new SparseIntArray();
        this.f5609i = -1;
        this.f5610j = 0;
        this.k = -1;
        this.f5605e = parcel;
        this.f5606f = i2;
        this.f5607g = i3;
        this.f5610j = i2;
        this.f5608h = str;
    }

    public a b() {
        Parcel parcel = this.f5605e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f5610j;
        if (i2 == this.f5606f) {
            i2 = this.f5607g;
        }
        b bVar = new b(parcel, dataPosition, i2, e.a.a.a.a.a(new StringBuilder(), this.f5608h, "  "), this.f5601a, this.f5602b, this.f5603c);
        return bVar;
    }

    public void a() {
        int i2 = this.f5609i;
        if (i2 >= 0) {
            int i3 = this.f5604d.get(i2);
            int dataPosition = this.f5605e.dataPosition();
            int i4 = dataPosition - i3;
            this.f5605e.setDataPosition(i3);
            this.f5605e.writeInt(i4);
            this.f5605e.setDataPosition(dataPosition);
        }
    }
}
