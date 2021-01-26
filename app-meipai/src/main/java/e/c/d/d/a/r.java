package e.c.d.d.a;

import android.text.TextUtils;
import com.baidubce.auth.DefaultBceSessionCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.AbortMultipartUploadRequest;
import com.baidubce.services.bos.model.CompleteMultipartUploadRequest;
import com.baidubce.services.bos.model.CompleteMultipartUploadResponse;
import e.c.d.d.f.b;
import e.c.d.f.b.c;
import e.c.d.f.d.g;
import org.json.JSONException;

/* compiled from: BosUploader */
public class r {

    /* renamed from: a reason: collision with root package name */
    public BosClient f5980a;

    /* renamed from: b reason: collision with root package name */
    public b<p> f5981b;

    /* renamed from: c reason: collision with root package name */
    public o f5982c;

    /* renamed from: d reason: collision with root package name */
    public g f5983d;

    /* renamed from: e reason: collision with root package name */
    public boolean f5984e = false;

    public r(o oVar) {
        this.f5982c = oVar;
        BosClientConfiguration bosClientConfiguration = new BosClientConfiguration();
        bosClientConfiguration.setCredentials(new DefaultBceSessionCredentials(oVar.f5975e, oVar.f5976f, oVar.f5977g));
        bosClientConfiguration.setEndpoint(oVar.f5971a);
        this.f5980a = new BosClient(bosClientConfiguration);
        this.f5981b = new b<>();
        g gVar = new g();
        this.f5983d = gVar;
        gVar.f6094f = 0;
    }

    public final void a(int i2) {
        g gVar = this.f5983d;
        gVar.f6094f = i2;
        if (!TextUtils.isEmpty(gVar.f6089a)) {
            c b2 = c.b();
            b2.a().d(this.f5983d);
        }
    }

    public final void b() {
        g gVar = this.f5983d;
        String str = gVar.f6089a;
        o oVar = this.f5982c;
        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(oVar.f5972b, oVar.f5973c, gVar.f6090b, gVar.f6093e);
        CompleteMultipartUploadResponse completeMultipartUploadResponse = null;
        try {
            completeMultipartUploadResponse = this.f5980a.completeMultipartUpload(completeMultipartUploadRequest);
        } catch (JSONException e2) {
            e2.getMessage();
            e2.printStackTrace();
        }
        if (completeMultipartUploadResponse != null) {
            a(999);
            this.f5981b.contains(new g(this, completeMultipartUploadResponse.getLocation()));
            this.f5983d.f6093e.clear();
            completeMultipartUploadResponse.getETag();
            return;
        }
        a(998);
        this.f5981b.contains(new c(this));
    }

    public /* synthetic */ void c(p pVar) {
        pVar.a(this.f5983d.f6089a);
    }

    public /* synthetic */ void d(p pVar) {
        pVar.a(this.f5983d.f6089a, 2);
    }

    public /* synthetic */ void e(p pVar) {
        pVar.a(this.f5983d.f6089a, 998);
    }

    public /* synthetic */ void f(p pVar) {
        pVar.a(this.f5983d.f6089a, 998);
    }

    public /* synthetic */ void a(String str, p pVar) {
        pVar.a(this.f5983d.f6089a, str);
    }

    public final void a() {
        this.f5984e = false;
        this.f5981b.contains(new b(this));
        g gVar = this.f5983d;
        if (gVar.f6094f == 1) {
            o oVar = this.f5982c;
            this.f5980a.abortMultipartUpload(new AbortMultipartUploadRequest(oVar.f5972b, oVar.f5973c, gVar.f6090b));
        }
        c b2 = c.b();
        b2.a().a(this.f5983d.f6089a);
    }

    public /* synthetic */ void b(p pVar) {
        pVar.a(this.f5983d.f6089a, 998);
    }

    public /* synthetic */ void a(p pVar) {
        pVar.a(this.f5983d.f6089a, 3);
    }
}
