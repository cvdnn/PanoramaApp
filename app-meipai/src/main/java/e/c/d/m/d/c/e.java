package e.c.d.m.d.c;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import android.text.TextUtils;
import com.arashivision.sdkmedia.work.WorkWrapper;
import com.baidu.picapture.App;
import com.baidu.picapture.R;
import com.baidu.picapture.db.tables.PanoTaskDao;
import com.baidu.picapture.db.tables.PanoTaskDao.Properties;
import e.c.d.d.b.b;
import e.c.d.m.a.c;
import i.b.b.j.f;
import i.b.b.j.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PanoramaPreviewPresenter */
public class e extends c<d> implements c {

    /* renamed from: b reason: collision with root package name */
    public a f6653b = a.FISH_EYE;

    /* renamed from: c reason: collision with root package name */
    public WorkWrapper f6654c;

    /* renamed from: d reason: collision with root package name */
    public String f6655d;

    /* compiled from: PanoramaPreviewPresenter */
    public enum a {
        FISH_EYE,
        PERSPECTIVE,
        PLANE
    }

    public e(d dVar) {
        super(dVar);
    }

    public void a(String str, String str2) {
        this.f6655d = str;
        WorkWrapper workWrapper = new WorkWrapper(str2);
        this.f6654c = workWrapper;
        ((d) this.f6403a).a(workWrapper);
    }

    @SuppressLint({"DefaultLocale"})
    public void b() {
        List list;
        e.c.d.f.b.a c2 = e.c.d.f.b.a.c();
        if (c2 != null) {
            String str = e.c.d.d.c.e.f6006d.f6009c;
            if (TextUtils.isEmpty(str)) {
                list = new ArrayList();
            } else {
                PanoTaskDao a2 = c2.a();
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
            sb.append(App.f1954b.getString(R.string.panorama));
            sb.append("-%d");
            ((d) this.f6403a).c(String.format(sb.toString(), new Object[]{Integer.valueOf(size + 1)}));
            return;
        }
        throw null;
    }

    public void o() {
        if (a.FISH_EYE == this.f6653b) {
            ((d) this.f6403a).P();
        }
    }

    public void r() {
        a aVar;
        a aVar2 = this.f6653b;
        if (aVar2 == a.FISH_EYE) {
            aVar = a.PERSPECTIVE;
        } else if (aVar2 == a.PERSPECTIVE) {
            aVar = a.PLANE;
        } else {
            aVar = a.FISH_EYE;
        }
        int ordinal = aVar.ordinal();
        if (ordinal == 0) {
            ((d) this.f6403a).c(this.f6654c);
        } else if (ordinal == 1) {
            ((d) this.f6403a).J();
        } else if (ordinal == 2) {
            ((d) this.f6403a).b(this.f6654c);
        }
        this.f6653b = aVar;
    }

    public void b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("taskId", this.f6655d);
            jSONObject.put("taskName", str);
            b a2 = b.a();
            e.c.d.d.b.c cVar = new e.c.d.d.b.c("ipc_new_pano_task", jSONObject.toString());
            if (a2 != null) {
                e.c.d.d.b.a aVar = a2.f5997a;
                if (aVar != null) {
                    try {
                        aVar.a(cVar);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
                ((d) this.f6403a).p();
                return;
            }
            throw null;
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }
}
