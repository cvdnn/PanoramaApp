package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.Fragment;
import d.n.a.c;
import d.n.a.d;
import d.n.a.i;
import d.n.a.j;
import e.a.a.a.a;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever implements Callback {
    public static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    public static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    public Handler mHandler;
    public final Map<FragmentManager, RequestManagerFragment> mPendingFragments;
    public final Map<i, SupportRequestManagerFragment> mPendingSupportFragments;
    public String mTag;

    public static class Holder {
        public static final RequestManagerRetriever INSTANCE = new RequestManagerRetriever();
    }

    public static <T> void checkNotNull(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
    }

    private RequestManagerFragment getFragment(FragmentManager fragmentManager, String str) {
        return getFragment(fragmentManager, str, false);
    }

    public static RequestManagerRetriever getInstance() {
        return Holder.INSTANCE;
    }

    private SupportRequestManagerFragment getSupportFragment(i iVar, String str) {
        return getSupportFragment(iVar, str, false);
    }

    public void destroy(Fragment fragment, boolean z) {
        String str;
        if (fragment != null) {
            String str2 = this.mTag;
            if (z) {
                StringBuilder a2 = a.a(str2);
                a2.append(fragment.getClass().getName());
                str = a2.toString();
            } else {
                StringBuilder a3 = a.a(str2);
                a3.append(System.identityHashCode(fragment));
                str = a3.toString();
            }
            getSupportFragment(fragment.getChildFragmentManager(), str, true);
        }
    }

    public ImmersionBar get(Activity activity) {
        checkNotNull(activity, "activity is null");
        StringBuilder sb = new StringBuilder();
        sb.append(this.mTag);
        sb.append(System.identityHashCode(activity));
        String sb2 = sb.toString();
        if (activity instanceof d) {
            return getSupportFragment(((d) activity).b0(), sb2).get(activity);
        }
        return getFragment(activity.getFragmentManager(), sb2).get(activity);
    }

    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            this.mPendingFragments.remove((FragmentManager) message.obj);
            return true;
        } else if (i2 != 2) {
            return false;
        } else {
            this.mPendingSupportFragments.remove((i) message.obj);
            return true;
        }
    }

    public RequestManagerRetriever() {
        this.mTag = ImmersionBar.class.getName();
        this.mPendingFragments = new HashMap();
        this.mPendingSupportFragments = new HashMap();
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    private RequestManagerFragment getFragment(FragmentManager fragmentManager, String str, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (requestManagerFragment == null) {
            requestManagerFragment = (RequestManagerFragment) this.mPendingFragments.get(fragmentManager);
            if (requestManagerFragment == null) {
                if (z) {
                    return null;
                }
                requestManagerFragment = new RequestManagerFragment();
                this.mPendingFragments.put(fragmentManager, requestManagerFragment);
                fragmentManager.beginTransaction().add(requestManagerFragment, str).commitAllowingStateLoss();
                this.mHandler.obtainMessage(1, fragmentManager).sendToTarget();
            }
        }
        if (!z) {
            return requestManagerFragment;
        }
        fragmentManager.beginTransaction().remove(requestManagerFragment).commitAllowingStateLoss();
        return null;
    }

    private SupportRequestManagerFragment getSupportFragment(i iVar, String str, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) iVar.a(str);
        if (supportRequestManagerFragment == null) {
            supportRequestManagerFragment = (SupportRequestManagerFragment) this.mPendingSupportFragments.get(iVar);
            if (supportRequestManagerFragment == null) {
                if (z) {
                    return null;
                }
                supportRequestManagerFragment = new SupportRequestManagerFragment();
                this.mPendingSupportFragments.put(iVar, supportRequestManagerFragment);
                d.n.a.a aVar = new d.n.a.a((j) iVar);
                aVar.a(0, supportRequestManagerFragment, str, 1);
                aVar.a();
                this.mHandler.obtainMessage(2, iVar).sendToTarget();
            }
        }
        if (!z) {
            return supportRequestManagerFragment;
        }
        d.n.a.a aVar2 = new d.n.a.a((j) iVar);
        aVar2.a((Fragment) supportRequestManagerFragment);
        aVar2.a();
        return null;
    }

    public void destroy(Activity activity, Dialog dialog) {
        if (activity != null && dialog != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mTag);
            sb.append(System.identityHashCode(dialog));
            String sb2 = sb.toString();
            if (activity instanceof d) {
                SupportRequestManagerFragment supportFragment = getSupportFragment(((d) activity).b0(), sb2, true);
                if (supportFragment != null) {
                    supportFragment.get(activity, dialog).onDestroy();
                    return;
                }
                return;
            }
            RequestManagerFragment fragment = getFragment(activity.getFragmentManager(), sb2, true);
            if (fragment != null) {
                fragment.get(activity, dialog).onDestroy();
            }
        }
    }

    public ImmersionBar get(Fragment fragment, boolean z) {
        String str;
        checkNotNull(fragment, "fragment is null");
        checkNotNull(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof c) {
            checkNotNull(((c) fragment).f5109h, "fragment.getDialog() is null");
        }
        String str2 = this.mTag;
        if (z) {
            StringBuilder a2 = a.a(str2);
            a2.append(fragment.getClass().getName());
            str = a2.toString();
        } else {
            StringBuilder a3 = a.a(str2);
            a3.append(System.identityHashCode(fragment));
            str = a3.toString();
        }
        return getSupportFragment(fragment.getChildFragmentManager(), str).get(fragment);
    }

    public ImmersionBar get(android.app.Fragment fragment, boolean z) {
        String str;
        checkNotNull(fragment, "fragment is null");
        checkNotNull(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            checkNotNull(((DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str2 = this.mTag;
        if (z) {
            StringBuilder a2 = a.a(str2);
            a2.append(fragment.getClass().getName());
            str = a2.toString();
        } else {
            StringBuilder a3 = a.a(str2);
            a3.append(System.identityHashCode(fragment));
            str = a3.toString();
        }
        return getFragment(fragment.getChildFragmentManager(), str).get(fragment);
    }

    public ImmersionBar get(Activity activity, Dialog dialog) {
        checkNotNull(activity, "activity is null");
        checkNotNull(dialog, "dialog is null");
        StringBuilder sb = new StringBuilder();
        sb.append(this.mTag);
        sb.append(System.identityHashCode(dialog));
        String sb2 = sb.toString();
        if (activity instanceof d) {
            return getSupportFragment(((d) activity).b0(), sb2).get(activity, dialog);
        }
        return getFragment(activity.getFragmentManager(), sb2).get(activity, dialog);
    }
}
