package e.c.a.a.b;

import android.os.Environment;
import android.text.TextUtils;
import e.c.a.a.a.a;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ e.c.a.a.b.b.c f5872a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ b f5873b;

    public c(b bVar, e.c.a.a.b.b.c cVar) {
        this.f5873b = bVar;
        this.f5872a = cVar;
    }

    public void run() {
        String str;
        File file;
        e.c.a.a.b.b.c cVar = this.f5872a;
        String str2 = cVar.f5869b;
        String str3 = cVar.f5868a;
        File file2 = new File(this.f5873b.f5861a.getFilesDir(), "libcuid.so");
        try {
            str = new JSONObject().put(b.d("ZGV2aWNlaWQ="), str3).put(b.d("aW1laQ=="), str2).put(b.d("dmVy"), 2).toString();
        } catch (JSONException unused) {
            str = null;
        }
        String e2 = b.e(str);
        if (!file2.exists()) {
            b.a(this.f5873b, e2);
        } else {
            e.c.a.a.b.b.c a2 = e.c.a.a.b.b.c.a(b.f(b.a(file2)));
            if (a2 != null) {
                if (this.f5873b.a(a2)) {
                    b.a(this.f5873b, b.e(a2.a()));
                }
            } else if (a2 == null) {
                b.a(this.f5873b, e2);
            }
        }
        boolean a3 = this.f5873b.a("android.permission.WRITE_SETTINGS");
        if (a3) {
            String str4 = "com.baidu.deviceid.v2";
            String b2 = this.f5873b.b(str4);
            if (TextUtils.isEmpty(b2)) {
                b.a(this.f5873b, str4, e2);
            } else {
                e.c.a.a.b.b.c a4 = e.c.a.a.b.b.c.a(b.f(b2));
                if (a4 != null) {
                    if (this.f5873b.a(a4)) {
                        b.a(this.f5873b, str4, b.e(a4.a()));
                    }
                } else if (a4 == null) {
                    b.a(this.f5873b, str4, e2);
                }
            }
        }
        boolean a5 = this.f5873b.a("android.permission.WRITE_EXTERNAL_STORAGE");
        if (a5) {
            if (!new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2").exists()) {
                b.c(e2);
            } else {
                e.c.a.a.b.b.c b3 = this.f5873b.b();
                if (b3 != null) {
                    if (this.f5873b.a(b3)) {
                        b.c(b.e(b3.a()));
                    }
                } else if (b3 == null) {
                    b.c(e2);
                }
            }
        }
        if (a3) {
            String str5 = "bd_setting_i";
            String b4 = this.f5873b.b(str5);
            if ((TextUtils.isEmpty(b4) ? 0 : b4.length()) >= 14) {
                b.a(this.f5873b, str5, "O");
            } else if (TextUtils.isEmpty(b4)) {
                b.a(this.f5873b, str5, "0");
            }
        }
        if (a5 && new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid").exists()) {
            b bVar = this.f5873b;
            if (bVar != null) {
                e.c.a.a.b.b.c c2 = bVar.c();
                if (c2 != null && this.f5873b.a(c2)) {
                    String str6 = c2.f5869b;
                    String str7 = c2.f5868a;
                    if (!TextUtils.isEmpty(str6)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str6);
                        sb.append("=");
                        sb.append(str7);
                        File file3 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
                        File file4 = new File(file3, ".cuid");
                        try {
                            if (file3.exists() && !file3.isDirectory()) {
                                Random random = new Random();
                                File parentFile = file3.getParentFile();
                                String name = file3.getName();
                                do {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(name);
                                    sb2.append(random.nextInt());
                                    sb2.append(".tmp");
                                    file = new File(parentFile, sb2.toString());
                                } while (file.exists());
                                file3.renameTo(file);
                                file.delete();
                            }
                            file3.mkdirs();
                            FileWriter fileWriter = new FileWriter(file4, false);
                            fileWriter.write(a.a(a.a.a.a.b.a.b(b.f5859d, b.f5859d, sb.toString().getBytes()), "utf-8"));
                            fileWriter.flush();
                            fileWriter.close();
                        } catch (IOException | Exception unused2) {
                        }
                    }
                }
            } else {
                throw null;
            }
        }
    }
}
