package com.baidu.pass.biometrics.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.pass.biometrics.face.R;

public class BioAlertDialog extends Dialog {
    public TextView dialogMsg;
    public TextView dialogTitle;
    public TextView msgText;
    public Button negativeBtn;
    public TextView neutralBtn;
    public Button positiveBtn;
    public LinearLayout timeOutDialogLl;
    public ViewSwitcher viewSwitcher;

    public BioAlertDialog(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        init();
    }

    private void init() {
        setContentView(R.layout.layout_pass_liveness_alert_dialog);
        setCanceledOnTouchOutside(false);
        this.viewSwitcher = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.dialogTitle = (TextView) findViewById(R.id.dialog_title);
        this.dialogMsg = (TextView) findViewById(R.id.dialog_msg);
        this.msgText = (TextView) findViewById(R.id.msg_text);
        this.positiveBtn = (Button) findViewById(R.id.positive_btn);
        this.negativeBtn = (Button) findViewById(R.id.negative_btn);
        this.neutralBtn = (TextView) findViewById(R.id.neutral_btn);
        this.timeOutDialogLl = (LinearLayout) findViewById(R.id.time_out_dialog_msg);
    }

    public void setBtnCount(int i2) {
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 2) {
            i2 = 2;
        }
        if (i2 == 2) {
            this.viewSwitcher.setDisplayedChild(0);
        } else {
            this.viewSwitcher.setDisplayedChild(1);
        }
    }

    public void setDialogMsg(String str) {
        this.dialogMsg.setVisibility(0);
        this.dialogMsg.setText(str);
    }

    public void setDialogMsgColor(int i2) {
        this.dialogMsg.setTextColor(i2);
    }

    public void setMessageIcon(int i2) {
        this.msgText.setText(i2);
    }

    public void setMessageText(String str) {
        this.msgText.setVisibility(0);
        this.msgText.setText(str);
    }

    public void setNegativeBtn(String str, OnClickListener onClickListener) {
        this.negativeBtn.setText(str);
        this.negativeBtn.setOnClickListener(onClickListener);
    }

    public void setNeutralBtn(String str, OnClickListener onClickListener) {
        this.neutralBtn.setText(str);
        this.neutralBtn.setOnClickListener(onClickListener);
    }

    public void setPositiveBtn(String str, OnClickListener onClickListener) {
        this.positiveBtn.setText(str);
        this.positiveBtn.setOnClickListener(onClickListener);
    }

    public void setTimeOutVisible(int i2) {
        this.timeOutDialogLl.setVisibility(0);
    }

    public void setTitleMsg(String str) {
        this.dialogTitle.setText(str);
    }

    public void setTitleVisible(boolean z) {
        if (z) {
            this.dialogTitle.setVisibility(0);
        } else {
            this.dialogTitle.setVisibility(8);
        }
    }
}
