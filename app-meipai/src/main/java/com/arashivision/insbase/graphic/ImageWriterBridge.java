package com.arashivision.insbase.graphic;

import android.annotation.TargetApi;
import android.media.Image;
import android.media.ImageWriter;
import android.media.ImageWriter.OnImageReleasedListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;

@TargetApi(23)
public class ImageWriterBridge {
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public OnImageReleasedListener mListener = new OnImageReleasedListener() {
        public void onImageReleased(ImageWriter imageWriter) {
            if (imageWriter == ImageWriterBridge.this.mWriter) {
                ImageWriterBridge imageWriterBridge = ImageWriterBridge.this;
                imageWriterBridge.nativeNotifyImageReleased(imageWriterBridge.mNativeInstance);
            }
        }
    };
    public long mNativeInstance;
    public ImageWriter mWriter;

    public ImageWriterBridge(long j2, ImageWriter imageWriter) {
        this.mNativeInstance = j2;
        HandlerThread handlerThread = new HandlerThread("ImageWriterBridge");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.mHandlerThread.getLooper());
        this.mHandler = handler;
        this.mWriter = imageWriter;
        imageWriter.setOnImageReleasedListener(this.mListener, handler);
    }

    private void close() {
        this.mWriter.close();
        this.mHandlerThread.quit();
        this.mWriter = null;
    }

    private Image dequeueInputImage() {
        return this.mWriter.dequeueInputImage();
    }

    private int getFormat() {
        return this.mWriter.getFormat();
    }

    private int getMaxImages() {
        return this.mWriter.getMaxImages();
    }

    /* access modifiers changed from: private */
    public native void nativeNotifyImageReleased(long j2);

    public static ImageWriterBridge newInstance(long j2, Surface surface, int i2) {
        return new ImageWriterBridge(j2, ImageWriter.newInstance(surface, i2));
    }

    private void queueInputImage(Image image) {
        this.mWriter.queueInputImage(image);
    }
}
