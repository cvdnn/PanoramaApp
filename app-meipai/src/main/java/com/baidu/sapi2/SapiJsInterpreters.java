package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.DatePicker;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.SapiJsCallBacks.CallBacks;
import com.baidu.sapi2.SapiJsCallBacks.FingerprintResult;
import com.baidu.sapi2.SapiJsCallBacks.SpeechRecognitionResult;
import com.baidu.sapi2.SapiWebView.AccountDestoryCallback.AccountDestoryResult;
import com.baidu.sapi2.SapiWebView.AccountFreezeCallback.AccountFreezeResult;
import com.baidu.sapi2.SapiWebView.BioScanFaceCallback.BioScanFaceResult;
import com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult;
import com.baidu.sapi2.SapiWebView.Command;
import com.baidu.sapi2.SapiWebView.CoverWebBdussResult;
import com.baidu.sapi2.SapiWebView.InvokeScAppCallback.InvokeScAppResult;
import com.baidu.sapi2.SapiWebView.LoadExternalWebViewResult;
import com.baidu.sapi2.SapiWebView.LoadSlideWebViewResult;
import com.baidu.sapi2.SapiWebView.PickPhotoResult;
import com.baidu.sapi2.SapiWebView.PreFillUserNameCallback.PreFillUserNameResult;
import com.baidu.sapi2.SapiWebView.QrLoginCallback;
import com.baidu.sapi2.SapiWebView.SwitchAccountCallback.Result;
import com.baidu.sapi2.SapiWebView.SystemUpwardSmsCallback;
import com.baidu.sapi2.SapiWebView.UpwardSmsCallback;
import com.baidu.sapi2.activity.SlideActiviy;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.b.h;
import com.baidu.sapi2.callback.GetContactCallback;
import com.baidu.sapi2.callback.RequestSMSCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.contact.utils.GetContactHelper;
import com.baidu.sapi2.dto.GetContactDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.outsdk.c.a;
import com.baidu.sapi2.permissions.AlertDialogInterface;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetContactResult;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.share.ShareStorage.StorageModel;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.g;
import com.baidubce.BceConfig;
import com.facebook.stetho.inspector.elements.android.TextViewDescriptor;
import com.tencent.open.SocialConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SapiJsInterpreters {

    /* renamed from: a reason: collision with root package name */
    public SapiWebView f2249a;

    /* renamed from: b reason: collision with root package name */
    public SapiConfiguration f2250b;

    /* renamed from: c reason: collision with root package name */
    public CallBacks f2251c;

    /* renamed from: d reason: collision with root package name */
    public Context f2252d;

    /* renamed from: e reason: collision with root package name */
    public HashMap<String, AbstractInterpreter> f2253e = new HashMap<>();

    /* renamed from: f reason: collision with root package name */
    public long f2254f;

    public abstract class AbstractInterpreter {
        public AbstractInterpreter() {
        }

        public abstract String interpret(Command command);
    }

    public class ActionBindWidgetPhoneNumberExist extends AbstractInterpreter {
        public ActionBindWidgetPhoneNumberExist() {
            super();
        }

        public String interpret(Command command) {
            String str = (String) command.getActionParams().get(0);
            if (SapiJsInterpreters.this.f2251c.f2246h != null) {
                SapiJsInterpreters.this.f2251c.f2246h.onPhoneNumberExist(str);
            }
            return null;
        }
    }

    public class ActionFaceLoginSwitch extends AbstractInterpreter {
        public ActionFaceLoginSwitch() {
            super();
        }

        public String interpret(Command command) {
            try {
                String optString = new JSONObject((String) command.getActionParams().get(0)).optString("livinguname");
                if (!TextUtils.isEmpty(optString)) {
                    new FaceLoginService().syncFaceLoginUID(SapiJsInterpreters.this.f2252d, optString);
                }
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return null;
        }
    }

    public class ActionForgetPwd extends AbstractInterpreter {
        public ActionForgetPwd() {
            super();
        }

        public String interpret(Command command) {
            return SapiJsInterpreters.this.f2251c.I != null ? SapiJsInterpreters.this.f2251c.I.onForgetPwd() : false ? "1" : "0";
        }
    }

    public class ActionGenerateSign extends AbstractInterpreter {
        public ActionGenerateSign() {
            super();
        }

        public String interpret(Command command) {
            String str = (String) command.getActionParams().get(0);
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    hashMap.put(str2, jSONObject.optString(str2));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return SapiUtils.calculateSig(hashMap, SapiJsInterpreters.this.f2250b.appSignKey);
        }
    }

    public class ActionGetLoadtime extends AbstractInterpreter {
        public ActionGetLoadtime() {
            super();
        }

        public String interpret(Command command) {
            SapiJsInterpreters.this.f2249a;
            if (SapiWebView.statLoadLogin == null) {
                return null;
            }
            SapiJsInterpreters.this.f2249a;
            return SapiWebView.statLoadLogin.a().toString();
        }
    }

    public class ActionGetSmsCheckCodeFromClip extends AbstractInterpreter {
        public ActionGetSmsCheckCodeFromClip() {
            super();
        }

        @TargetApi(11)
        public String interpret(Command command) {
            String str = "";
            try {
                ClipboardManager clipboardManager = (ClipboardManager) SapiJsInterpreters.this.f2252d.getSystemService("clipboard");
                if (clipboardManager.hasPrimaryClip()) {
                    str = SapiUtils.getSmsCheckCode(clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
                }
            } catch (Throwable th) {
                Log.e(th);
            }
            SapiStatUtil.statSmsCodeClip(SapiJsInterpreters.this.f2252d, TextUtils.isEmpty(str) ? "0" : "1");
            return str;
        }
    }

    public class ActionHuaweiLogin extends AbstractInterpreter {
        public ActionHuaweiLogin() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.f2239a != null) {
                Message message = new Message();
                message.what = SocialType.HUAWEI.getType();
                message.obj = SocialType.HUAWEI;
                SapiJsInterpreters.this.f2251c.f2239a.sendMessage(message);
            }
            return null;
        }
    }

    public class ActionJoinLogin extends AbstractInterpreter {
        public ActionJoinLogin() {
            super();
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0064 A[Catch:{ Exception -> 0x00ef }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0065 A[Catch:{ Exception -> 0x00ef }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00c4 A[Catch:{ Exception -> 0x00ef }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String interpret(com.baidu.sapi2.SapiWebView.Command r8) {
            /*
                r7 = this;
                java.lang.String r8 = "name"
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                com.baidu.sapi2.SapiJsInterpreters r1 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00ef }
                android.content.Context r1 = r1.f2252d     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsInterpreters r2 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00ef }
                android.content.Context r2 = r2.f2252d     // Catch:{ Exception -> 0x00ef }
                java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x00ef }
                java.lang.String[] r1 = com.baidu.sapi2.utils.SapiUtils.getPkgIconAndName(r1, r2)     // Catch:{ Exception -> 0x00ef }
                java.lang.String r2 = "icon"
                r3 = 0
                r3 = r1[r3]     // Catch:{ Exception -> 0x00ef }
                r0.put(r2, r3)     // Catch:{ Exception -> 0x00ef }
                r2 = 1
                r1 = r1[r2]     // Catch:{ Exception -> 0x00ef }
                r0.put(r8, r1)     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.share.SapiShareClient r1 = com.baidu.sapi2.share.SapiShareClient.getInstance()     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsInterpreters r2 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiConfiguration r2 = r2.f2250b     // Catch:{ Exception -> 0x00ef }
                android.content.Context r2 = r2.context     // Catch:{ Exception -> 0x00ef }
                java.util.List r1 = r1.getShareStorageModel(r2)     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsInterpreters r2 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r2 = r2.f2251c     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiWebView$ShareAccountClickCallback r2 = r2.s     // Catch:{ Exception -> 0x00ef }
                java.lang.String r3 = "false"
                java.lang.String r4 = "openShareLogin"
                if (r2 == 0) goto L_0x0055
                if (r1 == 0) goto L_0x0055
                int r1 = r1.size()     // Catch:{ Exception -> 0x00ef }
                if (r1 <= 0) goto L_0x0055
                java.lang.String r1 = "true"
                r0.put(r4, r1)     // Catch:{ Exception -> 0x00ef }
                goto L_0x0058
            L_0x0055:
                r0.put(r4, r3)     // Catch:{ Exception -> 0x00ef }
            L_0x0058:
                java.lang.String r1 = "hasThirdAccount"
                com.baidu.sapi2.SapiJsInterpreters r2 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r2 = r2.f2251c     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsCallBacks$JoinLoginParams r2 = r2.V     // Catch:{ Exception -> 0x00ef }
                if (r2 != 0) goto L_0x0065
                goto L_0x0080
            L_0x0065:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ef }
                r2.<init>()     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsInterpreters r3 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r3 = r3.f2251c     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsCallBacks$JoinLoginParams r3 = r3.V     // Catch:{ Exception -> 0x00ef }
                boolean r3 = r3.hasThirdAccount     // Catch:{ Exception -> 0x00ef }
                r2.append(r3)     // Catch:{ Exception -> 0x00ef }
                java.lang.String r3 = ""
                r2.append(r3)     // Catch:{ Exception -> 0x00ef }
                java.lang.String r3 = r2.toString()     // Catch:{ Exception -> 0x00ef }
            L_0x0080:
                r0.put(r1, r3)     // Catch:{ Exception -> 0x00ef }
                java.lang.String r1 = "supportFaceLogin"
                com.baidu.sapi2.share.face.FaceLoginService r2 = new com.baidu.sapi2.share.face.FaceLoginService     // Catch:{ Exception -> 0x00ef }
                r2.<init>()     // Catch:{ Exception -> 0x00ef }
                boolean r2 = r2.isSupFaceLogin()     // Catch:{ Exception -> 0x00ef }
                r0.put(r1, r2)     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsInterpreters r1 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r1 = r1.f2251c     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsCallBacks$JoinLoginParams r1 = r1.V     // Catch:{ Exception -> 0x00ef }
                if (r1 == 0) goto L_0x00f3
                com.baidu.sapi2.SapiJsInterpreters r1 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r1 = r1.f2251c     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsCallBacks$JoinLoginParams r1 = r1.V     // Catch:{ Exception -> 0x00ef }
                java.util.LinkedHashMap<java.lang.String, java.lang.String> r1 = r1.agreement     // Catch:{ Exception -> 0x00ef }
                if (r1 == 0) goto L_0x00f3
                org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x00ef }
                r1.<init>()     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsInterpreters r2 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r2 = r2.f2251c     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsCallBacks$JoinLoginParams r2 = r2.V     // Catch:{ Exception -> 0x00ef }
                java.util.LinkedHashMap<java.lang.String, java.lang.String> r2 = r2.agreement     // Catch:{ Exception -> 0x00ef }
                java.util.Set r2 = r2.keySet()     // Catch:{ Exception -> 0x00ef }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x00ef }
            L_0x00be:
                boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x00ef }
                if (r3 == 0) goto L_0x00e9
                java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x00ef }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x00ef }
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00ef }
                r4.<init>()     // Catch:{ Exception -> 0x00ef }
                r4.put(r8, r3)     // Catch:{ Exception -> 0x00ef }
                java.lang.String r5 = "url"
                com.baidu.sapi2.SapiJsInterpreters r6 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r6 = r6.f2251c     // Catch:{ Exception -> 0x00ef }
                com.baidu.sapi2.SapiJsCallBacks$JoinLoginParams r6 = r6.V     // Catch:{ Exception -> 0x00ef }
                java.util.LinkedHashMap<java.lang.String, java.lang.String> r6 = r6.agreement     // Catch:{ Exception -> 0x00ef }
                java.lang.Object r3 = r6.get(r3)     // Catch:{ Exception -> 0x00ef }
                r4.put(r5, r3)     // Catch:{ Exception -> 0x00ef }
                r1.put(r4)     // Catch:{ Exception -> 0x00ef }
                goto L_0x00be
            L_0x00e9:
                java.lang.String r8 = "agreement"
                r0.put(r8, r1)     // Catch:{ Exception -> 0x00ef }
                goto L_0x00f3
            L_0x00ef:
                r8 = move-exception
                com.baidu.sapi2.utils.Log.e(r8)
            L_0x00f3:
                java.lang.String r8 = r0.toString()
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiJsInterpreters.ActionJoinLogin.interpret(com.baidu.sapi2.SapiWebView$Command):java.lang.String");
        }
    }

    public class ActionLoadExternalWebview extends AbstractInterpreter {
        public ActionLoadExternalWebview() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.f2247i != null) {
                LoadExternalWebViewResult loadExternalWebViewResult = new LoadExternalWebViewResult();
                loadExternalWebViewResult.defaultTitle = (String) command.getActionParams().get(0);
                loadExternalWebViewResult.externalUrl = (String) command.getActionParams().get(1);
                SapiJsInterpreters.this.f2251c.f2247i.loadExternalWebview(loadExternalWebViewResult);
            }
            return null;
        }
    }

    public class ActionLoadSlideWebview extends AbstractInterpreter {
        public ActionLoadSlideWebview() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.x != null) {
                LoadSlideWebViewResult loadSlideWebViewResult = new LoadSlideWebViewResult();
                try {
                    JSONObject jSONObject = new JSONObject((String) command.getActionParams().get(0));
                    loadSlideWebViewResult.placeholderTitle = jSONObject.optString("placeholderTitle");
                    loadSlideWebViewResult.url = jSONObject.optString("url");
                    loadSlideWebViewResult.page = jSONObject.optString("page");
                    SapiJsInterpreters.this.f2251c.x.loadSlideWebview(loadSlideWebViewResult);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("errno", "0");
                    return jSONObject2.toString();
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            return null;
        }
    }

    public class ActionReceivedSmsCode extends AbstractInterpreter {
        public ActionReceivedSmsCode() {
            super();
        }

        public String interpret(Command command) {
            SapiJsInterpreters.this.f2249a.a((Handler) SapiJsInterpreters.this.f2251c.f2240b);
            SapiJsInterpreters.this.f2251c.f2240b.f2455a = (String) command.getActionParams().get(0);
            SapiJsInterpreters.this.f2251c.f2240b.f2456b = (String) command.getActionParams().get(1);
            SapiJsInterpreters.this.f2251c.f2240b.postDelayed(SapiJsInterpreters.this.f2251c.P, 15000);
            return null;
        }
    }

    public class ActionRemoveShareAccount extends AbstractInterpreter {
        public ActionRemoveShareAccount() {
            super();
        }

        public String interpret(Command command) {
            String str = (String) command.getActionParams().get(0);
            if (!TextUtils.isEmpty(str)) {
                Iterator it = SapiAccountManager.getInstance().getShareAccounts().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SapiAccount sapiAccount = (SapiAccount) it.next();
                    if (str.equals(sapiAccount.uid)) {
                        SapiShareClient.getInstance().invalidate(sapiAccount);
                        break;
                    }
                }
            }
            return null;
        }
    }

    public class ActionSetTitle extends AbstractInterpreter {
        public ActionSetTitle() {
            super();
        }

        public String interpret(Command command) {
            String str = (String) command.getActionParams().get(0);
            if (SapiJsInterpreters.this.f2251c.f2241c != null) {
                SapiJsInterpreters.this.f2251c.f2241c.onTitleChange(str);
            }
            return null;
        }
    }

    public class ActionShareAccountsViewBtnClicked extends AbstractInterpreter {
        public ActionShareAccountsViewBtnClicked() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.f2245g != null) {
                SapiJsInterpreters.this.f2251c.f2245g.handleOtherLogin();
            }
            return null;
        }
    }

    public class ActionShareClickOther extends AbstractInterpreter {
        public ActionShareClickOther() {
            super();
        }

        public String interpret(Command command) {
            SapiStatUtil.statShareClickOther((String) command.getActionParams().get(0), SapiJsInterpreters.this.f2249a.extras);
            return null;
        }
    }

    public class ActionShareV1AccountClick extends AbstractInterpreter {
        public ActionShareV1AccountClick() {
            super();
        }

        public String interpret(Command command) {
            String str = (String) command.getActionParams().get(0);
            List shareAccounts = SapiAccountManager.getInstance().getShareAccounts();
            String str2 = "";
            String str3 = str2;
            int i2 = 0;
            for (int i3 = 0; i3 < shareAccounts.size(); i3++) {
                if (str.equals(((SapiAccount) shareAccounts.get(i3)).uid)) {
                    String shareAccountTpl = ((SapiAccount) shareAccounts.get(i3)).getShareAccountTpl();
                    str3 = ((SapiAccount) shareAccounts.get(i3)).app;
                    str2 = shareAccountTpl;
                    i2 = i3;
                }
            }
            SapiStatUtil.statShareV1AccountClick(i2, str2, str3, SapiJsInterpreters.this.f2249a.extras);
            return null;
        }
    }

    public class ActionShareV2Login extends AbstractInterpreter {
        public ActionShareV2Login() {
            super();
        }

        public String interpret(Command command) {
            return SapiJsInterpreters.this.f2251c.aa.pageParams.toString();
        }
    }

    public class ActionShareV2LoginClick extends AbstractInterpreter {
        public ActionShareV2LoginClick() {
            super();
        }

        public String interpret(Command command) {
            SapiJsInterpreters.this.f2251c.aa.onSuccess();
            return null;
        }
    }

    public class ActionShareV2LoginFail extends AbstractInterpreter {
        public ActionShareV2LoginFail() {
            super();
        }

        public String interpret(Command command) {
            SapiJsInterpreters.this.f2251c.aa.onError();
            return null;
        }
    }

    public class ActionSocialMeizuSso extends AbstractInterpreter {
        public ActionSocialMeizuSso() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.f2239a != null) {
                Message message = new Message();
                message.what = SocialType.MEIZU.getType();
                message.obj = SocialType.MEIZU;
                SapiJsInterpreters.this.f2251c.f2239a.sendMessage(message);
            }
            return null;
        }
    }

    public class ActionSocialQqSso extends AbstractInterpreter {
        public ActionSocialQqSso() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.f2239a != null) {
                Message message = new Message();
                message.what = SocialType.QQ_SSO.getType();
                message.obj = SocialType.QQ_SSO;
                SapiJsInterpreters.this.f2251c.f2239a.sendMessage(message);
            }
            return null;
        }
    }

    public class ActionSocialSinaSso extends AbstractInterpreter {
        public ActionSocialSinaSso() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.f2239a != null) {
                Message message = new Message();
                message.what = SocialType.SINA_WEIBO_SSO.getType();
                message.obj = SocialType.SINA_WEIBO_SSO;
                SapiJsInterpreters.this.f2251c.f2239a.sendMessage(message);
            }
            return null;
        }
    }

    public class ActionSocialWeixinSso extends AbstractInterpreter {
        public ActionSocialWeixinSso() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.f2239a != null) {
                Message message = new Message();
                message.what = SocialType.WEIXIN.getType();
                message.obj = SocialType.WEIXIN;
                SapiJsInterpreters.this.f2251c.f2239a.sendMessage(message);
            }
            return null;
        }
    }

    public class ActionStopSlideWebview extends AbstractInterpreter {
        public ActionStopSlideWebview() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.F != null) {
                boolean z = false;
                try {
                    z = new JSONObject((String) command.getActionParams().get(0)).optBoolean("isStop");
                } catch (Exception e2) {
                    Log.e(e2);
                }
                SapiJsInterpreters.this.f2251c.F.onStopSlide(z);
            }
            return null;
        }
    }

    public class AddressManageGetContact extends AbstractInterpreter {
        public AddressManageGetContact() {
            super();
        }

        public String interpret(Command command) {
            GetContactDTO getContactDTO = new GetContactDTO();
            getContactDTO.context = SapiJsInterpreters.this.f2249a.getContext();
            GetContactHelper.getInstance().requestContact(getContactDTO, new GetContactCallback() {
                public AlertDialogInterface getDialog(Activity activity) {
                    return SapiJsInterpreters.this.f2251c.K.buildDialog(activity);
                }

                public void onCall(GetContactResult getContactResult) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("name", getContactResult.name);
                        jSONObject.put(SapiAccount.f2185e, getContactResult.phone);
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                    SapiJsInterpreters.this.f2251c.Q.confirm(jSONObject.toString());
                }
            });
            return null;
        }
    }

    public class AddressManageGetPasteboard extends AbstractInterpreter {
        public AddressManageGetPasteboard() {
            super();
        }

        public String interpret(Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                ClipboardManager clipboardManager = (ClipboardManager) SapiJsInterpreters.this.f2252d.getSystemService("clipboard");
                if (clipboardManager.hasPrimaryClip()) {
                    jSONObject.put("paste", clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
                }
            } catch (Throwable th) {
                Log.e(th);
            }
            return jSONObject.toString();
        }
    }

    public class AddressManageSelectedAddress extends AbstractInterpreter {
        public AddressManageSelectedAddress() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.L != null && command.getActionParams().size() > 0) {
                SapiJsInterpreters.this.f2251c.L.onCallback((String) command.getActionParams().get(0));
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }

    public class AuthorizedResponse extends AbstractInterpreter {
        public AuthorizedResponse() {
            super();
        }

        public String interpret(Command command) {
            String str = (String) command.getActionParams().get(0);
            int parseInt = command.getActionParams().size() >= 2 ? Integer.parseInt((String) command.getActionParams().get(1)) : 0;
            Object obj = command.getActionParams().size() >= 3 ? (String) command.getActionParams().get(2) : null;
            if (parseInt == 1) {
                SocialResponse b2 = SapiWebView.b(str, SapiJsInterpreters.this.f2252d);
                if (b2 == null) {
                    if (SapiJsInterpreters.this.f2251c.I != null) {
                        SapiJsInterpreters.this.f2249a.post(new Runnable() {
                            public void run() {
                                if (SapiJsInterpreters.this.f2251c.I != null) {
                                    SapiJsInterpreters.this.f2251c.I.onFailed(-100, Web2NativeLoginResult.ERROR_MSG_UNKNOWN);
                                }
                            }
                        });
                    }
                } else if (b2.offlineNotice || b2.bindGuide || b2.errorCode == 21 || b2.bindConflict) {
                    SapiJsInterpreters.this.f2251c.U = b2;
                } else {
                    SapiJsInterpreters.this.f2249a.a(b2);
                }
            }
            if (parseInt == 0) {
                final SapiAccountResponse a2 = SapiJsInterpreters.this.f2249a.a(str, SapiJsInterpreters.this.f2252d);
                if (a2 != null) {
                    int i2 = a2.errorCode;
                    if (i2 == 0 || i2 == 110000) {
                        SapiJsInterpreters.this.f2249a.a(a2);
                        if (SapiWebView.SWITCH_ACCOUNT_PAGE.equals(obj)) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("errno", 0);
                            } catch (JSONException e2) {
                                Log.e(e2);
                            }
                            return jSONObject.toString();
                        }
                    } else if (SapiJsInterpreters.this.f2251c.I != null) {
                        SapiJsInterpreters.this.f2249a.post(new Runnable() {
                            public void run() {
                                if (SapiJsInterpreters.this.f2251c.I != null) {
                                    AuthorizationListener authorizationListener = SapiJsInterpreters.this.f2251c.I;
                                    SapiAccountResponse sapiAccountResponse = a2;
                                    authorizationListener.onFailed(sapiAccountResponse.errorCode, sapiAccountResponse.errorMsg);
                                }
                            }
                        });
                    }
                } else if (SapiJsInterpreters.this.f2251c.I != null) {
                    SapiJsInterpreters.this.f2249a.post(new Runnable() {
                        public void run() {
                            if (SapiJsInterpreters.this.f2251c.I != null) {
                                SapiJsInterpreters.this.f2251c.I.onFailed(-100, Web2NativeLoginResult.ERROR_MSG_UNKNOWN);
                            }
                        }
                    });
                }
            }
            return null;
        }
    }

    public class Back extends AbstractInterpreter {
        public Back() {
            super();
        }

        public String interpret(Command command) {
            SapiJsInterpreters.this.f2249a.back();
            return null;
        }
    }

    public class ConfigFastloginFeatures extends AbstractInterpreter {
        public ConfigFastloginFeatures() {
            super();
        }

        public String interpret(Command command) {
            List<FastLoginFeature> fastLoginFeatureList = SapiJsInterpreters.this.f2251c.w != null ? SapiJsInterpreters.this.f2251c.w.getFastLoginFeatureList() : null;
            if (fastLoginFeatureList == null) {
                fastLoginFeatureList = SapiJsInterpreters.this.f2250b.fastLoginFeatureList;
            }
            if (fastLoginFeatureList == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (SapiContext.getInstance().isHostsHijacked()) {
                return sb.toString();
            }
            for (int i2 = 0; i2 < fastLoginFeatureList.size(); i2++) {
                FastLoginFeature fastLoginFeature = (FastLoginFeature) fastLoginFeatureList.get(i2);
                if (i2 == 0) {
                    sb.append(fastLoginFeature.getStrValue());
                } else {
                    sb.append(",");
                    sb.append(fastLoginFeature.getStrValue());
                }
            }
            return sb.toString();
        }
    }

    public class ConfigLoginShareStrategy extends AbstractInterpreter {
        public ConfigLoginShareStrategy() {
            super();
        }

        public String interpret(Command command) {
            return SapiJsInterpreters.this.f2250b.loginShareStrategy().getStrValue();
        }
    }

    public class CurrentAccountBdussExpired extends AbstractInterpreter {
        public CurrentAccountBdussExpired() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.E != null) {
                SapiJsInterpreters.this.f2251c.E.onBdussExpired();
            }
            return null;
        }
    }

    public class CurrentPageName extends AbstractInterpreter {
        public CurrentPageName() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.G != null) {
                try {
                    SapiJsInterpreters.this.f2251c.G.getCurrentPageName(new JSONObject((String) command.getActionParams().get(0)).optString("name"));
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
            return null;
        }
    }

    public class Finish extends AbstractInterpreter {
        public Finish() {
            super();
        }

        public String interpret(Command command) {
            SapiJsInterpreters.this.f2249a.a(SapiJsInterpreters.this.f2251c.U);
            if (command.getActionParams().size() > 0) {
                try {
                    SapiJsInterpreters.this.f2249a.finish(new JSONObject((String) command.getActionParams().get(0)).optString("page"));
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            } else {
                SapiJsInterpreters.this.f2249a.finish();
            }
            if (SapiJsInterpreters.this.f2251c.A != null) {
                SapiJsInterpreters.this.f2251c.A.onFinish(command.getActionParams().size() > 0 ? (String) command.getActionParams().get(0) : "");
            }
            return null;
        }
    }

    public class GetAllClientAccounts extends AbstractInterpreter {
        public GetAllClientAccounts() {
            super();
        }

        public String interpret(Command command) {
            String str = "http://";
            String str2 = "canshare2Accounts";
            JSONObject jSONObject = new JSONObject();
            boolean z = false;
            try {
                jSONObject.put("errno", 0);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            List<SapiAccount> touchidAccounts = SapiContext.getInstance().getTouchidAccounts();
            try {
                JSONArray jSONArray = new JSONArray();
                if (h.a(SapiJsInterpreters.this.f2250b) == 0) {
                    z = true;
                }
                for (SapiAccount sapiAccount : touchidAccounts) {
                    JSONObject jSONObject2 = sapiAccount.toJSONObject();
                    if (!TextUtils.isEmpty(sapiAccount.phone) && sapiAccount.phone.contains(str)) {
                        sapiAccount.phone = sapiAccount.phone.replace(str, "https://");
                    }
                    jSONObject2.put(SapiAccount.SAPI_ACCOUNT_PORTRAIT, sapiAccount.phone);
                    String str3 = "1";
                    String str4 = "touchCode";
                    if (!z) {
                        jSONObject2.put(str4, str3);
                    } else {
                        if (!TextUtils.isEmpty(sapiAccount.email)) {
                            str3 = "0";
                        }
                        jSONObject2.put(str4, str3);
                    }
                    jSONObject2.remove(SapiAccount.f2185e);
                    jSONObject2.remove(SapiAccount.SAPI_ACCOUNT_EXTRA);
                    jSONObject2.remove("app");
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("fingerAccounts", jSONArray);
            } catch (Exception e3) {
                Log.e(e3);
            }
            try {
                jSONObject.put("onekeyAccounts", new c().b());
            } catch (Exception e4) {
                Log.e(e4);
            }
            try {
                jSONObject.put("faceAccounts", SapiContext.getInstance().getV2FaceLoginCheckResults());
            } catch (Exception e5) {
                Log.e(e5);
            }
            try {
                List shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(SapiJsInterpreters.this.f2250b.context);
                JSONArray jSONArray2 = StorageModel.toJSONArray(shareStorageModel);
                if (jSONArray2 != null) {
                    jSONObject.put(str2, jSONArray2);
                    SapiStatUtil.statShareV2Open(shareStorageModel, null, SapiJsInterpreters.this.f2249a.extras);
                }
            } catch (Exception e6) {
                Log.e(e6);
            }
            try {
                if (!jSONObject.has(str2)) {
                    List shareAccounts = SapiAccountManager.getInstance().getShareAccounts();
                    JSONArray jSONArray3 = SapiAccount.toJSONArray(shareAccounts);
                    if (jSONArray3 != null) {
                        jSONObject.put("canshare1Accounts", jSONArray3);
                        SapiStatUtil.statShareV1OpenPage(shareAccounts, SapiJsInterpreters.this.f2249a.extras);
                    }
                }
            } catch (Exception e7) {
                Log.e(e7);
            }
            try {
                jSONObject.put("recentLoginUid", SapiContext.getInstance().getDecryptStr(SapiContext.KEY_LAST_LOGIN_UID));
            } catch (JSONException e8) {
                Log.e(e8);
            }
            return jSONObject.toString();
        }
    }

    public class GetCurrentAccountInfo extends AbstractInterpreter {
        public GetCurrentAccountInfo() {
            super();
        }

        public String interpret(Command command) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            JSONObject jSONObject = new JSONObject();
            if (currentAccount != null) {
                try {
                    currentAccount.portrait = currentAccount.getCompletePortrait();
                    jSONObject.put("currentAccount", currentAccount.toJSONObject());
                    jSONObject.put("errno", 0);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            return null;
        }
    }

    public class GetPresetPhoneNumber extends AbstractInterpreter {
        public GetPresetPhoneNumber() {
            super();
        }

        public String interpret(Command command) {
            String str = "";
            if (SapiJsInterpreters.this.f2250b.forbidPresetPhoneNumber) {
                return str;
            }
            if (SapiUtils.isValidPhoneNumber(SapiJsInterpreters.this.f2250b.presetPhoneNumber)) {
                return SapiJsInterpreters.this.f2250b.presetPhoneNumber;
            }
            String localPhoneNumber = SapiJsInterpreters.this.f2249a.getLocalPhoneNumber();
            if (SapiUtils.isValidPhoneNumber(localPhoneNumber)) {
                str = localPhoneNumber;
            }
            return str;
        }
    }

    public class GrantWebLogin extends AbstractInterpreter {
        public GrantWebLogin() {
            super();
        }

        public String interpret(Command command) {
            try {
                int optInt = new JSONObject((String) command.getActionParams().get(0)).optInt("type");
                if (SapiJsInterpreters.this.f2251c.D != null) {
                    SapiJsInterpreters.this.f2251c.D.onGrant(optInt);
                }
            } catch (Exception e2) {
                Log.e(e2);
            }
            return null;
        }
    }

    public class InvoiceBuildSelectedInvoice extends AbstractInterpreter {
        public InvoiceBuildSelectedInvoice() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.M != null && command.getActionParams().size() > 0) {
                SapiJsInterpreters.this.f2251c.M.onCallback((String) command.getActionParams().get(0));
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }

    public class NormalizeGuestAccount extends AbstractInterpreter {
        public NormalizeGuestAccount() {
            super();
        }

        public String interpret(Command command) {
            String str = SapiResult.ERROR_MSG_UNKNOWN;
            try {
                boolean z = false;
                JSONObject jSONObject = new JSONObject((String) command.getActionParams().get(0));
                int optInt = jSONObject.optInt("errno");
                String optString = jSONObject.optString("msg");
                if (optInt == 0) {
                    if (jSONObject.optInt("merge") == 1) {
                        z = true;
                    }
                    String optString2 = jSONObject.optString("normalizeWay");
                    SapiAccountResponse a2 = SapiJsInterpreters.this.f2249a.a(jSONObject.optString("xml"), SapiJsInterpreters.this.f2252d);
                    if (a2 != null) {
                        SapiAccount b2 = SapiJsInterpreters.this.f2249a.b(a2);
                        if (!SapiUtils.isValidAccount(b2)) {
                            SapiJsInterpreters.this.f2251c.z.onFailure(-202, str);
                            return null;
                        }
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        if (currentAccount != null) {
                            b2.addSocialInfo(currentAccount.getSocialType(), currentAccount.getSocialPortrait());
                        }
                        SapiAccountManager.getInstance().removeLoginAccount(currentAccount);
                        SapiAccountManager.getInstance().validate(b2);
                        if (SapiJsInterpreters.this.f2251c.z != null) {
                            SapiJsInterpreters.this.f2251c.z.onSuccess(z, optString2);
                        }
                    } else if (SapiJsInterpreters.this.f2251c.z != null) {
                        SapiJsInterpreters.this.f2251c.z.onFailure(NormalizeGuestAccountResult.ERROR_CODE_PARSE_XML, NormalizeGuestAccountResult.ERROR_MSG_PARSE_XML);
                    }
                } else if (SapiJsInterpreters.this.f2251c.z != null) {
                    SapiJsInterpreters.this.f2251c.z.onFailure(optInt, optString);
                }
            } catch (JSONException e2) {
                Log.e(e2);
                if (SapiJsInterpreters.this.f2251c.z != null) {
                    SapiJsInterpreters.this.f2251c.z.onFailure(-202, str);
                }
            }
            return null;
        }
    }

    public class NormalizeGuestDescription extends AbstractInterpreter {
        public NormalizeGuestDescription() {
            super();
        }

        public String interpret(Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                if (!TextUtils.isEmpty(SapiJsInterpreters.this.f2251c.W)) {
                    jSONObject.put(SocialConstants.PARAM_COMMENT, new JSONObject(SapiJsInterpreters.this.f2251c.W));
                }
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    public class OauthCallBaidu extends AbstractInterpreter {
        public OauthCallBaidu() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.Z != null) {
                SapiJsInterpreters.this.f2251c.Z.callback.onCallback((String) command.getActionParams().get(0));
            }
            return null;
        }
    }

    public class OauthSsoHash extends AbstractInterpreter {
        public OauthSsoHash() {
            super();
        }

        public String interpret(Command command) {
            SapiAccountManager.getInstance().getAccountService().generateSsoHash(new SsoHashCallback() {
                public void onSuccess(SsoHashResult ssoHashResult) {
                    SapiJsInterpreters.this.f2251c.Q.confirm(ssoHashResult.ssoHash);
                }
            }, SapiJsInterpreters.this.f2251c.Z.callingPkg, SapiJsInterpreters.this.f2251c.Z.callingAppId);
            return null;
        }
    }

    public class RealNameVerifySucceed extends AbstractInterpreter {
        public RealNameVerifySucceed() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.n != null) {
                SapiJsInterpreters.this.f2251c.n.onSuccess();
            }
            return null;
        }
    }

    public class SapiActionAccountCenterFastloginFeatures extends AbstractInterpreter {
        public SapiActionAccountCenterFastloginFeatures() {
            super();
        }

        public String interpret(Command command) {
            ArrayList arrayList = new ArrayList();
            if (SapiJsInterpreters.this.f2250b.fastLoginFeatureList == null || SapiJsInterpreters.this.f2250b.fastLoginFeatureList.isEmpty()) {
                return null;
            }
            arrayList.addAll(SapiJsInterpreters.this.f2250b.fastLoginFeatureList);
            if (arrayList.isEmpty()) {
                return null;
            }
            arrayList.remove(FastLoginFeature.MEIZU_SSO);
            arrayList.remove(FastLoginFeature.SINA_WEIBO_SSO);
            arrayList.remove(FastLoginFeature.TX_QQ_SSO);
            arrayList.remove(FastLoginFeature.HUAWEI_LOGIN);
            arrayList.remove(FastLoginFeature.TX_WEIXIN_SSO);
            StringBuilder sb = new StringBuilder();
            if (SapiContext.getInstance().isHostsHijacked()) {
                return sb.toString();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                FastLoginFeature fastLoginFeature = (FastLoginFeature) arrayList.get(i2);
                if (i2 == 0) {
                    sb.append(fastLoginFeature.getStrValue());
                } else {
                    sb.append(",");
                    sb.append(fastLoginFeature.getStrValue());
                }
            }
            return sb.toString();
        }
    }

    public class SapiActionAccountDestroy extends AbstractInterpreter {
        public SapiActionAccountDestroy() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.q != null) {
                SapiJsInterpreters.this.f2251c.q.onAccountDestory(new AccountDestoryResult());
            }
            SapiJsInterpreters.this.f2249a.finish();
            return null;
        }
    }

    public class SapiActionAccountFreeze extends AbstractInterpreter {
        public SapiActionAccountFreeze() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.r != null) {
                SapiJsInterpreters.this.f2251c.r.onAccountFreeze(new AccountFreezeResult());
            }
            return null;
        }
    }

    public class SapiActionBdussChanged extends AbstractInterpreter {
        public SapiActionBdussChanged() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.k != null) {
                SapiJsInterpreters.this.f2251c.k.onBdussChange();
            } else {
                SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback() {
                    public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
                    }

                    public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
                    }

                    public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                    }

                    public void onFinish() {
                    }

                    public void onStart() {
                    }

                    public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                    }
                }, true);
            }
            new b().a(b.f3032i);
            return null;
        }
    }

    public class SapiActionCheckLoginStatus extends AbstractInterpreter {
        public SapiActionCheckLoginStatus() {
            super();
        }

        public String interpret(Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (SapiJsInterpreters.this.f2251c.C != null) {
                    jSONObject.put("sup", true);
                }
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    public class SapiActionCheckMethodSupport extends AbstractInterpreter {
        public SapiActionCheckMethodSupport() {
            super();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
            if (com.baidu.sapi2.SapiJsInterpreters.b(r4.f2312b).supportFaceLogin != false) goto L_0x0077;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
            if (com.baidu.sapi2.SapiJsInterpreters.a(r4.f2312b).v != null) goto L_0x0077;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
            if (com.baidu.sapi2.SapiJsInterpreters.b(r4.f2312b).supportFaceLogin != false) goto L_0x0077;
         */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x007a  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String interpret(com.baidu.sapi2.SapiWebView.Command r5) {
            /*
                r4 = this;
                java.util.List r5 = r5.getActionParams()
                r0 = 0
                java.lang.Object r5 = r5.get(r0)
                java.lang.String r5 = (java.lang.String) r5
                com.baidu.sapi2.SapiJsInterpreters r1 = com.baidu.sapi2.SapiJsInterpreters.this
                java.lang.String r1 = r1.c(r5)
                r2 = 1
                java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0017 }
                r1 = r2
                goto L_0x0018
            L_0x0017:
                r1 = r0
            L_0x0018:
                java.lang.String r3 = "sapi_biometrics_identification_with_uid"
                boolean r3 = r5.equals(r3)
                if (r3 == 0) goto L_0x0035
                com.baidu.sapi2.SapiJsInterpreters r5 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r5 = r5.f2251c
                com.baidu.sapi2.SapiWebView$BioScanFaceCallback r5 = r5.f2242d
                if (r5 == 0) goto L_0x0078
                com.baidu.sapi2.SapiJsInterpreters r5 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiConfiguration r5 = r5.f2250b
                boolean r5 = r5.supportFaceLogin
                if (r5 == 0) goto L_0x0078
                goto L_0x0077
            L_0x0035:
                java.lang.String r3 = "sapi_biometrics_identification"
                boolean r3 = r5.equals(r3)
                if (r3 != 0) goto L_0x0063
                java.lang.String r3 = "sapi_biometrics_identification_no_bduss"
                boolean r3 = r5.equals(r3)
                if (r3 != 0) goto L_0x0063
                java.lang.String r3 = "sapi_biometrics_identification_with_authtoken"
                boolean r3 = r5.equals(r3)
                if (r3 == 0) goto L_0x004e
                goto L_0x0063
            L_0x004e:
                java.lang.String r3 = "sapi_action_sc_app_check"
                boolean r5 = r5.equals(r3)
                if (r5 == 0) goto L_0x0061
                com.baidu.sapi2.SapiJsInterpreters r5 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r5 = r5.f2251c
                com.baidu.sapi2.SapiWebView$InvokeScAppCallback r5 = r5.v
                if (r5 == 0) goto L_0x0078
                goto L_0x0077
            L_0x0061:
                r0 = r1
                goto L_0x0078
            L_0x0063:
                com.baidu.sapi2.SapiJsInterpreters r5 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r5 = r5.f2251c
                com.baidu.sapi2.SapiWebView$BiometricsIdentifyCallback r5 = r5.f2243e
                if (r5 == 0) goto L_0x0078
                com.baidu.sapi2.SapiJsInterpreters r5 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiConfiguration r5 = r5.f2250b
                boolean r5 = r5.supportFaceLogin
                if (r5 == 0) goto L_0x0078
            L_0x0077:
                r0 = r2
            L_0x0078:
                if (r0 == 0) goto L_0x007d
                java.lang.String r5 = "1"
                goto L_0x007f
            L_0x007d:
                java.lang.String r5 = "0"
            L_0x007f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiJsInterpreters.SapiActionCheckMethodSupport.interpret(com.baidu.sapi2.SapiWebView$Command):java.lang.String");
        }
    }

    public class SapiActionChinaMobileOauth extends AbstractInterpreter {
        public SapiActionChinaMobileOauth() {
            super();
        }

        public String interpret(Command command) {
            new c().a(SapiJsInterpreters.this.f2250b, (a) new a() {
                public void onGetTokenComplete(JSONObject jSONObject) {
                    SapiJsInterpreters.this.f2251c.Q.confirm(jSONObject.toString());
                }
            });
            return null;
        }
    }

    public class SapiActionCoverWebBduss extends AbstractInterpreter {
        public SapiActionCoverWebBduss() {
            super();
        }

        public String interpret(Command command) {
            String cookieBduss = SapiUtils.getCookieBduss();
            if (SapiJsInterpreters.this.f2251c.o != null) {
                SapiJsInterpreters.this.f2251c.o.onCoverBduss(cookieBduss, new CoverWebBdussResult() {
                    public void setWebBduss(String str) {
                        SapiJsInterpreters.this.f2249a.a(SapiJsInterpreters.this.f2252d, str);
                        SapiJsInterpreters.this.f2249a.reload();
                    }
                });
            }
            return null;
        }
    }

    public class SapiActionDeliverParams extends AbstractInterpreter {
        public SapiActionDeliverParams() {
            super();
        }

        public String interpret(Command command) {
            try {
                JSONObject jSONObject = new JSONObject((String) command.getActionParams().get(0));
                String optString = jSONObject.optString("username");
                boolean equals = jSONObject.optString(LivenessStat.TYPE_VOICE_CLOSE, "0").equals("1");
                PreFillUserNameResult preFillUserNameResult = new PreFillUserNameResult();
                preFillUserNameResult.userName = optString;
                if (SapiJsInterpreters.this.f2251c.p != null) {
                    SapiJsInterpreters.this.f2251c.p.onPreFillUserName(preFillUserNameResult);
                }
                if (equals) {
                    SapiJsInterpreters.this.f2249a.finish();
                }
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return null;
        }
    }

    public class SapiActionDirectedLogin extends AbstractInterpreter {
        public SapiActionDirectedLogin() {
            super();
        }

        public String interpret(Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("encryptedId", SapiJsInterpreters.this.f2251c.X.encryptedId);
                jSONObject.put("displayname", SapiJsInterpreters.this.f2251c.X.displayname);
                jSONObject.put("errno", 0);
            } catch (Exception e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    public class SapiActionGetAppTpl extends AbstractInterpreter {
        public SapiActionGetAppTpl() {
            super();
        }

        public String interpret(Command command) {
            return SapiJsInterpreters.this.f2250b.getTpl();
        }
    }

    public class SapiActionHandleBackButton extends AbstractInterpreter {
        public SapiActionHandleBackButton() {
            super();
        }

        public String interpret(Command command) {
            SapiJsInterpreters.this.f2251c.R = Integer.parseInt((String) command.getActionParams().get(0));
            if (SapiJsInterpreters.this.f2251c.m != null) {
                SapiJsInterpreters.this.f2251c.m.onLeftBtnVisible(SapiJsInterpreters.this.f2251c.R);
            }
            return null;
        }
    }

    public class SapiActionHideSuccessTip extends AbstractInterpreter {
        public SapiActionHideSuccessTip() {
            super();
        }

        public String interpret(Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("hideTip", SapiJsInterpreters.this.f2251c.Y ? "1" : "0");
                jSONObject.put("errno", 0);
            } catch (Exception e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    public class SapiActionLastLoginType extends AbstractInterpreter {
        public SapiActionLastLoginType() {
            super();
        }

        public String interpret(Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lastLoginType", SapiUtils.getLastLoginType());
                jSONObject.put("errno", 0);
            } catch (Exception e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    public class SapiActionLoginStatusChange extends AbstractInterpreter {
        public SapiActionLoginStatusChange() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.C != null) {
                SapiJsInterpreters.this.f2251c.C.onChange();
            }
            return null;
        }
    }

    public class SapiActionMiniDi extends AbstractInterpreter {
        public SapiActionMiniDi() {
            super();
        }

        public String interpret(Command command) {
            try {
                JSONArray optJSONArray = new JSONObject((String) command.getActionParams().get(0)).optJSONArray("di_keys");
                if (optJSONArray == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i2))) {
                        arrayList.add(optJSONArray.optString(i2));
                    }
                }
                return SapiDeviceInfo.getDiCookieInfo(arrayList, false);
            } catch (Exception e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    public class SapiActionPasteboardSet extends AbstractInterpreter {
        public SapiActionPasteboardSet() {
            super();
        }

        public String interpret(Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                String optString = new JSONObject((String) command.getActionParams().get(0)).optString(Config.LAUNCH_CONTENT);
                ((ClipboardManager) SapiJsInterpreters.this.f2252d.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(SlideActiviy.ADDRESS_PAGE_NAME, optString));
                jSONObject.put("errno", 0);
                return jSONObject.toString();
            } catch (Exception e2) {
                Log.e(e2);
                return jSONObject.toString();
            }
        }
    }

    public class SapiActionPickDate extends AbstractInterpreter {
        public SapiActionPickDate() {
            super();
        }

        @TargetApi(11)
        public String interpret(Command command) {
            String str = (String) command.getActionParams().get(0);
            Calendar instance = Calendar.getInstance();
            Date time = instance.getTime();
            try {
                instance.setTime(new SimpleDateFormat("yyyyMMdd").parse(str));
            } catch (Exception e2) {
                Log.e(e2);
            }
            int i2 = instance.get(1);
            int i3 = instance.get(2);
            int i4 = instance.get(5);
            instance.setTime(time);
            int i5 = instance.get(1);
            int i6 = instance.get(2);
            int i7 = instance.get(5);
            DatePickerDialog datePickerDialog = new DatePickerDialog(SapiJsInterpreters.this.f2252d, 3, new OnDateSetListener() {
                public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i2);
                    Object[] objArr = {Integer.valueOf(i3 + 1)};
                    String str = "%02d";
                    sb.append(String.format(str, objArr));
                    sb.append(String.format(str, new Object[]{Integer.valueOf(i4)}));
                    sb.append("");
                    SapiJsInterpreters.this.f2251c.Q.confirm(sb.toString());
                }
            }, i2, i3, i4);
            datePickerDialog.setOnCancelListener(new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    SapiJsInterpreters.this.f2251c.Q.confirm("");
                }
            });
            datePickerDialog.setTitle("");
            int i8 = i7;
            DatePickerDialog datePickerDialog2 = datePickerDialog;
            instance.set(i5, i6, i8, 23, 59, 59);
            datePickerDialog2.getDatePicker().setMaxDate(instance.getTimeInMillis());
            instance.set(i5 - 100, i6, i8, 0, 0, 0);
            datePickerDialog2.getDatePicker().setMinDate(instance.getTimeInMillis());
            datePickerDialog2.show();
            datePickerDialog2.setCustomTitle(null);
            return null;
        }
    }

    public class SapiActionPickImage extends AbstractInterpreter {
        public SapiActionPickImage() {
            super();
        }

        public String interpret(Command command) {
            int i2 = 0;
            try {
                i2 = Integer.parseInt((String) command.getActionParams().get(0));
            } catch (Exception e2) {
                Log.e(e2);
            }
            int i3 = 512;
            int i4 = 1;
            if (command.getActionParams().size() > 1) {
                try {
                    JSONObject jSONObject = new JSONObject((String) command.getActionParams().get(1));
                    i4 = jSONObject.optInt("sence", 1);
                    i3 = jSONObject.optInt("size", 512);
                } catch (JSONException e3) {
                    Log.e(e3);
                }
            }
            SapiJsInterpreters.this.f2251c.f2248j.onPickImage(i2, i4, i3, new PickPhotoResult() {
                public void setImageData(String str) {
                    if (SapiJsInterpreters.this.f2251c.Q != null) {
                        SapiJsInterpreters.this.f2251c.Q.confirm(str);
                    }
                }
            });
            return null;
        }
    }

    public class SapiActionQrLogin extends AbstractInterpreter {
        public SapiActionQrLogin() {
            super();
        }

        public String interpret(Command command) {
            boolean z = false;
            try {
                JSONObject jSONObject = new JSONObject((String) command.getActionParams().get(0));
                if (SapiJsInterpreters.this.f2251c.t != null) {
                    int optInt = jSONObject.optInt("relogin", -1);
                    if (optInt == 1) {
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        String optString = jSONObject.optString("bduss");
                        String optString2 = jSONObject.optString(SapiAccount.f2187g);
                        if (currentAccount != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            currentAccount.bduss = optString;
                            currentAccount.ptoken = optString2;
                            currentAccount.deleteStokens();
                            SapiAccountManager.getInstance().validate(currentAccount);
                            SapiAccountManager.getInstance().preFetchStoken(currentAccount, true);
                        }
                    }
                    QrLoginCallback qrLoginCallback = SapiJsInterpreters.this.f2251c.t;
                    if (optInt == 1) {
                        z = true;
                    }
                    qrLoginCallback.loginStatusChange(z);
                }
                if (SapiJsInterpreters.this.f2251c.S) {
                    SapiJsInterpreters.this.f2249a.finish();
                }
            } catch (Exception e2) {
                Log.e(e2);
            }
            return null;
        }
    }

    public class SapiActionRealname extends AbstractInterpreter {
        public SapiActionRealname() {
            super();
        }

        public String interpret(Command command) {
            try {
                JSONObject jSONObject = new JSONObject((String) command.getActionParams().get(0));
                AccountRealNameResult accountRealNameResult = new AccountRealNameResult();
                int optInt = jSONObject.optInt("status");
                accountRealNameResult.callbackkey = jSONObject.optString("callbackKey");
                if (SapiJsInterpreters.this.f2251c.B != null) {
                    if (optInt == 1) {
                        accountRealNameResult.juniorRealNameSuc = true;
                    } else if (optInt == 2) {
                        accountRealNameResult.seniorRealNameSuc = true;
                    }
                    SapiJsInterpreters.this.f2251c.B.onFinish(accountRealNameResult);
                }
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return null;
        }
    }

    public class SapiActionScAppCheck extends AbstractInterpreter {
        public SapiActionScAppCheck() {
            super();
        }

        public String interpret(Command command) {
            try {
                JSONObject jSONObject = new JSONObject((String) command.getActionParams().get(0));
                jSONObject.optString("action");
                String optString = jSONObject.optString("minver");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(WXLoginActivity.KEY_BASE_RESP_STATE, new com.baidu.sapi2.a.a().a(SapiJsInterpreters.this.f2252d, optString, SapiJsInterpreters.this.f2251c.v));
                return jSONObject2.toString();
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }
    }

    public class SapiActionScAppInvoke extends AbstractInterpreter {
        public SapiActionScAppInvoke() {
            super();
        }

        public String interpret(Command command) {
            String str = "action";
            try {
                JSONObject jSONObject = new JSONObject((String) command.getActionParams().get(0));
                String optString = jSONObject.optString(str);
                String optString2 = jSONObject.optString("minver");
                ArrayList arrayList = new ArrayList();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    if (!str2.equals(str)) {
                        arrayList.add(new PassNameValuePair(str2, jSONObject.optString(str2)));
                    }
                }
                SapiJsInterpreters.this.f2251c.v.onInvokeScApp(optString, optString2, arrayList, new InvokeScAppResult() {
                    public void setInvokeResult(String str) {
                        SapiJsInterpreters.this.f2251c.Q.confirm(str);
                    }
                });
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return null;
        }
    }

    public class SapiActionSwitchAccount extends AbstractInterpreter {
        public SapiActionSwitchAccount() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.l != null) {
                List actionParams = command.getActionParams();
                Result result = new Result();
                if (actionParams != null && actionParams.size() > 0) {
                    if (actionParams.size() > 1) {
                        try {
                            JSONObject jSONObject = new JSONObject((String) command.getActionParams().get(1));
                            result.extraJson = jSONObject.optString("extrajson");
                            result.displayName = jSONObject.getString("displayname");
                            result.encryptedUid = jSONObject.getString("uid");
                            result.loginType = jSONObject.getInt("type");
                            result.switchAccountType = 2;
                            SapiJsInterpreters.this.f2251c.l.onAccountSwitch(result);
                            return null;
                        } catch (JSONException e2) {
                            Log.e(e2);
                        }
                    } else {
                        result.userName = (String) actionParams.get(0);
                        result.switchAccountType = 1;
                        SapiJsInterpreters.this.f2251c.l.onAccountSwitch(result);
                        return null;
                    }
                }
                result.switchAccountType = 0;
                SapiJsInterpreters.this.f2251c.l.onAccountSwitch(result);
            }
            return null;
        }
    }

    public class SapiActionUpdateNavigator extends AbstractInterpreter {
        public SapiActionUpdateNavigator() {
            super();
        }

        public String interpret(Command command) {
            int parseInt = Integer.parseInt((String) command.getActionParams().get(0));
            if (SapiJsInterpreters.this.f2251c.J != null) {
                SapiJsInterpreters.this.f2251c.J.pageState(parseInt);
            }
            return null;
        }
    }

    public class SapiActionUpsms extends AbstractInterpreter {
        public SapiActionUpsms() {
            super();
        }

        public String interpret(Command command) {
            SendUpwardSms sendUpwardSms = new SendUpwardSms((String) command.getActionParams().get(0), (String) command.getActionParams().get(1), (String) command.getActionParams().get(2), (String) command.getActionParams().get(3), new UpwardSmsCallback() {
                public void onResult(boolean z, boolean z2, boolean z3) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("with_permision", z);
                        jSONObject.put("send_suc", z2);
                        jSONObject.put("cancel", z3);
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                    SapiJsInterpreters.this.f2251c.Q.confirm(jSONObject.toString());
                }
            });
            sendUpwardSms.c();
            return null;
        }
    }

    public class SapiBiometricsIdentification extends AbstractInterpreter {
        public SapiBiometricsIdentification() {
            super();
        }

        public String interpret(Command command) {
            AnonymousClass1 r0 = new BiometricsIdentifyResult() {
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.f2251c.Q != null) {
                        SapiJsInterpreters.this.f2251c.Q.confirm(str);
                    }
                }
            };
            r0.biometricType = Integer.parseInt((String) command.getActionParams().get(0));
            r0.livenessRecogType = "bduss";
            r0.recordVideo = 0;
            String str = "pp";
            r0.subPro = str;
            if (command.getActionParams().size() > 1) {
                r0.recordVideo = Integer.parseInt((String) command.getActionParams().get(1));
            }
            if (command.getActionParams().size() > 2) {
                r0.subPro = ((String) command.getActionParams().get(2)).toString();
            }
            if (command.getActionParams().size() > 3) {
                try {
                    r0.showGuidePage = 1 - new JSONObject((String) command.getActionParams().get(3)).optInt("hideGuidePage", 0);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            if (!TextUtils.isEmpty(r0.subPro)) {
                str = r0.subPro;
            }
            r0.subPro = str;
            if (SapiJsInterpreters.this.f2251c.f2243e != null) {
                SapiJsInterpreters.this.f2251c.f2243e.onBiometricsIdentify(r0);
            }
            return null;
        }
    }

    public class SapiBiometricsIdentificationNoBduss extends AbstractInterpreter {
        public SapiBiometricsIdentificationNoBduss() {
            super();
        }

        public String interpret(Command command) {
            AnonymousClass1 r0 = new BiometricsIdentifyResult() {
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.f2251c.Q != null) {
                        SapiJsInterpreters.this.f2251c.Q.confirm(str);
                    }
                }
            };
            r0.biometricType = Integer.parseInt((String) command.getActionParams().get(0));
            r0.livenessRecogType = "certinfo";
            r0.realName = (String) command.getActionParams().get(1);
            r0.idCardNum = (String) command.getActionParams().get(2);
            r0.recordVideo = 0;
            r0.phoneNum = "";
            if (command.getActionParams().size() > 3) {
                r0.recordVideo = Integer.parseInt((String) command.getActionParams().get(3));
            }
            if (command.getActionParams().size() > 4) {
                r0.phoneNum = (String) command.getActionParams().get(4);
            }
            String str = "pp";
            r0.subPro = str;
            if (command.getActionParams().size() > 5) {
                r0.subPro = (String) command.getActionParams().get(5);
            }
            if (command.getActionParams().size() > 6) {
                try {
                    r0.showGuidePage = 1 - new JSONObject((String) command.getActionParams().get(6)).optInt("hideGuidePage", 0);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            if (!TextUtils.isEmpty(r0.subPro)) {
                str = r0.subPro;
            }
            r0.subPro = str;
            if (SapiJsInterpreters.this.f2251c.f2243e != null) {
                SapiJsInterpreters.this.f2251c.f2243e.onBiometricsIdentify(r0);
            }
            return null;
        }
    }

    public class SapiBiometricsIdentificationWithAuthtoken extends AbstractInterpreter {
        public SapiBiometricsIdentificationWithAuthtoken() {
            super();
        }

        public String interpret(Command command) {
            AnonymousClass1 r0 = new BiometricsIdentifyResult() {
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.f2251c.Q != null) {
                        SapiJsInterpreters.this.f2251c.Q.confirm(str);
                    }
                }
            };
            r0.biometricType = Integer.parseInt((String) command.getActionParams().get(0));
            r0.livenessRecogType = "authtoken";
            r0.authToken = (String) command.getActionParams().get(1);
            r0.recordVideo = 0;
            String str = "pp";
            r0.subPro = str;
            if (command.getActionParams().size() > 2) {
                r0.recordVideo = Integer.parseInt((String) command.getActionParams().get(2));
            }
            if (command.getActionParams().size() > 3) {
                r0.subPro = ((String) command.getActionParams().get(3)).toString();
            }
            if (command.getActionParams().size() > 4) {
                try {
                    r0.showGuidePage = 1 - new JSONObject((String) command.getActionParams().get(4)).optInt("hideGuidePage", 0);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            if (!TextUtils.isEmpty(r0.subPro)) {
                str = r0.subPro;
            }
            r0.subPro = str;
            if (SapiJsInterpreters.this.f2251c.f2243e != null) {
                SapiJsInterpreters.this.f2251c.f2243e.onBiometricsIdentify(r0);
            }
            return null;
        }
    }

    public class SapiBiometricsIdentificationWithUid extends AbstractInterpreter {
        public SapiBiometricsIdentificationWithUid() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2251c.f2242d == null) {
                return null;
            }
            AnonymousClass1 r0 = new BioScanFaceResult() {
                public void setScanFaceIdentifyResult(String str) {
                    SapiJsInterpreters.this.f2251c.Q.confirm(str);
                }
            };
            try {
                JSONObject jSONObject = new JSONObject((String) command.getActionParams().get(0));
                r0.uid = jSONObject.optString("uid");
                r0.type = jSONObject.optInt("type");
                r0.subpro = jSONObject.optString("subpro");
                r0.showGuidePage = 1 - jSONObject.optInt("hideGuidePage", 0);
                if (TextUtils.isEmpty(r0.subpro)) {
                    r0.subpro = "pp";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("transParams");
                if (optJSONObject != null) {
                    Iterator keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        r0.transParamsMap.put(str, optJSONObject.optString(str));
                    }
                }
                SapiJsInterpreters.this.f2251c.f2242d.onBioScanFace(r0);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return null;
        }
    }

    public class SapiGoBack extends AbstractInterpreter {
        public SapiGoBack() {
            super();
        }

        public String interpret(Command command) {
            if (SapiJsInterpreters.this.f2249a.canGoBack()) {
                SapiJsInterpreters.this.f2249a.goBack();
            } else {
                SapiJsInterpreters.this.f2249a.finish();
            }
            return null;
        }
    }

    public class SapiRemoveLoginHistory extends AbstractInterpreter {
        public SapiRemoveLoginHistory() {
            super();
        }

        public String interpret(Command command) {
            String str = ".";
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                JSONObject jSONObject2 = new JSONObject((String) command.getActionParams().get(0));
                String optString = jSONObject2.optString("portraitSign");
                if (!TextUtils.isEmpty(optString)) {
                    SapiContext.getInstance().removeTouchidAccountByPortrait(optString);
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray(FaceLoginService.f2922c);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    SapiContext.getInstance().markAsDeleteFaceLogin(optJSONArray);
                }
                String optString2 = jSONObject2.optString(SapiAccount.SAPI_ACCOUNT_PORTRAIT);
                if (!TextUtils.isEmpty(optString2)) {
                    String[] split = optString2.split(BceConfig.BOS_DELIMITER);
                    String str2 = split[split.length - 1];
                    if (str2.contains(str)) {
                        str2 = str2.substring(0, str2.lastIndexOf(str));
                    }
                    SapiContext.getInstance().markAsDeleteShareLogin(str2);
                }
                String optString3 = jSONObject2.optString("uid");
                if (!TextUtils.isEmpty(optString3)) {
                    Iterator it = SapiAccountManager.getInstance().getShareAccounts().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        SapiAccount sapiAccount = (SapiAccount) it.next();
                        if (optString3.equals(sapiAccount.uid)) {
                            SapiShareClient.getInstance().invalidate(sapiAccount);
                            break;
                        }
                    }
                }
            } catch (Exception e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    public class SapiShareAccountClick extends AbstractInterpreter {
        public SapiShareAccountClick() {
            super();
        }

        public String interpret(Command command) {
            if (System.currentTimeMillis() - SapiJsInterpreters.this.f2254f > 1000) {
                SapiJsInterpreters.this.f2254f = System.currentTimeMillis();
                try {
                    JSONObject jSONObject = new JSONObject((String) command.getActionParams().get(0));
                    String optString = jSONObject.optString("pkg");
                    String optString2 = jSONObject.optString("url");
                    String optString3 = jSONObject.optString("trace_id");
                    String optString4 = jSONObject.optString("session_id");
                    SapiJsInterpreters.this.f2251c.Q.confirm("finish");
                    SapiJsInterpreters.this.f2251c.s.onClick(optString, optString2, optString3, optString4);
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
            return null;
        }
    }

    public class SendUpwardSms {

        /* renamed from: a reason: collision with root package name */
        public static final String f2351a = "收不到短信验证码?";

        /* renamed from: b reason: collision with root package name */
        public static final String f2352b = "我们邀请您发送一条短信至百度账号后台（10698000036592）以验证您的身份，预计花费0.1元短信费用";

        /* renamed from: c reason: collision with root package name */
        public static final String f2353c = "确定";

        /* renamed from: d reason: collision with root package name */
        public static final String f2354d = "发送上行短信";

        /* renamed from: e reason: collision with root package name */
        public static final String f2355e = "10698000036592";

        /* renamed from: f reason: collision with root package name */
        public static final String f2356f = "SENT_SMS_ACTION";

        /* renamed from: g reason: collision with root package name */
        public String f2357g;

        /* renamed from: h reason: collision with root package name */
        public String f2358h;

        /* renamed from: i reason: collision with root package name */
        public String f2359i;

        /* renamed from: j reason: collision with root package name */
        public String f2360j;
        public UpwardSmsCallback k;
        public boolean l;
        public boolean m;
        public Runnable n;
        public BroadcastReceiver o;

        /* access modifiers changed from: private */
        public void d() {
            if (SapiJsInterpreters.this.f2251c.u != null) {
                AnonymousClass6 r0 = new SystemUpwardSmsCallback.Result() {
                    public void onFinish() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("with_permision", false);
                            jSONObject.put("send_suc", false);
                            jSONObject.put("cancel", false);
                        } catch (JSONException e2) {
                            Log.e(e2);
                        }
                        if (SapiJsInterpreters.this.f2251c.Q != null) {
                            SapiJsInterpreters.this.f2251c.Q.confirm(jSONObject.toString());
                        }
                        SendUpwardSms sendUpwardSms = SendUpwardSms.this;
                        sendUpwardSms.k.onResult(sendUpwardSms.l, sendUpwardSms.m, false);
                    }
                };
                r0.content = this.f2358h;
                r0.destination = this.f2357g;
                SapiJsInterpreters.this.f2251c.u.onResult(r0);
            }
        }

        /* access modifiers changed from: private */
        public void e() {
            if (this.o != null) {
                try {
                    SapiJsInterpreters.this.f2252d.unregisterReceiver(this.o);
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
        }

        public SendUpwardSms(String str, String str2, String str3, String str4, UpwardSmsCallback upwardSmsCallback) {
            this.l = false;
            this.m = false;
            this.n = new Runnable() {
                public void run() {
                    SendUpwardSms.this.e();
                    SendUpwardSms.this.d();
                }
            };
            this.o = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    SapiJsInterpreters.this.f2249a.removeCallbacks(SendUpwardSms.this.n);
                    SendUpwardSms.this.e();
                    if (getResultCode() == -1) {
                        SendUpwardSms sendUpwardSms = SendUpwardSms.this;
                        sendUpwardSms.l = true;
                        sendUpwardSms.m = true;
                        sendUpwardSms.k.onResult(true, true, false);
                        return;
                    }
                    SendUpwardSms.this.d();
                }
            };
            if (TextUtils.isEmpty(str)) {
                this.f2357g = f2355e;
            } else {
                this.f2357g = str;
            }
            if (TextUtils.isEmpty(str2)) {
                this.f2358h = f2354d;
            } else {
                this.f2358h = str2;
            }
            if (TextUtils.isEmpty(str3)) {
                this.f2359i = f2351a;
            } else {
                this.f2359i = str3;
            }
            if (TextUtils.isEmpty(str4)) {
                this.f2360j = f2352b;
            } else {
                this.f2360j = str4;
            }
            this.k = upwardSmsCallback;
        }

        private String b() {
            return this.f2360j;
        }

        /* access modifiers changed from: private */
        public void c() {
            a();
        }

        @TargetApi(11)
        private void a() {
            Builder builder = new Builder(SapiJsInterpreters.this.f2252d, 3);
            builder.setTitle(this.f2359i);
            builder.setMessage(b());
            builder.setPositiveButton(f2353c, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SendUpwardSms.this.a((RequestSMSCallback) new RequestSMSCallback() {
                        public void sendSmsResult(boolean z) {
                            if (!z) {
                                SendUpwardSms.this.d();
                            }
                        }
                    });
                }
            });
            builder.setNegativeButton(SapiWebView.A, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SendUpwardSms.this.k.onResult(false, false, true);
                }
            });
            builder.setOnCancelListener(new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    SendUpwardSms.this.k.onResult(false, false, true);
                }
            });
            AlertDialog create = builder.create();
            if (!((Activity) SapiJsInterpreters.this.f2252d).isFinishing() && !create.isShowing()) {
                create.show();
            }
        }

        /* access modifiers changed from: private */
        public void a(RequestSMSCallback requestSMSCallback) {
            String str = f2356f;
            Intent intent = new Intent(str);
            intent.setPackage(SapiJsInterpreters.this.f2252d.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(SapiJsInterpreters.this.f2252d, 0, intent, 0);
            SapiJsInterpreters.this.f2252d.registerReceiver(this.o, new IntentFilter(str));
            g.a(SapiJsInterpreters.this.f2249a.getContext(), this.f2357g, this.f2358h, broadcast, null, requestSMSCallback);
        }
    }

    public class SpeechRecognitionGetContent extends AbstractInterpreter {
        public SpeechRecognitionGetContent() {
            super();
        }

        public String interpret(Command command) {
            SapiJsInterpreters.this.f2251c.y.onSpeechRecognition(new SpeechRecognitionResult() {
                public void setSpeechData(int i2, String str) {
                    if (SapiJsInterpreters.this.f2251c.Q != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errno", i2);
                            jSONObject.put(TextViewDescriptor.TEXT_ATTRIBUTE_NAME, str);
                            SapiJsInterpreters.this.f2251c.Q.confirm(jSONObject.toString());
                        } catch (JSONException e2) {
                            Log.e(e2);
                        }
                    }
                }
            });
            return null;
        }
    }

    public class SwitchAccountGetAccounts extends AbstractInterpreter {
        public SwitchAccountGetAccounts() {
            super();
        }

        public String interpret(Command command) {
            List<SapiAccount> list;
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            if (SapiJsInterpreters.this.f2250b.supportMultipleAccounts) {
                list = SapiContext.getInstance().getLoginAccounts();
            } else {
                arrayList.add(SapiContext.getInstance().getCurrentAccount());
                list = arrayList;
            }
            JSONArray jSONArray = new JSONArray();
            try {
                for (SapiAccount sapiAccount : list) {
                    JSONObject jSONObject2 = sapiAccount.toJSONObject();
                    jSONObject2.put(SapiAccount.SAPI_ACCOUNT_PORTRAIT, sapiAccount.getCompletePortrait());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("errno", 0);
                jSONObject.put("accountList", jSONArray);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    public class SwitchAccountGetConfig extends AbstractInterpreter {
        public SwitchAccountGetConfig() {
            super();
        }

        public String interpret(Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                jSONObject.put("showSwitchAccount", SapiJsInterpreters.this.f2249a.showSwitchAccount ? 1 : 0);
                jSONObject.put("showLinkAccount", SapiJsInterpreters.this.f2249a.showLinkAccount ? 1 : 0);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    public class SwitchAccountRemoveAccount extends AbstractInterpreter {
        public SwitchAccountRemoveAccount() {
            super();
        }

        public String interpret(Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                String optString = new JSONObject((String) command.getActionParams().get(0)).optString("uid");
                if (!TextUtils.isEmpty(optString)) {
                    for (SapiAccount sapiAccount : SapiContext.getInstance().getLoginAccounts()) {
                        if (optString.equals(sapiAccount.uid)) {
                            SapiAccountManager.getInstance().removeLoginAccount(sapiAccount);
                            jSONObject.put("errno", 0);
                            return jSONObject.toString();
                        }
                    }
                }
            } catch (Exception e2) {
                Log.e(e2);
            }
            return null;
        }
    }

    public class TouchidChangeStatus extends AbstractInterpreter {
        public TouchidChangeStatus() {
            super();
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String interpret(com.baidu.sapi2.SapiWebView.Command r6) {
            /*
                r5 = this;
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                java.lang.String r1 = "errno"
                r2 = 0
                r3 = 0
                r0.put(r1, r2)     // Catch:{ JSONException -> 0x0038 }
                java.lang.String r1 = "status"
                r0.put(r1, r2)     // Catch:{ JSONException -> 0x0038 }
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0038 }
                java.util.List r6 = r6.getActionParams()     // Catch:{ JSONException -> 0x0038 }
                java.lang.Object r6 = r6.get(r2)     // Catch:{ JSONException -> 0x0038 }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x0038 }
                r1.<init>(r6)     // Catch:{ JSONException -> 0x0038 }
                java.lang.String r6 = "handle"
                java.lang.String r6 = r1.optString(r6)     // Catch:{ JSONException -> 0x0038 }
                java.lang.String r2 = "portrait"
                java.lang.String r2 = r1.optString(r2)     // Catch:{ JSONException -> 0x0035 }
                java.lang.String r4 = "portraitSign"
                java.lang.String r1 = r1.optString(r4)     // Catch:{ JSONException -> 0x0033 }
                goto L_0x0040
            L_0x0033:
                r1 = move-exception
                goto L_0x003c
            L_0x0035:
                r1 = move-exception
                r2 = r3
                goto L_0x003c
            L_0x0038:
                r6 = move-exception
                r1 = r6
                r6 = r3
                r2 = r6
            L_0x003c:
                com.baidu.sapi2.utils.Log.e(r1)
                r1 = r3
            L_0x0040:
                com.baidu.sapi2.SapiContext r4 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.SapiAccount r4 = r4.getCurrentAccount()
                r4.phone = r2
                java.lang.String r2 = "open"
                boolean r6 = r2.equals(r6)
                if (r6 == 0) goto L_0x006f
                r4.email = r1
                com.baidu.sapi2.SapiJsInterpreters$TouchidChangeStatus$1 r6 = new com.baidu.sapi2.SapiJsInterpreters$TouchidChangeStatus$1
                r6.<init>(r0, r4)
                com.baidu.sapi2.SapiJsInterpreters r0 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r0 = r0.f2251c
                com.baidu.sapi2.SapiJsCallBacks$FingerprintCallback r0 = r0.N
                if (r0 == 0) goto L_0x006e
                com.baidu.sapi2.SapiJsInterpreters r0 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r0 = r0.f2251c
                com.baidu.sapi2.SapiJsCallBacks$FingerprintCallback r0 = r0.N
                r0.onCallback(r6)
            L_0x006e:
                return r3
            L_0x006f:
                java.lang.String r6 = ""
                r4.email = r6
                com.baidu.sapi2.SapiContext r6 = com.baidu.sapi2.SapiContext.getInstance()
                r6.addTouchidAccounts(r4)
                com.baidu.sapi2.SapiJsInterpreters r6 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r6 = r6.f2251c
                android.webkit.JsPromptResult r6 = r6.Q
                java.lang.String r0 = r0.toString()
                r6.confirm(r0)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiJsInterpreters.TouchidChangeStatus.interpret(com.baidu.sapi2.SapiWebView$Command):java.lang.String");
        }
    }

    public class TouchidCheckGuideStatus extends AbstractInterpreter {
        public TouchidCheckGuideStatus() {
            super();
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0077  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00db A[Catch:{ Exception -> 0x00e3 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String interpret(com.baidu.sapi2.SapiWebView.Command r9) {
            /*
                r8 = this;
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e3 }
                java.util.List r9 = r9.getActionParams()     // Catch:{ Exception -> 0x00e3 }
                r2 = 0
                java.lang.Object r9 = r9.get(r2)     // Catch:{ Exception -> 0x00e3 }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x00e3 }
                r1.<init>(r9)     // Catch:{ Exception -> 0x00e3 }
                java.lang.String r9 = "portraitSign"
                java.lang.String r9 = r1.optString(r9)     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiJsInterpreters r1 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiConfiguration r1 = r1.f2250b     // Catch:{ Exception -> 0x00e3 }
                int r1 = com.baidu.sapi2.b.h.a(r1)     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiContext r3 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ Exception -> 0x00e3 }
                java.util.List r3 = r3.getTouchidLoginRecord()     // Catch:{ Exception -> 0x00e3 }
                boolean r3 = r3.contains(r9)     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiContext r4 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ Exception -> 0x00e3 }
                java.util.List r4 = r4.getTouchidAccounts()     // Catch:{ Exception -> 0x00e3 }
                r5 = 1
                if (r4 == 0) goto L_0x005c
                java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00e3 }
            L_0x0040:
                boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x00e3 }
                if (r6 == 0) goto L_0x005c
                java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiAccount r6 = (com.baidu.sapi2.SapiAccount) r6     // Catch:{ Exception -> 0x00e3 }
                if (r6 == 0) goto L_0x0040
                java.lang.String r7 = r6.email     // Catch:{ Exception -> 0x00e3 }
                if (r7 == 0) goto L_0x0040
                java.lang.String r6 = r6.email     // Catch:{ Exception -> 0x00e3 }
                boolean r6 = r6.equals(r9)     // Catch:{ Exception -> 0x00e3 }
                if (r6 == 0) goto L_0x0040
                r4 = r5
                goto L_0x005d
            L_0x005c:
                r4 = r2
            L_0x005d:
                if (r1 != 0) goto L_0x0069
                boolean r6 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x00e3 }
                if (r6 != 0) goto L_0x0069
                if (r3 != 0) goto L_0x0069
                r6 = r5
                goto L_0x006a
            L_0x0069:
                r6 = r2
            L_0x006a:
                com.baidu.sapi2.SapiJsInterpreters r7 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiWebView r7 = r7.f2249a     // Catch:{ Exception -> 0x00e3 }
                boolean r7 = r7.supportTouchGuide     // Catch:{ Exception -> 0x00e3 }
                if (r7 != 0) goto L_0x0075
                r6 = r2
            L_0x0075:
                if (r4 == 0) goto L_0x0078
                r6 = r2
            L_0x0078:
                java.lang.String r7 = "errno"
                r0.put(r7, r2)     // Catch:{ Exception -> 0x00e3 }
                java.lang.String r2 = "guide"
                r0.put(r2, r6)     // Catch:{ Exception -> 0x00e3 }
                boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x00e3 }
                if (r2 == 0) goto L_0x008b
                java.lang.String r1 = "100"
                goto L_0x00cc
            L_0x008b:
                r2 = 101(0x65, float:1.42E-43)
                java.lang.String r7 = ""
                if (r1 == r2) goto L_0x00bd
                r2 = 102(0x66, float:1.43E-43)
                if (r1 != r2) goto L_0x0096
                goto L_0x00bd
            L_0x0096:
                if (r3 == 0) goto L_0x009b
                java.lang.String r1 = "103"
                goto L_0x00cc
            L_0x009b:
                com.baidu.sapi2.SapiJsInterpreters r2 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiWebView r2 = r2.f2249a     // Catch:{ Exception -> 0x00e3 }
                boolean r2 = r2.supportTouchGuide     // Catch:{ Exception -> 0x00e3 }
                if (r2 != 0) goto L_0x00a8
                java.lang.String r1 = "106"
                goto L_0x00cc
            L_0x00a8:
                if (r4 == 0) goto L_0x00ad
                java.lang.String r1 = "107"
                goto L_0x00cc
            L_0x00ad:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3 }
                r2.<init>()     // Catch:{ Exception -> 0x00e3 }
                r2.append(r1)     // Catch:{ Exception -> 0x00e3 }
                r2.append(r7)     // Catch:{ Exception -> 0x00e3 }
                java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x00e3 }
                goto L_0x00cc
            L_0x00bd:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3 }
                r2.<init>()     // Catch:{ Exception -> 0x00e3 }
                r2.append(r1)     // Catch:{ Exception -> 0x00e3 }
                r2.append(r7)     // Catch:{ Exception -> 0x00e3 }
                java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x00e3 }
            L_0x00cc:
                java.util.LinkedHashMap r2 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x00e3 }
                r2.<init>(r5)     // Catch:{ Exception -> 0x00e3 }
                java.lang.String r3 = "native_guide_finger"
                r2.put(r3, r1)     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.utils.t.a(r2)     // Catch:{ Exception -> 0x00e3 }
                if (r6 != r5) goto L_0x00e7
                com.baidu.sapi2.SapiContext r1 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ Exception -> 0x00e3 }
                r1.addTouchidLoginRecord(r9)     // Catch:{ Exception -> 0x00e3 }
                goto L_0x00e7
            L_0x00e3:
                r9 = move-exception
                com.baidu.sapi2.utils.Log.e(r9)
            L_0x00e7:
                java.lang.String r9 = r0.toString()
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiJsInterpreters.TouchidCheckGuideStatus.interpret(com.baidu.sapi2.SapiWebView$Command):java.lang.String");
        }
    }

    public class TouchidGetStatus extends AbstractInterpreter {
        public TouchidGetStatus() {
            super();
        }

        public String interpret(Command command) {
            boolean z;
            JSONObject jSONObject = new JSONObject();
            try {
                int i2 = 1;
                if (h.a(SapiJsInterpreters.this.f2250b) == 0) {
                    List touchidAccounts = SapiContext.getInstance().getTouchidAccounts();
                    SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                    Iterator it = touchidAccounts.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        SapiAccount sapiAccount = (SapiAccount) it.next();
                        if (sapiAccount.equals(currentAccount) && !TextUtils.isEmpty(sapiAccount.email)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        i2 = 2;
                    }
                } else {
                    i2 = 0;
                }
                jSONObject.put("errno", 0);
                jSONObject.put("status", i2);
            } catch (Exception e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    public class TouchidLogin extends AbstractInterpreter {
        public TouchidLogin() {
            super();
        }

        public String interpret(Command command) {
            AnonymousClass1 r2 = new FingerprintResult() {
                public void setResult(int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("status", i2);
                        SapiJsInterpreters.this.f2251c.Q.confirm(jSONObject.toString());
                    } catch (Exception e2) {
                        Log.e(e2);
                    }
                }
            };
            r2.authType = 3;
            if (SapiJsInterpreters.this.f2251c.N != null) {
                SapiJsInterpreters.this.f2251c.N.onCallback(r2);
            }
            return null;
        }
    }

    public class TouchidOpenGuide extends AbstractInterpreter {
        public TouchidOpenGuide() {
            super();
        }

        public String interpret(final Command command) {
            AnonymousClass1 r0 = new FingerprintResult() {
                public void setResult(int i2) {
                    String str = com.baidu.sapi2.utils.h.A;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("status", i2);
                        SapiJsInterpreters.this.f2251c.Q.confirm(jSONObject.toString());
                        if (i2 == 0) {
                            try {
                                JSONObject jSONObject2 = new JSONObject((String) command.getActionParams().get(0));
                                String optString = jSONObject2.optString(SapiAccount.SAPI_ACCOUNT_PORTRAIT);
                                String optString2 = jSONObject2.optString("portraitSign");
                                if (TextUtils.isEmpty(optString)) {
                                    String[] strArr = SapiJsInterpreters.this.f2251c.O;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(SapiJsInterpreters.this.f2250b.environment.getConfigHttpsUrl());
                                    sb.append(str);
                                    strArr[0] = sb.toString();
                                    String[] strArr2 = SapiJsInterpreters.this.f2249a.touchidPortraitAndSign;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(SapiJsInterpreters.this.f2250b.environment.getConfigHttpsUrl());
                                    sb2.append(str);
                                    strArr2[0] = sb2.toString();
                                } else {
                                    SapiJsInterpreters.this.f2251c.O[0] = optString;
                                    SapiJsInterpreters.this.f2249a.touchidPortraitAndSign[0] = optString;
                                }
                                SapiJsInterpreters.this.f2251c.O[1] = optString2;
                                SapiJsInterpreters.this.f2249a.touchidPortraitAndSign[1] = optString2;
                            } catch (Exception e2) {
                                Log.e(e2);
                            }
                        }
                    } catch (Exception e3) {
                        Log.e(e3);
                    }
                }
            };
            if (SapiJsInterpreters.this.f2251c.N != null) {
                SapiJsInterpreters.this.f2251c.N.onCallback(r0);
            }
            return null;
        }
    }

    public class UniteVerifyResult extends AbstractInterpreter {
        public UniteVerifyResult() {
            super();
        }

        public String interpret(Command command) {
            try {
                JSONObject jSONObject = new JSONObject((String) command.getActionParams().get(0));
                String optString = jSONObject.optString(Config.LAUNCH_INFO);
                String optString2 = jSONObject.optString("u");
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.uid = jSONObject.optString("passuid");
                sapiAccount.username = jSONObject.optString("username");
                sapiAccount.displayname = jSONObject.optString("displayname");
                sapiAccount.bduss = jSONObject.optString("bduss");
                sapiAccount.ptoken = jSONObject.optString(SapiAccount.f2187g);
                sapiAccount.stoken = jSONObject.optString(SapiAccount.f2188h);
                if (!TextUtils.isEmpty(optString) && SapiUtils.isValidAccount(sapiAccount) && SapiJsInterpreters.this.f2251c.f2244f != null) {
                    SapiJsInterpreters.this.f2251c.f2244f.onSuccess(optString, optString2, sapiAccount);
                }
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return null;
        }
    }

    public SapiJsInterpreters(SapiWebView sapiWebView, CallBacks callBacks) {
        this.f2249a = sapiWebView;
        this.f2252d = sapiWebView.getContext();
        this.f2251c = callBacks;
        this.f2250b = SapiAccountManager.getInstance().getSapiConfiguration();
    }

    private AbstractInterpreter b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (AbstractInterpreter) Class.forName(c(str)).getDeclaredConstructor(new Class[]{getClass()}).newInstance(new Object[]{this});
        } catch (Exception e2) {
            Log.e(e2);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String c(String str) {
        String[] split = str.split("_");
        StringBuilder a2 = e.a.a.a.a.a("com.baidu.sapi2.SapiJsInterpreters$");
        for (String charArray : split) {
            char[] charArray2 = charArray.toCharArray();
            if (charArray2[0] >= 'a' && charArray2[0] <= 'z') {
                charArray2[0] = (char) (charArray2[0] - ' ');
            }
            a2.append(new String(charArray2));
        }
        return a2.toString();
    }

    public AbstractInterpreter a(String str) {
        AbstractInterpreter abstractInterpreter = (AbstractInterpreter) this.f2253e.get(str);
        if (abstractInterpreter == null) {
            abstractInterpreter = b(str);
            if (abstractInterpreter != null) {
                this.f2253e.put(str, abstractInterpreter);
            }
        }
        return abstractInterpreter;
    }
}
