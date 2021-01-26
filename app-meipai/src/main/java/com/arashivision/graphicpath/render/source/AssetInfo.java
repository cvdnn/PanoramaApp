package com.arashivision.graphicpath.render.source;

public class AssetInfo implements Cloneable {
    public Double audioBitrate;
    public Integer audioChannelCount;
    public Long audioChannelLayout;
    public String audioCodecName;
    public Double audioDurationS;
    public Integer audioSampleRate;
    public Integer batteryType;
    public Double bitrate;
    public Integer cameraLensCount;
    public Integer cameraLensType;
    public String captureCameraName;
    public Integer cropWindowDstHeight;
    public Integer cropWindowDstWidth;
    public Integer cropWindowSrcHeight;
    public Integer cropWindowSrcWidth;
    public Integer exposureDataSize;
    public Integer fileGroupInfoType0;
    public Integer fovType;
    public String fwVersion;
    public Integer gyroDataSize;
    public Integer gyroDeviceType;
    public Integer gyroFilterType;
    public Boolean hasAudio;
    public Boolean hasVideo;
    public Integer height;
    public Boolean isBulletTimeVideo;
    public Boolean isDewarp;
    public Boolean isFisheye3dFormat;
    public Boolean isFlowstateOnline;
    public Boolean isInsFormat;
    public Boolean isNormalPlane;
    public Boolean isPanoFormat;
    public Boolean isSelfie;
    public Boolean isStaticTimelapseVideo;
    public Boolean isVideo;
    public String offset;
    public Integer oneRCameraPosture;
    public String originalOffset;
    public String path;
    public Integer planeRotationDegree;
    public Integer resolutionSizeHeight;
    public Integer resolutionSizeWidth;
    public String serialNumber;
    public String sphereMappingTypeName;
    public String stereo3dTypeName;
    public Integer totalFrames;
    public Double videoBitrate;
    public String videoCodecName;
    public Double videoDurationS;
    public Double videoFramerate;
    public Integer width;

    public class BatteryType {
        public static final int Thick = 0;
        public static final int Thin = 1;
        public static final int Vertical = 2;

        public BatteryType() {
        }
    }

    public class FovType {
        public static final int FOV_TYPE_LINEAR = 2;
        public static final int FOV_TYPE_NARROW = 4;
        public static final int FOV_TYPE_ULTRAWIDE = 3;
        public static final int FOV_TYPE_UNKNOWN = 0;
        public static final int FOV_TYPE_WIDE = 1;

        public FovType() {
        }
    }

    public class GyroDeviceType {
        public static final int INSDEV_IMU_TYPE_20948 = 0;
        public static final int INSDEV_IMU_TYPE_40609 = 1;

        public GyroDeviceType() {
        }
    }

    public class GyroFilterType {
        public static final int GYRO_FILTER_TYPE_AKF = 2;
        public static final int GYRO_FILTER_TYPE_BRUTE = 1;
        public static final int GYRO_FILTER_TYPE_UNKNOWN = 0;

        public GyroFilterType() {
        }
    }

    public class ONERCameraPosture {
        public static final int Rotate0 = 0;
        public static final int Rotate180 = 2;
        public static final int Rotate270 = 3;
        public static final int Rotate90 = 1;

        public ONERCameraPosture() {
        }
    }

    public class SubMediaType {
        public static final int PHOTO_AEB_NIGHT_MODE = 10;
        public static final int PHOTO_BURST = 7;
        public static final int PHOTO_HDR = 4;
        public static final int PHOTO_INTERVALSHOOTING = 5;
        public static final int PHOTO_NORMAL = 3;
        public static final int UNDEFINED = 65535;
        public static final int VIDEO_BULLETTIME = 1;
        public static final int VIDEO_HDR = 6;
        public static final int VIDEO_NORMAL = 0;
        public static final int VIDEO_STATIC_TIMELAPSE = 8;
        public static final int VIDEO_TIMELAPSE = 2;
        public static final int VIDEO_TIMESHIFT = 9;

