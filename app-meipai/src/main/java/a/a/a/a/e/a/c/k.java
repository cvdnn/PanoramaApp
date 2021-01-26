package a.a.a.a.e.a.c;

import a.a.a.a.a.f.b;
import com.arashivision.graphicpath.render.source.Asset;
import com.arashivision.insta360.basemedia.asset.AssetUtils;
import com.arashivision.insta360.basemedia.ui.player.video.SimpleVideoParams;

public class k implements b {

    /* renamed from: a reason: collision with root package name */
    public boolean f482a = false;

    /* renamed from: b reason: collision with root package name */
    public boolean f483b = false;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ SimpleVideoParams f484c;

    public k(SimpleVideoParams simpleVideoParams) {
        this.f484c = simpleVideoParams;
    }

    public void a(Asset asset) {
        if (this.f482a) {
            AssetUtils.setSelfie(asset, this.f483b);
        }
    }

    public void b(Asset asset) {
        this.f482a = true;
        this.f483b = AssetUtils.isSelfie(asset);
        AssetUtils.setSelfie(asset, this.f484c.isSelfie());
    }
}
