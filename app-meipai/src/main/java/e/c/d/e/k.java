package e.c.d.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import com.arashivision.sdkmedia.player.image.InstaImagePlayerView;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.panorama.preview.PanoramaPreviewActivity;
import d.k.e;

/* compiled from: ActivityPanoramaPreviewBinding */
public abstract class k extends ViewDataBinding {
    public final Button n;
    public final InstaImagePlayerView o;
    public final Button p;
    public PanoramaPreviewActivity q;

    public k(Object obj, View view, int i2, Button button, InstaImagePlayerView instaImagePlayerView, Button button2) {
        super(obj, view, i2);
        this.n = button;
        this.o = instaImagePlayerView;
        this.p = button2;
    }

    public static k a(LayoutInflater layoutInflater) {
        return (k) ViewDataBinding.a(layoutInflater, (int) R.layout.activity_panorama_preview, (ViewGroup) null, false, (Object) e.f5040b);
    }

    public abstract void a(PanoramaPreviewActivity panoramaPreviewActivity);
}
