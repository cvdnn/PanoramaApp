package e.d.a.n.o;

import android.util.Log;
import e.d.a.n.d;
import e.d.a.n.h;
import e.d.a.t.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferEncoder */
public class c implements d<ByteBuffer> {
    public boolean a(Object obj, File file, h hVar) {
        try {
            a.a((ByteBuffer) obj, file);
            return true;
        } catch (IOException e2) {
            String str = "ByteBufferEncoder";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to write data", e2);
            }
            return false;
        }
    }
}
