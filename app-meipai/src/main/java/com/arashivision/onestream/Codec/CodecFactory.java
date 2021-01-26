package com.arashivision.onestream.Codec;

import android.media.MediaFormat;
import java.io.IOException;

public class CodecFactory {
    public static ICodec create(MediaFormat mediaFormat) throws IOException {
        String string = mediaFormat.getString("mime");
        if ("video/avc".equals(string)) {
            try {
                return MCodec.createDecoderByType(string);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
