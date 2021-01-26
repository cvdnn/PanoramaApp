package e.d.a.n.p.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import e.c.f.n.n;
import e.d.a.n.m.k;
import e.d.a.n.m.m;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ImageReader */
public interface s {

    /* compiled from: ImageReader */
    public static final class a implements s {

        /* renamed from: a reason: collision with root package name */
        public final k f7716a;

        /* renamed from: b reason: collision with root package name */
        public final e.d.a.n.n.c0.b f7717b;

        /* renamed from: c reason: collision with root package name */
        public final List<ImageHeaderParser> f7718c;

        public a(InputStream inputStream, List<ImageHeaderParser> list, e.d.a.n.n.c0.b bVar) {
            String str = "Argument must not be null";
            n.a(bVar, str);
            this.f7717b = bVar;
            n.a(list, str);
            this.f7718c = list;
            this.f7716a = new k(inputStream, bVar);
        }

        public Bitmap a(Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f7716a.a(), null, options);
        }

        public void b() {
            this.f7716a.f7257a.a();
        }

        public ImageType c() throws IOException {
            return n.b(this.f7718c, this.f7716a.a(), this.f7717b);
        }

        public int a() throws IOException {
            return n.a(this.f7718c, this.f7716a.a(), this.f7717b);
        }
    }

    /* compiled from: ImageReader */
    public static final class b implements s {

        /* renamed from: a reason: collision with root package name */
        public final e.d.a.n.n.c0.b f7719a;

        /* renamed from: b reason: collision with root package name */
        public final List<ImageHeaderParser> f7720b;

        /* renamed from: c reason: collision with root package name */
        public final m f7721c;

        public b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, e.d.a.n.n.c0.b bVar) {
            String str = "Argument must not be null";
            n.a(bVar, str);
            this.f7719a = bVar;
            n.a(list, str);
            this.f7720b = list;
            this.f7721c = new m(parcelFileDescriptor);
        }

        public Bitmap a(Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f7721c.a().getFileDescriptor(), null, options);
        }

        public void b() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003e A[SYNTHETIC, Splitter:B:17:0x003e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.bumptech.glide.load.ImageHeaderParser.ImageType c() throws java.io.IOException {
            /*
                r10 = this;
                java.util.List<com.bumptech.glide.load.ImageHeaderParser> r0 = r10.f7720b
                e.d.a.n.m.m r1 = r10.f7721c
                e.d.a.n.n.c0.b r2 = r10.f7719a
                int r3 = r0.size()
                r4 = 0
            L_0x000b:
                if (r4 >= r3) goto L_0x0045
                java.lang.Object r5 = r0.get(r4)
                com.bumptech.glide.load.ImageHeaderParser r5 = (com.bumptech.glide.load.ImageHeaderParser) r5
                r6 = 0
                e.d.a.n.p.c.w r7 = new e.d.a.n.p.c.w     // Catch:{ all -> 0x003b }
                java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ all -> 0x003b }
                android.os.ParcelFileDescriptor r9 = r1.a()     // Catch:{ all -> 0x003b }
                java.io.FileDescriptor r9 = r9.getFileDescriptor()     // Catch:{ all -> 0x003b }
                r8.<init>(r9)     // Catch:{ all -> 0x003b }
                r7.<init>(r8, r2)     // Catch:{ all -> 0x003b }
                com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = r5.a(r7)     // Catch:{ all -> 0x0038 }
                r7.close()     // Catch:{ IOException -> 0x002d }
            L_0x002d:
                r1.a()
                com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
                if (r5 == r6) goto L_0x0035
                goto L_0x0047
            L_0x0035:
                int r4 = r4 + 1
                goto L_0x000b
            L_0x0038:
                r0 = move-exception
                r6 = r7
                goto L_0x003c
            L_0x003b:
                r0 = move-exception
            L_0x003c:
                if (r6 == 0) goto L_0x0041
                r6.close()     // Catch:{ IOException -> 0x0041 }
            L_0x0041:
                r1.a()
                throw r0
            L_0x0045:
                com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            L_0x0047:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.p.c.s.b.c():com.bumptech.glide.load.ImageHeaderParser$ImageType");
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x003e A[SYNTHETIC, Splitter:B:19:0x003e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a() throws java.io.IOException {
            /*
                r11 = this;
                java.util.List<com.bumptech.glide.load.ImageHeaderParser> r0 = r11.f7720b
                e.d.a.n.m.m r1 = r11.f7721c
                e.d.a.n.n.c0.b r2 = r11.f7719a
                int r3 = r0.size()
                r4 = 0
            L_0x000b:
                r5 = -1
                if (r4 >= r3) goto L_0x0045
                java.lang.Object r6 = r0.get(r4)
                com.bumptech.glide.load.ImageHeaderParser r6 = (com.bumptech.glide.load.ImageHeaderParser) r6
                r7 = 0
                e.d.a.n.p.c.w r8 = new e.d.a.n.p.c.w     // Catch:{ all -> 0x003b }
                java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ all -> 0x003b }
                android.os.ParcelFileDescriptor r10 = r1.a()     // Catch:{ all -> 0x003b }
                java.io.FileDescriptor r10 = r10.getFileDescriptor()     // Catch:{ all -> 0x003b }
                r9.<init>(r10)     // Catch:{ all -> 0x003b }
                r8.<init>(r9, r2)     // Catch:{ all -> 0x003b }
                int r6 = r6.a(r8, r2)     // Catch:{ all -> 0x0038 }
                r8.close()     // Catch:{ IOException -> 0x002e }
            L_0x002e:
                r1.a()
                if (r6 == r5) goto L_0x0035
                r5 = r6
                goto L_0x0045
            L_0x0035:
                int r4 = r4 + 1
                goto L_0x000b
            L_0x0038:
                r0 = move-exception
                r7 = r8
                goto L_0x003c
            L_0x003b:
                r0 = move-exception
            L_0x003c:
                if (r7 == 0) goto L_0x0041
                r7.close()     // Catch:{ IOException -> 0x0041 }
            L_0x0041:
                r1.a()
                throw r0
            L_0x0045:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.p.c.s.b.a():int");
        }
    }

    int a() throws IOException;

    Bitmap a(Options options) throws IOException;

    void b();

    ImageType c() throws IOException;
}
