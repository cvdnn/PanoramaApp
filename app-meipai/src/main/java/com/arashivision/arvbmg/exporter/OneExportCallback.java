package com.arashivision.arvbmg.exporter;

public interface OneExportCallback {
    void onExportProgressNotify(double d2);

    void onExportStateNotify(int i2, int i3, ExportError exportError);
}
