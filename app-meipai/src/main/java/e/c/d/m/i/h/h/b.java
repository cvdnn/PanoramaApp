package e.c.d.m.i.h.h;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.picapture.App;
import com.baidu.picapture.ui.widget.bdwebview.bean.Router;
import com.baidubce.BceConfig;
import e.g.b.j;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/* compiled from: BaseIntercept */
public class b implements d {

    /* renamed from: a reason: collision with root package name */
    public Router f6819a;

    public b() {
        try {
            InputStream open = App.f1954b.getAssets().open("webcache/router.json");
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                bufferedReader.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String sb2 = sb.toString();
            open.close();
            this.f6819a = (Router) new j().a(sb2, Router.class);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public String a(Map<String, String> map) {
        String str = (String) map.get("Accept");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(",");
        if (indexOf > -1) {
            str = str.substring(0, indexOf);
        }
        return str;
    }

    public boolean a(Uri uri) {
        if (TextUtils.isEmpty(uri.getHost()) || TextUtils.isEmpty(uri.getPath())) {
            return false;
        }
        if (!uri.getHost().equalsIgnoreCase(Uri.parse(this.f6819a.getHost()).getHost())) {
            return false;
        }
        return uri.toString().startsWith(a());
    }

    public String a(String str) {
        String str2;
        int indexOf = str.indexOf(63);
        int length = a().length();
        if (indexOf <= 0 || str.length() <= length) {
            str2 = str.substring(length);
        } else {
            str2 = str.substring(length, indexOf);
        }
        return (!str2.startsWith(BceConfig.BOS_DELIMITER) || str2.length() < 2) ? str2 : str2.substring(1);
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6819a.getHost());
        sb.append(this.f6819a.getPrefix());
        return sb.toString();
    }
}
