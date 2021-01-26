package e.d.a.n.p.g;

import android.util.Log;
import e.d.a.n.c;
import e.d.a.n.h;
import e.d.a.n.k;
import e.d.a.n.n.w;
import e.d.a.t.a;
import java.io.File;
import java.io.IOException;

/* compiled from: GifDrawableEncoder */
public class d implements k<c> {
    public boolean a(Object obj, File file, h hVar) {
        try {
            a.a(((c) ((w) obj).get()).f7758a.f7768a.f7770a.d().asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e2) {
            String str = "GifEncoder";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Failed to encode GIF drawable data", e2);
            }
            return false;
        }
    }

    public c a(h hVar) {
        return c.SOURCE;
    }
}
