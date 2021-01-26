package com.arashivision.insta360.basemedia.export.task.single.params.image;

import com.arashivision.graphicpath.render.engine.Transform;
import java.util.HashMap;

public interface IExportImageParams extends Cloneable {
    public static final String KEY_EXIF_GPS_ALTITUDE = "GPSAltitude";
    public static final String KEY_EXIF_GPS_LATITUDE = "GPSLatitude";
    public static final String KEY_EXIF_GPS_LONGITUDE = "GPSLongitude";
    public static final String KEY_EXIF_IMAGE_MAKE = "ImageMake";
    public static final String KEY_EXIF_IMAGE_MODEL = "ImageModel";
    public static final String KEY_XMP_CAPTURE_SOFTWARE = "captureSoftware";
    public static final String KEY_XMP_STITCHING_SOFTWARE = "stitchingSoftware";

    void addExifInfo(String str, String str2);

    void addXmpInfo(String str, String str2);

    IExportImageParams clone();

    HashMap<String, String> getExifInfo();

    long getExportTimestamp();

    int getHeight();

    String getIdenticalKey();

    String getPath();

    int getRenderModelType();

    Transform getTransform();

    int getWidth();

    HashMap<String, String> getXmpInfo();

    boolean isAccurateSeek();

    boolean isApplyStabilizer();

    boolean isApplyWatermark();

    boolean isUseOriginalOutput();

    boolean isUseSoftwareDecoder();

    boolean isUseTransform();

    void setAccurateSeek(boolean z);

    void setApplyStabilizer(boolean z);

    void setApplyWatermark(boolean z);

    void setExportTimestamp(long j2);

    void setHeight(int i2);

    void setPath(String str);

    void setRenderModelType(int i2);

    void setTransform(Transform transform);

    void setUseOriginalOutput(boolean z);

    void setUseSoftwareDecoder(boolean z);

    void setUseTransform(boolean z);

    void setWidth(int i2);
}
