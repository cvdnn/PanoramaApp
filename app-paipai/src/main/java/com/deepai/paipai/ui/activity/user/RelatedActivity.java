package com.deepai.paipai.ui.activity.user;

import android.os.Bundle;
import android.widget.TextView;
import com.deepai.library.support.utils.Util;
import com.deepai.paipai.R;
import com.deepai.paipai.ui.activity.basic.BaseActivity;

public class RelatedActivity extends BaseActivity {
    private TextView tvProjectNameVerson;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView((int) R.layout.activity_related);
        initTitle(R.string.related_title);
        initView();
    }

    private void initView() {
        this.tvProjectNameVerson = (TextView) findViewById(R.id.tv_project_name_verson);
        this.tvProjectNameVerson.setText("拍拍360 " + Util.getAppVersionName(this));
    }
}
