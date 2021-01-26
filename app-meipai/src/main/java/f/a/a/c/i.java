package f.a.a.c;

import android.util.Log;
import com.arashivision.onecamera.OneCameraImplement;
import f.a.a.c.o.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: PtsRebuild */
public abstract class i {

    /* renamed from: a reason: collision with root package name */
    public boolean f9042a;

    /* renamed from: b reason: collision with root package name */
    public long f9043b;

    /* renamed from: c reason: collision with root package name */
    public long f9044c;

    /* renamed from: d reason: collision with root package name */
    public double f9045d;

    /* renamed from: e reason: collision with root package name */
    public long f9046e;

    /* renamed from: f reason: collision with root package name */
    public long f9047f;

    /* renamed from: g reason: collision with root package name */
    public int f9048g = -1;

    /* renamed from: h reason: collision with root package name */
    public double f9049h = ((double) (OneCameraImplement.AUDIO_SAMPLE_RATE_DEF / 1024));

    /* renamed from: i reason: collision with root package name */
    public String f9050i;

    /* renamed from: j reason: collision with root package name */
    public List<a> f9051j;

    public i(o oVar, String str) {
        String str2;
        o oVar2 = oVar;
        if (oVar2.p == null) {
            oVar2.p = new ArrayList();
            long j2 = oVar2.f9100d;
            long j3 = oVar2.f9099c;
            if (j2 > j3) {
                a[] aVarArr = oVar2.f9101e;
                String str3 = "] ";
                String str4 = "TranscodeInfo";
                if (aVarArr != null) {
                    Arrays.sort(aVarArr, new n(oVar2));
                    a aVar = aVarArr[0];
                    long j4 = aVar.f9108b;
                    if (j4 > j3) {
                        List<a> list = oVar2.p;
                        a aVar2 = r8;
                        a aVar3 = new a(j3, j4, 1.0d);
                        list.add(aVar2);
                    }
                    String str5 = " to 1.0";
                    if (aVar.f9107a > 1.0d) {
                        StringBuilder a2 = e.a.a.a.a.a("force bad timescale factor[0] ");
                        a2.append(aVar.f9107a);
                        a2.append(str5);
                        Log.e(str4, a2.toString());
                    }
                    oVar2.p.add(aVar);
                    int i2 = 1;
                    while (i2 < aVarArr.length) {
                        a aVar4 = aVarArr[i2];
                        long j5 = aVar.f9109c;
                        long j6 = aVar4.f9108b;
                        if (j5 < j6) {
                            List<a> list2 = oVar2.p;
                            a aVar5 = new a(j5, j6, 1.0d);
                            list2.add(aVar5);
                        }
                        if (aVar4.f9107a > 1.0d) {
                            StringBuilder a3 = e.a.a.a.a.a("force bad timescale factor[", i2, str3);
                            a3.append(aVar4.f9107a);
                            a3.append(str5);
                            Log.e(str4, a3.toString());
                            aVar4.f9107a = 1.0d;
                        }
                        oVar2.p.add(aVar4);
                        i2++;
                        aVar = aVar4;
                    }
                    if (aVarArr[aVarArr.length - 1].f9109c < j2) {
                        List<a> list3 = oVar2.p;
                        str2 = str4;
                        a aVar6 = new a(aVarArr[aVarArr.length - 1].f9109c, j2, 1.0d);
                        list3.add(aVar6);
                    } else {
                        str2 = str4;
                    }
                } else {
                    str2 = str4;
                    a aVar7 = new a(j3, j2, 1.0d);
                    oVar2.p.add(aVar7);
                }
                long j7 = oVar2.f9100d - oVar2.f9099c;
                for (int i3 = 0; i3 < oVar2.p.size(); i3++) {
                    a aVar8 = (a) oVar2.p.get(i3);
                    StringBuilder a4 = e.a.a.a.a.a("[", i3, str3);
                    a4.append(aVar8.toString());
                    Log.i(str2, a4.toString());
                }
                oVar2.q = ((((long) oVar2.n) * j7) / 8192000) + ((long) (((((double) oVar2.f9106j) * 1.1d) * ((double) j7)) / 8388608.0d));
                StringBuilder a5 = e.a.a.a.a.a(" mAllTimeScales size ");
                a5.append(oVar2.p.size());
                a5.append(" durationUs ");
                a5.append(j7);
                a5.append(" mEstimateSize ");
                a5.append(oVar2.q);
                Log.i(str2, a5.toString());
            } else {
                StringBuilder a6 = e.a.a.a.a.a("transcode bad time end[ ");
                a6.append(oVar2.f9100d);
                a6.append("] <= [");
                a6.append(oVar2.f9099c);
                a6.append("]");
                throw new IllegalArgumentException(a6.toString());
            }
        }
        List<a> list4 = oVar2.p;
        this.f9051j = list4;
        this.f9050i = str;
    }

    public double a() {
        long j2 = this.f9043b;
        double d2 = (double) j2;
        double d3 = this.f9049h;
        double d4 = (double) (((long) (d2 / d3)) * 1000 * 1000);
        double d5 = (double) ((long) (((double) j2) % d3));
        double d6 = this.f9045d;
        return Math.max((d5 * d6) + d4, ((double) j2) * d6);
    }

    public abstract boolean a(long j2);

    public void b() {
        this.f9045d = 1000000.0d / this.f9049h;
        String str = this.f9050i;
        StringBuilder a2 = e.a.a.a.a.a(" mOutputFps ");
        a2.append(this.f9049h);
        a2.append(" mFrameDurationUs ");
        a2.append(this.f9045d);
        Log.i(str, a2.toString());
    }
}
