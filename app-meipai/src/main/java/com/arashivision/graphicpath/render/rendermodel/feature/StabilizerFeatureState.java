package com.arashivision.graphicpath.render.rendermodel.feature;

import com.arashivision.graphicpath.render.util.Stabilizer;

public final class StabilizerFeatureState {
    public boolean enabled;
    public Stabilizer stabilizer;

    public StabilizerFeatureState(Stabilizer stabilizer2, boolean z) {
        this.stabilizer = stabilizer2;
        this.enabled = z;
    }

    public Stabilizer getStabilizer() {
        return this.stabilizer;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setStabilizer(Stabilizer stabilizer2) {
        this.stabilizer = stabilizer2;
    }
}
