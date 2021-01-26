package com.arashivision.arvbmg.longtracker;

import com.arashivision.graphicpath.render.engine.Transform;

public class LongTrackInfo {
    public float curentFov;
    public boolean detectAround = false;
    public boolean detectSkeleton = false;
    public boolean dynamicFov = true;
    public float headThreshold = 0.3f;
    public int intervalTrack = 0;
    public float maxFov;
    public float minFov;
    public String mnnPath;
    public String namePath;
    public int objectName = 0;
    public float objectRatio = 0.5f;
    public long offStartTime = -1;
    public int offscreenHeight = 416;
    public int offscreenWidth = 416;
    public String roiPath;
    public boolean rolling = false;
    public double screenX = 0.5d;
    public double screenY = 0.5d;
    public String skeletonCachePath;
    public String skeletonMnnPath;
    public float smoothFactor = 0.5f;
    public Transform transform = null;
    public String[] urls = null;
    public boolean useOffRenderOnly = false;
}
