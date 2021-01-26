package com.arashivision.insbase.graphic;

import android.media.Image;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;

public class ImageReaderBridge {
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public OnImageAvailableListener mListener = new OnImageAvailableListener() {
        public void onImageAvailable(ImageReader imageReader) {
            if (imageReader == ImageReaderBridge.this.mReader) {
                ImageReaderBridge imageReaderBridge = ImageReaderBridge.this;
                imageReaderBridge.nativeNotifyImageAvailable(imageReaderBridge.mNativeInstance);
            }
        }
    };
    public long mNativeInstance;
    public ImageReader mReader;

    public ImageReaderBridge(long j2, ImageReader imageReader) {
        this.mNativeInstance = j2;
        HandlerThread handlerThread = new HandlerThread("ImageReaderBridge");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.mHandlerThread.getLooper());
        this.mHandler = handler;
        this.mReader = imageReader;
        imageReader.setOnImageAvailableListener(this.mListener, handler);
    }

    private Image acquireLatestImage() {
        return this.mReader.acquireLatestImage();
    }

    private Image acquireNextImage() {
        return this.mReader.acquireNextImage();
    }

    private void close() {
        this.mReader.close();
        this.mHandlerThread.quit();
        this.mNativeInstance = 0;
    }

    private int getHeight() {
        return this.mReader.getHeight();
    }

    private int getImageFormat() {
        return this.mReader.getImageFormat();
    }

    private int getMaxImages() {
        return this.mReader.getMaxImages();
    }

    private Surface getSurface() {
        return this.mReader.getSurface();
    }

    private int getWidth() {
        return this.mReader.getWidth();
    }

    /* access modifiers changed from: private */
    public native void nativeNotifyImageAvailable(long j2);

    public static ImageReaderBridge newInstance(long j2, int i2, int i3, int i4, int i5) {
        return new ImageReaderBridge(j2, ImageReader.newInstance(i2, i3, i4, i5));
    }
}
