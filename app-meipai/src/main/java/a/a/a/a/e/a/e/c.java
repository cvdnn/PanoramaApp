package a.a.a.a.e.a.e;

import com.arashivision.arvbmg.render.lottie.data.CompositionData;
import com.arashivision.arvbmg.render.lottie.utils.CutSceneJsonUtils;
import com.arashivision.arvbmg.transition.TransState;
import com.arashivision.arvbmg.transition.TransitionInfo;
import com.arashivision.arvbmg.transition.TransitionProcessor;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.ui.player.video.IVideoParams;
import com.arashivision.insta360.basemedia.util.FovDistanceUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: g reason: collision with root package name */
    public static MediaLogger f495g = MediaLogger.getLogger(c.class);

    /* renamed from: a reason: collision with root package name */
    public a.a.a.a.e.a.i.c f496a;

    /* renamed from: b reason: collision with root package name */
    public a f497b;

    /* renamed from: c reason: collision with root package name */
    public TransitionProcessor[] f498c;

    /* renamed from: d reason: collision with root package name */
    public Transform[] f499d;

    /* renamed from: e reason: collision with root package name */
    public int[] f500e;

    /* renamed from: f reason: collision with root package name */
    public double f501f;

    public class a {

        /* renamed from: a reason: collision with root package name */
        public long f502a;

        /* renamed from: b reason: collision with root package name */
        public long f503b;

        /* renamed from: c reason: collision with root package name */
        public CompositionData f504c;
    }

    public static long a(a.a.a.a.e.a.i.c cVar) {
        if (cVar.f582a.f593c) {
            return ((long) cVar.f583b) + 1000;
        }
        return (long) cVar.f583b;
    }

    public final TransState a(Transform transform, int[] iArr) {
        TransState transState = new TransState();
        transState.distance = (double) FovDistanceUtils.convertBmgDistanceToRajawaliDistance(transform.getDistance());
        transState.fov = FovDistanceUtils.convertYFovToXFov(Math.toDegrees((double) transform.getFov()), iArr[0], iArr[1]);
        transState.yaw = Math.toDegrees((double) transform.getYaw());
        transState.pitch = Math.toDegrees((double) transform.getPitch());
        transState.roll = Math.toDegrees((double) transform.getRoll());
        return transState;
    }

    public final Transform a(TransState transState, int[] iArr) {
        Transform transform = new Transform();
        transform.setDistance(FovDistanceUtils.convertRajawaliDistanceToBmgDistance((float) transState.distance));
        transform.setFov((float) Math.toRadians((double) FovDistanceUtils.convertXFovToYFov(transState.fov, iArr[0], iArr[1])));
        transform.setYaw((float) Math.toRadians(transState.yaw));
        transform.setPitch((float) Math.toRadians(transState.pitch));
        transform.setRoll((float) Math.toRadians(transState.roll));
        return transform;
    }

    public final Transform a(Transform transform, Transform transform2, float f2) {
        while (((double) Math.abs(transform2.getYaw() - transform.getYaw())) > 3.141592653589793d) {
            transform2.setYaw((float) (transform2.getYaw() > transform.getYaw() ? ((double) transform2.getYaw()) - 6.283185307179586d : ((double) transform2.getYaw()) + 6.283185307179586d));
        }
        while (((double) Math.abs(transform2.getPitch() - transform.getPitch())) > 3.141592653589793d) {
            transform2.setPitch((float) (transform2.getPitch() > transform.getPitch() ? ((double) transform2.getPitch()) - 6.283185307179586d : ((double) transform2.getPitch()) + 6.283185307179586d));
        }
        while (((double) Math.abs(transform2.getRoll() - transform.getRoll())) > 3.141592653589793d) {
            transform2.setRoll((float) (transform2.getRoll() > transform.getRoll() ? ((double) transform2.getRoll()) - 6.283185307179586d : ((double) transform2.getRoll()) + 6.283185307179586d));
        }
        Transform transform3 = new Transform();
        transform3.setDistance(((transform2.getDistance() - transform.getDistance()) * f2) + transform.getDistance());
        transform3.setFov(((transform2.getFov() - transform.getFov()) * f2) + transform.getFov());
        transform3.setYaw(((transform2.getYaw() - transform.getYaw()) * f2) + transform.getYaw());
        transform3.setPitch(((transform2.getPitch() - transform.getPitch()) * f2) + transform.getPitch());
        transform3.setRoll(((transform2.getRoll() - transform.getRoll()) * f2) + transform.getRoll());
        return transform3;
    }

    public final Float[] a(IVideoParams iVideoParams, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        Float valueOf = Float.valueOf(0.0f);
        Float valueOf2 = Float.valueOf(1.0f);
        Float[] fArr = {valueOf, valueOf2, valueOf, valueOf2};
        if (!FileType.UNPANORAMA.equals(iVideoParams.getFileType())) {
            return fArr;
        }
        float width = (float) iVideoParams.getWidth();
        float height = (float) iVideoParams.getHeight();
        float f2 = (float) i4;
        float f3 = (float) i5;
        if ((width * 1.0f) / height == (f2 * 1.0f) / f3) {
            return fArr;
        }
        if (i5 > i4) {
            fArr[0] = valueOf;
            fArr[1] = valueOf2;
            float f4 = (((height * 1.0f) / width) * f2) / f3;
            fArr[2] = Float.valueOf((1.0f - f4) / 2.0f);
            fArr[3] = Float.valueOf((f4 + 1.0f) / 2.0f);
        } else if (i4 == i5) {
            fArr[0] = valueOf;
            fArr[1] = valueOf2;
            float f5 = (height * 1.0f) / width;
            fArr[2] = Float.valueOf((1.0f - f5) / 2.0f);
            fArr[3] = Float.valueOf((f5 + 1.0f) / 2.0f);
        }
        MediaLogger mediaLogger = f495g;
        StringBuilder a2 = e.a.a.a.a.a("minX = ");
        a2.append(fArr[0]);
        a2.append(", maxX = ");
        a2.append(fArr[1]);
        a2.append(", minY = ");
        a2.append(fArr[2]);
        a2.append(", maxY = ");
        a2.append(fArr[3]);
        mediaLogger.i(a2.toString());
        return fArr;
    }

    public void a(Transform[] transformArr, int[] iArr) {
        Transform[] transformArr2 = transformArr;
        int[] iArr2 = iArr;
        this.f499d = transformArr2;
        this.f500e = iArr2;
        a.a.a.a.e.a.i.c.a aVar = this.f496a.f582a;
        if (aVar.f593c) {
            this.f498c = new TransitionProcessor[2];
            TransitionInfo readTransitionJsonStr = TransitionProcessor.readTransitionJsonStr(aVar.f591a);
            TransitionProcessor[] transitionProcessorArr = this.f498c;
            TransitionProcessor transitionProcessor = new TransitionProcessor(a(transformArr2[0], iArr2), readTransitionJsonStr.layerInfo1, 0, (long) this.f496a.f583b);
            transitionProcessorArr[0] = transitionProcessor;
            this.f498c[0].isOpen();
            TransitionProcessor[] transitionProcessorArr2 = this.f498c;
            TransitionProcessor transitionProcessor2 = new TransitionProcessor(a(transformArr2[1], iArr2), readTransitionJsonStr.layerInfo2, 0, (long) this.f496a.f583b);
            transitionProcessorArr2[1] = transitionProcessor2;
            this.f498c[1].isOpen();
            try {
                JSONObject jSONObject = new JSONObject(this.f496a.f582a.f591a).getJSONObject("transitions");
                int i2 = jSONObject.getInt("startPoint");
                int i3 = jSONObject.getInt("endPoint");
                a aVar2 = new a();
                this.f497b = aVar2;
                aVar2.f502a = ((long) (i2 * this.f496a.f583b)) / readTransitionJsonStr.frameCount;
                aVar2.f503b = ((long) (i3 * this.f496a.f583b)) / readTransitionJsonStr.frameCount;
                aVar2.f504c = CutSceneJsonUtils.parseCutSceneJson(this.f496a.f582a.f592b.f591a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else {
            a aVar3 = new a();
            this.f497b = aVar3;
            aVar3.f502a = 0;
            a.a.a.a.e.a.i.c cVar = this.f496a;
            aVar3.f503b = (long) cVar.f583b;
            aVar3.f504c = CutSceneJsonUtils.parseCutSceneJson(cVar.f582a.f591a);
        }
    }
}
