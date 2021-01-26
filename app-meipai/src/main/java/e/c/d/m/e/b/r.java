package e.c.d.m.e.b;

import com.baidu.picapture.model.net.BaseResponse;
import com.baidu.picapture.model.net.spin.SpinContentCreateReq;
import com.baidu.picapture.model.spin.SpinPackageDetail;
import com.tencent.connect.common.Constants;

import e.c.d.d.e.ThreadPoolService;
import e.c.d.l.b.a;
import e.c.d.l.b.b;
import e.g.b.j;
import g.e;
import g.x;
import g.y;

/* compiled from: SpinDetailPresenter */
public class r extends a<BaseResponse<SpinPackageDetail>> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ String f6724a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ String f6725b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ q f6726c;

    public r(q qVar, String str, String str2) {
        this.f6726c = qVar;
        this.f6724a = str;
        this.f6725b = str2;
    }

    public void a(e eVar, Object obj, int i2) {
        BaseResponse baseResponse = (BaseResponse) obj;
        if (i2 != 0 || baseResponse == null || baseResponse.getError_code() != 0 || baseResponse.getData() == null || ((SpinPackageDetail) baseResponse.getData()).getMaterialState() == null) {
            ThreadPoolService.post(new j(this, this.f6724a));
        } else if (((SpinPackageDetail) baseResponse.getData()).getMaterialState().equalsIgnoreCase("prepared")) {
            ThreadPoolService.post(new i(this, this.f6724a, this.f6725b));
        } else if (((SpinPackageDetail) baseResponse.getData()).getMaterialState().equalsIgnoreCase("failed")) {
            ThreadPoolService.post(new k(this, this.f6724a));
        }
    }

    public /* synthetic */ void b(String str) {
        q qVar = this.f6726c;
        qVar.I();
        V v = qVar.f6403a;
        if (v != null) {
            ((p) v).m();
            qVar.F();
        }
    }

    public /* synthetic */ void a(String str, String str2) {
        q qVar = this.f6726c;
        qVar.I();
        b a2 = b.a();
        s sVar = new s(qVar, str);
        if (a2 != null) {
            SpinContentCreateReq spinContentCreateReq = new SpinContentCreateReq();
            spinContentCreateReq.setContentName(str2);
            y create = y.create(b.f6372b, new j().a((Object) spinContentCreateReq));
            x.a aVar = new x.a();
            StringBuilder sb = new StringBuilder();
            sb.append("https://vrstudio.baidu.com/vr/mkt/repos3d/api/v2/content/");
            sb.append(str);
            sb.append("/create");
            aVar.a(sb.toString());
            aVar.a(Constants.HTTP_POST, create);
            a2.f6374a.a(aVar.a()).a(sVar);
            V v = qVar.f6403a;
            if (v != null) {
                ((p) v).E();
                return;
            }
            return;
        }
        throw null;
    }

    public /* synthetic */ void a(String str) {
        q qVar = this.f6726c;
        qVar.I();
        V v = qVar.f6403a;
        if (v != null) {
            ((p) v).m();
            qVar.F();
        }
    }
}
