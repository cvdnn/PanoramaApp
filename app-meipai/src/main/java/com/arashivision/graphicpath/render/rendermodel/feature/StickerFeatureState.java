package com.arashivision.graphicpath.render.rendermodel.feature;

import com.arashivision.graphicpath.render.source.ImageAsset;
import com.arashivision.insbase.joml.Vector3f;
import java.util.ArrayList;

public class StickerFeatureState {
    public int nextId = 1;
    public ArrayList<StickerSetup> stickers;

    public static class StickerSetup {
        public ImageAsset asset;
        public boolean enablePositionRoll;
        public Vector3f position;
        public float rotation;
        public float size;
        public int stickerId = -1;

        public StickerSetup(float f2, Vector3f vector3f, ImageAsset imageAsset, float f3, boolean z) {
            this.size = f2;
            this.position = vector3f;
            this.asset = imageAsset;
            this.rotation = f3;
            this.enablePositionRoll = z;
        }

        public ImageAsset getAsset() {
            return this.asset;
        }

        public Vector3f getPosition() {
            return this.position;
        }

        public float getRotation() {
            return this.rotation;
        }

        public float getSize() {
            return this.size;
        }

        public int getStickerId() {
            return this.stickerId;
        }

        public boolean isEnablePositionRoll() {
            return this.enablePositionRoll;
        }

        public void setAsset(ImageAsset imageAsset) {
            this.asset = imageAsset;
        }

        public void setEnablePositionRoll(boolean z) {
            this.enablePositionRoll = z;
        }

        public void setPosition(Vector3f vector3f) {
            this.position = vector3f;
        }

        public void setRotation(float f2) {
            this.rotation = f2;
        }

        public void setSize(float f2) {
            this.size = f2;
        }

        public void setStickerId(int i2) {
            this.stickerId = i2;
        }
    }

    public int getNextId() {
        return this.nextId;
    }

    public ArrayList<StickerSetup> getStickers() {
        return this.stickers;
    }

    public void setNextId(int i2) {
        this.nextId = i2;
    }

    public void setStickers(ArrayList<StickerSetup> arrayList) {
        this.stickers = arrayList;
    }
}
