package e.c.d.i.c;

import android.text.TextUtils;
import com.baidu.picapture.hardware.panorama.beans.OSCOptions;
import com.baidu.picapture.hardware.panorama.beans.OSCState;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.tencent.connect.common.Constants;
import e.g.b.j;
import g.a0;
import g.t;
import g.u;
import g.y;
import g.z;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OSCPoster */
public class n {

    /* renamed from: c reason: collision with root package name */
    public static final n f6212c = new n();

    /* renamed from: a reason: collision with root package name */
    public ExecutorService f6213a = Executors.newSingleThreadExecutor();

    /* renamed from: b reason: collision with root package name */
    public u f6214b;

    /* compiled from: OSCPoster */
    public interface a<T> {
        void a(T t, int i2);
    }

    public static /* synthetic */ void b(a aVar, String str, int i2) {
        if (i2 != 0) {
            aVar.a(null, i2);
        } else {
            aVar.a((OSCState) new j().a(str, OSCState.class), i2);
        }
    }

    public static /* synthetic */ void c(a aVar, String str, int i2) {
        if (i2 != 0) {
            aVar.a(null, i2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("results").getJSONObject("options");
            long j2 = jSONObject.getLong("totalSpace");
            long j3 = jSONObject.getLong("remainingSpace");
            arrayList.add(Long.valueOf(j2));
            arrayList.add(Long.valueOf(j3));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        aVar.a(arrayList, i2);
    }

    public /* synthetic */ void a(String str, String str2, a aVar) {
        String a2 = a(str, str2);
        if (TextUtils.isEmpty(a2)) {
            aVar.a(null, -1);
        } else {
            aVar.a(a2, 0);
        }
    }

    public final String a(String str, String str2) {
        String str3 = "application/json";
        y create = y.create(t.a(str3), str2);
        g.x.a aVar = new g.x.a();
        StringBuilder sb = new StringBuilder();
        sb.append("http://192.168.42.1");
        sb.append(str);
        aVar.a(sb.toString());
        aVar.a(Constants.HTTP_POST, create);
        aVar.a("Content-Type", str3);
        aVar.a("Accept", str3);
        aVar.a("X-XSRF-Protected", "1");
        try {
            z d2 = this.f6214b.a(aVar.a()).d();
            a0 a0Var = d2.f9620g;
            String string = a0Var != null ? a0Var.string() : null;
            if (d2.f9616c != 200 || string == null) {
                return null;
            }
            return string;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ void a(a aVar, String str, int i2) {
        Object obj = null;
        if (i2 != 0) {
            aVar.a(null, i2);
            return;
        }
        try {
            obj = (OSCOptions) new j().a(new JSONObject(str).getJSONObject("results").getJSONObject("options").toString(), OSCOptions.class);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        aVar.a(obj, i2);
    }

    public /* synthetic */ void a(Map map, a aVar, boolean z) {
        CharSequence charSequence;
        String str = "/osc/commands/execute";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("captureMode", "image");
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("options", jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("name", "camera.setOptions");
            jSONObject3.put("parameters", jSONObject2);
            charSequence = a(str, jSONObject3.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
            charSequence = null;
        }
        if (TextUtils.isEmpty(charSequence)) {
            aVar.a(null, -100);
            return;
        }
        String a2 = a(str, "{\"name\":\"camera.takePicture\"}");
        if (TextUtils.isEmpty(a2)) {
            aVar.a(null, -101);
            return;
        }
        try {
            String string = new JSONObject(a2).getString("id");
            int i2 = 0;
            while (i2 < 60) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("{\"id\":\"");
                sb.append(string);
                sb.append("\"}");
                String a3 = a("/osc/commands/status", sb.toString());
                if (TextUtils.isEmpty(a3)) {
                    aVar.a(null, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                    return;
                }
                try {
                    JSONObject jSONObject4 = new JSONObject(a3);
                    if ("done".equals(jSONObject4.get(WXLoginActivity.KEY_BASE_RESP_STATE))) {
                        JSONObject jSONObject5 = jSONObject4.getJSONObject("results");
                        ArrayList arrayList = new ArrayList();
                        if (z) {
                            JSONArray jSONArray = jSONObject5.getJSONArray("_fileGroup");
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                arrayList.add(jSONArray.getString(i3));
                            }
                        } else {
                            arrayList.add(jSONObject5.getString("fileUrl"));
                        }
                        aVar.a(arrayList, 0);
                        return;
                    }
                    i2++;
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    aVar.a(null, -2);
                    return;
                }
            }
            aVar.a(null, -101);
        } catch (JSONException e5) {
            e5.printStackTrace();
            aVar.a(null, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
        }
    }
}
