package com.arashivision.camera.command.ble;

import android.util.Log;
import com.arashivision.camera.command.InstaCmdExe;
import com.arashivision.camera.listener.IBleScanListener;
import com.arashivision.onecamera.OneDriver;
import e.e.a.a;
import e.e.a.a.C0102a;
import e.e.a.d.i;
import e.e.a.e.b;
import e.e.a.g.d;
import java.util.List;

public class BleScanCmd extends i implements InstaCmdExe {
    public final a mBleManager;
    public final IBleScanListener mBleScanListener;

    public BleScanCmd(long j2, boolean z, IBleScanListener iBleScanListener) {
        this.mBleScanListener = iBleScanListener;
        a aVar = C0102a.f7939a;
        this.mBleManager = aVar;
        d dVar = new d();
        dVar.f8016d = z;
        dVar.f8017e = false;
        dVar.f8018f = j2;
        aVar.f7930b = dVar;
        a aVar2 = this.mBleManager;
        if (aVar2 != null) {
            e.e.a.h.a.f8024a = true;
            aVar2.f7937i = 2;
            aVar2.f7938j = 3000;
            aVar2.l = 20000;
            aVar2.f7936h = 5000;
            return;
        }
        throw null;
    }

    public Object exeCmd(OneDriver oneDriver) {
        StringBuilder sb = new StringBuilder();
        sb.append("one driver = ");
        sb.append(oneDriver);
        Log.d("---", sb.toString());
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
