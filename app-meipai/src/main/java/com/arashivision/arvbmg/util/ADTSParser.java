package com.arashivision.arvbmg.util;

public class ADTSParser {

    public static class AAC_FORMAT {
        public static final int AAC_FORMAT_ADTS = 1;
        public static final int AAC_FORMAT_ERROR_PACEKT_SIZE = -6;
        public static final int AAC_FORMAT_LOAD_ERROR = -10;
        public static final int AAC_FORMAT_NEXT_SAMPLE_EOF = -8;
        public static final int AAC_FORMAT_NEXT_SAMPLE_ERROR = -7;
        public static final int AAC_FORMAT_NO_AUDIO_ERROR = -9;
        public static final int AAC_FORMAT_RAW = 0;
    }

    static {
        ARVBMGLibsLoader.load();
    }

    public static native int checkIsAdts(String str);
}
