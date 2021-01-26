package d.n.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import com.arashivision.graphicpath.render.source.AssetInfo.SubMediaType;
import com.arashivision.graphicpath.render.util.GPUCapability.GPUCapabilityNumber;
import d.a.c;
import d.h.d.a.b;
import d.p.e;
import d.p.i;
import d.p.t;
import d.p.u;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentActivity */
public class d extends ComponentActivity implements b {

    /* renamed from: f reason: collision with root package name */
    public final f f5113f;

    /* renamed from: g reason: collision with root package name */
    public final i f5114g = new i(this);

    /* renamed from: h reason: collision with root package name */
    public boolean f5115h;

    /* renamed from: i reason: collision with root package name */
    public boolean f5116i;

    /* renamed from: j reason: collision with root package name */
    public boolean f5117j = true;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public d.e.i<String> o;

    /* compiled from: FragmentActivity */
    public class a extends h<d> implements u, c {
        public a() {
            super(d.this);
        }

        public void a(Fragment fragment, Intent intent, int i2, Bundle bundle) {
            d dVar = d.this;
            dVar.m = true;
            if (i2 == -1) {
                try {
                    d.h.d.a.a(dVar, intent, -1, bundle);
                } catch (Throwable th) {
                    dVar.m = false;
                    throw th;
                }
            } else {
                d.l(i2);
                d.h.d.a.a(dVar, intent, ((dVar.a(fragment) + 1) << 16) + (i2 & SubMediaType.UNDEFINED), bundle);
            }
            dVar.m = false;
        }

        public e getLifecycle() {
            return d.this.f5114g;
        }

        public t getViewModelStore() {
            return d.this.getViewModelStore();
        }

        public OnBackPressedDispatcher j() {
            return d.this.f655e;
        }

        public View a(int i2) {
            return d.this.findViewById(i2);
        }

