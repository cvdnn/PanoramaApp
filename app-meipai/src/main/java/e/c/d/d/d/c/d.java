package e.c.d.d.d.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.picapture.common.share.ShareEntity;
import com.tencent.tauth.Tencent;
import e.c.d.d.d.a;
import e.c.d.d.d.a.C0065a;
import e.c.d.d.d.b;
import java.util.ArrayList;

/* compiled from: ShareToQQZone */
public class d extends a {

    /* renamed from: a reason: collision with root package name */
    public Tencent f6026a;

    /* renamed from: b reason: collision with root package name */
    public Context f6027b;

    public d(Context context) {
        this.f6026a = Tencent.createInstance("101826088", context);
        this.f6027b = context;
    }

    public void a(ShareEntity shareEntity, C0065a aVar) {
        if (!this.f6026a.isQQInstalled(this.f6027b)) {
            aVar.a(b.PLATFORM_QQ_EMPTY.a());
        } else if (shareEntity.title == null) {
            aVar.a(b.PARAM_TITLE_EMPTY.a());
        } else if (shareEntity.imageUrl == null) {
            aVar.a(b.PARAM_IMAGEURL_EMPTY.a());
        } else if (shareEntity.shareUrl == null) {
            aVar.a(b.PARAM_SHAREURL_EMPTY.a());
        } else {
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList();
            arrayList.add(shareEntity.imageUrl);
            bundle.putInt("req_type", 1);
            bundle.putString("title", shareEntity.title);
            bundle.putString("summary", shareEntity.description);
            bundle.putString("targetUrl", shareEntity.shareUrl);
            bundle.putStringArrayList("imageUrl", arrayList);
            this.f6026a.shareToQzone((Activity) this.f6027b, bundle, null);
        }
    }
}
