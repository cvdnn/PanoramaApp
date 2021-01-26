package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.outsdk.d;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.service.interfaces.a;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.share.ShareStorage.StorageModel;
import com.baidu.sapi2.share.m;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.i;
import com.baidu.sapi2.utils.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class SapiAccountManager implements ISAccountManager {
    public static final String SESSION_BDUSS = "bduss";
    public static final String SESSION_DISPLAYNAME = "displayname";
    public static final String SESSION_UID = "uid";
    public static final int VERSION_CODE = 240;
    public static final String VERSION_NAME = "8.9.5.5";

    /* renamed from: a reason: collision with root package name */
    public static final String f2197a = "SapiAccountManager";

    /* renamed from: b reason: collision with root package name */
    public static SapiAccountManager f2198b;

    /* renamed from: c reason: collision with root package name */
    public static SapiConfiguration f2199c;

    /* renamed from: d reason: collision with root package name */
    public static SapiAccountService f2200d;

    /* renamed from: e reason: collision with root package name */
    public static ServiceManager f2201e;

    /* renamed from: f reason: collision with root package name */
    public static SilentShareListener f2202f;

    /* renamed from: g reason: collision with root package name */
    public static ReceiveShareListener f2203g;

    /* renamed from: h reason: collision with root package name */
    public static GlobalAuthorizationListener f2204h;

    /* renamed from: i reason: collision with root package name */
    public static CheckUrlIsAvailableListener f2205i;

    /* renamed from: j reason: collision with root package name */
    public static final List<String> f2206j;
    public char k = 0;

    public interface CheckUrlIsAvailableListener {
        void handleWebPageUrl(String str);

        boolean onCheckUrlIsAvailable(String str);
    }

    public static abstract class GlobalAuthorizationListener {
        public void onLogoutSuccess(SapiAccount sapiAccount) {
        }
    }

    public interface ReceiveShareListener {
        void onReceiveShare();
    }

    public interface SilentShareListener {
        void onSilentShare();
    }

    static {
        ArrayList arrayList = new ArrayList();
        f2206j = arrayList;
        arrayList.add("uid");
        f2206j.add("displayname");
        f2206j.add("bduss");
    }

    private void b(String str) {
        if (SapiUtils.isDebug(f2199c.context) || f2199c.debug) {
            throw new RuntimeException(str);
        }
        Log.e(str, new Object[0]);
    }

    /* access modifiers changed from: private */
    public void c() {
        try {
            Class.forName("com.baidu.sofire.ac.FH");
        } catch (Exception unused) {
            b("please import the package : sofire-sdk-*.jar");
        }
        if (f2199c.supportFaceLogin) {
            try {
                Class.forName("com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager");
            } catch (Throwable unused2) {
                b("please import the package :pass-biometrics-face-*.aar and pass-biometrics-base-*.aar");
            }
        }
        if (f2199c.loginShareStrategy() != LoginShareStrategy.DISABLED && getReceiveShareListener() == null) {
            throw new RuntimeException("please registerReceiveShareListener to support share login function");
        }
    }

    public static CheckUrlIsAvailableListener getCheckUrlIsAvailablelister() {
        return f2205i;
    }

    public static GlobalAuthorizationListener getGlobalAuthorizationListener() {
        return f2204h;
    }

    public static synchronized SapiAccountManager getInstance() {
        SapiAccountManager sapiAccountManager;
        synchronized (SapiAccountManager.class) {
            if (f2198b == null) {
                f2198b = new SapiAccountManager();
            }
            sapiAccountManager = f2198b;
        }
        return sapiAccountManager;
    }

    public static ReceiveShareListener getReceiveShareListener() {
        return f2203g;
    }

    public static SilentShareListener getSilentShareListener() {
        return f2202f;
    }

    public static void registerCheckUrlIsAvailableListener(CheckUrlIsAvailableListener checkUrlIsAvailableListener) {
        f2205i = checkUrlIsAvailableListener;
    }

    public static void registerGlobalAuthorizationListener(GlobalAuthorizationListener globalAuthorizationListener) {
        f2204h = globalAuthorizationListener;
    }

    public static void registerReceiveShareListener(ReceiveShareListener receiveShareListener) {
        f2203g = receiveShareListener;
    }

    public static void registerSilentShareListener(SilentShareListener silentShareListener) {
        f2202f = silentShareListener;
    }

    public static void unregisterCheckUrlIsAvailableListener() {
        f2205i = null;
    }

    public static void unregisterGlobalAuthorizationListener() {
        f2204h = null;
    }

    public static void unregisterReceiveShareListener() {
        f2203g = null;
    }

    public static void unregisterSilentShareListener() {
        f2202f = null;
    }

    public SapiAccount getAccountByOpenid(String str) {
        String str2 = (String) SapiUtils.urlParamsToMap(SapiContext.getInstance().getString(SapiContext.KEY_OPENID_UID_LIST)).get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        List<SapiAccount> loginAccounts = getLoginAccounts();
        loginAccounts.addAll(getShareAccounts());
        for (SapiAccount sapiAccount : loginAccounts) {
            if (str2.equals(sapiAccount.uid)) {
                SapiContext.getInstance().setCurrentAccount(sapiAccount);
                return sapiAccount;
            }
        }
        return null;
    }

    public SapiAccountService getAccountService() {
        b();
        return f2200d;
    }

    public SapiConfiguration getConfignation() {
        return f2199c;
    }

    public String getCurrentZid(Context context) {
        return SapiSafeFacade.a().getCurrentZid(context);
    }

    public a getIsAccountService() {
        return getAccountService();
    }

    public List<SapiAccount> getLoginAccounts() {
        b();
        return SapiContext.getInstance().getLoginAccounts();
    }

    public void getOneKeyLoginIsAvailable(OneKeyLoginCallback oneKeyLoginCallback) {
        if (oneKeyLoginCallback == null) {
            Log.e(f2197a, "When check oneKeyLogin's ability, oneKeyLoginCallback can't be null!");
            return;
        }
        if (new c().a()) {
            JSONObject b2 = new c().b();
            String str = null;
            if (b2 != null) {
                str = b2.optString(SapiAccount.f2185e);
            }
            f2200d.checkOneKeyLoginIsAvailable(oneKeyLoginCallback, str);
        } else {
            new c().a(f2199c, c.m, oneKeyLoginCallback);
        }
    }

    public SapiSafeFacade getSafeFacade() {
        b();
        return SapiSafeFacade.a();
    }

    public SapiConfiguration getSapiConfiguration() {
        b();
        return f2199c;
    }

    public String getSession(String str, String str2) {
        b();
        SapiAccount session = getSession();
        if (a(str) && isLogin() && session != null) {
            JSONObject jSONObject = session.toJSONObject();
            if (jSONObject != null) {
                return jSONObject.optString(str, str2);
            }
        }
        return str2;
    }

    public List<SapiAccount> getShareAccounts() {
        b();
        ArrayList arrayList = new ArrayList();
        if (f2199c.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            return arrayList;
        }
        for (SapiAccount sapiAccount : SapiContext.getInstance().getShareAccounts()) {
            if (SapiUtils.isValidAccount(sapiAccount)) {
                arrayList.add(sapiAccount);
            } else {
                SapiContext.getInstance().removeShareAccount(sapiAccount);
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public List<StorageModel> getV2ShareModelList() {
        return getV2ShareModelList("");
    }

    public int getVersionCode() {
        return VERSION_CODE;
    }

    public String getVersionName() {
        return VERSION_NAME;
    }

    public String getZidAndCheckSafe(Context context, String str, int i2) {
        return SapiSafeFacade.a().getZidAndCheckSafe(context, str, i2);
    }

    public synchronized void init(final SapiConfiguration sapiConfiguration) {
        Class<SapiAccountManager> cls = SapiAccountManager.class;
        synchronized (this) {
            if (sapiConfiguration == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getSimpleName());
                sb.append(" initialized failed: SapiConfiguration can't be null");
                throw new IllegalArgumentException(sb.toString());
            } else if (f2199c == null) {
                f2199c = sapiConfiguration;
                f2200d = new SapiAccountService();
                ServiceManager instance = ServiceManager.getInstance();
                f2201e = instance;
                instance.setIsAccountManager(this);
                if (c(sapiConfiguration.context)) {
                    C0164b.b().a((Application) sapiConfiguration.context);
                    ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() {
                        public void run() {
                            boolean z;
                            try {
                                SapiAccountManager.this.c();
                            } catch (RuntimeException e2) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    public void run() {
                                        throw e2;
                                    }
                                });
                            }
                            SapiContext instance = SapiContext.getInstance();
                            instance.setShareStorage(null);
                            new m().a(true);
                            SapiShareClient.getInstance().registerActivityLifecycleCallbacks(sapiConfiguration.context);
                            int versionCode = SapiUtils.getVersionCode(sapiConfiguration.context);
                            if (sapiConfiguration.silentShareOnUpgrade && versionCode > instance.getAppVersionCode()) {
                                SapiUtils.resetSilentShareStatus();
                            }
                            if (versionCode > instance.getAppVersionCode()) {
                                SapiUtils.webLogin(sapiConfiguration.context, SapiUtils.getCookieBduss(), "");
                            }
                            String str = SapiContext.KEY_SDK_VERSION;
                            String string = instance.getString(str);
                            String str2 = SapiAccountManager.VERSION_NAME;
                            if (str2.compareTo(string) > 0) {
                                instance.put(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, false);
                            }
                            instance.setAppVersionCode(versionCode);
                            instance.put(str, str2);
                            SapiConfiguration sapiConfiguration = sapiConfiguration;
                            sapiConfiguration.clientId = SapiUtils.getClientId(sapiConfiguration.context);
                            sapiConfiguration.clientIp = SapiUtils.getLocalIpAddress();
                            SapiShareClient.syncShareAccounts();
                            List k = X.k();
                            String packageName = sapiConfiguration.context.getPackageName();
                            Iterator it = k.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (packageName.matches((String) it.next())) {
                                        z = false;
                                        break;
                                    }
                                } else {
                                    z = true;
                                    break;
                                }
                            }
                            if (z) {
                                new V().a(sapiConfiguration.context);
                            }
                            instance.setHostsHijacked(SapiDeviceUtils.a(sapiConfiguration.context));
                            if (sapiConfiguration.supportFaceLogin) {
                                new d().a(SapiAccountManager.f2199c);
                            }
                            com.baidu.sapi2.utils.d a2 = com.baidu.sapi2.utils.d.a();
                            SapiConfiguration sapiConfiguration2 = sapiConfiguration;
                            a2.a(sapiConfiguration2.context, sapiConfiguration2.sofireAppKey, sapiConfiguration2.sofireSecKey, 1);
                            if (TextUtils.isEmpty(SapiUtils.getCookieBduss())) {
                                SapiAccountManager.getInstance().getAccountService().webLogin(sapiConfiguration.context);
                            }
                        }
                    }));
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cls.getSimpleName());
                sb2.append(" had already been initialized");
                Log.d(sb2.toString(), new Object[0]);
            }
        }
    }

    public void invalidate(SapiAccount sapiAccount) {
        b();
        SapiShareClient.getInstance().invalidate(sapiAccount);
    }

    public boolean isLogin() {
        b();
        return SapiContext.getInstance().getCurrentAccount() != null;
    }

    public void logout() {
        t.a("logout", Collections.singletonMap("di", SapiDeviceInfo.getDeviceInfo("sdk_api_logout")));
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        removeLoginAccount(currentAccount);
        new m().a(false);
        SapiUtils.reportGid(i.f3090e);
        if (currentAccount != null) {
            SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_UID, currentAccount.uid);
        }
    }

    public void preFetchStoken(SapiAccount sapiAccount, boolean z) {
        List s = SapiContext.getInstance().getSapiOptions().s();
        if (sapiAccount != null && s != null && !s.isEmpty() && !getInstance().getAccountService().a(sapiAccount, s)) {
            getInstance().getAccountService().a((GetTplStokenCallback) new GetTplStokenCallback() {
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                }

                public void onFinish() {
                }

                public void onStart() {
                }

                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                }
            }, sapiAccount.bduss, s, z);
        }
    }

    public void removeLoginAccount(SapiAccount sapiAccount) {
        b();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        SapiContext.getInstance().removeLoginAccount(sapiAccount);
        new m().a(false);
        try {
            new OpenBdussService(getSapiConfiguration(), VERSION_NAME).logout();
        } catch (Throwable unused) {
        }
        if (currentAccount != null && !TextUtils.isEmpty(sapiAccount.uid) && sapiAccount.uid.equals(currentAccount.uid) && getGlobalAuthorizationListener() != null) {
            try {
                getGlobalAuthorizationListener().onLogoutSuccess(sapiAccount);
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public boolean validate(SapiAccount sapiAccount) {
        b();
        if (!SapiUtils.isValidAccount(sapiAccount)) {
            return false;
        }
        SapiShareClient.getInstance().validate(sapiAccount);
        return true;
    }

    public List<StorageModel> getV2ShareModelList(String str) {
        b();
        String str2 = "product_line_call";
        SapiStatUtil.statLoadLogin(str2);
        List<StorageModel> shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(f2199c.context);
        if (shareStorageModel.size() > 0) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                e.a.a.a.a.a("extrajson", str, arrayList);
            }
            SapiStatUtil.statShareV2Open(shareStorageModel, str2, arrayList);
        }
        return shareStorageModel;
    }

    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && f2206j.contains(str);
    }

    private String a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).processName;
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    public void b() {
        if (f2199c == null) {
            ReceiveShareListener receiveShareListener = f2203g;
            if (receiveShareListener != null) {
                receiveShareListener.onReceiveShare();
            }
        }
        if (f2199c != null) {
            return;
        }
        if (!Log.enabled) {
            android.util.Log.e(Log.TAG, "pass sdk have not been initialized");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.class.getSimpleName());
        sb.append(" have not been initialized");
        throw new IllegalStateException(sb.toString());
    }

    public String getSession(String str) {
        b();
        return getSession(str, null);
    }

    public SapiAccount getSession() {
        b();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (this.k == 0) {
            X sapiOptions = SapiContext.getInstance().getSapiOptions();
            if (!sapiOptions.q().contains(getConfignation().tpl) || sapiOptions.T) {
                this.k = 2;
            } else {
                this.k = 1;
            }
        }
        if (currentAccount != null && this.k == 1) {
            String str = "";
            currentAccount.uid = str;
            currentAccount.bduss = str;
        }
        return currentAccount;
    }

    private boolean c(Context context) {
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (b2.equals(a2) || b2.equals(f2199c.processName)) {
            return true;
        }
        return false;
    }

    @TargetApi(3)
    private String b(Context context) {
        try {
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Throwable th) {
            Log.e(th);
        }
        return "";
    }
}
