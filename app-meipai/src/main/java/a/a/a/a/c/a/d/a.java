package a.a.a.a.c.a.d;

import com.arashivision.insta360.basemedia.export.task.single.VideoToVideoTask;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import java.util.Arrays;

public class a implements a.a.a.a.a.e.a {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ VideoToVideoTask f433a;

    public a(VideoToVideoTask videoToVideoTask) {
        this.f433a = videoToVideoTask;
    }

    public void IL1Iii(long j2, long j3) {
        MediaLogger mediaLogger = VideoToVideoTask.LlLI1;
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(this.f433a.f20il.getUrlsForPlay()));
        sb.append(" onStabilizerLoadProgress: ");
        sb.append(j2);
        sb.append(" / ");
        sb.append(j3);
        mediaLogger.d(sb.toString());
    }
}
