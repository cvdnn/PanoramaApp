package a.a.a.a.c.a.d;

import a.a.a.a.a.e.a;
import com.arashivision.insta360.basemedia.export.task.single.VideoToImageTask;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import java.util.Arrays;

public class c implements a {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ VideoToImageTask f435a;

    public c(VideoToImageTask videoToImageTask) {
        this.f435a = videoToImageTask;
    }

    public void IL1Iii(long j2, long j3) {
        MediaLogger mediaLogger = VideoToImageTask.Lil;
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(this.f435a.f15il.getUrlsForPlay()));
        sb.append(" onStabilizerLoadProgress: ");
        sb.append(j2);
        sb.append(" / ");
        sb.append(j3);
        mediaLogger.d(sb.toString());
    }
}
