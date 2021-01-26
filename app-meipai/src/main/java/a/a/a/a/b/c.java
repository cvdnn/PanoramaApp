package a.a.a.a.b;

public enum c {
    VIDEO_NORMAL(0),
    VIDEO_BULLETTIME(1),
    VIDEO_TIMELAPSE(2),
    PHOTO_NORMAL(3),
    PHOTO_HDR(4),
    PHOTO_INTERVALSHOOTING(5),
    VIDEO_HDR(6),
    PHOTO_BURST(7),
    VIDEO_STATIC_TIMELAPSE(8),
    VIDEO_TIMESHIFT(9),
    PHOTO_AEB_NIGHT_MODE(10);
    

    /* renamed from: a reason: collision with root package name */
    public final int f417a;

    /* access modifiers changed from: public */
    c(int i2) {
        this.f417a = i2;
    }

    public static c a(int i2) {
        switch (i2) {
            case 0:
                return VIDEO_NORMAL;
            case 1:
                return VIDEO_BULLETTIME;
            case 2:
                return VIDEO_TIMELAPSE;
            case 3:
                return PHOTO_NORMAL;
            case 4:
                return PHOTO_HDR;
            case 5:
                return PHOTO_INTERVALSHOOTING;
            case 6:
                return VIDEO_HDR;
            case 7:
                return PHOTO_BURST;
            case 8:
                return VIDEO_STATIC_TIMELAPSE;
            default:
                return null;
        }
    }
}
