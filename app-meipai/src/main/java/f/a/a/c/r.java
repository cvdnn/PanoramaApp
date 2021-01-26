package f.a.a.c;

import android.util.Log;
import e.a.a.a.a;

/* compiled from: VideoPtsRebuild */
public class r extends i {
    public double k;

    public r(o oVar) {
        String str = "VideoPtsRebuild";
        super(oVar, str);
        int i2 = (int) ((oVar.f9098b / oVar.f9105i) + 0.5d);
        if (i2 < 1) {
            StringBuilder a2 = a.a(" bad input fps ");
            a2.append(oVar.f9098b);
            a2.append(" output fps ");
            a2.append(oVar.f9105i);
            Log.e(str, a2.toString());
            i2 = 1;
        }
        this.k = (double) i2;
        double d2 = oVar.f9105i;
        this.f9049h = d2;
        this.f9045d = 1000000.0d / d2;
        b();
        this.f9048g = -1;
        StringBuilder a3 = a.a("exporter from fps ");
        a3.append(oVar.f9098b);
        a3.append(" to new fps:");
        a3.append(oVar.f9105i);
        a3.append(" exporterScale ");
        a3.append(this.k);
        a3.append(" mFrameDurationUs ");
        a3.append(this.f9045d);
        Log.i(str, a3.toString());
    }

    public boolean a(long j2) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f9051j.size()) {
                break;
            }
            o.a aVar = (o.a) this.f9051j.get(i2);
            if (!(j2 == aVar.f9109c && i2 != this.f9051j.size() - 1 && j2 == ((o.a) this.f9051j.get(i2 + 1)).f9108b) && j2 >= aVar.f9108b && j2 <= aVar.f9109c) {
                String str = "VideoPtsRebuild";
                if (this.f9048g != i2) {
                    this.f9046e = j2;
                    this.f9047f = j2;
                    this.f9048g = i2;
                    this.f9043b = 0;
                    if (this.f9042a) {
                        StringBuilder a2 = a.a(" mCurrentRangeId ");
                        a2.append(this.f9048g);
                        Log.i(str, a2.toString());
                        StringBuilder sb = new StringBuilder();
                        sb.append(" range start videopts:");
                        sb.append(j2);
                        Log.i(str, sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(" rangeBeginMs_ ");
                        sb2.append(this.f9046e);
                        Log.i(str, sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(" rangeRawBeginMs_ ");
                        sb3.append(this.f9046e);
                        Log.i(str, sb3.toString());
                    }
                } else {
                    double d2 = aVar.f9107a / this.k;
                    int i3 = (d2 > 1.0d ? 1 : (d2 == 1.0d ? 0 : -1));
                    String str2 = "] videopts:";
                    if (i3 == 0) {
                        if (this.f9042a) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("scale[");
                            sb4.append(d2);
                            sb4.append(str2);
                            sb4.append(j2);
                            Log.i(str, sb4.toString());
                        }
                    } else if (d2 < 1.0d) {
                        int a3 = (int) (((((((double) (j2 - this.f9047f)) * aVar.f9107a) - a()) * this.f9049h) / 1000000.0d) + 0.3d);
                        String str3 = " mFrameCount ";
                        String str4 = "range scale[";
                        if (a3 >= 1) {
                            this.f9043b++;
                            if (this.f9042a) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(str4);
                                sb5.append(d2);
                                sb5.append(str2);
                                sb5.append(j2);
                                sb5.append(str3);
                                sb5.append(this.f9043b);
                                Log.i(str, sb5.toString());
                            }
                        } else if (!this.f9042a) {
                            return false;
                        } else {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str4);
                            sb6.append(d2);
                            sb6.append("] videopts discard:");
                            sb6.append(j2);
                            sb6.append(str3);
                            sb6.append(this.f9043b);
                            Log.i(str, sb6.toString());
                            return false;
                        }
                    } else if (i3 > 0) {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(" bad frameScale ");
                        sb7.append(d2);
                        throw new IllegalArgumentException(sb7.toString());
                    }
                }
            }
            i2++;
        }
        return true;
    }
}
