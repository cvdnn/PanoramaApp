package e.c.d.m.i.i;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.baidu.picapture.ui.widget.dialog.InputDialog;

/* compiled from: InputDialog */
public class l implements TextWatcher {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ InputDialog f6830a;

    public l(InputDialog inputDialog) {
        this.f6830a = inputDialog;
    }

    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable.toString().trim())) {
            this.f6830a.f2031e.setEnabled(false);
        } else {
            this.f6830a.f2031e.setEnabled(true);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
