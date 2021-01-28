package com.cvdnn.panorama.model;

import android.frame.context.FrameActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBinding;

import static androidx.lifecycle.Lifecycle.Event.ON_CREATE;
import static androidx.lifecycle.Lifecycle.Event.ON_DESTROY;
import static androidx.lifecycle.Lifecycle.Event.ON_PAUSE;
import static androidx.lifecycle.Lifecycle.Event.ON_RESUME;

public abstract class ModelBinding<V extends ViewBinding> implements LifecycleEventObserver {
    protected V mBinding;

    public <A extends FrameActivity> void onBind(A activity) {
        mBinding = (V)activity.binding;

        activity.getLifecycle().addObserver(this);
    }

    protected void onCreate(LifecycleOwner owner) {

    }

    protected void onResume() {

    }

    protected void onPause() {

    }

    protected void onDestroy(Lifecycle lifecycle) {
        lifecycle.removeObserver(this);
    }

    @Override
    public final void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
        Lifecycle lifecycle = source.getLifecycle();
        if (event == ON_CREATE) {
            onCreate(source);

        } else if (event == ON_RESUME) {
            onResume();

        } else if (event == ON_PAUSE) {
            onPause();

        } else if (event == ON_DESTROY) {
            onDestroy(lifecycle);
        }
    }
}
