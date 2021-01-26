package e.g.a.a.h0;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputLayout.f;
import com.google.android.material.textfield.TextInputLayout.g;
import e.g.a.a.e;
import e.g.a.a.i;

/* compiled from: PasswordToggleEndIconDelegate */
public class q extends n {

    /* renamed from: d reason: collision with root package name */
    public final TextWatcher f8207d = new a();

    /* renamed from: e reason: collision with root package name */
    public final f f8208e = new b();

    /* renamed from: f reason: collision with root package name */
    public final g f8209f = new c(this);

    /* compiled from: PasswordToggleEndIconDelegate */
    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            q qVar = q.this;
            qVar.f8191c.setChecked(!q.a(qVar));
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate */
    public class b implements f {
        public b() {
        }

        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            q qVar = q.this;
            qVar.f8191c.setChecked(!q.a(qVar));
            editText.removeTextChangedListener(q.this.f8207d);
            editText.addTextChangedListener(q.this.f8207d);
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate */
    public class c implements g {
        public c(q qVar) {
        }

        public void a(TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i2 == 1) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate */
    public class d implements OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            EditText editText = q.this.f8189a.getEditText();
            if (editText != null) {
                int selectionEnd = editText.getSelectionEnd();
                if (q.a(q.this)) {
                    editText.setTransformationMethod(null);
                } else {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
            }
        }
    }

    public q(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public void a() {
        this.f8189a.setEndIconDrawable(d.b.l.a.a.b(this.f8190b, e.design_password_eye));
        TextInputLayout textInputLayout = this.f8189a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(i.password_toggle_content_description));
        this.f8189a.setEndIconOnClickListener(new d());
        this.f8189a.a(this.f8208e);
        TextInputLayout textInputLayout2 = this.f8189a;
        textInputLayout2.Q.add(this.f8209f);
    }

    public static /* synthetic */ boolean a(q qVar) {
        EditText editText = qVar.f8189a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }
}
