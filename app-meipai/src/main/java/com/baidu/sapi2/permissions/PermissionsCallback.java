package com.baidu.sapi2.permissions;

import android.app.Activity;

public interface PermissionsCallback {
    AlertDialogInterface getDialog(Activity activity);

    void onFailure();

    void onSuccess();
}
