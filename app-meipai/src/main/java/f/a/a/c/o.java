package f.a.a.c;

import java.util.List;

/* compiled from: TranscodeInfo */
public class o {

    /* renamed from: a reason: collision with root package name */
    public String f9097a;

    /* renamed from: b reason: collision with root package name */
    public double f9098b;

    /* renamed from: c reason: collision with root package name */
    public long f9099c;

    /* renamed from: d reason: collision with root package name */
    public long f9100d;

    /* renamed from: e reason: collision with root package name */
    public a[] f9101e;

    /* renamed from: f reason: collision with root package name */
    public String f9102f;

    /* renamed from: g reason: collision with root package name */
    public int f9103g;

    /* renamed from: h reason: collision with root package name */
    public int f9104h;

    /* renamed from: i reason: collision with root package name */
    public double f9105i;

    /* renamed from: j reason: collision with root package name */
    public int f9106j;
    public boolean k;
    public int l;
    public int m;
    public int n = 128000;
    public int o = 1024;
    public List<a> p;
    public long q;
    public int r = 1;
    public boolean s = false;
    public boolean t;
    public boolean u = true;
    public boolean v = true;
    public long w = 41943040;
    public long x = 4194304;
    public int y = 15;

    /* compiled from: TranscodeInfo */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public double f9107a;

        /* renamed from: b reason: collision with root package name */
        public long f9108b;

        /* renamed from: c reason: collision with root package name */
        public long f9109c;

        public a(long j2, long j3, double d2) {
            this.f9108b = j2;
            this.f9109c = j3;
            this.f9107a = d2;
        }

        public String toString() {
            StringBuilder a2 = e.a.a.a.a.a("transcode timeScale(startTimeInSrc=");
            a2.append(this.f9108b);
            a2.append(", endTimeInSrc=");
            a2.append(this.f9109c);
            a2.append(", scale=");
            a2.append(this.f9107a);
            a2.append(")");
            return a2.toString();
        }
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder a2 = e.a.a.a.a.a(" input ");
        a2.append(this.f9097a);
        a2.append(" inputFps ");
        a2.append(this.f9098b);
        a2.append(" output ");
        a2.append(this.f9102f);
        a2.append(" outputFps ");
        a2.append(this.f9105i);
        a2.append(" output width ");
        a2.append(this.f9103g);
        a2.append(" output height ");
        a2.append(this.f9104h);
        a2.append(" startTimeUs ");
        a2.append(this.f9099c);
        a2.append(" endTimeUs ");
        a2.append(this.f9100d);
        a2.append(" noAudio ");
        a2.append(this.k);
        a2.append(" mVideoCache ");
        a2.append(this.u);
        a2.append(" mDecodeExractorrAlternative ");
        boolean z = false;
        a2.append(false);
        a2.append(" audioAdts ");
        a2.append(this.t);
        if (this.l > 0 && this.m > 0 && this.n > 0) {
            z = true;
        }
        if (z) {
            sb = e.a.a.a.a.a(" audioSampleRate ");
            sb.append(this.l);
            sb.append(" audioChannelCount ");
            sb.append(this.m);
            sb.append(" audioBitrate ");
            sb.append(this.l);
        } else {
            sb = e.a.a.a.a.a(" audioCache ");
            sb.append(this.v);
        }
        a2.append(sb.toString());
        return a2.toString();
    }
}
