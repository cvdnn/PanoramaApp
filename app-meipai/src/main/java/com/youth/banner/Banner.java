package com.youth.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.i;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import androidx.viewpager2.widget.ViewPager2.PageTransformer;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.config.BannerConfig;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.config.IndicatorConfig.Margins;
import com.youth.banner.indicator.Indicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.listener.OnPageChangeListener;
import com.youth.banner.transformer.MZScaleInTransformer;
import com.youth.banner.transformer.ScaleInTransformer;
import com.youth.banner.util.BannerUtils;
import com.youth.banner.util.ScrollSpeedManger;
import d.h.e.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;

public class Banner<T, BA extends BannerAdapter> extends FrameLayout {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_VALUE = -1;
    public static final String TAG = "banner_log";
    public static final int VERTICAL = 1;
    public int indicatorGravity;
    public int indicatorHeight;
    public int indicatorMargin;
    public int indicatorMarginBottom;
    public int indicatorMarginLeft;
    public int indicatorMarginRight;
    public int indicatorMarginTop;
    public int indicatorRadius;
    public int indicatorSpace;
    public BA mAdapter;
    public i mAdapterDataObserver;
    public float mBannerRadius;
    public CompositePageTransformer mCompositePageTransformer;
    public long mDelayTime;
    public Indicator mIndicator;
    public boolean mIsAutoLoop;
    public boolean mIsInfiniteLoop;
    public boolean mIsViewPager2Drag;
    public AutoLoopTask mLoopTask;
    public OnPageChangeListener mOnPageChangeListener;
    public BannerOnPageChangeCallback mPageChangeCallback;
    public int mScrollTime;
    public int mStartPosition;
    public float mStartX;
    public float mStartY;
    public int mTouchSlop;
    public ViewPager2 mViewPager2;
    public int normalColor;
    public int normalWidth;
    public int selectedColor;
    public int selectedWidth;

    public static class AutoLoopTask implements Runnable {
        public final WeakReference<Banner> reference;

        public AutoLoopTask(Banner banner) {
            this.reference = new WeakReference<>(banner);
        }

        public void run() {
            Banner banner = (Banner) this.reference.get();
            if (banner != null && banner.mIsAutoLoop) {
                int itemCount = banner.getItemCount();
                if (itemCount != 0) {
                    banner.setCurrentItem((banner.getCurrentItem() + 1) % itemCount);
                    banner.postDelayed(banner.mLoopTask, banner.mDelayTime);
                }
            }
        }
    }

    public class BannerOnPageChangeCallback extends OnPageChangeCallback {
        public boolean isScrolled;
        public int mTempPosition = -1;

        public BannerOnPageChangeCallback() {
        }

        public void onPageScrollStateChanged(int i2) {
            if (i2 == 1 || i2 == 2) {
                this.isScrolled = true;
            } else if (i2 == 0) {
                this.isScrolled = false;
                if (this.mTempPosition != -1 && Banner.this.mIsInfiniteLoop) {
                    int i3 = this.mTempPosition;
                    if (i3 == 0) {
                        Banner banner = Banner.this;
                        banner.setCurrentItem(banner.getRealCount(), false);
                    } else if (i3 == Banner.this.getItemCount() - 1) {
                        Banner.this.setCurrentItem(1, false);
                    }
                }
            }
            if (Banner.this.mOnPageChangeListener != null) {
                Banner.this.mOnPageChangeListener.onPageScrollStateChanged(i2);
            }
            if (Banner.this.mIndicator != null) {
                Banner.this.mIndicator.onPageScrollStateChanged(i2);
            }
        }

        public void onPageScrolled(int i2, float f2, int i3) {
            int realPosition = BannerUtils.getRealPosition(Banner.this.isInfiniteLoop(), i2, Banner.this.getRealCount());
            if (Banner.this.mOnPageChangeListener != null) {
                Banner.this.mOnPageChangeListener.onPageScrolled(realPosition, f2, i3);
            }
            if (Banner.this.mIndicator != null) {
                Banner.this.mIndicator.onPageScrolled(realPosition, f2, i3);
            }
        }

