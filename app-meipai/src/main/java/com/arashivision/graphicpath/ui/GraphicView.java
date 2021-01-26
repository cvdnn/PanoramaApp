package com.arashivision.graphicpath.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.arashivision.graphicpath.R;
import com.arashivision.graphicpath.render.HybridRender;
import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.insbase.arlog.Log;

public class GraphicView extends FrameLayout {
    public static final String TAG = "graphicpath";
    public boolean mDestroyed;
    public long mNativeInstance;
    public HybridRender mRender;
    public Callback mSurfaceCallback = new Callback() {
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            if (!GraphicView.this.mDestroyed) {
                if (!GraphicView.this.mSurfaceCreated) {
                    GraphicView.this.nativeOnSurfaceCreated(surfaceHolder.getSurface(), i3, i4);
                    GraphicView.this.mSurfaceCreated = true;
                    return;
                }
                GraphicView.this.nativeOnSurfaceChanged(i3, i4);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (!GraphicView.this.mDestroyed && GraphicView.this.mSurfaceCreated) {
                GraphicView.this.nativeOnSurfaceDestroyed();
                GraphicView.this.mSurfaceCreated = false;
            }
        }
    };
    public boolean mSurfaceCreated;
    public SurfaceView mSurfaceView;
    public OnTouchListener mSurfaceViewDefaultTouchListener = new OnTouchListener() {
        public int[] pointerIDList = new int[10];
        public float[] xList = new float[10];
        public float[] yList = new float[10];

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int min = Math.min(motionEvent.getPointerCount(), this.pointerIDList.length);
            for (int i2 = 0; i2 < min; i2++) {
                this.pointerIDList[i2] = motionEvent.getPointerId(i2);
                this.xList[i2] = motionEvent.getX(i2);
                this.yList[i2] = motionEvent.getY(i2);
            }
            GraphicView.this.nativeOnTouch(motionEvent.getActionMasked(), motionEvent.getActionIndex(), min, motionEvent.getEventTime(), this.xList, this.yList, this.pointerIDList);
            return true;
        }
    };
    public SurfaceTextureListener mTextureListener = new SurfaceTextureListener() {
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Log.i(GraphicView.TAG, "onSurfaceTextureAvailable");
            if (!GraphicView.this.mSurfaceCreated) {
                GraphicView.this.nativeOnSurfaceCreated(new Surface(surfaceTexture), i2, i3);
                GraphicView.this.mSurfaceCreated = true;
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (GraphicView.this.mDestroyed || !GraphicView.this.mSurfaceCreated) {
                return false;
            }
            GraphicView.this.nativeOnSurfaceDestroyed();
            GraphicView.this.mSurfaceCreated = false;
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            Log.i(GraphicView.TAG, "onSurfaceTextureSizeChanged");
            if (!GraphicView.this.mDestroyed) {
                if (!GraphicView.this.mSurfaceCreated) {
                    GraphicView.this.nativeOnSurfaceCreated(new Surface(surfaceTexture), i2, i3);
                    GraphicView.this.mSurfaceCreated = true;
                    return;
                }
                GraphicView.this.nativeOnSurfaceChanged(i2, i3);
            }
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    public TextureView mTextureView;
    public boolean mUseTextView = false;

    static {
        RenderLibsLoader.load();
    }

    public GraphicView(Context context) {
        super(context);
        nativeCreate();
        initView(false);
    }

    private boolean getAttrTextureView(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GraphicView, i2, i3);
        if (obtainStyledAttributes == null) {
            return false;
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.GraphicView_useTextureView, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    private void initView(boolean z) {
        this.mUseTextView = z;
        if (z) {
            TextureView textureView = new TextureView(getContext());
            this.mTextureView = textureView;
            addView(textureView, new LayoutParams(-1, -1));
            this.mTextureView.setSurfaceTextureListener(this.mTextureListener);
            this.mTextureView.setOnTouchListener(this.mSurfaceViewDefaultTouchListener);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.mSurfaceView = surfaceView;
        addView(surfaceView, new LayoutParams(-1, -1));
        this.mSurfaceView.getHolder().addCallback(this.mSurfaceCallback);
        this.mSurfaceView.setOnTouchListener(this.mSurfaceViewDefaultTouchListener);
    }

    private native void nativeCreate();

    private native void nativeDestroy();

    /* access modifiers changed from: private */
    public native void nativeOnSurfaceChanged(int i2, int i3);

    /* access modifiers changed from: private */
    public native void nativeOnSurfaceCreated(Surface surface, int i2, int i3);

    /* access modifiers changed from: private */
    public native void nativeOnSurfaceDestroyed();

    /* access modifiers changed from: private */
    public native void nativeOnTouch(int i2, int i3, int i4, long j2, float[] fArr, float[] fArr2, int[] iArr);

    private native void nativeRemoveRender();

    private native void nativeSetRender(HybridRender hybridRender);

    public void destroy() {
        if (!this.mDestroyed) {
            if (this.mRender != null) {
                Log.e(TAG, "GraphicView: should remove render before release! Force remove render...");
                removeRender();
            }
            nativeDestroy();
            this.mDestroyed = true;
        }
    }

    public void finalize() throws Throwable {
        if (!this.mDestroyed) {
            String str = TAG;
            Log.e(str, "GraphicView: finalize, GraphicView not released, you should release it manually! Force release...");
            if (this.mRender != null) {
                Log.i(str, "GraphicView: finalizing, remove render");
                removeRender();
            }
            destroy();
        }
        super.finalize();
    }

    public native long getNativeInstance();

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        StringBuilder sb = new StringBuilder();
        sb.append("GraphicView: onWindowFocusChanged: ");
        sb.append(z);
        Log.i(TAG, sb.toString());
    }

    public void removeRender() {
        if (this.mRender != null) {
            this.mRender = null;
            nativeRemoveRender();
        }
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        if (this.mUseTextView) {
            this.mTextureView.setOnTouchListener(onTouchListener);
        } else {
            this.mSurfaceView.setOnTouchListener(onTouchListener);
        }
    }

    public void setRender(HybridRender hybridRender) {
        if (hybridRender == null) {
            removeRender();
            return;
        }
        this.mRender = hybridRender;
        nativeSetRender(hybridRender);
    }

    public GraphicView(Context context, boolean z) {
        super(context);
        nativeCreate();
        initView(z);
    }

    public GraphicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        nativeCreate();
        initView(getAttrTextureView(context, attributeSet, R.attr.useTextureView, 0));
    }

    public GraphicView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        nativeCreate();
        initView(getAttrTextureView(context, attributeSet, i2, 0));
    }

    public GraphicView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        nativeCreate();
        initView(getAttrTextureView(context, attributeSet, i2, i3));
    }
}
