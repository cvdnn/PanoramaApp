package e.e.a.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import e.e.a.d.m;
import e.e.a.f.BleException;

import java.util.Queue;

/* compiled from: SplitWriter */
public class d {

    /* renamed from: a reason: collision with root package name */
    public HandlerThread f7969a;

    /* renamed from: b reason: collision with root package name */
    public Handler f7970b = new a(this.f7969a.getLooper());

    /* renamed from: c reason: collision with root package name */
    public a f7971c;

    /* renamed from: d reason: collision with root package name */
    public String f7972d;

    /* renamed from: e reason: collision with root package name */
    public String f7973e;

    /* renamed from: f reason: collision with root package name */
    public byte[] f7974f;

    /* renamed from: g reason: collision with root package name */
    public int f7975g;

    /* renamed from: h reason: collision with root package name */
    public boolean f7976h;

    /* renamed from: i reason: collision with root package name */
    public long f7977i;

    /* renamed from: j reason: collision with root package name */
    public m f7978j;
    public Queue<byte[]> k;
    public int l;

    /* compiled from: SplitWriter */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 51) {
                d.this.a();
            }
        }
    }

    /* compiled from: SplitWriter */
    public class b extends m {
        public b() {
        }

        public void onWriteFailure(BleException aVar) {
            m mVar = d.this.f7978j;
            if (mVar != null) {
                StringBuilder a2 = e.a.a.a.a.a("exception occur while writing: ");
                a2.append(aVar.f7991b);
                mVar.onWriteFailure(new e.e.a.f.d(a2.toString()));
            }
            d dVar = d.this;
            if (dVar.f7976h) {
                Message obtainMessage = dVar.f7970b.obtainMessage(51);
                d dVar2 = d.this;
                dVar2.f7970b.sendMessageDelayed(obtainMessage, dVar2.f7977i);
            }
        }

        public void onWriteSuccess(int i2, int i3, byte[] bArr) {
            d dVar = d.this;
            int size = dVar.l - dVar.k.size();
            d dVar2 = d.this;
            m mVar = dVar2.f7978j;
            if (mVar != null) {
                mVar.onWriteSuccess(size, dVar2.l, bArr);
            }
            d dVar3 = d.this;
            if (dVar3.f7976h) {
                Message obtainMessage = dVar3.f7970b.obtainMessage(51);
                d dVar4 = d.this;
                dVar4.f7970b.sendMessageDelayed(obtainMessage, dVar4.f7977i);
            }
        }
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("splitWriter");
        this.f7969a = handlerThread;
        handlerThread.start();
    }

    public final void a() {
        if (this.k.peek() == null) {
            this.f7969a.quit();
            this.f7970b.removeCallbacksAndMessages(null);
            return;
        }
        byte[] bArr = (byte[]) this.k.poll();
        a aVar = this.f7971c;
        if (aVar != null) {
            b bVar = new b(aVar);
            bVar.a(this.f7972d, this.f7973e);
            bVar.a(bArr, new b(), this.f7973e);
            if (!this.f7976h) {
                this.f7970b.sendMessageDelayed(this.f7970b.obtainMessage(51), this.f7977i);
            }
            return;
        }
        throw null;
    }
}
