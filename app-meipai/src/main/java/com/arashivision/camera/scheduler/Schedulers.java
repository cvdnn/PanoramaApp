package com.arashivision.camera.scheduler;

import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;

public abstract class Schedulers {

    public static abstract class Worker implements Disposable {
        public abstract Disposable schedule(OneDriver oneDriver, long j2, boolean z, InstaCmdExe... instaCmdExeArr);
    }

    public abstract Worker createWorker();

    public Disposable scheduleDirect(OneDriver oneDriver, long j2, InstaCmdExe... instaCmdExeArr) {
        Worker createWorker = createWorker();
        createWorker.schedule(oneDriver, j2, false, instaCmdExeArr);
        return createWorker;
    }

    public void scheduleDirectSync(OneDriver oneDriver, long j2, InstaCmdExe... instaCmdExeArr) {
        createWorker().schedule(oneDriver, j2, true, instaCmdExeArr);
    }
}
