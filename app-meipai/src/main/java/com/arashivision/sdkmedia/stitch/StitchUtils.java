package com.arashivision.sdkmedia.stitch;

import com.arashivision.arvbmg.hdr.Hdr;
import com.arashivision.graphicpath.render.source.ImageAsset;
import com.arashivision.insta360.basemedia.asset.AssetUtils;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.work.Work;
import com.arashivision.sdkmedia.work.WorkWrapper;
import e.a.a.a.a;
import java.io.File;
import java.util.UUID;

public class StitchUtils {

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public static final MediaLogger f357O8oO888 = MediaLogger.getLogger(StitchUtils.class);

    public static boolean generateHDR(WorkWrapper workWrapper, String str) {
        MediaLogger mediaLogger = f357O8oO888;
        StringBuilder a2 = a.a("GenerateHDR. work: ");
        a2.append(workWrapper.toString());
        a2.append(", outputPath: ");
        a2.append(str);
        mediaLogger.i(a2.toString());
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UUID.randomUUID());
        sb.append("tmp_hdr.jpg");
        File file2 = new File(parentFile, sb.toString());
        file2.delete();
        String[] urls = workWrapper.getUrls();
        String absolutePath = file2.getAbsolutePath();
        Work work = workWrapper.f358O8oO888;
        int doHdr = Hdr.doHdr(urls, work.getMediaOffset(), absolutePath);
        if (doHdr == 0) {
            ImageAsset imageAsset = new ImageAsset(absolutePath);
            imageAsset.appendNewExtraInfo(3);
            AssetUtils.setOffset(imageAsset, work.getOffset());
            AssetUtils.setCameraType(imageAsset, work.getCameraType());
            imageAsset.save();
        }
        if (doHdr < 0) {
            file2.delete();
            MediaLogger mediaLogger2 = f357O8oO888;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GenerateHDR getHDRFile Error ");
            sb2.append(doHdr);
            mediaLogger2.i(sb2.toString());
            return false;
        }
        file.delete();
        file2.renameTo(file);
        MediaLogger mediaLogger3 = f357O8oO888;
        StringBuilder a3 = a.a("GenerateHDR rename result: ");
        a3.append(file.exists());
        mediaLogger3.i(a3.toString());
        return file.exists();
    }
}
