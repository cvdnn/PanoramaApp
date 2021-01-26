package d.n.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* compiled from: FragmentManager */
public abstract class i {

    /* renamed from: b reason: collision with root package name */
    public static final g f5126b = new g();

    /* renamed from: a reason: collision with root package name */
    public g f5127a = null;

    /* compiled from: FragmentManager */
    public static abstract class a {
        public void onFragmentActivityCreated(i iVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentAttached(i iVar, Fragment fragment, Context context) {
        }

        public void onFragmentCreated(i iVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentDestroyed(i iVar, Fragment fragment) {
        }

        public void onFragmentDetached(i iVar, Fragment fragment) {
        }

        public void onFragmentPaused(i iVar, Fragment fragment) {
        }

        public void onFragmentPreAttached(i iVar, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(i iVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentResumed(i iVar, Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(i iVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentStarted(i iVar, Fragment fragment) {
        }

        public void onFragmentStopped(i iVar, Fragment fragment) {
        }

        public abstract void onFragmentViewCreated(i iVar, Fragment fragment, View view, Bundle bundle);

        public void onFragmentViewDestroyed(i iVar, Fragment fragment) {
        }
    }

    public abstract Fragment a(Bundle bundle, String str);

    public abstract Fragment a(String str);

    public abstract List<Fragment> a();

    public abstract void a(Bundle bundle, String str, Fragment fragment);

    public abstract void a(a aVar);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean b();

    public abstract boolean c();
}
