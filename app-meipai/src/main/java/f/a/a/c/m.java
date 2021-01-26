package f.a.a.c;

import android.media.MediaFormat;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: TrackTranscoder */
public abstract class m {

    /* renamed from: a reason: collision with root package name */
    public long f9090a = 0;

    /* renamed from: b reason: collision with root package name */
    public long f9091b = RecyclerView.FOREVER_NS;

    /* renamed from: c reason: collision with root package name */
    public i f9092c;

    /* renamed from: d reason: collision with root package name */
    public boolean f9093d;

    /* renamed from: e reason: collision with root package name */
    public boolean f9094e;

    /* renamed from: f reason: collision with root package name */
    public boolean f9095f;

    /* renamed from: g reason: collision with root package name */
    public long f9096g;

    public abstract MediaFormat a();

    public boolean a(long j2) {
        if (j2 >= this.f9090a) {
            i iVar = this.f9092c;
            if (iVar == null || iVar.a(j2)) {
                return true;
            }
        }
        return false;
    }

    public abstract void b();

    public abstract boolean b(long j2);

    public abstract void c();
}
