package d.b.o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.arashivision.graphicpath.render.source.AssetInfo.SubMediaType;
import d.b.o.i.i;
import d.b.o.i.j;
import d.b.p.e0;
import d.b.p.x0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SupportMenuInflater */
public class f extends MenuInflater {

    /* renamed from: e reason: collision with root package name */
    public static final Class<?>[] f4112e;

    /* renamed from: f reason: collision with root package name */
    public static final Class<?>[] f4113f;

    /* renamed from: a reason: collision with root package name */
    public final Object[] f4114a;

    /* renamed from: b reason: collision with root package name */
    public final Object[] f4115b;

    /* renamed from: c reason: collision with root package name */
    public Context f4116c;

    /* renamed from: d reason: collision with root package name */
    public Object f4117d;

    /* compiled from: SupportMenuInflater */
    public static class a implements OnMenuItemClickListener {

        /* renamed from: c reason: collision with root package name */
        public static final Class<?>[] f4118c = {MenuItem.class};

        /* renamed from: a reason: collision with root package name */
        public Object f4119a;

        /* renamed from: b reason: collision with root package name */
        public Method f4120b;

        public a(Object obj, String str) {
            this.f4119a = obj;
            Class cls = obj.getClass();
            try {
                this.f4120b = cls.getMethod(str, f4118c);
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't resolve menu item onClick handler ");
                sb.append(str);
                sb.append(" in class ");
                sb.append(cls.getName());
                InflateException inflateException = new InflateException(sb.toString());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f4120b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f4120b.invoke(this.f4119a, new Object[]{menuItem})).booleanValue();
                }
                this.f4120b.invoke(this.f4119a, new Object[]{menuItem});
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* compiled from: SupportMenuInflater */
    public class b {
        public d.h.k.b A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public Mode E = null;

        /* renamed from: a reason: collision with root package name */
        public Menu f4121a;

        /* renamed from: b reason: collision with root package name */
        public int f4122b;

        /* renamed from: c reason: collision with root package name */
        public int f4123c;

        /* renamed from: d reason: collision with root package name */
        public int f4124d;

        /* renamed from: e reason: collision with root package name */
        public int f4125e;

        /* renamed from: f reason: collision with root package name */
        public boolean f4126f;

        /* renamed from: g reason: collision with root package name */
        public boolean f4127g;

        /* renamed from: h reason: collision with root package name */
        public boolean f4128h;

        /* renamed from: i reason: collision with root package name */
        public int f4129i;

        /* renamed from: j reason: collision with root package name */
        public int f4130j;
        public CharSequence k;
        public CharSequence l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;

        public b(Menu menu) {
            this.f4121a = menu;
            this.f4122b = 0;
            this.f4123c = 0;
            this.f4124d = 0;
            this.f4125e = 0;
            this.f4126f = true;
            this.f4127g = true;
        }

