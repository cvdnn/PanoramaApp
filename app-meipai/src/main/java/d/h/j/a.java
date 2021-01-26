package d.h.j;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter */
public class a extends Writer {

    /* renamed from: a reason: collision with root package name */
    public final String f4901a;

    /* renamed from: b reason: collision with root package name */
    public StringBuilder f4902b = new StringBuilder(128);

    public a(String str) {
        this.f4901a = str;
    }

    public final void a() {
        if (this.f4902b.length() > 0) {
            Log.d(this.f4901a, this.f4902b.toString());
            StringBuilder sb = this.f4902b;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == 10) {
                a();
            } else {
                this.f4902b.append(c2);
            }
        }
    }
}
