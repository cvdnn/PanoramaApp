package com.baidu.pass.biometrics.base.utils;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.pass.biometrics.base.debug.Log;

public class ViewUtility {
    public static void dismissDialog(Activity activity, Dialog dialog) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null");
        } else if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
    }
}
