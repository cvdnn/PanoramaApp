package com.baidu.sofire;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import e.c.d.n.e;
import e.c.f.c;
import e.c.f.n.m;

public class THProvider extends ContentProvider {

    public static class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ String f3272a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ Context f3273b;

        public a(String str, Context context) {
            this.f3272a = str;
            this.f3273b = context;
        }

        public final void run() {
            try {
                new StringBuilder().append(this.f3272a);
                c.a();
                Intent intent = new Intent();
                intent.putExtra("t", "p");
                intent.putExtra("c", this.f3272a);
                e.a(this.f3273b, intent);
            } catch (Throwable unused) {
                c.d();
            }
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
        c.a();
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        c.a();
        try {
            if ("p".equals(str)) {
                m.a().a(new a(str2, getContext()));
            }
        } catch (Throwable unused) {
            c.d();
        }
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
