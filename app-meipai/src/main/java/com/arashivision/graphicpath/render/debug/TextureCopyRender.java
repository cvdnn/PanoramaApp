package com.arashivision.graphicpath.render.debug;

public class TextureCopyRender extends NativeRender {
    public TextureCopyRender(int i2) {
        super(createNativeWrap(i2));
    }

    public static native long createNativeWrap(int i2);

    public void render(int i2) {
        super.nativeRender(i2);
    }
}
