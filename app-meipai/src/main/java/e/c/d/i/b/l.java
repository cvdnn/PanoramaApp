package e.c.d.i.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.RectF;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.io.IOException;

@SuppressLint({"ViewConstructor"})
/* compiled from: CameraPreview */
public class l extends SurfaceView implements Callback {

    /* renamed from: a reason: collision with root package name */
    public SurfaceHolder f6185a;

    /* renamed from: b reason: collision with root package name */
    public Camera f6186b;

    public l(Context context, Camera camera) {
        super(context);
        this.f6186b = camera;
        SurfaceHolder holder = getHolder();
        this.f6185a = holder;
        holder.addCallback(this);
    }

    public int getPreviewHeight() {
        return getHeight();
    }

    public RectF getPreviewRect() {
        return new RectF((float) getLeft(), (float) getTop(), (float) getRight(), (float) getBottom());
    }

    public int getPreviewWidth() {
        return getWidth();
    }

    public void setCamera(Camera camera) {
        this.f6186b = camera;
        try {
            camera.setPreviewDisplay(this.f6185a);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            this.f6186b.setPreviewDisplay(surfaceHolder);
        } catch (IOException e2) {
            e2.getMessage();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
