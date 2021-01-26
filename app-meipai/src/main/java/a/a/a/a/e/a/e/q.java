package a.a.a.a.e.a.e;

import a.a.a.a.e.a.e.k.h;
import a.a.a.a.e.a.i.g;
import a.a.a.a.e.a.l.e;
import com.arashivision.arvbmg.exporter.OneTrimExport;
import com.arashivision.arvbmg.transcode.BMGMediaTranscode;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.util.MD5Util;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class q {

    /* renamed from: d reason: collision with root package name */
    public static final MediaLogger f565d = MediaLogger.getLogger(q.class);

    /* renamed from: a reason: collision with root package name */
    public h f566a;

    /* renamed from: b reason: collision with root package name */
    public b f567b;

    /* renamed from: c reason: collision with root package name */
    public o f568c = new o();

    public class a implements e {
        public double a(Object obj) {
            return ((f.a.a.c.o.a) obj).f9107a;
        }

        public Object a(double d2, double d3, double d4, Boolean bool, Double d5) {
            f.a.a.c.o.a aVar = new f.a.a.c.o.a((long) d2, (long) d3, d4);
            return aVar;
        }

        public double b(Object obj) {
            return (double) ((f.a.a.c.o.a) obj).f9109c;
        }

        public double c(Object obj) {
            return (double) ((f.a.a.c.o.a) obj).f9108b;
        }

        public double d(Object obj) {
            return 0.0d;
        }
    }

    public interface b {
    }

    public final String a(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f566a.getUrlsForPlay()[i2]);
        sb.append(this.f566a.getTrimStart());
        sb.append(this.f566a.getTrimEnd());
        List speedSectionList = this.f566a.getSpeedSectionList();
        for (int i3 = 0; i3 < speedSectionList.size(); i3++) {
            g gVar = (g) speedSectionList.get(i3);
            if (gVar.f612c > 1.0d) {
                sb.append(gVar.f610a);
                sb.append(gVar.f611b);
                sb.append(gVar.f612c);
            }
        }
        return MD5Util.getMD5String(sb.toString());
    }

    public final f.a.a.c.o.a[] a(List<g> list) {
        ArrayList arrayList = (ArrayList) a.a.a.a.b.a.a(this.f566a.getTrimEnd() * 1000.0d, list, this.f566a.getSpeedFactor(), this.f566a.getTrimStart() * 1000.0d, this.f566a.getTrimEnd() * 1000.0d, true, (e) new a());
        f.a.a.c.o.a[] aVarArr = new f.a.a.c.o.a[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            aVarArr[i2] = (f.a.a.c.o.a) arrayList.get(i2);
        }
        return aVarArr;
    }

    public String[] a() {
        h hVar = this.f566a;
        if (hVar == null) {
            return new String[0];
        }
        int length = hVar.getUrlsForPlay().length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String cacheVideoProxyRootPath = this.f566a.getCacheVideoProxyRootPath();
            StringBuilder sb = new StringBuilder();
            sb.append(a(i2));
            sb.append(".mp4");
            strArr[i2] = new File(cacheVideoProxyRootPath, sb.toString()).getAbsolutePath();
        }
        return strArr;
    }

    public void b() {
        o oVar = this.f568c;
        OneTrimExport oneTrimExport = oVar.f542b;
        if (oneTrimExport != null) {
            oneTrimExport.cancel();
        }
        BMGMediaTranscode bMGMediaTranscode = oVar.f541a;
        if (bMGMediaTranscode != null) {
            bMGMediaTranscode.cancel(oVar.f546f);
        }
    }

    public int c() {
        h hVar = this.f566a;
        if (hVar == null || Math.round(hVar.getFps()) % 30 == 0) {
            return 30;
        }
        if (Math.round(this.f566a.getFps()) % 25 == 0) {
            return 25;
        }
        MediaLogger mediaLogger = f565d;
        StringBuilder a2 = e.a.a.a.a.a("source fps is ");
        a2.append(this.f566a.getFps());
        a2.append(", not 30x or 25x, force proxy fps to 30");
        mediaLogger.e(a2.toString());
        return 30;
    }

    public final boolean d() {
        h hVar = this.f566a;
        boolean z = false;
        if (hVar == null) {
            f565d.e("do not generate proxy (params null)");
            return false;
        } else if (hVar.isMJpeg() || !this.f566a.isVideo()) {
            f565d.d("do not generate proxy (mjpeg detected)");
            return false;
        } else if (this.f566a.getTrimEnd() - this.f566a.getTrimStart() <= 30000.0d) {
            f.a.a.c.o.a[] a2 = a(a(false));
            String str = "do not generate proxy (no speed section detected)";
            if (a2.length == 0) {
                f565d.d(str);
                return false;
            }
            f.a.a.c.o.a aVar = null;
            for (int i2 = 0; i2 < a2.length; i2++) {
                if (i2 == 0) {
                    aVar = a2[0];
                } else if (aVar.f9107a > a2[i2].f9107a) {
                    aVar = a2[i2];
                }
            }
            if (aVar == null) {
                f565d.d(str);
                return false;
            }
            if (this.f566a.getFps() * (1.0d / aVar.f9107a) > 60.0d) {
                z = true;
            }
            return z;
        } else {
            f565d.d("do not generate proxy (clip trim range > 30s)");
            return false;
        }
    }

    public final List<g> a(boolean z) {
        List speedSectionList = this.f566a.getSpeedSectionList();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < speedSectionList.size(); i2++) {
            g gVar = (g) speedSectionList.get(i2);
            g gVar2 = new g();
            double d2 = gVar.f610a * 1000.0d;
            gVar2.f610a = d2;
            if (gVar2.f612c != 0.0d) {
                Math.abs(d2 - gVar2.f611b);
            }
            double d3 = gVar.f611b * 1000.0d;
            gVar2.f611b = d3;
            if (gVar2.f612c != 0.0d) {
                Math.abs(gVar2.f610a - d3);
            }
            if (z) {
                double d4 = gVar.f612c;
                if (d4 <= 1.0d) {
                    d4 = 1.0d;
                }
                gVar2.f612c = d4;
            } else {
                gVar2.f612c = gVar.f612c;
            }
            arrayList.add(gVar2);
        }
        return arrayList;
    }
}
