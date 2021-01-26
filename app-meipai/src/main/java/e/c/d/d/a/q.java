package e.c.d.d.a;

import com.baidubce.model.AbstractBceRequest;
import com.baidubce.services.bos.callback.BosProgressCallback;
import com.baidubce.services.bos.model.UploadPartRequest;
import java.io.File;

/* compiled from: BosUploader */
public class q extends BosProgressCallback<UploadPartRequest> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ File f5978a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ r f5979b;

    public q(r rVar, File file) {
        this.f5979b = rVar;
        this.f5978a = file;
    }

    public /* synthetic */ void a(float f2, p pVar) {
        pVar.a(this.f5979b.f5983d.f6089a, Math.min(f2, 100.0f));
    }

    public void onProgress(AbstractBceRequest abstractBceRequest, long j2, long j3) {
        this.f5979b.f5981b.observable(new a(this, (((float) ((((long) ((UploadPartRequest) abstractBceRequest).getPartNumber()) * 5242880) + j2)) * 100.0f) / ((float) this.f5978a.length())));
    }
}
