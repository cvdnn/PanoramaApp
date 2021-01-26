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

public class RegisterActivity extends BaseActivity {
    private EditText checkCodeET;
    /* access modifiers changed from: private */
    public boolean isVerifyPhoneNum = true;
    private TextView nextStepTV;
    /* access modifiers changed from: private */
    public EditText phoneNumET;
    private TextView sendCheckCodeTV;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView((int) R.layout.activity_register);
        initTitle(-1);
        setTitleBackgroundColor(17170445);
        initView();
    }

    private void initView() {
        this.phoneNumET = (EditText) findViewById(R.id.et_register_tel);
        this.checkCodeET = (EditText) findViewById(R.id.et_check_code);
        this.sendCheckCodeTV = (TextView) findViewById(R.id.tv_send_check_code);
        this.nextStepTV = (TextView) findViewById(R.id.tv_next_step);
        this.sendCheckCodeTV.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String phoneNum = RegisterActivity.this.phoneNumET.getText().toString();
                if (FormatUtil.isMobileNO(phoneNum)) {
                    RegisterActivity.this.sendCheckCode(phoneNum);
                } else {
                    Toast.makeText(RegisterActivity.this, RegisterActivity.this.getString(R.string.phone_format_error_tip), 0).show();
                }
            }
        });
    }

    public void nextStep(View view) {
        String phoneNum = this.phoneNumET.getText().toString();
        if (!FormatUtil.isMobileNO(phoneNum)) {
            Toast.makeText(this, getString(R.string.phone_format_error_tip), 0).show();
            return;
        }
        String code = this.checkCodeET.getText().toString();
        if (!FormatUtil.isIdentify(code)) {
            Toast.makeText(this, getString(R.string.check_code_format_error_tip), 0).show();
        } else {
            verifyCheckCode(phoneNum, code);
        }
    }

    /* access modifiers changed from: private */
    public void sendCheckCode(String phoneNum) {
        Map<String, String> params = new HashMap<>();
        params.put(RequestKey.LOGIN_NAME, phoneNum);
        params.put("type", "0");
        PaiApp.vQueue.add(new StringPostRequest(AppConstant.SEND_CHECK_CODE, params, new Listener<String>() {
            public void onResponse(String response) {
                try {
                    if (FormatUtil.getStringFromJson(response, AppConstant.CODE, AppConstant.SUCCESS)) {
                        Toast.makeText(RegisterActivity.this, RegisterActivity.this.getString(R.string.check_code_send_success_tip), 0).show();
                    } else {
                        Toast.makeText(RegisterActivity.this, RegisterActivity.this.getString(R.string.check_code_send_fail_tip), 0).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(RegisterActivity.this, RegisterActivity.this.getString(R.string.check_code_send_fail_tip), 0).show();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (error.getClass() == MsgError.class) {
                    ToastFactory.getToast((Context) RegisterActivity.this, error.getMessage()).show();
                } else {
                    ToastFactory.getToast((Context) RegisterActivity.this, "服务器正忙，请稍后再试").show();
                }
            }
        }));
    }

    private void verifyPhoneNum(String phoneNum) {
        Map<String, String> params = new HashMap<>();
        params.put("phone", phoneNum);
        PaiApp.vQueue.add(new StringPostRequest(AppConstant.VERIFY_PHONE_NUM, params, new Listener<String>() {
            public void onResponse(String response) {
                try {
                    if (FormatUtil.getStringFromJson(response, AppConstant.CODE, AppConstant.FAIL)) {
                        Toast.makeText(RegisterActivity.this, RegisterActivity.this.getString(R.string.phone_num_repeat_tip), 0).show();
                        RegisterActivity.this.isVerifyPhoneNum = false;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(RegisterActivity.this, RegisterActivity.this.getString(R.string.phone_num_repeat_tip), 0).show();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (error.getClass() == MsgError.class) {
                    ToastFactory.getToast((Context) RegisterActivity.this, error.getMessage()).show();
                } else {
                    ToastFactory.getToast((Context) RegisterActivity.this, "服务器正忙，请稍后再试").show();
                }
            }
        }));
    }

    private void verifyCheckCode(final String phoneNum, String code) {
        Map<String, String> params = new HashMap<>();
        params.put(RequestKey.LOGIN_NAME, phoneNum);
        params.put("identify", code);
        PaiApp.vQueue.add(new StringPostRequest(AppConstant.VERIFY_CHECK_CODE, params, new Listener<String>() {
            public void onResponse(String response) {
                try {
                    if (FormatUtil.getStringFromJson(response, AppConstant.CODE, AppConstant.SUCCESS)) {
                        Intent intent = new Intent(RegisterActivity.this, SetPwdActivity.class);
                        intent.putExtra("phoneNum", phoneNum);
                        RegisterActivity.this.startActivity(intent);
                        RegisterActivity.this.onBackPressed();
                        return;
                    }
                    Toast.makeText(RegisterActivity.this, RegisterActivity.this.getString(R.string.check_code_send_fail_tip), 0).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(RegisterActivity.this, RegisterActivity.this.getString(R.string.check_code_send_fail_tip), 0).show();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (error.getClass() == MsgError.class) {
                    ToastFactory.getToast((Context) RegisterActivity.this, error.getMessage()).show();
                } else {
                    ToastFactory.getToast((Context) RegisterActivity.this, "服务器正忙，请稍后再试").show();
                }
            }
        }));
    }
}
