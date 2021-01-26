package com.arashivision.arvbmg.util;

import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.arvbmg.previewer.BMGPreviewerSource;
import com.arashivision.arvbmg.previewer.BMGPreviewerSource.ClipTimeScale;
import com.arashivision.arvbmg.previewer.BMGPreviewerSource.FileSourceClip;
import com.arashivision.arvbmg.previewer.BMGPreviewerSource.ImageSourceClip;
import com.arashivision.arvbmg.previewer.BMGSourceClip;
import com.arashivision.graphicpath.insmedia.previewer2.PreviewerSource;
import com.arashivision.graphicpath.insmedia.previewer2.TimeScale;
import e.a.a.a.a;

public class PreviewerUtil {
    public static PreviewerSource getPreviewerSource(BMGPreviewerSource bMGPreviewerSource) {
        BMGSourceClip[] bMGSourceClipArr;
        PreviewerSource previewerSource;
        int i2;
        PreviewerSource previewerSource2 = new PreviewerSource();
        previewerSource2.setOriginAudioDisable(bMGPreviewerSource.getDisableAllAudioInClips());
        if (bMGPreviewerSource.getBgm() != null) {
            previewerSource2.setBgm(bMGPreviewerSource.getBgm().getUrl(), bMGPreviewerSource.getBgm().getSrcDuration(), bMGPreviewerSource.getBgm().getOffsetMsFirstTimePlaying(), bMGPreviewerSource.getBgmAudioWeight(), bMGPreviewerSource.getBgm().getVolume(), bMGPreviewerSource.getBgm().getAfadeInDurationMs(), bMGPreviewerSource.getBgm().getAfadeOutDurationMs());
        }
        BMGSourceClip[] clips = bMGPreviewerSource.getClips();
        int i3 = 0;
        while (i3 < clips.length) {
            if (clips[i3] instanceof FileSourceClip) {
                FileSourceClip fileSourceClip = (FileSourceClip) clips[i3];
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
                bMGSourceClipArr = clips;
                previewerSource.addFileClip((String[]) fileSourceClip.getUrls().toArray(), fileSourceClip.isHasAudio(), fileSourceClip.getStartTimeInSrc(), fileSourceClip.getEndTimeInSrc(), fileSourceClip.getSrcTotalDuration(), fileSourceClip.getEndCutscenesDurationMs(), timeScaleArr, fileSourceClip.getMuteBgmForRangeTimeScaleLessThan(), fileSourceClip.getAudioVolume(), fileSourceClip.getAfadeInDurationMs(), fileSourceClip.getAfadeOutDurationMs(), fileSourceClip.getMediaPartSizes(), fileSourceClip.getAmbientSoundWeight(), fileSourceClip.getVoiceWeight(), fileSourceClip.getVideoFramerate());
                i2 = i5;
            } else {
                i2 = i3;
                bMGSourceClipArr = clips;
                previewerSource = previewerSource2;
                if (bMGSourceClipArr[i2] instanceof ImageSourceClip) {
                    ImageSourceClip imageSourceClip = (ImageSourceClip) bMGSourceClipArr[i2];
                    previewerSource.addImage(imageSourceClip.getUrl(), imageSourceClip.getDuration(), imageSourceClip.getEndCutscenesDurationMs(), imageSourceClip.getFps(), imageSourceClip.getMediaPartSize());
                } else {
                    a.c(" other sourceClip index ", i2, BMGConstants.TAG);
                }
            }
            i3 = i2 + 1;
            previewerSource2 = previewerSource;
            clips = bMGSourceClipArr;
        }
        return previewerSource2;
    }
}
