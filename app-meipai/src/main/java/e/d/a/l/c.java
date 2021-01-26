package e.d.a.l;

import e.a.a.a.a;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: Util */
public final class c {

    /* renamed from: a reason: collision with root package name */
    public static final Charset f7176a = Charset.forName("US-ASCII");

    static {
        Charset.forName("UTF-8");
    }

    public static void a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i2 = 0;
            while (i2 < length) {
                File file2 = listFiles[i2];
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (file2.delete()) {
                    i2++;
                } else {
                    throw new IOException(a.a("failed to delete file: ", file2));
                }
            }
            return;
        }
        throw new IOException(a.a("not a readable directory: ", file));
    }
}
