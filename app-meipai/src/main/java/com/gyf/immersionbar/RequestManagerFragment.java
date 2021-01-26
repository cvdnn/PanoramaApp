package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;

public final class RequestManagerFragment extends Fragment {
    public ImmersionDelegate mDelegate;

    public ImmersionBar get(Object obj) {
        if (this.mDelegate == null) {
            this.mDelegate = new ImmersionDelegate(obj);
        }
        return this.mDelegate.get();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onActivityCreated(getResources().getConfiguration());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onConfigurationChanged(configuration);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onDestroy();
            this.mDelegate = null;
        }
    }

    public void onResume() {
        super.onResume();
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onResume();
        }
    }

    public ImmersionBar get(Activity activity, Dialog dialog) {
        if (this.mDelegate == null) {
            this.mDelegate = new ImmersionDelegate(activity, dialog);
        }
        return this.mDelegate.get();
    }
}
