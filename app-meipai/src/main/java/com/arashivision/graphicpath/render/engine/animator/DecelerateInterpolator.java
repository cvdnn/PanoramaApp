package com.arashivision.graphicpath.render.engine.animator;

public class DecelerateInterpolator implements TimeInterpolator {
    public float factor;

    public DecelerateInterpolator(float f2) {
        this.factor = f2;
    }

    public float getFactor() {
        return this.factor;
    }
}
