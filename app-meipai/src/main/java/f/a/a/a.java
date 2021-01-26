package f.a.a;

import android.util.Log;
import com.arashivision.onecamera.OneCameraImplement;
import f.a.a.c.i;
import f.a.a.c.o;

/* compiled from: AudioPtsRebuild */
public class a extends i {
    public int k = 1024;
    public int l = OneCameraImplement.AUDIO_SAMPLE_RATE_DEF;

    public a(o oVar) {
        super(oVar, "AudioPtsRebuild");
        b();
    }

    public boolean a(long j2) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f9051j.size()) {
                break;
            }
            f.a.a.c.o.a aVar = (f.a.a.c.o.a) this.f9051j.get(i2);
            if (!(j2 == aVar.f9109c && i2 != this.f9051j.size() - 1 && j2 == ((f.a.a.c.o.a) this.f9051j.get(i2 + 1)).f9108b) && j2 >= aVar.f9108b && j2 <= aVar.f9109c) {
                String str = " mFrameCount ";
                String str2 = "AudioPtsRebuild";
                if (this.f9048g != i2) {
                    StringBuilder a2 = e.a.a.a.a.a(" mCurrentRangeId ");
                    a2.append(this.f9048g);
                    a2.append(" i ");
                    a2.append(i2);
                    Log.i(str2, a2.toString());
                    this.f9044c = j2;
                    this.f9043b++;
                    this.f9046e = j2;
                    this.f9047f = j2;
                    this.f9048g = i2;
                    this.f9043b = 0;
                    if (this.f9042a) {
                        StringBuilder a3 = e.a.a.a.a.a("a audiopts speed:", j2, str);
                        a3.append(this.f9043b);
                        Log.i(str2, a3.toString());
                        StringBuilder sb = new StringBuilder();
                        sb.append(" rangeBeginMs_ ");
                        sb.append(this.f9046e);
                        Log.i(str2, sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(" rangeRawBeginMs_ ");
                        sb2.append(this.f9046e);
                        Log.i(str2, sb2.toString());
                    }
                } else {
                    double d2 = aVar.f9107a;
                    int i3 = (d2 > 1.0d ? 1 : (d2 == 1.0d ? 0 : -1));
                    if (i3 == 0) {
                        if (this.f9042a) {
                            StringBuilder a4 = e.a.a.a.a.a("b audiopts speed:", j2, str);
                            a4.append(this.f9043b);
                            Log.i(str2, a4.toString());
                        }
                    } else if (d2 < 1.0d) {
                        if (((int) ((((((double) (j2 - this.f9047f)) * aVar.f9107a) - a()) / this.f9045d) + 0.3d)) >= 1) {
                            this.f9043b++;
                            if (this.f9042a) {
                                StringBuilder a5 = e.a.a.a.a.a("c audiopts speed:", j2, str);
                                a5.append(this.f9043b);
                                Log.i(str2, a5.toString());
                            }
                        } else if (!this.f9042a) {
                            return false;
                        } else {
                            StringBuilder a6 = e.a.a.a.a.a("audiopts discard:", j2, str);
                            a6.append(this.f9043b);
                            Log.i(str2, a6.toString());
                            return false;
                        }
                    } else if (i3 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(" bad frameScale ");
                        sb3.append(d2);
                        throw new IllegalArgumentException(sb3.toString());
                    }
                }
            }
            i2++;
        }
        return true;
    }
}
