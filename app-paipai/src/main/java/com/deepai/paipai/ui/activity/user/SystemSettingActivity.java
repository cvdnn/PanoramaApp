package com.deepai.paipai.ui.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.deepai.library.support.utils.FileSizeUtil;
import com.deepai.paipai.R;
import com.deepai.paipai.support.file.FileUtils;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import java.io.File;

public class SystemSettingActivity extends BaseActivity {
    private double cacheSize = 0.0d;
    private LinearLayout linCache;
    private LinearLayout linRelated;
    /* access modifiers changed from: private */
    public TextView tvCacheSize;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView((int) R.layout.activity_system_setting);
        initTitle(R.string.system_setting_title);
        initView();
        initData();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.cacheSize = FileSizeUtil.getFileOrFilesSize(FileUtils.getUploadPach(), 3) + FileSizeUtil.getFileOrFilesSize(FileUtils.getTempFilePath(), 3) + FileSizeUtil.getFileOrFilesSize(FileUtils.getVideoPach(), 3);
        this.tvCacheSize.setText(FileSizeUtil.FormetSize(this.cacheSize) + "M");
    }

    private void initView() {
        this.linCache = (LinearLayout) findViewById(R.id.lin_cache);
        this.linRelated = (LinearLayout) findViewById(R.id.lin_related);
        this.tvCacheSize = (TextView) findViewById(R.id.cache_size);
    }

    private void initData() {
        this.linCache.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                FileSizeUtil.deleteAllFiles(new File(FileUtils.getUploadPach()));
                FileSizeUtil.deleteAllFiles(new File(FileUtils.getTempFilePath()));
                FileSizeUtil.deleteAllFiles(new File(FileUtils.getVideoPach()));
                SystemSettingActivity.this.tvCacheSize.setText("0.0M");
            }
        });
        this.linRelated.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SystemSettingActivity.this.startActivity(new Intent(SystemSettingActivity.this, RelatedActivity.class));
            }
        });
    }
}
