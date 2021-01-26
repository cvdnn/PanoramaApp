package com.arashivision.graphicpath.base;

import com.arashivision.insbase.arlog.Log;
import e.a.a.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class EglContextGroup {
    public long mEglContext;
    public long mEglContextWrap;
    public boolean mEnableDebug;
    public long mExternalGlContextShared;
    public int mGlVersion;
    public boolean mRecordable;
    public ArrayList<UserInfo> mUserInfos;

    public static class UserInfo {
        public WeakReference<Object> user;
        public int userId;

        public UserInfo(Object obj) {
            this.userId = obj.hashCode();
            this.user = new WeakReference<>(obj);
        }
    }

    public EglContextGroup() {
        this(3, false, true);
    }

    public static native long createEglContextWrap(long j2, int i2, boolean z, boolean z2);

    public static native void destroyEglContextWrap(long j2);

    public static native long getEglContextFromWrap(long j2);

    private void releaseUseless() {
        if (this.mEglContext != 0) {
            boolean z = false;
            Iterator it = this.mUserInfos.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((UserInfo) it.next()).user.get() != null) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                this.mUserInfos.clear();
                StringBuilder sb = new StringBuilder();
                sb.append("EglContextGroup destroy one context: ");
                sb.append(this.mEglContext);
                Log.i("ins", sb.toString());
                destroyEglContextWrap(this.mEglContextWrap);
                this.mEglContextWrap = 0;
                this.mEglContext = 0;
            }
        }
    }

    public synchronized long acquireEglContext(Object obj) {
        if (obj != null) {
            releaseUseless();
            if (this.mEglContext == 0) {
                long createEglContextWrap = createEglContextWrap(this.mExternalGlContextShared, this.mGlVersion, this.mEnableDebug, this.mRecordable);
                this.mEglContextWrap = createEglContextWrap;
                if (createEglContextWrap != 0) {
                    this.mEglContext = getEglContextFromWrap(createEglContextWrap);
                    StringBuilder sb = new StringBuilder();
                    sb.append("EglContextGroup create one context: ");
                    sb.append(this.mEglContext);
                    Log.i("ins", sb.toString());
                } else if (this.mExternalGlContextShared == 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("failed to create egl context, version: ");
                    sb2.append(this.mGlVersion);
                    sb2.append(", enable debug: ");
                    sb2.append(this.mEnableDebug);
                    sb2.append(", recordable: ");
                    sb2.append(this.mRecordable);
                    throw new RuntimeException(sb2.toString());
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("failed to create egl context with an external context: ");
                    sb3.append(this.mExternalGlContextShared);
                    sb3.append(" , version: ");
                    sb3.append(this.mGlVersion);
                    sb3.append(", enable debug: ");
                    sb3.append(this.mEnableDebug);
                    sb3.append(", recordable: ");
                    sb3.append(this.mRecordable);
                    throw new RuntimeException(sb3.toString());
                }
            }
            this.mUserInfos.add(new UserInfo(obj));
        } else {
            throw new NullPointerException();
        }
        return this.mEglContext;
    }

    public void finalize() throws Throwable {
        if (this.mEglContext != 0) {
            StringBuilder a2 = a.a("EglContextGroup finalize, but egl context leaked: ");
            a2.append(this.mEglContext);
            Log.e("ins", a2.toString());
            destroyEglContextWrap(this.mEglContextWrap);
            this.mEglContextWrap = 0;
            this.mEglContext = 0;
        }
        super.finalize();
    }

    public int getGlVersion() {
        return this.mGlVersion;
    }

    public synchronized void releaseEglContext(Object obj, long j2) {
        if (j2 != 0) {
            if (obj != null) {
                try {
                    if (j2 == this.mEglContext) {
                        boolean z = false;
                        Iterator it = this.mUserInfos.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((UserInfo) it.next()).userId == obj.hashCode()) {
                                    it.remove();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (z) {
                            releaseUseless();
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("releaseEglContext: no this user: ");
                        sb.append(obj);
                        sb.append(", current user count: ");
                        sb.append(this.mUserInfos.size());
                        throw new RuntimeException(sb.toString());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("releaseEglContext: wrong eglContext, expect: ");
                    sb2.append(this.mEglContext);
                    sb2.append(", got: ");
                    sb2.append(j2);
                    throw new RuntimeException(sb2.toString());
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new NullPointerException();
            }
        }
    }

    public EglContextGroup(boolean z) {
        this(3, z, true);
    }

    public EglContextGroup(int i2, boolean z, boolean z2) {
        this.mUserInfos = new ArrayList<>();
        this.mGlVersion = i2;
        this.mEnableDebug = z;
        this.mRecordable = z2;
    }

    public EglContextGroup(long j2, int i2, boolean z, boolean z2) {
        this.mUserInfos = new ArrayList<>();
        this.mExternalGlContextShared = j2;
        this.mGlVersion = i2;
        this.mEnableDebug = z;
        this.mRecordable = z2;
    }
}