        public boolean a() {
            Window window = d.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    public d() {
        a aVar = new a();
        a.a.a.a.b.a.a(aVar, (Object) "callbacks == null");
        this.f5113f = new f(aVar);
    }

    public static void l(int i2) {
        if ((i2 & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public final int a(Fragment fragment) {
        if (this.o.b() < 65534) {
            while (true) {
                d.e.i<String> iVar = this.o;
                int i2 = this.n;
                if (iVar.f4604a) {
                    iVar.a();
                }
                if (d.e.d.a(iVar.f4605b, iVar.f4607d, i2) >= 0) {
                    this.n = (this.n + 1) % GPUCapabilityNumber.OES_EGL_IMAGE_EXTERNAL_CAPABILITY;
                } else {
                    int i3 = this.n;
                    this.o.c(i3, fragment.mWho);
                    this.n = (this.n + 1) % GPUCapabilityNumber.OES_EGL_IMAGE_EXTERNAL_CAPABILITY;
                    return i3;
                }
            }
        } else {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
    }

    public final void b(int i2) {
        if (!this.k && i2 != -1) {
            l(i2);
        }
    }

    public i b0() {
        return this.f5113f.f5119a.f5125e;
    }

    @Deprecated
    public void c0() {
        invalidateOptionsMenu();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("  ");
        String sb2 = sb.toString();
        printWriter.print(sb2);
        printWriter.print("mCreated=");
        printWriter.print(this.f5115h);
        printWriter.print(" mResumed=");
        printWriter.print(this.f5116i);
        printWriter.print(" mStopped=");
        printWriter.print(this.f5117j);
        if (getApplication() != null) {
            d.q.a.a.a(this).a(sb2, fileDescriptor, printWriter, strArr);
        }
        this.f5113f.f5119a.f5125e.a(str, fileDescriptor, printWriter, strArr);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        this.f5113f.a();
        int i4 = i2 >> 16;
        if (i4 != 0) {
            int i5 = i4 - 1;
            String str = (String) this.o.a(i5);
            this.o.c(i5);
            String str2 = "FragmentActivity";
            if (str == null) {
                Log.w(str2, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment b2 = this.f5113f.f5119a.f5125e.b(str);
            if (b2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Activity result no fragment exists for who: ");
                sb.append(str);
                Log.w(str2, sb.toString());
            } else {
                b2.onActivityResult(i2 & SubMediaType.UNDEFINED, i3, intent);
            }
            return;
        }
        d.h.d.a.a();
        super.onActivityResult(i2, i3, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f5113f.a();
        this.f5113f.f5119a.f5125e.a(configuration);
    }

    public void onCreate(Bundle bundle) {
        h<?> hVar = this.f5113f.f5119a;
        hVar.f5125e.a((h) hVar, (e) hVar, (Fragment) null);
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            h<?> hVar2 = this.f5113f.f5119a;
            if (hVar2 instanceof u) {
                hVar2.f5125e.a(parcelable);
                String str = "android:support:next_request_index";
                if (bundle.containsKey(str)) {
                    this.n = bundle.getInt(str);
                    int[] intArray = bundle.getIntArray("android:support:request_indicies");
                    String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                    if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                        Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                    } else {
                        this.o = new d.e.i<>(intArray.length);
                        for (int i2 = 0; i2 < intArray.length; i2++) {
                            this.o.c(intArray[i2], stringArray[i2]);
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
        }
        if (this.o == null) {
            this.o = new d.e.i<>(10);
            this.n = 0;
        }
        super.onCreate(bundle);
        this.f5114g.a(d.p.e.a.ON_CREATE);
        this.f5113f.f5119a.f5125e.g();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return super.onCreatePanelMenu(i2, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i2, menu);
        f fVar = this.f5113f;
        return onCreatePanelMenu | fVar.f5119a.f5125e.a(menu, getMenuInflater());
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f5113f.f5119a.f5125e.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f5113f.f5119a.f5125e.h();
        this.f5114g.a(d.p.e.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f5113f.f5119a.f5125e.i();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.f5113f.f5119a.f5125e.b(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.f5113f.f5119a.f5125e.a(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.f5113f.f5119a.f5125e.a(z);
    }

    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.f5113f.a();
    }

    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.f5113f.f5119a.f5125e.a(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    public void onPause() {
        super.onPause();
        this.f5116i = false;
        this.f5113f.f5119a.f5125e.a(3);
        this.f5114g.a(d.p.e.a.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.f5113f.f5119a.f5125e.b(z);
    }

    public void onPostResume() {
        super.onPostResume();
        this.f5114g.a(d.p.e.a.ON_RESUME);
        j jVar = this.f5113f.f5119a.f5125e;
        jVar.u = false;
        jVar.v = false;
        jVar.a(4);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 == 0) {
            return super.onPreparePanel(0, view, menu) | this.f5113f.f5119a.f5125e.b(menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.f5113f.a();
        int i3 = (i2 >> 16) & SubMediaType.UNDEFINED;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.o.a(i4);
            this.o.c(i4);
            String str2 = "FragmentActivity";
            if (str == null) {
                Log.w(str2, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment b2 = this.f5113f.f5119a.f5125e.b(str);
            if (b2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Activity result no fragment exists for who: ");
                sb.append(str);
                Log.w(str2, sb.toString());
            } else {
                b2.onRequestPermissionsResult(i2 & SubMediaType.UNDEFINED, strArr, iArr);
            }
        }
    }

    public void onResume() {
        super.onResume();
        this.f5116i = true;
        this.f5113f.a();
        this.f5113f.f5119a.f5125e.k();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        do {
        } while (a(b0(), e.b.CREATED));
        this.f5114g.a(d.p.e.a.ON_STOP);
        Parcelable n2 = this.f5113f.f5119a.f5125e.n();
        if (n2 != null) {
            bundle.putParcelable("android:support:fragments", n2);
        }
        if (this.o.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.n);
            int[] iArr = new int[this.o.b()];
            String[] strArr = new String[this.o.b()];
            for (int i2 = 0; i2 < this.o.b(); i2++) {
                iArr[i2] = this.o.b(i2);
                strArr[i2] = (String) this.o.d(i2);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    public void onStart() {
        super.onStart();
        this.f5117j = false;
        if (!this.f5115h) {
            this.f5115h = true;
            j jVar = this.f5113f.f5119a.f5125e;
            jVar.u = false;
            jVar.v = false;
            jVar.a(2);
        }
        this.f5113f.a();
        this.f5113f.f5119a.f5125e.k();
        this.f5114g.a(d.p.e.a.ON_START);
        j jVar2 = this.f5113f.f5119a.f5125e;
        jVar2.u = false;
        jVar2.v = false;
        jVar2.a(3);
    }

    public void onStateNotSaved() {
        this.f5113f.a();
    }

    public void onStop() {
        super.onStop();
        this.f5117j = true;
        do {
        } while (a(b0(), e.b.CREATED));
        j jVar = this.f5113f.f5119a.f5125e;
        jVar.v = true;
        jVar.a(2);
        this.f5114g.a(d.p.e.a.ON_STOP);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        if (!this.m && i2 != -1) {
            l(i2);
        }
        super.startActivityForResult(intent, i2);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws SendIntentException {
        if (!this.l && i2 != -1) {
            l(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f5113f.f5119a.f5125e.onCreateView(null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (!this.m && i2 != -1) {
            l(i2);
        }
        super.startActivityForResult(intent, i2, bundle);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws SendIntentException {
        if (!this.l && i2 != -1) {
            l(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public static boolean a(i iVar, e.b bVar) {
        boolean z = false;
        for (Fragment fragment : iVar.a()) {
            if (fragment != null) {
                if (((i) fragment.getLifecycle()).f5281b.a(e.b.STARTED)) {
                    fragment.mLifecycleRegistry.a(bVar);
                    z = true;
                }
                if (fragment.getHost() != null) {
                    z |= a(fragment.getChildFragmentManager(), bVar);
                }
            }
        }
        return z;
    }
}