        public SubMediaType() {
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object get(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            switch(r0) {
                case -2080014900: goto L_0x0250;
                case -2035522509: goto L_0x0246;
                case -1866315534: goto L_0x023b;
                case -1778829246: goto L_0x0231;
                case -1688626505: goto L_0x0226;
                case -1685274069: goto L_0x021c;
                case -1613469997: goto L_0x0212;
                case -1485447431: goto L_0x0207;
                case -1475447264: goto L_0x01fc;
                case -1397958135: goto L_0x01f1;
                case -1306047740: goto L_0x01e5;
                case -1297119519: goto L_0x01d9;
                case -1221029593: goto L_0x01cd;
                case -1202170409: goto L_0x01c1;
                case -1110062838: goto L_0x01b5;
                case -1019779949: goto L_0x01a9;
                case -899581813: goto L_0x019d;
                case -839484053: goto L_0x0191;
                case -807671418: goto L_0x0185;
                case -739414846: goto L_0x0179;
                case -719467833: goto L_0x016d;
                case -674471513: goto L_0x0161;
                case -661100461: goto L_0x0155;
                case -567301886: goto L_0x0149;
                case -491568891: goto L_0x013d;
                case -470074298: goto L_0x0131;
                case -249426318: goto L_0x0125;
                case -231986382: goto L_0x0119;
                case -110146918: goto L_0x010d;
                case -102270099: goto L_0x0101;
                case -96365701: goto L_0x00f6;
                case 3433509: goto L_0x00ea;
                case 83787357: goto L_0x00de;
                case 113126854: goto L_0x00d2;
                case 113158492: goto L_0x00c6;
                case 132194817: goto L_0x00bb;
                case 153032844: goto L_0x00af;
                case 434546113: goto L_0x00a3;
                case 734734237: goto L_0x0097;
                case 762775124: goto L_0x008b;
                case 862805394: goto L_0x007f;
                case 1037122239: goto L_0x0073;
                case 1147447654: goto L_0x0067;
                case 1285932300: goto L_0x005b;
                case 1459255748: goto L_0x004f;
                case 1743821966: goto L_0x0043;
                case 1924224823: goto L_0x0038;
                case 2023351015: goto L_0x002c;
                case 2073608561: goto L_0x0021;
                case 2123127606: goto L_0x0015;
                case 2123834007: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x025b
        L_0x0009:
            java.lang.String r0 = "oneRCameraPosture"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 35
            goto L_0x025c
        L_0x0015:
            java.lang.String r0 = "captureCameraName"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 16
            goto L_0x025c
        L_0x0021:
            java.lang.String r0 = "isVideo"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 0
            goto L_0x025c
        L_0x002c:
            java.lang.String r0 = "batteryType"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 34
            goto L_0x025c
        L_0x0038:
            java.lang.String r0 = "isFisheye3dFormat"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 2
            goto L_0x025c
        L_0x0043:
            java.lang.String r0 = "stereo3dTypeName"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 20
            goto L_0x025c
        L_0x004f:
            java.lang.String r0 = "originalOffset"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 21
            goto L_0x025c
        L_0x005b:
            java.lang.String r0 = "cameraLensCount"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 48
            goto L_0x025c
        L_0x0067:
            java.lang.String r0 = "planeRotationDegree"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 31
            goto L_0x025c
        L_0x0073:
            java.lang.String r0 = "gyroDeviceType"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 50
            goto L_0x025c
        L_0x007f:
            java.lang.String r0 = "videoFramerate"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 11
            goto L_0x025c
        L_0x008b:
            java.lang.String r0 = "resolutionSizeHeight"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 37
            goto L_0x025c
        L_0x0097:
            java.lang.String r0 = "cameraLensType"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 47
            goto L_0x025c
        L_0x00a3:
            java.lang.String r0 = "cropWindowDstWidth"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 28
            goto L_0x025c
        L_0x00af:
            java.lang.String r0 = "cropWindowDstHeight"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 29
            goto L_0x025c
        L_0x00bb:
            java.lang.String r0 = "hasVideo"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 7
            goto L_0x025c
        L_0x00c6:
            java.lang.String r0 = "hasAudio"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 8
            goto L_0x025c
        L_0x00d2:
            java.lang.String r0 = "width"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 9
            goto L_0x025c
        L_0x00de:
            java.lang.String r0 = "serialNumber"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 22
            goto L_0x025c
        L_0x00ea:
            java.lang.String r0 = "path"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 14
            goto L_0x025c
        L_0x00f6:
            java.lang.String r0 = "isInsFormat"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 1
            goto L_0x025c
        L_0x0101:
            java.lang.String r0 = "bitrate"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 39
            goto L_0x025c
        L_0x010d:
            java.lang.String r0 = "gyroDataSize"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 17
            goto L_0x025c
        L_0x0119:
            java.lang.String r0 = "isSelfie"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 30
            goto L_0x025c
        L_0x0125:
            java.lang.String r0 = "videoBitrate"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 40
            goto L_0x025c
        L_0x0131:
            java.lang.String r0 = "sphereMappingTypeName"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 19
            goto L_0x025c
        L_0x013d:
            java.lang.String r0 = "fileGroupInfoType0"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 24
            goto L_0x025c
        L_0x0149:
            java.lang.String r0 = "cropWindowSrcWidth"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 26
            goto L_0x025c
        L_0x0155:
            java.lang.String r0 = "isDewarp"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 33
            goto L_0x025c
        L_0x0161:
            java.lang.String r0 = "fovType"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 38
            goto L_0x025c
        L_0x016d:
            java.lang.String r0 = "fwVersion"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 23
            goto L_0x025c
        L_0x0179:
            java.lang.String r0 = "audioChannelCount"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 43
            goto L_0x025c
        L_0x0185:
            java.lang.String r0 = "videoCodecName"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 13
            goto L_0x025c
        L_0x0191:
            java.lang.String r0 = "cropWindowSrcHeight"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 27
            goto L_0x025c
        L_0x019d:
            java.lang.String r0 = "audioCodecName"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 46
            goto L_0x025c
        L_0x01a9:
            java.lang.String r0 = "offset"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 15
            goto L_0x025c
        L_0x01b5:
            java.lang.String r0 = "totalFrames"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 25
            goto L_0x025c
        L_0x01c1:
            java.lang.String r0 = "audioChannelLayout"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 44
            goto L_0x025c
        L_0x01cd:
            java.lang.String r0 = "height"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 10
            goto L_0x025c
        L_0x01d9:
            java.lang.String r0 = "gyroFilterType"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 49
            goto L_0x025c
        L_0x01e5:
            java.lang.String r0 = "videoDurationS"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 12
            goto L_0x025c
        L_0x01f1:
            java.lang.String r0 = "audioDurationS"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 42
            goto L_0x025c
        L_0x01fc:
            java.lang.String r0 = "audioSampleRate"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 45
            goto L_0x025c
        L_0x0207:
            java.lang.String r0 = "resolutionSizeWidth"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 36
            goto L_0x025c
        L_0x0212:
            java.lang.String r0 = "isPanoFormat"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 3
            goto L_0x025c
        L_0x021c:
            java.lang.String r0 = "isNormalPlane"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 6
            goto L_0x025c
        L_0x0226:
            java.lang.String r0 = "audioBitrate"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 41
            goto L_0x025c
        L_0x0231:
            java.lang.String r0 = "isBulletTimeVideo"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 4
            goto L_0x025c
        L_0x023b:
            java.lang.String r0 = "exposureDataSize"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 18
            goto L_0x025c
        L_0x0246:
            java.lang.String r0 = "isStaticTimelapseVideo"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 5
            goto L_0x025c
        L_0x0250:
            java.lang.String r0 = "isFlowstateOnline"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 32
            goto L_0x025c
        L_0x025b:
            r0 = -1
        L_0x025c:
            switch(r0) {
                case 0: goto L_0x030d;
                case 1: goto L_0x030a;
                case 2: goto L_0x0307;
                case 3: goto L_0x0304;
                case 4: goto L_0x0301;
                case 5: goto L_0x02fe;
                case 6: goto L_0x02fb;
                case 7: goto L_0x02f8;
                case 8: goto L_0x02f5;
                case 9: goto L_0x02f2;
                case 10: goto L_0x02ef;
                case 11: goto L_0x02ec;
                case 12: goto L_0x02e9;
                case 13: goto L_0x02e6;
                case 14: goto L_0x02e3;
                case 15: goto L_0x02e0;
                case 16: goto L_0x02dd;
                case 17: goto L_0x02da;
                case 18: goto L_0x02d7;
                case 19: goto L_0x02d4;
                case 20: goto L_0x02d1;
                case 21: goto L_0x02ce;
                case 22: goto L_0x02cb;
                case 23: goto L_0x02c8;
                case 24: goto L_0x02c5;
                case 25: goto L_0x02c2;
                case 26: goto L_0x02bf;
                case 27: goto L_0x02bc;
                case 28: goto L_0x02b9;
                case 29: goto L_0x02b6;
                case 30: goto L_0x02b3;
                case 31: goto L_0x02b0;
                case 32: goto L_0x02ad;
                case 33: goto L_0x02aa;
                case 34: goto L_0x02a7;
                case 35: goto L_0x02a4;
                case 36: goto L_0x02a1;
                case 37: goto L_0x029e;
                case 38: goto L_0x029b;
                case 39: goto L_0x0298;
                case 40: goto L_0x0295;
                case 41: goto L_0x0292;
                case 42: goto L_0x028f;
                case 43: goto L_0x028c;
                case 44: goto L_0x0289;
                case 45: goto L_0x0286;
                case 46: goto L_0x0283;
                case 47: goto L_0x0280;
                case 48: goto L_0x027d;
                case 49: goto L_0x027a;
                case 50: goto L_0x0277;
                default: goto L_0x025f;
            }
        L_0x025f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "get asset info, unknown key name: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.String r0 = "ins"
            com.arashivision.insbase.arlog.Log.e(r0, r3)
            r3 = 0
            return r3
        L_0x0277:
            java.lang.Integer r3 = r2.gyroDeviceType
            return r3
        L_0x027a:
            java.lang.Integer r3 = r2.gyroFilterType
            return r3
        L_0x027d:
            java.lang.Integer r3 = r2.cameraLensCount
            return r3
        L_0x0280:
            java.lang.Integer r3 = r2.cameraLensType
            return r3
        L_0x0283:
            java.lang.String r3 = r2.audioCodecName
            return r3
        L_0x0286:
            java.lang.Integer r3 = r2.audioSampleRate
            return r3
        L_0x0289:
            java.lang.Long r3 = r2.audioChannelLayout
            return r3
        L_0x028c:
            java.lang.Integer r3 = r2.audioChannelCount
            return r3
        L_0x028f:
            java.lang.Double r3 = r2.audioDurationS
            return r3
        L_0x0292:
            java.lang.Double r3 = r2.audioBitrate
            return r3
        L_0x0295:
            java.lang.Double r3 = r2.videoBitrate
            return r3
        L_0x0298:
            java.lang.Double r3 = r2.bitrate
            return r3
        L_0x029b:
            java.lang.Integer r3 = r2.fovType
            return r3
        L_0x029e:
            java.lang.Integer r3 = r2.resolutionSizeHeight
            return r3
        L_0x02a1:
            java.lang.Integer r3 = r2.resolutionSizeWidth
            return r3
        L_0x02a4:
            java.lang.Integer r3 = r2.oneRCameraPosture
            return r3
        L_0x02a7:
            java.lang.Integer r3 = r2.batteryType
            return r3
        L_0x02aa:
            java.lang.Boolean r3 = r2.isDewarp
            return r3
        L_0x02ad:
            java.lang.Boolean r3 = r2.isFlowstateOnline
            return r3
        L_0x02b0:
            java.lang.Integer r3 = r2.planeRotationDegree
            return r3
        L_0x02b3:
            java.lang.Boolean r3 = r2.isSelfie
            return r3
        L_0x02b6:
            java.lang.Integer r3 = r2.cropWindowDstHeight
            return r3
        L_0x02b9:
            java.lang.Integer r3 = r2.cropWindowDstWidth
            return r3
        L_0x02bc:
            java.lang.Integer r3 = r2.cropWindowSrcHeight
            return r3
        L_0x02bf:
            java.lang.Integer r3 = r2.cropWindowSrcWidth
            return r3
        L_0x02c2:
            java.lang.Integer r3 = r2.totalFrames
            return r3
        L_0x02c5:
            java.lang.Integer r3 = r2.fileGroupInfoType0
            return r3
        L_0x02c8:
            java.lang.String r3 = r2.fwVersion
            return r3
        L_0x02cb:
            java.lang.String r3 = r2.serialNumber
            return r3
        L_0x02ce:
            java.lang.String r3 = r2.originalOffset
            return r3
        L_0x02d1:
            java.lang.String r3 = r2.stereo3dTypeName
            return r3
        L_0x02d4:
            java.lang.String r3 = r2.sphereMappingTypeName
            return r3
        L_0x02d7:
            java.lang.Integer r3 = r2.exposureDataSize
            return r3
        L_0x02da:
            java.lang.Integer r3 = r2.gyroDataSize
            return r3
        L_0x02dd:
            java.lang.String r3 = r2.captureCameraName
            return r3
        L_0x02e0:
            java.lang.String r3 = r2.offset
            return r3
        L_0x02e3:
            java.lang.String r3 = r2.path
            return r3
        L_0x02e6:
            java.lang.String r3 = r2.videoCodecName
            return r3
        L_0x02e9:
            java.lang.Double r3 = r2.videoDurationS
            return r3
        L_0x02ec:
            java.lang.Double r3 = r2.videoFramerate
            return r3
        L_0x02ef:
            java.lang.Integer r3 = r2.height
            return r3
        L_0x02f2:
            java.lang.Integer r3 = r2.width
            return r3
        L_0x02f5:
            java.lang.Boolean r3 = r2.hasAudio
            return r3
        L_0x02f8:
            java.lang.Boolean r3 = r2.hasVideo
            return r3
        L_0x02fb:
            java.lang.Boolean r3 = r2.isNormalPlane
            return r3
        L_0x02fe:
            java.lang.Boolean r3 = r2.isStaticTimelapseVideo
            return r3
        L_0x0301:
            java.lang.Boolean r3 = r2.isBulletTimeVideo
            return r3
        L_0x0304:
            java.lang.Boolean r3 = r2.isPanoFormat
            return r3
        L_0x0307:
            java.lang.Boolean r3 = r2.isFisheye3dFormat
            return r3
        L_0x030a:
            java.lang.Boolean r3 = r2.isInsFormat
            return r3
        L_0x030d:
            java.lang.Boolean r3 = r2.isVideo
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.graphicpath.render.source.AssetInfo.get(java.lang.String):java.lang.Object");
    }

    private boolean getBoolean(String str) {
        return ((Boolean) get(str)).booleanValue();
    }

    private double getDouble(String str) {
        return ((Double) get(str)).doubleValue();
    }

    private int getInt(String str) {
        return ((Integer) get(str)).intValue();
    }

    private long getLong(String str) {
        return ((Long) get(str)).longValue();
    }

    private String getString(String str) {
        return (String) get(str);
    }

    private boolean has(String str) {
        return get(str) != null;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void set(java.lang.String r2, java.lang.Object r3) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -2080014900: goto L_0x0250;
                case -2035522509: goto L_0x0246;
                case -1866315534: goto L_0x023b;
                case -1778829246: goto L_0x0231;
                case -1688626505: goto L_0x0226;
                case -1685274069: goto L_0x021c;
                case -1613469997: goto L_0x0212;
                case -1485447431: goto L_0x0207;
                case -1475447264: goto L_0x01fc;
                case -1397958135: goto L_0x01f1;
                case -1306047740: goto L_0x01e5;
                case -1297119519: goto L_0x01d9;
                case -1221029593: goto L_0x01cd;
                case -1202170409: goto L_0x01c1;
                case -1110062838: goto L_0x01b5;
                case -1019779949: goto L_0x01a9;
                case -899581813: goto L_0x019d;
                case -839484053: goto L_0x0191;
                case -807671418: goto L_0x0185;
                case -739414846: goto L_0x0179;
                case -719467833: goto L_0x016d;
                case -674471513: goto L_0x0161;
                case -661100461: goto L_0x0155;
                case -567301886: goto L_0x0149;
                case -491568891: goto L_0x013d;
                case -470074298: goto L_0x0131;
                case -249426318: goto L_0x0125;
                case -231986382: goto L_0x0119;
                case -110146918: goto L_0x010d;
                case -102270099: goto L_0x0101;
                case -96365701: goto L_0x00f6;
                case 3433509: goto L_0x00ea;
                case 83787357: goto L_0x00de;
                case 113126854: goto L_0x00d2;
                case 113158492: goto L_0x00c6;
                case 132194817: goto L_0x00bb;
                case 153032844: goto L_0x00af;
                case 434546113: goto L_0x00a3;
                case 734734237: goto L_0x0097;
                case 762775124: goto L_0x008b;
                case 862805394: goto L_0x007f;
                case 1037122239: goto L_0x0073;
                case 1147447654: goto L_0x0067;
                case 1285932300: goto L_0x005b;
                case 1459255748: goto L_0x004f;
                case 1743821966: goto L_0x0043;
                case 1924224823: goto L_0x0038;
                case 2023351015: goto L_0x002c;
                case 2073608561: goto L_0x0021;
                case 2123127606: goto L_0x0015;
                case 2123834007: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x025b
        L_0x0009:
            java.lang.String r0 = "oneRCameraPosture"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 35
            goto L_0x025c
        L_0x0015:
            java.lang.String r0 = "captureCameraName"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 16
            goto L_0x025c
        L_0x0021:
            java.lang.String r0 = "isVideo"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 0
            goto L_0x025c
        L_0x002c:
            java.lang.String r0 = "batteryType"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 34
            goto L_0x025c
        L_0x0038:
            java.lang.String r0 = "isFisheye3dFormat"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 2
            goto L_0x025c
        L_0x0043:
            java.lang.String r0 = "stereo3dTypeName"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 20
            goto L_0x025c
        L_0x004f:
            java.lang.String r0 = "originalOffset"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 21
            goto L_0x025c
        L_0x005b:
            java.lang.String r0 = "cameraLensCount"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 48
            goto L_0x025c
        L_0x0067:
            java.lang.String r0 = "planeRotationDegree"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 31
            goto L_0x025c
        L_0x0073:
            java.lang.String r0 = "gyroDeviceType"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 50
            goto L_0x025c
        L_0x007f:
            java.lang.String r0 = "videoFramerate"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 11
            goto L_0x025c
        L_0x008b:
            java.lang.String r0 = "resolutionSizeHeight"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 37
            goto L_0x025c
        L_0x0097:
            java.lang.String r0 = "cameraLensType"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 47
            goto L_0x025c
        L_0x00a3:
            java.lang.String r0 = "cropWindowDstWidth"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 28
            goto L_0x025c
        L_0x00af:
            java.lang.String r0 = "cropWindowDstHeight"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 29
            goto L_0x025c
        L_0x00bb:
            java.lang.String r0 = "hasVideo"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 7
            goto L_0x025c
        L_0x00c6:
            java.lang.String r0 = "hasAudio"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 8
            goto L_0x025c
        L_0x00d2:
            java.lang.String r0 = "width"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 9
            goto L_0x025c
        L_0x00de:
            java.lang.String r0 = "serialNumber"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 22
            goto L_0x025c
        L_0x00ea:
            java.lang.String r0 = "path"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 14
            goto L_0x025c
        L_0x00f6:
            java.lang.String r0 = "isInsFormat"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 1
            goto L_0x025c
        L_0x0101:
            java.lang.String r0 = "bitrate"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 39
            goto L_0x025c
        L_0x010d:
            java.lang.String r0 = "gyroDataSize"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 17
            goto L_0x025c
        L_0x0119:
            java.lang.String r0 = "isSelfie"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 30
            goto L_0x025c
        L_0x0125:
            java.lang.String r0 = "videoBitrate"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 40
            goto L_0x025c
        L_0x0131:
            java.lang.String r0 = "sphereMappingTypeName"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 19
            goto L_0x025c
        L_0x013d:
            java.lang.String r0 = "fileGroupInfoType0"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 24
            goto L_0x025c
        L_0x0149:
            java.lang.String r0 = "cropWindowSrcWidth"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 26
            goto L_0x025c
        L_0x0155:
            java.lang.String r0 = "isDewarp"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 33
            goto L_0x025c
        L_0x0161:
            java.lang.String r0 = "fovType"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 38
            goto L_0x025c
        L_0x016d:
            java.lang.String r0 = "fwVersion"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 23
            goto L_0x025c
        L_0x0179:
            java.lang.String r0 = "audioChannelCount"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 43
            goto L_0x025c
        L_0x0185:
            java.lang.String r0 = "videoCodecName"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 13
            goto L_0x025c
        L_0x0191:
            java.lang.String r0 = "cropWindowSrcHeight"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 27
            goto L_0x025c
        L_0x019d:
            java.lang.String r0 = "audioCodecName"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 46
            goto L_0x025c
        L_0x01a9:
            java.lang.String r0 = "offset"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 15
            goto L_0x025c
        L_0x01b5:
            java.lang.String r0 = "totalFrames"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 25
            goto L_0x025c
        L_0x01c1:
            java.lang.String r0 = "audioChannelLayout"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 44
            goto L_0x025c
        L_0x01cd:
            java.lang.String r0 = "height"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 10
            goto L_0x025c
        L_0x01d9:
            java.lang.String r0 = "gyroFilterType"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 49
            goto L_0x025c
        L_0x01e5:
            java.lang.String r0 = "videoDurationS"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 12
            goto L_0x025c
        L_0x01f1:
            java.lang.String r0 = "audioDurationS"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 42
            goto L_0x025c
        L_0x01fc:
            java.lang.String r0 = "audioSampleRate"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 45
            goto L_0x025c
        L_0x0207:
            java.lang.String r0 = "resolutionSizeWidth"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 36
            goto L_0x025c
        L_0x0212:
            java.lang.String r0 = "isPanoFormat"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 3
            goto L_0x025c
        L_0x021c:
            java.lang.String r0 = "isNormalPlane"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 6
            goto L_0x025c
        L_0x0226:
            java.lang.String r0 = "audioBitrate"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 41
            goto L_0x025c
        L_0x0231:
            java.lang.String r0 = "isBulletTimeVideo"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 4
            goto L_0x025c
        L_0x023b:
            java.lang.String r0 = "exposureDataSize"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 18
            goto L_0x025c
        L_0x0246:
            java.lang.String r0 = "isStaticTimelapseVideo"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 5
            goto L_0x025c
        L_0x0250:
            java.lang.String r0 = "isFlowstateOnline"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x025b
            r0 = 32
            goto L_0x025c
        L_0x025b:
            r0 = -1
        L_0x025c:
            switch(r0) {
                case 0: goto L_0x0391;
                case 1: goto L_0x038c;
                case 2: goto L_0x0387;
                case 3: goto L_0x0382;
                case 4: goto L_0x037d;
                case 5: goto L_0x0378;
                case 6: goto L_0x0373;
                case 7: goto L_0x036e;
                case 8: goto L_0x0369;
                case 9: goto L_0x0364;
                case 10: goto L_0x035f;
                case 11: goto L_0x035a;
                case 12: goto L_0x0355;
                case 13: goto L_0x0350;
                case 14: goto L_0x034b;
                case 15: goto L_0x0346;
                case 16: goto L_0x0341;
                case 17: goto L_0x033c;
                case 18: goto L_0x0337;
                case 19: goto L_0x0331;
                case 20: goto L_0x032b;
                case 21: goto L_0x0325;
                case 22: goto L_0x031f;
                case 23: goto L_0x0319;
                case 24: goto L_0x0313;
                case 25: goto L_0x030d;
                case 26: goto L_0x0307;
                case 27: goto L_0x0301;
                case 28: goto L_0x02fb;
                case 29: goto L_0x02f5;
                case 30: goto L_0x02ef;
                case 31: goto L_0x02e9;
                case 32: goto L_0x02e3;
                case 33: goto L_0x02dd;
                case 34: goto L_0x02d7;
                case 35: goto L_0x02d1;
                case 36: goto L_0x02cb;
                case 37: goto L_0x02c5;
                case 38: goto L_0x02bf;
                case 39: goto L_0x02b9;
                case 40: goto L_0x02b3;
                case 41: goto L_0x02ad;
                case 42: goto L_0x02a7;
                case 43: goto L_0x02a1;
                case 44: goto L_0x029b;
                case 45: goto L_0x0295;
                case 46: goto L_0x028f;
                case 47: goto L_0x0289;
                case 48: goto L_0x0283;
                case 49: goto L_0x027d;
                case 50: goto L_0x0277;
                default: goto L_0x025f;
            }
        L_0x025f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "set asset info, unknown key name: "
            r3.append(r0)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "ins"
            com.arashivision.insbase.arlog.Log.e(r3, r2)
            goto L_0x0395
        L_0x0277:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.gyroDeviceType = r3
            goto L_0x0395
        L_0x027d:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.gyroFilterType = r3
            goto L_0x0395
        L_0x0283:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.cameraLensCount = r3
            goto L_0x0395
        L_0x0289:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.cameraLensType = r3
            goto L_0x0395
        L_0x028f:
            java.lang.String r3 = (java.lang.String) r3
            r1.audioCodecName = r3
            goto L_0x0395
        L_0x0295:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.audioSampleRate = r3
            goto L_0x0395
        L_0x029b:
            java.lang.Long r3 = (java.lang.Long) r3
            r1.audioChannelLayout = r3
            goto L_0x0395
        L_0x02a1:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.audioChannelCount = r3
            goto L_0x0395
        L_0x02a7:
            java.lang.Double r3 = (java.lang.Double) r3
            r1.audioDurationS = r3
            goto L_0x0395
        L_0x02ad:
            java.lang.Double r3 = (java.lang.Double) r3
            r1.audioBitrate = r3
            goto L_0x0395
        L_0x02b3:
            java.lang.Double r3 = (java.lang.Double) r3
            r1.videoBitrate = r3
            goto L_0x0395
        L_0x02b9:
            java.lang.Double r3 = (java.lang.Double) r3
            r1.bitrate = r3
            goto L_0x0395
        L_0x02bf:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.fovType = r3
            goto L_0x0395
        L_0x02c5:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.resolutionSizeHeight = r3
            goto L_0x0395
        L_0x02cb:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.resolutionSizeWidth = r3
            goto L_0x0395
        L_0x02d1:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.oneRCameraPosture = r3
            goto L_0x0395
        L_0x02d7:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.batteryType = r3
            goto L_0x0395
        L_0x02dd:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            r1.isDewarp = r3
            goto L_0x0395
        L_0x02e3:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            r1.isFlowstateOnline = r3
            goto L_0x0395
        L_0x02e9:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.planeRotationDegree = r3
            goto L_0x0395
        L_0x02ef:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            r1.isSelfie = r3
            goto L_0x0395
        L_0x02f5:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.cropWindowDstHeight = r3
            goto L_0x0395
        L_0x02fb:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.cropWindowDstWidth = r3
            goto L_0x0395
        L_0x0301:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.cropWindowSrcHeight = r3
            goto L_0x0395
        L_0x0307:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.cropWindowSrcWidth = r3
            goto L_0x0395
        L_0x030d:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.totalFrames = r3
            goto L_0x0395
        L_0x0313:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.fileGroupInfoType0 = r3
            goto L_0x0395
        L_0x0319:
            java.lang.String r3 = (java.lang.String) r3
            r1.fwVersion = r3
            goto L_0x0395
        L_0x031f:
            java.lang.String r3 = (java.lang.String) r3
            r1.serialNumber = r3
            goto L_0x0395
        L_0x0325:
            java.lang.String r3 = (java.lang.String) r3
            r1.originalOffset = r3
            goto L_0x0395
        L_0x032b:
            java.lang.String r3 = (java.lang.String) r3
            r1.stereo3dTypeName = r3
            goto L_0x0395
        L_0x0331:
            java.lang.String r3 = (java.lang.String) r3
            r1.sphereMappingTypeName = r3
            goto L_0x0395
        L_0x0337:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.exposureDataSize = r3
            goto L_0x0395
        L_0x033c:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.gyroDataSize = r3
            goto L_0x0395
        L_0x0341:
            java.lang.String r3 = (java.lang.String) r3
            r1.captureCameraName = r3
            goto L_0x0395
        L_0x0346:
            java.lang.String r3 = (java.lang.String) r3
            r1.offset = r3
            goto L_0x0395
        L_0x034b:
            java.lang.String r3 = (java.lang.String) r3
            r1.path = r3
            goto L_0x0395
        L_0x0350:
            java.lang.String r3 = (java.lang.String) r3
            r1.videoCodecName = r3
            goto L_0x0395
        L_0x0355:
            java.lang.Double r3 = (java.lang.Double) r3
            r1.videoDurationS = r3
            goto L_0x0395
        L_0x035a:
            java.lang.Double r3 = (java.lang.Double) r3
            r1.videoFramerate = r3
            goto L_0x0395
        L_0x035f:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.height = r3
            goto L_0x0395
        L_0x0364:
            java.lang.Integer r3 = (java.lang.Integer) r3
            r1.width = r3
            goto L_0x0395
        L_0x0369:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            r1.hasAudio = r3
            goto L_0x0395
        L_0x036e:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            r1.hasVideo = r3
            goto L_0x0395
        L_0x0373:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            r1.isNormalPlane = r3
            goto L_0x0395
        L_0x0378:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            r1.isStaticTimelapseVideo = r3
            goto L_0x0395
        L_0x037d:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            r1.isBulletTimeVideo = r3
            goto L_0x0395
        L_0x0382:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            r1.isPanoFormat = r3
            goto L_0x0395
        L_0x0387:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            r1.isFisheye3dFormat = r3
            goto L_0x0395
        L_0x038c:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            r1.isInsFormat = r3
            goto L_0x0395
        L_0x0391:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            r1.isVideo = r3
        L_0x0395:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.graphicpath.render.source.AssetInfo.set(java.lang.String, java.lang.Object):void");
    }

    private void setBoolean(String str, boolean z) {
        set(str, Boolean.valueOf(z));
    }

    private void setDouble(String str, double d2) {
        set(str, Double.valueOf(d2));
    }

    private void setInt(String str, int i2) {
        set(str, Integer.valueOf(i2));
    }

    private void setLong(String str, long j2) {
        set(str, Long.valueOf(j2));
    }

    private void setString(String str, String str2) {
        set(str, str2);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
