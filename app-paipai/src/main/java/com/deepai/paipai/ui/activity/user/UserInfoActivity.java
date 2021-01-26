package com.deepai.paipai.ui.activity.user;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.me.error.MsgError;
import com.android.volley.me.request.StringPostRequest;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.paipai.R;
import com.deepai.paipai.app.AppConstant;
import com.deepai.paipai.app.AppConstant.RequestKey;
import com.deepai.paipai.app.PaiApp;
import com.deepai.paipai.db.SQLHelper;
import com.deepai.paipai.support.bean.DataBean;
import com.deepai.paipai.support.bean.LoginBean;
import com.deepai.paipai.support.imageloader.UniversalImageLoadTool;
import com.deepai.paipai.support.net.MultiPartUtils;
import com.deepai.paipai.support.net.MultiPartUtils.CallBackResponseContent;
import com.deepai.paipai.support.utils.AppSP;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import com.deepai.paipai.wechattakephoto.WCTakePhotoActivity;
import com.deepai.paipai.wechattakephoto.manager.ImageTaker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoActivity extends BaseActivity implements CallBackResponseContent {
    /* access modifiers changed from: private */
    public Button btn_cancel;
    /* access modifiers changed from: private */
    public Button btn_change;
    /* access modifiers changed from: private */
    public AlertDialog changeDialog;
    /* access modifiers changed from: private */
    public TextView etUserName;
    /* access modifiers changed from: private */
    public EditText et_text;
    private String filePath;
    private Gson gson;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                UniversalImageLoadTool.disCirclePlay(AppConstant.BASEUSERSERVICEURL + msg.getData().getString("url"), UserInfoActivity.this.ivHeader, R.mipmap.logo_default, UserInfoActivity.this);
                ToastFactory.getToast((Context) UserInfoActivity.this, "修改成功").show();
            } else if (msg.what == 1) {
                ToastFactory.getToast((Context) UserInfoActivity.this, "修改失败").show();
            }
        }
    };
    /* access modifiers changed from: private */
    public ImageView ivHeader;
    private LinearLayout linHeader;
    private LinearLayout linUserName;
    /* access modifiers changed from: private */
    public String token;
    /* access modifiers changed from: private */
    public TextView tv_title;
    private String urlHeader;
    private String userName;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView((int) R.layout.activity_user_info);
        initTitle(R.string.text_title);
        initView();
        initData();
    }

    private void initView() {
        ImageTaker.INSTANCE.initTemp();
        this.linHeader = (LinearLayout) findViewById(R.id.lin_image_head);
        this.linUserName = (LinearLayout) findViewById(R.id.lin_user_name);
        this.ivHeader = (ImageView) findViewById(R.id.iv_header);
        this.etUserName = (TextView) findViewById(R.id.et_user_name);
    }

    /* access modifiers changed from: private */
    public void showChangeDialog() {
        if (this.changeDialog == null) {
            View view = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.dialog_contact_change, null);
            this.btn_change = (Button) view.findViewById(R.id.btn_change);
            this.btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
            this.et_text = (EditText) view.findViewById(R.id.et_text);
            this.tv_title = (TextView) view.findViewById(R.id.title);
            this.changeDialog = new Builder(this).create();
            this.changeDialog.setView(view, -10, 0, 0, 0);
        }
    }

    /* access modifiers changed from: private */
    public void paserResponseMessage(String response) {
        if (response != null && !TextUtils.isEmpty(response.trim())) {
            LoginBean bean = (LoginBean) this.gson.fromJson(response, LoginBean.class);
            if (bean.getCode() == null || !AppConstant.SUCCESS.equals(bean.getCode())) {
                ToastFactory.getToast((Context) this, "修改失败").show();
                return;
            }
            ToastFactory.getToast((Context) this, "修改成功").show();
            AppSP.setUserName(this, bean.getData().getNickname());
        }
    }

    private void initData() {
        this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
        this.token = AppSP.getToken(this, "").toString();
        this.userName = AppSP.getUserName(this, "").toString();
        this.urlHeader = AppSP.getUserHeadUrl(this, "").toString();
        this.etUserName.setText(this.userName);
        UniversalImageLoadTool.disCirclePlay(this.urlHeader, this.ivHeader, R.mipmap.logo_default, this);
        this.linHeader.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this, WCTakePhotoActivity.class);
                intent.putExtra(WCTakePhotoActivity.EK_SELECT_TYPE, -2);
                intent.putExtra(WCTakePhotoActivity.EK_CROP_WIDTH, 1200);
                intent.putExtra(WCTakePhotoActivity.EK_CROP_HEIGHT, 1200);
                UserInfoActivity.this.startActivityForResult(intent, 17);
            }
        });
        this.linUserName.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                UserInfoActivity.this.showChangeDialog();
                UserInfoActivity.this.et_text.setFilters(new InputFilter[]{new LengthFilter(15)});
                UserInfoActivity.this.et_text.setText(UserInfoActivity.this.etUserName.getText());
                UserInfoActivity.this.tv_title.setText("请输入用户昵称");
                UserInfoActivity.this.btn_change.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        UserInfoActivity.this.changeDialog.dismiss();
                        if (!TextUtils.isEmpty(UserInfoActivity.this.et_text.getText().toString())) {
                            UserInfoActivity.this.etUserName.setText(UserInfoActivity.this.et_text.getText().toString());
                            Map<String, String> params = new HashMap<>();
                            params.put(SQLHelper.NAME, UserInfoActivity.this.et_text.getText().toString());
                            params.put(RequestKey.TOKEN, UserInfoActivity.this.token);
                            PaiApp.vQueue.add(new StringPostRequest(AppConstant.BASEUSERSERVICEURL_NAME, params, new Listener<String>() {
                                public void onResponse(String response) {
                                    UserInfoActivity.this.paserResponseMessage(response);
                                }
                            }, new ErrorListener() {
                                public void onErrorResponse(VolleyError error) {
                                    if (error.getClass() == MsgError.class) {
                                        ToastFactory.getToast((Context) UserInfoActivity.this.activity, error.getMessage()).show();
                                    }
                                }
                            }));
                            return;
                        }
                        ToastFactory.getToast((Context) UserInfoActivity.this, "昵称不能为空").show();
                    }
                });
                UserInfoActivity.this.btn_cancel.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        UserInfoActivity.this.changeDialog.dismiss();
                    }
                });
                UserInfoActivity.this.changeDialog.show();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != -1) {
            Log.e("UserInfoActivity", "ActivityResult resultCode error");
        } else if (requestCode == 17) {
            List<String> imgPaths = data.getStringArrayListExtra(WCTakePhotoActivity.ACT_RESP_KEY);
            if (imgPaths != null && imgPaths.size() > 0) {
                this.filePath = (String) imgPaths.get(0);
            }
            File file = null;
            if (!TextUtils.isEmpty(this.filePath)) {
                file = new File(this.filePath);
            }
            if (file.exists()) {
                final File finalFile = file;
                new Thread() {
                    public void run() {
                        MultiPartUtils.upLoadParsonHomepageImage(UserInfoActivity.this, finalFile, AppConstant.BASEUSERSERVICEURL_HEADER, UserInfoActivity.this);
                    }
                }.start();
            }
            Log.e("UserInfoActivity", this.filePath + "");
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ImageTaker.INSTANCE.clearTemp();
        super.onDestroy();
    }

    public void getResponseContent(String result) {
        if (result == null || TextUtils.isEmpty(result)) {
            this.handler.sendEmptyMessage(1);
            return;
        }
        DataBean bean = (DataBean) this.gson.fromJson(result, DataBean.class);
        AppSP.setUserHeadUrl(this, AppConstant.BASEUSERSERVICEURL + bean.getHeadimgurl());
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("url", bean.getHeadimgurl());
        message.setData(bundle);
        message.what = 0;
        this.handler.sendMessage(message);
    }

    public void getFailContent(String result) {
        if (result != null && !TextUtils.isEmpty(result)) {
            this.handler.sendEmptyMessage(1);
            Log.e("UserInfoActivity", result + "");
        }
    }
}
