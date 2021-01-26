package com.baidu.sapi2.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.mobstat.Config;
import com.baidubce.BceConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {

    /* renamed from: a reason: collision with root package name */
    public static final String[] f2836a = {"_display_name", "_size"};

    /* renamed from: b reason: collision with root package name */
    public static final String f2837b = "android.support.FILE_PROVIDER_PATHS";

    /* renamed from: c reason: collision with root package name */
    public static final String f2838c = "root-path";

    /* renamed from: d reason: collision with root package name */
    public static final String f2839d = "files-path";

    /* renamed from: e reason: collision with root package name */
    public static final String f2840e = "cache-path";

    /* renamed from: f reason: collision with root package name */
    public static final String f2841f = "external-path";

    /* renamed from: g reason: collision with root package name */
    public static final String f2842g = "name";

    /* renamed from: h reason: collision with root package name */
    public static final String f2843h = "path";

    /* renamed from: i reason: collision with root package name */
    public static final File f2844i = new File(BceConfig.BOS_DELIMITER);

    /* renamed from: j reason: collision with root package name */
    public static HashMap<String, a> f2845j = new HashMap<>();
    public a k;

    public interface a {
        File getFileForUri(Uri uri);

        Uri getUriForFile(File file);
    }

    public static class b implements a {

        /* renamed from: a reason: collision with root package name */
        public final String f2846a;

        /* renamed from: b reason: collision with root package name */
        public final HashMap<String, File> f2847b = new HashMap<>();

        public b(String str) {
            this.f2846a = str;
        }

        public void a(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f2847b.put(str, file.getCanonicalFile());
                } catch (IOException e2) {
                    throw new IllegalArgumentException(e.a.a.a.a.a("Failed to resolve canonical path for ", file), e2);
                }
            } else {
                throw new IllegalArgumentException("Name must not be empty");
            }
        }

        public File getFileForUri(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = (File) this.f2847b.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException(e.a.a.a.a.a("Failed to resolve canonical path for ", file2));
                }
            } else {
                throw new IllegalArgumentException(e.a.a.a.a.a("Unable to find configured root for ", uri));
            }
        }

        public Uri getUriForFile(File file) {
            String str;
            try {
                String canonicalPath = file.getCanonicalPath();
                Entry entry = null;
                for (Entry entry2 : this.f2847b.entrySet()) {
                    String path = ((File) entry2.getValue()).getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry != null) {
                    String path2 = ((File) entry.getValue()).getPath();
                    String str2 = BceConfig.BOS_DELIMITER;
                    if (path2.endsWith(str2)) {
                        str = canonicalPath.substring(path2.length());
                    } else {
                        str = canonicalPath.substring(path2.length() + 1);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(Uri.encode((String) entry.getKey()));
                    sb.append('/');
                    sb.append(Uri.encode(str, str2));
                    return new Builder().scheme(Config.LAUNCH_CONTENT).authority(this.f2846a).encodedPath(sb.toString()).build();
                }
                throw new IllegalArgumentException(e.a.a.a.a.a("Failed to find configured root that contains ", canonicalPath));
            } catch (IOException unused) {
                throw new IllegalArgumentException(e.a.a.a.a.a("Failed to resolve canonical path for ", file));
            }
        }
    }

    public static a a(Context context, String str) {
        a aVar;
        synchronized (f2845j) {
            aVar = (a) f2845j.get(str);
            if (aVar == null) {
                try {
                    aVar = b(context, str);
                    f2845j.put(str, aVar);
                } catch (IOException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                } catch (XmlPullParserException e3) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e3);
                }
            }
        }
        return aVar;
    }

    public static a b(Context context, String str) throws IOException, XmlPullParserException {
        b bVar = new b(str);
        XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), f2837b);
        if (loadXmlMetaData != null) {
            while (true) {
                int next = loadXmlMetaData.next();
                if (next == 1) {
                    return bVar;
                }
                if (next == 2) {
                    String name = loadXmlMetaData.getName();
                    File file = null;
                    String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                    String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                    if (f2838c.equals(name)) {
                        file = a(f2844i, attributeValue2);
                    } else if (f2839d.equals(name)) {
                        file = a(context.getFilesDir(), attributeValue2);
                    } else if (f2840e.equals(name)) {
                        file = a(context.getCacheDir(), attributeValue2);
                    } else if (f2841f.equals(name)) {
                        file = a(Environment.getExternalStorageDirectory(), attributeValue2);
                    }
                    if (file != null) {
                        bVar.a(attributeValue, file);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        return a(context, str).getUriForFile(file);
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            this.k = a(context, providerInfo.authority);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.k.getFileForUri(uri).delete() ? 1 : 0;
    }

    public String getType(Uri uri) {
        File fileForUri = this.k.getFileForUri(uri);
        int lastIndexOf = fileForUri.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.k.getFileForUri(uri), a(str));
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i2;
        File fileForUri = this.k.getFileForUri(uri);
        if (strArr == null) {
            strArr = f2836a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i3 = 0;
        for (String str3 : strArr) {
            String str4 = "_display_name";
            if (str4.equals(str3)) {
                strArr3[i3] = str4;
                i2 = i3 + 1;
                objArr[i3] = fileForUri.getName();
            } else {
                String str5 = "_size";
                if (str5.equals(str3)) {
                    strArr3[i3] = str5;
                    i2 = i3 + 1;
                    objArr[i3] = Long.valueOf(fileForUri.length());
                }
            }
            i3 = i2;
        }
        String[] a2 = a(strArr3, i3);
        Object[] a3 = a(objArr, i3);
        MatrixCursor matrixCursor = new MatrixCursor(a2, 1);
        matrixCursor.addRow(a3);
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public static int a(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if (Config.DEVICE_WIDTH.equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException(e.a.a.a.a.a("Invalid mode: ", str));
    }

    public static File a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    public static String[] a(String[] strArr, int i2) {
        String[] strArr2 = new String[i2];
        System.arraycopy(strArr, 0, strArr2, 0, i2);
        return strArr2;
    }

    public static Object[] a(Object[] objArr, int i2) {
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, i2);
        return objArr2;
    }
}
