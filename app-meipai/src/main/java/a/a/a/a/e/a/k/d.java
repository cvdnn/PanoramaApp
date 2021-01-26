package a.a.a.a.e.a.k;

import a.a.a.a.a.f.b;
import com.arashivision.graphicpath.render.source.Asset;
import com.arashivision.insta360.basemedia.asset.AssetUtils;
import com.arashivision.insta360.basemedia.ui.player.image.SimpleImageParams;

public class d implements b {

    /* renamed from: a reason: collision with root package name */
    public boolean f639a = false;

    /* renamed from: b reason: collision with root package name */
    public boolean f640b = false;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ SimpleImageParams f641c;

    public d(SimpleImageParams simpleImageParams) {
        this.f641c = simpleImageParams;
    }

    public void a(Asset asset) {
        if (this.f639a) {
            AssetUtils.setSelfie(asset, this.f640b);
        }
    }

    public void b(Asset asset) {
        this.f639a = true;
        this.f640b = AssetUtils.isSelfie(asset);
        AssetUtils.setSelfie(asset, this.f641c.isSelfie());
    }
}
