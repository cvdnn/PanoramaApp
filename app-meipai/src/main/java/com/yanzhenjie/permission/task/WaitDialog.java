package com.yanzhenjie.permission.task;

import android.content.Context;
import androidx.appcompat.app.AppCompatDialog;
import e.l.a.d;
import e.l.a.e;

public class WaitDialog extends AppCompatDialog {
    public WaitDialog(Context context) {
        super(context, e.Permission_Theme_Dialog_Wait);
        setContentView(d.permission_dialog_wait);
    }
}
