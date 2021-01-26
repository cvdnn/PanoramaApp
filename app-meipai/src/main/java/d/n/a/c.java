package d.n.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import d.n.a.j.h;
import d.n.a.j.i;

/* compiled from: DialogFragment */
public class c extends Fragment implements OnCancelListener, OnDismissListener {

    /* renamed from: a reason: collision with root package name */
    public Handler f5102a;

    /* renamed from: b reason: collision with root package name */
    public Runnable f5103b = new a();

    /* renamed from: c reason: collision with root package name */
    public int f5104c = 0;

    /* renamed from: d reason: collision with root package name */
    public int f5105d = 0;

    /* renamed from: e reason: collision with root package name */
    public boolean f5106e = true;

    /* renamed from: f reason: collision with root package name */
    public boolean f5107f = true;

    /* renamed from: g reason: collision with root package name */
    public int f5108g = -1;

    /* renamed from: h reason: collision with root package name */
    public Dialog f5109h;

    /* renamed from: i reason: collision with root package name */
    public boolean f5110i;

    /* renamed from: j reason: collision with root package name */
    public boolean f5111j;
    public boolean k;

    /* compiled from: DialogFragment */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            c cVar = c.this;
            Dialog dialog = cVar.f5109h;
            if (dialog != null) {
                cVar.onDismiss(dialog);
            }
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f5107f) {
            View view = getView();
            if (view != null) {
                if (view.getParent() == null) {
                    this.f5109h.setContentView(view);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            d activity = getActivity();
            if (activity != null) {
                this.f5109h.setOwnerActivity(activity);
            }
            this.f5109h.setCancelable(this.f5106e);
            this.f5109h.setOnCancelListener(this);
            this.f5109h.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f5109h.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (!this.k) {
            this.f5111j = false;
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5102a = new Handler();
        this.f5107f = this.mContainerId == 0;
        if (bundle != null) {
            this.f5104c = bundle.getInt("android:style", 0);
            this.f5105d = bundle.getInt("android:theme", 0);
            this.f5106e = bundle.getBoolean("android:cancelable", true);
            this.f5107f = bundle.getBoolean("android:showsDialog", this.f5107f);
            this.f5108g = bundle.getInt("android:backStackId", -1);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.f5109h;
        if (dialog != null) {
            this.f5110i = true;
            dialog.setOnDismissListener(null);
            this.f5109h.dismiss();
            if (!this.f5111j) {
                onDismiss(this.f5109h);
            }
            this.f5109h = null;
        }
    }

    public void onDetach() {
        super.onDetach();
        if (!this.k && !this.f5111j) {
            this.f5111j = true;
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f5110i && !this.f5111j) {
            this.f5111j = true;
            this.k = false;
            Dialog dialog = this.f5109h;
            if (dialog != null) {
                dialog.setOnDismissListener(null);
                this.f5109h.dismiss();
            }
            this.f5110i = true;
            if (this.f5108g >= 0) {
                i requireFragmentManager = requireFragmentManager();
                int i2 = this.f5108g;
                j jVar = (j) requireFragmentManager;
                if (jVar == null) {
                    throw null;
                } else if (i2 >= 0) {
                    jVar.a((h) new i(null, i2, 1), false);
                    this.f5108g = -1;
                } else {
                    throw new IllegalArgumentException(e.a.a.a.a.a("Bad id: ", i2));
                }
            } else {
                j jVar2 = (j) requireFragmentManager();
                if (jVar2 != null) {
                    a aVar = new a(jVar2);
                    aVar.a((Fragment) this);
                    aVar.a();
                    return;
                }
                throw null;
            }
        }
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        if (!this.f5107f) {
            return super.onGetLayoutInflater(bundle);
        }
        Dialog dialog = new Dialog(requireContext(), this.f5105d);
        this.f5109h = dialog;
        String str = "layout_inflater";
        if (dialog == null) {
            return (LayoutInflater) this.mHost.f5122b.getSystemService(str);
        }
        int i2 = this.f5104c;
        if (!(i2 == 1 || i2 == 2)) {
            if (i2 == 3) {
                dialog.getWindow().addFlags(24);
            }
            return (LayoutInflater) this.f5109h.getContext().getSystemService(str);
        }
        dialog.requestWindowFeature(1);
        return (LayoutInflater) this.f5109h.getContext().getSystemService(str);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.f5109h;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        int i2 = this.f5104c;
        if (i2 != 0) {
            bundle.putInt("android:style", i2);
        }
        int i3 = this.f5105d;
        if (i3 != 0) {
            bundle.putInt("android:theme", i3);
        }
        boolean z = this.f5106e;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.f5107f;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i4 = this.f5108g;
        if (i4 != -1) {
            bundle.putInt("android:backStackId", i4);
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.f5109h;
        if (dialog != null) {
            this.f5110i = false;
            dialog.show();
        }
    }

    public void onStop() {
        super.onStop();
        Dialog dialog = this.f5109h;
        if (dialog != null) {
            dialog.hide();
        }
    }
}
