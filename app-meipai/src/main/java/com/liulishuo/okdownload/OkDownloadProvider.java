package com.liulishuo.okdownload;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public class OkDownloadProvider extends ContentProvider {
    @SuppressLint({"StaticFieldLeak"})
    @SuppressFBWarnings({"ST"})

    /* renamed from: a reason: collision with root package name */
    public static Context f3542a;

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
        f3542a = getContext();
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
