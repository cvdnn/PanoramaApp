package a.a.a.a.e.a.e;

import a.a.a.a.e.a.d;
import a.a.a.a.e.a.e.k.a;
import a.a.a.a.e.a.h.b;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.arashivision.arvbmg.exporter.DashBoardImage;
import com.arashivision.insta360.basemedia.MediaModule;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.baidubce.auth.NTLMEngineImpl;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class i {

    /* renamed from: h reason: collision with root package name */
    public static final MediaLogger f523h = MediaLogger.getLogger(i.class);

    /* renamed from: a reason: collision with root package name */
    public a f524a;

    /* renamed from: b reason: collision with root package name */
    public int f525b;

    /* renamed from: c reason: collision with root package name */
    public int f526c;

    /* renamed from: d reason: collision with root package name */
    public int f527d;

    /* renamed from: e reason: collision with root package name */
    public int f528e;

    /* renamed from: f reason: collision with root package name */
    public FrameLayout f529f;

    /* renamed from: g reason: collision with root package name */
    public ArrayList<a.a.a.a.e.a.h.a> f530g = new ArrayList<>();

    public DashBoardImage a(double d2, int i2, int i3) {
        StringBuilder sb;
        MediaLogger mediaLogger;
        String str;
        boolean z;
        a aVar = this.f524a;
        if (aVar == null || aVar.getViewDecorationList().isEmpty()) {
            return null;
        }
        if (this.f525b <= 0 || this.f528e <= 0) {
            this.f525b = i2;
            this.f526c = i3;
        }
        if (this.f527d <= 0 || this.f528e <= 0) {
            int[] a2 = a(a(this.f525b, this.f526c));
            this.f527d = a2[0];
            this.f528e = a2[1];
        }
        if (this.f529f == null) {
            FrameLayout frameLayout = new FrameLayout(MediaModule.getApplication());
            this.f529f = frameLayout;
            frameLayout.setLayoutParams(new LayoutParams(this.f525b, this.f526c));
            Iterator it = this.f530g.iterator();
            while (it.hasNext()) {
                a.a.a.a.e.a.h.a aVar2 = (a.a.a.a.e.a.h.a) it.next();
                aVar2.a(this.f529f);
                aVar2.a(new LayoutParams(this.f525b, this.f526c, 17), new int[]{this.f527d, this.f528e});
            }
        }
        this.f529f.measure(MeasureSpec.makeMeasureSpec(this.f525b, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH), MeasureSpec.makeMeasureSpec(this.f526c, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH));
        this.f529f.layout(0, 0, this.f525b, this.f526c);
        String str2 = "at: ";
        if (this.f529f.getChildCount() == 0) {
            mediaLogger = f523h;
            sb = new StringBuilder();
            sb.append(str2);
            sb.append(d2);
            str = ", ExtraViewContainer has no child! return null!";
        } else {
            Iterator it2 = this.f530g.iterator();
            String str3 = "";
            loop1:
            while (true) {
                z = false;
                while (true) {
                    if (!it2.hasNext()) {
                        break loop1;
                    }
                    a.a.a.a.e.a.h.a aVar3 = (a.a.a.a.e.a.h.a) it2.next();
                    boolean a3 = aVar3.a(d2, false);
                    if (a3) {
                        StringBuilder a4 = e.a.a.a.a.a(str3);
                        a4.append(aVar3.getClass().getSimpleName());
                        str3 = a4.toString();
                    }
                    if (z || a3) {
                        z = true;
                    }
                }
            }
            mediaLogger = f523h;
            sb = new StringBuilder();
            sb.append(str2);
            sb.append(d2);
            if (!z) {
                str = ", there isn't any view has data! return null!";
            } else {
                sb.append(", ");
                sb.append(str3);
                sb.append(" has data!");
                mediaLogger.d(sb.toString());
                this.f529f.measure(MeasureSpec.makeMeasureSpec(this.f525b, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH), MeasureSpec.makeMeasureSpec(this.f526c, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH));
                this.f529f.layout(0, 0, this.f525b, this.f526c);
                Bitmap createBitmap = Bitmap.createBitmap(this.f525b, this.f526c, Config.ARGB_8888);
                this.f529f.draw(new Canvas(createBitmap));
                ByteBuffer allocate = ByteBuffer.allocate(createBitmap.getByteCount());
                createBitmap.copyPixelsToBuffer(allocate);
                if (!createBitmap.isRecycled()) {
                    createBitmap.recycle();
                }
                DashBoardImage dashBoardImage = new DashBoardImage();
                dashBoardImage.setWidth(this.f525b);
                dashBoardImage.setHeight(this.f526c);
                dashBoardImage.setData(allocate.array());
                return dashBoardImage;
            }
        }
        sb.append(str);
        mediaLogger.w(sb.toString());
        return null;
    }

    public void a() {
        if (this.f524a != null) {
            Iterator it = this.f530g.iterator();
            while (it.hasNext()) {
                ((a.a.a.a.e.a.h.a) it.next()).a();
            }
        }
        FrameLayout frameLayout = this.f529f;
        if (frameLayout != null) {
            ((ViewGroup) frameLayout.getParent()).removeView(this.f529f);
            this.f529f = null;
        }
    }

    public void a(double d2, boolean z) {
        if (this.f524a != null) {
            Iterator it = this.f530g.iterator();
            while (it.hasNext()) {
                ((a.a.a.a.e.a.h.a) it.next()).a(d2, z);
            }
        }
    }

    public void a(d dVar, a.a.a.a.e.a.g.d dVar2, boolean z) {
        this.f530g.clear();
        a aVar = this.f524a;
        if (aVar != null) {
            for (b b2 : aVar.getViewDecorationList()) {
                a.a.a.a.e.a.h.a b3 = b2.b();
                b3.a(dVar, dVar2, z);
                this.f530g.add(b3);
            }
        }
    }

    public void a(LayoutParams layoutParams) {
        if (this.f524a != null) {
            int[] a2 = a(a(layoutParams.width, layoutParams.height));
            Iterator it = this.f530g.iterator();
            while (it.hasNext()) {
                ((a.a.a.a.e.a.h.a) it.next()).a(new LayoutParams(layoutParams), a2);
            }
        }
    }

    public void a(FrameLayout frameLayout) {
        FrameLayout frameLayout2 = new FrameLayout(frameLayout.getContext());
        this.f529f = frameLayout2;
        frameLayout2.setLayoutParams(new LayoutParams(-1, -1, 17));
        frameLayout.addView(this.f529f);
        if (this.f524a != null) {
            Iterator it = this.f530g.iterator();
            while (it.hasNext()) {
                ((a.a.a.a.e.a.h.a) it.next()).a(this.f529f);
            }
        }
    }

    public final int[] a(int i2, int i3) {
        int[] a2 = a.a.a.a.e.a.l.d.a(this.f524a.getScreenRatio(), this.f524a.isRotateScreenRatioEnabled() && a.a.a.a.e.a.l.d.a(this.f524a.isRotateEnabled(), this.f524a.getRotateDegree()));
        if (a2[0] > 0 && a2[1] > 0) {
            return a2;
        }
        return new int[]{i2, i3};
    }

    public final int[] a(int[] iArr) {
        int[] iArr2 = new int[2];
        if (iArr != null && iArr.length >= 2) {
            if (Math.abs(((((float) iArr[1]) * 1.0f) / ((float) iArr[0])) - 2.35f) < 0.001f) {
                iArr2[0] = 544;
                iArr2[1] = 1280;
            } else if (iArr[0] * 16 == iArr[1] * 9) {
                iArr2[0] = 1080;
                iArr2[1] = 1920;
            } else if (iArr[0] * 4 == iArr[1] * 3) {
                iArr2[0] = 1080;
                iArr2[1] = 1440;
            } else if (iArr[0] == iArr[1]) {
                iArr2[0] = 1080;
                iArr2[1] = 1080;
            } else if (iArr[0] * 3 == iArr[1] * 4) {
                iArr2[0] = 1440;
                iArr2[1] = 1080;
            } else if (iArr[0] * 9 == iArr[1] * 16) {
                iArr2[0] = 1920;
                iArr2[1] = 1080;
            } else if (Math.abs(((((float) iArr[0]) * 1.0f) / ((float) iArr[1])) - 2.35f) < 0.001f) {
                iArr2[0] = 1280;
                iArr2[1] = 544;
            } else {
                MediaLogger mediaLogger = f523h;
                StringBuilder a2 = e.a.a.a.a.a("don't support this screen ratio!!! ratio = ");
                a2.append(iArr[0]);
                a2.append(" : ");
                a2.append(iArr[1]);
                mediaLogger.e(a2.toString());
                iArr2[1] = 1080;
                iArr2[0] = (((iArr2[1] * iArr[0]) / iArr[1]) / 8) * 8;
            }
        }
        return iArr2;
    }
}
