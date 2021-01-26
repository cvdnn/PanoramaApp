package com.deepai.paipai.ui.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.deepai.paipai.R;
import com.deepai.paipai.ui.activity.basic.BaseActivity;

public class SetPwdActivity extends BaseActivity {
    private EditText confirmPwdEt;
    private String phoneNum;
    private EditText pwdEt;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView((int) R.layout.activity_set_pwd);
        initTitle(-1);
        setTitleBackgroundColor(17170445);
        initView();
    }

    private void initView() {
        this.phoneNum = getIntent().getStringExtra("phoneNum");
        this.pwdEt = (EditText) findViewById(R.id.et_pwd_one);
        this.confirmPwdEt = (EditText) findViewById(R.id.et_pwd_two);
    }

    public void nextStep(View view) {
        String pwd = this.pwdEt.getText().toString();
        String confirmPwd = this.confirmPwdEt.getText().toString();
        if (TextUtils.isEmpty(pwd) || TextUtils.isEmpty(confirmPwd)) {
            Toast.makeText(this, getString(R.string.pwd_blank_tip), 0).show();
        } else if (pwd.length() < 6) {
            Toast.makeText(this, getString(R.string.pwd_less_tip), 0).show();
        } else if (!pwd.equals(confirmPwd)) {
            Toast.makeText(this, getString(R.string.pwd_different_tip), 0).show();
        } else {
            Intent intent = new Intent(this, SetUsernameActivity.class);
            intent.putExtra("phoneNum", this.phoneNum);
            intent.putExtra("pwd", pwd);
            startActivity(intent);
        }
    }
}
