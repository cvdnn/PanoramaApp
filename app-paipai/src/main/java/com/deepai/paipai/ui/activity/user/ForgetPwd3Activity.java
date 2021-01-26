package com.deepai.paipai.ui.activity.user;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.deepai.paipai.R;
import com.deepai.paipai.ui.activity.basic.BaseActivity;

public class ForgetPwd3Activity extends BaseActivity {
    private TextView loginNow;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_forget_pwd3);
        initTitle(R.string.forget_password_third_title);
        setTitleBackgroundColor(17170445);
        initView();
    }

    private void initView() {
        this.loginNow = (TextView) findViewById(R.id.tv_login_now);
        this.loginNow.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ForgetPwd3Activity.this.onBackPressed();
            }
        });
    }
}
