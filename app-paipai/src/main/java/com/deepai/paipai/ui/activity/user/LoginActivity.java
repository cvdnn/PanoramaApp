package com.deepai.paipai.ui.activity.user;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.me.error.MsgError;
import com.android.volley.me.request.StringPostRequest;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.library.support.utils.Util;
import com.deepai.paipai.R;
import com.deepai.paipai.app.AppConstant;
import com.deepai.paipai.app.AppConstant.RequestKey;
import com.deepai.paipai.app.PaiApp;
import com.deepai.paipai.db.SQLHelper;
import com.deepai.paipai.support.bean.LoginBean;
import com.deepai.paipai.support.utils.AppSP;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity implements PlatformActionListener, Callback {
    private EditText etUserName;
    private EditText etUserPsw;
    private TextView forgetpwd;
    private Gson gson;
    /* access modifiers changed from: private */
    public ProgressDialog mProgressBar;
    private String regType;
    private int type;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        ShareSDK.initSDK(this);
        setContentView((int) R.layout.activity_login);
        initTitle(-1);
        setTitleBackgroundColor(17170445);
        initView();
    }

    private void initView() {
        this.mProgressBar = getProgressBar();
        this.etUserName = (EditText) findViewById(R.id.edit_login_username);
        this.etUserPsw = (EditText) findViewById(R.id.edit_login_password);
        this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
        String phone = AppSP.getUserNumber(this, "").toString();
        if (!TextUtils.isEmpty(phone)) {
            this.etUserName.setText(phone);
        }
        this.forgetpwd = (TextView) findViewById(R.id.tv_forget_pwd);
        this.forgetpwd.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LoginActivity.this.onForgetPasswordClick(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public void paserResponseMessage(String response) {
        if (response == null || TextUtils.isEmpty(response.trim())) {
            ToastFactory.getToast((Context) this, "登录失败").show();
            return;
        }
        LoginBean bean = (LoginBean) this.gson.fromJson(response, LoginBean.class);
        if (bean.getCode() == null || !AppConstant.SUCCESS.equals(bean.getCode())) {
            ToastFactory.getToast((Context) this, "登录失败").show();
            return;
        }
        ToastFactory.getToast((Context) this, "登录成功").show();
        AppSP.setToken(this, bean.getData().getToken());
        AppSP.setExpire(this, bean.getData().getExpire());
        AppSP.setUserName(this, bean.getData().getNickname());
        AppSP.setUserNumber(this, this.etUserName.getText().toString());
        if (1 == this.type) {
            AppSP.setUserHeadUrl(this, bean.getData().getHeadimgurl());
        } else {
            AppSP.setUserHeadUrl(this, AppConstant.BASEUSERSERVICEURL + bean.getData().getHeadimgurl());
        }
        onBackPressed();
    }

    public void onLoginClick(View view) {
        this.type = 0;
        this.mProgressBar.show();
        Map<String, String> params = new HashMap<>();
        if (!TextUtils.isEmpty(this.etUserName.getText().toString())) {
            params.put(RequestKey.LOGIN_NAME, this.etUserName.getText().toString());
            if (!TextUtils.isEmpty(this.etUserPsw.getText().toString())) {
                params.put(RequestKey.PASSWORD, Util.md5(this.etUserPsw.getText().toString()));
                PaiApp.vQueue.add(new StringPostRequest(AppConstant.BASEUSERSERVICEURL_LOGIN, params, new Listener<String>() {
                    public void onResponse(String response) {
                        if (LoginActivity.this.mProgressBar != null && LoginActivity.this.mProgressBar.isShowing()) {
                            LoginActivity.this.mProgressBar.dismiss();
                        }
                        LoginActivity.this.paserResponseMessage(response);
                    }
                }, new ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        if (LoginActivity.this.mProgressBar != null && LoginActivity.this.mProgressBar.isShowing()) {
                            LoginActivity.this.mProgressBar.dismiss();
                        }
                        if (error.getClass() == MsgError.class) {
                            ToastFactory.getToast((Context) LoginActivity.this, error.getMessage()).show();
                        } else {
                            ToastFactory.getToast((Context) LoginActivity.this, "服务器正忙，请稍后再试").show();
                        }
                    }
                }));
                return;
            }
            if (this.mProgressBar != null && this.mProgressBar.isShowing()) {
                this.mProgressBar.dismiss();
            }
            ToastFactory.getToast((Context) this, "密码不能为空").show();
            return;
        }
        if (this.mProgressBar != null && this.mProgressBar.isShowing()) {
            this.mProgressBar.dismiss();
        }
        ToastFactory.getToast((Context) this, "登录名不能为空").show();
    }

    public void onRegisterClick(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void onForgetPasswordClick(View view) {
        startActivity(new Intent(this, ForgetPwdActivity.class));
    }

    public void onWXLoginClick(View view) {
        this.regType = "4";
        authorizeThirdLoginPlat(Wechat.NAME);
    }

    public void onQQLoginClick(View view) {
        this.regType = "3";
        authorizeThirdLoginPlat(QQ.NAME);
    }

    public void onSinaLoginClick(View view) {
        this.regType = "5";
        authorizeThirdLoginPlat(SinaWeibo.NAME);
    }

    private void authorizeThirdLoginPlat(String platName) {
        this.mProgressBar.show();
        Platform plat = ShareSDK.getPlatform(this, platName);
        plat.SSOSetting(false);
        plat.showUser(null);
        plat.setPlatformActionListener(this);
        if (!plat.isValid()) {
            plat.authorize();
        }
    }

    private void workLoginSuccessBack(Message message) {
        this.type = 1;
        Bundle bundle = message.getData();
        String string = bundle.getString("platName");
        String userId = bundle.getString("userId");
        String userName = bundle.getString("userName");
        String userIcon = bundle.getString("userIcon");
        Map<String, String> params = new HashMap<>();
        params.put("thirduid", userId);
        params.put("regType", this.regType);
        params.put(SQLHelper.NAME, userName);
        params.put("headimgurl", userIcon);
        PaiApp.vQueue.add(new StringPostRequest(AppConstant.BASEUSERSERVICEURL_THIRD_LOGIN, params, new Listener<String>() {
            public void onResponse(String response) {
                if (LoginActivity.this.mProgressBar != null && LoginActivity.this.mProgressBar.isShowing()) {
                    LoginActivity.this.mProgressBar.dismiss();
                }
                LoginActivity.this.paserResponseMessage(response);
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                if (LoginActivity.this.mProgressBar != null && LoginActivity.this.mProgressBar.isShowing()) {
                    LoginActivity.this.mProgressBar.dismiss();
                }
                if (error.getClass() == MsgError.class) {
                    ToastFactory.getToast((Context) LoginActivity.this, error.getMessage()).show();
                } else {
                    ToastFactory.getToast((Context) LoginActivity.this, "服务器正忙，请稍后再试").show();
                }
            }
        }));
    }

    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        if (i == 8) {
            Message message = new Message();
            message.what = 0;
            Bundle bundle = new Bundle();
            bundle.putString("platName", platform.getName());
            bundle.putString("userId", platform.getDb().getUserId());
            bundle.putString("userName", platform.getDb().getUserName());
            bundle.putString("userIcon", platform.getDb().getUserIcon());
            message.setData(bundle);
            UIHandler.sendMessage(message, this);
        } else if (this.mProgressBar != null && this.mProgressBar.isShowing()) {
            this.mProgressBar.dismiss();
        }
    }

    public void onError(Platform platform, int i, Throwable throwable) {
        if (i == 8) {
            UIHandler.sendEmptyMessage(1, this);
        } else if (this.mProgressBar != null && this.mProgressBar.isShowing()) {
            this.mProgressBar.dismiss();
        }
        throwable.printStackTrace();
    }

    public void onCancel(Platform platform, int i) {
        UIHandler.sendEmptyMessage(2, this);
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                workLoginSuccessBack(msg);
                break;
            case 1:
                if (this.mProgressBar != null && this.mProgressBar.isShowing()) {
                    this.mProgressBar.dismiss();
                }
                ToastFactory.getToast((Context) this, "登录失败，请稍后重试").show();
                break;
            case 2:
                if (this.mProgressBar != null && this.mProgressBar.isShowing()) {
                    this.mProgressBar.dismiss();
                }
                ToastFactory.getToast((Context) this, "已取消登录").show();
                break;
        }
        return false;
    }

    private ProgressDialog getProgressBar() {
        ProgressDialog mypDialog = new ProgressDialog(this);
        mypDialog.setProgressStyle(0);
        mypDialog.setMessage("正在登录中，请稍后...");
        mypDialog.setIndeterminate(false);
        mypDialog.setCancelable(true);
        return mypDialog;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ShareSDK.stopSDK(this);
        super.onDestroy();
    }
}
