package com.arashivision.camera.listener;

import e.e.a.e.b;
import java.util.List;

public interface IBleScanListener {
    void onScanFinished(List<b> list);

    void onScanStarted(boolean z);

    void onScanning(b bVar);
}
