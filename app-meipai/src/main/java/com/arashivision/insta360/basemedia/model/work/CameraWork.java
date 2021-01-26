package com.arashivision.insta360.basemedia.model.work;

import a.a.a.a.a.f.d.b;
import a.a.a.a.b.a;
import com.arashivision.graphicpath.render.source.Asset;
import com.arashivision.graphicpath.render.source.MetadataOption;
import com.arashivision.graphicpath.render.source.VideoAsset;
import com.arashivision.insta360.basemedia.asset.AssetUtils;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.onecamera.OneDriverInfo.RecordFormat;
import com.baidubce.BceConfig;
import com.tencent.connect.common.Constants;
import java.util.Arrays;

public class CameraWork extends Work {

    /* renamed from: lIi丨I reason: contains not printable characters */
    public static final MediaLogger f49lIiI = MediaLogger.getLogger(CameraWork.class);
    public IL1Iii ILL;

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public Long f50Ll1 = null;

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public String f51L11I;

    /* renamed from: 丨il reason: contains not printable characters */
    public String f52il;

    public interface IL1Iii {
        boolean IL1Iii(CameraWork cameraWork);
    }

    public CameraWork(String str, String[] strArr, Asset asset, IL1Iii iL1Iii) {
        super(strArr);
        this.f51L11I = str;
        this.ILL = iL1Iii;
        IL1Iii(new Asset[]{asset});
    }

    public CameraWork(String str, String[] strArr, IL1Iii iL1Iii) {
        super(strArr);
        this.f51L11I = str;
        this.ILL = iL1Iii;
        IL1Iii((Asset[]) null);
    }

    public CameraWork(String str, String[] strArr, IL1Iii iL1Iii, long j2) {
        super(strArr);
        this.f51L11I = str;
        this.ILL = iL1Iii;
        this.f50Ll1 = Long.valueOf(j2);
        IL1Iii((Asset[]) null);
    }

    public CameraWork(String str, String[] strArr, Asset[] assetArr, IL1Iii iL1Iii) {
        super(strArr);
        this.f51L11I = str;
        this.ILL = iL1Iii;
        IL1Iii(assetArr);
    }

    public int IL1Iii() {
        return MetadataOption.kVideoAll;
    }

    public Asset IL1Iii(int i2) {
        if (this.f50Ll1 != null) {
            String urlForParse = getUrlForParse(i2);
            if (a.a((CharSequence) urlForParse, (CharSequence) "insv") || a.a((CharSequence) urlForParse, (CharSequence) RecordFormat.VIDEO_FORMAT_MP4)) {
                return new VideoAsset(urlForParse, this.f50Ll1.longValue());
            }
        }
        return super.IL1Iii(i2);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CameraWork)) {
            return false;
        }
        return Arrays.equals(getUrls(), ((CameraWork) obj).getUrls());
    }

    public long getCreationTime(int i2) {
        a.a.a.a.a.f.a.a[] aVarArr = this.f56IL;
        if (aVarArr[i2].n == null || aVarArr[i2].n.longValue() <= 0) {
            this.f56IL[i2].n = Long.valueOf(AssetUtils.getCreationTime(this.Ilil[i2]));
            if (this.f56IL[i2].n.longValue() <= 0) {
                this.f56IL[i2].n = Long.valueOf(b.a(getName(i2)));
            }
        }
        return this.f56IL[i2].n.longValue();
    }

    public String getName(int i2) {
        if (this.f52il == null) {
            String urlForParse = getUrlForParse(i2);
            String substring = urlForParse.substring(urlForParse.lastIndexOf(BceConfig.BOS_DELIMITER) + 1, urlForParse.length());
            String str = "LRV";
            if (substring.startsWith(str)) {
                substring = substring.replace(str, "VID");
                String str2 = "_";
                String[] split = substring.split(str2);
                if (split.length == 5) {
                    String str3 = split[3];
                    if (str3.equals("01")) {
                        str3 = "00";
                    } else if (str3.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                        str3 = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(split[0]);
                    sb.append(str2);
                    sb.append(split[1]);
                    sb.append(str2);
                    e.a.a.a.a.a(sb, split[2], str2, str3, str2);
                    sb.append(split[4]);
                    substring = sb.toString();
                }
            }
            this.f52il = substring;
        }
        return this.f52il;
    }

    public String[] getRawUrls() {
        String[] strArr = this.ILil;
        if (strArr == null) {
            return null;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f51L11I);
            sb.append(this.ILil[i2]);
            strArr2[i2] = sb.toString();
        }
        return strArr2;
    }

    public String[] getRawUrlsForPlay(int i2) {
        String[] strArr = this.ILil;
        if (strArr == null) {
            return null;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f51L11I);
            sb.append(this.ILil[i3]);
            strArr2[i3] = sb.toString();
        }
        return strArr2;
    }

    public long getTotalSize() {
        if (!isPhoto(0)) {
            return isDualStream(0) ? AssetUtils.getFileSize(this.Ilil[0]) * 2 : AssetUtils.getFileSize(this.Ilil[0]);
        }
        long fileSize = AssetUtils.getFileSize(this.Ilil[0]);
        return (((long) getUrls().length) * fileSize) + ((getRawUrls() == null || getRawUrls().length <= 0) ? 0 : fileSize * 10 * ((long) getRawUrls().length));
    }

    public String getUrlForParse(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f51L11I);
        sb.append(this.IL1Iii[i2]);
        return sb.toString();
    }

    public String[] getUrls() {
        int length = this.IL1Iii.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f51L11I);
            sb.append(this.IL1Iii[i2]);
            strArr[i2] = sb.toString();
        }
        return strArr;
    }

    public String[] getUrlsForPlay(int i2) {
        if (isHDRPhoto(i2) || isSuperNight(i2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f51L11I);
            sb.append(this.IL1Iii[0]);
            return new String[]{sb.toString()};
        } else if (isIntervalShooting(i2) || isBurst(i2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f51L11I);
            sb2.append(this.IL1Iii[i2]);
            return new String[]{sb2.toString()};
        } else if (this.IL1Iii.length <= 1 || getFileType(i2) != FileType.UNPANORAMA) {
            int length = this.IL1Iii.length;
            String[] strArr = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.f51L11I);
                sb3.append(this.IL1Iii[i3]);
                strArr[i3] = sb3.toString();
            }
            return strArr;
        } else {
            f49lIiI.e("getUrlsForPlay, but more than one url is associated with an unpanorama file");
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.f51L11I);
            sb4.append(this.IL1Iii[0]);
            return new String[]{sb4.toString()};
        }
    }

    public boolean isInstaMedia(int i2) {
        return true;
    }

    public boolean isValid() {
        IL1Iii iL1Iii = this.ILL;
        if (iL1Iii != null) {
            return iL1Iii.IL1Iii(this);
        }
        return true;
    }

    public synchronized void save(int i2, com.arashivision.insta360.basemedia.model.work.Work.IL1Iii iL1Iii) {
        if (iL1Iii != null) {
            iL1Iii.IL1Iii(this, 0);
        }
    }
}
