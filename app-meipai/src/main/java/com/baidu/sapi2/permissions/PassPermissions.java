package com.baidu.sapi2.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.utils.SapiUtils;

public class PassPermissions {

    /* renamed from: a reason: collision with root package name */
    public static PassPermissions f2824a;

    /* renamed from: b reason: collision with root package name */
    public PermissionsDTO f2825b;

    /* renamed from: c reason: collision with root package name */
    public PermissionsCallback f2826c;

    public static synchronized PassPermissions getInstance() {
        PassPermissions passPermissions;
        synchronized (PassPermissions.class) {
            if (f2824a == null) {
                f2824a = new PassPermissions();
            }
            passPermissions = f2824a;
        }
        return passPermissions;
    }

    public PermissionsCallback getPermissionsCallback() {
        return this.f2826c;
    }

    public PermissionsDTO getPermissionsDTO() {
        return this.f2825b;
    }

    public void requestPermissions(PermissionsDTO permissionsDTO, final PermissionsCallback permissionsCallback) {
        if (!(permissionsDTO == null || permissionsDTO.context == null)) {
            String[] strArr = permissionsDTO.permissions;
            if (!(strArr == null || strArr.length == 0 || permissionsCallback == null)) {
                this.f2825b = permissionsDTO;
                this.f2826c = new PermissionsCallback() {
                    public AlertDialogInterface getDialog(Activity activity) {
                        return permissionsCallback.getDialog(activity);
                    }

                    public void onFailure() {
                        PassPermissions.this.a();
                        permissionsCallback.onFailure();
                    }

                    public void onSuccess() {
                        PassPermissions.this.a();
                        permissionsCallback.onSuccess();
                    }
                };
                if (a(permissionsDTO.permissions)) {
                    this.f2826c.onSuccess();
                    return;
                }
                Intent intent = new Intent(permissionsDTO.context, PermissionsHelperActivity.class);
                Context context = permissionsDTO.context;
                if (context instanceof Activity) {
                    context.startActivity(intent);
                } else {
                    intent.setFlags(268435456);
                    permissionsDTO.context.startActivity(intent);
                }
                return;
            }
        }
        throw new IllegalArgumentException("params is error");
    }

    public boolean a(String... strArr) {
        for (String checkRequestPermission : strArr) {
            if (!SapiUtils.checkRequestPermission(checkRequestPermission, this.f2825b.context)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f2825b = null;
        this.f2826c = null;
        f2824a = null;
    }
}
