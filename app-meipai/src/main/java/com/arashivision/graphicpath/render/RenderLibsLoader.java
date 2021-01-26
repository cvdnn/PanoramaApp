package com.arashivision.graphicpath.render;

import com.arashivision.graphicpath.insmedia.InsMediaLibsLoader;

public class RenderLibsLoader {
    public static boolean mLoaded;

    public static synchronized void load() {
        synchronized (RenderLibsLoader.class) {
            if (!mLoaded) {
                InsMediaLibsLoader.load();
                mLoaded = true;
            }
        }
    }
}
