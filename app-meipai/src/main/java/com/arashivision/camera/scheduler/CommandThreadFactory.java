package com.arashivision.camera.scheduler;

import java.util.concurrent.ThreadFactory;

public class CommandThreadFactory implements ThreadFactory {
    public final int priority;

    public CommandThreadFactory(int i2) {
        this.priority = i2;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(this.priority);
        return thread;
    }
}
