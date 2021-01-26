package e.c.d.l.b.c;

import androidx.recyclerview.widget.RecyclerView;
import g.a0;
import g.d0.f.f;
import g.s;
import g.x;
import g.y;
import g.z;
import h.e;
import h.g;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* compiled from: LogInterceptor */
public class a implements s {

    /* renamed from: a reason: collision with root package name */
    public static final Charset f6375a = StandardCharsets.UTF_8;

    public z intercept(g.s.a aVar) throws IOException {
        x xVar = ((f) aVar).f9242f;
        y yVar = xVar.f9598d;
        if (yVar != null) {
            e eVar = new e();
            try {
                yVar.writeTo(eVar);
                eVar.a(f6375a);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        StringBuilder a2 = e.a.a.a.a.a("requestURL:\n");
        a2.append(xVar.f9595a);
        a2.append("\nrequestHeaders:\n");
        a2.append(xVar.f9597c.toString());
        a2.append("\nrequestBody:");
        a2.toString();
        z a3 = ((f) aVar).a(xVar);
        if (a3 != null) {
            a0 a0Var = a3.f9620g;
            if (a0Var != null) {
                g source = a0Var.source();
                try {
                    source.e(RecyclerView.FOREVER_NS);
                    source.getBuffer().clone().a(f6375a);
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            a3.f9619f.toString();
        }
        return a3;
    }
}
