package com.deepai.paipai.support.camera;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.deepai.library.support.utils.DeviceInfoUtil;
import com.deepai.paipai.CutImgLR;
import com.deepai.paipai.NativeStitcherWrapper;
import com.deepai.paipai.support.file.FileUtils;
import com.tencent.mm.sdk.platformtools.Util;

import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.apache.commons.httpclient.cookie.CookieSpec;

public class PicStitcher {
    private static final int DEFAULT_THREAD_COUNT = 1;
    public static final int STITCH_FAIL = -9;
    public static final int STITCH_SUCCESS = -8;
    private static final String TAG = "PicStitcher";
    private static double[] featuresParams = {9.0d, 0.35d, 1.0d, 0.6d, 0.05d, 0.08d};
    public static double[] imgSize;
    public static double[] imgSize360 = {360.0d, 640.0d};
    public static double[] imgSize540 = {540.0d, 980.0d};
    private static PicStitcher instance;
    private long[] features;
    private String[] filePaths;
    private NativeStitcherWrapper nsw;
    private long[] pairwise_matches;
    /* access modifiers changed from: private */
    public int picMaxNum = 0;
    private Thread pollingThread;
    /* access modifiers changed from: private */
    public Handler pollingThreadHandler;
    /* access modifiers changed from: private */
    public Semaphore pollingThreadHandlerSema = new Semaphore(0);
    private Semaphore pollingThreadSema;
    /* access modifiers changed from: private */
    public int stitchCount = 0;
    private LinkedList<Runnable> taskQueue;
    /* access modifiers changed from: private */
    public ExecutorService threadPool;
    /* access modifiers changed from: private */
    public Handler uiHandler;

    private PicStitcher(int threadCount) {
        init(threadCount);
    }

    private void init(int threadCount) {
        this.pollingThread = new Thread() {
            public void run() {
                Looper.prepare();
                PicStitcher.this.pollingThreadHandler = new Handler() {
                    public void handleMessage(Message msg) {
                        try {
                            PicStitcher.this.pollingThreadHandlerSema.acquire();
                        } catch (InterruptedException e) {
                        }
                        PicStitcher.this.threadPool.execute(PicStitcher.this.getTask());
                    }
                };
                Looper.loop();
            }
        };
        this.pollingThread.start();
        this.threadPool = Executors.newFixedThreadPool(threadCount);
        this.pollingThreadHandlerSema = new Semaphore(threadCount);
        this.taskQueue = new LinkedList<>();
    }

    public static PicStitcher getInstance() {
        if (instance == null) {
            synchronized (PicStitcher.class) {
                if (instance == null) {
                    instance = new PicStitcher(1);
                }
            }
        }
        return instance;
    }

    public void initStitch(Handler uiHandler2, int picMaxNum2) {
        this.uiHandler = uiHandler2;
        this.picMaxNum = picMaxNum2;
        this.stitchCount = 0;
        this.filePaths = new String[picMaxNum2];
        this.nsw = new NativeStitcherWrapper();
        this.features = new long[1];
        this.pairwise_matches = new long[1];
        this.features[0] = 0;
        this.pairwise_matches[0] = 0;
        this.nsw.initialize(picMaxNum2, this.features, this.pairwise_matches);
        if (DeviceInfoUtil.getTotalMem() <= 1) {
            imgSize = imgSize360;
        } else {
            imgSize = imgSize540;
        }
        Log.d(TAG, "stitcher init");
    }

    /* access modifiers changed from: private */
    public void endStitch() {
        this.uiHandler = null;
        this.picMaxNum = 0;
        this.stitchCount = 0;
    }

    public void addPic(final String picPath) {
        addTask(new Runnable() {
            public void run() {
                PicStitcher.this.getFeatures(picPath);
                if (PicStitcher.this.stitchCount == PicStitcher.this.picMaxNum && PicStitcher.this.uiHandler != null) {
                    String filePath = PicStitcher.this.doStitch();
                    Message msg = PicStitcher.this.uiHandler.obtainMessage();
                    if (filePath != null) {
                        msg.what = -8;
                        msg.obj = filePath;
                    } else {
                        msg.what = -9;
                    }
                    PicStitcher.this.uiHandler.sendMessage(msg);
                    PicStitcher.this.endStitch();
                }
                PicStitcher.this.pollingThreadHandlerSema.release();
            }
        });
    }

    /* access modifiers changed from: private */
    public void getFeatures(String picPath) {
        this.filePaths[this.stitchCount] = picPath;
        Log.d(TAG, "stitch " + this.stitchCount);
        int leftNum = this.nsw.findFeatures(picPath, this.features[0], this.stitchCount, featuresParams[0], featuresParams[1], featuresParams[2], featuresParams[3], featuresParams[4], featuresParams[5]);
        Log.d(TAG, "leftNum " + leftNum);
        if (this.stitchCount > 0) {
            this.nsw.match2ImgPairwise(this.features[0], this.pairwise_matches[0], leftNum, this.stitchCount - 1, this.stitchCount, this.picMaxNum, 2.5f, 100);
        }
        if (this.stitchCount == this.picMaxNum - 1) {
            this.nsw.match2ImgPairwise(this.features[0], this.pairwise_matches[0], leftNum, this.stitchCount, 0, this.picMaxNum, 2.5f, 100);
        }
        this.stitchCount++;
    }

    /* access modifiers changed from: private */
    public String doStitch() {
        String filePath = FileUtils.getPanoDir() + CookieSpec.PATH_DELIM + System.currentTimeMillis() + Util.PHOTO_DEFAULT_EXT;
        String tempPath = FileUtils.getFilePath() + "/tempStitchFile.jpg";
        String tempPath1 = FileUtils.getFilePath() + "/tempStitchFile1.jpg";
        if (this.nsw.performStitcher(tempPath, this.filePaths, this.picMaxNum, this.features[0], this.pairwise_matches[0], 10) == 0) {
            this.nsw.cutImage(tempPath, tempPath1);
            new CutImgLR().cutImageLR(tempPath1, filePath, 2, 2);
        } else {
            filePath = null;
        }
        File tempfile = new File(tempPath);
        File tempFile1 = new File(tempPath1);
        if (tempfile.exists()) {
            tempfile.delete();
        }
        if (tempFile1.exists()) {
            tempFile1.delete();
        }
        return filePath;
    }

    private synchronized void addTask(Runnable runnable) {
        this.taskQueue.add(runnable);
        if (this.pollingThreadHandler == null) {
            try {
                this.pollingThreadHandlerSema.acquire();
            } catch (InterruptedException e) {
            }
        }
        this.pollingThreadHandler.sendEmptyMessage(0);
    }

    /* access modifiers changed from: private */
    public Runnable getTask() {
        return (Runnable) this.taskQueue.removeFirst();
    }
}
