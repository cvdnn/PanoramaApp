package i.d.a.i;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/* compiled from: IOUtils */
public class b {
    static {
        char c2 = File.separatorChar;
        c cVar = new c(4);
        PrintWriter printWriter = new PrintWriter(cVar);
        printWriter.println();
        cVar.toString();
        printWriter.close();
    }

    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                break;
            }
            outputStream.write(bArr, 0, read);
            j2 += (long) read;
        }
        if (j2 > 2147483647L) {
            return -1;
        }
        return (int) j2;
    }
}
