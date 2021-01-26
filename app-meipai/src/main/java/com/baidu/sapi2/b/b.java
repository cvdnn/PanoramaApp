package com.baidu.sapi2.b;

import android.view.View.OnClickListener;

/* compiled from: FingerprintDialogInterface */
public interface b {
    b a();

    b a(int i2);

    b a(String str, String str2);

    b setNegativeBtn(String str, OnClickListener onClickListener);

    b setPositiveBtn(String str, OnClickListener onClickListener);

    void showDialog();
}
