package com.deepai.library.support.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class DBaseAdapter<T> extends BaseAdapter {
    public Context context;
    public LayoutInflater inflater;
    public List<T> list;
    public String type;

    public abstract View createView(int i, View view, ViewGroup viewGroup);

    public DBaseAdapter(List<T> list2, Context context2) {
        this.list = list2;
        this.context = context2;
        this.inflater = LayoutInflater.from(context2);
    }

    public DBaseAdapter(List<T> list2, String type2, Context context2) {
        this.list = list2;
        this.type = type2;
        this.context = context2;
        this.inflater = LayoutInflater.from(context2);
    }

    public int getCount() {
        if (this.list == null || this.list.isEmpty()) {
            return 0;
        }
        return this.list.size();
    }

    public Object getItem(int position) {
        return this.list.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }
}
