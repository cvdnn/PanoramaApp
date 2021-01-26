package e.l.a.n;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import com.yanzhenjie.permission.task.WaitDialog;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: TaskExecutor */
public abstract class a extends AsyncTask<Void, Void, List<String>> {

    /* renamed from: b reason: collision with root package name */
    public static Executor f8974b = Executors.newSingleThreadExecutor();

    /* renamed from: a reason: collision with root package name */
    public Dialog f8975a;

    public a(Context context) {
        WaitDialog waitDialog = new WaitDialog(context);
        this.f8975a = waitDialog;
        waitDialog.setCancelable(false);
    }

    public abstract void a(List<String> list);

    public void onPostExecute(Object obj) {
        List list = (List) obj;
        if (this.f8975a.isShowing()) {
            this.f8975a.dismiss();
        }
        a(list);
    }

    public final void onPreExecute() {
        if (!this.f8975a.isShowing()) {
            this.f8975a.show();
        }
    }
}
