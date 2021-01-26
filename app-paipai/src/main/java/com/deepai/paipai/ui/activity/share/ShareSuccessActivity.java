package com.deepai.paipai.ui.activity.share;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.deepai.paipai.R;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import com.deepai.paipai.ui.activity.basic.MainActivity;
import com.deepai.paipai.ui.activity.photo.CameraActivity;

public class ShareSuccessActivity extends BaseActivity {
    private TextView mTitleText;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView((int) R.layout.activity_share_success);
        this.mTitleText = (TextView) findViewById(R.id.tv_title);
        this.mTitleText.setText("分享成功");
    }

    public void onBackIndexClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }

    public void onAgainImageClick(View view) {
        Intent intent = new Intent(this, CameraActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }
}
