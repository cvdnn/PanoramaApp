package com.arashivision.arvbmg.previewer;

import com.arashivision.arvbmg.previewer.BMGPreviewerSource.EntireBgmSourceClip;
import com.arashivision.arvbmg.previewer.BMGPreviewerSource.ImageSourceClip;

public class BMGPreviewerSourceBuilder {
    public static BMGPreviewerSource buildPreviwerSouce(BMGSourceClip[] bMGSourceClipArr, String str) {
        return buildPreviwerSouce(bMGSourceClipArr, str, false);
    }

    public static BMGPreviewerSource buildPreviwerSouce(BMGSourceClip[] bMGSourceClipArr, EntireBgmSourceClip entireBgmSourceClip, double d2, String str) {
        BMGPreviewerSource bMGPreviewerSource = new BMGPreviewerSource(bMGSourceClipArr, false, entireBgmSourceClip, d2);
        return bMGPreviewerSource.setCutSceneDir(str);
    }

    public static BMGPreviewerSource buildPreviwerSouce(ImageSourceClip[] imageSourceClipArr, String str) {
        return new BMGPreviewerSource(imageSourceClipArr, false).setCutSceneDir(str);
    }

    public static BMGPreviewerSource buildPreviwerSouce(BMGSourceClip[] bMGSourceClipArr, String str, boolean z) {
        return new BMGPreviewerSource(bMGSourceClipArr, z).setCutSceneDir(str);
    }
}
