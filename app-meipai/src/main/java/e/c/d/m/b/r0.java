package e.c.d.m.b;

import android.text.TextUtils;
import com.baidu.picapture.model.device.LanguageUtils;
import com.baidu.picapture.model.net.BaseResponse;
import com.baidu.picapture.model.net.LastVersionResp;

import e.c.d.d.e.ThreadPoolService;
import e.c.d.l.b.a;
import g.e;

/* compiled from: HomePresenter */
public class r0 extends a<BaseResponse<LastVersionResp>> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ q0 f6482a;

    public r0(q0 q0Var) {
        this.f6482a = q0Var;
    }

    public void a(e eVar, Object obj, int i2) {
        BaseResponse baseResponse = (BaseResponse) obj;
        if (i2 == 0 && baseResponse != null && baseResponse.getError_code() == 0 && baseResponse.getData() != null && !TextUtils.isEmpty(((LastVersionResp) baseResponse.getData()).getVersion()) && !TextUtils.isEmpty(((LastVersionResp) baseResponse.getData()).getDownloadingUrl()) && !((LastVersionResp) baseResponse.getData()).getVersion().equalsIgnoreCase("4.1.3.511")) {
            ThreadPoolService.post(new b0(this, baseResponse));
        }
    }

    public /* synthetic */ void a(BaseResponse baseResponse) {
        String str;
        if (this.f6482a.f6403a != null) {
            if (((LastVersionResp) baseResponse.getData()).isForceUpdate()) {
                ((p0) this.f6482a.f6403a).m(((LastVersionResp) baseResponse.getData()).getDownloadingUrl());
            } else {
                if (LanguageUtils.isChineseLanguage() || TextUtils.isEmpty(((LastVersionResp) baseResponse.getData()).getNoteEn())) {
                    str = ((LastVersionResp) baseResponse.getData()).getNote();
                } else {
                    str = ((LastVersionResp) baseResponse.getData()).getNoteEn();
                }
                ((p0) this.f6482a.f6403a).e(((LastVersionResp) baseResponse.getData()).getDownloadingUrl(), str);
            }
        }
    }
}
