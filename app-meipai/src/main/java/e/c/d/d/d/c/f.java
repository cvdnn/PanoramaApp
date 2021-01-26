package e.c.d.d.d.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.picapture.common.share.ShareEntity;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.share.WbShareHandler;
import e.c.d.d.d.a;
import e.c.d.d.d.b;
import e.c.d.d.e.ThreadPoolService;

/* compiled from: ShareToWeibo */
public class f extends a {

    /* renamed from: a reason: collision with root package name */
    public WbShareHandler f6030a;

    /* renamed from: b reason: collision with root package name */
    public ShareEntity f6031b;

    /* renamed from: c reason: collision with root package name */
    public Bitmap f6032c;

    public f(Context context) {
        WbSdk.install(context, new AuthInfo(context, "3346202980", "https://api.weibo.com/oauth2/default.html", ""));
        WbShareHandler wbShareHandler = new WbShareHandler((Activity) context);
        this.f6030a = wbShareHandler;
        wbShareHandler.registerApp();
    }

    public void a(ShareEntity shareEntity, C0065a aVar) {
        if (!this.f6030a.isWbAppInstalled()) {
            aVar.a(b.PLATFORM_WEIBO_EMPTY.a());
            return;
        }
        this.f6031b = shareEntity;
        ThreadPoolService.fixedThreadPool.execute(new b(this, shareEntity));
    }

    public /* synthetic */ void a(ShareEntity shareEntity) {
        String str;
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        TextObject textObject = new TextObject();
        String str2 = this.f6031b.title;
        if (str2 != null) {
            str = String.format("【%s】\n", new Object[]{str2});
        } else {
            str = "";
        }
        if (this.f6031b.description != null) {
            StringBuilder a2 = e.a.a.a.a.a(str);
            a2.append(this.f6031b.description);
            str = a2.toString();
        }
        if (this.f6031b.shareUrl != null) {
            StringBuilder a3 = e.a.a.a.a.a(str);
            a3.append(this.f6031b.shareUrl);
            str = a3.toString();
        }
        textObject.text = str;
        weiboMultiMessage.textObject = textObject;
        Bitmap a4 = a(shareEntity.imageUrl);
        this.f6032c = a4;
        if (a4 != null) {
            ImageObject imageObject = new ImageObject();
            imageObject.setImageObject(this.f6032c);
            weiboMultiMessage.imageObject = imageObject;
        }
        this.f6030a.shareMessage(weiboMultiMessage, false);
    }
}
