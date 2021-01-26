package com.deepai.paipai.ui.widget.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Scroller;
import com.deepai.paipai.ui.widget.refreshview.WaterDropListViewFooter.STATE;
import com.deepai.paipai.ui.widget.refreshview.WaterDropListViewHeader.IStateChangedListener;

public class WaterDropListView extends ListView implements OnScrollListener, IStateChangedListener {
    private static final float OFFSET_RADIO = 1.8f;
    private static final int PULL_LOAD_MORE_DELTA = 50;
    private static final int SCROLL_DURATION = 400;
    private boolean isTouchingScreen = false;
    private boolean mEnablePullLoad;
    private boolean mEnablePullRefresh = true;
    /* access modifiers changed from: private */
    public WaterDropListViewFooter mFooterView;
    private WaterDropListViewHeader mHeaderView;
    private boolean mIsFooterReady = false;
    private float mLastY = -1.0f;
    private IWaterDropListViewListener mListViewListener;
    private boolean mPullLoading;
    private ScrollBack mScrollBack;
    private OnScrollListener mScrollListener;
    private Scroller mScroller;
    private int mTotalItemCount;

    public interface IWaterDropListViewListener {
        void onLoadMore();

        void onRefresh();
    }

    public interface OnXScrollListener extends OnScrollListener {
        void onXScrolling(View view);
    }

    private enum ScrollBack {
        header,
        footer
    }

    public WaterDropListView(Context context) {
        super(context);
        initWithContext(context);
    }

