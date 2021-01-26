package com.deepai.paipai.ui.activity.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.deepai.library.ui.widget.ScaleImageView;
import com.deepai.paipai.NativeMatting;
import com.deepai.paipai.R;
import com.deepai.paipai.support.bean.HideInfo;
import com.deepai.paipai.support.file.FileUtils;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import com.deepai.paipai.ui.widget.AddHideInfoView;
import com.deepai.paipai.ui.widget.AddHideInfoView.OnHideInfoChangeListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.cookie.CookieSpec;

public class HideInfoActivity extends BaseActivity {
    public static final String EK_BIG_IMG_PATH = "bigImgPath";
    public static final String EK_CUT_IMG_PATH = "cutImgPath";
    public static final String EK_HIDE_INFOS = "hideInfo";
    public static final String EK_PAGE_IN = "pageIn";
    public static final String EK_TEMPLATE_PATH = "templatePath";
    public static final String PAGE_ADD_HIDE = "addHide";
    public static final String PAGE_CUT_IMG = "cutImg";
    public static final int REQ_CODE = 3;
    private String cutImgPath;
    /* access modifiers changed from: private */
    public ScaleImageView ivFore;
    /* access modifiers changed from: private */
    public AddHideInfoView ivMain;
    /* access modifiers changed from: private */
    public List<HideInfo> mHideInfos;
    private String mainImgPath;
    private String pageIn;
    private String templatePath;
    /* access modifiers changed from: private */
    public TextView tvChangeFocus;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView((int) R.layout.activity_hide_info);
        initTitle(1, R.string.done, R.string.add_hide_info);
        Intent intent = getIntent();
        this.ivMain = (AddHideInfoView) findViewById(R.id.view_add_hide_info);
        this.mainImgPath = intent.getStringExtra("bigImgPath");
        this.tvChangeFocus = (TextView) findViewById(R.id.tv_btn_change_focus);
        this.pageIn = intent.getStringExtra(EK_PAGE_IN);
        if (PAGE_ADD_HIDE.equals(this.pageIn)) {
            this.ivMain.setClickable(true);
            this.ivMain.setOnHideInfoChangeListener(new OnHideInfoChangeListener() {
                public void onHideInfoChange(List<HideInfo> hideInfos) {
                    if (HideInfoActivity.this.mHideInfos == null) {
                        HideInfoActivity.this.mHideInfos = new ArrayList();
                    }
                    HideInfoActivity.this.mHideInfos.clear();
                    HideInfoActivity.this.mHideInfos.addAll(hideInfos);
                }
            });
            this.mHideInfos = (List) new Gson().fromJson(intent.getStringExtra(EK_HIDE_INFOS), new TypeToken<List<HideInfo>>() {
            }.getType());
        } else if (PAGE_CUT_IMG.equals(this.pageIn)) {
            this.cutImgPath = intent.getStringExtra(EK_CUT_IMG_PATH);
            this.templatePath = intent.getStringExtra(EK_TEMPLATE_PATH);
            this.ivFore = new ScaleImageView(this);
            LayoutParams params = new LayoutParams(-1, -1);
            this.ivFore.setScaleType(ScaleType.MATRIX);
            this.ivFore.setLayoutParams(params);
            ((RelativeLayout) findViewById(R.id.rl_hide_view_container)).addView(this.ivFore);
            this.tvChangeFocus.setText(R.string.adjust_background);
            this.tvChangeFocus.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (HideInfoActivity.this.ivFore.getVisibility() == 0) {
                        HideInfoActivity.this.ivFore.setVisibility(8);
                        HideInfoActivity.this.tvChangeFocus.setText(R.string.adjust_foreground);
                        return;
                    }
                    HideInfoActivity.this.ivFore.setVisibility(0);
                    HideInfoActivity.this.tvChangeFocus.setText(R.string.adjust_background);
                }
            });
        }
    }

    public void onTitleRightClick(View view) {
        if (PAGE_ADD_HIDE.equals(this.pageIn)) {
            this.mHideInfos = this.ivMain.getHideInfos();
            if (this.mHideInfos != null) {
                Intent intent = new Intent();
                intent.putExtra(EK_HIDE_INFOS, new Gson().toJson((Object) this.mHideInfos));
                setResult(-1, intent);
            }
        } else if (PAGE_CUT_IMG.equals(this.pageIn)) {
            PointF pointF = this.ivMain.getPointF2Img(this.ivFore.getVertex());
            double s = this.ivFore.getScaleValue() / ((double) this.ivMain.getScaleRatio());
            String resultPath = FileUtils.getPanoDir() + CookieSpec.PATH_DELIM + System.currentTimeMillis() + Util.PHOTO_DEFAULT_EXT;
            if (new NativeMatting().BigImgCompose(this.mainImgPath, this.cutImgPath, this.templatePath, s, (int) pointF.y, (int) pointF.x, FileUtils.getFilePath() + "/result2.png", resultPath) == 0) {
                Intent intent2 = new Intent(this.activity, CreatePhotoActivity.class);
                intent2.addFlags(67108864);
                intent2.putExtra(CreatePhotoActivity.EK_BIG_IMG_PATH, resultPath);
                startActivity(intent2);
            }
        }
        onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.ivMain.setImage(this.mainImgPath);
        if (PAGE_ADD_HIDE.equals(this.pageIn) && this.mHideInfos != null && this.mHideInfos.size() > 0) {
            this.ivMain.post(new Runnable() {
                public void run() {
                    HideInfoActivity.this.ivMain.setHideInfos(HideInfoActivity.this.mHideInfos);
                }
            });
        }
        if (PAGE_CUT_IMG.equals(this.pageIn) && !TextUtils.isEmpty(this.cutImgPath)) {
            this.ivFore.setImgFile(this.cutImgPath);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.ivMain.release();
        if (this.ivFore != null) {
            this.ivFore.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public static void startForResult(Activity context, String bigImgPath, List<HideInfo> hideInfos) {
        Intent intent = new Intent(context, HideInfoActivity.class);
        intent.putExtra("bigImgPath", bigImgPath);
        intent.putExtra(EK_PAGE_IN, PAGE_ADD_HIDE);
        intent.putExtra(EK_HIDE_INFOS, new Gson().toJson((Object) hideInfos));
        context.startActivityForResult(intent, 3);
    }

    public static void start(Context context, String bigImgPath, String cutImgPath2, String templatePath2) {
        Intent intent = new Intent(context, HideInfoActivity.class);
        intent.putExtra("bigImgPath", bigImgPath);
        if (context.getClass() == CreatePhotoActivity.class) {
            intent.putExtra(EK_PAGE_IN, PAGE_ADD_HIDE);
        } else if (context.getClass() == CutImgActivity.class) {
            intent.putExtra(EK_PAGE_IN, PAGE_CUT_IMG);
            intent.putExtra(EK_CUT_IMG_PATH, cutImgPath2);
            intent.putExtra(EK_TEMPLATE_PATH, templatePath2);
        }
        context.startActivity(intent);
    }
}
