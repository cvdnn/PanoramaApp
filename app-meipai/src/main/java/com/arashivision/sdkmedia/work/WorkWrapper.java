package com.arashivision.sdkmedia.work;

import android.text.TextUtils;
import com.arashivision.insta360.basemedia.asset.GyroInfo;
import com.arashivision.insta360.basemedia.model.work.CameraWork;
import com.arashivision.insta360.basemedia.model.work.LocalWork;
import com.arashivision.insta360.basemedia.model.work.Work;
import com.arashivision.insta360.basemedia.util.MD5Util;
import java.util.UUID;

public class WorkWrapper implements Comparable<WorkWrapper> {

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public Work f358O8oO888;

    public WorkWrapper(Work work) {
        this.f358O8oO888 = work;
    }

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public static boolean m69O8oO888(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().matches("^((https|http|ftp|rtsp|mms)?://).*");
    }

    public int compareTo(Object obj) {
        WorkWrapper workWrapper = (WorkWrapper) obj;
        Work work = this.f358O8oO888;
        if (work != null) {
            return work.compareTo(workWrapper.f358O8oO888);
        }
        return -1;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkWrapper) || !TextUtils.equals(((WorkWrapper) obj).getIdenticalKey(), getIdenticalKey())) {
            z = false;
        }
        return z;
    }

    public int getBitrate() {
        Work work = this.f358O8oO888;
        if (work != null) {
            return work.getBitrate();
        }
        return 0;
    }

    public long getCreationTime() {
        Work work = this.f358O8oO888;
        if (work != null) {
            return work.getCreationTime();
        }
        return 0;
    }

    public double getFps() {
        Work work = this.f358O8oO888;
        if (work != null) {
            return work.getFps();
        }
        return 0.0d;
    }

    public GyroInfo[] getGyroInfo() {
        Work work = this.f358O8oO888;
        return work != null ? work.getGyroInfo() : new GyroInfo[0];
    }

    public int getHeight() {
        Work work = this.f358O8oO888;
        if (work != null) {
            return work.getHeight();
        }
        return 0;
    }

    public String getIdenticalKey() {
        Work work = this.f358O8oO888;
        return MD5Util.getMD5String(work != null ? work.getIdenticalKey() : UUID.randomUUID().toString());
    }

    public String[] getUrls() {
        Work work = this.f358O8oO888;
        return work != null ? work.getUrls() : new String[0];
    }

    public int getWidth() {
        Work work = this.f358O8oO888;
        if (work != null) {
            return work.getWidth();
        }
        return 0;
    }

    public int hashCode() {
        return getIdenticalKey().hashCode();
    }

    public boolean isCameraFile() {
        Work work = this.f358O8oO888;
        return work != null && (work instanceof CameraWork);
    }

    public boolean isHDRPhoto() {
        Work work = this.f358O8oO888;
        return work != null && work.isHDRPhoto();
    }

    public boolean isHDRVideo() {
        Work work = this.f358O8oO888;
        return work != null && work.isHDRVideo();
    }

    public boolean isLocalFile() {
        Work work = this.f358O8oO888;
        return work != null && (work instanceof LocalWork);
    }

    public boolean isPhoto() {
        Work work = this.f358O8oO888;
        return work != null && work.isPhoto();
    }

    public boolean isVideo() {
        Work work = this.f358O8oO888;
        return work != null && work.isVideo();
    }

    public String toString() {
        Work work = this.f358O8oO888;
        return work != null ? work.toString() : super.toString();
    }

    public WorkWrapper(String str) {
        this(new String[]{str});
    }

    public WorkWrapper(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            if (m69O8oO888(strArr[0])) {
                this.f358O8oO888 = new CameraWork("", strArr, null);
            } else {
                this.f358O8oO888 = new LocalWork(strArr);
            }
        }
    }
}
