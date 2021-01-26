package e.m.a;

import android.graphics.Point;
import android.view.View;

/* compiled from: DSVOrientation */
public enum a {
    HORIZONTAL {
        public c a() {
            return new d();
        }
    },
    VERTICAL {
        public c a() {
            return new e();
        }
    };

    /* compiled from: DSVOrientation */
    public interface c {
        float a(Point point, int i2, int i3);

        int a(int i2);

        int a(int i2, int i3);

        void a(int i2, g gVar);

        void a(Point point, int i2, Point point2);

        void a(b bVar, int i2, Point point);

        boolean a();

        boolean a(Point point, int i2, int i3, int i4, int i5);

        boolean a(c cVar);

        int b(int i2);

        int b(int i2, int i3);

        boolean b();

        int c(int i2, int i3);
    }

    /* compiled from: DSVOrientation */
    public static class d implements c {
        public int a(int i2) {
            return 0;
        }

        public int a(int i2, int i3) {
            return i2;
        }

        public void a(Point point, int i2, Point point2) {
            point2.set(point.x - i2, point.y);
        }

        public boolean a() {
            return false;
        }

        public int b(int i2) {
            return i2;
        }

        public int b(int i2, int i3) {
            return i2;
        }

        public boolean b() {
            return true;
        }

        public int c(int i2, int i3) {
            return i2;
        }

        public void a(b bVar, int i2, Point point) {
            point.set(bVar.a(i2) + point.x, point.y);
        }

        public boolean a(Point point, int i2, int i3, int i4, int i5) {
            int i6 = point.x;
            return i6 - i2 < i4 + i5 && i6 + i2 > (-i5);
        }

        public void a(int i2, g gVar) {
            gVar.f8995a.offsetChildrenHorizontal(i2);
        }

        public boolean a(c cVar) {
            View c2 = cVar.c();
            View d2 = cVar.d();
            int width = cVar.getWidth() + cVar.f8988f;
            boolean z = cVar.getDecoratedLeft(c2) > (-cVar.f8988f) && cVar.getPosition(c2) > 0;
            boolean z2 = cVar.getDecoratedRight(d2) < width && cVar.getPosition(d2) < cVar.getItemCount() - 1;
            if (z || z2) {
                return true;
            }
            return false;
        }

        public float a(Point point, int i2, int i3) {
            return (float) (i2 - point.x);
        }
    }

    /* compiled from: DSVOrientation */
    public static class e implements c {
        public int a(int i2) {
            return i2;
        }

        public int a(int i2, int i3) {
            return i3;
        }

        public void a(int i2, g gVar) {
            gVar.f8995a.offsetChildrenVertical(i2);
        }

        public boolean a() {
            return true;
        }

        public int b(int i2) {
            return 0;
        }

        public int b(int i2, int i3) {
            return i3;
        }

        public boolean b() {
            return false;
        }

        public int c(int i2, int i3) {
            return i3;
        }

        public void a(Point point, int i2, Point point2) {
            point2.set(point.x, point.y - i2);
        }

        public void a(b bVar, int i2, Point point) {
            point.set(point.x, bVar.a(i2) + point.y);
        }

        public float a(Point point, int i2, int i3) {
            return (float) (i3 - point.y);
        }

        public boolean a(Point point, int i2, int i3, int i4, int i5) {
            int i6 = point.y;
            return i6 - i3 < i4 + i5 && i6 + i3 > (-i5);
        }

        public boolean a(c cVar) {
            View c2 = cVar.c();
            View d2 = cVar.d();
            int height = cVar.getHeight() + cVar.f8988f;
            boolean z = cVar.getDecoratedTop(c2) > (-cVar.f8988f) && cVar.getPosition(c2) > 0;
            boolean z2 = cVar.getDecoratedBottom(d2) < height && cVar.getPosition(d2) < cVar.getItemCount() - 1;
            if (z || z2) {
                return true;
            }
            return false;
        }
    }

    public abstract c a();
}
