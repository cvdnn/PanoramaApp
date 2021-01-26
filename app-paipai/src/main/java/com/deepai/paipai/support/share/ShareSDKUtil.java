package com.deepai.paipai.support.share;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qq.QQClientNotExistException;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import cn.sharesdk.wechat.utils.WechatClientNotExistException;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.me.error.MsgError;
import com.android.volley.me.request.StringPostRequest;
import com.deepai.library.support.utils.FormatUtil;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.paipai.R;
import com.deepai.paipai.app.AppConstant;
import com.deepai.paipai.app.AppConstant.RequestKey;
import com.deepai.paipai.app.PaiApp;
import com.deepai.paipai.support.net.NetConstants;
import com.deepai.paipai.support.utils.AppSP;
import com.deepai.paipai.ui.activity.share.ShareSuccessActivity;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class ShareSDKUtil implements PlatformActionListener, Callback {
    /* access modifiers changed from: private */
    public Context mContext;
    private String shareId;
    private ShareParams shareParams;

    public ShareSDKUtil(Context context) {
        this.mContext = context;
    }

    public void initShareParams(String title, String content, String imagePath, String url) {
        ShareParams sp = new ShareParams();
        sp.setShareType(1);
        sp.setShareType(4);
        sp.setTitle(title);
        sp.setText(content);
        sp.setUrl(url);
        if (!TextUtils.isEmpty(imagePath)) {
            sp.setImageUrl(imagePath);
        } else {
            sp.setImageData(BitmapFactory.decodeResource(this.mContext.getResources(), R.mipmap.ic_launcher));
        }
        this.shareParams = sp;
    }

    public void qqShare(int position, String shareId2) {
        this.shareId = shareId2;
        ShareParams sp = new ShareParams();
        sp.setTitle(this.shareParams.getTitle());
        sp.setTitleUrl(this.shareParams.getUrl());
        sp.setText(this.shareParams.getText());
        if (!TextUtils.isEmpty(this.shareParams.getImageUrl())) {
            sp.setImageUrl(this.shareParams.getImageUrl());
        } else {
            sp.setImageData(BitmapFactory.decodeResource(this.mContext.getResources(), R.mipmap.ic_launcher));
        }
        sp.setComment("我对此分享内容的评论");
        sp.setSite(this.shareParams.getTitle());
        sp.setSiteUrl(this.shareParams.getUrl());
        Platform platform = ShareSDK.getPlatform(this.mContext, getPlatform(position));
        platform.SSOSetting(false);
        platform.setPlatformActionListener(this);
        platform.share(sp);
    }

    public void weiBoShare(int position, String shareId2) {
        this.shareId = shareId2;
        Platform plat = ShareSDK.getPlatform(this.mContext, getPlatform(position));
        plat.SSOSetting(false);
        plat.setPlatformActionListener(this);
        ShareParams shareParams2 = new ShareParams();
        shareParams2.setShareType(1);
        shareParams2.setShareType(4);
        shareParams2.setTitle(this.shareParams.getTitle());
        shareParams2.setTitleUrl(this.shareParams.getUrl());
        shareParams2.setText(this.shareParams.getTitle());
        shareParams2.setUrl(this.shareParams.getUrl());
        if (!TextUtils.isEmpty(this.shareParams.getImageUrl())) {
            shareParams2.setImageUrl(this.shareParams.getImageUrl());
        } else {
            shareParams2.setImageData(BitmapFactory.decodeResource(this.mContext.getResources(), R.mipmap.ic_launcher));
        }
        plat.share(shareParams2);
    }

    public void weiXinShare(int position, String shareId2) {
        this.shareId = shareId2;
        Platform plat = ShareSDK.getPlatform(this.mContext, getPlatform(position));
        plat.SSOSetting(false);
        plat.setPlatformActionListener(this);
        plat.share(this.shareParams);
    }

    public void copyUrl() {
        ((ClipboardManager) this.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("ImageUrl", this.shareParams.getUrl()));
        ToastFactory.getToast(this.mContext, "复制成功").show();
    }

    private String getPlatform(int position) {
        String platform = "";
        switch (position) {
            case 0:
                return QQ.NAME;
            case 1:
                return QZone.NAME;
            case 2:
                return Wechat.NAME;
            case 3:
                return WechatMoments.NAME;
            case 4:
                return SinaWeibo.NAME;
            case 5:
                return "";
            default:
                return platform;
        }
    }

    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        if (i == 9) {
            Message message = new Message();
            message.what = 0;
            message.obj = platform.getName();
            UIHandler.sendMessage(message, this);
        }
    }

    public void onError(Platform platform, int i, Throwable throwable) {
        if (i == 9) {
            Message message = new Message();
            message.what = 1;
            message.obj = throwable;
            UIHandler.sendMessage(message, this);
        }
    }

    public void onCancel(Platform platform, int i) {
        if (i == 9) {
            UIHandler.sendEmptyMessage(2, this);
        }
    }

    public boolean handleMessage(Message msg) {
        String fail_text;
        switch (msg.what) {
            case 0:
                String name = (String) msg.obj;
                int plat = 0;
                if (SinaWeibo.NAME.equals(name)) {
                    plat = 1;
                } else if (WechatMoments.NAME.equals(name)) {
                    plat = 2;
                } else if (QZone.NAME.equals(name)) {
                    plat = 3;
                }
                addShareToService(plat, this.shareId);
                break;
            case 1:
                if ((msg.obj instanceof WechatClientNotExistException) || (msg.obj instanceof QQClientNotExistException) || (msg.obj instanceof WechatClientNotExistException)) {
                    fail_text = "版本过低或未安装客户端";
                } else if ((msg.obj instanceof Throwable) && msg.obj.toString() != null && msg.obj.toString().contains("prevent duplicate publication")) {
                    fail_text = "请稍后发送";
                } else if (msg.obj.toString().contains("error")) {
                    fail_text = "分享失败";
                } else {
                    fail_text = "分享失败";
                }
                ToastFactory.getToast(this.mContext, fail_text).show();
                break;
            case 2:
                ToastFactory.getToast(this.mContext, "取消分享").show();
                break;
        }
        return false;
    }

    private void addShareToService(int plat, String photoId) {
        String token = AppSP.getToken(this.mContext, "").toString();
        Map<String, String> params = new HashMap<>();
        params.put(RequestKey.TOKEN, token);
        params.put("sharePlatform", plat + "");
        params.put("pictureId", photoId);
        PaiApp.vQueue.add(new StringPostRequest(NetConstants.ADD_SHARE, params, new Listener<String>() {
            public void onResponse(String response) {
                try {
                    if (FormatUtil.getStringFromJson(response, AppConstant.CODE, AppConstant.SUCCESS)) {
                        ToastFactory.getToast(ShareSDKUtil.this.mContext, "分享成功").show();
                        ShareSDKUtil.this.mContext.startActivity(new Intent(ShareSDKUtil.this.mContext, ShareSuccessActivity.class));
                        return;
                    }
                    ToastFactory.getToast(ShareSDKUtil.this.mContext, "分享失败").show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    ToastFactory.getToast(ShareSDKUtil.this.mContext, "分享失败").show();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (error.getClass() == MsgError.class) {
                    ToastFactory.getToast(ShareSDKUtil.this.mContext, "分享失败").show();
                } else {
                    ToastFactory.getToast(ShareSDKUtil.this.mContext, "服务器正忙，请稍后再试").show();
                }
            }
        }));
    }
}
