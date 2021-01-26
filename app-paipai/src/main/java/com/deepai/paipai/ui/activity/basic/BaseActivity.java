package com.deepai.paipai.ui.activity.basic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.deepai.library.app.AppManager;
import com.deepai.paipai.R;
import com.deepai.paipai.app.PaiApp;

public class BaseActivity extends AppCompatActivity {
    protected static final int BTN_TYPE_IMG = 0;
    protected static final int BTN_TYPE_NOT_SHOW = -1;
    protected static final int BTN_TYPE_TEXT = 1;
    public BaseActivity activity;
    public PaiApp application;
    private AlertDialog toLoginDialog;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        this.activity = this;
        this.application = (PaiApp) PaiApp.getInstance();
        AppManager.getInstance().addActivity(this);
    }

    public void initTitle(int leftType, int leftRes, int rightType, int rightRes, int titleTextRes) {
        ImageView ivBack = (ImageView) findViewById(R.id.iv_back);
        TextView tvLeft = (TextView) findViewById(R.id.tv_left);
        ImageView ivLeft = (ImageView) findViewById(R.id.iv_left);
        TextView tvRight = (TextView) findViewById(R.id.tv_right);
        ImageView ivRight = (ImageView) findViewById(R.id.iv_right);
        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
        LinearLayout llLeft = (LinearLayout) findViewById(R.id.ll_left);
        LinearLayout llRight = (LinearLayout) findViewById(R.id.ll_right);
        if (leftType == -1) {
            llLeft.setVisibility(View.GONE);
        } else {
            llLeft.setVisibility(View.VISIBLE);
            if (leftType == 1) {
                ivBack.setVisibility(View.VISIBLE);
                tvLeft.setVisibility(View.VISIBLE);
                tvLeft.setText(leftRes);
                ivLeft.setVisibility(View.GONE);
            } else if (leftType == 0) {
                ivBack.setVisibility(View.GONE);
                tvLeft.setVisibility(View.GONE);
                ivLeft.setVisibility(View.VISIBLE);
                ivLeft.setImageResource(leftRes);
            } else {
                throw new IllegalArgumentException("必须使用BaseActivity中的title相关常量");
            }
        }
        if (rightType == -1) {
            llRight.setVisibility(View.GONE);
        } else {
            llRight.setVisibility(View.VISIBLE);
            if (rightType == 1) {
                tvRight.setVisibility(View.VISIBLE);
                tvRight.setText(rightRes);
                ivRight.setVisibility(View.GONE);
            } else if (rightType == 0) {
                tvRight.setVisibility(View.GONE);
                ivRight.setVisibility(View.VISIBLE);
                ivRight.setImageResource(rightRes);
            } else {
                throw new IllegalArgumentException("必须使用BaseActivity中的title相关常量");
            }
        }
        if (titleTextRes != -1) {
            tvTitle.setText(titleTextRes);
        } else {
            tvTitle.setText(null);
        }
    }

    public void initTitle(int rightType, int rightRes, int titleTextRes) {
        initTitle(1, R.string.back, rightType, rightRes, titleTextRes);
    }

    public void initTitle(int titleTextRes) {
        initTitle(1, R.string.back, -1, -1, titleTextRes);
    }

    public void setTitleBackgroundColor(int colorRes) {
        findViewById(R.id.rl_title).setBackgroundColor(colorRes);
    }

    public void onTitleLeftClick(View view) {
        AppManager.getInstance().finishActivity((Activity) this.activity);
    }

    public void onTitleRightClick(View view) {
    }

    public void jumpToActivity(Context context, Class<?> targetActivity, Bundle bundle) {
        Intent intent = new Intent(context, targetActivity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.toLoginDialog != null) {
            if (this.toLoginDialog.isShowing()) {
                this.toLoginDialog.dismiss();
            }
            this.toLoginDialog = null;
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        super.onBackPressed();
        AppManager.getInstance().finishActivity((Activity) this.activity);
    }

    public void showStartDialog() {
    }
}
