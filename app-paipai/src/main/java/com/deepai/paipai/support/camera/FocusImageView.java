package com.deepai.paipai.support.camera;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.deepai.paipai.R;

public class FocusImageView extends ImageView {
    private static final int NO_ID = -1;
    public static final String TAG = "FocusImageView";
    private Animation mAnimation;
    private int mFocusFailedImg;
    private int mFocusImg;
    private int mFocusSucceedImg;
    private Handler mHandler;

    public FocusImageView(Context context) {
        super(context);
        this.mFocusImg = -1;
        this.mFocusSucceedImg = -1;
        this.mFocusFailedImg = -1;
        this.mAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.focusview_show);
        setVisibility(8);
        this.mHandler = new Handler();
    }

    public FocusImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mFocusImg = -1;
        this.mFocusSucceedImg = -1;
        this.mFocusFailedImg = -1;
        this.mAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.focusview_show);
        this.mHandler = new Handler();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FocusImageView);
        this.mFocusImg = a.getResourceId(0, -1);
        this.mFocusSucceedImg = a.getResourceId(1, -1);
        this.mFocusFailedImg = a.getResourceId(2, -1);
        a.recycle();
        if (this.mFocusImg == -1 || this.mFocusSucceedImg == -1 || this.mFocusFailedImg == -1) {
            throw new RuntimeException("Animation is null");
        }
    }

    public void startFocus(Point point) {
        if (this.mFocusImg == -1 || this.mFocusSucceedImg == -1 || this.mFocusFailedImg == -1) {
            throw new RuntimeException("focus image is null");
        }
        LayoutParams params = (LayoutParams) getLayoutParams();
        params.topMargin = point.y - (getHeight() / 2);
        params.leftMargin = point.x - (getWidth() / 2);
        setLayoutParams(params);
        setVisibility(0);
        setImageResource(this.mFocusImg);
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                FocusImageView.this.setVisibility(8);
            }
        }, 1000);
    }

    public void onFocusSuccess() {
        setImageResource(this.mFocusSucceedImg);
        this.mHandler.removeCallbacks(null, null);
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                FocusImageView.this.setVisibility(8);
            }
        }, 1000);
    }

    public void onFocusFailed() {
        setImageResource(this.mFocusFailedImg);
        this.mHandler.removeCallbacks(null, null);
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                FocusImageView.this.setVisibility(8);
            }
        }, 1000);
    }

    public void setFocusImg(int focus) {
        this.mFocusImg = focus;
    }

    public void setFocusSucceedImg(int focusSucceed) {
        this.mFocusSucceedImg = focusSucceed;
    }
}
