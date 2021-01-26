package a.a.a.a.a.g;

import android.text.TextUtils;
import com.arashivision.insta360.basemedia.MediaModule;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public abstract class a implements Comparable<a> {

    /* renamed from: a reason: collision with root package name */
    public byte[] f389a;

    /* renamed from: b reason: collision with root package name */
    public float[] f390b;

    public final void a() {
        if (!TextUtils.isEmpty(null)) {
            try {
                InputStream open = MediaModule.getApplication().getAssets().open(null);
                int available = open.available();
                byte[] bArr = new byte[available];
                open.read(bArr);
                open.close();
                int i2 = bArr[0] + (bArr[1] << 8) + (bArr[2] << 16) + (bArr[3] << 24);
                this.f389a = Arrays.copyOfRange(bArr, 8, available);
                float f2 = (float) i2;
                this.f390b = new float[]{f2, f2, f2};
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public int compareTo(Object obj) {
        if (((a) obj) != null) {
            return 1;
        }
        throw null;
    }
}
