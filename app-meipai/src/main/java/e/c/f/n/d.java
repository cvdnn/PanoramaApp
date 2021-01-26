package e.c.f.n;

import android.annotation.SuppressLint;
import android.content.Context;
import com.arashivision.insbase.arlog.MultipartUtility;
import com.baidu.mobstat.Config;
import com.baidu.sofire.core.ApkInfo;
import e.c.f.c;
import e.c.f.f.g;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ExceptionUtil */
public final class d {

    /* renamed from: a reason: collision with root package name */
    public static final String[] f7050a = {"java.lang.UnsatisfiedLinkError"};

    /* renamed from: b reason: collision with root package name */
    public static final String[] f7051b = {"space left"};

    public static String a(Context context, String str, String str2) {
        String[] split;
        File[] listFiles;
        String str3 = Config.TRACE_TODAY_VISIT_SPLIT;
        try {
            boolean z = str.contains(f7050a[0]) ? true : str.contains(f7051b[0]) ? true : false;
            if (z) {
                ApkInfo c2 = g.f6978g.c(str2);
                String str4 = c2.libPath;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("\r\n{libpath=");
                sb.append(c2.libPath);
                sb.append("}");
                String sb2 = sb.toString();
                for (String str5 : str4.split(str3)) {
                    if (str5.startsWith("/data/data/")) {
                        File file = new File(str5);
                        String str6 = "\r\nsubLibPathFile ";
                        if (!file.exists()) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(sb2);
                            sb3.append(str6);
                            sb3.append(str5);
                            sb3.append(" not exists");
                            sb2 = sb3.toString();
                        } else if (!file.isDirectory()) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(sb2);
                            sb4.append(str6);
                            sb4.append(str5);
                            sb4.append(" not a dir");
                            sb2 = sb4.toString();
                        } else {
                            for (File file2 : file.listFiles()) {
                                String a2 = h.a(file2);
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(sb2);
                                sb5.append("\r\n{");
                                sb5.append(file2.getAbsolutePath());
                                sb5.append(str3);
                                sb5.append(a2);
                                sb5.append("}\r\n");
                                sb2 = sb5.toString();
                            }
                        }
                    }
                }
                str = sb2;
            } else if (z) {
                str = a(context, str);
            }
            return str;
        } catch (Throwable unused) {
            c.d();
            return str;
        }
    }

    @SuppressLint({"NewApi"})
    public static String a(Context context, String str) {
        File[] listFiles;
        try {
            File filesDir = context.getFilesDir();
            long freeSpace = filesDir.getFreeSpace();
            long totalSpace = filesDir.getTotalSpace();
            long usableSpace = filesDir.getUsableSpace();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("\r\nFreeSpace=");
            sb.append(freeSpace);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append("  TotalSpace=");
            sb3.append(totalSpace);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append("  UsableSpace=");
            sb5.append(usableSpace);
            String sb6 = sb5.toString();
            JSONArray jSONArray = new JSONArray();
            long j2 = 0;
            for (File file : filesDir.listFiles()) {
                if (file.isDirectory() && file.getName().startsWith(".")) {
                    j2 += a(file, jSONArray);
                }
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            sb7.append(MultipartUtility.CTRLF);
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(sb8);
            sb9.append(jSONArray.toString());
            String sb10 = sb9.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(sb10);
            sb11.append("\r\nAllFileSize=");
            sb11.append(j2);
            return sb11.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static long a(File file, JSONArray jSONArray) throws JSONException {
        File[] listFiles;
        long length;
        long j2 = 0;
        if (!(file == null || jSONArray == null || !file.isDirectory())) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    length = a(file2, jSONArray);
                } else if (file2.exists()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("path", file2.getAbsolutePath());
                    jSONObject.put("size", file2.length());
                    jSONArray.put(jSONObject);
                    length = file2.length();
                }
                j2 = length + j2;
            }
        }
        return j2;
    }
}
