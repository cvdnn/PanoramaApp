package e.c.d.m.e.b;

import com.baidu.picapture.App;
import com.baidu.picapture.R;
import com.baidu.picapture.model.net.BaseResponse;
import com.baidu.picapture.model.net.spin.SpinContentCreateResp;

import e.c.d.d.e.ThreadPoolService;
import e.c.d.g.d;
import e.c.d.l.b.a;
import g.e;
import i.b.a.c;

/* compiled from: SpinDetailPresenter */
public class s extends a<BaseResponse<SpinContentCreateResp>> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ String f6727a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ q f6728b;

    public s(q qVar, String str) {
        this.f6728b = qVar;
        this.f6727a = str;
    }

    public void a(e eVar, Object obj, int i2) {
        ThreadPoolService.post(new l(this, i2, (BaseResponse) obj, this.f6727a));
    }

    public /* synthetic */ void a(int i2, BaseResponse baseResponse, String str) {
        if (i2 != 0 || baseResponse == null) {
            q.a(this.f6728b, str, -1);
        } else if (baseResponse.getError_code() == 0) {
            q qVar = this.f6728b;
            SpinContentCreateResp spinContentCreateResp = (SpinContentCreateResp) baseResponse.getData();
            if (qVar.f6403a != null) {
                c.b().a((Object) new d(String.format("#/detail/%s/%s", new Object[]{spinContentCreateResp.getContentId(), spinContentCreateResp.getMaterialUuid()})));
                ((p) qVar.f6403a).b(App.f1954b.getString(R.string.asset_created_sucess));
                ((p) qVar.f6403a).a();
            }
        } else {
            q.a(this.f6728b, str, baseResponse.getError_code());
        }
    }
}
