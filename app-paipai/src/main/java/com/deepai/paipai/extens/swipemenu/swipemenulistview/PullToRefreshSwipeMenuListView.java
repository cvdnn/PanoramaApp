package com.deepai.paipai.extens.swipemenu.swipemenulistview;

import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.deepai.paipai.R;
import com.deepai.paipai.extens.swipemenu.pulltorefresh.PullToRefreshListFooter;
import com.deepai.paipai.extens.swipemenu.pulltorefresh.PullToRefreshListHeader;

public class PullToRefreshSwipeMenuListView extends ListView implements OnScrollListener {
    private static final float OFFSET_RADIO = 1.8f;
    private static final int PULL_LOAD_MORE_DELTA = 50;
    private static final int SCROLLBACK_FOOTER = 1;
    private static final int SCROLLBACK_HEADER = 0;
    private static final int SCROLL_DURATION = 400;
    private static final int TOUCH_STATE_NONE = 0;
    private static final int TOUCH_STATE_X = 1;
    private static final int TOUCH_STATE_Y = 2;
    private int MAX_X = 3;
    private int MAX_Y = 5;
    private Interpolator mCloseInterpolator;
    private float mDownX;
    private float mDownY;
    private boolean mEnablePullLoad;
    private boolean mEnablePullRefresh = true;
    private PullToRefreshListFooter mFooterView;
    private TextView mHeaderTimeView;
    /* access modifiers changed from: private */
    public PullToRefreshListHeader mHeaderView;
    /* access modifiers changed from: private */
    public RelativeLayout mHeaderViewContent;
    /* access modifiers changed from: private */
    public int mHeaderViewHeight;
    private boolean mIsFooterReady = false;
    private float mLastY = -1.0f;
    private IXListViewListener mListViewListener;
    /* access modifiers changed from: private */
    public SwipeMenuCreator mMenuCreator;
    /* access modifiers changed from: private */
    public OnMenuItemClickListener mOnMenuItemClickListener;
    private OnSwipeListener mOnSwipeListener;
    private Interpolator mOpenInterpolator;
    private boolean mPullLoading;
    /* access modifiers changed from: private */
    public boolean mPullRefreshing = false;
    private int mScrollBack;
    private OnScrollListener mScrollListener;
    private Scroller mScroller;
    private int mTotalItemCount;
    private int mTouchPosition;
    private int mTouchState;
    /* access modifiers changed from: private */
    public SwipeMenuLayout mTouchView;

    public interface IXListViewListener {
        void onLoadMore();

        void onRefresh();
    }

    public interface OnMenuItemClickListener {
        void onMenuItemClick(int i, SwipeMenu swipeMenu, int i2);
    }

    public interface OnSwipeListener {
        void onSwipeEnd(int i);

        void onSwipeStart(int i);
    }

    public interface OnXScrollListener extends OnScrollListener {
        void onXScrolling(View view);
    }

