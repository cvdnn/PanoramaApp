package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.ShareStorage.StorageModel;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.share.m.b;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ShareUtils */
public final class x {

    /* renamed from: a reason: collision with root package name */
    public static final String f2975a = "share_account";

    /* renamed from: b reason: collision with root package name */
    public static final String f2976b = "share_fail_reason";

    /* renamed from: c reason: collision with root package name */
    public static final int f2977c = 87;

    public static List<Intent> a(Context context, List<ResolveInfo> list, String str) {
        String str2;
        ComponentInfo componentInfo;
        ArrayList arrayList = new ArrayList();
        if (!(context == null || list == null || list.size() == 0)) {
            HashMap hashMap = new HashMap();
            Map orderAuthorizedPackages = SapiContext.getInstance().getOrderAuthorizedPackages();
            try {
                for (ResolveInfo resolveInfo : list) {
                    if (SapiShareClient.f2871g.equals(str)) {
                        str2 = resolveInfo.serviceInfo.permission;
                        componentInfo = resolveInfo.serviceInfo;
                    } else {
                        str2 = resolveInfo.activityInfo.permission;
                        componentInfo = resolveInfo.activityInfo;
                    }
                    if (componentInfo != null) {
                        Intent intent = new Intent(str);
                        intent.setClassName(componentInfo.packageName, componentInfo.name);
                        intent.addFlags(32);
                        if ((TextUtils.isEmpty(str2) || context.checkCallingOrSelfPermission(str2) == 0) && a(context, intent.getComponent().getPackageName()) && !context.getPackageName().equals(intent.getComponent().getPackageName())) {
                            int i2 = Integer.MAX_VALUE;
                            for (String str3 : orderAuthorizedPackages.keySet()) {
                                if (intent.getComponent().getPackageName().matches(str3)) {
                                    i2 = ((Integer) orderAuthorizedPackages.get(str3)).intValue();
                                }
                            }
                            hashMap.put(intent, Integer.valueOf(i2));
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList(hashMap.entrySet());
                Collections.sort(arrayList2, new v());
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Entry) it.next()).getKey());
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
        return arrayList;
    }

    public static String b(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            if (packagesForUid.length > 0) {
                str = packagesForUid[0];
            }
        } catch (Throwable th) {
            Log.e(th);
        }
        return str;
    }

    public static List<Intent> c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String str = SapiShareClient.f2872h;
        return a(context, packageManager.queryIntentActivities(new Intent(str), 32), str);
    }

    public static List<Intent> d(Context context) {
        return new ArrayList();
    }

    public static void c() {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        Context context = confignation.context;
        if (SapiUtils.isOnline(context)) {
            if (!a.f3069b.equals(confignation.loginShareDirection())) {
                ArrayList arrayList = new ArrayList();
                List<Intent> c2 = c(context);
                if (c2.size() == 0) {
                    SapiContext.getInstance().setShareStorage(null);
                    return;
                }
                ShareStorage shareStorage = new ShareStorage();
                HashSet hashSet = new HashSet();
                for (SapiAccount sapiAccount : SapiAccountManager.getInstance().getLoginAccounts()) {
                    hashSet.add(sapiAccount.displayname);
                }
                int size = c2.size();
                int ordinal = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                int i2 = 0;
                int i3 = size;
                int i4 = 0;
                int i5 = 0;
                for (Intent component : c2) {
                    StorageModel a2 = shareStorage.a(component.getComponent().getPackageName());
                    if (a2 != null && a2.f2898d != ordinal) {
                        i3--;
                    } else if (a2 == null) {
                        i2++;
                    } else {
                        int i6 = a2.f2897c;
                        if (i6 == 0) {
                            i4++;
                        } else if (i6 == 1) {
                            i5++;
                        }
                        if (a2.f2896b == 0 && !hashSet.contains(a2.displayname)) {
                            arrayList.add(a2);
                            hashSet.add(a2.displayname);
                        }
                    }
                }
                SapiContext.getInstance().setShareStorage(StorageModel.toJSONArray(arrayList));
                SapiStatUtil.statShareV2OpenMax(context, i2, i4, i5, i3, shareStorage, arrayList);
            }
        }
    }

