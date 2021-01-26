package d.b.o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;
import d.b.i;

/* compiled from: ContextThemeWrapper */
public class c extends ContextWrapper {

    /* renamed from: a reason: collision with root package name */
    public int f4096a;

    /* renamed from: b reason: collision with root package name */
    public Theme f4097b;

    /* renamed from: c reason: collision with root package name */
    public LayoutInflater f4098c;

    /* renamed from: d reason: collision with root package name */
    public Resources f4099d;

    public c() {
        super(null);
    }

    public final void a() {
        if (this.f4097b == null) {
            this.f4097b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f4097b.setTo(theme);
            }
        }
        this.f4097b.applyStyle(this.f4096a, true);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        if (this.f4099d == null) {
            this.f4099d = super.getResources();
        }
        return this.f4099d;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f4098c == null) {
            this.f4098c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f4098c;
    }

    public Theme getTheme() {
        Theme theme = this.f4097b;
        if (theme != null) {
            return theme;
        }
        if (this.f4096a == 0) {
            this.f4096a = i.Theme_AppCompat_Light;
        }
        a();
        return this.f4097b;
    }

    public void setTheme(int i2) {
        if (this.f4096a != i2) {
            this.f4096a = i2;
            a();
        }
    }

    public c(Context context, int i2) {
        super(context);
        this.f4096a = i2;
    }

    public c(Context context, Theme theme) {
        super(context);
        this.f4097b = theme;
    }
}
