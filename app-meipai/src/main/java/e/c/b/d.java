package e.c.b;

import e.a.a.a.a;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

public final class d {
    public static boolean A = true;
    public static boolean B = true;
    public static boolean C = true;
    public static int D = 1;
    public static boolean E = false;
    public static boolean F = false;
    public static String G = "https://crab.baidu.com/";
    public static b H = null;
    public static c I = null;
    public static String J = null;
    public static String K = null;

    /* renamed from: a reason: collision with root package name */
    public static String f5877a = "";

    /* renamed from: b reason: collision with root package name */
    public static String f5878b = "alpha";

    /* renamed from: c reason: collision with root package name */
    public static String f5879c = null;

    /* renamed from: d reason: collision with root package name */
    public static String f5880d = "UNSET";

    /* renamed from: e reason: collision with root package name */
    public static int f5881e = 10;

    /* renamed from: f reason: collision with root package name */
    public static int f5882f = 5;

    /* renamed from: g reason: collision with root package name */
    public static int f5883g = 10;

    /* renamed from: h reason: collision with root package name */
    public static int f5884h = 200;

    /* renamed from: i reason: collision with root package name */
    public static boolean f5885i = true;

    /* renamed from: j reason: collision with root package name */
    public static long f5886j = 30000;
    public static boolean k = false;
    public static boolean l = false;
    public static String m = "";
    public static boolean n = false;
    public static boolean o = true;
    public static boolean p = false;
    public static int q = 10;
    public static int r = 30;
    public static int s = 10;
    public static HashMap<String, Integer> t = new HashMap<>();
    public static int u = 0;
    public static int v = -1;
    public static int w = 0;
    public static final SimpleDateFormat x = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
    public static boolean y = false;
    public static boolean z = true;

    static {
        String str = "http://yq01-crab-offline01.epc.baidu.com:8123/api/add_crab";
        J = str;
        K = str;
    }

    public static String a() {
        return z ? a.a(new StringBuilder(), G, "api_anr/add_crab") : K;
    }

    public static String b() {
        return z ? a.a(new StringBuilder(), G, "api/newsync2") : "http://yq01-crab-offline01.epc.baidu.com:8123/api/newsync2";
    }
}
