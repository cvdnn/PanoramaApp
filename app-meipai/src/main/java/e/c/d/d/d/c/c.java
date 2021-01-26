package e.c.d.d.d.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.picapture.common.share.ShareEntity;
import com.tencent.tauth.Tencent;
import e.c.d.d.d.a;
import e.c.d.d.d.a.C0065a;
import e.c.d.d.d.b;

/* compiled from: ShareToQQFriend */
public class c extends a {

    /* renamed from: a reason: collision with root package name */
    public Tencent f6024a;

    /* renamed from: b reason: collision with root package name */
    public Context f6025b;

    public c(Context context) {
        this.f6024a = Tencent.createInstance("101826088", context);
        this.f6025b = context;
    }

    public void a(ShareEntity shareEntity, C0065a aVar) {
        if (!this.f6024a.isQQInstalled(this.f6025b)) {
            aVar.a(b.PLATFORM_QQ_EMPTY.a());
        } else if (shareEntity.title == null) {
            aVar.a(b.PARAM_TITLE_EMPTY.a());
        } else if (shareEntity.shareUrl == null) {
            aVar.a(b.PARAM_SHAREURL_EMPTY.a());
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt("req_type", 1);
            bundle.putString("title", shareEntity.title);
            bundle.putString("summary", shareEntity.description);
            bundle.putString("targetUrl", shareEntity.shareUrl);
            bundle.putString("imageUrl", shareEntity.imageUrl);
            bundle.putInt("cflag", 2);
            this.f6024a.shareToQQ((Activity) this.f6025b, bundle, null);
        }
    }
}
