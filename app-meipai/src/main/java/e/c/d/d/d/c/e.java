package e.c.d.d.d.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.baidu.picapture.common.share.ShareEntity;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import e.c.d.d.d.a;
import e.c.d.d.d.b;
import e.c.d.d.e.ThreadPoolService;

import java.io.ByteArrayOutputStream;

/* compiled from: ShareToWechat */
public class e extends a {

    /* renamed from: a reason: collision with root package name */
    public IWXAPI f6028a;

    /* renamed from: b reason: collision with root package name */
    public Bitmap f6029b;

    public e(Context context) {
        String str = "wxf4d91e07aec514ad";
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, str, false);
        this.f6028a = createWXAPI;
        createWXAPI.registerApp(str);
    }

    public void a(ShareEntity shareEntity, C0065a aVar) {
        if (!this.f6028a.isWXAppInstalled()) {
            aVar.a(b.PLATFORM_WECHAT_EMPTY.a());
        } else if (shareEntity.shareUrl == null) {
            aVar.a(b.PARAM_SHAREURL_EMPTY.a());
        } else if (!shareEntity.type.equalsIgnoreCase("wechatmoments") || this.f6028a.getWXAppSupportAPI() >= 553779201) {
            ThreadPoolService.fixedThreadPool.execute(new a(this, shareEntity));
        } else {
            aVar.a(b.PLATFORM_WECHAT_ERROR.a());
        }
    }

    public /* synthetic */ void a(ShareEntity shareEntity) {
        Bitmap bitmap;
        int i2;
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = shareEntity.shareUrl;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        String str = "wechatmoments";
        if (shareEntity.type.equalsIgnoreCase(str)) {
            wXMediaMessage.title = String.format("【%s】%s", new Object[]{shareEntity.title, shareEntity.description});
        } else {
            wXMediaMessage.title = shareEntity.title;
            wXMediaMessage.description = shareEntity.description;
        }
        Bitmap a2 = a(shareEntity.imageUrl);
        if (a2 != null) {
            int width = a2.getWidth();
            int height = a2.getHeight();
            int min = Math.min(width, height);
            int i3 = width >= height ? (width - height) / 2 : 0;
            if (width >= height) {
                i2 = 0;
            } else {
                i2 = (height - width) / 2;
            }
            bitmap = Bitmap.createBitmap(a2, i3, i2, min, min, null, false);
        } else {
            bitmap = null;
        }
        this.f6029b = bitmap;
        if (bitmap != null) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 150, 150, true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createScaledBitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
            createScaledBitmap.recycle();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            wXMediaMessage.thumbData = byteArray;
        }
        Req req = new Req();
        StringBuilder a3 = e.a.a.a.a.a("webpage");
        a3.append(System.currentTimeMillis());
        req.transaction = a3.toString();
        req.message = wXMediaMessage;
        if (shareEntity.type.equalsIgnoreCase(str)) {
            req.scene = 1;
        } else {
            req.scene = 0;
        }
        this.f6028a.sendReq(req);
    }
}
