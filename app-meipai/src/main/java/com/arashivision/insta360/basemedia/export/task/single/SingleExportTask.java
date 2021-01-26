package com.arashivision.insta360.basemedia.export.task.single;

import a.a.a.a.c.a.c;
import a.a.a.a.d.b;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.arashivision.arvbmg.exporter.OneExport;
import com.arashivision.arvbmg.exporter.OneExportCallback;
import com.arashivision.insta360.basemedia.export.IExportTask;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import java.util.concurrent.CountDownLatch;

public abstract class SingleExportTask implements IExportTask {

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public static final MediaLogger f7L11I = MediaLogger.getLogger(SingleExportTask.class);
    public OneExport I1I;
    public int IL1Iii;
    public ISingleExportListener ILil;
    public Handler Ilil;

    /* renamed from: I丨L reason: contains not printable characters */
    public long f8IL;

    /* renamed from: I丨iL reason: contains not printable characters */
    public b f9IiL;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public double f10iILLL1 = 0.0d;

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public boolean f11lLi1LL = false;

    public class IL1Iii implements OneExportCallback {
        public final /* synthetic */ com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii[] IL1Iii;
        public final /* synthetic */ CountDownLatch ILil;

        public IL1Iii(com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii[] iL1IiiArr, CountDownLatch countDownLatch) {
            this.IL1Iii = iL1IiiArr;
            this.ILil = countDownLatch;
        }

