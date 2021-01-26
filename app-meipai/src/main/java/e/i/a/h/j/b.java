package e.i.a.h.j;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import e.i.a.h.j.a.C0126a;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* compiled from: DownloadUriOutputStream */
public class b implements a {

    /* renamed from: a reason: collision with root package name */
    public final FileChannel f8857a;

    /* renamed from: b reason: collision with root package name */
    public final ParcelFileDescriptor f8858b;

    /* renamed from: c reason: collision with root package name */
    public final BufferedOutputStream f8859c;

    /* renamed from: d reason: collision with root package name */
    public final FileOutputStream f8860d;

    /* compiled from: DownloadUriOutputStream */
    public static class a implements C0126a {
    }

    public b(Context context, Uri uri, int i2) throws FileNotFoundException {
        ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
        if (openFileDescriptor != null) {
            this.f8858b = openFileDescriptor;
            FileOutputStream fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
            this.f8860d = fileOutputStream;
            this.f8857a = fileOutputStream.getChannel();
            this.f8859c = new BufferedOutputStream(this.f8860d, i2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("result of ");
        sb.append(uri);
        sb.append(" is null!");
        throw new FileNotFoundException(sb.toString());
    }

    public void a() throws IOException {
        this.f8859c.flush();
        this.f8858b.getFileDescriptor().sync();
    }

    public void b(long j2) throws IOException {
        this.f8857a.position(j2);
    }

    public void close() throws IOException {
        this.f8859c.close();
        this.f8860d.close();
        this.f8858b.close();
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.f8859c.write(bArr, i2, i3);
    }

    public void a(long j2) {
        String str;
        String str2;
        String str3;
        String str4;
        try {
            Os.posix_fallocate(this.f8858b.getFileDescriptor(), 0, j2);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(j2);
            sb.append(str3);
            sb.append(str2);
            sb.append(VERSION.SDK_INT);
            sb.append(str);
            sb.append(th);
            sb.toString();
        }
    }
}
