package com.arashivision.bmgmedia.utils;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.arashivision.insbase.arlog.Log;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.IOException;

public class MetaParser {
    public static int getAudioTrackIndex(MediaExtractor mediaExtractor) {
        for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
            if (mediaExtractor.getTrackFormat(i2).getString("mime").startsWith("audio/")) {
                return i2;
            }
        }
        return -1;
    }

    public static int getVideoTrackIndex(MediaExtractor mediaExtractor) {
        for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
            if (mediaExtractor.getTrackFormat(i2).getString("mime").startsWith(FileUtils.VIDEO_FILE_START)) {
                return i2;
            }
        }
        return -1;
    }

    public MediaMeta parse(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            MediaMeta mediaMeta = new MediaMeta();
            int videoTrackIndex = getVideoTrackIndex(mediaExtractor);
            int audioTrackIndex = getAudioTrackIndex(mediaExtractor);
            String str2 = "durationUs";
            if (videoTrackIndex != -1) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(videoTrackIndex);
                if (trackFormat.containsKey(str2)) {
                    mediaMeta.videoDuration = ((double) trackFormat.getLong(str2)) / 1000.0d;
                }
                String str3 = "width";
                if (trackFormat.containsKey(str3)) {
                    mediaMeta.videoWidth = trackFormat.getInteger(str3);
                }
                String str4 = "height";
                if (trackFormat.containsKey(str4)) {
                    mediaMeta.videoHeight = trackFormat.getInteger(str4);
                }
                String str5 = "frame-rate";
                if (trackFormat.containsKey(str5)) {
                    float f2 = 0.0f;
                    try {
                        f2 = trackFormat.getFloat(str5);
                    } catch (Exception unused) {
                    }
                    double d2 = (double) f2;
                    if (d2 > 0.0d) {
                        mediaMeta.videoFps = d2;
                    } else {
                        mediaMeta.videoFps = (double) trackFormat.getInteger(str5);
                    }
                }
            }
            if (audioTrackIndex != -1) {
                MediaFormat trackFormat2 = mediaExtractor.getTrackFormat(videoTrackIndex);
                if (trackFormat2.containsKey(str2)) {
                    mediaMeta.audioDuration = (double) (trackFormat2.getLong(str2) / 1000);
                }
            }
            mediaExtractor.release();
            return mediaMeta;
        } catch (IOException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("failed parse file: ");
            sb.append(str);
            sb.append(", err: ");
            sb.append(e2);
            Log.e("ins", sb.toString());
            e2.printStackTrace();
            return null;
        }
    }
}