    public WaterDropListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWithContext(context);
    }

    public WaterDropListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initWithContext(context);
    }

    private void initWithContext(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        super.setOnScrollListener(this);
        this.mHeaderView = new WaterDropListViewHeader(context);
        this.mHeaderView.setStateChangedListener(this);
        addHeaderView(this.mHeaderView);
        this.mFooterView = new WaterDropListViewFooter(context);
    }

    public void setAdapter(ListAdapter adapter) {
        if (!this.mIsFooterReady) {
            this.mIsFooterReady = true;
            addFooterView(this.mFooterView);
        }
        super.setAdapter(adapter);
    }

    public void setPullLoadEnable(boolean enable) {
        this.mEnablePullLoad = enable;
        if (!this.mEnablePullLoad) {
            this.mFooterView.hide();
            this.mFooterView.setOnClickListener(null);
            return;
        }
        this.mPullLoading = false;
        this.mFooterView.show();
        this.mFooterView.setState(STATE.normal);
        this.mFooterView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                WaterDropListView.this.mFooterView.setEnabled(false);
                WaterDropListView.this.startLoadMore();
            }
        });
    }

    public void stopRefresh() {
        if (this.mHeaderView.getCurrentState() == WaterDropListViewHeader.STATE.refreshing) {
            this.mHeaderView.updateState(WaterDropListViewHeader.STATE.end);
            if (!this.isTouchingScreen) {
                resetHeaderHeight();
            }
        }
    }

    public void stopLoadMore() {
        if (this.mPullLoading) {
            this.mPullLoading = false;
            this.mFooterView.setState(STATE.normal);
        }
        this.mFooterView.setEnabled(true);
    }

    private void invokeOnScrolling() {
        if (this.mScrollListener instanceof OnXScrollListener) {
            ((OnXScrollListener) this.mScrollListener).onXScrolling(this);
        }
    }

    private void updateHeaderHeight(int height) {
        if (this.mEnablePullRefresh) {
            if (this.mHeaderView.getCurrentState() == WaterDropListViewHeader.STATE.normal && height >= this.mHeaderView.getStretchHeight()) {
                this.mHeaderView.updateState(WaterDropListViewHeader.STATE.stretch);
            } else if (this.mHeaderView.getCurrentState() == WaterDropListViewHeader.STATE.stretch && height >= this.mHeaderView.getReadyHeight()) {
                this.mHeaderView.updateState(WaterDropListViewHeader.STATE.ready);
            } else if (this.mHeaderView.getCurrentState() == WaterDropListViewHeader.STATE.stretch && height < this.mHeaderView.getStretchHeight()) {
                this.mHeaderView.updateState(WaterDropListViewHeader.STATE.normal);
            } else if (this.mHeaderView.getCurrentState() == WaterDropListViewHeader.STATE.end && height < 2) {
                this.mHeaderView.updateState(WaterDropListViewHeader.STATE.normal);
            }
        }
        this.mHeaderView.setVisiableHeight(height);
    }

    private void updateHeaderHeight(float delta) {
        updateHeaderHeight(((int) delta) + this.mHeaderView.getVisiableHeight());
    }

    private void resetHeaderHeight() {
        int height = this.mHeaderView.getVisiableHeight();
        if (height != 0) {
            if (this.mHeaderView.getCurrentState() != WaterDropListViewHeader.STATE.refreshing || height > this.mHeaderView.getStretchHeight()) {
                int finalHeight = 0;
                if ((this.mHeaderView.getCurrentState() == WaterDropListViewHeader.STATE.ready || this.mHeaderView.getCurrentState() == WaterDropListViewHeader.STATE.refreshing) && height > this.mHeaderView.getStretchHeight()) {
                    finalHeight = this.mHeaderView.getStretchHeight();
                }
                this.mScrollBack = ScrollBack.header;
                this.mScroller.startScroll(0, height, 0, finalHeight - height, 400);
                invalidate();
            }
        }
    }

    private void updateFooterHeight(float delta) {
        int height = this.mFooterView.getBottomMargin() + ((int) delta);
        if (this.mEnablePullLoad && !this.mPullLoading) {
            if (height > 50) {
                this.mFooterView.setState(STATE.ready);
            } else {
                this.mFooterView.setState(STATE.normal);
            }
        }
        this.mFooterView.setBottomMargin(height);
    }

    private void resetFooterHeight() {
        int bottomMargin = this.mFooterView.getBottomMargin();
        if (bottomMargin > 0) {
            this.mScrollBack = ScrollBack.footer;
            this.mScroller.startScroll(0, bottomMargin, 0, -bottomMargin, 400);
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public void startLoadMore() {
        this.mPullLoading = true;
        this.mFooterView.setState(STATE.loading);
        if (this.mListViewListener != null) {
            this.mListViewListener.onLoadMore();
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (this.mLastY == -1.0f) {
            this.mLastY = ev.getRawY();
        }
        switch (ev.getAction()) {
            case 0:
                this.mLastY = ev.getRawY();
                this.isTouchingScreen = true;
                break;
            case 2:
                float deltaY = ev.getRawY() - this.mLastY;
                this.mLastY = ev.getRawY();
                if (getFirstVisiblePosition() != 0 || (this.mHeaderView.getVisiableHeight() <= 0 && deltaY <= 0.0f)) {
                    if (getLastVisiblePosition() == this.mTotalItemCount - 1 && (this.mFooterView.getBottomMargin() > 0 || deltaY < 0.0f)) {
                        updateFooterHeight((-deltaY) / OFFSET_RADIO);
                        break;
                    }
                } else {
                    updateHeaderHeight(deltaY / OFFSET_RADIO);
                    invokeOnScrolling();
                    break;
                }
                break;
            default:
                this.mLastY = -1.0f;
                this.isTouchingScreen = false;
                if (getFirstVisiblePosition() == 0) {
                    resetHeaderHeight();
                }
                if (getLastVisiblePosition() == this.mTotalItemCount - 1) {
                    if (this.mEnablePullLoad && this.mFooterView.getBottomMargin() > 50) {
                        startLoadMore();
                    }
                    resetFooterHeight();
                    break;
                }
                break;
        }
        boolean flag = false;
        try {
            return super.onTouchEvent(ev);
        } catch (Exception e) {
            return flag;
        }
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            if (this.mScrollBack == ScrollBack.header) {
                updateHeaderHeight(this.mScroller.getCurrY());
                if (this.mScroller.getCurrY() < 2 && this.mHeaderView.getCurrentState() == WaterDropListViewHeader.STATE.end) {
                    this.mHeaderView.updateState(WaterDropListViewHeader.STATE.normal);
                }
            } else {
                this.mFooterView.setBottomMargin(this.mScroller.getCurrY());
            }
            postInvalidate();
            invokeOnScrolling();
        }
        super.computeScroll();
    }

    public void setOnScrollListener(OnScrollListener l) {
        this.mScrollListener = l;
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (this.mScrollListener != null) {
            this.mScrollListener.onScrollStateChanged(view, scrollState);
        }
    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.mTotalItemCount = totalItemCount;
        if (this.mScrollListener != null) {
            this.mScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }

    public void notifyStateChanged(WaterDropListViewHeader.STATE oldState, WaterDropListViewHeader.STATE newState) {
        if (newState == WaterDropListViewHeader.STATE.refreshing && this.mListViewListener != null) {
            this.mListViewListener.onRefresh();
        }
    }

    public void setWaterDropListViewListener(IWaterDropListViewListener l) {
        this.mListViewListener = l;
    }
}
