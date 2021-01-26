package f.a.a.c;

import com.arashivision.graphicpath.render.source.AssetInfo.SubMediaType;
import java.nio.ShortBuffer;

/* compiled from: AudioRemixer */
public interface b {

    /* renamed from: a reason: collision with root package name */
    public static final b f9014a = new a();

    /* renamed from: b reason: collision with root package name */
    public static final b f9015b = new C0138b();

    /* renamed from: c reason: collision with root package name */
    public static final b f9016c = new c();

    /* compiled from: AudioRemixer */
    public static class a implements b {
        public void a(ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
            int i2;
            int min = Math.min(shortBuffer.remaining() / 2, shortBuffer2.remaining());
            for (int i3 = 0; i3 < min; i3++) {
                int i4 = shortBuffer.get() + 32768;
                int i5 = shortBuffer.get() + 32768;
                int i6 = SubMediaType.UNDEFINED;
                if (i4 < 32768 || i5 < 32768) {
                    i2 = (i4 * i5) / 32768;
                } else {
                    i2 = (((i4 + i5) * 2) - ((i4 * i5) / 32768)) - SubMediaType.UNDEFINED;
                }
                if (i2 != 65536) {
                    i6 = i2;
                }
                shortBuffer2.put((short) (i6 - 32768));
            }
        }
    }

    /* renamed from: f.a.a.c.b$b reason: collision with other inner class name */
    /* compiled from: AudioRemixer */
    public static class C0138b implements b {
        public void a(ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
            int min = Math.min(shortBuffer.remaining(), shortBuffer2.remaining() / 2);
            for (int i2 = 0; i2 < min; i2++) {
                short s = shortBuffer.get();
                shortBuffer2.put(s);
                shortBuffer2.put(s);
            }
        }
    }

    /* compiled from: AudioRemixer */
    public static class c implements b {
        public void a(ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
            shortBuffer2.put(shortBuffer);
        }
    }

    void a(ShortBuffer shortBuffer, ShortBuffer shortBuffer2);
}
