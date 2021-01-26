package e.g.a.a.h0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputLayout.f;
import e.g.a.a.e;
import e.g.a.a.i;

/* compiled from: ClearTextEndIconDelegate */
public class a extends n {

    /* renamed from: d reason: collision with root package name */
    public final TextWatcher f8159d = new C0108a();

    /* renamed from: e reason: collision with root package name */
    public final f f8160e = new b();

    /* renamed from: f reason: collision with root package name */
    public AnimatorSet f8161f;

    /* renamed from: g reason: collision with root package name */
    public ValueAnimator f8162g;

    /* renamed from: e.g.a.a.h0.a$a reason: collision with other inner class name */
    /* compiled from: ClearTextEndIconDelegate */
    public class C0108a implements TextWatcher {
        public C0108a() {
        }

        public void afterTextChanged(Editable editable) {
            if (!(editable.length() > 0)) {
                a.this.f8161f.cancel();
                a.this.f8162g.start();
            } else if (!a.this.f8189a.g()) {
                a.this.f8162g.cancel();
                a.this.f8161f.start();
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* compiled from: ClearTextEndIconDelegate */
    public class b implements f {
        public b() {
        }

        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.getText().length() > 0);
            textInputLayout.setEndIconCheckable(false);
            editText.removeTextChangedListener(a.this.f8159d);
            editText.addTextChangedListener(a.this.f8159d);
        }
    }

    /* compiled from: ClearTextEndIconDelegate */
    public class c implements OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            a.this.f8189a.getEditText().setText(null);
        }
    }

    public a(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public void a() {
        this.f8189a.setEndIconDrawable(d.b.l.a.a.b(this.f8190b, e.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.f8189a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(i.clear_text_end_icon_content_description));
        this.f8189a.setEndIconOnClickListener(new c());
        this.f8189a.a(this.f8160e);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        ofFloat.setInterpolator(e.g.a.a.l.a.f8220d);
        ofFloat.setDuration(150);
        ofFloat.addUpdateListener(new e(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat2.setInterpolator(e.g.a.a.l.a.f8217a);
        ofFloat2.setDuration(100);
        ofFloat2.addUpdateListener(new d(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f8161f = animatorSet;
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        this.f8161f.addListener(new b(this));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat3.setInterpolator(e.g.a.a.l.a.f8217a);
        ofFloat3.setDuration(100);
        ofFloat3.addUpdateListener(new d(this));
        this.f8162g = ofFloat3;
        ofFloat3.addListener(new c(this));
    }
}
