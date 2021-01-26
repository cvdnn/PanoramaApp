package com.arashivision.onecamera.render;

import e.a.a.a.a;

public class RenderMode {
    public RenderMethod renderMethod;
    public Type type;

    /* renamed from: com.arashivision.onecamera.render.RenderMode$1 reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$arashivision$onecamera$render$RenderMode$Type;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.arashivision.onecamera.render.RenderMode$Type[] r0 = com.arashivision.onecamera.render.RenderMode.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$arashivision$onecamera$render$RenderMode$Type = r0
                r1 = 1
                com.arashivision.onecamera.render.RenderMode$Type r2 = com.arashivision.onecamera.render.RenderMode.Type.DirectDecoding     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$arashivision$onecamera$render$RenderMode$Type     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.arashivision.onecamera.render.RenderMode$Type r2 = com.arashivision.onecamera.render.RenderMode.Type.WithGLRenderer     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onecamera.render.RenderMode.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        DirectDecoding,
        WithGLRenderer
    }

    public RenderMode(Type type2, RenderMethod renderMethod2) {
        this.type = type2;
        this.renderMethod = renderMethod2;
    }

    public static RenderMode directDecoding() {
        return new RenderMode(Type.DirectDecoding, null);
    }

    public static RenderMode withGlRenderer(RenderMethod renderMethod2) {
        return new RenderMode(Type.WithGLRenderer, renderMethod2);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (RenderMode.class != obj.getClass()) {
            return false;
        }
        RenderMode renderMode = (RenderMode) obj;
        int ordinal = this.type.ordinal();
        if (ordinal == 0) {
            if (renderMode.type == Type.DirectDecoding) {
                z = true;
            }
            return z;
        } else if (ordinal != 1) {
            return false;
        } else {
            if (renderMode.type == Type.WithGLRenderer && renderMode.renderMethod == this.renderMethod) {
                z = true;
            }
            return z;
        }
    }

    public String toString() {
        int ordinal = this.type.ordinal();
        if (ordinal == 0) {
            return "{DirectDecoding}";
        }
        if (ordinal != 1) {
            return super.toString();
        }
        StringBuilder a2 = a.a("{WithGLRenderer, method: ");
        a2.append(this.renderMethod);
        a2.append("}");
        return a2.toString();
    }
}
