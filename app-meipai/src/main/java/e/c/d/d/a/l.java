package e.c.d.d.a;

import com.baidu.picapture.common.bos.beans.UploadTask;
import com.baidu.picapture.model.net.BaseResponse;

/* compiled from: lambda */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ t f5963a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ int f5964b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ BaseResponse f5965c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ UploadTask f5966d;

    public /* synthetic */ l(t tVar, int i2, BaseResponse baseResponse, UploadTask uploadTask) {
        this.f5963a = tVar;
        this.f5964b = i2;
        this.f5965c = baseResponse;
        this.f5966d = uploadTask;
    }

    public final void run() {
        this.f5963a.a(this.f5964b, this.f5965c, this.f5966d);
    }
}
