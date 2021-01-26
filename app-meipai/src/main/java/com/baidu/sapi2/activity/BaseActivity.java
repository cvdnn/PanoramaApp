package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.ValueCallback;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.arashivision.graphicpath.render.source.ExtraMetadataKey;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiJsCallBacks.BuildCustomAlertDialog;
import com.baidu.sapi2.SapiJsCallBacks.FingerprintCallback;
import com.baidu.sapi2.SapiJsCallBacks.FingerprintResult;
import com.baidu.sapi2.SapiJsCallBacks.PageStateCallback;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.ActivityLifeCycle;
import com.baidu.sapi2.SapiWebView.BioScanFaceCallback;
import com.baidu.sapi2.SapiWebView.BioScanFaceCallback.BioScanFaceResult;
import com.baidu.sapi2.SapiWebView.BiometricsIdentifyCallback;
import com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult;
import com.baidu.sapi2.SapiWebView.FileChooserCallback;
import com.baidu.sapi2.SapiWebView.InvokeScAppCallback;
import com.baidu.sapi2.SapiWebView.InvokeScAppCallback.InvokeScAppResult;
import com.baidu.sapi2.SapiWebView.LocalConfigCallback;
import com.baidu.sapi2.SapiWebView.PickPhotoCallback;
import com.baidu.sapi2.SapiWebView.PickPhotoResult;
import com.baidu.sapi2.SapiWebView.WebViewTitleCallback;
import com.baidu.sapi2.a.a;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebLoginDTO.Config;
import com.baidu.sapi2.permissions.AlertDialogInterface;
import com.baidu.sapi2.permissions.PassPermissions;
import com.baidu.sapi2.permissions.PermissionsCallback;
import com.baidu.sapi2.permissions.PermissionsDTO;
import com.baidu.sapi2.provider.FileProvider;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.shell.listener.IScreenShotListener;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceUtils.DeviceCrypto;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.m;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.sapi2.views.CustomAlertDialog;
import com.baidu.sapi2.views.f;
import e.c.c.a.b;
import e.c.c.a.e;
import e.c.c.a.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseActivity extends TitleActivity {
    public static final String EXTRA_PARAM_BUSINESS_FROM = "extra_params_business_from";
    public static final int EXTRA_PARAM_FROM_ACCOUNT_CENTER = 2003;
    public static final int EXTRA_PARAM_FROM_CHOICE_SHARE = 2004;
    public static final int EXTRA_PARAM_FROM_GRANT_WAP = 2005;
    public static final int EXTRA_PARAM_FROM_LOGIN = 2001;
    public static final int EXTRA_PARAM_FROM_PASS_SDK_ENTER = 2002;
    public static final int REQUEST_CODE_FILECHOOSER = 1010;
    public static final int REQUEST_CODE_FILECHOOSER_FOR_ANDROID_5 = 1011;
    public static final int REQUEST_CODE_LOGIN = 1004;

    /* renamed from: b reason: collision with root package name */
    public static final String f2565b = "BaseActivity";

    /* renamed from: c reason: collision with root package name */
    public static final String f2566c = "javascript:(function(){if(window.Pass && window.Pass.client && window.Pass.client.screenShot){Pass.client.screenShot()}}())";

    /* renamed from: d reason: collision with root package name */
    public static final String f2567d = "camera_temp_image.jpg";

    /* renamed from: e reason: collision with root package name */
    public static final int f2568e = 1001;

    /* renamed from: f reason: collision with root package name */
    public static final int f2569f = 1002;

    /* renamed from: g reason: collision with root package name */
    public static final int f2570g = 1003;

    /* renamed from: h reason: collision with root package name */
    public ValueCallback<Uri> f2571h;

    /* renamed from: i reason: collision with root package name */
    public ValueCallback<Uri[]> f2572i;

    /* renamed from: j reason: collision with root package name */
    public PickPhotoResult f2573j;
    public BiometricsIdentifyResult k;
    public FingerprintResult l;
    public boolean loginStatusChange;
    public a m;
    public int n;
    public int o;
    public ImageCropResult p;
    public com.baidu.sapi2.shell.a.a q;
    public SapiWebView sapiWebView;

    public void initScreenShotManager() {
        com.baidu.sapi2.shell.a.a aVar = new com.baidu.sapi2.shell.a.a();
        this.q = aVar;
        aVar.a(getContentResolver(), (IScreenShotListener) new IScreenShotListener() {
            public void onScreenShot() {
                BaseActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        SapiWebView sapiWebView = BaseActivity.this.sapiWebView;
                        if (sapiWebView != null) {
                            sapiWebView.loadUrl(BaseActivity.f2566c);
                        }
                    }
                });
            }
        });
        this.q.a();
    }

    public void livenessRecognize(String str, BiometricsIdentifyResult biometricsIdentifyResult) {
        String str2;
        String str3;
        BiometricsIdentifyResult biometricsIdentifyResult2 = biometricsIdentifyResult;
        BiometricsManager instance = BiometricsManager.getInstance();
        PassFaceRecogType passFaceRecogType = PassFaceRecogType.RECOG_TYPE_BDUSS;
        if ("bduss".equals(biometricsIdentifyResult2.livenessRecogType)) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null) {
                str3 = "";
            } else {
                str3 = currentAccount.bduss;
            }
            str2 = str3;
        } else {
            if ("authtoken".equals(biometricsIdentifyResult2.livenessRecogType)) {
                passFaceRecogType = PassFaceRecogType.RECOG_TYPE_AUTHTOKEN;
            } else {
                if ("certinfo".equals(biometricsIdentifyResult2.livenessRecogType)) {
                    passFaceRecogType = PassFaceRecogType.RECOG_TYPE_CERTINFO;
                }
            }
            str2 = null;
        }
        BiometricsManager biometricsManager = instance;
        String str4 = str;
        biometricsManager.livenessRecognize(this, passFaceRecogType, biometricsIdentifyResult2.subPro, null, "0", str2, str4, biometricsIdentifyResult2.authToken, "", biometricsIdentifyResult2.realName, biometricsIdentifyResult2.idCardNum, biometricsIdentifyResult2.phoneNum, new PassFaceRecogCallback() {
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a2 = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), null, null);
                if (BaseActivity.this.k != null) {
                    BaseActivity.this.k.setIdentifyToken(a2.toString());
                }
            }

            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a2 = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), passFaceRecogResult.callbackkey, passFaceRecogResult.authSid);
                if (BaseActivity.this.k != null) {
                    BaseActivity.this.k.setIdentifyToken(a2.toString());
                }
            }
        });
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        ImageCropCallback imageCropCallback = PassportSDK.getInstance().getImageCropCallback();
        ActivityResultCallback activityResultCallback = PassportSDK.getInstance().getActivityResultCallback();
        if (imageCropCallback == null || activityResultCallback == null) {
            imageCropCallback = b();
            activityResultCallback = a();
        }
        ImageCropCallback imageCropCallback2 = imageCropCallback;
        if (activityResultCallback != null) {
            activityResultCallback.onActivityResult(i2, i3, intent);
        }
        if (i2 == 1010) {
            if (this.f2571h != null) {
                this.f2571h.onReceiveValue((intent == null || i3 != -1) ? null : intent.getData());
                this.f2571h = null;
            }
        } else if (i2 != 1011) {
            String str = "";
            if (i2 == 1001) {
                if (this.f2573j != null) {
                    if (i3 != -1 || imageCropCallback2 == null) {
                        this.f2573j.setImageData(str);
                    } else {
                        imageCropCallback2.onImageCrop(this, Uri.fromFile(new File(Environment.getExternalStorageDirectory(), f2567d)), this.n, this.o, new ImageCropResult() {
                            public void onImageResult(String str) {
                                if (str != null) {
                                    BaseActivity.this.f2573j.setImageData(str);
                                } else {
                                    BaseActivity.this.f2573j.setImageData("");
                                }
                            }
                        });
                    }
                }
            } else if (i2 == 1002) {
                if (this.f2573j != null) {
                    if (i3 != -1 || intent.getData() == null || imageCropCallback2 == null) {
                        this.f2573j.setImageData(str);
                    } else {
                        imageCropCallback2.onImageCrop(this, intent.getData(), this.n, this.o, new ImageCropResult() {
                            public void onImageResult(String str) {
                                if (str != null) {
                                    BaseActivity.this.f2573j.setImageData(str);
                                } else {
                                    BaseActivity.this.f2573j.setImageData("");
                                }
                            }
                        });
                    }
                }
            } else if (i2 == 3001) {
                a aVar = this.m;
                if (aVar != null) {
                    aVar.a(i2, i3, intent);
                }
            }
        } else if (this.f2572i != null) {
            Uri data = (intent == null || i3 != -1) ? null : intent.getData();
            if (data != null) {
                this.f2572i.onReceiveValue(new Uri[]{data});
            } else {
                this.f2572i.onReceiveValue(new Uri[0]);
            }
            this.f2572i = null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", this)) {
            initScreenShotManager();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        releaseScreenShotManager();
        LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
        boolean z = this.loginStatusChange;
        try {
            ((RelativeLayout) findViewById(e.root_view)).removeView(this.sapiWebView);
            this.sapiWebView.removeAllViews();
            this.sapiWebView.destroy();
            this.sapiWebView = null;
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.sapiWebView.onKeyUp(i2)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        SapiUtils.hideSoftInput(this);
        this.executeSubClassMethod = true;
        TitleBtnCallback titleBtnCallback = this.titleBtnCallback;
        if (titleBtnCallback != null) {
            this.executeSubClassMethod = true ^ titleBtnCallback.onLeftBtnClick();
        }
    }

    public void onPause() {
        super.onPause();
        this.sapiWebView.asyncNaLifeCycle2H5(ActivityLifeCycle.ON_PAUSE);
        try {
            this.sapiWebView.onPause();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super.onResume();
        this.sapiWebView.asyncNaLifeCycle2H5(ActivityLifeCycle.ON_RESUME);
        try {
            this.sapiWebView.onResume();
        } catch (Exception unused) {
        }
    }

    public void releaseScreenShotManager() {
        com.baidu.sapi2.shell.a.a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void setupViews() {
        super.setupViews();
        SapiWebView sapiWebView2 = (SapiWebView) findViewById(e.sapi_webview);
        this.sapiWebView = sapiWebView2;
        if (this.configuration.isDarkMode) {
            sapiWebView2.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_color));
        }
        m.a(this, this.sapiWebView, getWebDTO() != null && getWebDTO().sweepLightLoading);
        this.sapiWebView.setWebViewTitleCallback(new WebViewTitleCallback() {
            public void onTitleChange(String str) {
                String string = BaseActivity.this.getString(g.sapi_sdk_account_center_webview_title_online_service);
                String string2 = BaseActivity.this.getString(g.sapi_sdk_account_center_webview_title_common_problem);
                if (string.equals(str)) {
                    str = string2;
                }
                BaseActivity.this.setTitleText(str);
            }
        });
        this.sapiWebView.setLocalConfigCallback(new LocalConfigCallback() {
            public List<FastLoginFeature> getFastLoginFeatureList() {
                WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
                if (webLoginDTO != null) {
                    Config config = webLoginDTO.config;
                    if (config != null) {
                        return config.fastLoginFeatureList;
                    }
                }
                return null;
            }
        });
        this.sapiWebView.setFileChooserCallback(new FileChooserCallback() {
            public void onFileChooser(ValueCallback<Uri> valueCallback) {
                BaseActivity.this.a(valueCallback);
            }

            public void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback) {
                BaseActivity.this.b(valueCallback);
            }
        });
        this.sapiWebView.setPickPhotoCallback(new PickPhotoCallback() {
            public void onPickImage(int i2, int i3, int i4, PickPhotoResult pickPhotoResult) {
                BaseActivity.this.f2573j = pickPhotoResult;
                BaseActivity.this.n = i3;
                BaseActivity.this.o = i4;
                if (1 == i2) {
                    BaseActivity.this.d();
                } else {
                    BaseActivity.this.c();
                }
            }
        });
        this.sapiWebView.setBiometricsIdentifyCallback(new BiometricsIdentifyCallback() {
            public void onBiometricsIdentify(BiometricsIdentifyResult biometricsIdentifyResult) {
                BaseActivity.this.k = biometricsIdentifyResult;
                if ("bduss".equals(biometricsIdentifyResult.livenessRecogType)) {
                    BaseActivity.this.a(biometricsIdentifyResult);
                    return;
                }
                if (!"certinfo".equals(biometricsIdentifyResult.livenessRecogType)) {
                    if (!"authtoken".equals(biometricsIdentifyResult.livenessRecogType)) {
                        return;
                    }
                }
                BaseActivity.this.livenessRecognize(null, biometricsIdentifyResult);
            }
        });
        this.sapiWebView.setPageStateCallback(new PageStateCallback() {
            public void pageState(int i2) {
                BaseActivity.this.updateBottomBack(i2);
            }
        });
        this.sapiWebView.setBioScanFaceCallback(new BioScanFaceCallback() {
            public void onBioScanFace(BioScanFaceResult bioScanFaceResult) {
                BaseActivity baseActivity = BaseActivity.this;
                baseActivity.a((Context) baseActivity, bioScanFaceResult);
            }
        });
        this.sapiWebView.setInvokeScAppCallback(new InvokeScAppCallback() {
            public void onInvokeScApp(String str, String str2, List<PassNameValuePair> list, InvokeScAppResult invokeScAppResult) {
                BaseActivity.this.m = new a();
                BaseActivity.this.m.a(BaseActivity.this, str, str2, list, invokeScAppResult);
            }
        });
        if (PassportSDK.getLoginStatusChangeCallback() != null) {
            this.sapiWebView.setLoginStatusChangeCallback(new SapiJsCallBacks.LoginStatusChangeCallback() {
                public void onChange() {
                    BaseActivity.this.loginStatusChange = true;
                }
            });
        }
        this.sapiWebView.setBuildCustomAlertDialog(new BuildCustomAlertDialog() {
            public AlertDialogInterface buildDialog(Activity activity) {
                return new CustomAlertDialog(activity);
            }
        });
        this.sapiWebView.setFingerprintCallback(new FingerprintCallback() {
            public void onCallback(FingerprintResult fingerprintResult) {
                BaseActivity.this.l = fingerprintResult;
                PermissionsDTO permissionsDTO = new PermissionsDTO();
                BaseActivity baseActivity = BaseActivity.this;
                permissionsDTO.context = baseActivity;
                permissionsDTO.permissions = new String[]{"android.permission.USE_FINGERPRINT"};
                permissionsDTO.dialogTitle = "权限申请";
                permissionsDTO.dialogMsg = String.format(baseActivity.getString(g.sapi_sdk_pmn_msg_use_fingerprint), new Object[]{SapiUtils.getAppName(BaseActivity.this), "指纹权限"});
                PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() {
                    public AlertDialogInterface getDialog(Activity activity) {
                        return new CustomAlertDialog(activity);
                    }

                    public void onFailure() {
                        Toast.makeText(BaseActivity.this, "请开启指纹权限", 1).show();
                    }

                    public void onSuccess() {
                        BaseActivity baseActivity = BaseActivity.this;
                        new com.baidu.sapi2.b.g(baseActivity, new f(baseActivity)).a(BaseActivity.this.l.authType, (com.baidu.sapi2.b.a) new com.baidu.sapi2.b.a() {
                            public void onCall(int i2) {
                                BaseActivity.this.l.setResult(i2);
                            }
                        });
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void c() {
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this;
        permissionsDTO.permissions = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        permissionsDTO.dialogTitle = "权限申请";
        permissionsDTO.dialogMsg = String.format(getString(g.sapi_sdk_pmn_msg_set_portrait), new Object[]{SapiUtils.getAppName(this), "存储权限"});
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() {
            public AlertDialogInterface getDialog(Activity activity) {
                return new CustomAlertDialog(activity);
            }

            public void onFailure() {
                Toast.makeText(BaseActivity.this, "请开启存储权限", 1).show();
                if (BaseActivity.this.f2573j != null) {
                    BaseActivity.this.f2573j.setImageData("");
                }
            }

            public void onSuccess() {
                try {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction("android.intent.action.GET_CONTENT");
                    BaseActivity.this.startActivityForResult(intent, 1002);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void d() {
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this;
        permissionsDTO.permissions = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
        permissionsDTO.dialogTitle = "权限申请";
        permissionsDTO.dialogMsg = String.format(getString(g.sapi_sdk_pmn_msg_set_portrait), new Object[]{SapiUtils.getAppName(this), "相机和存储权限"});
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() {
            public AlertDialogInterface getDialog(Activity activity) {
                return new CustomAlertDialog(activity);
            }

            public void onFailure() {
                Toast.makeText(BaseActivity.this, "请开启相机和存储权限", 1).show();
                if (BaseActivity.this.f2573j != null) {
                    BaseActivity.this.f2573j.setImageData("");
                }
            }

            public void onSuccess() {
                String str = "android.media.action.IMAGE_CAPTURE";
                String str2 = BaseActivity.f2567d;
                try {
                    if (!"mounted".equals(Environment.getExternalStorageState())) {
                        Toast.makeText(BaseActivity.this, g.sapi_sdk_user_profile_sdcard_unavailable, 0).show();
                        return;
                    }
                    File file = new File(Environment.getExternalStorageDirectory(), str2);
                    if (file.exists()) {
                        file.delete();
                    }
                    Intent intent = new Intent(str);
                    intent.setAction(str);
                    File file2 = new File(Environment.getExternalStorageDirectory(), str2);
                    String str3 = "output";
                    if (VERSION.SDK_INT >= 24) {
                        if (BaseActivity.this.getApplicationInfo().targetSdkVersion >= 24) {
                            BaseActivity baseActivity = BaseActivity.this;
                            StringBuilder sb = new StringBuilder();
                            sb.append(BaseActivity.this.getPackageName());
                            sb.append(".passfileprovider");
                            intent.putExtra(str3, FileProvider.getUriForFile(baseActivity, sb.toString(), file2));
                            intent.putExtra(ExtraMetadataKey.kOrientation, 0);
                            BaseActivity.this.startActivityForResult(intent, 1001);
                        }
                    }
                    intent.putExtra(str3, Uri.fromFile(file2));
                    intent.putExtra(ExtraMetadataKey.kOrientation, 0);
                    BaseActivity.this.startActivityForResult(intent, 1001);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(ValueCallback<Uri[]> valueCallback) {
        this.f2572i = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        Intent intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", intent);
        intent2.putExtra("android.intent.extra.TITLE", "Image Chooser");
        startActivityForResult(intent2, 1011);
    }

    /* access modifiers changed from: private */
    public void a(ValueCallback<Uri> valueCallback) {
        this.f2571h = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1010);
    }

    private ImageCropCallback b() {
        return new ImageCropCallback() {
            public void onImageCrop(Context context, Uri uri, int i2, int i3, ImageCropResult imageCropResult) {
                BaseActivity.this.p = imageCropResult;
                Intent intent = new Intent(context, ImageClipActivity.class);
                int i4 = ClipBoxView.f3134b;
                String str = ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS;
                if (i2 == i4) {
                    intent.putExtra(str, 0);
                } else {
                    intent.putExtra(str, 1);
                }
                intent.putExtra(ImageClipActivity.EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, i3);
                intent.setData(uri);
                BaseActivity.this.startActivityForResult(intent, 1003);
            }
        };
    }

    /* access modifiers changed from: private */
    public void a(final BiometricsIdentifyResult biometricsIdentifyResult) {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            Toast.makeText(this, "请先登录", 1).show();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() {
            public void onFinish() {
            }

            public void onStart() {
            }

            public void onFailure(GetTplStokenResult getTplStokenResult) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", getTplStokenResult.getResultCode());
                    jSONObject.put("errmsg", getTplStokenResult.getResultMsg());
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                if (BaseActivity.this.k != null) {
                    BaseActivity.this.k.setIdentifyToken(jSONObject.toString());
                }
            }

            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                String str = (String) getTplStokenResult.tplStokenMap.get("pp");
                if (!TextUtils.isEmpty(str)) {
                    BiometricsIdentifyResult biometricsIdentifyResult = biometricsIdentifyResult;
                    if (biometricsIdentifyResult.biometricType == 1) {
                        BaseActivity.this.livenessRecognize(str, biometricsIdentifyResult);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", -402);
                    jSONObject.put("errmsg", "服务异常，请稍后再试");
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                if (BaseActivity.this.k != null) {
                    BaseActivity.this.k.setIdentifyToken(jSONObject.toString());
                }
            }
        }, currentAccount.bduss, arrayList);
    }

    /* access modifiers changed from: private */
    public void a(Context context, final BioScanFaceResult bioScanFaceResult) {
        BiometricsManager instance = BiometricsManager.getInstance();
        AnonymousClass16 r7 = new PassFaceRecogCallback() {
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a2 = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), null, null);
                BioScanFaceResult bioScanFaceResult = bioScanFaceResult;
                if (bioScanFaceResult != null) {
                    bioScanFaceResult.setScanFaceIdentifyResult(a2.toString());
                }
            }

            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                String str;
                BioScanFaceResult bioScanFaceResult = bioScanFaceResult;
                if (bioScanFaceResult != null) {
                    if (bioScanFaceResult.type == 1) {
                        try {
                            JSONObject jSONObject = passFaceRecogResult.extraJson;
                            if (jSONObject != null) {
                                jSONObject.remove("faceimage");
                                jSONObject.remove("imgdigests");
                                jSONObject.put("errno", passFaceRecogResult.getResultCode());
                                jSONObject.put("errmsg", passFaceRecogResult.getResultMsg());
                                str = jSONObject.toString();
                                bioScanFaceResult.setScanFaceIdentifyResult(str);
                            }
                        } catch (JSONException e2) {
                            Log.e(e2);
                        }
                        str = "";
                        bioScanFaceResult.setScanFaceIdentifyResult(str);
                    } else {
                        bioScanFaceResult.setScanFaceIdentifyResult(BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), passFaceRecogResult.callbackkey, passFaceRecogResult.authSid).toString());
                    }
                }
            }
        };
        String str = "0";
        if (bioScanFaceResult.type == 1) {
            instance.recogWithFaceDetect(context, bioScanFaceResult.subpro, bioScanFaceResult.transParamsMap, str, bioScanFaceResult.uid, "", r7);
            return;
        }
        instance.recogWithFaceOuter(context, bioScanFaceResult.subpro, bioScanFaceResult.transParamsMap, str, bioScanFaceResult.uid, r7);
    }

    /* access modifiers changed from: private */
    public JSONObject a(int i2, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", i2);
            jSONObject.put("errmsg", str);
            if (i2 == 0) {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("credentialKey", str2);
                    jSONObject.put("callbackkey", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("authsid", str3);
                }
            }
        } catch (JSONException e2) {
            Log.e(e2);
        }
        return jSONObject;
    }

    private ActivityResultCallback a() {
        return new ActivityResultCallback() {
            public void onActivityResult(int i2, int i3, Intent intent) {
                if (i2 != 1003) {
                    return;
                }
                if (i3 == -1) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE);
                    if (byteArrayExtra != null && BaseActivity.this.p != null) {
                        BaseActivity.this.p.onImageResult(DeviceCrypto.base64Encode(byteArrayExtra));
                    }
                } else if (BaseActivity.this.p != null) {
                    BaseActivity.this.p.onImageResult(null);
                }
            }
        };
    }
}
