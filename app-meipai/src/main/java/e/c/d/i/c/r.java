package e.c.d.i.c;

import com.arashivision.sdkcamera.camera.InstaCameraManager;
import com.arashivision.sdkcamera.camera.callback.ICameraChangedCallback;
import com.arashivision.sdkmedia.stitch.StitchUtils;
import com.arashivision.sdkmedia.work.WorkWrapper;
import g.u;
import g.u.b;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SphericalCamera */
public class r {

    /* renamed from: b reason: collision with root package name */
    public static final r f6218b = new r();

    /* renamed from: a reason: collision with root package name */
    public ExecutorService f6219a = Executors.newSingleThreadExecutor();

    /* compiled from: SphericalCamera */
    public interface a<T> {
        void a(T t, int i2);
    }

    public void a() {
        InstaCameraManager.getInstance().openCamera(2);
    }

    public void b(a<List<Long>> aVar) {
        n nVar = n.f6212c;
        aVar.getClass();
        a aVar2 = new a(aVar);
        if (nVar != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("totalSpace");
            jSONArray.put("remainingSpace");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("optionNames", jSONArray);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("name", "camera.getOptions");
                jSONObject2.put("parameters", jSONObject);
                nVar.f6213a.execute(new g(nVar, "/osc/commands/execute", jSONObject2.toString(), new i(aVar2)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else {
            throw null;
        }
    }

    public /* synthetic */ void c(a aVar) {
        InstaCameraManager.getInstance().formatStorage(new o(this, aVar));
    }

    public void a(SocketFactory socketFactory) {
        n nVar = n.f6212c;
        if (nVar != null) {
            b bVar = new b(new u());
            if (socketFactory != null) {
                bVar.l = socketFactory;
                bVar.a(5, TimeUnit.SECONDS);
                nVar.f6214b = new u(bVar);
                s sVar = s.f6220b;
                b bVar2 = new b(new u());
                bVar2.l = socketFactory;
                bVar2.c(1, TimeUnit.SECONDS);
                bVar2.b(1, TimeUnit.SECONDS);
                bVar2.a(1, TimeUnit.SECONDS);
                sVar.f6221a = new u(bVar2);
                return;
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw null;
    }

    public void a(a<Boolean> aVar) {
        n nVar = n.f6212c;
        aVar.getClass();
        nVar.f6213a.execute(new f(new j(aVar)));
    }

    public void a(ICameraChangedCallback iCameraChangedCallback) {
        InstaCameraManager.getInstance().registerCameraChangedCallback(iCameraChangedCallback);
    }

    public static /* synthetic */ void a(WorkWrapper workWrapper, String str, a aVar) {
        boolean generateHDR = StitchUtils.generateHDR(workWrapper, str);
        String str2 = "";
        if (generateHDR) {
            aVar.a(str2, 0);
        } else {
            aVar.a(str2, -1);
        }
    }
}
