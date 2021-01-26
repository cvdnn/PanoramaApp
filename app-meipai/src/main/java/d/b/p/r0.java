package d.b.p;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import com.baidu.mobstat.Config;
import d.b.f;
import d.i.a.c;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* compiled from: SuggestionsAdapter */
public class r0 extends c implements OnClickListener {
    public final SearchView l;
    public final SearchableInfo m;
    public final Context n;
    public final WeakHashMap<String, ConstantState> o;
    public final int p;
    public boolean q = false;
    public int r = 1;
    public ColorStateList s;
    public int t = -1;
    public int u = -1;
    public int v = -1;
    public int w = -1;
    public int x = -1;
    public int y = -1;

    /* compiled from: SuggestionsAdapter */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        public final TextView f4434a;

        /* renamed from: b reason: collision with root package name */
        public final TextView f4435b;

        /* renamed from: c reason: collision with root package name */
        public final ImageView f4436c;

        /* renamed from: d reason: collision with root package name */
        public final ImageView f4437d;

        /* renamed from: e reason: collision with root package name */
        public final ImageView f4438e;

        public a(View view) {
            this.f4434a = (TextView) view.findViewById(16908308);
            this.f4435b = (TextView) view.findViewById(16908309);
            this.f4436c = (ImageView) view.findViewById(16908295);
            this.f4437d = (ImageView) view.findViewById(16908296);
            this.f4438e = (ImageView) view.findViewById(f.edit_query);
        }
    }

    public r0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        SearchManager searchManager = (SearchManager) this.f5001d.getSystemService("search");
        this.l = searchView;
        this.m = searchableInfo;
        this.p = searchView.getSuggestionCommitIconResId();
        this.n = context;
        this.o = weakHashMap;
    }

    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View inflate = this.k.inflate(this.f5009i, viewGroup, false);
        inflate.setTag(new a(inflate));
        ((ImageView) inflate.findViewById(f.edit_query)).setImageResource(this.p);
        return inflate;
    }

    public CharSequence b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a2 = a(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (a2 != null) {
            return a2;
        }
        if (this.m.shouldRewriteQueryFromData()) {
            String a3 = a(cursor, cursor.getColumnIndex("suggest_intent_data"));
            if (a3 != null) {
                return a3;
            }
        }
        if (this.m.shouldRewriteQueryFromText()) {
            String a4 = a(cursor, cursor.getColumnIndex("suggest_text_1"));
            if (a4 != null) {
                return a4;
            }
        }
        return null;
    }

    public final void c(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            if (this.f4998a) {
                this.f5000c.moveToPosition(i2);
                if (view == null) {
                    view = this.k.inflate(this.f5010j, viewGroup, false);
                }
                a(view, this.f5001d, this.f5000c);
            } else {
                view = null;
            }
            return view;
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View inflate = this.k.inflate(this.f5010j, viewGroup, false);
            if (inflate != null) {
                ((a) inflate.getTag()).f4434a.setText(e2.toString());
            }
            return inflate;
        }
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View a2 = a(this.f5001d, this.f5000c, viewGroup);
            if (a2 != null) {
                ((a) a2.getTag()).f4434a.setText(e2.toString());
            }
            return a2;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        c(this.f5000c);
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        c(this.f5000c);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.l.a((CharSequence) tag);
        }
    }

    public void a(Cursor cursor) {
        String str = "SuggestionsAdapter";
        if (this.q) {
            Log.w(str, "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.t = cursor.getColumnIndex("suggest_text_1");
                this.u = cursor.getColumnIndex("suggest_text_2");
                this.v = cursor.getColumnIndex("suggest_text_2_url");
                this.w = cursor.getColumnIndex("suggest_icon_1");
                this.x = cursor.getColumnIndex("suggest_icon_2");
                this.y = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e(str, "error changing cursor and caching columns", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0145  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r18, android.content.Context r19, android.database.Cursor r20) {
        /*
            r17 = this;
            r1 = r17
            r2 = r20
            java.lang.Object r0 = r18.getTag()
            r3 = r0
            d.b.p.r0$a r3 = (d.b.p.r0.a) r3
            int r0 = r1.y
            r4 = -1
            r5 = 0
            if (r0 == r4) goto L_0x0017
            int r0 = r2.getInt(r0)
            r4 = r0
            goto L_0x0018
        L_0x0017:
            r4 = r5
        L_0x0018:
            android.widget.TextView r0 = r3.f4434a
            r6 = 8
            if (r0 == 0) goto L_0x0036
            int r0 = r1.t
            java.lang.String r0 = a(r2, r0)
            android.widget.TextView r7 = r3.f4434a
            r7.setText(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0033
            r7.setVisibility(r6)
            goto L_0x0036
        L_0x0033:
            r7.setVisibility(r5)
        L_0x0036:
            android.widget.TextView r0 = r3.f4435b
            r7 = 2
            r8 = 1
            if (r0 == 0) goto L_0x00be
            int r0 = r1.v
            java.lang.String r0 = a(r2, r0)
            if (r0 == 0) goto L_0x0085
            android.content.res.ColorStateList r9 = r1.s
            if (r9 != 0) goto L_0x0066
            android.util.TypedValue r9 = new android.util.TypedValue
            r9.<init>()
            android.content.Context r10 = r1.f5001d
            android.content.res.Resources$Theme r10 = r10.getTheme()
            int r11 = d.b.a.textColorSearchUrl
            r10.resolveAttribute(r11, r9, r8)
            android.content.Context r10 = r1.f5001d
            android.content.res.Resources r10 = r10.getResources()
            int r9 = r9.resourceId
            android.content.res.ColorStateList r9 = r10.getColorStateList(r9)
            r1.s = r9
        L_0x0066:
            android.text.SpannableString r9 = new android.text.SpannableString
            r9.<init>(r0)
            android.text.style.TextAppearanceSpan r15 = new android.text.style.TextAppearanceSpan
            r11 = 0
            r12 = 0
            r13 = 0
            android.content.res.ColorStateList r14 = r1.s
            r16 = 0
            r10 = r15
            r6 = r15
            r15 = r16
            r10.<init>(r11, r12, r13, r14, r15)
            int r0 = r0.length()
            r10 = 33
            r9.setSpan(r6, r5, r0, r10)
            goto L_0x008b
        L_0x0085:
            int r0 = r1.u
            java.lang.String r9 = a(r2, r0)
        L_0x008b:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L_0x009e
            android.widget.TextView r0 = r3.f4434a
            if (r0 == 0) goto L_0x00aa
            r0.setSingleLine(r5)
            android.widget.TextView r0 = r3.f4434a
            r0.setMaxLines(r7)
            goto L_0x00aa
        L_0x009e:
            android.widget.TextView r0 = r3.f4434a
            if (r0 == 0) goto L_0x00aa
            r0.setSingleLine(r8)
            android.widget.TextView r0 = r3.f4434a
            r0.setMaxLines(r8)
        L_0x00aa:
            android.widget.TextView r0 = r3.f4435b
            r0.setText(r9)
            boolean r6 = android.text.TextUtils.isEmpty(r9)
            if (r6 == 0) goto L_0x00bb
            r6 = 8
            r0.setVisibility(r6)
            goto L_0x00be
        L_0x00bb:
            r0.setVisibility(r5)
        L_0x00be:
            android.widget.ImageView r6 = r3.f4436c
            if (r6 == 0) goto L_0x016f
            int r0 = r1.w
            r9 = -1
            if (r0 != r9) goto L_0x00ca
            r0 = 0
            goto L_0x015c
        L_0x00ca:
            java.lang.String r0 = r2.getString(r0)
            android.graphics.drawable.Drawable r0 = r1.a(r0)
            if (r0 == 0) goto L_0x00d6
            goto L_0x015c
        L_0x00d6:
            android.app.SearchableInfo r0 = r1.m
            android.content.ComponentName r0 = r0.getSearchActivity()
            java.lang.String r9 = r0.flattenToShortString()
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r10 = r1.o
            boolean r10 = r10.containsKey(r9)
            if (r10 == 0) goto L_0x00ff
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r0 = r1.o
            java.lang.Object r0 = r0.get(r9)
            android.graphics.drawable.Drawable$ConstantState r0 = (android.graphics.drawable.Drawable.ConstantState) r0
            if (r0 != 0) goto L_0x00f4
            r0 = 0
            goto L_0x014f
        L_0x00f4:
            android.content.Context r9 = r1.n
            android.content.res.Resources r9 = r9.getResources()
            android.graphics.drawable.Drawable r0 = r0.newDrawable(r9)
            goto L_0x014f
        L_0x00ff:
            java.lang.String r10 = "SuggestionsAdapter"
            android.content.Context r11 = r1.f5001d
            android.content.pm.PackageManager r11 = r11.getPackageManager()
            r12 = 128(0x80, float:1.794E-43)
            android.content.pm.ActivityInfo r12 = r11.getActivityInfo(r0, r12)     // Catch:{ NameNotFoundException -> 0x0137 }
            int r13 = r12.getIconResource()
            if (r13 != 0) goto L_0x0114
            goto L_0x0140
        L_0x0114:
            java.lang.String r14 = r0.getPackageName()
            android.content.pm.ApplicationInfo r12 = r12.applicationInfo
            android.graphics.drawable.Drawable r11 = r11.getDrawable(r14, r13, r12)
            if (r11 != 0) goto L_0x0141
            java.lang.String r11 = "Invalid icon resource "
            java.lang.String r12 = " for "
            java.lang.StringBuilder r11 = e.a.a.a.a.a(r11, r13, r12)
            java.lang.String r0 = r0.flattenToShortString()
            r11.append(r0)
            java.lang.String r0 = r11.toString()
            android.util.Log.w(r10, r0)
            goto L_0x0140
        L_0x0137:
            r0 = move-exception
            r11 = r0
            java.lang.String r0 = r11.toString()
            android.util.Log.w(r10, r0)
        L_0x0140:
            r11 = 0
        L_0x0141:
            if (r11 != 0) goto L_0x0145
            r0 = 0
            goto L_0x0149
        L_0x0145:
            android.graphics.drawable.Drawable$ConstantState r0 = r11.getConstantState()
        L_0x0149:
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r10 = r1.o
            r10.put(r9, r0)
            r0 = r11
        L_0x014f:
            if (r0 == 0) goto L_0x0152
            goto L_0x015c
        L_0x0152:
            android.content.Context r0 = r1.f5001d
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.graphics.drawable.Drawable r0 = r0.getDefaultActivityIcon()
        L_0x015c:
            r9 = 4
            r6.setImageDrawable(r0)
            if (r0 != 0) goto L_0x0166
            r6.setVisibility(r9)
            goto L_0x016f
        L_0x0166:
            r6.setVisibility(r5)
            r0.setVisible(r5, r5)
            r0.setVisible(r8, r5)
        L_0x016f:
            android.widget.ImageView r0 = r3.f4437d
            if (r0 == 0) goto L_0x0196
            int r6 = r1.x
            r9 = -1
            if (r6 != r9) goto L_0x017a
            r2 = 0
            goto L_0x0182
        L_0x017a:
            java.lang.String r2 = r2.getString(r6)
            android.graphics.drawable.Drawable r2 = r1.a(r2)
        L_0x0182:
            r0.setImageDrawable(r2)
            if (r2 != 0) goto L_0x018d
            r6 = 8
            r0.setVisibility(r6)
            goto L_0x0196
        L_0x018d:
            r0.setVisibility(r5)
            r2.setVisible(r5, r5)
            r2.setVisible(r8, r5)
        L_0x0196:
            int r0 = r1.r
            if (r0 == r7) goto L_0x01a9
            if (r0 != r8) goto L_0x01a1
            r0 = r4 & 1
            if (r0 == 0) goto L_0x01a1
            goto L_0x01a9
        L_0x01a1:
            android.widget.ImageView r0 = r3.f4438e
            r2 = 8
            r0.setVisibility(r2)
            goto L_0x01be
        L_0x01a9:
            android.widget.ImageView r0 = r3.f4438e
            r0.setVisibility(r5)
            android.widget.ImageView r0 = r3.f4438e
            android.widget.TextView r2 = r3.f4434a
            java.lang.CharSequence r2 = r2.getText()
            r0.setTag(r2)
            android.widget.ImageView r0 = r3.f4438e
            r0.setOnClickListener(r1)
        L_0x01be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.p.r0.a(android.view.View, android.content.Context, android.database.Cursor):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:34|35|36) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r4 = new java.lang.StringBuilder();
        r4.append("Resource does not exist: ");
        r4.append(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b4, code lost:
        throw new java.io.FileNotFoundException(r4.toString());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x009e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable a(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "SuggestionsAdapter"
            r1 = 0
            if (r8 == 0) goto L_0x013a
            boolean r2 = r8.isEmpty()
            if (r2 != 0) goto L_0x013a
            java.lang.String r2 = "0"
            boolean r2 = r2.equals(r8)
            if (r2 == 0) goto L_0x0015
            goto L_0x013a
        L_0x0015:
            int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            java.lang.String r4 = "android.resource://"
            r3.append(r4)     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            android.content.Context r4 = r7.n     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            r3.append(r4)     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            r3.append(r2)     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            java.lang.String r3 = r3.toString()     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r4 = r7.o     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            android.graphics.drawable.Drawable$ConstantState r4 = (android.graphics.drawable.Drawable.ConstantState) r4     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            if (r4 != 0) goto L_0x0044
            r4 = r1
            goto L_0x0048
        L_0x0044:
            android.graphics.drawable.Drawable r4 = r4.newDrawable()     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
        L_0x0048:
            if (r4 == 0) goto L_0x004b
            return r4
        L_0x004b:
            android.content.Context r4 = r7.n     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            android.graphics.drawable.Drawable r2 = d.h.e.a.b(r4, r2)     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            if (r2 == 0) goto L_0x005c
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r4 = r7.o     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            android.graphics.drawable.Drawable$ConstantState r5 = r2.getConstantState()     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
            r4.put(r3, r5)     // Catch:{ NumberFormatException -> 0x0072, NotFoundException -> 0x005d }
        L_0x005c:
            return r2
        L_0x005d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Icon resource not found: "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            android.util.Log.w(r0, r8)
            return r1
        L_0x0072:
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r2 = r7.o
            java.lang.Object r2 = r2.get(r8)
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2
            if (r2 != 0) goto L_0x007e
            r2 = r1
            goto L_0x0082
        L_0x007e:
            android.graphics.drawable.Drawable r2 = r2.newDrawable()
        L_0x0082:
            if (r2 == 0) goto L_0x0085
            return r2
        L_0x0085:
            android.net.Uri r2 = android.net.Uri.parse(r8)
            java.lang.String r3 = "Error closing icon stream for "
            java.lang.String r4 = r2.getScheme()     // Catch:{ FileNotFoundException -> 0x010e }
            java.lang.String r5 = "android.resource"
            boolean r4 = r5.equals(r4)     // Catch:{ FileNotFoundException -> 0x010e }
            if (r4 == 0) goto L_0x00b5
            android.graphics.drawable.Drawable r0 = r7.a(r2)     // Catch:{ NotFoundException -> 0x009e }
            r1 = r0
            goto L_0x012f
        L_0x009e:
            java.io.FileNotFoundException r3 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x010e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x010e }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x010e }
            java.lang.String r5 = "Resource does not exist: "
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x010e }
            r4.append(r2)     // Catch:{ FileNotFoundException -> 0x010e }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x010e }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x010e }
            throw r3     // Catch:{ FileNotFoundException -> 0x010e }
        L_0x00b5:
            android.content.Context r4 = r7.n     // Catch:{ FileNotFoundException -> 0x010e }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ FileNotFoundException -> 0x010e }
            java.io.InputStream r4 = r4.openInputStream(r2)     // Catch:{ FileNotFoundException -> 0x010e }
            if (r4 == 0) goto L_0x00f7
            android.graphics.drawable.Drawable r5 = android.graphics.drawable.Drawable.createFromStream(r4, r1)     // Catch:{ all -> 0x00de }
            r4.close()     // Catch:{ IOException -> 0x00c9 }
            goto L_0x00dc
        L_0x00c9:
            r4 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x010e }
            r6.<init>()     // Catch:{ FileNotFoundException -> 0x010e }
            r6.append(r3)     // Catch:{ FileNotFoundException -> 0x010e }
            r6.append(r2)     // Catch:{ FileNotFoundException -> 0x010e }
            java.lang.String r3 = r6.toString()     // Catch:{ FileNotFoundException -> 0x010e }
            android.util.Log.e(r0, r3, r4)     // Catch:{ FileNotFoundException -> 0x010e }
        L_0x00dc:
            r1 = r5
            goto L_0x012f
        L_0x00de:
            r5 = move-exception
            r4.close()     // Catch:{ IOException -> 0x00e3 }
            goto L_0x00f6
        L_0x00e3:
            r4 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x010e }
            r6.<init>()     // Catch:{ FileNotFoundException -> 0x010e }
            r6.append(r3)     // Catch:{ FileNotFoundException -> 0x010e }
            r6.append(r2)     // Catch:{ FileNotFoundException -> 0x010e }
            java.lang.String r3 = r6.toString()     // Catch:{ FileNotFoundException -> 0x010e }
            android.util.Log.e(r0, r3, r4)     // Catch:{ FileNotFoundException -> 0x010e }
        L_0x00f6:
            throw r5     // Catch:{ FileNotFoundException -> 0x010e }
        L_0x00f7:
            java.io.FileNotFoundException r3 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x010e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x010e }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x010e }
            java.lang.String r5 = "Failed to open "
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x010e }
            r4.append(r2)     // Catch:{ FileNotFoundException -> 0x010e }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x010e }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x010e }
            throw r3     // Catch:{ FileNotFoundException -> 0x010e }
        L_0x010e:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Icon not found: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = ", "
            r4.append(r2)
            java.lang.String r2 = r3.getMessage()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            android.util.Log.w(r0, r2)
        L_0x012f:
            if (r1 == 0) goto L_0x013a
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r0 = r7.o
            android.graphics.drawable.Drawable$ConstantState r2 = r1.getConstantState()
            r0.put(r8, r2)
        L_0x013a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.p.r0.a(java.lang.String):android.graphics.drawable.Drawable");
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    public static String a(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    public Drawable a(Uri uri) throws FileNotFoundException {
        int i2;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f5001d.getPackageManager().getResourcesForApplication(authority);
                List pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i2 = Integer.parseInt((String) pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException(e.a.a.a.a.a("Single path segment is not a resource ID: ", uri));
                        }
                    } else if (size == 2) {
                        i2 = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException(e.a.a.a.a.a("More than two path segments: ", uri));
                    }
                    if (i2 != 0) {
                        return resourcesForApplication.getDrawable(i2);
                    }
                    throw new FileNotFoundException(e.a.a.a.a.a("No resource found for: ", uri));
                }
                throw new FileNotFoundException(e.a.a.a.a.a("No path: ", uri));
            } catch (NameNotFoundException unused2) {
                throw new FileNotFoundException(e.a.a.a.a.a("No package found for authority: ", uri));
            }
        } else {
            throw new FileNotFoundException(e.a.a.a.a.a("No authority: ", uri));
        }
    }

    public Cursor a(SearchableInfo searchableInfo, String str, int i2) {
        String[] strArr = null;
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        Builder authority = new Builder().scheme(Config.LAUNCH_CONTENT).authority(suggestAuthority);
        String str2 = "";
        Builder fragment = authority.query(str2).fragment(str2);
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i2 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.f5001d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }
}
