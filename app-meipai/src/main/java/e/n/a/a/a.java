package e.n.a.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.youth.banner.adapter.BannerAdapter;

/* compiled from: lambda */
public final /* synthetic */ class a implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ BannerAdapter f8996a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ int f8997b;

    public /* synthetic */ a(BannerAdapter bannerAdapter, int i2) {
        this.f8996a = bannerAdapter;
        this.f8997b = i2;
    }

    public final void onClick(View view) {
        this.f8996a.a(this.f8997b, view);
    }
}
