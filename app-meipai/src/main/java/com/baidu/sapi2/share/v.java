package com.baidu.sapi2.share;

import android.content.Intent;
import java.util.Comparator;
import java.util.Map.Entry;

/* compiled from: ShareUtils */
public class v implements Comparator<Entry<Intent, Integer>> {
    /* renamed from: a */
    public int compare(Entry<Intent, Integer> entry, Entry<Intent, Integer> entry2) {
        return ((Integer) entry.getValue()).compareTo((Integer) entry2.getValue());
    }
}
