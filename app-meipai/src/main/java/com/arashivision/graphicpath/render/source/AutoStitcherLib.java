package com.arashivision.graphicpath.render.source;

public class AutoStitcherLib {
    public static int ResolveLensTypeFromOffset(String str) {
        return nativeResolveLensTypeFromOffset(str);
    }

    public static native int nativeResolveLensTypeFromOffset(String str);
}
