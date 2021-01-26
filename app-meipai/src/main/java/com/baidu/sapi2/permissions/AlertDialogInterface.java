package com.baidu.sapi2.permissions;

import android.view.View.OnClickListener;

public interface AlertDialogInterface {
    void setCancel(boolean z);

    void setMessageText(String str);

    void setNegativeBtn(String str, OnClickListener onClickListener);

    void setPositiveBtn(String str, OnClickListener onClickListener);

    void setTitleText(String str);

    void showDialog();
}
