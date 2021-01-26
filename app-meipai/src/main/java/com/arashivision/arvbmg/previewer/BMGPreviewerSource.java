package com.arashivision.arvbmg.previewer;

import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.graphicpath.insmedia.previewer2.PreviewerSource;
import com.arashivision.graphicpath.insmedia.previewer2.TimeScale;
import e.a.a.a.a;
import java.util.Arrays;
import java.util.List;

public final class BMGPreviewerSource {
    public final EntireBgmSourceClip bgm;
    public final double bgmAudioWeight;
    public final BMGSourceClip[] clips;
    public String cutSceneDir;
    public final boolean disableAllAudioInClips;
    public final double originAudioWeight;

    public static class ClipTimeScale {
        public final double endTimeInSrc;
        public final double repeatToFps;
        public final double scale;
        public final double startTimeInSrc;
        public final boolean videoKeyframeOnly;

        public ClipTimeScale(double d2, double d3, double d4) {
            this(d2, d3, d4, false, 0.0d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClipTimeScale) {
                ClipTimeScale clipTimeScale = (ClipTimeScale) obj;
                if (this.startTimeInSrc == clipTimeScale.startTimeInSrc && this.endTimeInSrc == clipTimeScale.endTimeInSrc && Double.compare(this.scale, clipTimeScale.scale) == 0 && Double.compare(this.repeatToFps, clipTimeScale.repeatToFps) == 0) {
                    return true;
                }
            }
            return false;
        }

        public final double getEndTimeInSrc() {
            return this.endTimeInSrc;
        }

        public final double getRepeatToFps() {
            return this.repeatToFps;
        }

        public final double getScale() {
            return this.scale;
        }

        public final double getStartTimeInSrc() {
            return this.startTimeInSrc;
        }

        public boolean isVideoKeyframeOnly() {
            return this.videoKeyframeOnly;
        }

        public String toString() {
            StringBuilder a2 = a.a("ClipTimeScale(startTimeInSrc=");
            a2.append(this.startTimeInSrc);
            a2.append(", endTimeInSrc=");
            a2.append(this.endTimeInSrc);
            a2.append(", scale=");
            a2.append(this.scale);
            a2.append(", repeatToFps=");
            a2.append(this.repeatToFps);
            a2.append(")");
            return a2.toString();
        }

        public ClipTimeScale(double d2, double d3, double d4, boolean z, double d5) {
            this.startTimeInSrc = d2;
            this.endTimeInSrc = d3;
            this.scale = d4;
            this.videoKeyframeOnly = z;
            this.repeatToFps = d5;
        }
    }

    public static final class EntireBgmSourceClip {
        public final double afadeInDurationMs;
        public final double afadeOutDurationMs;
        public final double endTimeMs;
        public final double offsetMsFirstTimePlaying;
        public final double srcDuration;
        public final String url;
        public final double volume;

        public EntireBgmSourceClip(String str, double d2, double d3, double d4) {
            this(str, d2, d3, d4, 1.0d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EntireBgmSourceClip) {
                EntireBgmSourceClip entireBgmSourceClip = (EntireBgmSourceClip) obj;
                if (this.url.equals(entireBgmSourceClip.url) && this.offsetMsFirstTimePlaying == entireBgmSourceClip.offsetMsFirstTimePlaying && this.endTimeMs == entireBgmSourceClip.endTimeMs && Double.compare(this.volume, entireBgmSourceClip.volume) == 0 && this.afadeInDurationMs == entireBgmSourceClip.afadeInDurationMs && this.afadeOutDurationMs == entireBgmSourceClip.afadeOutDurationMs) {
                    return true;
                }
            }
            return false;
        }

        public final double getAfadeInDurationMs() {
            return this.afadeInDurationMs;
        }

        public final double getAfadeOutDurationMs() {
            return this.afadeOutDurationMs;
        }

        public final double getEndTimeMs() {
            return this.endTimeMs;
        }

        public final double getOffsetMsFirstTimePlaying() {
            return this.offsetMsFirstTimePlaying;
        }

        public double getSrcDuration() {
            return this.srcDuration;
        }

        public final String getUrl() {
            return this.url;
        }

        public final double getVolume() {
            return this.volume;
        }

        public String toString() {
            StringBuilder a2 = a.a("EntireBgmSourceClip(url=");
            a2.append(this.url);
            a2.append(", offsetMsFirstTimePlaying=");
            a2.append(this.offsetMsFirstTimePlaying);
            a2.append(", endTimeMs=");
            a2.append(this.endTimeMs);
            a2.append(", volume=");
            a2.append(this.volume);
            a2.append(", afadeInDurationMs=");
            a2.append(this.afadeInDurationMs);
            a2.append(", afadeOutDurationMs=");
            a2.append(this.afadeOutDurationMs);
            a2.append(")");
            return a2.toString();
        }