    public static void b(SapiAccount sapiAccount) {
        if (SapiUtils.isValidAccount(sapiAccount)) {
            SapiContext instance = SapiContext.getInstance();
            SapiAccount currentAccount = instance.getCurrentAccount();
            if (currentAccount != null && sapiAccount.uid.equals(currentAccount.uid)) {
                k.a().a(currentAccount, sapiAccount);
                instance.setCurrentAccount(currentAccount);
                SapiAccountManager.getInstance().preFetchStoken(currentAccount, false);
            }
            for (SapiAccount sapiAccount2 : instance.getLoginAccounts()) {
                if (sapiAccount.uid.equals(sapiAccount2.uid)) {
                    k.a().a(sapiAccount2, sapiAccount);
                    instance.addLoginAccount(sapiAccount2);
                    new ShareStorage().a(false);
                }
            }
            for (SapiAccount sapiAccount3 : instance.getShareAccounts()) {
                if (sapiAccount.uid.equals(sapiAccount3.uid)) {
                    k.a().a(sapiAccount3, sapiAccount);
                    instance.addShareAccount(sapiAccount3);
                }
            }
        }
    }

    public static boolean b() {
        Context context = SapiAccountManager.getInstance().getConfignation().context;
        Map vehicleSystemPackages = SapiContext.getInstance().getVehicleSystemPackages();
        String packageName = context.getPackageName();
        String packageSign = SapiUtils.getPackageSign(context, packageName);
        if (!TextUtils.isEmpty(packageSign)) {
            for (String str : vehicleSystemPackages.keySet()) {
                if (packageName.matches(str) && packageSign.equals(vehicleSystemPackages.get(str))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return a(context, b(context));
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Map authorizedPackages = SapiContext.getInstance().getAuthorizedPackages();
            String packageSign = SapiUtils.getPackageSign(context, str);
            if (!TextUtils.isEmpty(packageSign)) {
                for (String str2 : authorizedPackages.keySet()) {
                    if (str.matches(str2) && packageSign.equals(authorizedPackages.get(str2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e3, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r1, com.baidu.sapi2.utils.enums.LoginShareStrategy r2, com.baidu.sapi2.share.ShareModel r3, int r4, java.lang.String r5, boolean r6, boolean r7, java.lang.String r8) {
        /*
            java.lang.Class<com.baidu.sapi2.share.x> r0 = com.baidu.sapi2.share.x.class
            monitor-enter(r0)
            if (r6 == 0) goto L_0x0015
            com.baidu.sapi2.SapiAccountManager r1 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ all -> 0x0012 }
            com.baidu.sapi2.SapiAccountService r1 = r1.getAccountService()     // Catch:{ all -> 0x0012 }
            r1.setIqiyiAccessToken(r5)     // Catch:{ all -> 0x0012 }
            monitor-exit(r0)
            return
        L_0x0012:
            r1 = move-exception
            goto L_0x00e4
        L_0x0015:
            if (r1 == 0) goto L_0x00e6
            if (r2 == 0) goto L_0x00e6
            if (r3 != 0) goto L_0x001d
            goto L_0x00e6
        L_0x001d:
            r3.a(r1)     // Catch:{ all -> 0x0012 }
            com.baidu.sapi2.SapiContext r1 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ all -> 0x0012 }
            com.baidu.sapi2.utils.enums.LoginShareStrategy r5 = com.baidu.sapi2.utils.enums.LoginShareStrategy.SILENT     // Catch:{ all -> 0x0012 }
            r6 = 0
            if (r2 != r5) goto L_0x004f
            boolean r2 = r1.isLoginStatusChanged()     // Catch:{ all -> 0x0012 }
            if (r2 != 0) goto L_0x004f
            com.baidu.sapi2.SapiAccount r2 = r1.getCurrentAccount()     // Catch:{ all -> 0x0012 }
            if (r2 != 0) goto L_0x004f
            java.util.List r2 = r3.c()     // Catch:{ all -> 0x0012 }
            int r2 = r2.size()     // Catch:{ all -> 0x0012 }
            if (r2 <= 0) goto L_0x004f
            java.util.List r2 = r3.c()     // Catch:{ all -> 0x0012 }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x0012 }
            com.baidu.sapi2.SapiAccount r2 = (com.baidu.sapi2.SapiAccount) r2     // Catch:{ all -> 0x0012 }
            boolean r2 = com.baidu.sapi2.utils.SapiUtils.isValidAccount(r2)     // Catch:{ all -> 0x0012 }
            if (r2 != 0) goto L_0x0051
        L_0x004f:
            if (r7 == 0) goto L_0x00b6
        L_0x0051:
            java.util.List r2 = r3.c()     // Catch:{ all -> 0x0012 }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x0012 }
            com.baidu.sapi2.SapiAccount r2 = (com.baidu.sapi2.SapiAccount) r2     // Catch:{ all -> 0x0012 }
            com.baidu.sapi2.share.k r4 = com.baidu.sapi2.share.k.a()     // Catch:{ all -> 0x0012 }
            r4.a(r2, r8)     // Catch:{ all -> 0x0012 }
            r1.setCurrentAccount(r2)     // Catch:{ all -> 0x0012 }
            com.baidu.sapi2.SapiAccountManager r4 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ all -> 0x0012 }
            r4.preFetchStoken(r2, r6)     // Catch:{ all -> 0x0012 }
            r1.addLoginAccount(r2)     // Catch:{ all -> 0x0012 }
            com.baidu.sapi2.share.ShareStorage r4 = new com.baidu.sapi2.share.ShareStorage     // Catch:{ all -> 0x0012 }
            r4.<init>()     // Catch:{ all -> 0x0012 }
            r4.a(r6)     // Catch:{ all -> 0x0012 }
            r1.removeShareAccount(r2)     // Catch:{ all -> 0x0012 }
            com.baidu.sapi2.SapiAccountManager$SilentShareListener r2 = com.baidu.sapi2.SapiAccountManager.getSilentShareListener()     // Catch:{ all -> 0x0012 }
            if (r2 == 0) goto L_0x0091
            android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x0012 }
            android.os.Looper r4 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0012 }
            r2.<init>(r4)     // Catch:{ all -> 0x0012 }
            com.baidu.sapi2.share.w r4 = new com.baidu.sapi2.share.w     // Catch:{ all -> 0x0012 }
            r4.<init>(r1)     // Catch:{ all -> 0x0012 }
            r2.post(r4)     // Catch:{ all -> 0x0012 }
        L_0x0091:
            java.util.List r2 = r3.c()     // Catch:{ all -> 0x0012 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0012 }
        L_0x0099:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0012 }
            if (r3 == 0) goto L_0x00e2
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0012 }
            com.baidu.sapi2.SapiAccount r3 = (com.baidu.sapi2.SapiAccount) r3     // Catch:{ all -> 0x0012 }
            boolean r4 = a(r3)     // Catch:{ all -> 0x0012 }
            if (r4 == 0) goto L_0x0099
            com.baidu.sapi2.share.k r4 = com.baidu.sapi2.share.k.a()     // Catch:{ all -> 0x0012 }
            r4.a(r3, r8)     // Catch:{ all -> 0x0012 }
            r1.addShareAccount(r3)     // Catch:{ all -> 0x0012 }
            goto L_0x0099
        L_0x00b6:
            java.util.List r2 = r3.c()     // Catch:{ all -> 0x0012 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0012 }
        L_0x00be:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0012 }
            if (r3 == 0) goto L_0x00e2
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0012 }
            com.baidu.sapi2.SapiAccount r3 = (com.baidu.sapi2.SapiAccount) r3     // Catch:{ all -> 0x0012 }
            boolean r5 = a(r3)     // Catch:{ all -> 0x0012 }
            if (r5 == 0) goto L_0x00da
            com.baidu.sapi2.share.k r5 = com.baidu.sapi2.share.k.a()     // Catch:{ all -> 0x0012 }
            r5.a(r3, r8)     // Catch:{ all -> 0x0012 }
            r1.addShareAccount(r3)     // Catch:{ all -> 0x0012 }
        L_0x00da:
            r5 = 87
            if (r4 < r5) goto L_0x00be
            b(r3)     // Catch:{ all -> 0x0012 }
            goto L_0x00be
        L_0x00e2:
            monitor-exit(r0)
            return
        L_0x00e4:
            monitor-exit(r0)
            throw r1
        L_0x00e6:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.share.x.a(android.content.Context, com.baidu.sapi2.utils.enums.LoginShareStrategy, com.baidu.sapi2.share.ShareModel, int, java.lang.String, boolean, boolean, java.lang.String):void");
    }

    public static boolean a(SapiAccount sapiAccount) {
        SapiContext instance = SapiContext.getInstance();
        return SapiUtils.isValidAccount(sapiAccount) && (instance.getCurrentAccount() == null || !instance.getCurrentAccount().uid.equals(sapiAccount.uid)) && !instance.getLoginAccounts().contains(sapiAccount);
    }

    public static void a(Context context, ShareModel shareModel) {
        if (context != null && shareModel != null) {
            shareModel.a(context);
            SapiContext instance = SapiContext.getInstance();
            if (shareModel.c().size() > 0) {
                SapiAccount sapiAccount = (SapiAccount) shareModel.c().get(0);
                if (instance.getCurrentAccount() == null || !instance.getCurrentAccount().uid.equals(sapiAccount.uid)) {
                    instance.removeShareAccount(sapiAccount);
                }
            }
        }
    }

    public static void a(Context context, LoginShareStrategy loginShareStrategy, ShareModel shareModel) {
        if (context != null && loginShareStrategy != null && shareModel != null) {
            if (TextUtils.isEmpty(shareModel.b())) {
                shareModel.a(context.getPackageName());
            }
            shareModel.a(loginShareStrategy);
            shareModel.b(context);
        }
    }

    public static List<StorageModel> a() {
        List<StorageModel> a2 = StorageModel.a(SapiContext.getInstance().getShareStorage());
        String[] deleteShareLoginList = SapiContext.getInstance().getDeleteShareLoginList();
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            StorageModel storageModel = (StorageModel) it.next();
            for (String str : deleteShareLoginList) {
                if (!TextUtils.isEmpty(storageModel.url) && storageModel.url.contains(str)) {
                    try {
                        it.remove();
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return a2;
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list) {
        if (activity != null) {
            int i2 = 0;
            if (TextUtils.isEmpty(str) || !SapiUtils.isAppInstalled(activity, str)) {
                Toast.makeText(activity, Web2NativeLoginResult.ERROR_MSG_UNKNOWN, 0).show();
            } else {
                ComponentName componentName = new ComponentName(str, "com.baidu.sapi2.activity.ShareActivity");
                Intent intent = new Intent();
                intent.putExtra("android.intent.extra.TEXT", str2);
                intent.putExtra(m.f2941b, str4);
                intent.putExtra(m.f2940a, str3);
                intent.setComponent(componentName);
                activity.startActivityForResult(intent, m.f2946g);
            }
            m.k = new b();
            List shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(activity);
            while (true) {
                if (i2 < shareStorageModel.size()) {
                    if (((StorageModel) shareStorageModel.get(i2)).pkg.equals(str) && ((StorageModel) shareStorageModel.get(i2)).url.equals(str2)) {
                        b bVar = m.k;
                        bVar.f2953d = i2;
                        bVar.f2954e = ((StorageModel) shareStorageModel.get(i2)).tpl;
                        m.k.f2955f = ((StorageModel) shareStorageModel.get(i2)).app;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            SapiStatUtil.statShareV2Click(m.k, list);
            return;
        }
        throw new IllegalArgumentException("loginActivity can't be null");
    }

    public static void a(m.a aVar, int i2, int i3, Intent intent, m mVar, List<PassNameValuePair> list) {
        String str;
        String str2;
        if (i2 == 20001) {
            if (aVar != null) {
                Context context = SapiAccountManager.getInstance().getConfignation().context;
                String str3 = "";
                String str4 = SapiResult.ERROR_MSG_V2_SHARE_ACCOUNT_FAIL;
                int i4 = 0;
                if (i3 == -1) {
                    SapiAccount sapiAccount = (SapiAccount) intent.getParcelableExtra("share_account");
                    if (sapiAccount != null) {
                        if (intent.getIntExtra("SDK_VERSION", 0) >= 190) {
                            k.a().a(sapiAccount, intent.getStringExtra("PKG"));
                        } else {
                            sapiAccount.app = str3;
                        }
                        str = sapiAccount.uid;
                        SapiContext instance = SapiContext.getInstance();
                        instance.setCurrentAccount(sapiAccount);
                        SapiAccountManager.getInstance().preFetchStoken(sapiAccount, false);
                        instance.addLoginAccount(sapiAccount);
                        mVar.a(false);
                        instance.removeShareAccount(sapiAccount);
                        String str5 = m.f2949j;
                        instance.setAccountActionType(str5);
                        if (instance.shareLivingunameEnable()) {
                            ArrayList arrayList = new ArrayList();
                            String stringExtra = intent.getStringExtra("V2_FACE_LOGIN_UIDS_TIMES");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                arrayList.addAll(new FaceLoginService().str2ShareModelV2List(stringExtra));
                            }
                            if (!arrayList.isEmpty()) {
                                new FaceLoginService().syncFaceLoginUidList(context, arrayList);
                            }
                        }
                        instance.put(SapiContext.KEY_PRE_LOGIN_TYPE, str5);
                        aVar.onSuccess();
                    } else {
                        Toast.makeText(context, str4, 0).show();
                        aVar.onFailed(SapiResult.ERROR_CODE_V2_SHARE_ACCOUNT_FAIL, str4);
                        i4 = 1;
                        str = str3;
                        str3 = str4;
                    }
                } else {
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra("share_fail_reason");
                        Toast.makeText(context, stringExtra2, 0).show();
                        str2 = stringExtra2;
                    } else {
                        str2 = "result data is null";
                    }
                    aVar.onFailed(SapiResult.ERROR_CODE_V2_SHARE_ACCOUNT_FAIL, str4);
                    i4 = 2;
                    str = str3;
                    str3 = str2;
                }
                SapiStatUtil.statShareV2Result(m.k, str3, i4, str, list);
                return;
            }
            throw new IllegalArgumentException("and shareLoginCallBack can't be null");
        }
    }
}
