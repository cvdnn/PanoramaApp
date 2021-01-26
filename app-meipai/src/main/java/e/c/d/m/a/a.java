package e.c.d.m.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.picapture.model.device.LanguageUtils;
import d.b.k.d;
import d.w.a;

/* compiled from: BaseActivity */
public abstract class a<B extends d.w.a> extends d {
    public B r;

    public void a(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(LanguageUtils.attachBaseContext(context));
    }

    public abstract B f0();

    public abstract void g0();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LanguageUtils.initContextSettingLanguage(this);
        B f0 = f0();
        this.r = f0;
        setContentView(f0.a());
        g0();
    }
}
