package com.arashivision.insbase.nativeref;

import com.arashivision.insbase.NativeLibsLoader;
import com.arashivision.insbase.arlog.Log;
import e.a.a.a.a;

public class NativeObjectRef {
    public boolean mMoved;
    public String mName = "Unknown";
    public boolean mRequireFreeManually;
    public long mWrapPtr;

    static {
        NativeLibsLoader.load();
    }

    public NativeObjectRef(long j2, String str) {
        this.mWrapPtr = j2;
        this.mName = str;
    }

    private void doFree(boolean z) {
        if (!this.mMoved && this.mWrapPtr != 0) {
            if (z && this.mRequireFreeManually) {
                StringBuilder a2 = a.a("Freeing NativeObjectRef: ");
                a2.append(this.mName);
                a2.append("(");
                a2.append(this.mWrapPtr);
                a2.append(") in finalize! but this object require free manually!!!");
                Log.e("ins", a2.toString());
            }
            nativeFree();
            this.mWrapPtr = 0;
        }
    }

    private native void nativeFree();

    private native boolean nativeHasSameNativeObject(NativeObjectRef nativeObjectRef);

    public void finalize() throws Throwable {
        doFree(true);
        super.finalize();
    }

    public void free() {
        doFree(false);
    }

    public String getName() {
        return this.mName;
    }

    public long getWrapPtr() {
        return this.mWrapPtr;
    }

    public boolean hasSameNativeObject(Object obj) {
        if (obj != null && (obj instanceof NativeObjectRef)) {
            return nativeHasSameNativeObject((NativeObjectRef) obj);
        }
        return false;
    }

    public boolean isMoved() {
        return this.mMoved;
    }

    public long moveGetWrapPtr() {
        if (!this.mMoved) {
            this.mMoved = true;
            long j2 = this.mWrapPtr;
            this.mWrapPtr = 0;
            return j2;
        }
        throw new RuntimeException(a.a(new StringBuilder(), this.mName, " has moved"));
    }

    public void setRequireFreeManually() {
        this.mRequireFreeManually = true;
    }

    public void setRequireFreeManually(boolean z) {
        this.mRequireFreeManually = z;
    }
}
