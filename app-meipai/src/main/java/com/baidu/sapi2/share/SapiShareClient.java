package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.ShareStorage.StorageModel;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SapiShareClient {
    public static final String EXTRA_APP_PKG = "PKG";
    public static final String EXTRA_FACE_LOGIN_MODEL = "FACE_LOGIN_MODEL";
    public static final String EXTRA_V2_FACE_LOGIN_UIDS = "V2_FACE_LOGIN_UIDS_TIMES";
    public static final int MAX_SHARE_ACCOUNTS = 5;

    /* renamed from: a reason: collision with root package name */
    public static final String f2865a = "LOGIN_SHARE_MODEL";

    /* renamed from: b reason: collision with root package name */
    public static final String f2866b = "RUNTIME_ENVIRONMENT";

    /* renamed from: c reason: collision with root package name */
    public static final String f2867c = "SDK_VERSION";

    /* renamed from: d reason: collision with root package name */
    public static final String f2868d = "EXTRA_OTHER_INFO";

    /* renamed from: e reason: collision with root package name */
    public static final String f2869e = "IQIYI_TOKEN";

    /* renamed from: f reason: collision with root package name */
    public static final String f2870f = "VEHICLE_SYSTEM";

    /* renamed from: g reason: collision with root package name */
    public static final String f2871g = "baidu.intent.action.account.SHARE_SERVICE";

    /* renamed from: h reason: collision with root package name */
    public static final String f2872h = "baidu.intent.action.account.SHARE_ACTIVITY";

    /* renamed from: i reason: collision with root package name */
    public static SapiConfiguration f2873i = SapiAccountManager.getInstance().getSapiConfiguration();

    /* renamed from: j reason: collision with root package name */
    public static SapiContext f2874j = SapiContext.getInstance();
    public static final SapiShareClient k = new SapiShareClient();
    public volatile int l = 0;
    public volatile boolean m = true;

    public static SapiShareClient getInstance() {
        return k;
    }

    public static boolean isInReceiveOtherInfoWhiteList(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.sapi2.(.*)");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.matches((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInShareBlackList() {
        if (f2873i.enableShare) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("tv.pps.mobile");
        arrayList.add("com.qiyi.video");
        return arrayList.contains(f2873i.context.getPackageName());
    }

    public static boolean isInShareOtherInfoWhiteList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tv.pps.mobile");
        arrayList.add("com.qiyi.video");
        arrayList.add("com.baidu.sapi2.demo.standard");
        return arrayList.contains(f2873i.context.getPackageName());
    }

    public static boolean isInV2ShareDisableWhiteList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (f2873i.context.getPackageName().matches((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void syncShareAccounts() {
    }

    public List<StorageModel> getShareStorageModel(Context context) {
        if (f2873i.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            if (!a.f3069b.equals(f2873i.loginShareDirection())) {
                return x.a();
            }
        }
        return new ArrayList(0);
    }

    @TargetApi(5)
    public void invalidate(SapiAccount sapiAccount) {
        if (!(sapiAccount == null || sapiAccount.isGuestAccount() || f2873i.loginShareStrategy() == LoginShareStrategy.DISABLED)) {
            f2874j.removeShareAccount(sapiAccount);
            if (!isInShareBlackList() && !c()) {
                if (!a.f3068a.equals(f2873i.loginShareDirection())) {
                    HandlerThread handlerThread = new HandlerThread("InvalidateThread");
                    handlerThread.start();
                    Handler handler = new Handler(handlerThread.getLooper());
                    f fVar = new f(this, x.d(f2873i.context), handler, sapiAccount, handlerThread);
                    handler.post(fVar);
                }
            }
        }
    }

    public void registerActivityLifecycleCallbacks(Context context) {
        Application application = null;
        try {
            application = (Application) context;
        } catch (Exception e2) {
            Log.e(e2);
        }
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new j(this));
        }
    }

    public void validate(SapiAccount sapiAccount) {
        if (SapiUtils.isValidAccount(sapiAccount)) {
            k.a().d(sapiAccount);
            f2874j.setCurrentAccount(sapiAccount);
            SapiAccountManager.getInstance().preFetchStoken(sapiAccount, false);
            f2874j.addLoginAccount(sapiAccount);
            new b().a(b.f3031h);
            new ShareStorage().a(false);
            f2874j.removeShareAccount(sapiAccount);
            if (f2873i.loginShareStrategy() != LoginShareStrategy.DISABLED && sapiAccount.getAccountType() != AccountType.INCOMPLETE_USER && !isInShareBlackList() && !c()) {
                a(sapiAccount, x.d(f2873i.context), false);
            }
        }
    }

    public void validateOtherInfo() {
        List d2 = x.d(f2873i.context);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < d2.size(); i2++) {
            Intent intent = (Intent) d2.get(i2);
            if (isInReceiveOtherInfoWhiteList(intent.getComponent().getPackageName())) {
                arrayList.add(intent);
            }
        }
        if (arrayList.size() != 0) {
            a(null, arrayList, true);
        }
    }

    public static boolean c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.input_huawei");
        arrayList.add("com.baidu.input_yijia");
        arrayList.add("com.baidu.browser.apps");
        return arrayList.contains(f2873i.context.getPackageName());
    }

    @TargetApi(5)
    public static void d() {
        if (!c()) {
            if (!a.f3069b.equals(f2873i.loginShareDirection())) {
                HandlerThread handlerThread = new HandlerThread("SyncThread");
                handlerThread.start();
                Handler handler = new Handler(handlerThread.getLooper());
                handler.post(new i(x.d(f2873i.context), (f2873i.loginShareStrategy() == LoginShareStrategy.DISABLED || f2873i.loginShareStrategy() == LoginShareStrategy.CHOICE) ? false : true, handler, handlerThread));
            }
        }
    }

    public static void b(Parcel parcel) {
        if (parcel != null) {
            try {
                Bundle readBundle = parcel.readBundle(ShareModel.class.getClassLoader());
                if (readBundle != null) {
                    ShareModel shareModel = (ShareModel) readBundle.getParcelable(f2865a);
                    boolean z = readBundle.getBoolean(f2870f, false);
                    String string = readBundle.getString("PKG");
                    x.a(f2873i.context, f2873i.loginShareStrategy(), shareModel, readBundle.getInt("SDK_VERSION"), null, false, z, string);
                    if (SapiContext.getInstance().shareLivingunameEnable()) {
                        ArrayList arrayList = new ArrayList();
                        String string2 = readBundle.getString("V2_FACE_LOGIN_UIDS_TIMES");
                        if (!TextUtils.isEmpty(string2)) {
                            arrayList.addAll(new FaceLoginService().str2ShareModelV2List(string2));
                        }
                        if (!arrayList.isEmpty()) {
                            new FaceLoginService().syncFaceLoginUidList(f2873i.context, arrayList);
                        }
                    }
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    @TargetApi(5)
    public void a(SapiAccount sapiAccount, List<Intent> list, boolean z) {
        if (!a.f3068a.equals(f2873i.loginShareDirection()) && !sapiAccount.isGuestAccount()) {
            HandlerThread handlerThread = new HandlerThread("ValidateThread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            c cVar = new c(this, list, handler, sapiAccount, z, handlerThread);
            handler.post(cVar);
        }
    }

    public static Parcel a(ShareModel shareModel, boolean z) {
        Parcel obtain = Parcel.obtain();
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putBoolean(f2868d, true);
            bundle.putString(f2869e, SapiContext.getInstance().getIqiyiAccesstoken());
        } else if (x.b()) {
            bundle.putBoolean(f2870f, true);
        }
        if (SapiContext.getInstance().shareLivingunameEnable()) {
            bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance().getV2FaceLivingUnames());
        }
        SapiConfiguration sapiConfiguration = f2873i;
        x.a(sapiConfiguration.context, sapiConfiguration.loginShareStrategy(), shareModel);
        bundle.putString("PKG", f2873i.context.getPackageName());
        bundle.putParcelable(f2865a, shareModel);
        bundle.putSerializable(f2866b, f2873i.environment);
        bundle.putInt("SDK_VERSION", SapiAccountManager.VERSION_CODE);
        obtain.writeBundle(bundle);
        return obtain;
    }
}