        public void onPageSelected(int i2) {
            if (this.isScrolled) {
                this.mTempPosition = i2;
                int realPosition = BannerUtils.getRealPosition(Banner.this.isInfiniteLoop(), i2, Banner.this.getRealCount());
                if (Banner.this.mOnPageChangeListener != null) {
                    Banner.this.mOnPageChangeListener.onPageSelected(realPosition);
                }
                if (Banner.this.mIndicator != null) {
                    Banner.this.mIndicator.onPageSelected(realPosition);
                }
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public Banner(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.mCompositePageTransformer = new CompositePageTransformer();
        this.mPageChangeCallback = new BannerOnPageChangeCallback<>();
        this.mLoopTask = new AutoLoopTask(this);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.mViewPager2 = viewPager2;
        viewPager2.setLayoutParams(new LayoutParams(-1, -1));
        this.mViewPager2.setOffscreenPageLimit(1);
        this.mViewPager2.registerOnPageChangeCallback(this.mPageChangeCallback);
        this.mViewPager2.setPageTransformer(this.mCompositePageTransformer);
        ScrollSpeedManger.reflectLayoutManager(this);
        addView(this.mViewPager2);
    }

    private void initIndicator() {
        if (this.mIndicator != null && getAdapter() != null) {
            if (this.mIndicator.getIndicatorConfig().isAttachToBanner()) {
                removeIndicator();
                addView(this.mIndicator.getIndicatorView());
            }
            initIndicatorAttr();
            setIndicatorPageChange();
        }
    }

    private void initIndicatorAttr() {
        int i2 = this.indicatorMargin;
        if (i2 != 0) {
            setIndicatorMargins(new Margins(i2));
        } else if (!(this.indicatorMarginLeft == 0 && this.indicatorMarginTop == 0 && this.indicatorMarginRight == 0 && this.indicatorMarginBottom == 0)) {
            setIndicatorMargins(new Margins(this.indicatorMarginLeft, this.indicatorMarginTop, this.indicatorMarginRight, this.indicatorMarginBottom));
        }
        int i3 = this.indicatorSpace;
        if (i3 > 0) {
            setIndicatorSpace(i3);
        }
        int i4 = this.indicatorGravity;
        if (i4 != 1) {
            setIndicatorGravity(i4);
        }
        int i5 = this.normalWidth;
        if (i5 > 0) {
            setIndicatorNormalWidth(i5);
        }
        int i6 = this.selectedWidth;
        if (i6 > 0) {
            setIndicatorSelectedWidth(i6);
        }
        int i7 = this.indicatorHeight;
        if (i7 > 0) {
            setIndicatorHeight(i7);
        }
        int i8 = this.indicatorRadius;
        if (i8 > 0) {
            setIndicatorRadius(i8);
        }
        setIndicatorNormalColor(this.normalColor);
        setIndicatorSelectedColor(this.selectedColor);
    }

    private void initTypedArray(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Banner);
            this.mDelayTime = (long) obtainStyledAttributes.getInt(R.styleable.Banner_delay_time, BannerConfig.LOOP_TIME);
            this.mIsAutoLoop = obtainStyledAttributes.getBoolean(R.styleable.Banner_is_auto_loop, true);
            this.mIsInfiniteLoop = obtainStyledAttributes.getBoolean(R.styleable.Banner_is_infinite_loop, true);
            this.normalWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_normal_width, BannerConfig.INDICATOR_NORMAL_WIDTH);
            this.selectedWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_selected_width, BannerConfig.INDICATOR_SELECTED_WIDTH);
            this.normalColor = obtainStyledAttributes.getColor(R.styleable.Banner_indicator_normal_color, BannerConfig.INDICATOR_NORMAL_COLOR);
            this.selectedColor = obtainStyledAttributes.getColor(R.styleable.Banner_indicator_selected_color, BannerConfig.INDICATOR_SELECTED_COLOR);
            this.indicatorGravity = obtainStyledAttributes.getInt(R.styleable.Banner_indicator_gravity, 1);
            this.indicatorSpace = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_space, 0);
            this.indicatorMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_margin, 0);
            this.indicatorMarginLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_marginLeft, 0);
            this.indicatorMarginTop = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_marginTop, 0);
            this.indicatorMarginRight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_marginRight, 0);
            this.indicatorMarginBottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_marginBottom, 0);
            this.indicatorHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_height, BannerConfig.INDICATOR_HEIGHT);
            this.indicatorRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_radius, BannerConfig.INDICATOR_RADIUS);
            setOrientation(obtainStyledAttributes.getInt(R.styleable.Banner_banner_orientation, 0));
            setInfiniteLoop();
            obtainStyledAttributes.recycle();
        }
    }

    private void setInfiniteLoop() {
        if (!isInfiniteLoop()) {
            isAutoLoop(false);
        }
        setStartPosition(isInfiniteLoop() ? 1 : 0);
    }

    private void setRecyclerViewPadding(int i2) {
        RecyclerView recyclerView = (RecyclerView) getViewPager2().getChildAt(0);
        if (getViewPager2().getOrientation() == 1) {
            recyclerView.setPadding(0, i2, 0, i2);
        } else {
            recyclerView.setPadding(i2, 0, i2, 0);
        }
        recyclerView.setClipToPadding(false);
    }

    public Banner addItemDecoration(n nVar) {
        getViewPager2().addItemDecoration(nVar);
        return this;
    }

    public Banner addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        return this;
    }

    public Banner addPageTransformer(PageTransformer pageTransformer) {
        this.mCompositePageTransformer.addTransformer(pageTransformer);
        return this;
    }

    public void destroy() {
        getViewPager2().unregisterOnPageChangeCallback(this.mPageChangeCallback);
        removeCallbacks(this.mLoopTask);
        this.mCompositePageTransformer = null;
        this.mPageChangeCallback = null;
        this.mOnPageChangeListener = null;
        this.mLoopTask = null;
        this.mIndicator = null;
        this.mAdapterDataObserver = null;
        this.mAdapter = null;
        this.mViewPager2 = null;
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.mBannerRadius > 0.0f) {
            Path path = new Path();
            RectF rectF = new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
            float f2 = this.mBannerRadius;
            path.addRoundRect(rectF, f2, f2, Direction.CW);
            canvas.clipPath(path);
        }
        super.dispatchDraw(canvas);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!getViewPager2().isUserInputEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
            start();
        } else if (actionMasked == 0) {
            stop();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public BA getAdapter() {
        if (this.mAdapter == null) {
            Log.e(TAG, getContext().getString(R.string.banner_adapter_use_error));
        }
        return this.mAdapter;
    }

    public int getCurrentItem() {
        return this.mViewPager2.getCurrentItem();
    }

    public Indicator getIndicator() {
        if (this.mIndicator == null) {
            Log.e(TAG, getContext().getString(R.string.indicator_null_error));
        }
        return this.mIndicator;
    }

    public IndicatorConfig getIndicatorConfig() {
        if (getIndicator() != null) {
            return getIndicator().getIndicatorConfig();
        }
        return null;
    }

    public int getItemCount() {
        if (getAdapter() == null) {
            return 0;
        }
        return getAdapter().getItemCount();
    }

    public int getRealCount() {
        return getAdapter().getRealCount();
    }

    public int getScrollTime() {
        return this.mScrollTime;
    }

    public ViewPager2 getViewPager2() {
        return this.mViewPager2;
    }

    public Banner isAutoLoop(boolean z) {
        this.mIsAutoLoop = z;
        return this;
    }

    public boolean isInfiniteLoop() {
        return this.mIsInfiniteLoop;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        start();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r0 != 3) goto L_0x0084;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.viewpager2.widget.ViewPager2 r0 = r5.getViewPager2()
            boolean r0 = r0.isUserInputEnabled()
            if (r0 != 0) goto L_0x000f
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        L_0x000f:
            int r0 = r6.getAction()
            r1 = 1
            if (r0 == 0) goto L_0x0071
            r2 = 0
            if (r0 == r1) goto L_0x0069
            r3 = 2
            if (r0 == r3) goto L_0x0020
            r1 = 3
            if (r0 == r1) goto L_0x0069
            goto L_0x0084
        L_0x0020:
            float r0 = r6.getX()
            float r3 = r6.getY()
            float r4 = r5.mStartX
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            float r4 = r5.mStartY
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            androidx.viewpager2.widget.ViewPager2 r4 = r5.getViewPager2()
            int r4 = r4.getOrientation()
            if (r4 != 0) goto L_0x0050
            int r4 = r5.mTouchSlop
            float r4 = (float) r4
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x004c
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r1 = r2
        L_0x004d:
            r5.mIsViewPager2Drag = r1
            goto L_0x005f
        L_0x0050:
            int r4 = r5.mTouchSlop
            float r4 = (float) r4
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x005c
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r1 = r2
        L_0x005d:
            r5.mIsViewPager2Drag = r1
        L_0x005f:
            android.view.ViewParent r0 = r5.getParent()
            boolean r1 = r5.mIsViewPager2Drag
            r0.requestDisallowInterceptTouchEvent(r1)
            goto L_0x0084
        L_0x0069:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L_0x0084
        L_0x0071:
            float r0 = r6.getX()
            r5.mStartX = r0
            float r0 = r6.getY()
            r5.mStartY = r0
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
        L_0x0084:
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youth.banner.Banner.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void removeIndicator() {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            removeView(indicator.getIndicatorView());
        }
    }

    public Banner removeTransformer(PageTransformer pageTransformer) {
        this.mCompositePageTransformer.removeTransformer(pageTransformer);
        return this;
    }

    public Banner setAdapter(BA ba) {
        if (ba != null) {
            this.mAdapter = ba;
            if (!isInfiniteLoop()) {
                this.mAdapter.setIncreaseCount(0);
            }
            this.mAdapter.registerAdapterDataObserver(this.mAdapterDataObserver);
            this.mViewPager2.setAdapter(ba);
            setCurrentItem(this.mStartPosition, false);
            initIndicator();
            return this;
        }
        throw new NullPointerException(getContext().getString(R.string.banner_adapter_null_error));
    }

    public Banner setBannerGalleryEffect(int i2, int i3) {
        return setBannerGalleryEffect(i2, i3, 0.85f);
    }

    public Banner setBannerGalleryMZ(int i2) {
        return setBannerGalleryMZ(i2, 0.88f);
    }

    public Banner setBannerRound(float f2) {
        this.mBannerRadius = f2;
        return this;
    }

    public Banner setBannerRound2(float f2) {
        BannerUtils.setBannerRound(this, f2);
        return this;
    }

    public void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    public Banner setDatas(List<T> list) {
        if (getAdapter() != null) {
            getAdapter().setDatas(list);
            getAdapter().notifyDataSetChanged();
            setCurrentItem(this.mStartPosition, false);
            setIndicatorPageChange();
            start();
        }
        return this;
    }

    public Banner setDelayTime(long j2) {
        this.mDelayTime = j2;
        return this;
    }

    public Banner setIndicator(Indicator indicator) {
        return setIndicator(indicator, true);
    }

    public Banner setIndicatorGravity(int i2) {
        Indicator indicator = this.mIndicator;
        if (indicator != null && indicator.getIndicatorConfig().isAttachToBanner()) {
            this.mIndicator.getIndicatorConfig().setGravity(i2);
            this.mIndicator.getIndicatorView().postInvalidate();
        }
        return this;
    }

    public Banner<T, BA> setIndicatorHeight(int i2) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setHeight(i2);
        }
        return this;
    }

    public Banner setIndicatorMargins(Margins margins) {
        Indicator indicator = this.mIndicator;
        if (indicator != null && indicator.getIndicatorConfig().isAttachToBanner()) {
            this.mIndicator.getIndicatorConfig().setMargins(margins);
            this.mIndicator.getIndicatorView().requestLayout();
        }
        return this;
    }

    public Banner setIndicatorNormalColor(int i2) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setNormalColor(i2);
        }
        return this;
    }

    public Banner setIndicatorNormalColorRes(int i2) {
        setIndicatorNormalColor(a.a(getContext(), i2));
        return this;
    }

    public Banner setIndicatorNormalWidth(int i2) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setNormalWidth(i2);
        }
        return this;
    }

    public void setIndicatorPageChange() {
        if (this.mIndicator != null) {
            this.mIndicator.onPageChanged(getRealCount(), BannerUtils.getRealPosition(isInfiniteLoop(), getCurrentItem(), getRealCount()));
        }
    }

    public Banner<T, BA> setIndicatorRadius(int i2) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setRadius(i2);
        }
        return this;
    }

    public Banner setIndicatorSelectedColor(int i2) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setSelectedColor(i2);
        }
        return this;
    }

    public Banner setIndicatorSelectedColorRes(int i2) {
        setIndicatorSelectedColor(a.a(getContext(), i2));
        return this;
    }

    public Banner setIndicatorSelectedWidth(int i2) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setSelectedWidth(i2);
        }
        return this;
    }

    public Banner setIndicatorSpace(int i2) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setIndicatorSpace(i2);
        }
        return this;
    }

    public Banner setIndicatorWidth(int i2, int i3) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setNormalWidth(i2);
            this.mIndicator.getIndicatorConfig().setSelectedWidth(i3);
        }
        return this;
    }

    public Banner setOnBannerListener(OnBannerListener onBannerListener) {
        if (getAdapter() != null) {
            getAdapter().setOnBannerListener(onBannerListener);
        }
        return this;
    }

    public Banner setOrientation(int i2) {
        this.mViewPager2.setOrientation(i2);
        return this;
    }

    public Banner setPageTransformer(PageTransformer pageTransformer) {
        getViewPager2().setPageTransformer(pageTransformer);
        return this;
    }

    public Banner setScrollTime(int i2) {
        this.mScrollTime = i2;
        return this;
    }

    public Banner setStartPosition(int i2) {
        this.mStartPosition = i2;
        return this;
    }

    public Banner setTouchSlop(int i2) {
        this.mTouchSlop = i2;
        return this;
    }

    public Banner setUserInputEnabled(boolean z) {
        getViewPager2().setUserInputEnabled(z);
        return this;
    }

    public Banner start() {
        if (this.mIsAutoLoop) {
            stop();
            postDelayed(this.mLoopTask, this.mDelayTime);
        }
        return this;
    }

    public Banner stop() {
        if (this.mIsAutoLoop) {
            removeCallbacks(this.mLoopTask);
        }
        return this;
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner addItemDecoration(n nVar, int i2) {
        getViewPager2().addItemDecoration(nVar, i2);
        return this;
    }

    public Banner setBannerGalleryEffect(int i2, int i3, float f2) {
        if (i3 > 0) {
            addPageTransformer(new MarginPageTransformer((int) BannerUtils.dp2px((float) i3)));
        }
        if (f2 < 1.0f && f2 > 0.0f) {
            addPageTransformer(new ScaleInTransformer(f2));
        }
        setRecyclerViewPadding((int) BannerUtils.dp2px((float) (i2 + i3)));
        return this;
    }

    public Banner setBannerGalleryMZ(int i2, float f2) {
        if (f2 < 1.0f && f2 > 0.0f) {
            addPageTransformer(new MZScaleInTransformer(f2));
        }
        setRecyclerViewPadding((int) BannerUtils.dp2px((float) i2));
        return this;
    }

    public void setCurrentItem(int i2, boolean z) {
        this.mViewPager2.setCurrentItem(i2, z);
    }

    public Banner setIndicator(Indicator indicator, boolean z) {
        removeIndicator();
        indicator.getIndicatorConfig().setAttachToBanner(z);
        this.mIndicator = indicator;
        initIndicator();
        return this;
    }

    public Banner(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mScrollTime = BannerConfig.SCROLL_TIME;
        this.mStartPosition = 1;
        this.mBannerRadius = 0.0f;
        this.mAdapterDataObserver = new i() {
            public void onChanged() {
                if (Banner.this.getItemCount() <= 1) {
                    Banner.this.stop();
                } else {
                    Banner.this.start();
                }
                Banner.this.setIndicatorPageChange();
            }
        };
        init(context);
        initTypedArray(context, attributeSet);
    }
}
