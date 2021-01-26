package com.arashivision.bmgmedia.test;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.arashivision.bmgmedia.NativeLibsLoader;
import com.arashivision.insbase.arlog.Log;
import com.sina.weibo.sdk.utils.FileUtils;
import e.a.a.a.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Decode {
    static {
        NativeLibsLoader.load();
    }

    public static native void decodeCodecPacketFile(String str, int i2, int i3, String str2);

    public static native void decodeFile(String str, int i2, boolean z, boolean z2);

    public static void decodeJava(String str) {
        try {
            decodeJavaInternal(str);
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("failed decode(java): ");
            sb.append(e2);
            Log.e("ins", sb.toString());
            e2.printStackTrace();
        }
    }

    public static void decodeJavaInternal(String str) throws Exception {
        long j2;
        boolean z;
        FpsLoggr fpsLoggr = new FpsLoggr("decode java");
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(getVideoTrackIndex(mediaExtractor));
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
        StringBuilder a2 = a.a("using codec: ");
        a2.append(createDecoderByType.getName());
        Log.i("@@@@", a2.toString());
        trackFormat.setInteger("color-format", 2135033992);
        trackFormat.setInteger("frame-rate", 150);
        boolean z2 = false;
        createDecoderByType.configure(trackFormat, null, null, 0);
        createDecoderByType.start();
        mediaExtractor.selectTrack(getVideoTrackIndex(mediaExtractor));
        BufferInfo bufferInfo = new BufferInfo();
        int i2 = 0;
        int i3 = 0;
        boolean z3 = false;
        while (!z3) {
            String str2 = "ins";
            if (!z2) {
                int dequeueInputBuffer = createDecoderByType.dequeueInputBuffer(1000);
                if (dequeueInputBuffer >= 0) {
                    int readSampleData = mediaExtractor.readSampleData(createDecoderByType.getInputBuffer(dequeueInputBuffer), i2);
                    int i4 = i3 + 1;
                    if (readSampleData < 0 || i4 >= 700) {
                        Log.d(str2, "saw input EOS.");
                        readSampleData = i2;
                        j2 = 0;
                        z = true;
                    } else {
                        j2 = mediaExtractor.getSampleTime();
                        z = z2;
                    }
                    int sampleFlags = mediaExtractor.getSampleFlags();
                    if (z) {
                        sampleFlags |= 4;
                    }
                    int i5 = dequeueInputBuffer;
                    int i6 = readSampleData;
                    long j3 = j2;
                    int i7 = i4;
                    createDecoderByType.queueInputBuffer(i5, 0, i6, j3, sampleFlags);
                    if (!z) {
                        mediaExtractor.advance();
                    }
                    z2 = z;
                    i3 = i7;
                }
            }
            int dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 1000);
            if (dequeueOutputBuffer >= 0) {
                fpsLoggr.inc();
                createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, true);
                if ((bufferInfo.flags & 4) != 0) {
                    Log.d(str2, "saw output EOS.");
                    z3 = true;
                }
            } else if (dequeueOutputBuffer == -2) {
                MediaFormat outputFormat = createDecoderByType.getOutputFormat();
                StringBuilder sb = new StringBuilder();
                sb.append("output format has changed to ");
                sb.append(outputFormat);
                Log.d(str2, sb.toString());
            }
            i2 = 0;
        }
        createDecoderByType.stop();
        createDecoderByType.release();
        mediaExtractor.release();
        fpsLoggr.summarize();
    }

    public static void dumpColorFormats(String str) {
        MediaCodecInfo[] codecInfos;
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                int i2 = 0;
                while (true) {
                    if (i2 < supportedTypes.length) {
                        if (supportedTypes[i2].equalsIgnoreCase(str) && !mediaCodecInfo.getName().startsWith("OMX.google.") && !mediaCodecInfo.getName().toLowerCase().contains("ffmpeg") && mediaCodecInfo.getName().toLowerCase().startsWith("omx.")) {
                            arrayList.add(mediaCodecInfo);
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
        }
        if (arrayList.size() != 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CodecCapabilities capabilitiesForType = ((MediaCodecInfo) it.next()).getCapabilitiesForType(str);
                capabilitiesForType.getVideoCapabilities();
                capabilitiesForType.getEncoderCapabilities();
                for (int valueOf : capabilitiesForType.colorFormats) {
                    Log.i("ins", String.format("support color format: 0x%x", new Object[]{Integer.valueOf(valueOf)}));
                }
            }
        }
    }

    public static MediaCodecInfo[] getCodecInfos() {
        return new MediaCodecList(1).getCodecInfos();
    }

    public static int getVideoTrackIndex(MediaExtractor mediaExtractor) throws IOException {
        for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
            if (mediaExtractor.getTrackFormat(i2).getString("mime").startsWith(FileUtils.VIDEO_FILE_START)) {
                return i2;
            }
        }
        throw new IOException("no video track in file");
    }
}
