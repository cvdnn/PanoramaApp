package e.g.b;

import com.google.gson.internal.bind.TypeAdapters;
import e.g.b.e0.c;
import java.io.IOException;
import java.io.StringWriter;

/* compiled from: JsonElement */
public abstract class o {
    public boolean a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public l d() {
        if (this instanceof l) {
            return (l) this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Not a JSON Array: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    public r e() {
        if (this instanceof r) {
            return (r) this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Not a JSON Object: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    public t f() {
        if (this instanceof t) {
            return (t) this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Not a JSON Primitive: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    public String g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            c cVar = new c(stringWriter);
            cVar.f8566f = true;
            TypeAdapters.X.a(cVar, this);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
