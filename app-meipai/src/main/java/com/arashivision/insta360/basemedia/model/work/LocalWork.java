package com.arashivision.insta360.basemedia.model.work;

import a.a.a.a.a.f.a.a;
import a.a.a.a.a.f.d.b;
import com.arashivision.graphicpath.render.source.Asset;
import com.arashivision.graphicpath.render.source.MetadataOption;
import com.arashivision.insta360.basemedia.asset.AssetUtils;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.model.work.Work.IL1Iii;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.Arrays;

public class LocalWork extends Work {
    public static final MediaLogger ILL = MediaLogger.getLogger(LocalWork.class);

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public String f53L11I;

    /* renamed from: 丨il reason: contains not printable characters */
    public long f54il;

    public LocalWork(String[] strArr) {
        super(strArr);
        IL1Iii((Asset[]) null);
    }

    public LocalWork(String[] strArr, Asset asset) {
        super(strArr);
        IL1Iii(new Asset[]{asset});
    }

    public LocalWork(String[] strArr, Asset[] assetArr) {
        super(strArr);
        IL1Iii(assetArr);
    }

    public int IL1Iii() {
        return MetadataOption.kAll;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof LocalWork)) {
            return false;
        }
        return Arrays.equals(getUrls(), ((LocalWork) obj).getUrls());
    }

    public long getCreationTime(int i2) {
        Long l;
        a aVar;
        a[] aVarArr = this.f56IL;
        if (aVarArr[i2].n == null || aVarArr[i2].n.longValue() <= 0) {
            if (isInstaMedia(i2)) {
                aVar = this.f56IL[i2];
                l = Long.valueOf(AssetUtils.getCreationTime(this.Ilil[i2]));
            } else {
                aVar = this.f56IL[i2];
                l = Long.valueOf(0);
            }
            aVar.n = l;
            if (this.f56IL[i2].n.longValue() <= 0) {
                this.f56IL[i2].n = Long.valueOf(b.a(getName(i2)));
                if (this.f56IL[i2].n.longValue() <= 0) {
                    this.f56IL[i2].n = Long.valueOf(new File(getUrlForParse(i2)).lastModified());
                }
            }
        }
        return this.f56IL[i2].n.longValue();
    }

    public FileType getFileType(int i2) {
        return AssetUtils.isInsFormat(this.Ilil[i2]) ? super.getFileType(i2) : AssetUtils.isPanoramaFormat(this.Ilil[i2]) ? FileType.VR360 : FileType.UNPANORAMA;
    }

    public String getName(int i2) {
        if (this.f53L11I == null) {
            String name = new File(getUrlForParse(i2)).getName();
            String str = "LRV";
            if (name.startsWith(str)) {
                name = name.replace(str, "VID");
                String str2 = "_";
                String[] split = name.split(str2);
                if (split.length == 5) {
                    String str3 = split[3];
                    if (!str3.equals("01")) {
                        if (str3.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                            if (getFileType(0) != FileType.VR360) {
                                str3 = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(split[0]);
                        sb.append(str2);
                        sb.append(split[1]);
                        sb.append(str2);
                        e.a.a.a.a.a(sb, split[2], str2, str3, str2);
                        sb.append(split[4]);
                        name = sb.toString();
                    }
                    str3 = "00";
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(split[0]);
                    sb2.append(str2);
                    sb2.append(split[1]);
                    sb2.append(str2);
                    e.a.a.a.a.a(sb2, split[2], str2, str3, str2);
                    sb2.append(split[4]);
                    name = sb2.toString();
                }
            }
            this.f53L11I = name;
        }
        return this.f53L11I;
    }

    public String[] getRawUrls() {
        return this.ILil;
    }

    public String[] getRawUrlsForPlay(int i2) {
        return this.ILil;
    }

    public long getTotalSize() {
        if (this.f54il == 0) {
            for (String file : getUrls()) {
                this.f54il = new File(file).length() + this.f54il;
            }
            if (getRawUrls() != null && getRawUrls().length > 0) {
                for (String file2 : getRawUrls()) {
                    this.f54il = new File(file2).length() + this.f54il;
                }
            }
        }
        return this.f54il;
    }

    public String getUrlForParse(int i2) {
        return this.IL1Iii[i2];
    }

    public String[] getUrls() {
        return this.IL1Iii;
    }

    public String[] getUrlsForPlay(int i2) {
        if (isHDRPhoto(i2) || isSuperNight(i2)) {
            return new String[]{this.IL1Iii[0]};
        } else if (isIntervalShooting(i2) || isBurst(i2)) {
            return new String[]{this.IL1Iii[i2]};
        } else if (this.IL1Iii.length <= 1 || getFileType(i2) != FileType.UNPANORAMA) {
            return this.IL1Iii;
        } else {
            ILL.e("getUrlsForPlay, but more than one url is associated with an unpanorama file");
            return new String[]{this.IL1Iii[0]};
        }
    }

    public boolean isInstaMedia(int i2) {
        return AssetUtils.isInsFormat(this.Ilil[i2]);
    }

    public boolean isValid() {
        return new File(getUrlForParse(getIndex())).exists();
    }

    public synchronized void save(int i2, IL1Iii iL1Iii) {
        AssetUtils.save(this.Ilil[i2]);
        if (iL1Iii != null) {
            iL1Iii.IL1Iii(this, 0);
        }
    }
}
