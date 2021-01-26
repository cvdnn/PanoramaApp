package e.e.a.b;

import android.annotation.TargetApi;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseData.Builder;
import android.bluetooth.le.BluetoothLeAdvertiser;
import e.a.a.a.a;
import java.util.UUID;

/* compiled from: AdvertiseManager */
public class c {

    /* renamed from: a reason: collision with root package name */
    public final BluetoothLeAdvertiser f7942a;

    public c(BluetoothLeAdvertiser bluetoothLeAdvertiser) {
        this.f7942a = bluetoothLeAdvertiser;
    }

    @TargetApi(21)
    public static AdvertiseData a(int i2, UUID uuid, short s, short s2, byte b2) {
        String str = "";
        String[] split = uuid.toString().replaceAll("-", str).toLowerCase().split(str);
        byte[] bArr = new byte[16];
        int i3 = 1;
        int i4 = 0;
        while (i3 < split.length) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            bArr[i4] = (byte) ((Integer.parseInt(split[i3], 16) << 4) | Integer.parseInt(split[i5], 16));
            i4++;
            i3 = i6;
        }
        byte[] bArr2 = {(byte) (s >> 8), (byte) (s & 255)};
        byte[] bArr3 = {(byte) (s2 >> 8), (byte) (s2 & 255)};
        byte[] bArr4 = {b2};
        byte[] bArr5 = new byte[23];
        System.arraycopy(new byte[]{2, 21}, 0, bArr5, 0, 2);
        System.arraycopy(bArr, 0, bArr5, 2, 16);
        System.arraycopy(bArr2, 0, bArr5, 18, 2);
        System.arraycopy(bArr3, 0, bArr5, 20, 2);
        System.arraycopy(bArr4, 0, bArr5, 22, 1);
        Builder builder = new Builder();
        builder.addManufacturerData(i2 == 3 ? 6699 : 76, bArr5);
        AdvertiseData build = builder.build();
        StringBuilder a2 = a.a("new adv ");
        a2.append(build.toString());
        e.e.a.h.a.b(a2.toString());
        return build;
    }
}
