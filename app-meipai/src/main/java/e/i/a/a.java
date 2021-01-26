package e.i.a;

import e.i.a.h.d.c;
import e.i.a.h.e.b;
import java.util.List;
import java.util.Map;

/* compiled from: DownloadListener */
public interface a {
    void connectEnd(c cVar, int i2, int i3, Map<String, List<String>> map);

    void connectStart(c cVar, int i2, Map<String, List<String>> map);

    void connectTrialEnd(c cVar, int i2, Map<String, List<String>> map);

    void connectTrialStart(c cVar, Map<String, List<String>> map);

    void downloadFromBeginning(c cVar, c cVar2, b bVar);

    void downloadFromBreakpoint(c cVar, c cVar2);

    void fetchEnd(c cVar, int i2, long j2);

    void fetchProgress(c cVar, int i2, long j2);

    void fetchStart(c cVar, int i2, long j2);

    void taskEnd(c cVar, e.i.a.h.e.a aVar, Exception exc);

    void taskStart(c cVar);
}
