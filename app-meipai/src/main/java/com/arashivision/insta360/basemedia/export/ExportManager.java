package com.arashivision.insta360.basemedia.export;

import a.a.a.a.c.a.a.a.a;
import a.a.a.a.c.a.b;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ExportManager {
    public static ExportManager I1I = null;
    public static final MediaLogger ILil = MediaLogger.getLogger(ExportManager.class);
    public final Map<String, ILil> IL1Iii = new ConcurrentHashMap();

    public class IL1Iii implements Runnable {
        public final /* synthetic */ String I1I;
        public final /* synthetic */ Pair IL1Iii;
        public final /* synthetic */ ILil ILil;

        public IL1Iii(Pair pair, ILil iLil, String str) {
            this.IL1Iii = pair;
            this.ILil = iLil;
            this.I1I = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void IL1Iii(Pair pair, com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii iL1Iii, String str) {
            Object obj = pair.first;
            if (!(obj instanceof a)) {
                b.a((IExportTask) obj, iL1Iii);
            }
            ExportManager.this.IL1Iii(str);
        }

        public void run() {
            com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii startExport = ((IExportTask) this.IL1Iii.first).startExport();
            synchronized (this.ILil.IL1Iii) {
                this.ILil.ILil = null;
                this.ILil.IL1Iii.set(false);
            }
            Handler callbackHandler = ((IExportTask) this.IL1Iii.first).getCallbackHandler();
            if (callbackHandler == null) {
                callbackHandler = new Handler(Looper.getMainLooper());
            }
            callbackHandler.post(new e.b.c.b.a.a(this, this.IL1Iii, startExport, this.I1I));
        }
    }

    public static class ILil {
        public final PriorityQueue<Pair<IExportTask, Exception>> I1I = new PriorityQueue<>(10, new IL1Iii(this));
        public final AtomicBoolean IL1Iii = new AtomicBoolean(false);
        public Pair<IExportTask, Exception> ILil = null;

        public class IL1Iii implements Comparator<Pair<IExportTask, Exception>> {
            public IL1Iii(ILil iLil) {
            }

            public int compare(Object obj, Object obj2) {
                Pair pair = (Pair) obj;
                Pair pair2 = (Pair) obj2;
                int priority = ((IExportTask) pair.first).getPriority();
                int priority2 = ((IExportTask) pair2.first).getPriority();
                if (priority != priority2) {
                    return priority - priority2;
                }
                int i2 = ((((IExportTask) pair.first).getCreationTime() - ((IExportTask) pair2.first).getCreationTime()) > 0 ? 1 : ((((IExportTask) pair.first).getCreationTime() - ((IExportTask) pair2.first).getCreationTime()) == 0 ? 0 : -1));
                if (i2 > 0) {
                    return 1;
                }
                return i2 == 0 ? 0 : -1;
            }
        }

        public String toString() {
            StringBuilder a2 = e.a.a.a.a.a("ExportData{mIsExporting=");
            a2.append(this.IL1Iii);
            a2.append(", mExportTaskExporting=");
            a2.append(this.ILil);
            a2.append(", mPriorityQueue=");
            a2.append(this.I1I);
            a2.append('}');
            return a2.toString();
        }
    }

    public static ExportManager getInstance() {
        if (I1I == null) {
            I1I = new ExportManager();
        }
        return I1I;
    }

    public final void IL1Iii(String str) {
        ILil ILil2;
        Pair<IExportTask, Exception> pair;
        MediaLogger mediaLogger = ILil;
        StringBuilder sb = new StringBuilder();
        sb.append("print all tasks info (queue: ");
        sb.append(str);
        sb.append(")");
        mediaLogger.i(sb.toString());
        synchronized (this.IL1Iii) {
            ILil2 = ILil(str);
        }
        synchronized (ILil2.IL1Iii) {
            if (ILil2.IL1Iii.get()) {
                MediaLogger mediaLogger2 = ILil;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("exportNextIfAvailable(");
                sb2.append(str);
                sb2.append("), already exporting, ignored");
                mediaLogger2.i(sb2.toString());
                return;
            }
            PriorityQueue<Pair<IExportTask, Exception>> priorityQueue = ILil(str).I1I;
            synchronized (priorityQueue) {
                pair = (Pair) priorityQueue.poll();
                ILil2.ILil = pair;
            }
            if (pair == null) {
                MediaLogger mediaLogger3 = ILil;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("exportNextIfAvailable(");
                sb3.append(str);
                sb3.append("), all export tasks done!");
                mediaLogger3.i(sb3.toString());
                return;
            }
            MediaLogger mediaLogger4 = ILil;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("exportNextIfAvailable(");
            sb4.append(str);
            sb4.append("), continue export... (");
            sb4.append(((IExportTask) ILil2.ILil.first).getEventId());
            sb4.append(")");
            mediaLogger4.i(sb4.toString());
            ILil2.IL1Iii.set(true);
            new Thread(new IL1Iii(ILil2.ILil, ILil2, str)).start();
        }
    }

    public final ILil ILil(String str) {
        ILil iLil;
        synchronized (this.IL1Iii) {
            if (this.IL1Iii.get(str) == null) {
                MediaLogger mediaLogger = ILil;
                StringBuilder sb = new StringBuilder();
                sb.append("create new export queue: ");
                sb.append(str);
                mediaLogger.d(sb.toString());
                this.IL1Iii.put(str, new ILil());
            }
            iLil = (ILil) this.IL1Iii.get(str);
        }
        return iLil;
    }

    public boolean isExporting(int i2) {
        synchronized (this.IL1Iii) {
            for (Entry value : this.IL1Iii.entrySet()) {
                ILil iLil = (ILil) value.getValue();
                Pair<IExportTask, Exception> pair = iLil.ILil;
                if (pair != null && ((IExportTask) pair.first).getEventId() == i2) {
                    return true;
                }
                synchronized (iLil.I1I) {
                    Iterator it = iLil.I1I.iterator();
                    while (it.hasNext()) {
                        if (((IExportTask) ((Pair) it.next()).first).getEventId() == i2) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public void startExport(IExportTask iExportTask) {
        if (iExportTask == null) {
            ILil.e("startExport, but exportTask is null!");
        } else if (!a.a.a.a.b.a.a(iExportTask.getOriginalMediaWidth(), iExportTask.getOriginalMediaHeight())) {
            ILil.e("startExport, but GPU texture not support!");
            if (iExportTask.getExportListener() != null) {
                iExportTask.getExportListener().onError(iExportTask.getEventId(), -13020, "GPU texture not support");
            }
        } else if (isExporting(iExportTask.getEventId())) {
            ILil.w("startExport, but already exporting!");
            if (iExportTask.getExportListener() != null) {
                iExportTask.getExportListener().onError(iExportTask.getEventId(), -31000, "already exporting");
            }
        } else {
            MediaLogger mediaLogger = ILil;
            StringBuilder a2 = e.a.a.a.a.a("startExport, offer task (");
            a2.append(iExportTask.getEventId());
            a2.append(")");
            mediaLogger.i(a2.toString());
            PriorityQueue<Pair<IExportTask, Exception>> priorityQueue = ILil(iExportTask.getRunningQueueName()).I1I;
            synchronized (priorityQueue) {
                priorityQueue.offer(new Pair(iExportTask, new Exception("log export task stack")));
            }
            IL1Iii(iExportTask.getRunningQueueName());
        }
    }

    public void stopExport(int i2) {
        MediaLogger mediaLogger = ILil;
        StringBuilder sb = new StringBuilder();
        sb.append("[stopExport] eventId=");
        sb.append(i2);
        mediaLogger.i(sb.toString());
        synchronized (this.IL1Iii) {
            for (Entry value : this.IL1Iii.entrySet()) {
                ILil iLil = (ILil) value.getValue();
                Pair<IExportTask, Exception> pair = iLil.ILil;
                if (pair == null || ((IExportTask) pair.first).getEventId() != i2) {
                    boolean z = false;
                    IExportTask iExportTask = null;
                    synchronized (iLil.I1I) {
                        Iterator it = iLil.I1I.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            iExportTask = (IExportTask) ((Pair) it.next()).first;
                            if (iExportTask.getEventId() == i2) {
                                z = true;
                                MediaLogger mediaLogger2 = ILil;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("stopExport iteratorQueue.remove() eventId=");
                                sb2.append(i2);
                                mediaLogger2.i(sb2.toString());
                                it.remove();
                                break;
                            }
                        }
                    }
                    MediaLogger mediaLogger3 = ILil;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("stopExport ");
                    sb3.append(z ? "(waiting)" : "(not found)");
                    sb3.append(", eventId = ");
                    sb3.append(i2);
                    mediaLogger3.d(sb3.toString());
                    if (iExportTask != null) {
                        iExportTask.getExportListener().onCancel(iExportTask.getEventId());
                    }
                } else {
                    MediaLogger mediaLogger4 = ILil;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("stopExport (exporting) eventId=(");
                    sb4.append(i2);
                    sb4.append(")");
                    mediaLogger4.i(sb4.toString());
                    ((IExportTask) pair.first).stopExport();
                }
            }
        }
    }
}
