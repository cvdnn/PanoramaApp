package e.d.a.n.m;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

/* compiled from: ParcelFileDescriptorRewinder */
public final class m implements e<ParcelFileDescriptor> {

    /* renamed from: a reason: collision with root package name */
    public final b f7262a;

    /* compiled from: ParcelFileDescriptorRewinder */
    public static final class a implements e.d.a.n.m.e.a<ParcelFileDescriptor> {
        public e a(Object obj) {
            return new m((ParcelFileDescriptor) obj);
        }

        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }
    }

    /* compiled from: ParcelFileDescriptorRewinder */
    public static final class b {

        /* renamed from: a reason: collision with root package name */
        public final ParcelFileDescriptor f7263a;

        public b(ParcelFileDescriptor parcelFileDescriptor) {
            this.f7263a = parcelFileDescriptor;
        }
    }

    public m(ParcelFileDescriptor parcelFileDescriptor) {
        this.f7262a = new b(parcelFileDescriptor);
    }

    public void b() {
    }

    public ParcelFileDescriptor a() throws IOException {
        b bVar = this.f7262a;
        if (bVar != null) {
            try {
                Os.lseek(bVar.f7263a.getFileDescriptor(), 0, OsConstants.SEEK_SET);
                return bVar.f7263a;
            } catch (ErrnoException e2) {
                throw new IOException(e2);
            }
        } else {
            throw null;
        }
    }
}
