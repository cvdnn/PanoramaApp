package e.c.d.m.e.d;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.picapture.App;
import com.baidu.picapture.R;
import com.baidu.picapture.db.tables.LocalTaskDao;
import com.baidu.picapture.db.tables.LocalTaskDao.Properties;
import e.c.d.d.c.e;
import e.c.d.f.b.b;
import e.c.d.m.a.c;
import i.b.b.j.f;
import i.b.b.j.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SpinPreviewPresenter */
public class i extends c<h> implements g {

    /* renamed from: b reason: collision with root package name */
    public String f6782b;

    /* renamed from: c reason: collision with root package name */
    public File[] f6783c;

    public i(h hVar) {
        super(hVar);
    }

    public void a(String str) {
        this.f6782b = str;
    }

    @SuppressLint({"DefaultLocale"})
    public void b() {
        List list;
        b b2 = b.b();
        if (b2 != null) {
            String str = e.f6006d.f6009c;
            if (TextUtils.isEmpty(str)) {
                list = new ArrayList();
            } else {
                LocalTaskDao a2 = b2.a();
                if (a2 != null) {
                    f fVar = new f(a2);
                    fVar.a(Properties.Uid.a(str), new h[0]);
                    fVar.a(" ASC", Properties.CreateTime);
                    list = fVar.a();
                } else {
                    throw null;
                }
            }
            int size = list != null ? list.size() : 0;
            StringBuilder sb = new StringBuilder();
            sb.append(App.f1954b.getString(R.string.asset_3d));
            sb.append("-%d");
            ((h) this.f6403a).c(String.format(sb.toString(), new Object[]{Integer.valueOf(size + 1)}));
            return;
        }
        throw null;
    }

    public void e() {
        super.e();
        this.f6783c = null;
    }

    public void n() {
        e.c.d.n.e.b("has_shown_preview_rotate_tips", true, true);
    }

    public void start() {
        File[] i2 = e.c.d.n.e.i(this.f6782b);
        this.f6783c = i2;
        if (i2.length > 0) {
            ((h) this.f6403a).a(i2);
        }
        ((h) this.f6403a).j(true ^ e.c.d.n.e.a("has_shown_preview_rotate_tips", true));
    }

    public void b(String str) {
        ((h) this.f6403a).b(this.f6782b, str);
    }
}
