package com.arashivision.graphicpath.render.rendermodel.feature;

import com.arashivision.graphicpath.render.source.ImageAsset;
import com.arashivision.insbase.joml.Vector3f;

public final class LogoFeatureState {
    public ImageAsset asset;
    public boolean enabled;
    public Vector3f position;
    public float size;

    public LogoFeatureState(boolean z, float f2, Vector3f vector3f, ImageAsset imageAsset) {
        this.enabled = z;
        this.size = f2;
        this.position = vector3f;
        this.asset = imageAsset;
    }

    public ImageAsset getAsset() {
        return this.asset;
    }

    public Vector3f getPosition() {
        return this.position;
    }

    public float getSize() {
        return this.size;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setAsset(ImageAsset imageAsset) {
        this.asset = imageAsset;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setPosition(Vector3f vector3f) {
        this.position = vector3f;
    }

    public void setSize(float f2) {
        this.size = f2;
    }
}
