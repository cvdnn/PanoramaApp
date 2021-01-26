package e.e.a.e;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: BleDevice */
public class b implements Parcelable {
    public static final Creator<b> CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    public BluetoothDevice f7983a;

    /* renamed from: b reason: collision with root package name */
    public byte[] f7984b;

    /* renamed from: c reason: collision with root package name */
    public int f7985c;

    /* renamed from: d reason: collision with root package name */
    public long f7986d;

    /* compiled from: BleDevice */
    public static class a implements Creator<b> {
        public Object createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        public Object[] newArray(int i2) {
            return new b[i2];
        }
    }

    public b(BluetoothDevice bluetoothDevice, int i2, byte[] bArr, long j2) {
        this.f7983a = bluetoothDevice;
        this.f7984b = bArr;
        this.f7985c = i2;
        this.f7986d = j2;
    }

    public String a() {
        if (this.f7983a == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7983a.getName());
        sb.append(this.f7983a.getAddress());
        return sb.toString();
    }

    public String b() {
        BluetoothDevice bluetoothDevice = this.f7983a;
        if (bluetoothDevice != null) {
            return bluetoothDevice.getAddress();
        }
        return null;
    }

    public String c() {
        BluetoothDevice bluetoothDevice = this.f7983a;
        if (bluetoothDevice != null) {
            return bluetoothDevice.getName();
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f7983a, i2);
        parcel.writeByteArray(this.f7984b);
        parcel.writeInt(this.f7985c);
        parcel.writeLong(this.f7986d);
    }

    public b(Parcel parcel) {
        this.f7983a = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.f7984b = parcel.createByteArray();
        this.f7985c = parcel.readInt();
        this.f7986d = parcel.readLong();
    }
}
