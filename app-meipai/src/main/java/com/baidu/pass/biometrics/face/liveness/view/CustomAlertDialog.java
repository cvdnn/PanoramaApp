package com.baidu.pass.biometrics.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.pass.biometrics.face.R;

public class CustomAlertDialog extends Dialog {
    public TextView msgText;
    public TextView negativeBtn;
    public TextView neutralBtn;
    public TextView positiveBtn;
    public TextView titleText;
    public ViewSwitcher viewSwitcher;

    public CustomAlertDialog(Context context) {
        super(context, R.style.PassBioBeautyDialog);
        init();
    }

    private void init() {
        setContentView(R.layout.layout_pass_liveness_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.viewSwitcher = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.titleText = (TextView) findViewById(R.id.title_text);
        this.msgText = (TextView) findViewById(R.id.msg_text);
        this.positiveBtn = (TextView) findViewById(R.id.positive_btn);
        this.negativeBtn = (TextView) findViewById(R.id.negative_btn);
        this.neutralBtn = (TextView) findViewById(R.id.neutral_btn);
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

    public void setMessageText(String str) {
        this.msgText.setText(str);
    }

    public void setMessageVisible(int i2) {
        this.msgText.setVisibility(i2);
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

    public void setTitleText(String str) {
        this.titleText.setText(str);
    }

    public void setTitleVisible(int i2) {
        this.titleText.setVisibility(i2);
    }
}