        public final void a(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!f.this.f4116c.isRestricted()) {
                    f fVar = f.this;
                    if (fVar.f4117d == null) {
                        fVar.f4117d = fVar.a(fVar.f4116c);
                    }
                    menuItem.setOnMenuItemClickListener(new a(fVar.f4117d, this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z3 = menuItem instanceof i;
            if (z3) {
                i iVar = (i) menuItem;
            }
            if (this.r >= 2) {
                if (z3) {
                    i iVar2 = (i) menuItem;
                    iVar2.x = (iVar2.x & -5) | 4;
                } else if (menuItem instanceof j) {
                    j jVar = (j) menuItem;
                    try {
                        if (jVar.f4223e == null) {
                            jVar.f4223e = jVar.f4222d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                        }
                        jVar.f4223e.invoke(jVar.f4222d, new Object[]{Boolean.valueOf(true)});
                    } catch (Exception e2) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
                    }
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) a(str, f.f4112e, f.this.f4114a));
                z2 = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (!z2) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            d.h.k.b bVar = this.A;
            if (bVar != null) {
                if (menuItem instanceof d.h.g.a.b) {
                    ((d.h.g.a.b) menuItem).a(bVar);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.B;
            boolean z4 = menuItem instanceof d.h.g.a.b;
            if (z4) {
                ((d.h.g.a.b) menuItem).setContentDescription(charSequence);
            } else if (VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.C;
            if (z4) {
                ((d.h.g.a.b) menuItem).setTooltipText(charSequence2);
            } else if (VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
            char c2 = this.n;
            int i4 = this.o;
            if (z4) {
                ((d.h.g.a.b) menuItem).setAlphabeticShortcut(c2, i4);
            } else if (VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c2, i4);
            }
            char c3 = this.p;
            int i5 = this.q;
            if (z4) {
                ((d.h.g.a.b) menuItem).setNumericShortcut(c3, i5);
            } else if (VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c3, i5);
            }
            Mode mode = this.E;
            if (mode != null) {
                if (z4) {
                    ((d.h.g.a.b) menuItem).setIconTintMode(mode);
                } else if (VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList == null) {
                return;
            }
            if (z4) {
                ((d.h.g.a.b) menuItem).setIconTintList(colorStateList);
            } else if (VERSION.SDK_INT >= 26) {
                menuItem.setIconTintList(colorStateList);
            }
        }

        public SubMenu a() {
            this.f4128h = true;
            SubMenu addSubMenu = this.f4121a.addSubMenu(this.f4122b, this.f4129i, this.f4130j, this.k);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public final <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = Class.forName(str, false, f.this.f4116c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot instantiate class: ");
                sb.append(str);
                Log.w("SupportMenuInflater", sb.toString(), e2);
                return null;
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f4112e = clsArr;
        f4113f = clsArr;
    }

    public f(Context context) {
        super(context);
        this.f4116c = context;
        Object[] objArr = {context};
        this.f4114a = objArr;
        this.f4115b = objArr;
    }

    public final void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        String str;
        char c2;
        char c3;
        AttributeSet attributeSet2 = attributeSet;
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            str = "menu";
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals(str)) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException(e.a.a.a.a.a("Expecting menu, got ", name));
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
                XmlPullParser xmlPullParser2 = xmlPullParser;
            }
        }
        String str2 = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (eventType != 1) {
                String str3 = "item";
                String str4 = "group";
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str2)) {
                            XmlPullParser xmlPullParser3 = xmlPullParser;
                            str2 = null;
                            z2 = false;
                            eventType = xmlPullParser.next();
                        } else if (name2.equals(str4)) {
                            bVar.f4122b = 0;
                            bVar.f4123c = 0;
                            bVar.f4124d = 0;
                            bVar.f4125e = 0;
                            bVar.f4126f = true;
                            bVar.f4127g = true;
                        } else if (name2.equals(str3)) {
                            if (!bVar.f4128h) {
                                d.h.k.b bVar2 = bVar.A;
                                if (bVar2 == null || !((d.b.o.i.j.a) bVar2).f4224b.hasSubMenu()) {
                                    bVar.f4128h = true;
                                    bVar.a(bVar.f4121a.add(bVar.f4122b, bVar.f4129i, bVar.f4130j, bVar.k));
                                } else {
                                    bVar.a();
                                }
                            }
                        } else if (name2.equals(str)) {
                            XmlPullParser xmlPullParser4 = xmlPullParser;
                            z = true;
                            eventType = xmlPullParser.next();
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals(str4)) {
                        TypedArray obtainStyledAttributes = f.this.f4116c.obtainStyledAttributes(attributeSet2, d.b.j.MenuGroup);
                        bVar.f4122b = obtainStyledAttributes.getResourceId(d.b.j.MenuGroup_android_id, 0);
                        bVar.f4123c = obtainStyledAttributes.getInt(d.b.j.MenuGroup_android_menuCategory, 0);
                        bVar.f4124d = obtainStyledAttributes.getInt(d.b.j.MenuGroup_android_orderInCategory, 0);
                        bVar.f4125e = obtainStyledAttributes.getInt(d.b.j.MenuGroup_android_checkableBehavior, 0);
                        bVar.f4126f = obtainStyledAttributes.getBoolean(d.b.j.MenuGroup_android_visible, true);
                        bVar.f4127g = obtainStyledAttributes.getBoolean(d.b.j.MenuGroup_android_enabled, true);
                        obtainStyledAttributes.recycle();
                    } else if (name3.equals(str3)) {
                        x0 a2 = x0.a(f.this.f4116c, attributeSet2, d.b.j.MenuItem);
                        bVar.f4129i = a2.f(d.b.j.MenuItem_android_id, 0);
                        bVar.f4130j = (a2.d(d.b.j.MenuItem_android_menuCategory, bVar.f4123c) & -65536) | (a2.d(d.b.j.MenuItem_android_orderInCategory, bVar.f4124d) & SubMediaType.UNDEFINED);
                        bVar.k = a2.e(d.b.j.MenuItem_android_title);
                        bVar.l = a2.e(d.b.j.MenuItem_android_titleCondensed);
                        bVar.m = a2.f(d.b.j.MenuItem_android_icon, 0);
                        String d2 = a2.d(d.b.j.MenuItem_android_alphabeticShortcut);
                        if (d2 == null) {
                            c2 = 0;
                        } else {
                            c2 = d2.charAt(0);
                        }
                        bVar.n = c2;
                        bVar.o = a2.d(d.b.j.MenuItem_alphabeticModifiers, 4096);
                        String d3 = a2.d(d.b.j.MenuItem_android_numericShortcut);
                        if (d3 == null) {
                            c3 = 0;
                        } else {
                            c3 = d3.charAt(0);
                        }
                        bVar.p = c3;
                        bVar.q = a2.d(d.b.j.MenuItem_numericModifiers, 4096);
                        if (a2.f(d.b.j.MenuItem_android_checkable)) {
                            bVar.r = a2.a(d.b.j.MenuItem_android_checkable, false) ? 1 : 0;
                        } else {
                            bVar.r = bVar.f4125e;
                        }
                        bVar.s = a2.a(d.b.j.MenuItem_android_checked, false);
                        bVar.t = a2.a(d.b.j.MenuItem_android_visible, bVar.f4126f);
                        bVar.u = a2.a(d.b.j.MenuItem_android_enabled, bVar.f4127g);
                        bVar.v = a2.d(d.b.j.MenuItem_showAsAction, -1);
                        bVar.z = a2.d(d.b.j.MenuItem_android_onClick);
                        bVar.w = a2.f(d.b.j.MenuItem_actionLayout, 0);
                        bVar.x = a2.d(d.b.j.MenuItem_actionViewClass);
                        String d4 = a2.d(d.b.j.MenuItem_actionProviderClass);
                        bVar.y = d4;
                        boolean z3 = d4 != null;
                        if (z3 && bVar.w == 0 && bVar.x == null) {
                            bVar.A = (d.h.k.b) bVar.a(bVar.y, f4113f, f.this.f4115b);
                        } else {
                            if (z3) {
                                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            bVar.A = null;
                        }
                        bVar.B = a2.e(d.b.j.MenuItem_contentDescription);
                        bVar.C = a2.e(d.b.j.MenuItem_tooltipText);
                        if (a2.f(d.b.j.MenuItem_iconTintMode)) {
                            bVar.E = e0.a(a2.d(d.b.j.MenuItem_iconTintMode, -1), bVar.E);
                        } else {
                            bVar.E = null;
                        }
                        if (a2.f(d.b.j.MenuItem_iconTint)) {
                            bVar.D = a2.a(d.b.j.MenuItem_iconTint);
                        } else {
                            bVar.D = null;
                        }
                        a2.f4485b.recycle();
                        bVar.f4128h = false;
                    } else {
                        if (name3.equals(str)) {
                            a(xmlPullParser, attributeSet2, bVar.a());
                        } else {
                            XmlPullParser xmlPullParser5 = xmlPullParser;
                            str2 = name3;
                            z2 = true;
                        }
                        eventType = xmlPullParser.next();
                    }
                }
                XmlPullParser xmlPullParser6 = xmlPullParser;
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    public void inflate(int i2, Menu menu) {
        String str = "Error inflating menu XML";
        if (!(menu instanceof d.h.g.a.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f4116c.getResources().getLayout(i2);
            a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            xmlResourceParser.close();
        } catch (XmlPullParserException e2) {
            throw new InflateException(str, e2);
        } catch (IOException e3) {
            throw new InflateException(str, e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    public final Object a(Object obj) {
        if (obj instanceof Activity) {
            return obj;
        }
        if (obj instanceof ContextWrapper) {
            obj = a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }
}
