package e.d.a.n.p;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.DecodeException;
import android.graphics.ImageDecoder.ImageInfo;
import android.graphics.ImageDecoder.OnHeaderDecodedListener;
import android.graphics.ImageDecoder.OnPartialImageListener;
import android.graphics.ImageDecoder.Source;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Size;
import com.baidu.mobstat.Config;
import e.d.a.n.b;
import e.d.a.n.h;
import e.d.a.n.i;
import e.d.a.n.j;
import e.d.a.n.n.w;
import e.d.a.n.p.c.d;
import e.d.a.n.p.c.e;
import e.d.a.n.p.c.l;
import e.d.a.n.p.c.m;
import e.d.a.n.p.c.r;
import java.io.IOException;

/* compiled from: ImageDecoderResourceDecoder */
public abstract class a<T> implements j<Source, T> {

    /* renamed from: a reason: collision with root package name */
    public final r f7647a = r.b();

    /* renamed from: e.d.a.n.p.a$a reason: collision with other inner class name */
    /* compiled from: ImageDecoderResourceDecoder */
    public class C0093a implements OnHeaderDecodedListener {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int f7648a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ int f7649b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean f7650c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ b f7651d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ l f7652e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ i f7653f;

        /* renamed from: e.d.a.n.p.a$a$a reason: collision with other inner class name */
        /* compiled from: ImageDecoderResourceDecoder */
        public class C0094a implements OnPartialImageListener {
            public C0094a(C0093a aVar) {
            }

            public boolean onPartialImage(DecodeException decodeException) {
                return false;
            }
        }

        public C0093a(int i2, int i3, boolean z, b bVar, l lVar, i iVar) {
            this.f7648a = i2;
            this.f7649b = i3;
            this.f7650c = z;
            this.f7651d = bVar;
            this.f7652e = lVar;
            this.f7653f = iVar;
        }

        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageInfo imageInfo, Source source) {
            boolean z = false;
            if (a.this.f7647a.a(this.f7648a, this.f7649b, this.f7650c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f7651d == b.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0094a(this));
            Size size = imageInfo.getSize();
            int i2 = this.f7648a;
            if (i2 == Integer.MIN_VALUE) {
                i2 = size.getWidth();
            }
            int i3 = this.f7649b;
            if (i3 == Integer.MIN_VALUE) {
                i3 = size.getHeight();
            }
            float b2 = this.f7652e.b(size.getWidth(), size.getHeight(), i2, i3);
            int round = Math.round(((float) size.getWidth()) * b2);
            int round2 = Math.round(((float) size.getHeight()) * b2);
            String str = "ImageDecoder";
            if (Log.isLoggable(str, 2)) {
                StringBuilder a2 = e.a.a.a.a.a("Resizing from [");
                a2.append(size.getWidth());
                String str2 = Config.EVENT_HEAT_X;
                a2.append(str2);
                a2.append(size.getHeight());
                a2.append("] to [");
                a2.append(round);
                a2.append(str2);
                a2.append(round2);
                a2.append("] scaleFactor: ");
                a2.append(b2);
                Log.v(str, a2.toString());
            }
            imageDecoder.setTargetSize(round, round2);
            int i4 = VERSION.SDK_INT;
            if (i4 >= 28) {
                if (this.f7653f == i.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z = true;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(z ? Named.DISPLAY_P3 : Named.SRGB));
            } else if (i4 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(Named.SRGB));
            }
        }
    }

    public boolean a(Object obj, h hVar) throws IOException {
        Source source = (Source) obj;
        return true;
    }

    public final w<T> a(Source source, int i2, int i3, h hVar) throws IOException {
        C0093a aVar = new C0093a(i2, i3, hVar.a(m.f7698i) != null && ((Boolean) hVar.a(m.f7698i)).booleanValue(), (b) hVar.a(m.f7695f), (l) hVar.a(l.f7690f), (i) hVar.a(m.f7696g));
        d dVar = (d) this;
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, aVar);
        String str = "BitmapImageDecoder";
        if (Log.isLoggable(str, 2)) {
            StringBuilder a2 = e.a.a.a.a.a("Decoded [");
            a2.append(decodeBitmap.getWidth());
            String str2 = Config.EVENT_HEAT_X;
            a2.append(str2);
            a2.append(decodeBitmap.getHeight());
            a2.append("] for [");
            a2.append(i2);
            a2.append(str2);
            a2.append(i3);
            a2.append("]");
            Log.v(str, a2.toString());
        }
        return new e(decodeBitmap, dVar.f7673b);
    }
}
