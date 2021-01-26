package d.b.p;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* compiled from: AppCompatTextClassifierHelper */
public final class x {

    /* renamed from: a reason: collision with root package name */
    public TextView f4482a;

    /* renamed from: b reason: collision with root package name */
    public TextClassifier f4483b;

    public x(TextView textView) {
        if (textView != null) {
            this.f4482a = textView;
            return;
        }
        throw null;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f4483b;
        if (textClassifier == null) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) this.f4482a.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            textClassifier = TextClassifier.NO_OP;
        }
        return textClassifier;
    }
}
