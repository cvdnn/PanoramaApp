package a.a.a.a.c.a.a.a;

import a.a.a.a.c.a.c;
import a.a.a.a.e.a.l.h;
import android.os.Handler;
import com.arashivision.arvbmg.exporter.FrameExporter;
import com.arashivision.insta360.basemedia.export.IExportListener;
import com.arashivision.insta360.basemedia.export.IExportTask;
import com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.ui.player.video.IVideoParams;

public class a implements IExportTask {

    /* renamed from: a reason: collision with root package name */
    public FrameExporter f428a;

    /* renamed from: b reason: collision with root package name */
    public boolean f429b;

    static {
        MediaLogger.getLogger(a.class);
    }

    public Handler getCallbackHandler() {
        return null;
    }

    public long getCreationTime() {
        return 0;
    }

    public int getEventId() {
        return 0;
    }

    public int getExportHeight() {
        return 0;
    }

    public IExportListener getExportListener() {
        return null;
    }

    public int getExportWidth() {
        return 0;
    }

    public int getOriginalMediaHeight() {
        throw null;
    }

    public int getOriginalMediaWidth() {
        throw null;
    }

    public int getPriority() {
        return 500;
    }

    public String getRunningQueueName() {
        return IExportTask.QUEUE_BACKGROUND;
    }

    public String logInfo() {
        throw null;
    }

    public IL1Iii startExport() {
        IL1Iii iL1Iii;
        if (this.f428a == null) {
            int a2 = !this.f429b ? h.a((IVideoParams) null, a.class.getSimpleName(), -31012) : 0;
            if (!this.f429b && a2 == 0) {
                throw null;
            } else if (!this.f429b && a2 == 0) {
                throw null;
            } else if (this.f429b || a2 != 0) {
                if (this.f429b) {
                    a2 = -31010;
                }
                if (a2 != 0) {
                    c cVar = a2 == -31010 ? new c(null, new IL1Iii(1, 0, null)) : new c(null, new IL1Iii(0, a2, "load extra info failed!"));
                    synchronized (this) {
                        if (cVar.f432b != null) {
                            iL1Iii = cVar.f432b;
                        } else {
                            this.f428a = (FrameExporter) cVar.f431a;
                            throw null;
                        }
                    }
                    return iL1Iii;
                }
                throw null;
            } else {
                throw null;
            }
        } else {
            throw null;
        }
    }

    public void stopExport() {
        this.f429b = true;
        throw null;
    }
}
