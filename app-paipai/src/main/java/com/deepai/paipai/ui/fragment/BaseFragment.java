package com.deepai.paipai.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.deepai.paipai.ui.activity.basic.BaseActivity;

public class BaseFragment extends Fragment {
    public BaseActivity activity;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onAttach(Activity activity2) {
        super.onAttach(activity2);
        this.activity = (BaseActivity) activity2;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
