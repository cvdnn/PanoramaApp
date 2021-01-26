package com.arashivision.onecamera;

import java.util.concurrent.CountDownLatch;

public class TaskWaiter {
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
