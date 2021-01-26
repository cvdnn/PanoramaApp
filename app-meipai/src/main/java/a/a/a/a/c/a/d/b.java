package a.a.a.a.c.a.d;

import a.a.a.a.a.e.a;
import com.arashivision.insta360.basemedia.export.task.single.ImageToImageTask;
import com.arashivision.insta360.basemedia.log.MediaLogger;

public class b implements a {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ImageToImageTask f434a;

    public b(ImageToImageTask imageToImageTask) {
        this.f434a = imageToImageTask;
    }

    public void IL1Iii(long j2, long j3) {
        MediaLogger mediaLogger = ImageToImageTask.Lil;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f434a.f5il.getUrlsForPlay());
        sb.append(" onStabilizerLoadProgress: ");
        sb.append(j2);
        sb.append(" / ");
        sb.append(j3);
        mediaLogger.d(sb.toString());
    }
}
