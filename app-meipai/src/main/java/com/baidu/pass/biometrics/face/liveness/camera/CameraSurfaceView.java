package com.baidu.pass.biometrics.face.liveness.camera;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class CameraSurfaceView extends SurfaceView implements Callback {
    public CameraInterface cameraInterface;
    public SurfaceHolder mSurfaceHolder;

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        SurfaceHolder holder = getHolder();
        this.mSurfaceHolder = holder;
        holder.setFormat(-2);
        this.mSurfaceHolder.setType(3);
        this.mSurfaceHolder.addCallback(this);
    }

    public void setCameraInterface(CameraInterface cameraInterface2) {
        this.cameraInterface = cameraInterface2;
    }

    public void startPreview() {
        if (getContext() instanceof Activity) {
            this.cameraInterface.doStartPreview((Activity) getContext(), this.mSurfaceHolder);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (getContext() instanceof Activity) {
            this.cameraInterface.doStartPreview((Activity) getContext(), this.mSurfaceHolder);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.cameraInterface.doStopCamera();
    }
}
