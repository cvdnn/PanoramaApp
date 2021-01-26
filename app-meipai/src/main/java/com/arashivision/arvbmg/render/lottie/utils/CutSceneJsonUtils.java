package com.arashivision.arvbmg.render.lottie.utils;

import android.text.TextUtils;
import android.util.Log;
import com.arashivision.arvbmg.render.lottie.data.BezierKeyFrame;
import com.arashivision.arvbmg.render.lottie.data.CompositionData;
import com.arashivision.arvbmg.render.lottie.data.LayerData;
import com.arashivision.arvbmg.render.lottie.data.MaskData;
import com.arashivision.arvbmg.render.lottie.data.ShapeData;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.EffectData;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.EffectData.Type;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.IBezierData;
import com.arashivision.graphicpath.render.source.ExtraMetadataKey;
import com.baidu.mobstat.Config;
import e.c.f.n.n;
import e.g.b.e0.a;
import e.g.b.e0.b;
import e.g.b.e0.d;
import e.g.b.l;
import e.g.b.o;
import e.g.b.p;
import e.g.b.q;
import e.g.b.r;
import e.g.b.s;
import e.g.b.w;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class CutSceneJsonUtils {

    public interface IParseBezierKeyFrameDataCallback {
        IBezierData parse(o oVar);
    }

    public static float getValueFromJsonArrayOrJsonFloat(o oVar) {
        if (oVar == null) {
            return 0.0f;
        }
        if (oVar instanceof l) {
            return ((l) oVar).get(0).b();
        }
        return oVar.b();
    }

    public static List<BezierKeyFrame> parseBezierKeyFrame(o oVar, IParseBezierKeyFrameDataCallback iParseBezierKeyFrameDataCallback) {
        if (oVar != null && (oVar instanceof r)) {
            r e2 = oVar.e();
            o a2 = e2.a(Config.APP_VERSION_CODE);
            if (a2 != null) {
                ArrayList arrayList = new ArrayList();
                int c2 = a2.c();
                String str = Config.APP_KEY;
                if (c2 == 1) {
                    o a3 = e2.a(str);
                    if (a3 != null) {
                        l d2 = a3.d();
                        for (int i2 = 0; i2 < d2.size() - 1; i2++) {
                            BezierKeyFrame bezierKeyFrame = new BezierKeyFrame();
                            bezierKeyFrame.setNeedAnimation(true);
                            o oVar2 = d2.get(i2);
                            String str2 = "t";
                            if (oVar2 != null) {
                                r e3 = oVar2.e();
                                o a4 = e3.a("i");
                                if (a4 != null) {
                                    r e4 = a4.e();
                                    String str3 = Config.EVENT_HEAT_X;
                                    String str4 = "y";
                                    bezierKeyFrame.setInTangent(new float[]{getValueFromJsonArrayOrJsonFloat(e4.a(str3)), getValueFromJsonArrayOrJsonFloat(e4.a(str4))});
                                    o a5 = e3.a(Config.OS);
                                    if (a5 != null) {
                                        r e5 = a5.e();
                                        bezierKeyFrame.setOutTangent(new float[]{getValueFromJsonArrayOrJsonFloat(e5.a(str3)), getValueFromJsonArrayOrJsonFloat(e5.a(str4))});
                                    }
                                    o a6 = e3.a(str2);
                                    if (a6 != null) {
                                        bezierKeyFrame.setStartFrame(a6.c());
                                    }
                                    o a7 = e3.a("h");
                                    if (a7 != null) {
                                        bezierKeyFrame.setHold(a7.a());
                                    }
                                    if (iParseBezierKeyFrameDataCallback != null) {
                                        bezierKeyFrame.setStartData(iParseBezierKeyFrameDataCallback.parse(e3.a("s")));
                                        bezierKeyFrame.setEndData(iParseBezierKeyFrameDataCallback.parse(e3.a("e")));
                                    }
                                }
                            }
                            o oVar3 = d2.get(i2 + 1);
                            if (oVar3 != null) {
                                o a8 = oVar3.e().a(str2);
                                if (a8 != null) {
                                    bezierKeyFrame.setEndFrame(a8.c());
                                }
                            }
                            arrayList.add(bezierKeyFrame);
                        }
                    }
                } else {
                    BezierKeyFrame bezierKeyFrame2 = new BezierKeyFrame();
                    bezierKeyFrame2.setNeedAnimation(false);
                    if (iParseBezierKeyFrameDataCallback != null) {
                        bezierKeyFrame2.setDefaultData(iParseBezierKeyFrameDataCallback.parse(e2.a(str)));
                    }
                    arrayList.add(bezierKeyFrame2);
                }
                return arrayList;
            }
        }
        return null;
    }

    public static CompositionData parseCutSceneJson(String str) {
        a aVar;
        String str2;
        String str3;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        CompositionData compositionData = new CompositionData();
        try {
            aVar = new a(new StringReader(str));
            str2 = " to Json";
            str3 = "Failed parsing JSON source: ";
            z = aVar.f8541b;
            aVar.f8541b = true;
            o a2 = n.a(aVar);
            aVar.f8541b = z;
            if (a2 != null) {
                if (!(a2 instanceof q)) {
                    if (aVar.A() != b.END_DOCUMENT) {
                        throw new w("Did not consume the entire document.");
                    }
                }
                r e2 = a2.e();
                o a3 = e2.a("v");
                if (a3 != null) {
                    compositionData.setVersion(a3.g());
                }
                String str4 = "nm";
                o a4 = e2.a(str4);
                if (a4 != null) {
                    compositionData.setName(a4.g());
                }
                o a5 = e2.a(Config.DEVICE_WIDTH);
                if (a5 != null) {
                    compositionData.setWidth(a5.c());
                }
                o a6 = e2.a("h");
                if (a6 != null) {
                    compositionData.setHeight(a6.c());
                }
                o a7 = e2.a(ExtraMetadataKey.kIp);
                if (a7 != null) {
                    compositionData.setMinFrame(a7.c());
                }
                o a8 = e2.a(Config.OPERATOR);
                if (a8 != null) {
                    compositionData.setMaxFrame(a8.c());
                }
                o a9 = e2.a("fr");
                if (a9 != null) {
                    compositionData.setFrameRate(a9.c());
                }
                ArrayList arrayList = new ArrayList();
                compositionData.setLayerList(arrayList);
                o a10 = e2.a("layers");
                if (a10 != null) {
                    l d2 = a10.d();
                    for (int i2 = 0; i2 < d2.size(); i2++) {
                        o oVar = d2.get(i2);
                        if (oVar != null) {
                            o a11 = oVar.e().a(str4);
                            if (a11 != null) {
                                LayerData parseLayer = parseLayer(oVar, compositionData.getWidth(), compositionData.getHeight());
                                if (parseLayer != null) {
                                    String trim = a11.g().trim();
                                    char c2 = 65535;
                                    switch (trim.hashCode()) {
                                        case -41957070:
                                            if (trim.equals("layer A")) {
                                                c2 = 0;
                                                break;
                                            }
                                            break;
                                        case -41957069:
                                            if (trim.equals("layer B")) {
                                                c2 = 1;
                                                break;
                                            }
                                            break;
                                    }
                                    if (c2 == 0) {
                                        arrayList.add(0, parseLayer);
                                    } else if (c2 == 1) {
                                        arrayList.add(parseLayer);
                                    }
                                }
                            }
                        }
                    }
                }
                return compositionData;
            }
            throw null;
        } catch (StackOverflowError e3) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(aVar);
            sb.append(str2);
            throw new s(sb.toString(), e3);
        } catch (OutOfMemoryError e4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(aVar);
            sb2.append(str2);
            throw new s(sb2.toString(), e4);
        } catch (d e5) {
            throw new w((Throwable) e5);
        } catch (IOException e6) {
            throw new p((Throwable) e6);
        } catch (NumberFormatException e7) {
            throw new w((Throwable) e7);
        } catch (Throwable th) {
            aVar.f8541b = z;
            throw th;
        }
    }

    public static EffectData parseEffect(o oVar, int i2, int i3) {
        if (oVar == null) {
            return null;
        }
        EffectData effectData = new EffectData();
        r e2 = oVar.e();
        o a2 = e2.a(Config.EXCEPTION_CRASH_CHANNEL);
        if (a2 != null) {
            int c2 = a2.c();
            o a3 = e2.a("nm");
            if (a3 != null) {
                effectData.setName(a3.g());
            }
            String str = "ef";
            if (c2 == 5) {
                effectData.setType(Type.Radial);
                effectData.setRadialAmount(parseEffectRadialAmount(e2.a(str)));
                effectData.setRadialCenter(parseEffectRadialCenter(e2.a(str), i2, i3));
                effectData.setRadialType(parseEffectRadialType(e2.a(str)));
            } else if (c2 != 29) {
                StringBuilder sb = new StringBuilder();
                sb.append("unknown effect data type: ");
                sb.append(c2);
                Log.w("CutSceneJsonUtils", sb.toString());
            } else {
                effectData.setType(Type.Gaussian);
                effectData.setGaussianBlurriness(parseEffectGaussianBlurriness(e2.a(str)));
                effectData.setGaussianDimensions(parseEffectGaussianDimensions(e2.a(str)));
            }
        }
        return effectData;
    }

    public static List<BezierKeyFrame> parseEffectGaussianBlurriness(o oVar) {
        if (oVar != null) {
            l d2 = oVar.d();
            for (int i2 = 0; i2 < d2.size(); i2++) {
                o oVar2 = d2.get(i2);
                if (oVar2 != null) {
                    r e2 = oVar2.e();
                    o a2 = e2.a(Config.EXCEPTION_CRASH_CHANNEL);
                    if (a2 != null) {
                        int c2 = a2.c();
                        if (c2 == 0) {
                            return parseBezierKeyFrame(e2.a("v"), new IParseBezierKeyFrameDataCallback() {
                                public IBezierData parse(o oVar) {
                                    return BezierDataUtils.createFloat(oVar);
                                }
                            });
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("unknown gaussian blur type: ");
                        sb.append(c2);
                        Log.w("CutSceneJsonUtils", sb.toString());
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public static List<BezierKeyFrame> parseEffectGaussianDimensions(o oVar) {
        if (oVar != null) {
            l d2 = oVar.d();
            for (int i2 = 0; i2 < d2.size(); i2++) {
                o oVar2 = d2.get(i2);
                if (oVar2 != null) {
                    r e2 = oVar2.e();
                    o a2 = e2.a(Config.EXCEPTION_CRASH_CHANNEL);
                    o a3 = e2.a("nm");
                    if (!(a2 == null || a3 == null)) {
                        int c2 = a2.c();
                        String g2 = a3.g();
                        if (c2 == 7 && "Blur Dimensions".equals(g2)) {
                            return parseBezierKeyFrame(e2.a("v"), new IParseBezierKeyFrameDataCallback() {
                                public IBezierData parse(o oVar) {
                                    return BezierDataUtils.createInt(oVar);
                                }
                            });
                        }
                    }
                }
            }
        }
        return null;
    }

    public static List<BezierKeyFrame> parseEffectRadialAmount(o oVar) {
        if (oVar != null) {
            l d2 = oVar.d();
            for (int i2 = 0; i2 < d2.size(); i2++) {
                o oVar2 = d2.get(i2);
                if (oVar2 != null) {
                    r e2 = oVar2.e();
                    o a2 = e2.a(Config.EXCEPTION_CRASH_CHANNEL);
                    if (a2 != null) {
                        int c2 = a2.c();
                        if (c2 == 0) {
                            return parseBezierKeyFrame(e2.a("v"), new IParseBezierKeyFrameDataCallback() {
                                public IBezierData parse(o oVar) {
                                    return BezierDataUtils.createFloat(oVar);
                                }
                            });
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("unknown radial blur type: ");
                        sb.append(c2);
                        Log.w("CutSceneJsonUtils", sb.toString());
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public static List<BezierKeyFrame> parseEffectRadialCenter(o oVar, final int i2, final int i3) {
        if (oVar != null) {
            l d2 = oVar.d();
            for (int i4 = 0; i4 < d2.size(); i4++) {
                o oVar2 = d2.get(i4);
                if (oVar2 != null) {
                    r e2 = oVar2.e();
                    o a2 = e2.a(Config.EXCEPTION_CRASH_CHANNEL);
                    if (a2 != null) {
                        int c2 = a2.c();
                        if (c2 == 3) {
                            return parseBezierKeyFrame(e2.a("v"), new IParseBezierKeyFrameDataCallback() {
                                public IBezierData parse(o oVar) {
                                    return BezierDataUtils.createPoint(oVar, i2, i3);
                                }
                            });
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("unknown radial blur type: ");
                        sb.append(c2);
                        Log.w("CutSceneJsonUtils", sb.toString());
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public static List<BezierKeyFrame> parseEffectRadialType(o oVar) {
        if (oVar != null) {
            l d2 = oVar.d();
            for (int i2 = 0; i2 < d2.size(); i2++) {
                o oVar2 = d2.get(i2);
                if (oVar2 != null) {
                    r e2 = oVar2.e();
                    o a2 = e2.a(Config.EXCEPTION_CRASH_CHANNEL);
                    o a3 = e2.a("nm");
                    if (!(a2 == null || a3 == null)) {
                        int c2 = a2.c();
                        String g2 = a3.g();
                        if (c2 == 7 && "Type".equals(g2)) {
                            return parseBezierKeyFrame(e2.a("v"), new IParseBezierKeyFrameDataCallback() {
                                public IBezierData parse(o oVar) {
                                    return BezierDataUtils.createInt(oVar);
                                }
                            });
                        }
                    }
                }
            }
        }
        return null;
    }

    public static LayerData parseLayer(o oVar, int i2, int i3) {
        LayerData layerData = new LayerData();
        r e2 = oVar.e();
        o a2 = e2.a("ind");
        if (a2 != null) {
            layerData.setIndex(a2.c());
        }
        o a3 = e2.a("nm");
        if (a3 != null) {
            layerData.setName(a3.g());
        }
        String str = Config.EXCEPTION_CRASH_CHANNEL;
        o a4 = e2.a(str);
        if (a4 != null) {
            int c2 = a4.c();
            if (c2 < LayerData.Type.values().length) {
                layerData.setType(LayerData.Type.values()[c2]);
            }
            if (c2 == 0) {
                o a5 = e2.a(Config.DEVICE_WIDTH);
                if (a5 != null) {
                    layerData.setWidth(a5.c());
                }
                o a6 = e2.a("h");
                if (a6 != null) {
                    layerData.setHeight(a6.c());
                }
            } else if (c2 != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("unknown layer data type: ");
                sb.append(c2);
                Log.w("CutSceneJsonUtils", sb.toString());
            } else {
                o a7 = e2.a("sw");
                if (a7 != null) {
                    layerData.setWidth(a7.c());
                }
                o a8 = e2.a("sh");
                if (a8 != null) {
                    layerData.setHeight(a8.c());
                }
                if (e2.a(Config.STAT_SDK_CHANNEL) != null) {
                    layerData.setColor(a8.g());
                }
            }
        }
        o a9 = e2.a(ExtraMetadataKey.kIp);
        if (a9 != null) {
            layerData.setStartFrame(a9.c());
        }
        o a10 = e2.a(Config.OPERATOR);
        if (a10 != null) {
            layerData.setEndFrame(a10.c());
        }
        ArrayList arrayList = new ArrayList();
        layerData.setShapeList(arrayList);
        o a11 = e2.a("shapes");
        if (a11 != null) {
            l d2 = a11.d();
            if (d2.size() > 0) {
                o oVar2 = d2.get(0);
                if (oVar2 != null) {
                    r e3 = oVar2.e();
                    o a12 = e3.a(str);
                    if (a12 != null && a12.g().equals("gr")) {
                        a11 = e3.a("it");
                    }
                    List parseShape = parseShape(a11, i2, i3);
                    if (parseShape != null) {
                        arrayList.addAll(parseShape);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        layerData.setEffectList(arrayList2);
        o a13 = e2.a("ef");
        if (a13 != null) {
            l d3 = a13.d();
            for (int i4 = 0; i4 < d3.size(); i4++) {
                EffectData parseEffect = parseEffect(d3.get(i4), i2, i3);
                if (parseEffect != null) {
                    arrayList2.add(parseEffect);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        layerData.setMaskList(arrayList3);
        o a14 = e2.a("masksProperties");
        if (a14 != null) {
            l d4 = a14.d();
            for (int i5 = 0; i5 < d4.size(); i5++) {
                MaskData parseMask = parseMask(d4.get(i5), i2, i3);
                if (parseMask != null) {
                    arrayList3.add(parseMask);
                }
            }
        }
        return layerData;
    }

    public static MaskData parseMask(o oVar, final int i2, final int i3) {
        if (oVar == null) {
            return null;
        }
        MaskData maskData = new MaskData();
        r e2 = oVar.e();
        o a2 = e2.a("nm");
        if (a2 != null) {
            maskData.setName(a2.g());
        }
        o a3 = e2.a(Config.CELL_LOCATION);
        if (a3 != null) {
            maskData.setClosed(a3.a());
        }
        o a4 = e2.a("inv");
        if (a4 != null) {
            maskData.setInverted(a4.a());
        }
        o a5 = e2.a("mode");
        if (a5 != null) {
            String g2 = a5.g();
            char c2 = 65535;
            int hashCode = g2.hashCode();
            if (hashCode != 97) {
                if (hashCode != 105) {
                    if (hashCode == 115 && g2.equals("s")) {
                        c2 = 1;
                    }
                } else if (g2.equals("i")) {
                    c2 = 2;
                }
            } else if (g2.equals(Config.APP_VERSION_CODE)) {
                c2 = 0;
            }
            if (c2 == 0) {
                maskData.setType(MaskData.Type.Add);
            } else if (c2 == 1) {
                maskData.setType(MaskData.Type.Subtract);
            } else if (c2 != 2) {
                StringBuilder sb = new StringBuilder();
                sb.append("unknown mask data mode: ");
                sb.append(g2);
                Log.w("CutSceneJsonUtils", sb.toString());
            } else {
                maskData.setType(MaskData.Type.Intersect);
            }
        }
        maskData.setMaskShape(parseBezierKeyFrame(e2.a(Config.PLATFORM_TYPE), new IParseBezierKeyFrameDataCallback() {
            public IBezierData parse(o oVar) {
                return BezierDataUtils.createPath(oVar, i2, i3);
            }
        }));
        maskData.setOpacity(parseBezierKeyFrame(e2.a(Config.OS), new IParseBezierKeyFrameDataCallback() {
            public IBezierData parse(o oVar) {
                return BezierDataUtils.createFloat(oVar);
            }
        }));
        maskData.setExpansion(parseBezierKeyFrame(e2.a(Config.EVENT_HEAT_X), new IParseBezierKeyFrameDataCallback() {
            public IBezierData parse(o oVar) {
                return BezierDataUtils.createFloat(oVar);
            }
        }));
        return maskData;
    }

    public static List<ShapeData> parseShape(o oVar, int i2, int i3) {
        Object obj;
        if (oVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        l d2 = oVar.d();
        for (int i4 = 0; i4 < d2.size(); i4++) {
            o oVar2 = d2.get(i4);
            if (oVar2 != null) {
                o a2 = oVar2.e().a(Config.EXCEPTION_CRASH_CHANNEL);
                if (a2 != null) {
                    String g2 = a2.g();
                    char c2 = 65535;
                    if (g2.hashCode() == 3710 && g2.equals("tr")) {
                        c2 = 0;
                    }
                    if (c2 != 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("unknown shape data type: ");
                        sb.append(g2);
                        Log.w("CutSceneJsonUtils", sb.toString());
                        obj = null;
                    } else {
                        obj = parseShapeTransform(oVar2, i2, i3);
                    }
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
            }
        }
        return arrayList;
    }

    public static ShapeData parseShapeRectangle(o oVar, final int i2, final int i3) {
        if (oVar == null) {
            return null;
        }
        ShapeData shapeData = new ShapeData();
        shapeData.setType(ShapeData.Type.Rectangle);
        r e2 = oVar.e();
        o a2 = e2.a("nm");
        if (a2 != null) {
            shapeData.setName(a2.g());
        }
        shapeData.setPosition(parseBezierKeyFrame(e2.a("p"), new IParseBezierKeyFrameDataCallback() {
            public IBezierData parse(o oVar) {
                return BezierDataUtils.createPoint(oVar, i2, i3);
            }
        }));
        shapeData.setCornerRadius(parseBezierKeyFrame(e2.a("r"), new IParseBezierKeyFrameDataCallback() {
            public IBezierData parse(o oVar) {
                return BezierDataUtils.createFloat(oVar);
            }
        }));
        shapeData.setSize(parseBezierKeyFrame(e2.a("s"), new IParseBezierKeyFrameDataCallback() {
            public IBezierData parse(o oVar) {
                return BezierDataUtils.createSize(oVar);
            }
        }));
        return shapeData;
    }

    public static ShapeData parseShapeTransform(o oVar, final int i2, final int i3) {
        if (oVar == null) {
            return null;
        }
        ShapeData shapeData = new ShapeData();
        shapeData.setType(ShapeData.Type.Transform);
        r e2 = oVar.e();
        o a2 = e2.a("nm");
        if (a2 != null) {
            shapeData.setName(a2.g());
        }
        shapeData.setPosition(parseBezierKeyFrame(e2.a("p"), new IParseBezierKeyFrameDataCallback() {
            public IBezierData parse(o oVar) {
                return BezierDataUtils.createPoint(oVar, i2, i3);
            }
        }));
        shapeData.setAnchor(parseBezierKeyFrame(e2.a(Config.APP_VERSION_CODE), new IParseBezierKeyFrameDataCallback() {
            public IBezierData parse(o oVar) {
                return BezierDataUtils.createPoint(oVar, i2, i3);
            }
        }));
        shapeData.setScale(parseBezierKeyFrame(e2.a("s"), new IParseBezierKeyFrameDataCallback() {
            public IBezierData parse(o oVar) {
                return BezierDataUtils.createScale(oVar);
            }
        }));
        shapeData.setRotation(parseBezierKeyFrame(e2.a("r"), new IParseBezierKeyFrameDataCallback() {
            public IBezierData parse(o oVar) {
                return BezierDataUtils.createFloat(oVar);
            }
        }));
        shapeData.setOpacity(parseBezierKeyFrame(e2.a(Config.OS), new IParseBezierKeyFrameDataCallback() {
            public IBezierData parse(o oVar) {
                return BezierDataUtils.createFloat(oVar);
            }
        }));
        return shapeData;
    }
}
