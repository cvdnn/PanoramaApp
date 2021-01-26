package com.deepai.paipai.ui.activity.basic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import com.deepai.paipai.R;

public class SplashActivity extends BaseActivity {
    private static final int GO_MAIN = 0;
    private Handler handler = new Handler();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_splash);
        this.handler.postDelayed(new Runnable() {
            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.onBackPressed();
            }
        }, 3000);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
