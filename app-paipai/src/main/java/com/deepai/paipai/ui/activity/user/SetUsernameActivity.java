package com.deepai.paipai.ui.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
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
import com.deepai.paipai.support.bean.LoginBean;
import com.deepai.paipai.support.utils.AppSP;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import com.deepai.paipai.ui.activity.basic.MainActivity;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class SetUsernameActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public String phoneNum;
    /* access modifiers changed from: private */
    public String pwd;
    /* access modifiers changed from: private */
    public EditText userNameET;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView((int) R.layout.activity_set_username);
        initTitle(-1);
        setTitleBackgroundColor(17170445);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        this.phoneNum = intent.getStringExtra("phoneNum");
        this.pwd = intent.getStringExtra("pwd");
        this.userNameET = (EditText) findViewById(R.id.edit_login_username);
        this.userNameET.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                String str;
                if (SetUsernameActivity.this.userNameET.length() > 15) {
                    String str2 = s.toString();
                    int cursorStart = SetUsernameActivity.this.userNameET.getSelectionStart();
                    if (cursorStart != SetUsernameActivity.this.userNameET.getSelectionEnd() || cursorStart >= str2.length() || cursorStart < 1) {
                        str = str2.substring(0, s.length() - 1);
                    } else {
                        str = str2.substring(0, cursorStart - 1) + str2.substring(cursorStart);
                    }
                    SetUsernameActivity.this.userNameET.setText(str);
                    SetUsernameActivity.this.userNameET.setSelection(SetUsernameActivity.this.userNameET.getText().length());
                }
            }
        });
    }

    public void doneRegister(View view) {
        String userName = this.userNameET.getText().toString();
        if (!FormatUtil.isUserName(userName)) {
            Toast.makeText(this, getString(R.string.user_name_blank_tip), 0).show();
        } else {
            userRegister(userName);
        }
    }

    private void userRegister(String userName) {
        Map<String, String> params = new HashMap<>();
        params.put("phone", this.phoneNum);
        params.put(RequestKey.PASSWORD, Util.md5(this.pwd));
        params.put(RequestKey.LOGIN_NAME, userName);
        PaiApp.vQueue.add(new StringPostRequest(AppConstant.USER_PHONE_REGISTER, params, new Listener<String>() {
            public void onResponse(String response) {
                try {
                    if (FormatUtil.getStringFromJson(response, AppConstant.CODE, AppConstant.SUCCESS)) {
                        SetUsernameActivity.this.login(SetUsernameActivity.this.phoneNum, SetUsernameActivity.this.pwd);
                    } else {
                        Toast.makeText(SetUsernameActivity.this, SetUsernameActivity.this.getString(R.string.check_code_send_fail_tip), 0).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(SetUsernameActivity.this, SetUsernameActivity.this.getString(R.string.check_code_send_fail_tip), 0).show();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (error.getClass() == MsgError.class) {
                    ToastFactory.getToast((Context) SetUsernameActivity.this, error.getMessage()).show();
                }
            }
        }));
    }

    public void login(String userName, String pwd2) {
        Map<String, String> params = new HashMap<>();
        params.put(RequestKey.LOGIN_NAME, userName);
        params.put(RequestKey.PASSWORD, Util.md5(pwd2));
        PaiApp.vQueue.add(new StringPostRequest(AppConstant.BASEUSERSERVICEURL_LOGIN, params, new Listener<String>() {
            public void onResponse(String response) {
                SetUsernameActivity.this.paserResponseMessage(response);
                SetUsernameActivity.this.startActivity(new Intent(SetUsernameActivity.this, MainActivity.class).setFlags(67108864));
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (error.getClass() == MsgError.class) {
                    ToastFactory.getToast((Context) SetUsernameActivity.this, error.getMessage()).show();
                }
            }
        }));
    }

    /* access modifiers changed from: private */
    public void paserResponseMessage(String response) {
        LoginBean bean = (LoginBean) new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create().fromJson(response, LoginBean.class);
        if (AppConstant.SUCCESS.equals(bean.getCode())) {
            ToastFactory.getToast((Context) this, "登录成功").show();
            AppSP.setToken(this, bean.getData().getToken());
            AppSP.setExpire(this, bean.getData().getExpire());
            AppSP.setUserName(this, bean.getData().getNickname());
            AppSP.setUserHeadUrl(this, bean.getData().getHeadimgurl());
            return;
        }
        ToastFactory.getToast((Context) this, "登录失败").show();
    }
}
