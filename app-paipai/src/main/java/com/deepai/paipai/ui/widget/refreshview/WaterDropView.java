package com.deepai.paipai.ui.widget.refreshview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.deepai.paipai.R;

public class WaterDropView extends View {
    private static final int BACK_ANIM_DURATION = 180;
    private static final float STROKE_WIDTH = 2.0f;
    private Bitmap arrowBitmap;
    private Circle bottomCircle;
    private float mMaxCircleRadius;
    private float mMinCircleRaidus;
    private Paint mPaint;
    private Path mPath;
    private Circle topCircle;

    public WaterDropView(Context context) {
        super(context);
        init(context, null);
    }

    public WaterDropView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public WaterDropView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WaterDropView, 0, 0);
            try {
                if (a.hasValue(2)) {
                    this.mPaint.setColor(a.getColor(2, -7829368));
                }
                if (a.hasValue(0)) {
                    this.mMaxCircleRadius = (float) a.getDimensionPixelSize(0, 0);
                    this.topCircle.setRadius(this.mMaxCircleRadius);
                    this.bottomCircle.setRadius(this.mMaxCircleRadius);
                    this.topCircle.setX(this.mMaxCircleRadius + STROKE_WIDTH);
                    this.topCircle.setY(this.mMaxCircleRadius + STROKE_WIDTH);
                    this.bottomCircle.setX(this.mMaxCircleRadius + STROKE_WIDTH);
                    this.bottomCircle.setY(this.mMaxCircleRadius + STROKE_WIDTH);
                }
                if (a.hasValue(1)) {
                    this.mMinCircleRaidus = (float) a.getDimensionPixelSize(1, 0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                a.recycle();
            }
        }
    }

    private void init(Context context, AttributeSet attrs) {
        this.topCircle = new Circle();
        this.bottomCircle = new Circle();
        this.mPath = new Path();
        this.mPaint = new Paint();
        this.mPaint.setColor(-7829368);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Style.FILL_AND_STROKE);
        this.mPaint.setStrokeWidth(STROKE_WIDTH);
        this.arrowBitmap = Utils.drawableToBitmap(getResources().getDrawable(R.drawable.refresh_arrow));
        parseAttrs(context, attrs);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int) ((this.mMaxCircleRadius + STROKE_WIDTH) * STROKE_WIDTH), (int) Math.ceil((double) (this.bottomCircle.getY() + this.bottomCircle.getRadius() + 4.0f)));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        makeBezierPath();
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.drawCircle(this.topCircle.getX(), this.topCircle.getY(), this.topCircle.getRadius(), this.mPaint);
        canvas.drawCircle(this.bottomCircle.getX(), this.bottomCircle.getY(), this.bottomCircle.getRadius(), this.mPaint);
        canvas.drawBitmap(this.arrowBitmap, null, new RectF(this.topCircle.getX() - (this.topCircle.getRadius() * 0.5f), this.topCircle.getY() - (this.topCircle.getRadius() * 0.5f), this.topCircle.getX() + (this.topCircle.getRadius() * 0.5f), this.topCircle.getY() + (this.topCircle.getRadius() * 0.5f)), this.mPaint);
        super.onDraw(canvas);
    }

    private void makeBezierPath() {
        this.mPath.reset();
        double angle = getAngle();
        float top_x1 = (float) (((double) this.topCircle.getX()) - (((double) this.topCircle.getRadius()) * Math.cos(angle)));
        float top_y1 = (float) (((double) this.topCircle.getY()) + (((double) this.topCircle.getRadius()) * Math.sin(angle)));
        float top_x2 = (float) (((double) this.topCircle.getX()) + (((double) this.topCircle.getRadius()) * Math.cos(angle)));
        float top_y2 = top_y1;
        float bottom_x1 = (float) (((double) this.bottomCircle.getX()) - (((double) this.bottomCircle.getRadius()) * Math.cos(angle)));
        float bottom_y1 = (float) (((double) this.bottomCircle.getY()) + (((double) this.bottomCircle.getRadius()) * Math.sin(angle)));
        float bottom_x2 = (float) (((double) this.bottomCircle.getX()) + (((double) this.bottomCircle.getRadius()) * Math.cos(angle)));
        float bottom_y2 = bottom_y1;
        this.mPath.moveTo(this.topCircle.getX(), this.topCircle.getY());
        this.mPath.lineTo(top_x1, top_y1);
        this.mPath.quadTo(this.bottomCircle.getX() - this.bottomCircle.getRadius(), (this.bottomCircle.getY() + this.topCircle.getY()) / STROKE_WIDTH, bottom_x1, bottom_y1);
        this.mPath.lineTo(bottom_x2, bottom_y2);
        this.mPath.quadTo(this.bottomCircle.getX() + this.bottomCircle.getRadius(), (this.bottomCircle.getY() + top_y2) / STROKE_WIDTH, top_x2, top_y2);
        this.mPath.close();
    }

    private double getAngle() {
        return Math.asin((double) ((this.topCircle.getRadius() - this.bottomCircle.getRadius()) / (this.bottomCircle.getY() - this.topCircle.getY())));
    }

    public Animator createAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(180);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WaterDropView.this.updateComleteState(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return valueAnimator;
    }

    public void updateComleteState(float percent) {
        float bottom_r = ((this.mMinCircleRaidus - this.mMaxCircleRadius) * percent) + this.mMaxCircleRadius;
        float bottomCricleOffset = STROKE_WIDTH * percent * this.mMaxCircleRadius;
        this.topCircle.setRadius((float) (((double) this.mMaxCircleRadius) - ((0.25d * ((double) percent)) * ((double) this.mMaxCircleRadius))));
        this.bottomCircle.setRadius(bottom_r);
        this.bottomCircle.setY(this.topCircle.getY() + bottomCricleOffset);
        requestLayout();
        postInvalidate();
    }

    public Circle getTopCircle() {
        return this.topCircle;
    }

    public Circle getBottomCircle() {
        return this.bottomCircle;
    }

    public void setIndicatorColor(int color) {
        this.mPaint.setColor(color);
    }

    public int getIndicatorColor() {
        return this.mPaint.getColor();
    }
}