    class ResetHeaderHeightTask extends AsyncTask<Void, Void, Void> {
        ResetHeaderHeightTask() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            PullToRefreshSwipeMenuListView.this.mPullRefreshing = false;
            PullToRefreshSwipeMenuListView.this.mHeaderView.setState(0);
            PullToRefreshSwipeMenuListView.this.resetHeaderHeight();
        }
    }

    public PullToRefreshSwipeMenuListView(Context context) {
        super(context);
        init(context);
    }

    public PullToRefreshSwipeMenuListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public PullToRefreshSwipeMenuListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        super.setOnScrollListener(this);
        this.mHeaderView = new PullToRefreshListHeader(context);
        this.mHeaderViewContent = (RelativeLayout) this.mHeaderView.findViewById(R.id.xlistview_header_content);
        this.mHeaderTimeView = (TextView) this.mHeaderView.findViewById(R.id.xlistview_header_time);
        addHeaderView(this.mHeaderView);
        this.mFooterView = new PullToRefreshListFooter(context);
        this.mHeaderView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                PullToRefreshSwipeMenuListView.this.mHeaderViewHeight = PullToRefreshSwipeMenuListView.this.mHeaderViewContent.getHeight();
                PullToRefreshSwipeMenuListView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        this.MAX_X = dp2px(this.MAX_X);
        this.MAX_Y = dp2px(this.MAX_Y);
        this.mTouchState = 0;
    }

    public void setAdapter(ListAdapter adapter) {
        if (!this.mIsFooterReady) {
            this.mIsFooterReady = true;
            addFooterView(this.mFooterView);
        }
        super.setAdapter(new SwipeMenuAdapter(getContext(), adapter) {
            public void createMenu(SwipeMenu menu) {
                if (PullToRefreshSwipeMenuListView.this.mMenuCreator != null) {
                    PullToRefreshSwipeMenuListView.this.mMenuCreator.create(menu);
                }
            }

            public void onItemClick(SwipeMenuView view, SwipeMenu menu, int index) {
                if (PullToRefreshSwipeMenuListView.this.mOnMenuItemClickListener != null) {
                    PullToRefreshSwipeMenuListView.this.mOnMenuItemClickListener.onMenuItemClick(view.getPosition(), menu, index);
                }
                if (PullToRefreshSwipeMenuListView.this.mTouchView != null) {
                    PullToRefreshSwipeMenuListView.this.mTouchView.smoothCloseMenu();
                }
            }
        });
    }

    public void setCloseInterpolator(Interpolator interpolator) {
        this.mCloseInterpolator = interpolator;
    }

    public void setOpenInterpolator(Interpolator interpolator) {
        this.mOpenInterpolator = interpolator;
    }

    public Interpolator getOpenInterpolator() {
        return this.mOpenInterpolator;
    }

    public Interpolator getCloseInterpolator() {
        return this.mCloseInterpolator;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (this.mLastY == -1.0f) {
            this.mLastY = ev.getRawY();
        }
        switch (ev.getAction()) {
            case 0:
                this.mLastY = ev.getRawY();
                int oldPos = this.mTouchPosition;
                this.mDownX = ev.getX();
                this.mDownY = ev.getY();
                this.mTouchState = 0;
                this.mTouchPosition = pointToPosition((int) ev.getX(), (int) ev.getY());
                if (this.mTouchPosition != oldPos || this.mTouchView == null || !this.mTouchView.isOpen()) {
                    View view = getChildAt(this.mTouchPosition - getFirstVisiblePosition());
                    if (this.mTouchView == null || !this.mTouchView.isOpen()) {
                        if (view instanceof SwipeMenuLayout) {
                            this.mTouchView = (SwipeMenuLayout) view;
                        }
                        if (this.mTouchView != null) {
                            this.mTouchView.onSwipe(ev);
                            break;
                        }
                    } else {
                        this.mTouchView.smoothCloseMenu();
                        this.mTouchView = null;
                        return super.onTouchEvent(ev);
                    }
                } else {
                    this.mTouchState = 1;
                    this.mTouchView.onSwipe(ev);
                    return true;
                }
                break;
            case 1:
                this.mLastY = -1.0f;
                if (this.mEnablePullLoad && this.mFooterView.getBottomMargin() > 50) {
                    startLoadMore();
                    resetFooterHeight();
                    new ResetHeaderHeightTask().execute(new Void[0]);
                } else if (getFirstVisiblePosition() == 0) {
                    if (this.mEnablePullRefresh && this.mHeaderView.getVisiableHeight() > this.mHeaderViewHeight) {
                        this.mPullRefreshing = true;
                        this.mHeaderView.setState(2);
                        if (this.mListViewListener != null) {
                            this.mListViewListener.onRefresh();
                        }
                    }
                    resetHeaderHeight();
                }
                if (this.mTouchState == 1) {
                    if (this.mTouchView != null) {
                        this.mTouchView.onSwipe(ev);
                        if (!this.mTouchView.isOpen()) {
                            this.mTouchPosition = -1;
                            this.mTouchView = null;
                        }
                    }
                    if (this.mOnSwipeListener != null) {
                        this.mOnSwipeListener.onSwipeEnd(this.mTouchPosition);
                    }
                    ev.setAction(3);
                    super.onTouchEvent(ev);
                    return true;
                }
                break;
            case 2:
                float deltaY = ev.getRawY() - this.mLastY;
                float dy = Math.abs(ev.getY() - this.mDownY);
                float dx = Math.abs(ev.getX() - this.mDownX);
                this.mLastY = ev.getRawY();
                if ((this.mTouchView == null || !this.mTouchView.isActive()) && Math.pow((double) dx, 2.0d) / Math.pow((double) dy, 2.0d) <= 3.0d) {
                    if (getFirstVisiblePosition() == 0 && (this.mHeaderView.getVisiableHeight() > 0 || deltaY > 0.0f)) {
                        updateHeaderHeight(deltaY / OFFSET_RADIO);
                        invokeOnScrolling();
                    } else if (this.mFooterView.getBottomMargin() > 0 || deltaY < 0.0f) {
                        updateFooterHeight((-deltaY) / OFFSET_RADIO);
                    }
                }
                if (this.mTouchState != 1) {
                    if (this.mTouchState == 0) {
                        if (Math.abs(dy) <= ((float) this.MAX_Y)) {
                            if (dx > ((float) this.MAX_X)) {
                                this.mTouchState = 1;
                                if (this.mOnSwipeListener != null) {
                                    this.mOnSwipeListener.onSwipeStart(this.mTouchPosition);
                                    break;
                                }
                            }
                        } else {
                            this.mTouchState = 2;
                            break;
                        }
                    }
                } else {
                    if (this.mTouchView != null) {
                        this.mTouchView.onSwipe(ev);
                    }
                    getSelector().setState(new int[]{0});
                    ev.setAction(3);
                    super.onTouchEvent(ev);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    public void smoothOpenMenu(int position) {
        if (position >= getFirstVisiblePosition() && position <= getLastVisiblePosition()) {
            View view = getChildAt(position - getFirstVisiblePosition());
            if (view instanceof SwipeMenuLayout) {
                this.mTouchPosition = position;
                if (this.mTouchView != null && this.mTouchView.isOpen()) {
                    this.mTouchView.smoothCloseMenu();
                }
                this.mTouchView = (SwipeMenuLayout) view;
                this.mTouchView.smoothOpenMenu();
            }
        }
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(1, (float) dp, getContext().getResources().getDisplayMetrics());
    }

    public void setMenuCreator(SwipeMenuCreator menuCreator) {
        this.mMenuCreator = menuCreator;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOnSwipeListener(OnSwipeListener onSwipeListener) {
        this.mOnSwipeListener = onSwipeListener;
    }

    public void setPullRefreshEnable(boolean enable) {
        this.mEnablePullRefresh = enable;
        if (!this.mEnablePullRefresh) {
            this.mHeaderViewContent.setVisibility(4);
        } else {
            this.mHeaderViewContent.setVisibility(0);
        }
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
        this.mFooterView.setState(0);
        this.mFooterView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                PullToRefreshSwipeMenuListView.this.startLoadMore();
            }
        });
    }

    public void stopRefresh() {
        if (this.mPullRefreshing) {
            this.mPullRefreshing = false;
            resetHeaderHeight();
        }
    }

    public void stopLoadMore() {
        if (this.mPullLoading) {
            this.mPullLoading = false;
            this.mFooterView.setState(0);
        }
    }

    public void setRefreshTime(String time) {
        this.mHeaderTimeView.setText(time);
    }

    private void invokeOnScrolling() {
        if (this.mScrollListener instanceof OnXScrollListener) {
            ((OnXScrollListener) this.mScrollListener).onXScrolling(this);
        }
    }

    private void updateHeaderHeight(float delta) {
        this.mHeaderView.setVisiableHeight(((int) delta) + this.mHeaderView.getVisiableHeight());
        if (this.mEnablePullRefresh && !this.mPullRefreshing) {
            if (this.mHeaderView.getVisiableHeight() > this.mHeaderViewHeight) {
                this.mHeaderView.setState(1);
            } else {
                this.mHeaderView.setState(0);
            }
        }
        setSelection(0);
    }

    /* access modifiers changed from: private */
    public void resetHeaderHeight() {
        int height = this.mHeaderView.getVisiableHeight();
        if (height != 0) {
            if (!this.mPullRefreshing || height > this.mHeaderViewHeight) {
                int finalHeight = 0;
                if (this.mPullRefreshing && height > this.mHeaderViewHeight) {
                    finalHeight = this.mHeaderViewHeight;
                }
                this.mScrollBack = 0;
                this.mScroller.startScroll(0, height, 0, finalHeight - height, 400);
                invalidate();
            }
        }
    }

    private void updateFooterHeight(float delta) {
        int height = this.mFooterView.getBottomMargin() + ((int) delta);
        if (this.mEnablePullLoad && !this.mPullLoading) {
            if (height > 50) {
                this.mFooterView.setState(1);
            } else {
                this.mFooterView.setState(0);
            }
        }
        this.mFooterView.setBottomMargin(height);
    }

    private void resetFooterHeight() {
        int bottomMargin = this.mFooterView.getBottomMargin();
        if (bottomMargin > 0) {
            this.mScrollBack = 1;
            this.mScroller.startScroll(0, bottomMargin, 0, -bottomMargin, 400);
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public void startLoadMore() {
        this.mPullLoading = true;
        this.mFooterView.setState(2);
        if (this.mListViewListener != null) {
            this.mListViewListener.onLoadMore();
        }
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            if (this.mScrollBack == 0) {
                this.mHeaderView.setVisiableHeight(this.mScroller.getCurrY());
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

    public void setXListViewListener(IXListViewListener l) {
        this.mListViewListener = l;
    }
}
