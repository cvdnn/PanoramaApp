package com.baidu.picapture.model.spin;

import java.util.List;

public class SpinPackageDetail {
    public ExportUrlsBean exportUrls;
    public FailedReasonBean failedReason;
    public List<?> hotspotRes;
    public ImageUrlsBean imageUrls;
    public MaterialPropertiesBean materialProperties;
    public String materialState;
    public String materialType;
    public String materialUrl;
    public String materialUuid;
    public Object packageDesc;
    public String packageId;
    public String packageName;
    public PackagePropertiesBean packageProperties;
    public SdkConfigUrlsBean sdkConfigUrls;
    public String source;
    public String thumbnailUrl;
    public long uploadedDt;
    public VrLoadingUrlsBean vrLoadingUrls;

    public static class ExportUrlsBean {
    }

    public static class FailedReasonBean {
    }

    public static class ImageUrlsBean {
        public List<OriginBean> origin;
        public List<PreviewBean> preview;

        public static class OriginBean {
            public int height;
            public String sceneDir;
            public String sceneName;
            public String viewUrl;
            public int width;

            public int getHeight() {
                return this.height;
            }

            public String getSceneDir() {
                return this.sceneDir;
            }

            public String getSceneName() {
                return this.sceneName;
            }

            public String getViewUrl() {
                return this.viewUrl;
            }

            public int getWidth() {
                return this.width;
            }

            public void setHeight(int i2) {
                this.height = i2;
            }

            public void setSceneDir(String str) {
                this.sceneDir = str;
            }

            public void setSceneName(String str) {
                this.sceneName = str;
            }

            public void setViewUrl(String str) {
                this.viewUrl = str;
            }

            public void setWidth(int i2) {
                this.width = i2;
            }
        }

        public static class PreviewBean {
            public int height;
            public String sceneDir;
            public String sceneName;
            public String viewUrl;
            public int width;

            public int getHeight() {
                return this.height;
            }

            public String getSceneDir() {
                return this.sceneDir;
            }

            public String getSceneName() {
                return this.sceneName;
            }

            public String getViewUrl() {
                return this.viewUrl;
            }

            public int getWidth() {
                return this.width;
            }

            public void setHeight(int i2) {
                this.height = i2;
            }

            public void setSceneDir(String str) {
                this.sceneDir = str;
            }

            public void setSceneName(String str) {
                this.sceneName = str;
            }

            public void setViewUrl(String str) {
                this.viewUrl = str;
            }

            public void setWidth(int i2) {
                this.width = i2;
            }
        }

        public List<OriginBean> getOrigin() {
            return this.origin;
        }

        public List<PreviewBean> getPreview() {
            return this.preview;
        }

        public void setOrigin(List<OriginBean> list) {
            this.origin = list;
        }

        public void setPreview(List<PreviewBean> list) {
            this.preview = list;
        }
    }

    public static class MaterialPropertiesBean {
    }

    public static class PackagePropertiesBean {
    }

    public static class SdkConfigUrlsBean {
        public String preview;

        public String getPreview() {
            return this.preview;
        }

        public void setPreview(String str) {
            this.preview = str;
        }
    }

    public static class VrLoadingUrlsBean {
        public String preview;

        public String getPreview() {
            return this.preview;
        }

        public void setPreview(String str) {
            this.preview = str;
        }
    }

    public ExportUrlsBean getExportUrls() {
        return this.exportUrls;
    }

    public FailedReasonBean getFailedReason() {
        return this.failedReason;
    }

    public List<?> getHotspotRes() {
        return this.hotspotRes;
    }

    public ImageUrlsBean getImageUrls() {
        return this.imageUrls;
    }

    public MaterialPropertiesBean getMaterialProperties() {
        return this.materialProperties;
    }

    public String getMaterialState() {
        return this.materialState;
    }

    public String getMaterialType() {
        return this.materialType;
    }

    public String getMaterialUrl() {
        return this.materialUrl;
    }

    public String getMaterialUuid() {
        return this.materialUuid;
    }

    public Object getPackageDesc() {
        return this.packageDesc;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public PackagePropertiesBean getPackageProperties() {
        return this.packageProperties;
    }

    public SdkConfigUrlsBean getSdkConfigUrls() {
        return this.sdkConfigUrls;
    }

    public String getSource() {
        return this.source;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public long getUploadedDt() {
        return this.uploadedDt;
    }

    public VrLoadingUrlsBean getVrLoadingUrls() {
        return this.vrLoadingUrls;
    }

    public void setExportUrls(ExportUrlsBean exportUrlsBean) {
        this.exportUrls = exportUrlsBean;
    }

    public void setFailedReason(FailedReasonBean failedReasonBean) {
        this.failedReason = failedReasonBean;
    }

    public void setHotspotRes(List<?> list) {
        this.hotspotRes = list;
    }

    public void setImageUrls(ImageUrlsBean imageUrlsBean) {
        this.imageUrls = imageUrlsBean;
    }

    public void setMaterialProperties(MaterialPropertiesBean materialPropertiesBean) {
        this.materialProperties = materialPropertiesBean;
    }

    public void setMaterialState(String str) {
        this.materialState = str;
    }

    public void setMaterialType(String str) {
        this.materialType = str;
    }

    public void setMaterialUrl(String str) {
        this.materialUrl = str;
    }

    public void setMaterialUuid(String str) {
        this.materialUuid = str;
    }

    public void setPackageDesc(Object obj) {
        this.packageDesc = obj;
    }

    public void setPackageId(String str) {
        this.packageId = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPackageProperties(PackagePropertiesBean packagePropertiesBean) {
        this.packageProperties = packagePropertiesBean;
    }

    public void setSdkConfigUrls(SdkConfigUrlsBean sdkConfigUrlsBean) {
        this.sdkConfigUrls = sdkConfigUrlsBean;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public void setUploadedDt(long j2) {
        this.uploadedDt = j2;
    }

    public void setVrLoadingUrls(VrLoadingUrlsBean vrLoadingUrlsBean) {
        this.vrLoadingUrls = vrLoadingUrlsBean;
    }
}
