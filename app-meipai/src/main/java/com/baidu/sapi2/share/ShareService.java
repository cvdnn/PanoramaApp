package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShareService extends Service {

    /* renamed from: a reason: collision with root package name */
    public Context f2881a;

    /* renamed from: b reason: collision with root package name */
    public LoginShareStrategy f2882b;

    /* renamed from: c reason: collision with root package name */
    public SapiContext f2883c;

    /* renamed from: d reason: collision with root package name */
    public boolean f2884d = false;

    /* renamed from: e reason: collision with root package name */
    public Handler f2885e;

    public class a extends Binder {
        public a() {
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            String str = SapiShareClient.f2866b;
            if (!x.a((Context) ShareService.this)) {
                return false;
            }
            if (SapiAccountManager.getReceiveShareListener() != null) {
                if (ShareService.this.f2885e == null) {
                    ShareService.this.f2885e = new Handler(Looper.getMainLooper());
                }
                ShareService.this.f2885e.post(new r(this));
            }
            if (!ShareService.this.f2884d) {
                ShareService shareService = ShareService.this;
                shareService.a((Context) shareService);
            }
            if (ShareService.this.f2884d && ShareService.this.f2882b != LoginShareStrategy.DISABLED) {
                try {
                    Bundle readBundle = parcel.readBundle(ShareModel.class.getClassLoader());
                    ShareModel shareModel = (ShareModel) readBundle.getParcelable(SapiShareClient.f2865a);
                    if (shareModel == null) {
                        return true;
                    }
                    String string = readBundle.getString(SapiShareClient.f2869e);
                    boolean z = readBundle.getBoolean(SapiShareClient.f2868d);
                    if (SapiContext.getInstance().shareLivingunameEnable()) {
                        ArrayList arrayList = new ArrayList();
                        String string2 = readBundle.getString("V2_FACE_LOGIN_UIDS_TIMES");
                        if (!TextUtils.isEmpty(string2)) {
                            arrayList.addAll(new FaceLoginService().str2ShareModelV2List(string2));
                        }
                        if (!arrayList.isEmpty()) {
                            new FaceLoginService().syncFaceLoginUidList(ShareService.this.f2881a, arrayList);
                        }
                    }
                    boolean z2 = readBundle.getBoolean(SapiShareClient.f2870f, false);
                    if (readBundle.getSerializable(str) != null && (readBundle.getSerializable(str) instanceof Domain) && ((Domain) readBundle.getSerializable(str)) != SapiAccountManager.getInstance().getSapiConfiguration().environment) {
                        return true;
                    }
                    int i4 = readBundle.getInt("SDK_VERSION");
                    String string3 = readBundle.getString("PKG");
                    String loginShareDirection = SapiAccountManager.getInstance().getSapiConfiguration().loginShareDirection();
                    int i5 = q.f2967a[shareModel.a().ordinal()];
                    String str2 = com.baidu.sapi2.utils.enums.a.f3069b;
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                                if (!com.baidu.sapi2.utils.enums.a.f3068a.equals(loginShareDirection) || !SapiContext.getInstance().getCurrentAccount().isGuestAccount()) {
                                    ShareService.this.a(parcel2);
                                }
                            }
                        } else if (!str2.equals(loginShareDirection)) {
                            x.a(ShareService.this.f2881a, shareModel);
                        }
                    } else if (!str2.equals(loginShareDirection)) {
                        x.a(ShareService.this.f2881a, ShareService.this.f2882b, shareModel, i4, string, z, z2, string3);
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
            return true;
        }

        public /* synthetic */ a(ShareService shareService, q qVar) {
            this();
        }
    }

    public IBinder onBind(Intent intent) {
        return new a(this, null);
    }

    public void onCreate() {
        super.onCreate();
        this.f2885e = new Handler(Looper.getMainLooper());
    }

    @TargetApi(5)
    public int onStartCommand(Intent intent, int i2, int i3) {
        a();
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        a();
        return super.onUnbind(intent);
    }

    private void a() {
        try {
            stopSelf();
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    public void a(Context context) {
        try {
            this.f2881a = context;
            this.f2883c = SapiContext.getInstance();
            this.f2882b = SapiAccountManager.getInstance().getSapiConfiguration().loginShareStrategy();
            this.f2884d = true;
        } catch (IllegalStateException unused) {
            this.f2884d = false;
        }
    }

    public void a(Parcel parcel) {
        Bundle bundle = new Bundle();
        ShareModel shareModel = new ShareModel(ShareEvent.SYNC_ACK);
        SapiAccount currentAccount = this.f2883c.getCurrentAccount();
        shareModel.a(currentAccount);
        List loginAccounts = this.f2883c.getLoginAccounts();
        if (currentAccount != null) {
            currentAccount.app = SapiUtils.getAppName(this.f2881a);
            if (loginAccounts.size() > 0 && loginAccounts.contains(currentAccount)) {
                loginAccounts.set(loginAccounts.indexOf(currentAccount), loginAccounts.get(0));
                loginAccounts.set(0, currentAccount);
            }
        } else {
            Collections.reverse(loginAccounts);
        }
        shareModel.c().addAll(loginAccounts);
        shareModel.c().addAll(this.f2883c.getShareAccounts());
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : shareModel.c()) {
            if (sapiAccount.getAccountType() == AccountType.INCOMPLETE_USER) {
                arrayList.add(sapiAccount);
            }
        }
        shareModel.c().removeAll(arrayList);
        for (SapiAccount sapiAccount2 : shareModel.c()) {
            sapiAccount2.app = SapiUtils.getAppName(this.f2881a);
        }
        x.a(this.f2881a, this.f2882b, shareModel);
        bundle.putParcelable(SapiShareClient.f2865a, shareModel);
        bundle.putSerializable(SapiShareClient.f2866b, SapiAccountManager.getInstance().getSapiConfiguration().environment);
        bundle.putInt("SDK_VERSION", SapiAccountManager.VERSION_CODE);
        if (SapiContext.getInstance().shareLivingunameEnable()) {
            bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance().getV2FaceLivingUnames());
        }
        bundle.putString("PKG", getPackageName());
        if (x.b()) {
            bundle.putBoolean(SapiShareClient.f2870f, true);
        }
        parcel.writeBundle(bundle);
    }
}
