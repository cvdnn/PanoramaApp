package com.deepai.paipai.support.bean;

import android.graphics.Point;
import java.io.Serializable;

public class HideInfo implements Serializable {
    public static final int TYPE_NON = 0;
    public static final int TYPE_RECORD = 2;
    public static final int TYPE_RECORD_LOCAL = 3;
    public static final int TYPE_TEXT = 1;
    private String recordUrl;
    private String recordUrlLocal;
    private String text;
    private int type;
    private int x;
    private int y;

    public HideInfo(Point point) {
        setPoint(point);
    }

    public Point getPoint() {
        return new Point(this.x, this.y);
    }

    public void setPoint(Point point) {
        this.x = point.x;
        this.y = point.y;
        this.type = 0;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text2) {
        this.type = 1;
        this.text = text2;
    }

    public String getRecordUrl() {
        return this.recordUrl;
    }

    public void setRecordUrl(String recordUrl2) {
        this.type = 2;
        this.recordUrl = recordUrl2;
    }

    public String getRecordUrlLocal() {
        return this.recordUrlLocal;
    }

    public void setRecordUrlLocal(String recordUrlLocal2) {
        this.type = 3;
        this.recordUrlLocal = recordUrlLocal2;
    }

    public int getType() {
        return this.type;
    }
}
