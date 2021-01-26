package j.a.a.a;

import com.arashivision.insta360.basecamera.log.CameraLogger;

public class a {

    /* renamed from: a reason: collision with root package name */
    public static CameraLogger f9912a = CameraLogger.getLogger(a.class);

    public static int a(String str, String str2) {
        boolean z = false;
        if (!(str != null && str.length() > 0)) {
            f9912a.d("newVersion invalid");
            return -1;
        }
        if (str2 != null && str2.length() > 0) {
            z = true;
        }
        if (!z) {
            f9912a.d("oldVersion invalid");
            return 1;
        }
        b bVar = new b();
        bVar.f9913a = 3;
        return bVar.compare(str, str2);
    }
}
