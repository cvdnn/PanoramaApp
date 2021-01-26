package com.deepai.paipai.ui.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.me.error.MsgError;
import com.android.volley.me.request.StringPostRequest;
import com.deepai.library.support.utils.FormatUtil;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.library.support.utils.Util;
import com.deepai.paipai.R;
import com.deepai.paipai.app.AppConstant;
import com.deepai.paipai.app.AppConstant.RequestKey;
import com.deepai.paipai.app.PaiApp;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class ForgetPwd2Activity extends BaseActivity {
    /* access modifiers changed from: private */
    public EditText confirmPwdEt;
    private TextView nextStep;
    private String phoneNum;
    /* access modifiers changed from: private */
    public EditText pwdEt;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_forget_pwd2);
        initTitle(R.string.forget_password_sec_title);
        setTitleBackgroundColor(17170445);
        initView();
    }

    private void initView() {
        this.phoneNum = getIntent().getStringExtra("phoneNum");
        this.pwdEt = (EditText) findViewById(R.id.et_pwd_one);
        this.confirmPwdEt = (EditText) findViewById(R.id.et_pwd_two);
        this.nextStep = (TextView) findViewById(R.id.tv_next_step);
        this.nextStep.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String pwd = ForgetPwd2Activity.this.pwdEt.getText().toString();
                String confirmPwd = ForgetPwd2Activity.this.confirmPwdEt.getText().toString();
                if (TextUtils.isEmpty(pwd) || TextUtils.isEmpty(confirmPwd)) {
                    Toast.makeText(ForgetPwd2Activity.this, ForgetPwd2Activity.this.getString(R.string.pwd_blank_tip), 0).show();
                } else if (!pwd.equals(confirmPwd)) {
                    Toast.makeText(ForgetPwd2Activity.this, ForgetPwd2Activity.this.getString(R.string.pwd_different_tip), 0).show();
                } else {
                    ForgetPwd2Activity.this.updatePwd(pwd);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void updatePwd(String pwd) {
        Map<String, String> params = new HashMap<>();
        params.put(RequestKey.LOGIN_NAME, this.phoneNum);
        params.put(RequestKey.PASSWORD, Util.md5(pwd));
        PaiApp.vQueue.add(new StringPostRequest(AppConstant.UPDATE_PASSWORD, params, new Listener<String>() {
            public void onResponse(String response) {
                try {
                    if (FormatUtil.getStringFromJson(response, AppConstant.CODE, AppConstant.SUCCESS)) {
                        ForgetPwd2Activity.this.startActivity(new Intent(ForgetPwd2Activity.this, ForgetPwd3Activity.class));
                        ForgetPwd2Activity.this.onBackPressed();
                        return;
                    }
                    Toast.makeText(ForgetPwd2Activity.this, ForgetPwd2Activity.this.getString(R.string.reset_pwd_fail_tip), 0).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(ForgetPwd2Activity.this, ForgetPwd2Activity.this.getString(R.string.reset_pwd_fail_tip), 0).show();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (error.getClass() == MsgError.class) {
                    ToastFactory.getToast((Context) ForgetPwd2Activity.this, error.getMessage()).show();
                } else {
                    ToastFactory.getToast((Context) ForgetPwd2Activity.this, "服务器忙，请稍后再试").show();
                }
            }
        }));
    }
}
