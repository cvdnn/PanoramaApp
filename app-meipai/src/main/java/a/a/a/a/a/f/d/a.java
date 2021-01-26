package a.a.a.a.a.f.d;

import a.a.a.a.b.c;
import com.arashivision.graphicpath.render.source.Asset;
import com.arashivision.graphicpath.render.source.ImageAsset;
import com.arashivision.graphicpath.render.source.VideoAsset;
import com.arashivision.onecamera.OneDriverInfo.RecordFormat;
import com.tencent.connect.common.Constants;
import java.util.Arrays;

public class a {

    /* renamed from: a reason: collision with root package name */
    public String f382a;

    /* renamed from: b reason: collision with root package name */
    public Asset f383b;

    public a(String str, Asset asset) {
        this.f382a = str;
        this.f383b = asset;
        if (asset == null) {
            Asset videoAsset = (a.a.a.a.b.a.a((CharSequence) str, (CharSequence) "insv") || a.a.a.a.b.a.a((CharSequence) str, (CharSequence) RecordFormat.VIDEO_FORMAT_MP4)) ? new VideoAsset(str) : new ImageAsset(str);
            videoAsset.parse(1);
            this.f383b = videoAsset;
        }
    }

    public static a[] a(int i2, a[] aVarArr, a aVar, String[] strArr, int i3) {
        c a2 = c.a(i2);
        if (a2 == null) {
            int i4 = i3 + 1;
            if (aVarArr.length < i4) {
                aVarArr = (a[]) Arrays.copyOf(aVarArr, i4);
            }
            if (i3 < aVarArr.length) {
                aVarArr[i3] = aVar;
            }
            return aVarArr;
        }
        switch (a2.ordinal()) {
            case 0:
            case 1:
            case 2:
            case 6:
            case 8:
                String str = strArr[3];
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 1536) {
                    if (hashCode != 1537) {
                        if (hashCode != 1567) {
                            if (hashCode == 1568 && str.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                                c2 = 3;
                            }
                        } else if (str.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)) {
                            c2 = 1;
                        }
                    } else if (str.equals("01")) {
                        c2 = 2;
                    }
                } else if (str.equals("00")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 != 2) {
                            if (c2 == 3) {
                                if (aVarArr.length < 4) {
                                    aVarArr = (a[]) Arrays.copyOf(aVarArr, 4);
                                }
                                aVarArr[3] = aVar;
                                break;
                            }
                        } else {
                            if (aVarArr.length < 3) {
                                aVarArr = (a[]) Arrays.copyOf(aVarArr, 3);
                            }
                            aVarArr[2] = aVar;
                            break;
                        }
                    } else {
                        if (aVarArr.length < 2) {
                            aVarArr = (a[]) Arrays.copyOf(aVarArr, 2);
                        }
                        aVarArr[1] = aVar;
                        break;
                    }
                } else {
                    if (aVarArr.length < 1) {
                        aVarArr = (a[]) Arrays.copyOf(aVarArr, 1);
                    }
                    aVarArr[0] = aVar;
                    break;
                }
                break;
            case 4:
            case 5:
            case 7:
            case 10:
                int i5 = i3 + 1;
                if (aVarArr.length < i5) {
                    aVarArr = (a[]) Arrays.copyOf(aVarArr, i5);
                }
                if (i3 < aVarArr.length) {
                    aVarArr[i3] = aVar;
                    break;
                }
                break;
            default:
                aVarArr = new a[]{aVar};
                break;
        }
        return aVarArr;
    }
}
