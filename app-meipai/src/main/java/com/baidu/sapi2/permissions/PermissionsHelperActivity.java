package com.baidu.sapi2.permissions;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.Log;

public class PermissionsHelperActivity extends Activity {

    /* renamed from: a reason: collision with root package name */
    public static final int f2829a = 8000;

    /* renamed from: b reason: collision with root package name */
    public static final int f2830b = 8001;

    /* renamed from: c reason: collision with root package name */
    public PermissionsDTO f2831c;

    /* renamed from: d reason: collision with root package name */
    public PermissionsCallback f2832d;

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 8000) {
            return;
        }
        if (PassPermissions.getInstance().a(PassPermissions.getInstance().getPermissionsDTO().permissions)) {
            this.f2832d.onSuccess();
            finish();
            return;
        }
        requestPermissions(this.f2831c.permissions, f2830b);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2831c = PassPermissions.getInstance().getPermissionsDTO();
        this.f2832d = PassPermissions.getInstance().getPermissionsCallback();
        PermissionsDTO permissionsDTO = this.f2831c;
        if (permissionsDTO == null) {
            Log.e(Log.TAG, "PermissionDTO is null!");
            PermissionsCallback permissionsCallback = this.f2832d;
            if (permissionsCallback != null) {
                permissionsCallback.onFailure();
            }
            finish();
            return;
        }
        requestPermissions(permissionsDTO.permissions, f2830b);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 8001) {
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 >= strArr.length) {
                    z = true;
                    break;
                } else if (iArr[i3] == 0) {
                    Log.i(Log.TAG, "Permission check result is permission granted");
                    i3++;
                } else {
                    AlertDialogInterface dialog = this.f2832d.getDialog(this);
                    if (TextUtils.isEmpty(this.f2831c.dialogMsg) || dialog == null) {
                        this.f2832d.onFailure();
                        finish();
                        return;
                    }
                    dialog.setTitleText(this.f2831c.dialogTitle);
                    dialog.setMessageText(this.f2831c.dialogMsg);
                    dialog.setNegativeBtn(SapiWebView.A, new OnClickListener() {
                        public void onClick(View view) {
                            PermissionsHelperActivity.this.f2832d.onFailure();
                            PermissionsHelperActivity.this.finish();
                        }
                    });
                    final String str = strArr[i3];
                    dialog.setPositiveBtn("去允许", new OnClickListener() {
                        public void onClick(View view) {
                            if (!PermissionsHelperActivity.this.shouldShowRequestPermissionRationale(str)) {
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.fromParts("package", PermissionsHelperActivity.this.getPackageName(), null));
                                PermissionsHelperActivity.this.startActivityForResult(intent, PermissionsHelperActivity.f2829a);
                                return;
                            }
                            PermissionsHelperActivity permissionsHelperActivity = PermissionsHelperActivity.this;
                            permissionsHelperActivity.requestPermissions(permissionsHelperActivity.f2831c.permissions, PermissionsHelperActivity.f2830b);
                        }
                    });
                    dialog.setCancel(false);
                    dialog.showDialog();
                }
            }
            if (z) {
                this.f2832d.onSuccess();
                finish();
            }
        }
    }
}
