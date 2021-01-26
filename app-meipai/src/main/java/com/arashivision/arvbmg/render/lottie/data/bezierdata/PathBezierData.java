package com.arashivision.arvbmg.render.lottie.data.bezierdata;

import java.util.List;

public class PathBezierData implements IBezierData {
    public List<List<float[]>> mPaths;

    public PathBezierData(List<List<float[]>> list) {
        this.mPaths = list;
    }

    public List<List<float[]>> getPaths() {
        return this.mPaths;
    }

    public void setPaths(List<List<float[]>> list) {
        this.mPaths = list;
    }
}
