package com.deepai.paipai.ui.activity.share;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import cn.sharesdk.framework.ShareSDK;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.paipai.R;
import com.deepai.paipai.app.AppConstant;
import com.deepai.paipai.support.bean.HideInfo;
import com.deepai.paipai.support.bean.SaveShareDataBean;
import com.deepai.paipai.support.net.MultiPartUtils;
import com.deepai.paipai.support.net.MultiPartUtils.CallBackResponseContent;
import com.deepai.paipai.support.net.NetConstants;
import com.deepai.paipai.support.share.ShareSDKUtil;
import com.deepai.paipai.support.utils.AppSP;
import com.deepai.paipai.support.utils.BaiDuLocationResult;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import com.deepai.paipai.ui.activity.basic.MainActivity;
import com.deepai.paipai.ui.activity.user.LoginActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SaveShareActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public String editDate;
    private String hideContent = "";
    private String imagShowPath = "";
    private ImageView mBackImage;
    private TextView mBackText;
    private BaiDuLocationResult mBaiDuLocationResult;
    private EditText mEditImag;
    /* access modifiers changed from: private */
    public ProgressDialog mProgressBar;
    /* access modifiers changed from: private */
    public ShareSDKUtil mShareSDKUtil;
    private TextView mShareText;
    /* access modifiers changed from: private */
    public TextView mTextLoaction;
    private TextView mTitleText;
    private String musicName = "";
    /* access modifiers changed from: private */
    public String showLocation = "";
    /* access modifiers changed from: private */
    public String uploadTip = "";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        ShareSDK.initSDK(this);
        setContentView((int) R.layout.activity_save_share);
        initView();
    }

    private void initView() {
        this.mBackImage = (ImageView) findViewById(R.id.iv_back);
        this.mBackText = (TextView) findViewById(R.id.tv_left);
        this.mTitleText = (TextView) findViewById(R.id.tv_title);
        this.mShareText = (TextView) findViewById(R.id.tv_right);
        this.mEditImag = (EditText) findViewById(R.id.edit_image_text);
        this.mTextLoaction = (TextView) findViewById(R.id.text_location);
        this.mBackImage.setVisibility(0);
        this.mBackText.setVisibility(0);
        this.mTitleText.setVisibility(0);
        this.mShareText.setVisibility(0);
        this.mTitleText.setText("保存分享");
        this.mShareText.setText("稍后分享");
        this.mShareSDKUtil = new ShareSDKUtil(this);
        getBuddleData();
        updateLocation();
    }

    private void getBuddleData() {
        SaveShareDataBean bean = (SaveShareDataBean) getIntent().getExtras().getSerializable("saveShareData");
        if (bean != null) {
            this.imagShowPath = bean.getPhotoImagPath();
            this.hideContent = bean.getHideInform();
            this.musicName = bean.getMusicName();
        }
    }

    private void publishData(int type) {
        this.editDate = this.mEditImag.getText().toString().trim();
        if (TextUtils.isEmpty(this.editDate)) {
            this.editDate = "【全景】申义集团";
        } else {
            this.editDate = "【全景】" + this.editDate;
        }
        File file = new File(this.imagShowPath);
        String token = AppSP.getToken(this, "").toString();
        if (TextUtils.isEmpty(token)) {
            jumpToActivity(this, LoginActivity.class, null);
            return;
        }
        String[] upLoadStr = {this.imagShowPath, token, this.editDate, this.showLocation, this.hideContent, this.musicName};
        if (file.exists()) {
            this.mProgressBar = getProgressBar();
            this.mProgressBar.show();
            asynTaskUpLoadFile(upLoadStr, type);
            return;
        }
        ToastFactory.getToast((Context) this, "无上传图片").show();
    }

    public void onSinaClick(View view) {
        publishData(2);
    }

    public void onWXFreindClick(View view) {
        publishData(3);
    }

    public void onQQZnoeClick(View view) {
        publishData(1);
    }

    public void onTitleLeftClick(View view) {
        onBackPressed();
    }

    public void onTitleRightClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        onBackPressed();
    }

    public void onSendClick(View view) {
        publishData(0);
    }

    private void updateLocation() {
        if (this.mBaiDuLocationResult == null) {
            this.mBaiDuLocationResult = new BaiDuLocationResult();
        }
        if (this.mBaiDuLocationResult != null) {
            this.mBaiDuLocationResult.getPositionResult(this, new BDLocationListener() {
                public void onReceiveLocation(BDLocation location) {
                    if (location != null) {
                        double longitude = location.getLongitude();
                        double latitude = location.getLatitude();
                        String province = location.getProvince();
                        String city = location.getCity();
                        String address = location.getAddrStr();
                        if (TextUtils.isEmpty(address)) {
                            SaveShareActivity.this.showLocation = "无法定位";
                        } else {
                            SaveShareActivity.this.showLocation = address;
                        }
                        SaveShareActivity.this.mTextLoaction.setText(SaveShareActivity.this.showLocation);
                    }
                }
            });
        }
    }

    public void onDestroy() {
        if (this.mBaiDuLocationResult != null) {
            this.mBaiDuLocationResult.stopBaiduSDK();
        }
        super.onDestroy();
    }

    private ProgressDialog getProgressBar() {
        ProgressDialog mypDialog = new ProgressDialog(this);
        mypDialog.setProgressStyle(0);
        mypDialog.setMessage("正在发表中，请稍后...");
        mypDialog.setIndeterminate(false);
        mypDialog.setCancelable(true);
        return mypDialog;
    }

    private void asynTaskUpLoadFile(String[] upLoadStr, final int type) {
        new AsyncTask<String[], Void, String>() {
            /* access modifiers changed from: protected */
            public String doInBackground(String[]... params) {
                final File imageFile = new File(params[0][0]);
                final String token = params[0][1];
                final String imageContent = params[0][2];
                final String loStr = params[0][3];
                final String nameMusic = params[0][5];
                String hideContent = params[0][4];
                if (!TextUtils.isEmpty(hideContent)) {
                    final List<HideInfo> hideInfoList = (List) new Gson().fromJson(hideContent, new TypeToken<List<HideInfo>>() {
                    }.getType());
                    if (hideInfoList == null || hideInfoList.size() <= 0) {
                        String str = NetConstants.ADD_IMAGE;
                        AnonymousClass4 r0 = new CallBackResponseContent() {
                            public void getResponseContent(String result) {
                                SaveShareActivity.this.uploadTip = result;
                            }

                            public void getFailContent(String result) {
                                SaveShareActivity.this.uploadTip = "error";
                            }
                        };
                        MultiPartUtils.upLoadAddImage(imageFile, token, imageContent, loStr, hideContent, nameMusic, str, r0);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < hideInfoList.size(); i++) {
                            String localUrl = ((HideInfo) hideInfoList.get(i)).getRecordUrlLocal();
                            if (!TextUtils.isEmpty(localUrl)) {
                                arrayList.add(localUrl);
                            }
                        }
                        if (arrayList.size() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                File file = new File((String) arrayList.get(i2));
                                if (file.exists()) {
                                    arrayList2.add(file);
                                }
                            }
                            File[] files = new File[arrayList2.size()];
                            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                                files[i3] = (File) arrayList2.get(i3);
                            }
                            MultiPartUtils.upLoadArmFile(files, params[0][1], NetConstants.ARM_UPLOAD, new CallBackResponseContent() {
                                public void getResponseContent(String result) {
                                    if (!TextUtils.isEmpty(result)) {
                                        try {
                                            JSONArray array = new JSONObject(result).getJSONArray(AppConstant.DATA);
                                            int count = 0;
                                            int length = array.length();
                                            for (int i = 0; i < hideInfoList.size(); i++) {
                                                HideInfo hideInfo = (HideInfo) hideInfoList.get(i);
                                                if (hideInfo.getType() == 3 && count < length) {
                                                    hideInfo.setRecordUrl("http://www.paipai360.cn/paipai360" + array.getString(count));
                                                    count++;
                                                }
                                            }
                                            MultiPartUtils.upLoadAddImage(imageFile, token, imageContent, loStr, new Gson().toJson((Object) hideInfoList), nameMusic, NetConstants.ADD_IMAGE, new CallBackResponseContent() {
                                                public void getResponseContent(String result) {
                                                    SaveShareActivity.this.uploadTip = result;
                                                }

                                                public void getFailContent(String result) {
                                                    SaveShareActivity.this.uploadTip = "error";
                                                }
                                            });
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                                public void getFailContent(String result) {
                                    SaveShareActivity.this.uploadTip = "error";
                                }
                            });
                        } else {
                            String str2 = NetConstants.ADD_IMAGE;
                            AnonymousClass3 r02 = new CallBackResponseContent() {
                                public void getResponseContent(String result) {
                                    SaveShareActivity.this.uploadTip = result;
                                }

                                public void getFailContent(String result) {
                                    SaveShareActivity.this.uploadTip = "error";
                                }
                            };
                            MultiPartUtils.upLoadAddImage(imageFile, token, imageContent, loStr, hideContent, nameMusic, str2, r02);
                        }
                    }
                } else {
                    String str3 = NetConstants.ADD_IMAGE;
                    AnonymousClass5 r03 = new CallBackResponseContent() {
                        public void getResponseContent(String result) {
                            SaveShareActivity.this.uploadTip = result;
                        }

                        public void getFailContent(String result) {
                            SaveShareActivity.this.uploadTip = "error";
                        }
                    };
                    MultiPartUtils.upLoadAddImage(imageFile, token, imageContent, loStr, hideContent, nameMusic, str3, r03);
                }
                return SaveShareActivity.this.uploadTip;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(String s) {
                super.onPostExecute(s);
                if (TextUtils.isEmpty(s)) {
                    if (SaveShareActivity.this.mProgressBar != null && SaveShareActivity.this.mProgressBar.isShowing()) {
                        SaveShareActivity.this.mProgressBar.dismiss();
                    }
                    ToastFactory.getToast((Context) SaveShareActivity.this, "服务器正忙，请稍后再试").show();
                } else if (!"error".equals(s)) {
                    if (SaveShareActivity.this.mProgressBar != null && SaveShareActivity.this.mProgressBar.isShowing()) {
                        SaveShareActivity.this.mProgressBar.dismiss();
                    }
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        if (AppConstant.SUCCESS.equals(jsonObject.getString(AppConstant.CODE))) {
                            JSONObject dataBean = jsonObject.getJSONObject(AppConstant.DATA);
                            String shareUrl = dataBean.getString("shareUrl");
                            String shareId = dataBean.getString("id");
                            String photoUrl = dataBean.getString("url");
                            if (!photoUrl.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                                photoUrl = "http://www.paipai360.cn/paipai360" + photoUrl;
                            }
                            if (!shareUrl.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                                if (shareUrl.startsWith(CookieSpec.PATH_DELIM)) {
                                    shareUrl = "http://www.paipai360.cn/paipai360" + shareUrl;
                                } else {
                                    shareUrl = AppConstant.BASEUSERSERVICEURL + shareUrl;
                                }
                            }
                            switch (type) {
                                case 0:
                                    ToastFactory.getToast((Context) SaveShareActivity.this, "发表成功").show();
                                    SaveShareActivity.this.jumpToActivity(SaveShareActivity.this, ShareSuccessActivity.class, null);
                                    return;
                                case 1:
                                    SaveShareActivity.this.mShareSDKUtil.initShareParams(SaveShareActivity.this.editDate, "全景拍摄 一次就好", photoUrl, shareUrl);
                                    SaveShareActivity.this.mShareSDKUtil.qqShare(1, shareId);
                                    return;
                                case 2:
                                    SaveShareActivity.this.mShareSDKUtil.initShareParams(SaveShareActivity.this.editDate, "全景拍摄 一次就好", photoUrl, shareUrl);
                                    SaveShareActivity.this.mShareSDKUtil.weiBoShare(4, shareId);
                                    return;
                                case 3:
                                    SaveShareActivity.this.mShareSDKUtil.initShareParams(SaveShareActivity.this.editDate, "全景拍摄 一次就好", photoUrl, shareUrl);
                                    SaveShareActivity.this.mShareSDKUtil.weiXinShare(3, shareId);
                                    return;
                                default:
                                    return;
                            }
                            e.printStackTrace();
                            ToastFactory.getToast((Context) SaveShareActivity.this, "发表失败").show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        ToastFactory.getToast((Context) SaveShareActivity.this, "发表失败").show();
                    }
                } else {
                    if (SaveShareActivity.this.mProgressBar != null && SaveShareActivity.this.mProgressBar.isShowing()) {
                        SaveShareActivity.this.mProgressBar.dismiss();
                    }
                    if (type == 0) {
                        ToastFactory.getToast((Context) SaveShareActivity.this, "发表失败").show();
                    } else {
                        ToastFactory.getToast((Context) SaveShareActivity.this, "分享失败").show();
                    }
                }
            }
        }.execute(new String[][]{upLoadStr});
    }
}
