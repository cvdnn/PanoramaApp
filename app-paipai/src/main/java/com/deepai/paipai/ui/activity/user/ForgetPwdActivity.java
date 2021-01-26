package com.deepai.paipai.ui.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.baidu.location.c.d;
import com.deepai.library.support.utils.FormatUtil;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.paipai.R;
import com.deepai.paipai.app.AppConstant;
import com.deepai.paipai.app.AppConstant.RequestKey;
import com.deepai.paipai.app.PaiApp;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class ForgetPwdActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public EditText checkCode;
    /* access modifiers changed from: private */
    public EditText forgetPwdTel;
    private TextView nextStep;
    private TextView sendCheckCode;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_forget_pwd);
        initTitle(R.string.forget_password_first_title);
        setTitleBackgroundColor(17170445);
        initView();
    }

    private void initView() {
        this.forgetPwdTel = (EditText) findViewById(R.id.et_forget_pwd_tel);
        this.checkCode = (EditText) findViewById(R.id.et_check_code);
        this.sendCheckCode = (TextView) findViewById(R.id.tv_send_check_code);
        this.nextStep = (TextView) findViewById(R.id.tv_next_step);
        this.sendCheckCode.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String phoneNum = ForgetPwdActivity.this.forgetPwdTel.getText().toString();
                if (FormatUtil.isMobileNO(phoneNum)) {
                    ForgetPwdActivity.this.sendCheckCode(phoneNum);
                } else {
                    Toast.makeText(ForgetPwdActivity.this, ForgetPwdActivity.this.getString(R.string.phone_format_error_tip), 0).show();
                }
            }
        });
        this.nextStep.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String phoneNum = ForgetPwdActivity.this.forgetPwdTel.getText().toString();
                if (!FormatUtil.isMobileNO(phoneNum)) {
                    Toast.makeText(ForgetPwdActivity.this, ForgetPwdActivity.this.getString(R.string.phone_format_error_tip), 0).show();
                    return;
                }
                String code = ForgetPwdActivity.this.checkCode.getText().toString();
                if (!FormatUtil.isIdentify(code)) {
                    Toast.makeText(ForgetPwdActivity.this, ForgetPwdActivity.this.getString(R.string.check_code_format_error_tip), 0).show();
                } else {
                    ForgetPwdActivity.this.verifyCheckCode(phoneNum, code);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void sendCheckCode(String phoneNum) {
        Map<String, String> params = new HashMap<>();
        params.put(RequestKey.LOGIN_NAME, phoneNum);
        params.put("type", d.ai);
        PaiApp.vQueue.add(new StringPostRequest(AppConstant.SEND_CHECK_CODE, params, new Listener<String>() {
            public void onResponse(String response) {
                try {
                    if (FormatUtil.getStringFromJson(response, AppConstant.CODE, AppConstant.SUCCESS)) {
                        Toast.makeText(ForgetPwdActivity.this, ForgetPwdActivity.this.getString(R.string.check_code_send_success_tip), 0).show();
                    } else {
                        Toast.makeText(ForgetPwdActivity.this, ForgetPwdActivity.this.getString(R.string.check_code_send_fail_tip), 0).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(ForgetPwdActivity.this, ForgetPwdActivity.this.getString(R.string.check_code_send_fail_tip), 0).show();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (error.getClass() == MsgError.class) {
                    ToastFactory.getToast((Context) ForgetPwdActivity.this, error.getMessage()).show();
                } else {
                    ToastFactory.getToast((Context) ForgetPwdActivity.this, "服务器忙，请稍后再试").show();
                }
            }
        }));
    }

    /* access modifiers changed from: private */
    public void verifyCheckCode(final String phoneNum, String code) {
        Map<String, String> params = new HashMap<>();
        params.put(RequestKey.LOGIN_NAME, phoneNum);
        params.put("identify", code);
        PaiApp.vQueue.add(new StringPostRequest(AppConstant.VERIFY_CHECK_CODE, params, new Listener<String>() {
            public void onResponse(String response) {
                try {
                    if (FormatUtil.getStringFromJson(response, AppConstant.CODE, AppConstant.SUCCESS)) {
                        Intent intent = new Intent(ForgetPwdActivity.this, ForgetPwd2Activity.class);
                        intent.putExtra("phoneNum", phoneNum);
                        ForgetPwdActivity.this.startActivity(intent);
                        ForgetPwdActivity.this.onBackPressed();
                        return;
                    }
                    Toast.makeText(ForgetPwdActivity.this, ForgetPwdActivity.this.getString(R.string.check_code_error_tip), 0).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(ForgetPwdActivity.this, ForgetPwdActivity.this.getString(R.string.check_code_error_tip), 0).show();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (error.getClass() == MsgError.class) {
                    ToastFactory.getToast((Context) ForgetPwdActivity.this, error.getMessage()).show();
                } else {
                    ToastFactory.getToast((Context) ForgetPwdActivity.this, "服务器忙，请稍后再试").show();
                }
            }
        }));
    }
}
