package com.baidu.sapi2.share;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.List;

public class ShareModel implements Parcelable {
    public static final Creator<ShareModel> CREATOR = new o();

    /* renamed from: a reason: collision with root package name */
    public SapiAccount f2876a;

    /* renamed from: b reason: collision with root package name */
    public List<SapiAccount> f2877b;

    /* renamed from: c reason: collision with root package name */
    public ShareEvent f2878c;

    /* renamed from: d reason: collision with root package name */
    public String f2879d;

    /* renamed from: e reason: collision with root package name */
    public LoginShareStrategy f2880e;

    public ShareModel() {
        this.f2877b = new ArrayList();
    }

    public void a(List<SapiAccount> list) {
        if (list != null) {
            this.f2877b = list;
        }
    }

    public String b() {
        return this.f2879d;
    }

    public List<SapiAccount> c() {
        return this.f2877b;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder a2 = a.a("ShareModel{currentAccount=");
        a2.append(this.f2876a);
        a2.append(", shareAccounts=");
        a2.append(this.f2877b);
        a2.append(", event=");
        a2.append(this.f2878c);
        a2.append(", from='");
        a.a(a2, this.f2879d, '\'', ", senderStrategy=");
        a2.append(this.f2880e);
        a2.append('}');
        return a2.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeSerializable(this.f2878c);
        parcel.writeTypedList(this.f2877b);
        parcel.writeParcelable(this.f2876a, i2);
        parcel.writeSerializable(this.f2880e);
        parcel.writeString(this.f2879d);
    }

    public void a(LoginShareStrategy loginShareStrategy) {
        this.f2880e = loginShareStrategy;
    }

    public void b(Context context) {
        ArrayList arrayList = new ArrayList();
        for (SapiAccount b2 : c()) {
            arrayList.add(n.b(context, b2));
        }
        a((List<SapiAccount>) arrayList);
        SapiAccount sapiAccount = this.f2876a;
        if (sapiAccount != null) {
            this.f2876a = n.b(context, sapiAccount);
        }
        if (!TextUtils.isEmpty(this.f2879d)) {
            this.f2879d = n.b(context, this.f2879d);
        }
    }

    public ShareModel(Parcel parcel) {
        this.f2877b = new ArrayList();
        a(parcel);
    }

    public void a(ShareEvent shareEvent) {
        this.f2878c = shareEvent;
    }

    public ShareEvent a() {
        return this.f2878c;
    }

    public void a(SapiAccount sapiAccount) {
        this.f2876a = sapiAccount;
    }

    public ShareModel(ShareEvent shareEvent) {
        this.f2877b = new ArrayList();
        this.f2878c = shareEvent;
    }

    public void a(String str) {
        this.f2879d = str;
    }

    private void a(Parcel parcel) {
        this.f2878c = (ShareEvent) parcel.readSerializable();
        parcel.readTypedList(this.f2877b, SapiAccount.CREATOR);
        this.f2876a = (SapiAccount) parcel.readParcelable(SapiAccount.class.getClassLoader());
        this.f2880e = (LoginShareStrategy) parcel.readSerializable();
        this.f2879d = parcel.readString();
    }

    public ShareModel(ShareEvent shareEvent, SapiAccount sapiAccount) {
        this(shareEvent);
        this.f2876a = sapiAccount;
    }

    public ShareModel(ShareEvent shareEvent, SapiAccount sapiAccount, List<SapiAccount> list) {
        this(shareEvent, sapiAccount);
        this.f2877b = list;
    }

    public void a(Context context) {
        ArrayList arrayList = new ArrayList();
        for (SapiAccount a2 : c()) {
            arrayList.add(n.a(context, a2));
        }
        a((List<SapiAccount>) arrayList);
        SapiAccount sapiAccount = this.f2876a;
        if (sapiAccount != null) {
            this.f2876a = n.a(context, sapiAccount);
        }
        if (!TextUtils.isEmpty(this.f2879d)) {
            this.f2879d = n.a(context, this.f2879d);
        }
    }
}
