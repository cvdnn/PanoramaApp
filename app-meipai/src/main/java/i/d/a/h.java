package i.d.a;

import com.baidubce.BceConfig;
import e.c.f.n.n;
import i.d.a.i.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: ZipUtil */
public final class h {

    /* renamed from: a reason: collision with root package name */
    public static final Logger f9895a = LoggerFactory.d().a("org/zeroturnaround/zip/ZipUtil".replace('/', '.'));

    /* compiled from: ZipUtil */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public final File f9896a;

        /* renamed from: b reason: collision with root package name */
        public final c f9897b;

        public a(File file, c cVar) {
            this.f9896a = file;
            this.f9897b = cVar;
        }

        public void a(InputStream inputStream, ZipEntry zipEntry) throws IOException {
            String a2 = this.f9897b.a(zipEntry.getName());
            if (a2 != null) {
                File file = new File(this.f9896a, a2);
                if (a2.indexOf("..") == -1 || file.getCanonicalPath().startsWith(this.f9896a.getCanonicalPath())) {
                    if (zipEntry.isDirectory()) {
                        i.d.a.i.a.a(file);
                    } else {
                        i.d.a.i.a.a(file.getParentFile());
                        if (h.f9895a.a() && file.exists()) {
                            h.f9895a.a("Overwriting file '{}'.", zipEntry.getName());
                        }
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                        try {
                            b.a(inputStream, bufferedOutputStream);
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused) {
                            }
                        } catch (Throwable th) {
                            b.a((OutputStream) bufferedOutputStream);
                            throw th;
                        }
                    }
                    d dVar = null;
                    try {
                        i.d.a.j.a a3 = n.a(i.d.a.j.b.a(zipEntry.getExtra()));
                        if (a3 != null) {
                            dVar = f.a(a3.f9901a & 511);
                        }
                        if (dVar != null) {
                            f.f9894b.a(file, dVar);
                        }
                    } catch (ZipException e2) {
                        throw new g((Exception) e2);
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("The file ");
                    sb.append(a2);
                    sb.append(" is trying to leave the target output directory of ");
                    sb.append(this.f9896a);
                    sb.append(". Ignoring this file.");
                    throw new g(sb.toString());
                }
            }
        }
    }

    public static void a(File file, File file2, c cVar) {
        f9895a.a("Compressing '{}' into '{}'.", file, file2);
        if (file.exists()) {
            ZipOutputStream zipOutputStream = null;
            try {
                ZipOutputStream zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                try {
                    zipOutputStream2.setLevel(-1);
                    a(file, zipOutputStream2, cVar, "", true);
                    b.a((OutputStream) zipOutputStream2);
                } catch (IOException e2) {
                    e = e2;
                    zipOutputStream = zipOutputStream2;
                    try {
                        throw new g((Exception) e);
                    } catch (Throwable th) {
                        th = th;
                        zipOutputStream2 = zipOutputStream;
                        b.a((OutputStream) zipOutputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    b.a((OutputStream) zipOutputStream2);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                throw new g((Exception) e);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Given file '");
            sb.append(file);
            sb.append("' doesn't exist!");
            throw new g(sb.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c A[SYNTHETIC, Splitter:B:33:0x006c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.io.File r5, java.io.File r6, i.d.a.c r7) {
        /*
            org.slf4j.Logger r0 = f9895a
            java.lang.String r1 = "Extracting '{}' into '{}'."
            r0.a(r1, r5, r6)
            i.d.a.h$a r0 = new i.d.a.h$a
            r0.<init>(r6, r7)
            r6 = 0
            java.util.zip.ZipFile r7 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0062 }
            r7.<init>(r5)     // Catch:{ IOException -> 0x0062 }
            java.util.Enumeration r5 = r7.entries()     // Catch:{ IOException -> 0x005d, all -> 0x005b }
        L_0x0016:
            boolean r6 = r5.hasMoreElements()     // Catch:{ IOException -> 0x005d, all -> 0x005b }
            if (r6 == 0) goto L_0x0057
            java.lang.Object r6 = r5.nextElement()     // Catch:{ IOException -> 0x005d, all -> 0x005b }
            java.util.zip.ZipEntry r6 = (java.util.zip.ZipEntry) r6     // Catch:{ IOException -> 0x005d, all -> 0x005b }
            java.io.InputStream r1 = r7.getInputStream(r6)     // Catch:{ IOException -> 0x005d, all -> 0x005b }
            r0.a(r1, r6)     // Catch:{ IOException -> 0x002f }
            i.d.a.i.b.a(r1)     // Catch:{ IOException -> 0x005d, all -> 0x005b }
            goto L_0x0016
        L_0x002d:
            r5 = move-exception
            goto L_0x0053
        L_0x002f:
            r5 = move-exception
            i.d.a.g r2 = new i.d.a.g     // Catch:{ all -> 0x002d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            r3.<init>()     // Catch:{ all -> 0x002d }
            java.lang.String r4 = "Failed to process zip entry '"
            r3.append(r4)     // Catch:{ all -> 0x002d }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x002d }
            r3.append(r6)     // Catch:{ all -> 0x002d }
            java.lang.String r6 = "' with action "
            r3.append(r6)     // Catch:{ all -> 0x002d }
            r3.append(r0)     // Catch:{ all -> 0x002d }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x002d }
            r2.<init>(r6, r5)     // Catch:{ all -> 0x002d }
            throw r2     // Catch:{ all -> 0x002d }
        L_0x0053:
            i.d.a.i.b.a(r1)     // Catch:{ IOException -> 0x005d, all -> 0x005b }
            throw r5     // Catch:{ IOException -> 0x005d, all -> 0x005b }
        L_0x0057:
            r7.close()     // Catch:{ IOException -> 0x005a }
        L_0x005a:
            return
        L_0x005b:
            r5 = move-exception
            goto L_0x006a
        L_0x005d:
            r5 = move-exception
            r6 = r7
            goto L_0x0063
        L_0x0060:
            r5 = move-exception
            goto L_0x0069
        L_0x0062:
            r5 = move-exception
        L_0x0063:
            i.d.a.g r7 = new i.d.a.g     // Catch:{ all -> 0x0060 }
            r7.<init>(r5)     // Catch:{ all -> 0x0060 }
            throw r7     // Catch:{ all -> 0x0060 }
        L_0x0069:
            r7 = r6
        L_0x006a:
            if (r7 == 0) goto L_0x006f
            r7.close()     // Catch:{ IOException -> 0x006f }
        L_0x006f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: i.d.a.h.b(java.io.File, java.io.File, i.d.a.c):void");
    }

    public static void a(File file, ZipOutputStream zipOutputStream, c cVar, String str, boolean z) throws IOException {
        String[] list = file.list();
        if (list == null) {
            if (!file.exists()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Given file '");
                sb.append(file);
                sb.append("' doesn't exist!");
                throw new g(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Given file is not a directory '");
            sb2.append(file);
            sb2.append("'");
            throw new IOException(sb2.toString());
        } else if (!z || list.length != 0) {
            for (String file2 : list) {
                File file3 = new File(file, file2);
                boolean isDirectory = file3.isDirectory();
                StringBuilder a2 = e.a.a.a.a.a(str);
                a2.append(file3.getName());
                String sb3 = a2.toString();
                if (isDirectory) {
                    sb3 = e.a.a.a.a.a(sb3, BceConfig.BOS_DELIMITER);
                }
                String a3 = cVar.a(sb3);
                if (a3 != null) {
                    ZipEntry zipEntry = new ZipEntry(a3);
                    if (!file3.isDirectory()) {
                        zipEntry.setSize(file3.length());
                    }
                    zipEntry.setTime(file3.lastModified());
                    d a4 = f.f9894b.a(file3);
                    if (a4 != null) {
                        try {
                            List a5 = i.d.a.j.b.a(zipEntry.getExtra());
                            i.d.a.j.a a6 = n.a(a5);
                            if (a6 == null) {
                                a6 = new i.d.a.j.a();
                                ((ArrayList) a5).add(a6);
                            }
                            a6.f9905e = zipEntry.isDirectory();
                            a6.f9901a = a6.a(a6.f9901a);
                            a6.f9901a = a6.a(f.a(a4));
                            zipEntry.setExtra(i.d.a.j.b.a(a5));
                        } catch (ZipException unused) {
                        }
                    }
                    zipOutputStream.putNextEntry(zipEntry);
                    if (!isDirectory) {
                        i.d.a.i.a.a(file3, zipOutputStream);
                    }
                    zipOutputStream.closeEntry();
                }
                if (isDirectory) {
                    a(file3, zipOutputStream, cVar, sb3, false);
                }
            }
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Given directory '");
            sb4.append(file);
            sb4.append("' doesn't contain any files!");
            throw new g(sb4.toString());
        }
    }
}
