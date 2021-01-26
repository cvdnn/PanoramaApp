package com.arashivision.insbase.joml.sampling;

import com.arashivision.insbase.joml.Random;
import com.arashivision.insbase.joml.Vector2f;
import com.arashivision.insbase.joml.Vector3f;
import e.a.a.a.a;
import java.nio.FloatBuffer;
import java.util.ArrayList;

public class BestCandidateSampling {

    public static class Cube {
        public int numCandidates = 60;
        public int numSamples;
        public long seed;

        public Cube generate(final float[] fArr) {
            final IntHolder intHolder = new IntHolder();
            return generate((Callback3d) new Callback3d() {
                public void onNewSample(float f2, float f3, float f4) {
                    float[] fArr = fArr;
                    IntHolder intHolder = intHolder;
                    int i2 = intHolder.value;
                    fArr[(i2 * 3) + 0] = f2;
                    fArr[(i2 * 3) + 1] = f3;
                    fArr[(i2 * 3) + 2] = f4;
                    intHolder.value = i2 + 1;
                }
            });
        }

        public Cube numCandidates(int i2) {
            this.numCandidates = i2;
            return this;
        }

        public Cube numSamples(int i2) {
            this.numSamples = i2;
            return this;
        }

        public Cube seed(long j2) {
            this.seed = j2;
            return this;
        }

        public Cube generate(final FloatBuffer floatBuffer) {
            final IntHolder intHolder = new IntHolder();
            final int position = floatBuffer.position();
            return generate((Callback3d) new Callback3d() {
                public void onNewSample(float f2, float f3, float f4) {
                    floatBuffer.put((intHolder.value * 3) + position + 0, f2);
                    floatBuffer.put((intHolder.value * 3) + position + 1, f3);
                    floatBuffer.put((intHolder.value * 3) + position + 2, f4);
                    intHolder.value++;
                }
            });
        }

