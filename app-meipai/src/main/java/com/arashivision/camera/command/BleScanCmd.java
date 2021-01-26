package com.arashivision.camera.command;

import com.arashivision.camera.listener.IBleScanListener;
import com.arashivision.onecamera.OneDriver;
import com.baidu.mobstat.Config;
import e.e.a.a;
import e.e.a.a.C0102a;
import e.e.a.d.i;
import e.e.a.e.b;
import java.util.List;

public class BleScanCmd extends i implements InstaCmdExe {
    public final a mBleManager;
    public final IBleScanListener mBleScanListener;

    public BleScanCmd(IBleScanListener iBleScanListener) {
        this.mBleScanListener = iBleScanListener;
        a aVar = C0102a.f7939a;
        this.mBleManager = aVar;
        if (aVar != null) {
            e.e.a.h.a.f8024a = true;
            aVar.f7937i = 1;
            aVar.f7938j = Config.BPLUS_DELAY_TIME;
            aVar.l = 20000;
            aVar.f7936h = 5000;
            return;
        }
        throw null;
    }

    public Object exeCmd(OneDriver oneDriver) {
        this.mBleManager.a(this);
        return null;
    }

    public void onScanFinished(List<b> list) {
        this.mBleScanListener.onScanFinished(list);
    }

    public void onScanStarted(boolean z) {
        this.mBleScanListener.onScanStarted(z);
    }

    public void onScanning(b bVar) {
        this.mBleScanListener.onScanning(bVar);
    }
}
