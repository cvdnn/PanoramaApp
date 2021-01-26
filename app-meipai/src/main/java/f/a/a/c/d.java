package f.a.a.c;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import e.a.a.a.a;
import java.nio.ByteBuffer;

/* compiled from: BaseMediaExtractor */
public abstract class d {

    /* renamed from: a reason: collision with root package name */
    public final String f9020a;

    /* renamed from: b reason: collision with root package name */
    public MediaExtractor f9021b;

    /* renamed from: c reason: collision with root package name */
    public MediaFormat f9022c;

    /* renamed from: d reason: collision with root package name */
    public long f9023d = 0;

    /* renamed from: e reason: collision with root package name */
    public long f9024e = RecyclerView.FOREVER_NS;

    /* renamed from: f reason: collision with root package name */
    public boolean f9025f;

    /* renamed from: g reason: collision with root package name */
    public final int f9026g;

    /* renamed from: h reason: collision with root package name */
    public final int f9027h;

    public d(MediaExtractor mediaExtractor, int i2, String str, int i3) {
        this.f9020a = str;
        this.f9027h = i3;
        this.f9026g = i2;
        this.f9021b = mediaExtractor;
        mediaExtractor.selectTrack(i2);
        this.f9022c = this.f9021b.getTrackFormat(i2);
        String str2 = this.f9020a;
        StringBuilder a2 = a.a("init mExtractor.getSampleTime() ");
        a2.append(this.f9021b.getSampleTime());
        Log.i(str2, a2.toString());
    }

    public abstract q a(ByteBuffer byteBuffer);

    public abstract void a();

    public void a(long j2, long j3) {
        this.f9023d = j2;
        this.f9024e = j3;
        if (j3 < 0) {
            String str = this.f9020a;
            StringBuilder a2 = a.a(" error trackcode trim end ");
            a2.append(this.f9024e);
            Log.e(str, a2.toString());
        }
        if (this.f9023d < 0) {
            String str2 = this.f9020a;
            StringBuilder a3 = a.a(" error trackcode trim start ");
            a3.append(this.f9023d);
            Log.e(str2, a3.toString());
        }
        if (this.f9024e < this.f9023d) {
            String str3 = this.f9020a;
            StringBuilder a4 = a.a(" error trackcode trim end(");
            a4.append(this.f9024e);
            a4.append(") < (");
            a4.append(this.f9023d);
            a4.append(")");
            Log.e(str3, a4.toString());
        }
    }

    public abstract void b();

    public void a(boolean z, int i2) {
        if (!this.f9025f) {
            this.f9025f = true;
            if (!z) {
                Log.e(this.f9020a, " first not keyframe");
            }
            if (i2 <= 0) {
                String str = this.f9020a;
                StringBuilder sb = new StringBuilder();
                sb.append(" first video sampleSize(");
                sb.append(i2);
                sb.append(") <= 0");
                Log.e(str, sb.toString());
            }
        }
    }
}