        public Cube generate(Callback3d callback3d) {
            Octree octree = new Octree(-1.0f, -1.0f, -1.0f, 2.0f);
            Random random = new Random(this.seed);
            for (int i2 = 0; i2 < this.numSamples; i2++) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                int i3 = 0;
                while (i3 < this.numCandidates) {
                    float nextFloat = (random.nextFloat() * 2.0f) - 1.0f;
                    float nextFloat2 = (random.nextFloat() * 2.0f) - 1.0f;
                    float nextFloat3 = (random.nextFloat() * 2.0f) - 1.0f;
                    int i4 = i3;
                    float nearest = octree.nearest(nextFloat, nextFloat2, nextFloat3, f5, Float.POSITIVE_INFINITY);
                    if (nearest > f5) {
                        f5 = nearest;
                        f2 = nextFloat;
                        f3 = nextFloat2;
                        f4 = nextFloat3;
                    }
                    i3 = i4 + 1;
                }
                callback3d.onNewSample(f2, f3, f4);
                octree.insert(new Vector3f(f2, f3, f4));
            }
            return this;
        }
    }

    public static class Disk {
        public int numCandidates = 60;
        public int numSamples;
        public long seed;

        public Disk generate(final float[] fArr) {
            final IntHolder intHolder = new IntHolder();
            return generate((Callback2d) new Callback2d() {
                public void onNewSample(float f2, float f3) {
                    float[] fArr = fArr;
                    IntHolder intHolder = intHolder;
                    int i2 = intHolder.value;
                    fArr[(i2 * 2) + 0] = f2;
                    fArr[(i2 * 2) + 1] = f3;
                    intHolder.value = i2 + 1;
                }
            });
        }

        public Disk numCandidates(int i2) {
            this.numCandidates = i2;
            return this;
        }

        public Disk numSamples(int i2) {
            this.numSamples = i2;
            return this;
        }

        public Disk seed(long j2) {
            this.seed = j2;
            return this;
        }

        public Disk generate(final FloatBuffer floatBuffer) {
            final IntHolder intHolder = new IntHolder();
            final int position = floatBuffer.position();
            return generate((Callback2d) new Callback2d() {
                public void onNewSample(float f2, float f3) {
                    floatBuffer.put((intHolder.value * 3) + position + 0, f2);
                    floatBuffer.put((intHolder.value * 3) + position + 1, f3);
                    intHolder.value++;
                }
            });
        }

        public Disk generate(Callback2d callback2d) {
            float nextFloat;
            float nextFloat2;
            QuadTree quadTree = new QuadTree(-1.0f, -1.0f, 2.0f);
            Random random = new Random(this.seed);
            for (int i2 = 0; i2 < this.numSamples; i2++) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                for (int i3 = 0; i3 < this.numCandidates; i3++) {
                    do {
                        nextFloat = (random.nextFloat() * 2.0f) - 1.0f;
                        nextFloat2 = (random.nextFloat() * 2.0f) - 1.0f;
                    } while ((nextFloat2 * nextFloat2) + (nextFloat * nextFloat) > 1.0f);
                    float nearest = quadTree.nearest(nextFloat, nextFloat2, f4, Float.POSITIVE_INFINITY);
                    if (nearest > f4) {
                        f2 = nextFloat;
                        f4 = nearest;
                        f3 = nextFloat2;
                    }
                }
                callback2d.onNewSample(f2, f3);
                quadTree.insert(new Vector2f(f2, f3));
            }
            return this;
        }
    }

    public static final class IntHolder {
        public int value;

        public IntHolder() {
        }
    }

    public static class Octree {
        public static final int MAX_OBJECTS_PER_NODE = 32;
        public static final int NXNYNZ = 1;
        public static final int NXNYPZ = 5;
        public static final int NXPYNZ = 2;
        public static final int NXPYPZ = 6;
        public static final int PXNYNZ = 0;
        public static final int PXNYPZ = 4;
        public static final int PXPYNZ = 3;
        public static final int PXPYPZ = 7;
        public Octree[] children;
        public float hs;
        public float minX;
        public float minY;
        public float minZ;
        public ArrayList objects;

        public Octree(float f2, float f3, float f4, float f5) {
            this.minX = f2;
            this.minY = f3;
            this.minZ = f4;
            this.hs = f5 * 0.5f;
        }

        private void insertIntoChild(Vector3f vector3f) {
            this.children[octant(vector3f.x, vector3f.y, vector3f.z)].insert(vector3f);
        }

        private int octant(float f2, float f3, float f4) {
            float f5 = this.minX;
            float f6 = this.hs;
            return f2 < f5 + f6 ? f3 < this.minY + f6 ? f4 < this.minZ + f6 ? 1 : 5 : f4 < this.minZ + f6 ? 2 : 6 : f3 < this.minY + f6 ? f4 < this.minZ + f6 ? 0 : 4 : f4 < this.minZ + f6 ? 3 : 7;
        }

        private void split() {
            Octree[] octreeArr = new Octree[8];
            this.children = octreeArr;
            octreeArr[1] = new Octree(this.minX, this.minY, this.minZ, this.hs);
            Octree[] octreeArr2 = this.children;
            float f2 = this.minX;
            float f3 = this.hs;
            octreeArr2[0] = new Octree(f2 + f3, this.minY, this.minZ, f3);
            Octree[] octreeArr3 = this.children;
            float f4 = this.minX;
            float f5 = this.minY;
            float f6 = this.hs;
            octreeArr3[2] = new Octree(f4, f5 + f6, this.minZ, f6);
            Octree[] octreeArr4 = this.children;
            float f7 = this.minX;
            float f8 = this.hs;
            octreeArr4[3] = new Octree(f7 + f8, this.minY + f8, this.minZ, f8);
            Octree[] octreeArr5 = this.children;
            float f9 = this.minX;
            float f10 = this.minY;
            float f11 = this.minZ;
            float f12 = this.hs;
            octreeArr5[5] = new Octree(f9, f10, f11 + f12, f12);
            Octree[] octreeArr6 = this.children;
            float f13 = this.minX;
            float f14 = this.hs;
            octreeArr6[4] = new Octree(f13 + f14, this.minY, this.minZ + f14, f14);
            Octree[] octreeArr7 = this.children;
            float f15 = this.minX;
            float f16 = this.minY;
            float f17 = this.hs;
            octreeArr7[6] = new Octree(f15, f16 + f17, this.minZ + f17, f17);
            Octree[] octreeArr8 = this.children;
            float f18 = this.minX;
            float f19 = this.hs;
            octreeArr8[7] = new Octree(f18 + f19, this.minY + f19, this.minZ + f19, f19);
        }

        public void insert(Vector3f vector3f) {
            if (this.children != null) {
                insertIntoChild(vector3f);
                return;
            }
            ArrayList arrayList = this.objects;
            if (arrayList == null || arrayList.size() != 32) {
                if (this.objects == null) {
                    this.objects = new ArrayList(32);
                }
                this.objects.add(vector3f);
            } else {
                split();
                for (int i2 = 0; i2 < this.objects.size(); i2++) {
                    insertIntoChild((Vector3f) this.objects.get(i2));
                }
                this.objects = null;
                insertIntoChild(vector3f);
            }
        }

        public float nearest(float f2, float f3, float f4, float f5, float f6) {
            float f7 = this.minX;
            if (f2 >= f7 - f6) {
                float f8 = this.hs;
                if (f2 <= a.f(f8, 2.0f, f7, f6)) {
                    float f9 = this.minY;
                    if (f3 >= f9 - f6 && f3 <= a.f(f8, 2.0f, f9, f6)) {
                        float f10 = this.minZ;
                        if (f4 >= f10 - f6 && f4 <= a.f(f8, 2.0f, f10, f6)) {
                            int i2 = 0;
                            if (this.children != null) {
                                int octant = octant(f2, f3, f4);
                                while (i2 < 8) {
                                    f6 = Math.min(this.children[octant].nearest(f2, f3, f4, f5, f6), f6);
                                    if (f6 <= f5) {
                                        return f5;
                                    }
                                    octant = (octant + 1) & 7;
                                    i2++;
                                }
                                return f6;
                            }
                            float f11 = f6 * f6;
                            float f12 = f5 * f5;
                            while (true) {
                                ArrayList arrayList = this.objects;
                                if (arrayList != null && i2 < arrayList.size()) {
                                    float distanceSquared = ((Vector3f) this.objects.get(i2)).distanceSquared(f2, f3, f4);
                                    if (distanceSquared <= f12) {
                                        return f5;
                                    }
                                    if (distanceSquared < f11) {
                                        f11 = distanceSquared;
                                    }
                                    i2++;
                                }
                            }
                            return (float) Math.sqrt((double) f11);
                        }
                    }
                }
            }
            return f6;
        }
    }

    public static class Quad {
        public int numCandidates = 60;
        public int numSamples;
        public long seed;

        public Quad generate(final float[] fArr) {
            final IntHolder intHolder = new IntHolder();
            return generate((Callback2d) new Callback2d() {
                public void onNewSample(float f2, float f3) {
                    float[] fArr = fArr;
                    IntHolder intHolder = intHolder;
                    int i2 = intHolder.value;
                    fArr[(i2 * 2) + 0] = f2;
                    fArr[(i2 * 2) + 1] = f3;
                    intHolder.value = i2 + 1;
                }
            });
        }

        public Quad numCandidates(int i2) {
            this.numCandidates = i2;
            return this;
        }

        public Quad numSamples(int i2) {
            this.numSamples = i2;
            return this;
        }

        public Quad seed(long j2) {
            this.seed = j2;
            return this;
        }

        public Quad generate(final FloatBuffer floatBuffer) {
            final IntHolder intHolder = new IntHolder();
            final int position = floatBuffer.position();
            return generate((Callback2d) new Callback2d() {
                public void onNewSample(float f2, float f3) {
                    floatBuffer.put((intHolder.value * 3) + position + 0, f2);
                    floatBuffer.put((intHolder.value * 3) + position + 1, f3);
                    intHolder.value++;
                }
            });
        }

        public Quad generate(Callback2d callback2d) {
            QuadTree quadTree = new QuadTree(-1.0f, -1.0f, 2.0f);
            Random random = new Random(this.seed);
            for (int i2 = 0; i2 < this.numSamples; i2++) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                for (int i3 = 0; i3 < this.numCandidates; i3++) {
                    float nextFloat = (random.nextFloat() * 2.0f) - 1.0f;
                    float nextFloat2 = (random.nextFloat() * 2.0f) - 1.0f;
                    float nearest = quadTree.nearest(nextFloat, nextFloat2, f4, Float.POSITIVE_INFINITY);
                    if (nearest > f4) {
                        f2 = nextFloat;
                        f4 = nearest;
                        f3 = nextFloat2;
                    }
                }
                callback2d.onNewSample(f2, f3);
                quadTree.insert(new Vector2f(f2, f3));
            }
            return this;
        }
    }

    public static class QuadTree {
        public static final int MAX_OBJECTS_PER_NODE = 32;
        public static final int NXNY = 1;
        public static final int NXPY = 2;
        public static final int PXNY = 0;
        public static final int PXPY = 3;
        public QuadTree[] children;
        public float hs;
        public float minX;
        public float minY;
        public ArrayList objects;

        public QuadTree(float f2, float f3, float f4) {
            this.minX = f2;
            this.minY = f3;
            this.hs = f4 * 0.5f;
        }

        private void insertIntoChild(Vector2f vector2f) {
            this.children[quadrant(vector2f.x, vector2f.y)].insert(vector2f);
        }

        private int quadrant(float f2, float f3) {
            float f4 = this.minX;
            float f5 = this.hs;
            return f2 < f4 + f5 ? f3 < this.minY + f5 ? 1 : 2 : f3 < this.minY + f5 ? 0 : 3;
        }

        private void split() {
            QuadTree[] quadTreeArr = new QuadTree[4];
            this.children = quadTreeArr;
            quadTreeArr[1] = new QuadTree(this.minX, this.minY, this.hs);
            QuadTree[] quadTreeArr2 = this.children;
            float f2 = this.minX;
            float f3 = this.hs;
            quadTreeArr2[0] = new QuadTree(f2 + f3, this.minY, f3);
            QuadTree[] quadTreeArr3 = this.children;
            float f4 = this.minX;
            float f5 = this.minY;
            float f6 = this.hs;
            quadTreeArr3[2] = new QuadTree(f4, f5 + f6, f6);
            QuadTree[] quadTreeArr4 = this.children;
            float f7 = this.minX;
            float f8 = this.hs;
            quadTreeArr4[3] = new QuadTree(f7 + f8, this.minY + f8, f8);
        }

        public void insert(Vector2f vector2f) {
            if (this.children != null) {
                insertIntoChild(vector2f);
                return;
            }
            ArrayList arrayList = this.objects;
            if (arrayList == null || arrayList.size() != 32) {
                if (this.objects == null) {
                    this.objects = new ArrayList(32);
                }
                this.objects.add(vector2f);
            } else {
                split();
                for (int i2 = 0; i2 < this.objects.size(); i2++) {
                    insertIntoChild((Vector2f) this.objects.get(i2));
                }
                this.objects = null;
                insertIntoChild(vector2f);
            }
        }

        public float nearest(float f2, float f3, float f4, float f5) {
            float f6 = this.minX;
            if (f2 >= f6 - f5) {
                float f7 = this.hs;
                if (f2 <= a.f(f7, 2.0f, f6, f5)) {
                    float f8 = this.minY;
                    if (f3 >= f8 - f5 && f3 <= a.f(f7, 2.0f, f8, f5)) {
                        int i2 = 0;
                        if (this.children != null) {
                            int quadrant = quadrant(f2, f3);
                            while (i2 < 4) {
                                f5 = Math.min(this.children[quadrant].nearest(f2, f3, f4, f5), f5);
                                if (f5 <= f4) {
                                    return f4;
                                }
                                quadrant = (quadrant + 1) & 3;
                                i2++;
                            }
                            return f5;
                        }
                        float f9 = f5 * f5;
                        float f10 = f4 * f4;
                        while (true) {
                            ArrayList arrayList = this.objects;
                            if (arrayList != null && i2 < arrayList.size()) {
                                float distanceSquared = ((Vector2f) this.objects.get(i2)).distanceSquared(f2, f3);
                                if (distanceSquared <= f10) {
                                    return f4;
                                }
                                if (distanceSquared < f9) {
                                    f9 = distanceSquared;
                                }
                                i2++;
                            }
                        }
                        return (float) Math.sqrt((double) f9);
                    }
                }
            }
            return f5;
        }
    }

    public static class Sphere {
        public int numCandidates = 60;
        public int numSamples;
        public boolean onHemisphere;
        public long seed;

        public static final class Node {
            public static final int MAX_OBJECTS_PER_NODE = 32;
            public float arc;
            public Node[] children;
            public float cx;
            public float cy;
            public float cz;
            public ArrayList objects;
            public float v0x;
            public float v0y;
            public float v0z;
            public float v1x;
            public float v1y;
            public float v1z;
            public float v2x;
            public float v2y;
            public float v2z;

            public Node() {
                Node[] nodeArr = new Node[8];
                this.children = nodeArr;
                this.arc = 6.2831855f;
                Node node = new Node(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                nodeArr[0] = node;
                Node[] nodeArr2 = this.children;
                Node node2 = new Node(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
                nodeArr2[1] = node2;
                Node[] nodeArr3 = this.children;
                Node node3 = new Node(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f);
                nodeArr3[2] = node3;
                Node[] nodeArr4 = this.children;
                Node node4 = new Node(0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
                nodeArr4[3] = node4;
                Node[] nodeArr5 = this.children;
                Node node5 = new Node(-1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                nodeArr5[4] = node5;
                Node[] nodeArr6 = this.children;
                Node node6 = new Node(0.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f);
                nodeArr6[5] = node6;
                Node[] nodeArr7 = this.children;
                Node node7 = new Node(1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, -1.0f);
                nodeArr7[6] = node7;
                Node[] nodeArr8 = this.children;
                Node node8 = new Node(0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f);
                nodeArr8[7] = node8;
            }

            private int child(float f2, float f3, float f4) {
                int i2 = 0;
                while (true) {
                    Node[] nodeArr = this.children;
                    if (i2 >= nodeArr.length) {
                        return 0;
                    }
                    Node node = nodeArr[i2];
                    if (isPointOnSphericalTriangle(f2, f3, f4, node.v0x, node.v0y, node.v0z, node.v1x, node.v1y, node.v1z, node.v2x, node.v2y, node.v2z, 1.0E-5f)) {
                        return i2;
                    }
                    i2++;
                }
            }

            private float greatCircleDist(float f2, float f3, float f4, float f5, float f6, float f7) {
                return (float) ((((double) ((f4 * f7) + (f3 * f6) + (f2 * f5))) * -1.5707963267948966d) + 1.5707963267948966d);
            }

            private void insertIntoChild(Vector3f vector3f) {
                Vector3f vector3f2 = vector3f;
                int i2 = 0;
                while (true) {
                    Node[] nodeArr = this.children;
                    if (i2 < nodeArr.length) {
                        Node node = nodeArr[i2];
                        if (isPointOnSphericalTriangle(vector3f2.x, vector3f2.y, vector3f2.z, node.v0x, node.v0y, node.v0z, node.v1x, node.v1y, node.v1z, node.v2x, node.v2y, node.v2z, 1.0E-6f)) {
                            node.insert(vector3f2);
                            return;
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            }

            public static boolean isPointOnSphericalTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
                float f15 = f4;
                float f16 = f5;
                float f17 = f6;
                float f18 = f7;
                float f19 = f14;
                float f20 = f8 - f16;
                float f21 = f9 - f17;
                float f22 = f10 - f18;
                float f23 = f11 - f16;
                float f24 = f12 - f17;
                float f25 = f13 - f18;
                float f26 = (f3 * f25) - (f15 * f24);
                float f27 = (f15 * f23) - (f2 * f25);
                float f28 = (f2 * f24) - (f3 * f23);
                float f29 = (f22 * f28) + (f21 * f27) + (f20 * f26);
                boolean z = false;
                if (f29 > (-f19) && f29 < f19) {
                    return false;
                }
                float f30 = -f16;
                float f31 = -f17;
                float f32 = -f18;
                float f33 = 1.0f / f29;
                float g2 = a.g(f28, f32, (f27 * f31) + (f26 * f30), f33);
                if (g2 >= 0.0f && g2 <= 1.0f) {
                    float f34 = (f31 * f22) - (f32 * f21);
                    float f35 = (f32 * f20) - (f22 * f30);
                    float f36 = (f30 * f21) - (f31 * f20);
                    float g3 = a.g(f15, f36, (f3 * f35) + (f2 * f34), f33);
                    if (g3 >= 0.0f && g2 + g3 <= 1.0f) {
                        if (a.g(f25, f36, (f24 * f35) + (f23 * f34), f33) >= f19) {
                            z = true;
                        }
                    }
                }
                return z;
            }

            private void split() {
                float f2 = this.v1x + this.v2x;
                float f3 = this.v1y + this.v2y;
                float f4 = this.v1z + this.v2z;
                float sqrt = 1.0f / ((float) Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2)))));
                float f5 = f2 * sqrt;
                float f6 = f3 * sqrt;
                float f7 = f4 * sqrt;
                float f8 = this.v0x + this.v2x;
                float f9 = this.v0y + this.v2y;
                float f10 = this.v0z + this.v2z;
                float sqrt2 = 1.0f / ((float) Math.sqrt((double) ((f10 * f10) + ((f9 * f9) + (f8 * f8)))));
                float f11 = f8 * sqrt2;
                float f12 = f9 * sqrt2;
                float f13 = f10 * sqrt2;
                float f14 = this.v0x + this.v1x;
                float f15 = this.v0y + this.v1y;
                float f16 = this.v0z + this.v1z;
                float sqrt3 = 1.0f / ((float) Math.sqrt((double) ((f16 * f16) + ((f15 * f15) + (f14 * f14)))));
                float f17 = f14 * sqrt3;
                float f18 = f15 * sqrt3;
                float f19 = sqrt3 * f16;
                Node[] nodeArr = new Node[4];
                this.children = nodeArr;
                float f20 = f17;
                float f21 = f18;
                Node node = new Node(this.v0x, this.v0y, this.v0z, f20, f21, f19, f11, f12, f13);
                nodeArr[0] = node;
                Node[] nodeArr2 = this.children;
                Node node2 = new Node(this.v1x, this.v1y, this.v1z, f5, f6, f7, f20, f21, f19);
                nodeArr2[1] = node2;
                float f22 = f11;
                float f23 = f12;
                float f24 = f13;
                Node[] nodeArr3 = this.children;
                Node node3 = new Node(this.v2x, this.v2y, this.v2z, f22, f23, f24, f5, f6, f7);
                nodeArr3[2] = node3;
                Node[] nodeArr4 = this.children;
                Node node4 = new Node(f5, f6, f7, f22, f23, f24, f17, f18, f19);
                nodeArr4[3] = node4;
            }

            public void insert(Vector3f vector3f) {
                if (this.children != null) {
                    insertIntoChild(vector3f);
                    return;
                }
                ArrayList arrayList = this.objects;
                if (arrayList == null || arrayList.size() != 32) {
                    if (this.objects == null) {
                        this.objects = new ArrayList(32);
                    }
                    this.objects.add(vector3f);
                } else {
                    split();
                    for (int i2 = 0; i2 < 32; i2++) {
                        insertIntoChild((Vector3f) this.objects.get(i2));
                    }
                    this.objects = null;
                    insertIntoChild(vector3f);
                }
            }

            public float nearest(float f2, float f3, float f4) {
                return nearest(f2, f3, f4, Float.POSITIVE_INFINITY);
            }

            public float nearest(float f2, float f3, float f4, float f5) {
                if (greatCircleDist(f2, f3, f4, this.cx, this.cy, this.cz) - this.arc > f5) {
                    return f5;
                }
                Node[] nodeArr = this.children;
                int i2 = 0;
                if (nodeArr != null) {
                    int length = nodeArr.length;
                    int i3 = length - 1;
                    int child = child(f2, f3, f4);
                    while (i2 < length) {
                        f5 = Math.min(this.children[child].nearest(f2, f3, f4, f5), f5);
                        child = (child + 1) & i3;
                        i2++;
                    }
                    return f5;
                }
                while (true) {
                    ArrayList arrayList = this.objects;
                    if (arrayList == null || i2 >= arrayList.size()) {
                        return f5;
                    }
                    Vector3f vector3f = (Vector3f) this.objects.get(i2);
                    float greatCircleDist = greatCircleDist(vector3f.x, vector3f.y, vector3f.z, f2, f3, f4);
                    if (greatCircleDist < f5) {
                        f5 = greatCircleDist;
                    }
                    i2++;
                }
                return f5;
            }

            public Node(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
                this.v0x = f2;
                this.v0y = f3;
                this.v0z = f4;
                this.v1x = f5;
                this.v1y = f6;
                this.v1z = f7;
                this.v2x = f8;
                this.v2y = f9;
                this.v2z = f10;
                float f11 = ((f2 + f5) + f8) / 3.0f;
                this.cx = f11;
                float f12 = ((f3 + f6) + f9) / 3.0f;
                this.cy = f12;
                float f13 = ((f4 + f7) + f10) / 3.0f;
                this.cz = f13;
                float f14 = f13 * f13;
                float sqrt = 1.0f / ((float) Math.sqrt((double) (f14 + ((f12 * f12) + (f11 * f11)))));
                float f15 = this.cx * sqrt;
                this.cx = f15;
                float f16 = this.cy * sqrt;
                this.cy = f16;
                float f17 = this.cz * sqrt;
                this.cz = f17;
                float greatCircleDist = greatCircleDist(f15, f16, f17, this.v0x, this.v0y, this.v0z);
                float greatCircleDist2 = greatCircleDist(this.cx, this.cy, this.cz, this.v1x, this.v1y, this.v1z);
                this.arc = Math.max(Math.max(greatCircleDist, greatCircleDist2), greatCircleDist(this.cx, this.cy, this.cz, this.v2x, this.v2y, this.v2z)) * 1.7f;
            }
        }

        public Sphere generate(final float[] fArr) {
            final IntHolder intHolder = new IntHolder();
            return generate((Callback3d) new Callback3d() {
                public void onNewSample(float f2, float f3, float f4) {
                    float[] fArr = fArr;
                    IntHolder intHolder = intHolder;
                    int i2 = intHolder.value;
                    fArr[(i2 * 3) + 0] = f2;
                    fArr[(i2 * 3) + 1] = f3;
                    fArr[(i2 * 3) + 2] = f4;
                    intHolder.value = i2 + 1;
                }
            });
        }

        public Sphere numCandidates(int i2) {
            this.numCandidates = i2;
            return this;
        }

        public Sphere numSamples(int i2) {
            this.numSamples = i2;
            return this;
        }

        public Sphere onHemisphere(boolean z) {
            this.onHemisphere = z;
            return this;
        }

        public Sphere seed(long j2) {
            this.seed = j2;
            return this;
        }

        public Sphere generate(final FloatBuffer floatBuffer) {
            final IntHolder intHolder = new IntHolder();
            final int position = floatBuffer.position();
            return generate((Callback3d) new Callback3d() {
                public void onNewSample(float f2, float f3, float f4) {
                    floatBuffer.put((intHolder.value * 3) + position + 0, f2);
                    floatBuffer.put((intHolder.value * 3) + position + 1, f3);
                    floatBuffer.put((intHolder.value * 3) + position + 2, f4);
                    intHolder.value++;
                }
            });
        }

        public Sphere generate(Callback3d callback3d) {
            float nextFloat;
            float nextFloat2;
            float f2;
            float f3;
            float f4;
            Random random = new Random(this.seed);
            Node node = new Node();
            int i2 = 0;
            while (i2 < this.numSamples) {
                float f5 = 0.0f;
                float f6 = Float.NaN;
                float f7 = Float.NaN;
                float f8 = Float.NaN;
                int i3 = 0;
                while (i3 < this.numCandidates) {
                    do {
                        nextFloat = (random.nextFloat() * 2.0f) - 1.0f;
                        nextFloat2 = (random.nextFloat() * 2.0f) - 1.0f;
                        f2 = nextFloat * nextFloat;
                        f3 = nextFloat2 * nextFloat2;
                        f4 = f2 + f3;
                    } while (f4 > 1.0f);
                    int i4 = i2;
                    float sqrt = (float) Math.sqrt((1.0d - ((double) f2)) - ((double) f3));
                    float f9 = nextFloat * 2.0f * sqrt;
                    float f10 = nextFloat2 * 2.0f * sqrt;
                    float f11 = 1.0f - (f4 * 2.0f);
                    if (this.onHemisphere) {
                        f11 = Math.abs(f11);
                    }
                    float nearest = node.nearest(f9, f10, f11);
                    if (nearest > f5) {
                        f5 = nearest;
                        f6 = f9;
                        f8 = f11;
                        f7 = f10;
                    }
                    i3++;
                    i2 = i4;
                }
                int i5 = i2;
                callback3d.onNewSample(f6, f7, f8);
                node.insert(new Vector3f(f6, f7, f8));
                i2 = i5 + 1;
            }
            return this;
        }
    }
}
