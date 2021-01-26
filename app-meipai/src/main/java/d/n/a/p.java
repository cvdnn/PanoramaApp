package d.n.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;

@SuppressLint({"BanParcelableUsage"})
/* compiled from: FragmentState */
public final class p implements Parcelable {
    public static final Creator<p> CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    public final String f5179a;

    /* renamed from: b reason: collision with root package name */
    public final String f5180b;

    /* renamed from: c reason: collision with root package name */
    public final boolean f5181c;

    /* renamed from: d reason: collision with root package name */
    public final int f5182d;

    /* renamed from: e reason: collision with root package name */
    public final int f5183e;

    /* renamed from: f reason: collision with root package name */
    public final String f5184f;

    /* renamed from: g reason: collision with root package name */
    public final boolean f5185g;

    /* renamed from: h reason: collision with root package name */
    public final boolean f5186h;

    /* renamed from: i reason: collision with root package name */
    public final boolean f5187i;

    /* renamed from: j reason: collision with root package name */
    public final Bundle f5188j;
    public final boolean k;
    public final int l;
    public Bundle m;
    public Fragment n;

    /* compiled from: FragmentState */
    public static class a implements Creator<p> {
        public Object createFromParcel(Parcel parcel) {
            return new p(parcel);
        }

        public Object[] newArray(int i2) {
            return new p[i2];
        }
    }

    public p(Fragment fragment) {
        this.f5179a = fragment.getClass().getName();
        this.f5180b = fragment.mWho;
        this.f5181c = fragment.mFromLayout;
        this.f5182d = fragment.mFragmentId;
        this.f5183e = fragment.mContainerId;
        this.f5184f = fragment.mTag;
        this.f5185g = fragment.mRetainInstance;
        this.f5186h = fragment.mRemoving;
        this.f5187i = fragment.mDetached;
        this.f5188j = fragment.mArguments;
        this.k = fragment.mHidden;
        this.l = fragment.mMaxState.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f5179a);
        sb.append(" (");
        sb.append(this.f5180b);
        sb.append(")}:");
        if (this.f5181c) {
            sb.append(" fromLayout");
        }
        if (this.f5183e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f5183e));
        }
        String str = this.f5184f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f5184f);
        }
        if (this.f5185g) {
            sb.append(" retainInstance");
        }
        if (this.f5186h) {
            sb.append(" removing");
        }
        if (this.f5187i) {
            sb.append(" detached");
        }
        if (this.k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5179a);
        parcel.writeString(this.f5180b);
        parcel.writeInt(this.f5181c ? 1 : 0);
        parcel.writeInt(this.f5182d);
        parcel.writeInt(this.f5183e);
        parcel.writeString(this.f5184f);
        parcel.writeInt(this.f5185g ? 1 : 0);
        parcel.writeInt(this.f5186h ? 1 : 0);
        parcel.writeInt(this.f5187i ? 1 : 0);
        parcel.writeBundle(this.f5188j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeBundle(this.m);
        parcel.writeInt(this.l);
    }

    public p(Parcel parcel) {
        this.f5179a = parcel.readString();
        this.f5180b = parcel.readString();
        boolean z = true;
        this.f5181c = parcel.readInt() != 0;
        this.f5182d = parcel.readInt();
        this.f5183e = parcel.readInt();
        this.f5184f = parcel.readString();
        this.f5185g = parcel.readInt() != 0;
        this.f5186h = parcel.readInt() != 0;
        this.f5187i = parcel.readInt() != 0;
        this.f5188j = parcel.readBundle();
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.k = z;
        this.m = parcel.readBundle();
        this.l = parcel.readInt();
    }
}
