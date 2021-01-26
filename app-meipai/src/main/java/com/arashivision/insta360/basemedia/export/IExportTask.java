package com.arashivision.insta360.basemedia.export;

import android.os.Handler;
import com.arashivision.arvbmg.exporter.ExportError;

public interface IExportTask {
    public static final int PRIORITY_BACKGROUND = 500;
    public static final int PRIORITY_FOREGROUND = 1000;
    public static final String QUEUE_BACKGROUND = "queue_background";
    public static final String QUEUE_FOREGROUND = "queue_foreground";

    public static class IL1Iii {
        public int I1I;
        public C0004IL1Iii IL1Iii;
        public int ILil;
        public ExportError Ilil;

        /* renamed from: I丨L reason: contains not printable characters */
        public String f1IL;

        /* renamed from: com.arashivision.insta360.basemedia.export.IExportTask$IL1Iii$IL1Iii reason: collision with other inner class name */
        public enum C0004IL1Iii {
            EXPORT,
            OTHER
        }

        public IL1Iii(int i2, int i3, String str) {
            this.IL1Iii = C0004IL1Iii.OTHER;
            this.ILil = i2;
            this.I1I = i3;
            this.f1IL = str;
        }

        public IL1Iii(int i2, ExportError exportError) {
            this.IL1Iii = C0004IL1Iii.EXPORT;
            this.ILil = i2;
            this.Ilil = exportError;
        }

        public String IL1Iii() {
            String str;
            if (this.IL1Iii == C0004IL1Iii.OTHER) {
                return this.f1IL;
            }
            if (this.Ilil != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.Ilil.getErrorCode());
                String str2 = "-";
                sb.append(str2);
                sb.append(this.Ilil.getDomain());
                sb.append(str2);
                sb.append(this.Ilil.getDesc());
                str = sb.toString();
            } else {
                str = "";
            }
            return str;
        }
    }

    Handler getCallbackHandler();

    long getCreationTime();

    int getEventId();

    int getExportHeight();

    IExportListener getExportListener();

    int getExportWidth();

    int getOriginalMediaHeight();

    int getOriginalMediaWidth();

    int getPriority();

    String getRunningQueueName();

    String logInfo();

    IL1Iii startExport();

    void stopExport();
}
