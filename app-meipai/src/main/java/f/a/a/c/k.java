package f.a.a.c;

import android.media.MediaExtractor;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.LinkedList;

/* compiled from: RemoteMediaExtractor */
public class k extends d {

    /* renamed from: i reason: collision with root package name */
    public boolean f9070i;

    /* renamed from: j reason: collision with root package name */
    public Thread f9071j;
    public b k;

    /* compiled from: RemoteMediaExtractor */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            while (true) {
                k kVar = k.this;
                if (kVar.f9070i) {
                    int sampleTrackIndex = kVar.f9021b.getSampleTrackIndex();
                    if (sampleTrackIndex < 0) {
                        e.a.a.a.a.c("extractor eos trackIndex ", sampleTrackIndex, k.this.f9020a);
                        k.this.c();
                    } else {
                        k kVar2 = k.this;
                        if (sampleTrackIndex == kVar2.f9026g) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(kVar2.f9027h);
                            allocateDirect.clear();
                            allocateDirect.clear();
                            boolean z = false;
                            int readSampleData = k.this.f9021b.readSampleData(allocateDirect, 0);
                            if ((k.this.f9021b.getSampleFlags() & 1) != 0) {
                                z = true;
                            }
                            long sampleTime = k.this.f9021b.getSampleTime();
                            if (sampleTime < 0) {
                                String str = k.this.f9020a;
                                StringBuilder sb = new StringBuilder();
                                sb.append("eof timeUs ");
                                sb.append(sampleTime);
                                Log.e(str, sb.toString());
                                k.this.c();
                            } else {
                                k kVar3 = k.this;
                                if (sampleTime > kVar3.f9024e) {
                                    String str2 = kVar3.f9020a;
                                    StringBuilder a2 = e.a.a.a.a.a(" reach end ", sampleTime, " mEndTimeUs ");
                                    a2.append(k.this.f9024e);
                                    Log.i(str2, a2.toString());
                                    if (!k.this.f9021b.advance()) {
                                        Log.e(k.this.f9020a, " exceed end eof?");
                                    }
                                    k.this.c();
                                } else {
                                    synchronized (kVar3.k) {
                                        ByteBuffer a3 = k.this.k.a(allocateDirect);
                                        if (a3 == null) {
                                            k.this.k.b();
                                            a3 = k.this.k.a(allocateDirect);
                                            if (a3 == null) {
                                                Log.e(k.this.f9020a, "alloc fail again for notified by stop ?");
                                            }
                                        }
                                        q qVar = new q();
                                        qVar.f9118b = z;
                                        qVar.f9120d = a3;
                                        qVar.f9119c = sampleTime;
                                        qVar.f9117a = readSampleData;
                                        k.this.k.a(qVar);
                                        k.this.k.a();
                                        k.this.a(z, readSampleData);
                                        if (!k.this.f9021b.advance()) {
                                            k.this.c();
                                        }
                                    }
                                }
                            }
                        } else {
                            String str3 = kVar2.f9020a;
                            StringBuilder a4 = e.a.a.a.a.a("extractor index mismatch(", sampleTrackIndex, " != ");
                            a4.append(k.this.f9026g);
                            a4.append(")");
                            Log.e(str3, a4.toString());
                        }
                    }
                } else {
                    Log.i(kVar.f9020a, "extractor exit");
                    return;
                }
            }
            while (true) {
            }
        }
    }

    /* compiled from: RemoteMediaExtractor */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public final String f9073a;

        /* renamed from: b reason: collision with root package name */
        public int f9074b;

        /* renamed from: c reason: collision with root package name */
        public LinkedList<q> f9075c = new LinkedList<>();

        /* renamed from: d reason: collision with root package name */
        public boolean f9076d;

        /* renamed from: e reason: collision with root package name */
        public int f9077e;

        /* renamed from: f reason: collision with root package name */
        public boolean f9078f;

        /* renamed from: g reason: collision with root package name */
        public int f9079g;

        public b(String str, int i2, int i3, int i4) {
            this.f9073a = str;
            this.f9077e = i2;
            this.f9079g = i4;
            this.f9074b = i4;
        }

        public void a(q qVar) {
            String str = ")";
            if (qVar.f9120d.remaining() != qVar.f9117a) {
                String str2 = this.f9073a;
                StringBuilder a2 = e.a.a.a.a.a(" add mismatch (");
                a2.append(qVar.f9120d.remaining());
                a2.append(" != ");
                a2.append(qVar.f9117a);
                a2.append(str);
                Log.e(str2, a2.toString());
            }
            this.f9075c.add(qVar);
            if (this.f9075c.size() > this.f9079g) {
                String str3 = this.f9073a;
                StringBuilder a3 = e.a.a.a.a.a(" packet size exceed (");
                a3.append(this.f9075c.size());
                a3.append(" > ");
                a3.append(this.f9079g);
                a3.append(str);
                Log.e(str3, a3.toString());
            }
        }

        public q b(ByteBuffer byteBuffer) {
            if (this.f9075c.size() <= 0) {
                return null;
            }
            q qVar = (q) this.f9075c.removeFirst();
            int remaining = qVar.f9120d.remaining();
            if (remaining != qVar.f9117a) {
                String str = this.f9073a;
                StringBuilder a2 = e.a.a.a.a.a(" pop mismatch (", remaining, " != ");
                a2.append(qVar.f9117a);
                a2.append(")");
                Log.e(str, a2.toString());
            }
            byteBuffer.clear();
            byteBuffer.put(qVar.f9120d);
            byteBuffer.flip();
            qVar.f9120d = byteBuffer;
            this.f9074b += remaining;
            return qVar;
        }

        public ByteBuffer a(ByteBuffer byteBuffer) {
            if (this.f9074b >= this.f9077e) {
                ByteBuffer order = ByteBuffer.allocate(byteBuffer.limit()).order(byteBuffer.order());
                order.clear();
                order.put(byteBuffer);
                order.flip();
                this.f9074b -= order.capacity();
                return order;
            }
            String str = this.f9073a;
            StringBuilder a2 = e.a.a.a.a.a("alloc fail:( ");
            a2.append(this.f9074b);
            a2.append("< ");
            a2.append(this.f9077e);
            a2.append(")  size ");
            a2.append(this.f9075c.size());
            a2.append(" capacity ");
            e.a.a.a.a.b(a2, this.f9079g, str);
            return null;
        }

        public void b() {
            if (!this.f9076d) {
                this.f9076d = true;
                try {
                    super.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            } else {
                Log.e(this.f9073a, "wait again ?? deadlock happen");
            }
        }

        public void a() {
            if (this.f9076d) {
                super.notify();
                this.f9076d = false;
            }
        }
    }

    public k(MediaExtractor mediaExtractor, int i2, String str, int i3) {
        super(mediaExtractor, i2, str, i3);
        this.k = new b(str, i3, 0, 20971520);
    }

    public void a() {
        this.f9070i = true;
        Thread thread = new Thread(new a());
        this.f9071j = thread;
        thread.start();
    }

    public void b() {
        String str = this.f9020a;
        StringBuilder a2 = e.a.a.a.a.a(" stop mStart ");
        a2.append(this.f9070i);
        Log.i(str, a2.toString());
        if (this.f9070i) {
            this.f9070i = false;
            synchronized (this.k) {
                this.k.notifyAll();
            }
            try {
                this.f9071j.join();
                this.f9071j = null;
            } catch (InterruptedException e2) {
                Log.e(this.f9020a, " mThread stop exception ");
                e2.printStackTrace();
            }
            this.f9021b = null;
            return;
        }
        Log.e(this.f9020a, "stop when mStart false?");
    }

    public final void c() {
        synchronized (this.k) {
            this.k.f9078f = true;
            this.k.a();
            Log.i(this.f9020a, " mCacheManager.wait() eof");
            this.k.b();
        }
    }

    public q a(ByteBuffer byteBuffer) {
        q b2;
        synchronized (this.k) {
            b2 = this.k.b(byteBuffer);
            if (b2 != null) {
                b bVar = this.k;
                if ((bVar.f9074b >= bVar.f9077e) && !this.k.f9078f) {
                    this.k.a();
                }
            } else if (!this.k.f9078f) {
                if (!this.f9025f) {
                    Log.e(this.f9020a, " packet null when first packet not extract to wait");
                }
                this.k.b();
                b2 = this.k.b(byteBuffer);
                if (b2 == null && !this.k.f9078f) {
                    Log.e(this.f9020a, " packet null but not eof ");
                }
            }
        }
        return b2;
    }
}
