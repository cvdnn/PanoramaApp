package e.c.d.m.d.b.l;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.recyclerview.widget.RecyclerView.d0;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;

/* compiled from: ImageAdapter */
public class a extends BannerAdapter<Integer, C0068a> {

    /* renamed from: e.c.d.m.d.b.l.a$a reason: collision with other inner class name */
    /* compiled from: ImageAdapter */
    public static class C0068a extends d0 {

        /* renamed from: a reason: collision with root package name */
        public ImageView f6650a;

        public C0068a(ImageView imageView) {
            super(imageView);
            this.f6650a = imageView;
        }
    }

    public a(List<Integer> list) {
        super(list);
    }

    public void onBindView(Object obj, Object obj2, int i2, int i3) {
        ((C0068a) obj).f6650a.setImageResource(((Integer) obj2).intValue());
    }

    public Object onCreateHolder(ViewGroup viewGroup, int i2) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new LayoutParams(-1, -1));
        imageView.setScaleType(ScaleType.FIT_CENTER);
        return new C0068a(imageView);
    }
}
