package d.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import d.b.c;
import d.b.p.n0.e;

/* compiled from: AppCompatDrawableManager */
public final class j {

    /* renamed from: b reason: collision with root package name */
    public static final Mode f4367b = Mode.SRC_IN;

    /* renamed from: c reason: collision with root package name */
    public static j f4368c;

    /* renamed from: a reason: collision with root package name */
    public n0 f4369a;

    /* compiled from: AppCompatDrawableManager */
    public static class a implements e {

        /* renamed from: a reason: collision with root package name */
        public final int[] f4370a = {d.b.e.abc_textfield_search_default_mtrl_alpha, d.b.e.abc_textfield_default_mtrl_alpha, d.b.e.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b reason: collision with root package name */
        public final int[] f4371b = {d.b.e.abc_ic_commit_search_api_mtrl_alpha, d.b.e.abc_seekbar_tick_mark_material, d.b.e.abc_ic_menu_share_mtrl_alpha, d.b.e.abc_ic_menu_copy_mtrl_am_alpha, d.b.e.abc_ic_menu_cut_mtrl_alpha, d.b.e.abc_ic_menu_selectall_mtrl_alpha, d.b.e.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c reason: collision with root package name */
        public final int[] f4372c = {d.b.e.abc_textfield_activated_mtrl_alpha, d.b.e.abc_textfield_search_activated_mtrl_alpha, d.b.e.abc_cab_background_top_mtrl_alpha, d.b.e.abc_text_cursor_material, d.b.e.abc_text_select_handle_left_mtrl_dark, d.b.e.abc_text_select_handle_middle_mtrl_dark, d.b.e.abc_text_select_handle_right_mtrl_dark, d.b.e.abc_text_select_handle_left_mtrl_light, d.b.e.abc_text_select_handle_middle_mtrl_light, d.b.e.abc_text_select_handle_right_mtrl_light};

        /* renamed from: d reason: collision with root package name */
        public final int[] f4373d = {d.b.e.abc_popup_background_mtrl_mult, d.b.e.abc_cab_background_internal_bg, d.b.e.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e reason: collision with root package name */
        public final int[] f4374e = {d.b.e.abc_tab_indicator_material, d.b.e.abc_textfield_search_material};

        /* renamed from: f reason: collision with root package name */
        public final int[] f4375f = {d.b.e.abc_btn_check_material, d.b.e.abc_btn_radio_material, d.b.e.abc_btn_check_material_anim, d.b.e.abc_btn_radio_material_anim};

        public final ColorStateList a(Context context, int i2) {
            int b2 = s0.b(context, d.b.a.colorControlHighlight);
            return new ColorStateList(new int[][]{s0.f4441b, s0.f4443d, s0.f4442c, s0.f4445f}, new int[]{s0.a(context, d.b.a.colorButtonNormal), d.h.f.a.a(b2, i2), d.h.f.a.a(b2, i2), i2});
        }

        public ColorStateList b(Context context, int i2) {
            if (i2 == d.b.e.abc_edit_text_material) {
                return d.b.l.a.a.a(context, c.abc_tint_edittext);
            }
            if (i2 == d.b.e.abc_switch_track_mtrl_alpha) {
                return d.b.l.a.a.a(context, c.abc_tint_switch_track);
            }
            if (i2 == d.b.e.abc_switch_thumb_material) {
                int[][] iArr = new int[3][];
                int[] iArr2 = new int[3];
                ColorStateList c2 = s0.c(context, d.b.a.colorSwitchThumbNormal);
                if (c2 == null || !c2.isStateful()) {
                    iArr[0] = s0.f4441b;
                    iArr2[0] = s0.a(context, d.b.a.colorSwitchThumbNormal);
                    iArr[1] = s0.f4444e;
                    iArr2[1] = s0.b(context, d.b.a.colorControlActivated);
                    iArr[2] = s0.f4445f;
                    iArr2[2] = s0.b(context, d.b.a.colorSwitchThumbNormal);
                } else {
                    iArr[0] = s0.f4441b;
                    iArr2[0] = c2.getColorForState(iArr[0], 0);
                    iArr[1] = s0.f4444e;
                    iArr2[1] = s0.b(context, d.b.a.colorControlActivated);
                    iArr[2] = s0.f4445f;
                    iArr2[2] = c2.getDefaultColor();
                }
                return new ColorStateList(iArr, iArr2);
            } else if (i2 == d.b.e.abc_btn_default_mtrl_shape) {
                return a(context, s0.b(context, d.b.a.colorButtonNormal));
            } else {
                if (i2 == d.b.e.abc_btn_borderless_material) {
                    return a(context, 0);
                }
                if (i2 == d.b.e.abc_btn_colored_material) {
                    return a(context, s0.b(context, d.b.a.colorAccent));
                }
                if (i2 == d.b.e.abc_spinner_mtrl_am_alpha || i2 == d.b.e.abc_spinner_textfield_background_material) {
                    return d.b.l.a.a.a(context, c.abc_tint_spinner);
                }
                if (a(this.f4371b, i2)) {
                    return s0.c(context, d.b.a.colorControlNormal);
                }
                if (a(this.f4374e, i2)) {
                    return d.b.l.a.a.a(context, c.abc_tint_default);
                }
                if (a(this.f4375f, i2)) {
                    return d.b.l.a.a.a(context, c.abc_tint_btn_checkable);
                }
                if (i2 == d.b.e.abc_seekbar_thumb_material) {
                    return d.b.l.a.a.a(context, c.abc_tint_seek_thumb);
                }
                return null;
            }
        }

        public final void a(Drawable drawable, int i2, Mode mode) {
            if (e0.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = j.f4367b;
            }
            drawable.setColorFilter(j.a(i2, mode));
        }

        public final boolean a(int[] iArr, int i2) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }
    }

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (f4368c == null) {
                b();
            }
            jVar = f4368c;
        }
        return jVar;
    }

    public static synchronized void b() {
        synchronized (j.class) {
            if (f4368c == null) {
                j jVar = new j();
                f4368c = jVar;
                jVar.f4369a = n0.a();
                f4368c.f4369a.a((e) new a());
            }
        }
    }

    public synchronized Drawable a(Context context, int i2) {
        return this.f4369a.b(context, i2);
    }

    public synchronized Drawable a(Context context, int i2, boolean z) {
        return this.f4369a.a(context, i2, z);
    }

    public synchronized void a(Context context) {
        this.f4369a.a(context);
    }

    public synchronized ColorStateList b(Context context, int i2) {
        return this.f4369a.c(context, i2);
    }

    public static void a(Drawable drawable, v0 v0Var, int[] iArr) {
        n0.a(drawable, v0Var, iArr);
    }

    public static synchronized PorterDuffColorFilter a(int i2, Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (j.class) {
            a2 = n0.a(i2, mode);
        }
        return a2;
    }
}
