package com.yanzhenjie.permission;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
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
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {

    /* renamed from: b reason: collision with root package name */
    public static final String[] f3969b = {"_display_name", "_size"};

    /* renamed from: c reason: collision with root package name */
    public static final File f3970c = new File(BceConfig.BOS_DELIMITER);

    /* renamed from: d reason: collision with root package name */
    public static final HashMap<String, a> f3971d = new HashMap<>();

    /* renamed from: a reason: collision with root package name */
    public a f3972a;

    public interface a {
        File getFileForUri(Uri uri);
    }

    public static class b implements a {

        /* renamed from: a reason: collision with root package name */
        public final HashMap<String, File> f3973a = new HashMap<>();

        public b(String str) {
        }

        public File getFileForUri(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = (File) this.f3973a.get(decode);
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
    }

    public static a a(Context context, String str) {
        a aVar;
        synchronized (f3971d) {
            aVar = (a) f3971d.get(str);
            if (aVar == null) {
                try {
                    aVar = b(context, str);
                    f3971d.put(str, aVar);
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
        XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), com.baidu.sapi2.provider.FileProvider.f2837b);
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
                    if (com.baidu.sapi2.provider.FileProvider.f2838c.equals(name)) {
                        file = f3970c;
                    } else if (com.baidu.sapi2.provider.FileProvider.f2839d.equals(name)) {
                        file = context.getFilesDir();
                    } else if (com.baidu.sapi2.provider.FileProvider.f2840e.equals(name)) {
                        file = context.getCacheDir();
                    } else if (com.baidu.sapi2.provider.FileProvider.f2841f.equals(name)) {
                        file = Environment.getExternalStorageDirectory();
                    } else if ("external-files-path".equals(name)) {
                        File[] externalFilesDirs = context.getExternalFilesDirs(null);
                        if (externalFilesDirs.length > 0) {
                            file = externalFilesDirs[0];
                        }
                    } else if ("external-cache-path".equals(name)) {
                        File[] externalCacheDirs = context.getExternalCacheDirs();
                        if (externalCacheDirs.length > 0) {
                            file = externalCacheDirs[0];
                        }
                    } else if ("external-media-path".equals(name)) {
                        File[] externalMediaDirs = context.getExternalMediaDirs();
                        if (externalMediaDirs.length > 0) {
                            file = externalMediaDirs[0];
                        }
                    }
                    if (file != null) {
                        String[] strArr = {attributeValue2};
                        for (int i2 = 0; i2 < 1; i2++) {
                            String str2 = strArr[i2];
                            if (str2 != null) {
                                file = new File(file, str2);
                            }
                        }
                        if (!TextUtils.isEmpty(attributeValue)) {
                            try {
                                bVar.f3973a.put(attributeValue, file.getCanonicalFile());
                            } catch (IOException e2) {
                                throw new IllegalArgumentException(e.a.a.a.a.a("Failed to resolve canonical path for ", file), e2);
                            }
                        } else {
                            throw new IllegalArgumentException("Name must not be empty");
                        }
                    } else {
                        continue;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            this.f3972a = a(context, providerInfo.authority);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.f3972a.getFileForUri(uri).delete() ? 1 : 0;
    }

    public String getType(Uri uri) {
        File fileForUri = this.f3972a.getFileForUri(uri);
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
        int i2;
        File fileForUri = this.f3972a.getFileForUri(uri);
        if ("r".equals(str)) {
            i2 = 268435456;
        } else if (Config.DEVICE_WIDTH.equals(str) || "wt".equals(str)) {
            i2 = 738197504;
        } else if ("wa".equals(str)) {
            i2 = 704643072;
        } else if ("rw".equals(str)) {
            i2 = 939524096;
        } else if ("rwt".equals(str)) {
            i2 = 1006632960;
        } else {
            throw new IllegalArgumentException(e.a.a.a.a.a("Invalid mode: ", str));
        }
        return ParcelFileDescriptor.open(fileForUri, i2);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i2;
        File fileForUri = this.f3972a.getFileForUri(uri);
        if (strArr == null) {
            strArr = f3969b;
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
        String[] strArr4 = new String[i3];
        System.arraycopy(strArr3, 0, strArr4, 0, i3);
        Object[] objArr2 = new Object[i3];
        System.arraycopy(objArr, 0, objArr2, 0, i3);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
