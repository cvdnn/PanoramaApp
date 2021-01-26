package com.arashivision.insta360.basemedia.export.task.single.params.video;

import a.a.a.a.c.a.d.d.a.b;
import a.a.a.a.c.a.d.d.a.c;
import java.util.List;

public interface IExportVideoParams {
    int getBitrate();

    int getFps();

    b getFrameInput();

    List<Long> getFrameTimestampList();

    int getHeight();

    c getImageDownloader();

    String getMetaDataMake();

    String getMetaDataModel();

    int getMp4Type();

    String getPath();

    int getPriorityFpsDen();

    int getPriorityFpsNum();

    int getRenderModelType();

    float getStarrySkyK();

    int getWidth();

    boolean isApplyFlash();

    boolean isApplyWatermark();

    boolean isStarrySkyEnabled();

    boolean isTurnBack();

    boolean isUseSoftwareDecoder();

    boolean isUseSoftwareEncoder();

    void setApplyFlash(boolean z);

    void setApplyWatermark(boolean z);

    void setBitrate(int i2);

    void setFps(int i2);

    void setFrameInput(b bVar);

    void setFrameTimestampList(List<Long> list);

    void setHeight(int i2);

    void setImageDownloader(c cVar);

    void setMetaDataMake(String str);

    void setMetaDataModel(String str);

    void setMp4Type(int i2);

    void setPath(String str);

    void setPriorityFpsDen(int i2);

    void setPriorityFpsNum(int i2);

    void setRenderModelType(int i2);

    void setStarrySkyEnabled(boolean z);

    void setStarrySkyK(float f2);

    void setTurnBack(boolean z);

    void setUseSoftwareDecoder(boolean z);

    void setUseSoftwareEncoder(boolean z);

    void setWidth(int i2);
}
