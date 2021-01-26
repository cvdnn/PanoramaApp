package e.c.d.d.a;

import com.baidu.picapture.common.bos.beans.BosKeyBean;
import com.baidu.picapture.common.bos.beans.UploadTask;
import com.baidu.picapture.model.net.BaseResponse;

import e.c.d.d.e.ThreadPoolService;
import e.c.d.l.b.a;
import g.e;

/* compiled from: UploadManager */
public class t extends a<BaseResponse<BosKeyBean>> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ UploadTask f5993a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ s f5994b;

    public t(s sVar, UploadTask uploadTask) {
        this.f5994b = sVar;
        this.f5993a = uploadTask;
    }

    public void a(e eVar, Object obj, int i2) {
        BaseResponse baseResponse = (BaseResponse) obj;
        this.f5993a.getFilePath();
        s.f5986e.execute(new l(this, i2, baseResponse, this.f5993a));
    }

    public /* synthetic */ void a(int i2, BaseResponse baseResponse, UploadTask uploadTask) {
        if (i2 == 0 && baseResponse != null && baseResponse.getError_code() == 0 && baseResponse.getData() != null) {
            s sVar = this.f5994b;
            BosKeyBean bosKeyBean = (BosKeyBean) baseResponse.getData();
            if (!sVar.f5987a.containsKey(uploadTask.getUploadId())) {
                uploadTask.getUploadId();
            } else {
                uploadTask.setStatus(4);
                o oVar = new o(uploadTask.getFilePath(), uploadTask.getBucketKey(), bosKeyBean.getAccessKeyId(), bosKeyBean.getSecretAccessKey(), bosKeyBean.getSessionToken());
                r rVar = new r(oVar);
                p pVar = sVar.f5989c;
                if (!rVar.f5981b.contains(pVar)) {
                    rVar.f5981b.registerObserver(pVar);
                }
                p uploadListener = uploadTask.getUploadListener();
                if (!rVar.f5981b.contains(uploadListener)) {
                    rVar.f5981b.registerObserver(uploadListener);
                }
                uploadTask.setBosUploader(rVar);
                ThreadPoolService.fixedThreadPool.execute(new n(rVar, uploadTask));
            }
        } else if (uploadTask.getUploadListener() != null) {
            s.a(this.f5994b, uploadTask.getUploadId());
            if (i2 == 2) {
                uploadTask.getUploadListener().a(uploadTask.getUploadId(), 3);
            } else {
                uploadTask.getUploadListener().a(uploadTask.getUploadId(), 4);
            }
        }
    }
}
