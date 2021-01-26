package com.youth.banner.adapter;

import android.view.ViewGroup;

public interface IViewHolder<T, VH> {
    void onBindView(VH vh, T t, int i2, int i3);

    VH onCreateHolder(ViewGroup viewGroup, int i2);
}
