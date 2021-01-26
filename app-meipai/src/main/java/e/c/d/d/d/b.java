package e.c.d.d.d;

import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShareErrorCode */
public enum b {
    SUCCESS("0", "分享成功"),
    CANCLED("1", "取消分享"),
    ERROR("2", "分享失败"),
    PARAM_TYPE_EMPTY(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "type为空"),
    PARAM_TYPE_ERROR(Constants.VIA_REPORT_TYPE_SET_AVATAR, "type有误"),
    PARAM_TITLE_EMPTY("13", "缺少标题"),
    PARAM_IMAGEURL_EMPTY(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "缺少图片链接"),
    PARAM_SHAREURL_EMPTY(Constants.VIA_REPORT_TYPE_WPA_STATE, "缺少分享链接"),
    PARAM_JSON_ERROR(Constants.VIA_REPORT_TYPE_START_WAP, "json解析失败"),
    PLATFORM_WEIBO_EMPTY("100", "请安装微博客户端"),
    PLATFORM_WECHAT_EMPTY("200", "请安装微信客户端"),
    PLATFORM_WECHAT_ERROR("201", "微信版本太低，不支持分享到朋友圈"),
    PLATFORM_QQ_EMPTY("300", "请安装QQ客户端");
    

    /* renamed from: a reason: collision with root package name */
    public String f6018a;

    /* renamed from: b reason: collision with root package name */
    public String f6019b;

    /* access modifiers changed from: public */
    b(String str, String str2) {
        this.f6018a = str;
        this.f6019b = str2;
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f6018a);
            jSONObject.put(SocialConstants.PARAM_COMMENT, this.f6019b);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