        public void onExportProgressNotify(double d2) {
            MediaLogger mediaLogger = SingleExportTask.f7L11I;
            StringBuilder sb = new StringBuilder();
            sb.append("progress: ");
            sb.append(d2);
            mediaLogger.d(sb.toString());
            SingleExportTask singleExportTask = SingleExportTask.this;
            singleExportTask.f10iILLL1 = d2;
            singleExportTask.f9IiL.b();
            SingleExportTask singleExportTask2 = SingleExportTask.this;
            ISingleExportListener iSingleExportListener = singleExportTask2.ILil;
            if (iSingleExportListener != null) {
                iSingleExportListener.onProgress(singleExportTask2.IL1Iii, (float) singleExportTask2.f10iILLL1);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
            r4.I1I.f9IiL.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
            if (r5 == 0) goto L_0x0050;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
            if (r5 == 1) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
            if (r5 == 2) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
            r4.I1I.m5IL();
            com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.f7L11I.d("complete");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
            com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.f7L11I.d("canceled");
            r4.I1I.ILil();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
            r6 = com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.f7L11I;
            r0 = e.a.a.a.a.a("error, ");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
            if (r7 == null) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
            r2 = new java.lang.StringBuilder();
            r2.append(r7.getErrorCode());
            r2.append("-");
            r2.append(r7.getDomain());
            r2.append("-");
            r2.append(r7.getDesc());
            r2 = r2.toString();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
            r2 = "";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0085, code lost:
            r0.append(r2);
            r6.e(r0.toString());
            r4.I1I.ILil();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
            r4.IL1Iii[0] = new com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii(r5, r7);
            r4.ILil.countDown();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a2, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onExportStateNotify(int r5, int r6, com.arashivision.arvbmg.exporter.ExportError r7) {
            /*
                r4 = this;
                r0 = 3
                if (r5 != r0) goto L_0x000d
                com.arashivision.insta360.basemedia.export.task.single.SingleExportTask r5 = com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.this
                com.arashivision.insta360.basemedia.export.task.single.ISingleExportListener r5 = r5.ILil
                if (r5 == 0) goto L_0x000c
                r5.onNotify(r6)
            L_0x000c:
                return
            L_0x000d:
                com.arashivision.insta360.basemedia.export.task.single.SingleExportTask r6 = com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.this
                monitor-enter(r6)
                com.arashivision.insta360.basemedia.export.task.single.SingleExportTask r0 = com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.this     // Catch:{ all -> 0x00a3 }
                r1 = 0
                r0.f11lLi1LL = r1     // Catch:{ all -> 0x00a3 }
                com.arashivision.insta360.basemedia.export.task.single.SingleExportTask r0 = com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.this     // Catch:{ all -> 0x00a3 }
                a.a.a.a.d.b r0 = r0.f9IiL     // Catch:{ all -> 0x00a3 }
                boolean r0 = r0.f442e     // Catch:{ all -> 0x00a3 }
                if (r0 == 0) goto L_0x0025
                com.arashivision.insta360.basemedia.export.task.single.SingleExportTask r5 = com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.this     // Catch:{ all -> 0x00a3 }
                r5.release()     // Catch:{ all -> 0x00a3 }
                monitor-exit(r6)     // Catch:{ all -> 0x00a3 }
                return
            L_0x0025:
                monitor-exit(r6)     // Catch:{ all -> 0x00a3 }
                com.arashivision.insta360.basemedia.export.task.single.SingleExportTask r6 = com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.this
                a.a.a.a.d.b r6 = r6.f9IiL
                r6.a()
                if (r5 == 0) goto L_0x0050
                r6 = 1
                if (r5 == r6) goto L_0x0043
                r6 = 2
                if (r5 == r6) goto L_0x0036
                goto L_0x0094
            L_0x0036:
                com.arashivision.insta360.basemedia.export.task.single.SingleExportTask r6 = com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.this
                r6.m5IL()
                com.arashivision.insta360.basemedia.log.MediaLogger r6 = com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.f7L11I
                java.lang.String r0 = "complete"
                r6.d(r0)
                goto L_0x0094
            L_0x0043:
                com.arashivision.insta360.basemedia.log.MediaLogger r6 = com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.f7L11I
                java.lang.String r0 = "canceled"
                r6.d(r0)
                com.arashivision.insta360.basemedia.export.task.single.SingleExportTask r6 = com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.this
                r6.ILil()
                goto L_0x0094
            L_0x0050:
                com.arashivision.insta360.basemedia.log.MediaLogger r6 = com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.f7L11I
                java.lang.String r0 = "error, "
                java.lang.StringBuilder r0 = e.a.a.a.a.a(r0)
                if (r7 == 0) goto L_0x0083
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                int r3 = r7.getErrorCode()
                r2.append(r3)
                java.lang.String r3 = "-"
                r2.append(r3)
                java.lang.String r3 = r7.getDomain()
                r2.append(r3)
                java.lang.String r3 = "-"
                r2.append(r3)
                java.lang.String r3 = r7.getDesc()
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                goto L_0x0085
            L_0x0083:
                java.lang.String r2 = ""
            L_0x0085:
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                r6.e(r0)
                com.arashivision.insta360.basemedia.export.task.single.SingleExportTask r6 = com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.this
                r6.ILil()
            L_0x0094:
                com.arashivision.insta360.basemedia.export.IExportTask$IL1Iii[] r6 = r4.IL1Iii
                com.arashivision.insta360.basemedia.export.IExportTask$IL1Iii r0 = new com.arashivision.insta360.basemedia.export.IExportTask$IL1Iii
                r0.<init>(r5, r7)
                r6[r1] = r0
                java.util.concurrent.CountDownLatch r5 = r4.ILil
                r5.countDown()
                return
            L_0x00a3:
                r5 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x00a3 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.IL1Iii.onExportStateNotify(int, int, com.arashivision.arvbmg.exporter.ExportError):void");
        }
    }

    public SingleExportTask(int i2, ISingleExportListener iSingleExportListener) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.Ilil = handler;
        this.f9IiL = new b(handler);
        this.IL1Iii = i2;
        this.ILil = iSingleExportListener;
        this.f8IL = SystemClock.uptimeMillis();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void IL1Iii(com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii[] iL1IiiArr, CountDownLatch countDownLatch) {
        stopExport();
        ILil();
        iL1IiiArr[0] = new com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii(0, -13016, null);
        countDownLatch.countDown();
    }

    public abstract c I1I();

    public abstract void IL1Iii();

    public abstract void ILil();

    public abstract void Ilil();

    /* renamed from: I丨L reason: contains not printable characters */
    public abstract void m5IL();

    public Handler getCallbackHandler() {
        return this.Ilil;
    }

    public long getCreationTime() {
        return this.f8IL;
    }

    public int getEventId() {
        return this.IL1Iii;
    }

    public ISingleExportListener getExportListener() {
        return this.ILil;
    }

    public int getPriority() {
        return 1000;
    }

    public String getRunningQueueName() {
        return IExportTask.QUEUE_FOREGROUND;
    }

    public void release() {
        synchronized (this) {
            if (this.I1I != null && !this.f11lLi1LL) {
                this.I1I.release();
                this.I1I = null;
                f7L11I.d("released~");
            }
        }
    }

    public void setCallbackHandler(Handler handler) {
        this.Ilil = handler;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r1 = new com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii[]{null};
        r2 = new java.util.concurrent.CountDownLatch(1);
        r8.I1I.setStateCallback(new com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.IL1Iii(r8, r1, r2), new android.os.Handler(android.os.Looper.getMainLooper()));
        IL1Iii();
        r4 = r8.f9IiL;
        r4.f439b = 300000;
        r4.f440c = new e.b.c.b.a.b.a.a(r8, r1, r2);
        r8.f9IiL.c();
        r8.f11lLi1LL = true;
        r8.I1I.start();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2.await();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0055, code lost:
        r0.printStackTrace();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii startExport() {
        /*
            r8 = this;
            a.a.a.a.c.a.c r0 = r8.I1I()
            monitor-enter(r8)
            com.arashivision.insta360.basemedia.export.IExportTask$IL1Iii r1 = r0.f432b     // Catch:{ all -> 0x0061 }
            if (r1 == 0) goto L_0x000d
            com.arashivision.insta360.basemedia.export.IExportTask$IL1Iii r0 = r0.f432b     // Catch:{ all -> 0x0061 }
            monitor-exit(r8)     // Catch:{ all -> 0x0061 }
            return r0
        L_0x000d:
            java.lang.Object r0 = r0.f431a     // Catch:{ all -> 0x0061 }
            com.arashivision.arvbmg.exporter.OneExport r0 = (com.arashivision.arvbmg.exporter.OneExport) r0     // Catch:{ all -> 0x0061 }
            r8.I1I = r0     // Catch:{ all -> 0x0061 }
            monitor-exit(r8)     // Catch:{ all -> 0x0061 }
            r0 = 1
            com.arashivision.insta360.basemedia.export.IExportTask$IL1Iii[] r1 = new com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii[r0]
            r2 = 0
            r3 = 0
            r1[r3] = r2
            java.util.concurrent.CountDownLatch r2 = new java.util.concurrent.CountDownLatch
            r2.<init>(r0)
            com.arashivision.arvbmg.exporter.OneExport r4 = r8.I1I
            com.arashivision.insta360.basemedia.export.task.single.SingleExportTask$IL1Iii r5 = new com.arashivision.insta360.basemedia.export.task.single.SingleExportTask$IL1Iii
            r5.<init>(r1, r2)
            android.os.Handler r6 = new android.os.Handler
            android.os.Looper r7 = android.os.Looper.getMainLooper()
            r6.<init>(r7)
            r4.setStateCallback(r5, r6)
            r8.IL1Iii()
            a.a.a.a.d.b r4 = r8.f9IiL
            r5 = 300000(0x493e0, double:1.482197E-318)
            r4.f439b = r5
            e.b.c.b.a.b.a.a r5 = new e.b.c.b.a.b.a.a
            r5.<init>(r8, r1, r2)
            r4.f440c = r5
            a.a.a.a.d.b r4 = r8.f9IiL
            r4.c()
            r8.f11lLi1LL = r0
            com.arashivision.arvbmg.exporter.OneExport r0 = r8.I1I
            r0.start()
            r2.await()     // Catch:{ InterruptedException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0058:
            r8.release()
            r8.Ilil()
            r0 = r1[r3]
            return r0
        L_0x0061:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0061 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.export.task.single.SingleExportTask.startExport():com.arashivision.insta360.basemedia.export.IExportTask$IL1Iii");
    }

    public void stopExport() {
        this.f9IiL.a();
        synchronized (this) {
            if (this.I1I != null) {
                this.I1I.cancel();
            }
        }
    }
}
