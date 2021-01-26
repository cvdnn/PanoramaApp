package e.c.d.m.i.i;

import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.picapture.ui.webview.WebViewActivity;
import com.baidu.picapture.ui.widget.dialog.PolicyPromptDialog;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: PolicyPromptDialog */
public class m extends ClickableSpan {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Entry f6831a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ PolicyPromptDialog f6832b;

    public m(PolicyPromptDialog policyPromptDialog, Entry entry) {
        this.f6832b = policyPromptDialog;
        this.f6831a = entry;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f6832b.f2088b, WebViewActivity.class);
        intent.putExtra("title", (String) ((List) this.f6831a.getValue()).get(0));
        intent.putExtra("URL", (String) ((List) this.f6831a.getValue()).get(1));
        this.f6832b.f2088b.startActivity(intent);
    }
}
