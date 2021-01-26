package i.d.a.i;

import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

/* compiled from: FileUtils */
public class a {

    /* renamed from: a reason: collision with root package name */
    public static final BigInteger f9898a;

    static {
        BigInteger multiply = BigInteger.valueOf(AppSupportContentFlag.MMAPP_SUPPORT_XLS).multiply(BigInteger.valueOf(1152921504606846976L));
        f9898a = multiply;
        multiply.multiply(BigInteger.valueOf(1152921504606846976L));
    }

    public static void a(File file, OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            b.a(new BufferedInputStream(fileInputStream), outputStream);
        } finally {
            b.a((InputStream) fileInputStream);
        }
    }

    public static void a(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                StringBuilder sb = new StringBuilder();
                sb.append("File ");
                sb.append(file);
                sb.append(" exists and is not a directory. Unable to create directory.");
                throw new IOException(sb.toString());
            }
        } else if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException(e.a.a.a.a.a("Unable to create directory ", file));
        }
    }
}
