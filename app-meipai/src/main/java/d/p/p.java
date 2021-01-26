package d.p;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/* compiled from: ReportFragment */
public class p extends Fragment {

    /* renamed from: a reason: collision with root package name */
    public a f5291a;

    /* compiled from: ReportFragment */
    public interface a {
        void a();

        void b();

        void onStart();
    }

    public static void a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        String str = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
        if (fragmentManager.findFragmentByTag(str) == null) {
            fragmentManager.beginTransaction().add(new p(), str).commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a aVar = this.f5291a;
        if (aVar != null) {
            aVar.a();
        }
        a(d.p.e.a.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        a(d.p.e.a.ON_DESTROY);
        this.f5291a = null;
    }

    public void onPause() {
        super.onPause();
        a(d.p.e.a.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        a aVar = this.f5291a;
        if (aVar != null) {
            aVar.b();
        }
        a(d.p.e.a.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        a aVar = this.f5291a;
        if (aVar != null) {
            aVar.onStart();
        }
        a(d.p.e.a.ON_START);
    }

    public void onStop() {
        super.onStop();
        a(d.p.e.a.ON_STOP);
    }

    public final void a(d.p.e.a aVar) {
        Activity activity = getActivity();
        if (activity instanceof j) {
            ((j) activity).getLifecycle().a(aVar);
            return;
        }
        if (activity instanceof h) {
            e lifecycle = ((h) activity).getLifecycle();
            if (lifecycle instanceof i) {
                ((i) lifecycle).a(aVar);
            }
        }
    }
}
