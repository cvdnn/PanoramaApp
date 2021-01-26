package com.baidu.pass.biometrics.base.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.pass.biometrics.base.NoProguard;
import com.baidu.pass.biometrics.base.R;
import com.baidu.pass.biometrics.base.utils.PassBioGlobalUtils;

public class BaseActivity extends Activity implements NoProguard {
    public boolean mIsActivityInForeground = false;
    public boolean mIsMultiWindowAvailable = true;
    public boolean mIsShowMultiWindowTips = false;
    public String mMultiWindowTips;

    @TargetApi(24)
    private void showMultiWindowTips() {
        if (VERSION.SDK_INT >= 24 && isInMultiWindowMode()) {
            if (this.mIsShowMultiWindowTips) {
                PassBioGlobalUtils.toastWithText(getActivity(), this.mMultiWindowTips, 1);
            }
            if (!this.mIsMultiWindowAvailable) {
                finish();
            }
        }
    }

    public Activity getActivity() {
        return this;
    }

    public boolean isActivityInForeground() {
        return this.mIsActivityInForeground;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mMultiWindowTips = getResources().getString(R.string.pass_bio_multi_window_tips);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    @TargetApi(5)
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 82 || !keyEvent.isLongPress()) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        if (VERSION.SDK_INT >= 24) {
            super.onMultiWindowModeChanged(z);
            if (z && isActivityInForeground()) {
                if (this.mIsShowMultiWindowTips) {
                    PassBioGlobalUtils.toastWithText(getActivity(), this.mMultiWindowTips, 1);
                }
                if (!this.mIsMultiWindowAvailable) {
                    finish();
                }
            }
        }
    }

    public void onPause() {
        super.onPause();
        this.mIsActivityInForeground = false;
    }

    public void onResume() {
        super.onResume();
        this.mIsActivityInForeground = true;
        showMultiWindowTips();
    }

    public void setIsMultiWindowAvailable(boolean z) {
        if (z != this.mIsMultiWindowAvailable) {
            this.mIsMultiWindowAvailable = z;
        }
    }

    public void setIsShowMultiWindowTips(boolean z) {
        if (z != this.mIsShowMultiWindowTips) {
            this.mIsShowMultiWindowTips = z;
        }
    }

    public void setMultiWindowTipsId(String str) {
        this.mMultiWindowTips = str;
    }
}
