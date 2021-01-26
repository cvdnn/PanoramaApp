package com.arashivision.graphicpath.insmedia.previewer2;

import java.util.HashMap;

public class PlayPosition {
    public double mediaTimeMs;
    public HashMap<String, PlayTrackPosition> trackPositions = new HashMap<>();

    public static class PlayTrackPosition {
        public int clipIndex;
        public double progressTimeMs;
        public double repeatMediaTimeOffsetMs;
        public double timeMs;
        public String trackName;

        public PlayTrackPosition(String str, int i2, double d2, double d3, double d4) {
            this.trackName = str;
            this.clipIndex = i2;
            this.timeMs = d2;
            this.repeatMediaTimeOffsetMs = d3;
            this.progressTimeMs = d4;
        }
    }

    public PlayPosition(double d2) {
        this.mediaTimeMs = d2;
    }
}
