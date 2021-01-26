package com.baidu.sapi2.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ShareModel */
public class o implements Creator<ShareModel> {
    public ShareModel createFromParcel(Parcel parcel) {
        return new ShareModel(parcel);
    }

    public ShareModel[] newArray(int i2) {
        return new ShareModel[i2];
    }
}
