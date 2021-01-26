package com.arashivision.graphicpath.render.engine.animator;

public class AccelerateDecelerateInterpolator implements TimeInterpolator {
    public float factor;

    public AccelerateDecelerateInterpolator(float f2) {
        this.factor = f2;
    }

    public float getFactor() {
        return this.factor;
    }
}
