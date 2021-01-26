package com.deepai.paipai.wechattakephoto.manager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.util.LruCache;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MyImageLoader {
    private static final int DEFAULT_THREAD_COUNT = 3;
    private static MyImageLoader mInstance = null;
    private static final int maxMemoryCache = 4194304;
    private LruCache<String, Bitmap> mLruCache;
    private boolean mNeedRefresh;
    private Thread mPollingThread;
    /* access modifiers changed from: private */
    public Handler mPollingThreadHandler;
    /* access modifiers changed from: private */
    public Semaphore mSemaphorePollingThread;
    /* access modifiers changed from: private */
    public Semaphore mSemaphorePollingThreadHandler = new Semaphore(0);
    private LinkedList<Runnable> mTaskQueue;
    /* access modifiers changed from: private */
    public ExecutorService mThreadPool;
    private Type mType = Type.LIFO;
    private Handler mUIHandler;

    private class ImageBeanHolder {
        Bitmap bitmap;
        ImageView imageView;
        String path;

        private ImageBeanHolder() {
        }
    }

    private class ImageSize {
        int height;
        int width;

        private ImageSize() {
        }
    }

    public enum Type {
        FIFO,
        LIFO
    }

    private MyImageLoader(int threadCount, Type type) {
        init(threadCount, type);
    }

    private void init(int threadCount, Type type) {
        int i = maxMemoryCache;
        this.mPollingThread = new Thread() {
            public void run() {
                Looper.prepare();
                MyImageLoader.this.mPollingThreadHandler = new Handler() {
                    public void handleMessage(Message msg) {
                        MyImageLoader.this.mThreadPool.execute(MyImageLoader.this.getTask());
                        try {
                            MyImageLoader.this.mSemaphorePollingThread.acquire();
                        } catch (InterruptedException e) {
                        }
                    }
                };
                MyImageLoader.this.mSemaphorePollingThreadHandler.release();
                Looper.loop();
            }
        };
        this.mPollingThread.start();
        int maxAvailableMemory = (int) Runtime.getRuntime().maxMemory();
        if (maxAvailableMemory / 8 <= maxMemoryCache) {
            i = maxAvailableMemory / 8;
        }
        this.mLruCache = new LruCache<String, Bitmap>(i) {
            /* access modifiers changed from: protected */
            public int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
        this.mThreadPool = Executors.newFixedThreadPool(threadCount);
        this.mSemaphorePollingThread = new Semaphore(threadCount);
        this.mTaskQueue = new LinkedList<>();
        this.mType = type;
    }

    public static MyImageLoader getInstance() {
        return getInstance(3, Type.LIFO);
    }

    public static MyImageLoader getInstance(int threadCount, Type type) {
        if (mInstance == null) {
            synchronized (MyImageLoader.class) {
                if (mInstance == null) {
                    mInstance = new MyImageLoader(threadCount, type);
                }
            }
        }
        return mInstance;
    }

    public void loadImage(@NonNull final String path, @NonNull final ImageView imageView, boolean needRefresh) {
        imageView.setTag(path);
        this.mNeedRefresh = needRefresh;
        if (this.mUIHandler == null) {
            this.mUIHandler = new Handler() {
                public void handleMessage(Message msg) {
                    ImageBeanHolder holder = (ImageBeanHolder) msg.obj;
                    Bitmap bm = holder.bitmap;
                    ImageView imageView = holder.imageView;
                    if (imageView.getTag().toString().equals(holder.path)) {
                        imageView.setImageBitmap(bm);
                    }
                }
            };
        }
        Bitmap bm = getBitmapFromLruCache(path);
        if (bm != null) {
            refreshBitmap(path, imageView, bm);
        } else {
            addTask(new Runnable() {
                public void run() {
                    ImageSize imageSize = MyImageLoader.this.getImageViewSize(imageView);
                    Bitmap bm = MyImageLoader.this.decodeSampleBitmapFromPath(path, imageSize.width, imageSize.height);
                    if (bm != null) {
                        MyImageLoader.this.addBitmapToLruCache(path, bm);
                        MyImageLoader.this.refreshBitmap(path, imageView, bm);
                    }
                    MyImageLoader.this.mSemaphorePollingThread.release();
                }
            });
        }
    }

    public void clearLruCache() {
        if (this.mLruCache != null && this.mLruCache.size() > 0) {
            this.mLruCache.evictAll();
        }
    }

    public void removeFromLruCache(String imagePath) {
    }

    /* access modifiers changed from: private */
    public void refreshBitmap(String path, ImageView imageView, Bitmap bm) {
        if (bm != null) {
            Message msg = Message.obtain();
            ImageBeanHolder holder = new ImageBeanHolder();
            holder.bitmap = bm;
            holder.imageView = imageView;
            holder.path = path;
            msg.obj = holder;
            this.mUIHandler.sendMessage(msg);
        }
    }

    private synchronized void addTask(Runnable runnable) {
        this.mTaskQueue.add(runnable);
        if (this.mPollingThreadHandler == null) {
            try {
                this.mSemaphorePollingThreadHandler.acquire();
            } catch (InterruptedException e) {
            }
        }
        this.mPollingThreadHandler.sendEmptyMessage(0);
    }

    /* access modifiers changed from: private */
    public Runnable getTask() {
        if (this.mType == Type.LIFO) {
            return (Runnable) this.mTaskQueue.removeLast();
        }
        return (Runnable) this.mTaskQueue.removeFirst();
    }

    /* access modifiers changed from: private */
    public void addBitmapToLruCache(String path, Bitmap bm) {
        if (getBitmapFromLruCache(path) == null && bm != null) {
            this.mLruCache.put(path, bm);
        }
    }

    private Bitmap getBitmapFromLruCache(String path) {
        if (this.mNeedRefresh && this.mLruCache.get(path) != null) {
            this.mLruCache.remove(path);
        }
        return (Bitmap) this.mLruCache.get(path);
    }

    /* access modifiers changed from: private */
    public ImageSize getImageViewSize(ImageView imageView) {
        ImageSize imageSize = new ImageSize();
        DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
        LayoutParams lp = imageView.getLayoutParams();
        int width = imageView.getWidth();
        if (width <= 0) {
            width = lp.width;
        }
        if (width <= 0) {
            width = getFieldValue(imageView, "mMaxWidth");
        }
        if (width <= 0) {
            width = displayMetrics.widthPixels;
        }
        int height = imageView.getHeight();
        if (height <= 0) {
            height = lp.height;
        }
        if (height <= 0) {
            height = getFieldValue(imageView, "mMaxHeight");
        }
        if (height <= 0) {
            height = displayMetrics.heightPixels;
        }
        imageSize.width = width;
        imageSize.height = height;
        return imageSize;
    }

    private int getFieldValue(Object obj, String fieldName) {
        try {
            Field field = ImageView.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            int fieldValue = field.getInt(obj);
            if (fieldValue <= 0 || fieldValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return fieldValue;
        } catch (Exception e) {
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public Bitmap decodeSampleBitmapFromPath(String path, int width, int height) {
        Bitmap bm = null;
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);
            options.inSampleSize = calculateInSampleSize(options, width, height);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(path, options);
        } catch (Throwable th) {
            this.mLruCache.evictAll();
            return bm;
        }
    }

    private int calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        int width = options.outWidth;
        int height = options.outHeight;
        if (width > reqWidth || height > reqHeight) {
            return Math.max(Math.round((((float) width) * 1.0f) / ((float) reqWidth)), Math.round((((float) height) * 1.0f) / ((float) reqHeight)));
        }
        return 1;
    }
}
