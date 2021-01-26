package com.arashivision.camera.scheduler;

import android.util.Log;
import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.camera.exception.InstaError;
import com.arashivision.camera.scheduler.Schedulers.Worker;
import com.arashivision.onecamera.OneDriver;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class CommandScheduler extends Schedulers {
    public static final String KEY_NEWTHREAD_PRIORITY = "commandthread-priority";
    public static final CommandThreadFactory THREAD_FACTORY = new CommandThreadFactory(Math.max(1, Math.min(10, Integer.getInteger(KEY_NEWTHREAD_PRIORITY, 5).intValue())));
    public final ScheduledExecutorService executor;

    public static final class CommandWorker extends Worker {
        public volatile boolean disposed;
        public volatile Object disposedObject;
        public final ScheduledExecutorService executor;

        public CommandWorker(ScheduledExecutorService scheduledExecutorService) {
            this.executor = scheduledExecutorService;
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.executor.shutdownNow();
            }
        }

        public Object getDiaposeObject() {
            return this.disposedObject;
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public Disposable schedule(OneDriver oneDriver, long j2, boolean z, InstaCmdExe... instaCmdExeArr) {
            Future future;
            if (this.disposed) {
                return null;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(instaCmdExeArr, oneDriver);
            if (j2 <= 0) {
                try {
                    future = this.executor.submit(scheduledRunnable);
                } catch (Exception e2) {
                    InstaError.onError((Throwable) e2);
                }
            } else {
                future = this.executor.schedule(scheduledRunnable, j2, TimeUnit.MILLISECONDS);
            }
            scheduledRunnable.setFuture(future);
            StringBuilder sb = new StringBuilder();
            sb.append("sync = ");
            sb.append(z);
            Log.i("Runnable", sb.toString());
            if (!z) {
                this.disposedObject = future.get();
            }
            return scheduledRunnable;
        }
    }

    public CommandScheduler() {
        this(THREAD_FACTORY);
    }

    public Worker createWorker() {
        return new CommandWorker(this.executor);
    }

    public CommandScheduler(ThreadFactory threadFactory) {
        this.executor = Executors.newScheduledThreadPool(1, threadFactory);
    }
}
