package com.deepai.paipai.ui.activity.photo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.me.error.MsgError;
import com.android.volley.me.request.StringPostRequest;
import com.baidu.location.c.d;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.paipai.R;
import com.deepai.paipai.app.AppConstant;
import com.deepai.paipai.app.AppConstant.RequestKey;
import com.deepai.paipai.app.PaiApp;
import com.deepai.paipai.support.adapter.GridViewMyWorksAdapter;
import com.deepai.paipai.support.adapter.GridViewMyWorksAdapter.OnClickListener;
import com.deepai.paipai.support.bean.IndexPhotoBean;
import com.deepai.paipai.support.bean.MyworksBean;
import com.deepai.paipai.support.file.FileUtils;
import com.deepai.paipai.support.utils.AppSP;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import com.deepai.paipai.ui.activity.details.ImageDetailsActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyWorksActivity extends BaseActivity implements OnClickListener {
    private List<IndexPhotoBean> beanList;
    private List<File> fileList;
    private Gson gson;
    private LinearLayout linBg;
    private List<String[]> list;
    private GridViewMyWorksAdapter mAdapter;
    private ImageView mBackImage;
    private TextView mBackText;
    private GridView mGridViewShow;
    /* access modifiers changed from: private */
    public ProgressDialog mProgressBar;
    private TextView mTitleText;
    /* access modifiers changed from: private */
    public String token;
    private TextView tvLocalPic;
    private TextView tvNetPic;
    /* access modifiers changed from: private */
    public String type = "0";
    private String urlHeader;
    private String userName;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView((int) R.layout.activity_my_works);
        initView();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.token = AppSP.getToken(this, "").toString();
        this.userName = AppSP.getUserName(this, "").toString();
        this.urlHeader = AppSP.getUserHeadUrl(this, "").toString();
        if (!"".equals(this.userName)) {
            this.mTitleText.setText(this.userName);
        }
        initData();
    }

    /* access modifiers changed from: private */
    public void clickLocalPicState() {
        this.linBg.setBackgroundResource(R.mipmap.bg_myworks_switch1);
        this.tvLocalPic.setTextColor(getResources().getColor(R.color.bg_white));
        this.tvNetPic.setTextColor(getResources().getColor(R.color.black));
    }

    /* access modifiers changed from: private */
    public void clickNetPicState() {
        this.linBg.setBackgroundResource(R.mipmap.bg_myworks_switch2);
        this.tvLocalPic.setTextColor(getResources().getColor(R.color.black));
        this.tvNetPic.setTextColor(getResources().getColor(R.color.bg_white));
    }

    private void initView() {
        this.mProgressBar = getProgressBar();
        this.mProgressBar.show();
        this.mTitleText = (TextView) findViewById(R.id.tv_title);
        this.mBackImage = (ImageView) findViewById(R.id.iv_back);
        this.mBackText = (TextView) findViewById(R.id.tv_left);
        this.mGridViewShow = (GridView) findViewById(R.id.grid_my_works);
        this.tvLocalPic = (TextView) findViewById(R.id.tv_local_pic);
        this.tvNetPic = (TextView) findViewById(R.id.tv_net_pic);
        this.linBg = (LinearLayout) findViewById(R.id.lin_bg_switch);
        this.mBackImage.setVisibility(0);
        this.mBackText.setVisibility(0);
        this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
        this.tvLocalPic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MyWorksActivity.this.type = "0";
                MyWorksActivity.this.clickLocalPicState();
                MyWorksActivity.this.initData();
            }
        });
        this.tvNetPic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ("".equals(MyWorksActivity.this.token) || "0".equals(MyWorksActivity.this.token)) {
                    ToastFactory.getToast((Context) MyWorksActivity.this, "请先登录").show();
                    return;
                }
                MyWorksActivity.this.type = d.ai;
                MyWorksActivity.this.clickNetPicState();
                MyWorksActivity.this.initData();
            }
        });
    }

    /* access modifiers changed from: private */
    public void initData() {
        if ("0".equals(this.type)) {
            String dir = FileUtils.getPanoDir();
            if (dir != null) {
                this.list = new ArrayList();
                this.fileList = FileUtils.getFiles(new File(dir), Util.PHOTO_DEFAULT_EXT, null);
                if (this.fileList != null) {
                    for (int i = 0; i < this.fileList.size(); i++) {
                        this.list.add(new String[]{((File) this.fileList.get(i)).getAbsolutePath(), "-1"});
                    }
                }
                if (this.list != null) {
                    this.mAdapter = new GridViewMyWorksAdapter(this.list, this.type, this);
                    this.mGridViewShow.setAdapter(this.mAdapter);
                    this.mAdapter.setOnClickListener(this);
                    if (this.mProgressBar != null && this.mProgressBar.isShowing()) {
                        this.mProgressBar.dismiss();
                    }
                } else if (this.mProgressBar != null && this.mProgressBar.isShowing()) {
                    this.mProgressBar.dismiss();
                }
            }
        } else if (d.ai.equals(this.type)) {
            Map<String, String> params = new HashMap<>();
            params.put(RequestKey.TOKEN, this.token);
            PaiApp.vQueue.add(new StringPostRequest(AppConstant.BASEUSERSERVICEURL_NET_WORKS, params, new Listener<String>() {
                public void onResponse(String response) {
                    if (MyWorksActivity.this.mProgressBar != null && MyWorksActivity.this.mProgressBar.isShowing()) {
                        MyWorksActivity.this.mProgressBar.dismiss();
                    }
                    MyWorksActivity.this.paserResponseMessage(response);
                }
            }, new ErrorListener() {
                public void onErrorResponse(VolleyError error) {
                    if (MyWorksActivity.this.mProgressBar != null && MyWorksActivity.this.mProgressBar.isShowing()) {
                        MyWorksActivity.this.mProgressBar.dismiss();
                    }
                    if (error.getClass() == MsgError.class) {
                        MyWorksActivity.this.clickLocalPicState();
                    } else {
                        ToastFactory.getToast((Context) MyWorksActivity.this, "服务器正忙，请稍后再试").show();
                    }
                }
            }));
        }
    }

    /* access modifiers changed from: private */
    public void paserResponseMessage(String response) {
        if (response != null && !TextUtils.isEmpty(response.trim())) {
            MyworksBean bean = (MyworksBean) this.gson.fromJson(response, MyworksBean.class);
            if (bean.getCode() == null || !AppConstant.SUCCESS.equals(bean.getCode())) {
                clickLocalPicState();
                ToastFactory.getToast((Context) this, "获取网络作品失败").show();
                return;
            }
            this.list = new ArrayList();
            if (bean.getData() != null) {
                if (bean.getData().size() != 0) {
                    for (int i = 0; i < bean.getData().size(); i++) {
                        this.list.add(new String[]{AppConstant.BASEUSERSERVICEURL + ((IndexPhotoBean) bean.getData().get(i)).getSurl(), ((IndexPhotoBean) bean.getData().get(i)).getId()});
                        ((IndexPhotoBean) bean.getData().get(i)).setHeadimgurl(this.urlHeader.substring(AppConstant.BASEUSERSERVICEURL.length()));
                        ((IndexPhotoBean) bean.getData().get(i)).setNickname(this.userName);
                    }
                    this.beanList = bean.getData();
                } else {
                    ToastFactory.getToast((Context) this, "暂无网络作品").show();
                }
                if (this.list != null) {
                    this.mAdapter = new GridViewMyWorksAdapter(this.list, this.type, this);
                    this.mGridViewShow.setAdapter(this.mAdapter);
                    this.mAdapter.setOnClickListener(this);
                    return;
                }
                return;
            }
            ToastFactory.getToast((Context) this, "暂无网络作品").show();
        }
    }

    private ProgressDialog getProgressBar() {
        ProgressDialog mypDialog = new ProgressDialog(this);
        mypDialog.setProgressStyle(0);
        mypDialog.setMessage("正在加载我的作品中，请稍后...");
        mypDialog.setIndeterminate(false);
        mypDialog.setCancelable(true);
        return mypDialog;
    }

    public void onClick(int position) {
        Bundle bundle = new Bundle();
        if ("0".equals(this.type)) {
            if (this.list != null && this.list.size() > 0) {
                bundle.putString(CreatePhotoActivity.EK_BIG_IMG_PATH, ((String[]) this.list.get(position))[0]);
                jumpToActivity(this, CreatePhotoActivity.class, bundle);
            }
        } else if (d.ai.equals(this.type) && this.beanList != null && this.beanList.size() > 0) {
            bundle.putSerializable("detailsData", (Serializable) this.beanList.get(position));
            jumpToActivity(this, ImageDetailsActivity.class, bundle);
        }
    }
}
