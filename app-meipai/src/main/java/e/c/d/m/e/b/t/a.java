package e.c.d.m.e.b.t;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.picapture.R;
import com.baidu.picapture.model.hotspot.HotSpot;
import com.baidubce.BceConfig;
import com.makeramen.roundedimageview.RoundedImageView;
import e.c.b.e.Utils;
import e.c.d.n.e;
import e.d.a.n.p.c.l;
import java.io.File;
import java.util.List;

/* compiled from: SpinDetailHotSpotAdapter */
public class a extends BaseAdapter {

    /* renamed from: a reason: collision with root package name */
    public List<HotSpot> f6729a;

    /* renamed from: b reason: collision with root package name */
    public Context f6730b;

    /* renamed from: c reason: collision with root package name */
    public String f6731c;

    /* renamed from: d reason: collision with root package name */
    public int f6732d;

    /* compiled from: SpinDetailHotSpotAdapter */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public RoundedImageView f6733a;

        /* renamed from: b reason: collision with root package name */
        public ImageView f6734b;

        public b() {
        }

        public /* synthetic */ b(C0069a aVar) {
        }
    }

    public a(Context context, List<HotSpot> list, String str) {
        this.f6730b = context;
        this.f6729a = list;
        this.f6731c = str;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f6730b).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        this.f6732d = i2;
        this.f6732d = i2 - Utils.b(48.0f);
    }

    public int getCount() {
        return this.f6729a.size();
    }

    public Object getItem(int i2) {
        List<HotSpot> list = this.f6729a;
        if (list == null || i2 >= list.size()) {
            return null;
        }
        return this.f6729a.get(i2);
    }

    public long getItemId(int i2) {
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        boolean z = false;
        if (i2 == 0) {
            if (view == null) {
                view = LayoutInflater.from(this.f6730b).inflate(R.layout.item_hot_spot_capture, viewGroup, false);
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_item_hot_spot_capture);
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_hot_spot_capture);
                if (this.f6729a.size() != 11) {
                    z = true;
                }
                imageView.setEnabled(z);
                LayoutParams layoutParams = relativeLayout.getLayoutParams();
                int i3 = this.f6732d / 3;
                layoutParams.height = i3;
                layoutParams.width = i3;
                view.setLayoutParams(layoutParams);
            }
            return view;
        }
        if (view == null) {
            bVar = new b(null);
            view2 = LayoutInflater.from(this.f6730b).inflate(R.layout.item_hot_spot, viewGroup, false);
            bVar.f6733a = (RoundedImageView) view2.findViewById(R.id.iv_item_hot_spot);
            bVar.f6734b = (ImageView) view2.findViewById(R.id.iv_item_hot_spot_txt);
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(e.j(this.f6731c));
        sb.append(BceConfig.BOS_DELIMITER);
        sb.append(((HotSpot) this.f6729a.get(i2)).getImg());
        ((e.d.a.i) e.d.a.b.c(this.f6730b).a(new File(sb.toString())).b(l.f7687c, (e.d.a.n.l<Bitmap>) new e.d.a.n.p.c.i<Bitmap>())).a((ImageView) bVar.f6733a);
        String str = "";
        if (!((HotSpot) this.f6729a.get(i2)).getTitle().trim().equals(str) || !((HotSpot) this.f6729a.get(i2)).getDescribe().trim().equals(str)) {
            bVar.f6734b.setVisibility(0);
        } else {
            bVar.f6734b.setVisibility(4);
        }
        LayoutParams layoutParams2 = ((RelativeLayout) view2.findViewById(R.id.rl_item_hot_spot)).getLayoutParams();
        int i4 = this.f6732d / 3;
        layoutParams2.height = i4;
        layoutParams2.width = i4;
        view2.setLayoutParams(layoutParams2);
        return view2;
    }
}