        public EntireBgmSourceClip(String str, double d2, double d3, double d4, double d5) {
            this(str, d2, d3, d4, d5, 0.0d, 0.0d);
        }

        public EntireBgmSourceClip(String str, double d2, double d3, double d4, double d5, double d6, double d7) {
            this.url = str;
            this.offsetMsFirstTimePlaying = d2;
            this.endTimeMs = d3;
            this.srcDuration = d4;
            this.volume = d5;
            this.afadeInDurationMs = d6;
            this.afadeOutDurationMs = d7;
        }
    }

    public static class FileSourceClip extends BMGSourceClip {
        public final double afadeInDurationMs;
        public final double afadeOutDurationMs;
        public final float ambientSoundWeight;
        public final double audioVolume;
        public final double endCutscenesDurationMs;
        public final double endTimeInSrc;
        public final boolean hasAudio;
        public final double minTimeScaleApplyed;
        public final double muteBgmForRangeTimeScaleLessThan;
        public final double srcTotalDuration;
        public final double startTimeInSrc;
        public final ClipTimeScale[] timeScales;
        public final double videoFramerate;
        public final float voiceWeight;

        public FileSourceClip(List<String> list, double d2, double d3, double d4, double d5, boolean z, ClipTimeScale[] clipTimeScaleArr, double d6, double d7, double d8, double d9, double d10, long[] jArr, float f2, float f3, double d11) {
            this.url = list;
            this.startTimeInSrc = d2;
            this.endTimeInSrc = d3;
            this.srcTotalDuration = d4;
            this.hasAudio = z;
            this.muteBgmForRangeTimeScaleLessThan = d5;
            this.timeScales = clipTimeScaleArr;
            this.endCutscenesDurationMs = d6;
            this.minTimeScaleApplyed = d7;
            this.audioVolume = d8;
            this.afadeInDurationMs = d9;
            this.afadeOutDurationMs = d10;
            this.mediaPartSize = jArr;
            this.ambientSoundWeight = f2;
            this.voiceWeight = f3;
            this.videoFramerate = d11;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof FileSourceClip)) {
                    return false;
                }
                FileSourceClip fileSourceClip = (FileSourceClip) obj;
                List<String> list = this.url;
                if (!(list.equals(list) && this.startTimeInSrc == fileSourceClip.startTimeInSrc && this.endTimeInSrc == fileSourceClip.endTimeInSrc && this.hasAudio == fileSourceClip.hasAudio && Arrays.equals(this.timeScales, fileSourceClip.timeScales) && this.endCutscenesDurationMs == fileSourceClip.endCutscenesDurationMs && Double.compare(this.minTimeScaleApplyed, fileSourceClip.minTimeScaleApplyed) == 0 && Double.compare(this.audioVolume, fileSourceClip.audioVolume) == 0 && this.afadeInDurationMs == fileSourceClip.afadeInDurationMs && this.afadeOutDurationMs == fileSourceClip.afadeOutDurationMs)) {
                    return false;
                }
            }
            return true;
        }

        public final double getAfadeInDurationMs() {
            return this.afadeInDurationMs;
        }

        public final double getAfadeOutDurationMs() {
            return this.afadeOutDurationMs;
        }

        public float getAmbientSoundWeight() {
            return this.ambientSoundWeight;
        }

        public final double getAudioVolume() {
            return this.audioVolume;
        }

        public final double getEndCutscenesDurationMs() {
            return this.endCutscenesDurationMs;
        }

        public final double getEndTimeInSrc() {
            return this.endTimeInSrc;
        }

        public final double getMinTimeScaleApplyed() {
            return this.minTimeScaleApplyed;
        }

        public double getMuteBgmForRangeTimeScaleLessThan() {
            return this.muteBgmForRangeTimeScaleLessThan;
        }

        public double getSrcTotalDuration() {
            return this.srcTotalDuration;
        }

        public final double getStartTimeInSrc() {
            return this.startTimeInSrc;
        }

        public final ClipTimeScale[] getTimeScales() {
            return this.timeScales;
        }

        public double getVideoFramerate() {
            return this.videoFramerate;
        }

        public float getVoiceWeight() {
            return this.voiceWeight;
        }

        public boolean isHasAudio() {
            return this.hasAudio;
        }

        public String toString() {
            StringBuilder a2 = a.a("FileSourceClip(url=");
            a2.append(this.url);
            a2.append(", startTimeInSrc=");
            a2.append(this.startTimeInSrc);
            a2.append(", endTimeInSrc=");
            a2.append(this.endTimeInSrc);
            a2.append(", hasAudio=");
            a2.append(this.hasAudio);
            a2.append(", timeScales=");
            a2.append(Arrays.toString(this.timeScales));
            a2.append(", endCutscenesDurationMs=");
            a2.append(this.endCutscenesDurationMs);
            a2.append(", minTimeScaleApplyed=");
            a2.append(this.minTimeScaleApplyed);
            a2.append(", audioVolume=");
            a2.append(this.audioVolume);
            a2.append(", afadeInDurationMs=");
            a2.append(this.afadeInDurationMs);
            a2.append(", afadeOutDurationMs=");
            a2.append(this.afadeOutDurationMs);
            a2.append(")");
            return a2.toString();
        }
    }

    public static class ImageSourceClip extends BMGSourceClip {
        public final double duration;
        public final double endCutscenesDurationMs;
        public final double fps;

        public ImageSourceClip(String str, double d2, double d3, double d4, long[] jArr) {
            this(Arrays.asList(new String[]{str}), d2, d3, d4, jArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ImageSourceClip) {
                ImageSourceClip imageSourceClip = (ImageSourceClip) obj;
                if (this.url.equals(imageSourceClip.url) && this.duration == imageSourceClip.duration && Double.compare(this.fps, imageSourceClip.fps) == 0 && this.endCutscenesDurationMs == imageSourceClip.endCutscenesDurationMs) {
                    return true;
                }
            }
            return false;
        }

        public final double getDuration() {
            return this.duration;
        }

        public final double getEndCutscenesDurationMs() {
            return this.endCutscenesDurationMs;
        }

        public final double getFps() {
            return this.fps;
        }

        public String toString() {
            StringBuilder a2 = a.a("ImageSourceClip(url=");
            a2.append(this.url);
            a2.append(", duration=");
            a2.append(this.duration);
            a2.append(", fps=");
            a2.append(this.fps);
            a2.append(", endCutscenesDurationMs=");
            a2.append(this.endCutscenesDurationMs);
            a2.append(")");
            return a2.toString();
        }

        public ImageSourceClip(List<String> list, double d2, double d3, double d4, long[] jArr) {
            this.url = list;
            this.duration = d2;
            this.fps = d3;
            this.endCutscenesDurationMs = d4;
            this.mediaPartSize = jArr;
        }
    }

    public BMGPreviewerSource(BMGSourceClip bMGSourceClip) {
        this(new BMGSourceClip[]{bMGSourceClip}, false);
    }

    public static PreviewerSource create(BMGPreviewerSource bMGPreviewerSource) {
        BMGSourceClip[] bMGSourceClipArr;
        PreviewerSource previewerSource;
        int i2;
        PreviewerSource previewerSource2 = new PreviewerSource();
        previewerSource2.setOriginAudioDisable(bMGPreviewerSource.getDisableAllAudioInClips());
        if (bMGPreviewerSource.getBgm() != null) {
            previewerSource2.setBgm(bMGPreviewerSource.getBgm().getUrl(), bMGPreviewerSource.getBgm().getSrcDuration(), bMGPreviewerSource.getBgm().getOffsetMsFirstTimePlaying(), bMGPreviewerSource.getBgmAudioWeight(), bMGPreviewerSource.getBgm().getVolume(), bMGPreviewerSource.getBgm().getAfadeInDurationMs(), bMGPreviewerSource.getBgm().getAfadeOutDurationMs());
        }
        BMGSourceClip[] clips2 = bMGPreviewerSource.getClips();
        int i3 = 0;
        while (i3 < clips2.length) {
            if (clips2[i3] instanceof FileSourceClip) {
                FileSourceClip fileSourceClip = (FileSourceClip) clips2[i3];
                ClipTimeScale[] timeScales = fileSourceClip.getTimeScales();
                TimeScale[] timeScaleArr = null;
                if (timeScales != null && timeScales.length > 0) {
                    timeScaleArr = new TimeScale[timeScales.length];
                    for (int i4 = 0; i4 < timeScales.length; i4++) {
                        ClipTimeScale clipTimeScale = timeScales[i4];
                        TimeScale timeScale = new TimeScale(clipTimeScale.getStartTimeInSrc(), clipTimeScale.getEndTimeInSrc(), clipTimeScale.getScale(), clipTimeScale.getRepeatToFps(), clipTimeScale.isVideoKeyframeOnly());
                        timeScaleArr[i4] = timeScale;
                    }
                }
                previewerSource = previewerSource2;
                int i5 = i3;
                bMGSourceClipArr = clips2;
                previewerSource.addFileClip((String[]) fileSourceClip.getUrls().toArray(), fileSourceClip.isHasAudio(), fileSourceClip.getStartTimeInSrc(), fileSourceClip.getEndTimeInSrc(), fileSourceClip.getSrcTotalDuration(), fileSourceClip.getEndCutscenesDurationMs(), timeScaleArr, fileSourceClip.getMuteBgmForRangeTimeScaleLessThan(), fileSourceClip.getAudioVolume(), fileSourceClip.getAfadeInDurationMs(), fileSourceClip.getAfadeOutDurationMs(), fileSourceClip.getMediaPartSizes(), fileSourceClip.getAmbientSoundWeight(), fileSourceClip.getVoiceWeight(), fileSourceClip.getVideoFramerate());
                i2 = i5;
            } else {
                i2 = i3;
                bMGSourceClipArr = clips2;
                previewerSource = previewerSource2;
                if (bMGSourceClipArr[i2] instanceof ImageSourceClip) {
                    ImageSourceClip imageSourceClip = (ImageSourceClip) bMGSourceClipArr[i2];
                    previewerSource.addImage(imageSourceClip.getUrl(), imageSourceClip.getDuration(), imageSourceClip.getEndCutscenesDurationMs(), imageSourceClip.getFps(), imageSourceClip.getMediaPartSize());
                } else {
                    a.c(" PreviewerSource create other souceClip index ", i2, BMGConstants.TAG);
                }
            }
            i3 = i2 + 1;
            previewerSource2 = previewerSource;
            clips2 = bMGSourceClipArr;
        }
        return previewerSource2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BMGPreviewerSource) {
            BMGPreviewerSource bMGPreviewerSource = (BMGPreviewerSource) obj;
            if (Arrays.equals(this.clips, bMGPreviewerSource.clips) && this.disableAllAudioInClips == bMGPreviewerSource.disableAllAudioInClips && this.bgm.equals(bMGPreviewerSource.bgm) && Double.compare(this.originAudioWeight, bMGPreviewerSource.originAudioWeight) == 0 && Double.compare(this.bgmAudioWeight, bMGPreviewerSource.bgmAudioWeight) == 0) {
                return true;
            }
        }
        return false;
    }

    public final EntireBgmSourceClip getBgm() {
        return this.bgm;
    }

    public final double getBgmAudioWeight() {
        return this.bgmAudioWeight;
    }

    public final BMGSourceClip[] getClips() {
        return this.clips;
    }

    public String getCutSceneDir() {
        return this.cutSceneDir;
    }

    public final boolean getDisableAllAudioInClips() {
        return this.disableAllAudioInClips;
    }

    public final double getOriginAudioWeight() {
        return this.originAudioWeight;
    }

    public BMGPreviewerSource setCutSceneDir(String str) {
        this.cutSceneDir = str;
        return this;
    }

    public String toString() {
        StringBuilder a2 = a.a("BMGPreviewerSource(clips=");
        a2.append(Arrays.toString(this.clips));
        a2.append(", disableAllAudioInClips=");
        a2.append(this.disableAllAudioInClips);
        a2.append(", bgm=");
        a2.append(this.bgm);
        a2.append(", originAudioWeight=");
        a2.append(this.originAudioWeight);
        a2.append(", bgmAudioWeight=");
        a2.append(this.bgmAudioWeight);
        a2.append(")");
        return a2.toString();
    }

    public BMGPreviewerSource(BMGSourceClip[] bMGSourceClipArr) {
        this(bMGSourceClipArr, false);
    }

    public BMGPreviewerSource(BMGSourceClip[] bMGSourceClipArr, boolean z) {
        this(bMGSourceClipArr, z, null, 1.0d);
    }

    public BMGPreviewerSource(BMGSourceClip[] bMGSourceClipArr, boolean z, EntireBgmSourceClip entireBgmSourceClip, double d2) {
        this.clips = bMGSourceClipArr;
        this.disableAllAudioInClips = z;
        this.bgm = entireBgmSourceClip;
        this.originAudioWeight = 1.0d;
        this.bgmAudioWeight = d2;
        this.cutSceneDir = BMGConstants.CUTSCENE_DIR;
        StringBuilder sb = new StringBuilder();
        sb.append(" BMGPreviewerSource disableAllAudioInClips ");
        sb.append(z);
        Log.i(BMGConstants.TAG, sb.toString());
    }
}
