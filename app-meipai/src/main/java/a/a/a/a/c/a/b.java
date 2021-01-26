package a.a.a.a.c.a;

import a.a.a.a.e.a.i.g;
import a.a.a.a.e.a.l.d;
import android.text.TextUtils;
import com.arashivision.arvbmg.exporter.ExportError;
import com.arashivision.graphicpath.render.source.ImageAsset;
import com.arashivision.graphicpath.render.source.SphereProjectionType;
import com.arashivision.insta360.basemedia.export.IExportListener;
import com.arashivision.insta360.basemedia.export.IExportTask;
import com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii;
import com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii.C0004IL1Iii;
import com.arashivision.insta360.basemedia.export.task.single.params.image.IExportImageParams;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.ui.player.video.IVideoParams;
import e.a.a.a.a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class b {

    /* renamed from: a reason: collision with root package name */
    public static final MediaLogger f430a = MediaLogger.getLogger(b.class);

    public static int a(a.a.a.a.e.a.e.k.b bVar, int i2, int i3) {
        return (!bVar.isRotateScreenRatioEnabled() || !d.a(bVar.isRotateEnabled(), bVar.getRotateDegree())) ? i3 : i2;
    }

    public static int a(IVideoParams iVideoParams) {
        if (iVideoParams.isMotionBlur()) {
            double d2 = 0.0d;
            List speedSectionList = iVideoParams.getSpeedSectionList();
            for (int i2 = 0; i2 < speedSectionList.size(); i2++) {
                d2 = Math.max(d2, ((g) speedSectionList.get(i2)).f612c);
            }
            if (d2 >= 2.0d) {
                MediaLogger mediaLogger = f430a;
                StringBuilder a2 = a.a("export motion blur num is: ");
                int i3 = (int) d2;
                a2.append(i3);
                mediaLogger.d(a2.toString());
                return i3;
            }
        }
        f430a.d("export motion blur num is off");
        return -1;
    }

    public static boolean a(ExportError exportError) {
        return exportError != null && exportError.getErrorCode() == -3 && (exportError.getDomain().equals("com.insta360.bmg.FFmpegEnocder") || exportError.getDomain().equals("com.insta360.bmg.FFmpegEncoder") || exportError.getDomain().equals("com.insta360.bmg.Enocder") || exportError.getDomain().equals("com.insta360.bmg.Encoder"));
    }

    public static boolean a(FileType fileType, int i2) {
        if (fileType == FileType.VR360) {
            if (i2 == 11 || i2 == 12 || i2 == 20) {
                return true;
            }
        }
        return false;
    }

    public static int[] a(int i2, int i3) {
        int i4;
        int i5 = 64;
        if (i3 > i2) {
            int i6 = (i2 * 64) / i3;
            i4 = 64;
            i5 = i6;
        } else {
            i4 = (i3 * 64) / i2;
        }
        return new int[]{i5, i4, i5, i4};
    }

    public static int b(a.a.a.a.e.a.e.k.b bVar, int i2, int i3) {
        return (!bVar.isRotateScreenRatioEnabled() || !d.a(bVar.isRotateEnabled(), bVar.getRotateDegree())) ? i2 : i3;
    }

    public static void a(IExportTask iExportTask, IL1Iii iL1Iii) {
        int i2;
        IExportListener exportListener = iExportTask.getExportListener();
        int eventId = iExportTask.getEventId();
        int i3 = iL1Iii.ILil;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2 && exportListener != null) {
                    exportListener.onComplete(eventId);
                }
            } else if (exportListener != null) {
                exportListener.onCancel(eventId);
            }
        } else if (exportListener == null) {
        } else {
            if (a(iL1Iii.Ilil)) {
                exportListener.onError(eventId, -13021, iL1Iii.IL1Iii());
                return;
            }
            if (iL1Iii.IL1Iii == C0004IL1Iii.OTHER) {
                i2 = iL1Iii.I1I;
            } else {
                ExportError exportError = iL1Iii.Ilil;
                i2 = exportError != null ? exportError.getErrorCode() : 0;
            }
            exportListener.onError(eventId, i2, iL1Iii.IL1Iii());
        }
    }

    public static void a(String str, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            String str2 = (String) hashMap.get(IExportImageParams.KEY_EXIF_IMAGE_MAKE);
            String str3 = (String) hashMap.get(IExportImageParams.KEY_EXIF_IMAGE_MODEL);
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            ImageAsset imageAsset = new ImageAsset(str);
            imageAsset.parse(256);
            imageAsset.setExifMetadata("Exif.Image.Make", str2);
            imageAsset.setExifMetadata("Exif.Image.Model", str3);
            imageAsset.setExifMetadata("Exif.Image.DateTime", new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.ENGLISH).format(new Date(timeInMillis)));
            imageAsset.save();
            String str4 = (String) hashMap.get(IExportImageParams.KEY_EXIF_GPS_LATITUDE);
            String str5 = (String) hashMap.get(IExportImageParams.KEY_EXIF_GPS_LONGITUDE);
            String str6 = (String) hashMap.get(IExportImageParams.KEY_EXIF_GPS_ALTITUDE);
            if (str4 != null || str5 != null || str6 != null) {
                try {
                    String str7 = "";
                    if (TextUtils.isEmpty(str4)) {
                        str4 = str7;
                    }
                    double doubleValue = Double.valueOf(str4).doubleValue();
                    if (TextUtils.isEmpty(str5)) {
                        str5 = str7;
                    }
                    double doubleValue2 = Double.valueOf(str5).doubleValue();
                    if (TextUtils.isEmpty(str6)) {
                        str6 = str7;
                    }
                    a.a.a.a.b.a.a(str, doubleValue, doubleValue2, Double.valueOf(str6).doubleValue());
                } catch (NullPointerException | NumberFormatException e2) {
                    e2.printStackTrace();
                    f430a.e("gps info in ExportImageParams is invalid!");
                }
            }
        }
    }

    public static void a(String str, HashMap<String, String> hashMap, int i2, int i3) {
        if (hashMap != null) {
            String str2 = (String) hashMap.get(IExportImageParams.KEY_XMP_CAPTURE_SOFTWARE);
            String str3 = (String) hashMap.get(IExportImageParams.KEY_XMP_STITCHING_SOFTWARE);
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            ImageAsset imageAsset = new ImageAsset(str);
            imageAsset.parse(512);
            imageAsset.setXmpMetadata("Xmp.GPano.UsePanoramaViewer", "True");
            imageAsset.setXmpMetadata("Xmp.GPano.CaptureSoftware", str2);
            imageAsset.setXmpMetadata("Xmp.GPano.StitchingSoftware", str3);
            imageAsset.setXmpMetadata("Xmp.GPano.ProjectionType", SphereProjectionType.kNameLeftRight);
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            String str4 = "";
            sb.append(str4);
            imageAsset.setXmpMetadata("Xmp.GPano.CroppedAreaImageWidthPixels", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i3);
            sb2.append(str4);
            imageAsset.setXmpMetadata("Xmp.GPano.CroppedAreaImageHeightPixels", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i2);
            sb3.append(str4);
            imageAsset.setXmpMetadata("Xmp.GPano.FullPanoWidthPixels", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(i3);
            sb4.append(str4);
            imageAsset.setXmpMetadata("Xmp.GPano.FullPanoHeightPixels", sb4.toString());
            String str5 = "0";
            imageAsset.setXmpMetadata("Xmp.GPano.CroppedAreaLeftPixels", str5);
            imageAsset.setXmpMetadata("Xmp.GPano.CroppedAreaTopPixels", str5);
            imageAsset.setXmpMetadata("Xmp.GPano.SourceImageCreateTime", new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.ENGLISH).format(new Date(timeInMillis)));
            imageAsset.save();
        }
    }
}
