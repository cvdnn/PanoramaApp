package e.d.a.n.n;

import android.util.Log;
import e.d.a.n.f;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: GlideException */
public final class r extends Exception {

    /* renamed from: f reason: collision with root package name */
    public static final StackTraceElement[] f7497f = new StackTraceElement[0];

    /* renamed from: a reason: collision with root package name */
    public final List<Throwable> f7498a;

    /* renamed from: b reason: collision with root package name */
    public f f7499b;

    /* renamed from: c reason: collision with root package name */
    public e.d.a.n.a f7500c;

    /* renamed from: d reason: collision with root package name */
    public Class<?> f7501d;

    /* renamed from: e reason: collision with root package name */
    public String f7502e;

    /* compiled from: GlideException */
    public static final class a implements Appendable {

        /* renamed from: a reason: collision with root package name */
        public final Appendable f7503a;

        /* renamed from: b reason: collision with root package name */
        public boolean f7504b = true;

        public a(Appendable appendable) {
            this.f7503a = appendable;
        }

        public Appendable append(char c2) throws IOException {
            boolean z = false;
            if (this.f7504b) {
                this.f7504b = false;
                this.f7503a.append("  ");
            }
            if (c2 == 10) {
                z = true;
            }
            this.f7504b = z;
            this.f7503a.append(c2);
            return this;
        }

        public Appendable append(CharSequence charSequence) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            append(charSequence, 0, charSequence.length());
            return this;
        }

        public Appendable append(CharSequence charSequence, int i2, int i3) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z = false;
            if (this.f7504b) {
                this.f7504b = false;
                this.f7503a.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i3 - 1) == 10) {
                z = true;
            }
            this.f7504b = z;
            this.f7503a.append(charSequence, i2, i3);
            return this;
        }
    }

    public r(String str) {
        List<Throwable> emptyList = Collections.emptyList();
        this.f7502e = str;
        setStackTrace(f7497f);
        this.f7498a = emptyList;
    }

    public void a(String str) {
        ArrayList arrayList = new ArrayList();
        a((Throwable) this, (List<Throwable>) arrayList);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder a2 = e.a.a.a.a.a("Root cause (");
            int i3 = i2 + 1;
            a2.append(i3);
            a2.append(" of ");
            a2.append(size);
            a2.append(")");
            Log.i(str, a2.toString(), (Throwable) arrayList.get(i2));
            i2 = i3;
        }
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f7502e);
        String str3 = ", ";
        String str4 = "";
        if (this.f7501d != null) {
            StringBuilder a2 = e.a.a.a.a.a(str3);
            a2.append(this.f7501d);
            str = a2.toString();
        } else {
            str = str4;
        }
        sb.append(str);
        if (this.f7500c != null) {
            StringBuilder a3 = e.a.a.a.a.a(str3);
            a3.append(this.f7500c);
            str2 = a3.toString();
        } else {
            str2 = str4;
        }
        sb.append(str2);
        if (this.f7499b != null) {
            StringBuilder a4 = e.a.a.a.a.a(str3);
            a4.append(this.f7499b);
            str4 = a4.toString();
        }
        sb.append(str4);
        ArrayList arrayList = new ArrayList();
        a((Throwable) this, (List<Throwable>) arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            sb.append(" causes:");
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Throwable th = (Throwable) it.next();
            sb.append(10);
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    public void printStackTrace() {
        a((Appendable) System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        a((Appendable) printStream);
    }

    public void printStackTrace(PrintWriter printWriter) {
        a((Appendable) printWriter);
    }

    public final void a(Throwable th, List<Throwable> list) {
        if (th instanceof r) {
            for (Throwable a2 : ((r) th).f7498a) {
                a(a2, list);
            }
            return;
        }
        list.add(th);
    }

    public r(String str, Throwable th) {
        List<Throwable> singletonList = Collections.singletonList(th);
        this.f7502e = str;
        setStackTrace(f7497f);
        this.f7498a = singletonList;
    }

    public r(String str, List<Throwable> list) {
        this.f7502e = str;
        setStackTrace(f7497f);
        this.f7498a = list;
    }

    public final void a(Appendable appendable) {
        a((Throwable) this, appendable);
        try {
            a(this.f7498a, (Appendable) new a(appendable));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void a(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public static void a(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = (Throwable) list.get(i2);
            if (th instanceof r) {
                ((r) th).a(appendable);
            } else {
                a(th, appendable);
            }
            i2 = i3;
        }
    }
}
