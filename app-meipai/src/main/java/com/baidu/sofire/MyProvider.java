package com.baidu.sofire;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import e.c.f.f.e;
import e.c.f.n.c;

public class MyProvider extends ContentProvider {
    public Bundle call(String str, String str2, Bundle bundle) {
        try {
            String callingPackage = getCallingPackage();
            if (callingPackage != null && !callingPackage.equals(getContext().getPackageName())) {
                return null;
            }
            if (!"getRemoteZid".equals(str)) {
                return e.a(getContext().getApplicationContext(), str, bundle);
            }
            String b2 = c.b(getContext());
            Bundle bundle2 = new Bundle();
            if (!TextUtils.isEmpty(b2)) {
                bundle2.putString("_zid", b2);
            }
            return bundle2;
        } catch (Throwable unused) {
            e.c.f.c.d();
            return null;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        e.c.f.c.a();
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
