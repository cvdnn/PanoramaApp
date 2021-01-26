package com.baidu.sapi2;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.baidu.sapi2.p reason: case insensitive filesystem */
/* compiled from: SapiAccount */
public class C0177p implements Creator<SapiAccount> {
    public SapiAccount createFromParcel(Parcel parcel) {
        return new SapiAccount(parcel);
    }

    public SapiAccount[] newArray(int i2) {
        return new SapiAccount[i2];
    }
}
