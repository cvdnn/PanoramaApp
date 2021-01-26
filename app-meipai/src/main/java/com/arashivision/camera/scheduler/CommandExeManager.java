package com.arashivision.camera.scheduler;

import android.util.Log;
import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.onecamera.OneDriver;
import e.a.a.a.a;

public class CommandExeManager {
    public static final String TAG = "com.arashivision.camera.scheduler.CommandExeManager";
    public final Schedulers scheduler = new CommandScheduler();

    public Object exeCommand(OneDriver oneDriver, long j2, InstaCmdExe... instaCmdExeArr) {
        Disposable scheduleDirect = this.scheduler.scheduleDirect(oneDriver, j2, instaCmdExeArr);
        String str = TAG;
        StringBuilder a2 = a.a("disposable = ");
        a2.append(scheduleDirect.isDisposed());
        Log.d(str, a2.toString());
        return scheduleDirect.getDiaposeObject();
    }

    public void exeCommandSync(OneDriver oneDriver, long j2, InstaCmdExe... instaCmdExeArr) {
        this.scheduler.scheduleDirectSync(oneDriver, j2, instaCmdExeArr);
    }
}
