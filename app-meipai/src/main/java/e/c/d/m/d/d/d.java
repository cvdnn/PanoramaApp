package e.c.d.m.d.d;

import android.text.TextUtils;
import com.arashivision.sdkmedia.work.WorkWrapper;
import com.baidu.picapture.db.tables.PanoTaskDao;
import com.baidu.picapture.db.tables.PanoTaskDao.Properties;
import e.c.d.f.b.a;
import e.c.d.m.a.c;
import e.c.d.n.e;
import i.b.b.j.f;
import i.b.b.j.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PanoramaSimplePreviewPresenter */
public class d extends c<c> implements b {
    public d(c cVar) {
        super(cVar);
    }

    public void a(String str) {
        List list;
        WorkWrapper workWrapper = new WorkWrapper(e.g(str));
        a c2 = a.c();
        if (c2 != null) {
            if (TextUtils.isEmpty(e.c.d.d.c.e.f6006d.f6009c)) {
                list = new ArrayList();
            } else {
                PanoTaskDao a2 = c2.a();
                if (a2 != null) {
                    f fVar = new f(a2);
                    fVar.a(Properties.TaskId.a(str), new h[0]);
                    list = fVar.a();
                } else {
                    throw null;
                }
            }
            if (list != null && !list.isEmpty()) {
                ((c) this.f6403a).i(((e.c.d.f.d.d) list.get(0)).f6084d);
                ((c) this.f6403a).a(workWrapper);
                return;
            }
            return;
        }
        throw null;
    }

    public void a() {
        ((c) this.f6403a).c();
    }
}
