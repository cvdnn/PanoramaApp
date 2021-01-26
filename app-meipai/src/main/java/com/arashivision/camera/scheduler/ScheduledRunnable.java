package com.arashivision.camera.scheduler;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.camera.exception.InstaError;
import com.arashivision.onecamera.OneDriver;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

public class ScheduledRunnable extends AtomicReference<Future<?>> implements Callable<Object>, Disposable {
    public static final FutureTask<Void> DISPOSED = new FutureTask<>(EMPTY_RUNNABLE, null);
    public static final Runnable EMPTY_RUNNABLE = new EmptyRunnable();
    public static final FutureTask<Void> FINISHED = new FutureTask<>(EMPTY_RUNNABLE, null);
    public InstaCmdExe[] instaCmdExes;
    public final OneDriver onDriver;
    public Thread runner;

    public static final class EmptyRunnable implements Runnable {
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    public ScheduledRunnable(InstaCmdExe[] instaCmdExeArr, OneDriver oneDriver) {
        this.instaCmdExes = instaCmdExeArr;
        this.onDriver = oneDriver;
    }

    public Object call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            if (this.instaCmdExes == null) {
                lazySet(FINISHED);
                this.runner = null;
                return null;
            }
            if (this.instaCmdExes.length > 1) {
                for (InstaCmdExe exeCmd : this.instaCmdExes) {
                    exeCmd.exeCmd(this.onDriver);
                }
            } else if (this.instaCmdExes.length == 1) {
                Object exeCmd2 = this.instaCmdExes[0].exeCmd(this.onDriver);
                lazySet(FINISHED);
                this.runner = null;
                return exeCmd2;
            }
            lazySet(FINISHED);
            this.runner = null;
            return Integer.valueOf(-1);
        } catch (Exception e2) {
            InstaError.onError((Throwable) e2);
        } catch (Throwable th) {
            lazySet(FINISHED);
            this.runner = null;
            throw th;
        }
    }

    public void dispose() {
        Future future = (Future) get();
        if (future != FINISHED) {
            FutureTask<Void> futureTask = DISPOSED;
            if (future != futureTask && compareAndSet(future, futureTask) && future != null) {
                future.cancel(this.runner != Thread.currentThread());
            }
        }
    }

    public Object getDiaposeObject() {
        try {
            return ((Future) get()).get();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return Integer.valueOf(-1);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
            return Integer.valueOf(-1);
        }
    }

    public boolean isDisposed() {
        Future future = (Future) get();
        return future == FINISHED || future == DISPOSED;
    }

    public void setFuture(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 != FINISHED) {
                if (future2 == DISPOSED) {
                    future.cancel(this.runner != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
