package com.arashivision.arvbmg.exporter;

public class ExportInfo {
    public int bitrate;
    public boolean dashBoard;
    public EdgeInsets edge;
    public boolean enableX264Decoder;
    public boolean enableX264Encoder;
    public int encFormat;
    public int fps;
    public int height;
    public boolean iOS_needCompatibleAlbum;
    public boolean is3DLefRight;
    public boolean isSpherical;
    public int mImageTextureId = -1;
    public int maxBlurNum = 16;
    public String metadataComment;
    public String metadataMake;
    public String metadataModel;
    public boolean motionBlur;
    public int priorityFpsDen;
    public int priorityFpsNum;
    public int srcHeight;
    public int srcWidth;
    public boolean tailClear;
    public int type;
    public String url;
    public String videoEncodeTune;
    public String videoEncoderProfile;
    public Watermark watermark;
    public int width;
    public String x264Preset;

    public static class EdgeInsets {
        public int bottom;
        public double convertScale = 1.0d;
        public int convertType;
        public int left;
        public int right;
        public int top;

        public static class CONVERT_TYPE {
            public static final int NV12 = 3;
            public static final int RGB = 2;
            public static final int RGBA = 0;
            public static final int YUV420 = 1;
        }

        public int getBottom() {
            return this.bottom;
        }

        public double getConvertScale() {
            return this.convertScale;
        }

        public int getConvertType() {
            return this.convertType;
        }

        public int getLeft() {
            return this.left;
        }

        public int getRight() {
            return this.right;
        }

        public int getTop() {
            return this.top;
        }

        public void setBottom(int i2) {
            this.bottom = i2;
        }

        public void setConvertScale(double d2) {
            this.convertScale = d2;
        }

        public void setConvertType(int i2) {
            this.convertType = i2;
        }

        public void setLeft(int i2) {
            this.left = i2;
        }

        public void setRight(int i2) {
            this.right = i2;
        }

        public void setTop(int i2) {
            this.top = i2;
        }
    }

    public static class EncFormat {
        public static final int EN_NV12 = 23;
        public static final int EN_RGBA = 26;
        public static final int EN_YUV420 = 0;
    }

    public static class Rect {
        public int height;
        public int width;
        public int x;
        public int y;

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public void setHeight(int i2) {
            this.height = i2;
        }

        public void setWidth(int i2) {
            this.width = i2;
        }

        public void setX(int i2) {
            this.x = i2;
        }

        public void setY(int i2) {
            this.y = i2;
        }
    }

    public static class VideoType {
        public static final int FRAGMENT_MP4 = 1;
        public static final int NORMAL_MP4 = 0;
    }

    public static class Watermark {
        public Rect mRect;
        public int mWaterHeight;
        public byte[] mWaterMask;
        public int mWaterWidth;

        public Rect getmRect() {
            return this.mRect;
        }

        public int getmWaterHeight() {
            return this.mWaterHeight;
        }

        public byte[] getmWaterMask() {
            return this.mWaterMask;
        }

        public int getmWaterWidth() {
            return this.mWaterWidth;
        }

        public void setmRect(Rect rect) {
            this.mRect = rect;
        }

        public void setmWaterHeight(int i2) {
            this.mWaterHeight = i2;
        }

        public void setmWaterMask(byte[] bArr) {
            this.mWaterMask = bArr;
        }

        public void setmWaterWidth(int i2) {
            this.mWaterWidth = i2;
        }
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public EdgeInsets getEdge() {
        return this.edge;
    }

    public int getEncFormat() {
        return this.encFormat;
    }

    public int getFps() {
        return this.fps;
    }

    public int getHeight() {
        return this.height;
    }

    public int getMaxBlurNum() {
        return this.maxBlurNum;
    }

    public String getMetadataComment() {
        return this.metadataComment;
    }

    public String getMetadataMake() {
        return this.metadataMake;
    }

    public String getMetadataModel() {
        return this.metadataModel;
    }

    public int getPriorityFpsDen() {
        return this.priorityFpsDen;
    }

    public int getPriorityFpsNum() {
        return this.priorityFpsNum;
    }

    public int getSrcHeight() {
        return this.srcHeight;
    }

    public int getSrcWidth() {
        return this.srcWidth;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVideoEncodeTune() {
        return this.videoEncodeTune;
    }

    public String getVideoEncoderProfile() {
        return this.videoEncoderProfile;
    }

    public Watermark getWatermark() {
        return this.watermark;
    }

    public int getWidth() {
        return this.width;
    }

    public String getX264Preset() {
        return this.x264Preset;
    }

    public int getmImageTextureId() {
        return this.mImageTextureId;
    }

    public boolean isDashBoard() {
        return this.dashBoard;
    }

    public boolean isEnableX264Decoder() {
        return this.enableX264Decoder;
    }

    public boolean isEnableX264Encoder() {
        return this.enableX264Encoder;
    }

    public boolean isIs3DLefRight() {
        return this.is3DLefRight;
    }

    public boolean isMotionBlur() {
        return this.motionBlur;
    }

    public boolean isSpherical() {
        return this.isSpherical;
    }

    public boolean isTailClear() {
        return this.tailClear;
    }

    public boolean isiOS_needCompatibleAlbum() {
        return this.iOS_needCompatibleAlbum;
    }

    public void setBitrate(int i2) {
        this.bitrate = i2;
    }

    public void setDashBoard(boolean z) {
        this.dashBoard = z;
    }

    public void setEdge(EdgeInsets edgeInsets) {
        this.edge = edgeInsets;
    }

    public void setEnableX264Decoder(boolean z) {
        this.enableX264Decoder = z;
    }

    public void setEnableX264Encoder(boolean z) {
        this.enableX264Encoder = z;
    }

    public void setEncFormat(int i2) {
        this.encFormat = i2;
    }

    public void setFps(int i2) {
        this.fps = i2;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setIs3DLefRight(boolean z) {
        this.is3DLefRight = z;
    }

    public void setMaxBlurNum(int i2) {
        this.maxBlurNum = i2;
    }

    public void setMetadataComment(String str) {
        this.metadataComment = str;
    }

    public void setMetadataMake(String str) {
        this.metadataMake = str;
    }

    public void setMetadataModel(String str) {
        this.metadataModel = str;
    }

    public void setMotionBlur(boolean z) {
        this.motionBlur = z;
    }

    public void setPriorityFpsDen(int i2) {
        this.priorityFpsDen = i2;
    }

    public void setPriorityFpsNum(int i2) {
        this.priorityFpsNum = i2;
    }

    public void setSpherical(boolean z) {
        this.isSpherical = z;
    }

    public void setSrcHeight(int i2) {
        this.srcHeight = i2;
    }

    public void setSrcWidth(int i2) {
        this.srcWidth = i2;
    }

    public void setTailClear(boolean z) {
        this.tailClear = z;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVideoEncodeTune(String str) {
        this.videoEncodeTune = str;
    }

    public void setVideoEncoderProfile(String str) {
        this.videoEncoderProfile = str;
    }

    public void setWatermark(Watermark watermark2) {
        this.watermark = watermark2;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    public void setX264Preset(String str) {
        this.x264Preset = str;
    }

    public void setiOS_needCompatibleAlbum(boolean z) {
        this.iOS_needCompatibleAlbum = z;
    }

    public void setmImageTextureId(int i2) {
        this.mImageTextureId = i2;
    }
}
