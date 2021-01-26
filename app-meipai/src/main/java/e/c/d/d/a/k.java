package e.c.d.d.a;

import com.baidu.picapture.common.bos.beans.UploadTask;
import com.baidu.picapture.model.net.BaseResponse;
import e.c.d.d.a.s.b;

/* compiled from: lambda */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ b f5959a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ int f5960b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ BaseResponse f5961c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ UploadTask f5962d;

    public /* synthetic */ k(b bVar, int i2, BaseResponse baseResponse, UploadTask uploadTask) {
        this.f5959a = bVar;
        this.f5960b = i2;
        this.f5961c = baseResponse;
        this.f5962d = uploadTask;
    }

    public final void run() {
        this.f5959a.a(this.f5960b, this.f5961c, this.f5962d);
    }
}
