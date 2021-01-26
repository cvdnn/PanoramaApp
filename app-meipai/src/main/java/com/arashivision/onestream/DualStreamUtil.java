package com.arashivision.onestream;

import com.arashivision.onestream.Gyro.ByteBuf;
import java.util.concurrent.CountDownLatch;

public class DualStreamUtil {

    public static class ClockUtil {
        public static final int MS_TO_NS = 1000000;

        public static long getCurTimeMs() {
            return System.nanoTime() / 1000000;
        }

        public static long getCurTimeNs() {
            return System.nanoTime();
        }

        public static long setMsToNs(long j2) {
            return j2 * 1000000;
        }

        public static long setNsToMs(long j2) {
            return j2 / 1000000;
        }
    }

    public static class RenderInfo {
        public ByteBuf mByteBuf;
        public int mIFrame;
        public int mIndex;
        public long mOriginPts;
        public long mPts;

        public RenderInfo(int i2, long j2, long j3, int i3, ByteBuf byteBuf) {
            this.mIndex = i2;
            this.mPts = j2;
            this.mIFrame = i3;
            this.mOriginPts = j3;
            this.mByteBuf = byteBuf;
        }

        public boolean isIFrame() {
            return this.mIFrame == 1;
        }
    }

    public static class SystemClock {
        public long mStartTimeNs;

        public long getCurrentTimeUs() {
            return (System.nanoTime() - this.mStartTimeNs) / 1000;
        }

        public boolean isStarted() {
            return this.mStartTimeNs != 0;
        }

        public void reset() {
            this.mStartTimeNs = 0;
        }

        public void start() {
            this.mStartTimeNs = System.nanoTime();
        }
    }

    public static class TaskWaiter {
        public CountDownLatch mLatch = new CountDownLatch(1);

        public void await() {
            try {
                this.mLatch.await();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        public void done() {
            this.mLatch.countDown();
        }
    }

    public static long getTid() {
        return Thread.currentThread().getId();
    }

    public static boolean isIFrame(ImageData imageData) {
        return imageData.flags == 1;
    }

    public static void waitUntil(Object obj, long j2) {
        long nanoTime = j2 - System.nanoTime();
        if (nanoTime > 0) {
            long j3 = nanoTime / 1000000;
            try {
                obj.wait(j3, (int) (nanoTime - (1000000 * j3)));
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }
}
