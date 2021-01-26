package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.t;
import e.c.c.a.g;
import e.c.c.a.h;
import e.c.c.a.i;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SmsLoginView extends FrameLayout implements NoProguard {

    /* renamed from: a reason: collision with root package name */
    public static final String f3163a = "extrajson";

    /* renamed from: b reason: collision with root package name */
    public static final String f3164b = "sdk_situation";

    /* renamed from: c reason: collision with root package name */
    public static final String f3165c = "pop_login";

    /* renamed from: d reason: collision with root package name */
    public static final String f3166d = "skipreg";

    /* renamed from: e reason: collision with root package name */
    public Context f3167e;

    /* renamed from: f reason: collision with root package name */
    public View f3168f;

    /* renamed from: g reason: collision with root package name */
    public View f3169g;

    /* renamed from: h reason: collision with root package name */
    public EditText f3170h;

    /* renamed from: i reason: collision with root package name */
    public EditText f3171i;

    /* renamed from: j reason: collision with root package name */
    public TextView f3172j;
    public TextView k;
    public View l;
    public View m;
    public Dialog n;
    public CountDownTimer o;
    public String p;
    public boolean q;
    public BroadcastReceiver r;
    public e s;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Log.i("dragon", "onTextChanged");
            int length = charSequence.toString().length();
            if (length == 0) {
                SmsLoginView.this.f3171i.setGravity(19);
            } else if (length == 1) {
                SmsLoginView.this.k.setText("");
                SmsLoginView.this.k.setVisibility(8);
                SmsLoginView.this.f3171i.setGravity(17);
            } else if (length == 6 && !TextUtils.isEmpty(SmsLoginView.this.p)) {
                SmsLoginView.this.c();
            }
        }

        public /* synthetic */ a(SmsLoginView smsLoginView, h hVar) {
            this();
        }
    }

    public class b extends Dialog {
        public b(Context context) {
            super(context, h.sapi_sdk_empty_dialog);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            setContentView(new TextView(context));
            getWindow().setFlags(131072, 131072);
        }
    }

    public class c implements OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            if (SmsLoginView.this.f3170h.getText().toString().length() == 11) {
                SmsLoginView smsLoginView = SmsLoginView.this;
                smsLoginView.q = smsLoginView.f3172j.getText().toString().equals(SmsLoginView.this.f3167e.getString(g.sapi_sdk_sms_get_check_code));
                SmsLoginView.this.k.setVisibility(8);
                SmsLoginView.this.k.setText("");
                SmsLoginView.this.f3171i.requestFocus();
                SmsLoginView smsLoginView2 = SmsLoginView.this;
                smsLoginView2.a((Handler) smsLoginView2.s);
                SmsLoginView smsLoginView3 = SmsLoginView.this;
                k kVar = new k(this, 60000, 1000);
                smsLoginView3.o = kVar;
                SmsLoginView.this.o.start();
                SmsLoginView smsLoginView4 = SmsLoginView.this;
                smsLoginView4.p = smsLoginView4.f3170h.getText().toString();
                String smsLoginStatExtra = PassportSDK.getInstance().getSmsLoginStatExtra();
                HashMap hashMap = new HashMap();
                if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
                    hashMap.put("extrajson", smsLoginStatExtra);
                }
                hashMap.put(SmsLoginView.f3164b, "pop_login");
                hashMap.put(SmsLoginView.f3166d, "1");
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new l(this), SmsLoginView.this.p, null, hashMap);
                if (SmsLoginView.this.q) {
                    SmsLoginView.b(f.f3181d, (String) null);
                } else {
                    SmsLoginView.b(f.f3184g, (String) null);
                }
            }
        }

        public /* synthetic */ c(SmsLoginView smsLoginView, h hVar) {
            this();
        }
    }

    public class d implements TextWatcher {
        public d() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int length = charSequence.toString().length();
            String str = "";
            if (length == 0) {
                if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
                    PassportSDK.getInstance().getSmsViewLoginCallback().onCheckCodeViewHide();
                }
                SmsLoginView.this.f3169g.setVisibility(8);
                SmsLoginView.this.k.setVisibility(8);
                SmsLoginView.this.k.setText(str);
                SmsLoginView.this.f3170h.setGravity(19);
            } else if (SmsLoginView.this.f3169g.getVisibility() != 0) {
                if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
                    PassportSDK.getInstance().getSmsViewLoginCallback().onCheckCodeViewShow();
                }
                SmsLoginView.this.f3169g.setVisibility(0);
                SmsLoginView.this.f3170h.setGravity(17);
            }
            if (length == 10) {
                if (TextUtils.isEmpty(SmsLoginView.this.p)) {
                    SmsLoginView.this.f3172j.setText(g.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.a(false);
                    SmsLoginView.this.k.setVisibility(8);
                    SmsLoginView.this.k.setText(str);
                    SmsLoginView.this.f3172j.setEnabled(false);
                }
            } else if (length == 11) {
                if (!SmsLoginView.this.f3170h.getText().toString().equals(SmsLoginView.this.p)) {
                    if (SmsLoginView.this.o != null) {
                        SmsLoginView.this.o.cancel();
                    }
                    SmsLoginView.this.f3172j.setText(g.sapi_sdk_sms_get_check_code);
                    SmsLoginView.this.a(true);
                    if (SapiUtils.validateMobile(charSequence.toString())) {
                        SmsLoginView.this.f3172j.setEnabled(true);
                    } else {
                        SmsLoginView.this.k.setVisibility(0);
                        SmsLoginView.this.k.setText(g.sapi_sdk_sms_prompt_phone_number_error);
                    }
                }
                SmsLoginView.b(f.f3180c, (String) null);
            }
        }

        public /* synthetic */ d(SmsLoginView smsLoginView, h hVar) {
            this();
        }
    }

    public class e extends Handler {
        public e() {
        }

        public void handleMessage(Message message) {
            Object obj = message.obj;
            if (obj != null) {
                SmsLoginView.this.f3171i.setText((String) obj);
                SmsLoginView.this.e();
            }
        }

        public /* synthetic */ e(SmsLoginView smsLoginView, h hVar) {
            this();
        }
    }

    public interface f {

        /* renamed from: a reason: collision with root package name */
        public static final String f3178a = "pop_login";

        /* renamed from: b reason: collision with root package name */
        public static final String f3179b = "show";

        /* renamed from: c reason: collision with root package name */
        public static final String f3180c = "input_phone";

        /* renamed from: d reason: collision with root package name */
        public static final String f3181d = "first_get_dpass";

        /* renamed from: e reason: collision with root package name */
        public static final String f3182e = "first_get_dpass_success";

        /* renamed from: f reason: collision with root package name */
        public static final String f3183f = "first_get_dpass_failure";

        /* renamed from: g reason: collision with root package name */
        public static final String f3184g = "get_dpass_again";

        /* renamed from: h reason: collision with root package name */
        public static final String f3185h = "get_dpass_again_success";

        /* renamed from: i reason: collision with root package name */
        public static final String f3186i = "get_dpass_again_failure";

        /* renamed from: j reason: collision with root package name */
        public static final String f3187j = "verify";
        public static final String k = "success";
        public static final String l = "failure";
    }

    public SmsLoginView(Context context) {
        this(context, null);
    }

    public static void notifyStartLogin() {
        b(f.f3179b, (String) null);
    }

    public void clean() {
        String str = "";
        this.f3171i.setText(str);
        this.f3170h.setText(str);
        CountDownTimer countDownTimer = this.o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f3172j.setText(g.sapi_sdk_sms_get_check_code);
        a(false);
    }

    public void close() {
        CountDownTimer countDownTimer = this.o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        PassportSDK.getInstance().release();
        e();
    }

    public SmsLoginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    /* access modifiers changed from: private */
    public void c() {
        String obj = this.f3171i.getText().toString();
        String smsLoginStatExtra = PassportSDK.getInstance().getSmsLoginStatExtra();
        HashMap hashMap = new HashMap();
        if (SapiUtils.statExtraValid(smsLoginStatExtra)) {
            hashMap.put("extrajson", smsLoginStatExtra);
        }
        hashMap.put(f3164b, "pop_login");
        SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin(new i(this), this.p, obj, hashMap);
        b(f.f3187j, (String) null);
    }

    private void d() {
        if (SapiAccountManager.getInstance().getSapiConfiguration().isNightMode || SapiAccountManager.getInstance().getSapiConfiguration().isDarkMode) {
            this.f3168f.setBackgroundColor(getResources().getColor(e.c.c.a.b.sapi_sdk_sms_bg_night_mode));
            this.f3170h.setTextColor(getResources().getColor(e.c.c.a.b.sapi_sdk_sms_edit_phone_text_color_night_mode));
            this.f3170h.setHintTextColor(getResources().getColor(e.c.c.a.b.sapi_sdk_sms_edit_hint_color_night_mode));
            this.f3171i.setTextColor(getResources().getColor(e.c.c.a.b.sapi_sdk_sms_edit_check_code_text_color_night_mode));
            this.f3171i.setHintTextColor(getResources().getColor(e.c.c.a.b.sapi_sdk_sms_edit_check_code_hint_text_color_night_mode));
            this.k.setTextColor(getResources().getColor(e.c.c.a.b.sapi_sdk_sms_prompt_phone_number_error_color_night_mode));
            this.l.setBackgroundColor(getResources().getColor(e.c.c.a.b.sapi_sdk_separate_line_color_night_mode));
        }
        a(false);
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.r != null) {
            try {
                getContext().unregisterReceiver(this.r);
            } catch (Throwable unused) {
            }
        }
        this.r = null;
    }

    public SmsLoginView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.q = true;
        this.f3167e = context;
        this.s = new e(this, null);
        this.f3168f = LayoutInflater.from(context).inflate(e.c.c.a.f.layout_sapi_sdk_sms_login_view, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.sapi_sdk_sms_login_view, i2, 0);
        boolean z = obtainStyledAttributes.getBoolean(i.sapi_sdk_sms_login_view_sapi_sdk_show_keyboard, false);
        obtainStyledAttributes.recycle();
        this.f3169g = this.f3168f.findViewById(e.c.c.a.e.code_container);
        this.f3170h = (EditText) this.f3168f.findViewById(e.c.c.a.e.phone);
        this.m = this.f3168f.findViewById(e.c.c.a.e.loading_container);
        this.f3171i = (EditText) this.f3168f.findViewById(e.c.c.a.e.check_code);
        this.f3172j = (TextView) this.f3168f.findViewById(e.c.c.a.e.get_code);
        this.k = (TextView) this.f3168f.findViewById(e.c.c.a.e.prompt);
        this.l = this.f3168f.findViewById(e.c.c.a.e.separate_line);
        a(this.f3170h, context.getString(g.sapi_sdk_sms_hint_input_phone));
        a(this.f3171i, context.getString(g.sapi_sdk_sms_hint_input_check_code));
        this.f3170h.addTextChangedListener(new d(this, null));
        this.f3171i.addTextChangedListener(new a(this, null));
        this.f3172j.setEnabled(false);
        this.f3172j.setOnClickListener(new c(this, null));
        d();
        if (z) {
            new Handler().postDelayed(new h(this), 100);
        }
        if (SapiUtils.getLastLoginType() == 2) {
            String decryptStr = SapiContext.getInstance().getDecryptStr(SapiContext.KEY_LAST_LOGIN_PHONE);
            if (!TextUtils.isEmpty(decryptStr) && decryptStr.length() == 11) {
                this.f3170h.setText(decryptStr);
                this.f3170h.setSelection(decryptStr.length());
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        this.m.setVisibility(0);
        b bVar = new b(this.f3167e);
        this.n = bVar;
        bVar.show();
    }

    public static void b(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put("pop_login", str);
        HashMap hashMap = new HashMap(1);
        hashMap.put("extrajson", PassportSDK.getInstance().getSmsLoginStatExtra());
        hashMap.put("errno", str2);
        t.a(linkedHashMap, (Map<String, String>) hashMap);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        int i2;
        getResources().getColor(e.c.c.a.b.sapi_sdk_sms_get_code_text_color);
        int i3 = -1;
        if (SapiAccountManager.getInstance().getSapiConfiguration().isNightMode || SapiAccountManager.getInstance().getSapiConfiguration().isDarkMode) {
            i3 = getResources().getColor(e.c.c.a.b.sapi_sdk_sms_bg_night_mode);
            if (z) {
                i2 = getResources().getColor(e.c.c.a.b.sapi_sdk_sms_get_code_text_color_night_mode);
            } else {
                i2 = getResources().getColor(e.c.c.a.b.sapi_sdk_sms_get_code_disable_color_night_mode);
            }
        } else if (z) {
            i2 = getResources().getColor(e.c.c.a.b.sapi_sdk_sms_get_code_text_color);
        } else {
            i2 = getResources().getColor(e.c.c.a.b.sapi_sdk_sms_get_code_disable_color);
        }
        GradientDrawable gradientDrawable = (GradientDrawable) this.f3172j.getBackground();
        gradientDrawable.setStroke(SapiUtils.dip2px(getContext(), 0.5f), i2);
        gradientDrawable.setColor(i3);
        this.f3172j.setTextColor(i2);
    }

    private void a(EditText editText, String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(18, true), 0, spannableString.length(), 33);
        editText.setHint(new SpannedString(spannableString));
    }

    /* access modifiers changed from: private */
    public void a(Handler handler) {
        if (this.r == null) {
            com.baidu.sapi2.utils.g.a(this.f3167e, handler, new j(this));
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        this.m.setVisibility(8);
        try {
            this.n.dismiss();
        } catch (Throwable unused) {
        }
    }
}
