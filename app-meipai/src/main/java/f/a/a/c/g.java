package f.a.a.c;

import android.media.MediaExtractor;
import android.util.Log;
import e.a.a.a.a;
import java.nio.ByteBuffer;

/* compiled from: LocalVideoExtractor */
public class g extends d {
    public g(MediaExtractor mediaExtractor, int i2, String str, int i3) {
        super(mediaExtractor, i2, str, i3);
    }

    public q a(ByteBuffer byteBuffer) {
        int sampleTrackIndex = this.f9021b.getSampleTrackIndex();
        if (sampleTrackIndex < 0) {
            a.c("extractor eos trackIndex ", sampleTrackIndex, this.f9020a);
        } else {
            byteBuffer.clear();
            boolean z = false;
            int readSampleData = this.f9021b.readSampleData(byteBuffer, 0);
            if ((this.f9021b.getSampleFlags() & 1) != 0) {
                z = true;
            }
            long sampleTime = this.f9021b.getSampleTime();
            if (sampleTime < 0) {
                String str = this.f9020a;
                StringBuilder sb = new StringBuilder();
                sb.append("eof timeUs ");
                sb.append(sampleTime);
                Log.e(str, sb.toString());
            } else if (sampleTime > this.f9024e) {
                String str2 = this.f9020a;
                StringBuilder a2 = a.a(" reach end ", sampleTime, " mEndTimeUs ");
                a2.append(this.f9024e);
                Log.i(str2, a2.toString());
                if (!this.f9021b.advance()) {
                    Log.e(this.f9020a, " exceed end eof?");
                }
            } else {
                q qVar = new q();
                qVar.f9118b = z;
                qVar.f9120d = byteBuffer;
                qVar.f9119c = sampleTime;
                qVar.f9117a = readSampleData;
                a(z, readSampleData);
                if (!this.f9021b.advance()) {
                    Log.e(this.f9020a, "eof?");
                }
                return qVar;
            }
        }
        return null;
    }

    public void a() {
    }

    public void b() {
    }
}
