package com.deepai.paipai.ui.activity.photo;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.deepai.library.support.utils.FileUtil;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.library.ui.widget.ScaleImageView;
import com.deepai.paipai.NativeMatting;
import com.deepai.paipai.R;
import com.deepai.paipai.support.file.FileUtils;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.cookie.CookieSpec;

public class CutImgActivity extends BaseActivity {
    public static final String EK_BIG_IMG_PATH = "bigImgPath";
    public static final String EK_PHOTO_PATH = "photoPath";
    public static final int RESULT_CODE_NOFOUND = 200;
    private static final String TAG = "CutImgActivity";
    private String bigImgPath;
    /* access modifiers changed from: private */
    public int clickPosition = -1;
    private ScaleImageView ivPic;
    /* access modifiers changed from: private */
    public ScaleImageView ivTemplate;
    private GalleryAdapter mAdapter;
    /* access modifiers changed from: private */
    public List<String[]> mTemplateList;
    private String photoPath;
    private RecyclerView rvTemplate;

    class GalleryAdapter extends Adapter<ViewHolder> {

        public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
            ImageView mImg;

            public ViewHolder(View arg0) {
                super(arg0);
            }
        }

        GalleryAdapter() {
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(CutImgActivity.this.activity).inflate(R.layout.item_template, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            viewHolder.mImg = (ImageView) view.findViewById(R.id.iv_item_template);
            return viewHolder;
        }

        public void onBindViewHolder(ViewHolder holder, final int position) {
            ImageLoader.getInstance().displayImage("file://" + ((String[]) CutImgActivity.this.mTemplateList.get(position))[0], holder.mImg);
            holder.mImg.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (CutImgActivity.this.ivTemplate.getVisibility() == 8) {
                        CutImgActivity.this.ivTemplate.setImgFile(((String[]) CutImgActivity.this.mTemplateList.get(position))[0]);
                        CutImgActivity.this.ivTemplate.setVisibility(0);
                        CutImgActivity.this.clickPosition = position;
                        return;
                    }
                    CutImgActivity.this.ivTemplate.setVisibility(8);
                    CutImgActivity.this.ivTemplate.recycle();
                }
            });
        }

        public int getItemCount() {
            return CutImgActivity.this.mTemplateList.size();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_cut_img);
        initTitle(1, R.string.done, R.string.in_head_photo);
        initView();
        initData();
    }

    private void initView() {
        this.ivPic = (ScaleImageView) findViewById(R.id.iv_template_photo_pic);
        this.ivTemplate = (ScaleImageView) findViewById(R.id.iv_template);
    }

    private void initData() {
        Intent intent = getIntent();
        this.photoPath = intent.getStringExtra(EK_PHOTO_PATH);
        this.bigImgPath = intent.getStringExtra("bigImgPath");
        this.ivPic.setImgFile(this.photoPath);
        String dir = FileUtils.getTemplateDir();
        if (dir != null) {
            AssetManager assetManager = getResources().getAssets();
            for (int i = 0; i < 3; i++) {
                String fileName0 = "template" + i + "_0.png";
                String fileName1 = "template" + i + "_1.png";
                String fileName2 = "template" + i + "_2.png";
                try {
                    FileUtil.asset2File(dir, fileName0, assetManager.open(fileName0));
                    FileUtil.asset2File(dir, fileName1, assetManager.open(fileName1));
                    FileUtil.asset2File(dir, fileName2, assetManager.open(fileName2));
                } catch (IOException e) {
                }
                if (this.mTemplateList == null) {
                    this.mTemplateList = new ArrayList();
                }
                this.mTemplateList.add(new String[]{dir + CookieSpec.PATH_DELIM + fileName0, dir + CookieSpec.PATH_DELIM + fileName1, dir + CookieSpec.PATH_DELIM + fileName2});
            }
            initRv();
        }
    }

    private void initRv() {
        this.rvTemplate = (RecyclerView) findViewById(R.id.rv_template);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.rvTemplate.setLayoutManager(linearLayoutManager);
        this.mAdapter = new GalleryAdapter();
        this.rvTemplate.setAdapter(this.mAdapter);
    }

    public void onTitleRightClick(View view) {
        if (this.clickPosition == -1) {
            ToastFactory.getToast((Context) this, (int) R.string.check_template_tips).show();
            return;
        }
        Log.e(TAG, this.ivPic.getVertex().toString() + "//" + this.ivPic.getScaleValue());
        PointF p1 = this.ivPic.getVertex();
        double s1 = this.ivPic.getScaleValue();
        PointF p2 = this.ivTemplate.getVertex();
        double s2 = this.ivTemplate.getScaleValue();
        int x = Math.round((p2.x - p1.x) / ((float) s2));
        String[] templatePath = (String[]) this.mTemplateList.get(this.clickPosition);
        if (new NativeMatting().ImgCompose(templatePath[0], templatePath[1], this.photoPath, s1 / s2, Math.round((p2.y - p1.y) / ((float) s2)), x, FileUtils.getFilePath() + "/result1.jpg", FileUtils.getFilePath() + "/result.png") == 0) {
            HideInfoActivity.start(this.activity, this.bigImgPath, FileUtils.getFilePath() + "/result.png", templatePath[2]);
            onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.ivPic.recycle();
        this.ivTemplate.recycle();
        super.onDestroy();
    }
}
