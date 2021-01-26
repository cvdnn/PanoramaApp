package com.deepai.paipai.ui.widget.refreshview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.deepai.paipai.R;

public class WaterDropListViewHeader extends FrameLayout {
    private static final int DISTANCE_BETWEEN_STRETCH_READY = 50;
    private LinearLayout mContainer;
    private ProgressBar mProgressBar;
    private STATE mState = STATE.normal;
    private IStateChangedListener mStateChangedListener;
    /* access modifiers changed from: private */
    public WaterDropView mWaterDropView;
    /* access modifiers changed from: private */
    public int readyHeight;
    /* access modifiers changed from: private */
    public int stretchHeight;

    public interface IStateChangedListener {
        void notifyStateChanged(STATE state, STATE state2);
    }

    public enum STATE {
        normal,
        stretch,
        ready,
        refreshing,
        end
    }

    public WaterDropListViewHeader(Context context) {
        super(context);
        initView(context);
    }

    public WaterDropListViewHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        this.mContainer = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.waterdroplistview_header, null);
        this.mProgressBar = (ProgressBar) this.mContainer.findViewById(R.id.waterdroplist_header_progressbar);
        this.mWaterDropView = (WaterDropView) this.mContainer.findViewById(R.id.waterdroplist_waterdrop);
        addView(this.mContainer, new LayoutParams(-1, 0));
        initHeight();
    }

    private void initHeight() {
        this.mContainer.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                WaterDropListViewHeader.this.stretchHeight = WaterDropListViewHeader.this.mWaterDropView.getHeight();
                WaterDropListViewHeader.this.readyHeight = WaterDropListViewHeader.this.stretchHeight + 50;
                WaterDropListViewHeader.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    public void updateState(STATE state) {
        if (state != this.mState) {
            STATE oldState = this.mState;
            this.mState = state;
            if (this.mStateChangedListener != null) {
                this.mStateChangedListener.notifyStateChanged(oldState, this.mState);
            }
            switch (this.mState) {
                case normal:
                    handleStateNormal();
                    return;
                case stretch:
                    handleStateStretch();
                    return;
                case ready:
                    handleStateReady();
                    return;
                case refreshing:
                    handleStateRefreshing();
                    return;
                case end:
                    handleStateEnd();
                    return;
                default:
                    return;
            }
        }
    }

    private void handleStateNormal() {
        this.mWaterDropView.setVisibility(0);
        this.mProgressBar.setVisibility(8);
        this.mContainer.setGravity(81);
    }

    private void handleStateStretch() {
        this.mWaterDropView.setVisibility(0);
        this.mProgressBar.setVisibility(8);
        this.mContainer.setGravity(49);
    }

    private void handleStateReady() {
        this.mWaterDropView.setVisibility(0);
        this.mProgressBar.setVisibility(8);
        Animator shrinkAnimator = this.mWaterDropView.createAnimator();
        shrinkAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                WaterDropListViewHeader.this.updateState(STATE.refreshing);
            }
        });
        shrinkAnimator.start();
    }

    private void handleStateRefreshing() {
        this.mWaterDropView.setVisibility(8);
        this.mProgressBar.setVisibility(0);
    }

    private void handleStateEnd() {
        this.mWaterDropView.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setVisiableHeight(int height) {
        if (height < 0) {
            height = 0;
        }
        LayoutParams lp = (LayoutParams) this.mContainer.getLayoutParams();
        lp.height = height;
        this.mContainer.setLayoutParams(lp);
        if (this.mState == STATE.stretch) {
            this.mWaterDropView.updateComleteState((float) Utils.mapValueFromRangeToRange((double) height, (double) this.stretchHeight, (double) this.readyHeight, 0.0d, 1.0d));
        }
    }

    public int getVisiableHeight() {
        return this.mContainer.getHeight();
    }

    public STATE getCurrentState() {
        return this.mState;
    }

    public int getStretchHeight() {
        return this.stretchHeight;
    }

    public int getReadyHeight() {
        return this.readyHeight;
    }

    public void setStateChangedListener(IStateChangedListener l) {
        this.mStateChangedListener = l;
    }
}
