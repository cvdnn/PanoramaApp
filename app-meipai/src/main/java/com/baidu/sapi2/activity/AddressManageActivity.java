package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiJsCallBacks.GetCurrentPageNameCallback;
import com.baidu.sapi2.SapiJsCallBacks.SpeechRecognitionCallback;
import com.baidu.sapi2.SapiJsCallBacks.SpeechRecognitionResult;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.SapiWebView.OnNewBackCallback;
import com.baidu.sapi2.callback.AddressManageCallback;
import com.baidu.sapi2.callback.AddressManageCallback.VoiceRecognitionResult;
import com.baidu.sapi2.dto.AddressManageDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.permissions.AlertDialogInterface;
import com.baidu.sapi2.permissions.PassPermissions;
import com.baidu.sapi2.permissions.PermissionsCallback;
import com.baidu.sapi2.permissions.PermissionsDTO;
import com.baidu.sapi2.result.AddressManageResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.views.m;
import com.baidu.sapi2.views.o;
import e.a.a.a.a;
import e.c.c.a.d;
import e.c.c.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AddressManageActivity extends SlideActiviy {
    public static final String A = "AddressManageActivity";
    public static final String B = "AddressManageActivity";
    public static final String C = "select";
    public static final String D = "useSpeech";
    public AddressManageDTO E;
    public AddressManageCallback F;
    public AddressManageResult G = new AddressManageResult();
    public SpeechRecognitionResult H;
    public boolean I = true;
    public boolean J = false;

    /* access modifiers changed from: private */
    public void finishActivity() {
        AddressManageCallback addressManageCallback = this.F;
        if (addressManageCallback != null) {
            addressManageCallback.onFinish(this.G);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    /* access modifiers changed from: private */
    public void i() {
        final o oVar = new o(this);
        final m mVar = new m(this);
        this.F.onStartSpeech(new VoiceRecognitionResult() {
            public void onVoiceResult(String str) {
                AddressManageActivity.this.I = false;
                AddressManageActivity.this.H.setSpeechData(0, str);
                oVar.dismiss();
                if (mVar.isShowing()) {
                    mVar.dismiss();
                    AddressManageActivity.this.I = true;
                }
            }

            public void onVolumeResult(int i2) {
                oVar.a(i2);
            }
        });
        oVar.setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                AddressManageActivity.this.F.onStopSpeech();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (AddressManageActivity.this.I) {
                            mVar.show();
                        }
                        AddressManageActivity.this.I = true;
                    }
                }, 500);
            }
        });
        oVar.show();
    }

    public void configTitle() {
        if (PassportViewManager.getInstance().getTitleViewModule() != null) {
            configCustomTitle();
            return;
        }
        switchDarkmode();
        setBtnVisibility(4, 0, 4);
        setTitleDrawable(null, null, null, null);
        setLeftBtnDrawable(getResources().getDrawable(d.sapi_sdk_btn_back), null, null, null);
        if (this.configuration.showBottomBack) {
            setBtnVisibility(4, 4, 4);
        }
    }

    public void finishActivityAfterSlideOver() {
        if ("AddressManageActivity".equals(getClass().getSimpleName())) {
            this.G.setResultCode(-301);
            finishActivity();
            return;
        }
        super.finish();
    }

    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getAddressManageDTO();
    }

    public void init() {
        super.init();
        this.E = PassportSDK.getInstance().getAddressManageDTO();
        AddressManageCallback addressManageCallback = PassportSDK.getInstance().getAddressManageCallback();
        this.F = addressManageCallback;
        if (this.E == null || addressManageCallback == null) {
            this.G.setResultCode(-204);
            finishActivity();
            return;
        }
        addressManageCallback.activityOnCreate();
    }

    public void loadAddressUrl(List<PassNameValuePair> list) {
        this.sapiWebView.loadAddressManage(list);
    }

    public void onBottomBackBtnClick() {
        g();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(A, "AddressManageActivity onCreate");
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.G.setResultCode(-202);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(A, "AddressManageActivity onDestroy");
        AddressManageCallback addressManageCallback = this.F;
        if (addressManageCallback != null) {
            addressManageCallback.activityOnDestory();
        }
    }

    public void onLeftBtnClick() {
        g();
    }

    public void onPause() {
        super.onPause();
        Log.d(A, "AddressManageActivity onPause");
        AddressManageCallback addressManageCallback = this.F;
        if (addressManageCallback != null) {
            addressManageCallback.activityOnPause();
        }
    }

    public void onResume() {
        super.onResume();
        Log.d(A, "AddressManageActivity onResume");
        AddressManageCallback addressManageCallback = this.F;
        if (addressManageCallback != null) {
            addressManageCallback.activityOnResume();
        }
    }

    public void setupViews() {
        super.setupViews();
        configTitle();
        this.sapiWebView.setOnNewBackCallback(new OnNewBackCallback() {
            public boolean onBack() {
                AddressManageActivity.this.g();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                AddressManageActivity.this.G.setResultCode(-301);
                AddressManageActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setAddressManageCallback(new SapiJsCallBacks.AddressManageCallback() {
            public void onCallback(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        AddressManageActivity.this.G.map.put(str2, jSONObject.optString(str2));
                    }
                    AddressManageActivity.this.G.setResultCode(0);
                } catch (JSONException e2) {
                    Log.e(e2);
                    AddressManageActivity.this.G.setResultCode(-205);
                }
                AddressManageActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setSpeechRecognitionCallback(new SpeechRecognitionCallback() {
            public void onSpeechRecognition(SpeechRecognitionResult speechRecognitionResult) {
                AddressManageActivity.this.H = speechRecognitionResult;
                if (AddressManageActivity.this.F != null) {
                    if (SapiUtils.isMethodOverWrited(AddressManageActivity.this.F, "onStopSpeech", AddressManageCallback.class, new Class[0])) {
                        AddressManageActivity.this.h();
                        return;
                    }
                }
                AddressManageActivity.this.H.setSpeechData(1, "");
            }
        });
        this.sapiWebView.setGetCurrentPageNameCallback(new GetCurrentPageNameCallback() {
            public void getCurrentPageName(String str) {
                if (GetCurrentPageNameCallback.ADDRESS_EDIT_PAGE.equals(str)) {
                    AddressManageActivity.this.J = true;
                }
            }
        });
        ArrayList arrayList = new ArrayList(1);
        String str = "1";
        a.a(SlideActiviy.EXTRA_PARAMS_SLIDE_PAGE, str, arrayList);
        AddressManageDTO addressManageDTO = this.E;
        if (addressManageDTO != null) {
            arrayList.add(new PassNameValuePair("select", addressManageDTO.type));
            arrayList.add(new PassNameValuePair("tplse", this.E.tplse));
            arrayList.add(new PassNameValuePair("tplt", this.E.tplt));
            arrayList.add(new PassNameValuePair("pageName", this.E.openPageName));
            if (str.equals(this.E.openPageName)) {
                this.J = true;
            }
        }
        AddressManageCallback addressManageCallback = this.F;
        if (addressManageCallback != null) {
            if (SapiUtils.isMethodOverWrited(addressManageCallback, "onStartSpeech", AddressManageCallback.class, VoiceRecognitionResult.class)) {
                a.a(D, str, arrayList);
            }
        }
        loadAddressUrl(arrayList);
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.J) {
            this.sapiWebView.loadUrl(SapiWebView.FN_SWITCH_VIEW);
            return;
        }
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            this.G.setResultCode(-301);
            finishActivity();
            return;
        }
        this.sapiWebView.goBack();
    }

    /* access modifiers changed from: private */
    public void h() {
        PermissionsDTO permissionsDTO = this.E.permissionsDTO;
        if (permissionsDTO != null) {
            permissionsDTO.context = this;
            permissionsDTO.dialogTitle = TextUtils.isEmpty(permissionsDTO.dialogTitle) ? "权限申请" : permissionsDTO.dialogTitle;
            permissionsDTO.dialogMsg = TextUtils.isEmpty(permissionsDTO.dialogMsg) ? "为保证您正常地使用此功能，需要获取您的语音等使用权限，请允许" : permissionsDTO.dialogMsg;
            PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() {
                public AlertDialogInterface getDialog(Activity activity) {
                    return AddressManageActivity.this.F.getDialog(activity);
                }

                public void onFailure() {
                    AddressManageActivity.this.H.setSpeechData(1, "");
                }

                public void onSuccess() {
                    AddressManageActivity.this.i();
                }
            });
            return;
        }
        i();
        Log.d(A, "permissionsDTO is null");
    }
}
