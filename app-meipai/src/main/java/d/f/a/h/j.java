package d.f.a.h;

import com.baidu.mobstat.Config;
import d.f.a.e;
import d.f.a.g;
import d.f.a.h.c.C0033c;
import e.a.a.a.a;

/* compiled from: ResolutionAnchor */
public class j extends l {

    /* renamed from: c reason: collision with root package name */
    public c f4716c;

    /* renamed from: d reason: collision with root package name */
    public j f4717d;

    /* renamed from: e reason: collision with root package name */
    public float f4718e;

    /* renamed from: f reason: collision with root package name */
    public j f4719f;

    /* renamed from: g reason: collision with root package name */
    public float f4720g;

    /* renamed from: h reason: collision with root package name */
    public int f4721h = 0;

    /* renamed from: i reason: collision with root package name */
    public j f4722i;

    /* renamed from: j reason: collision with root package name */
    public k f4723j = null;
    public int k = 1;
    public k l = null;
    public int m = 1;

    public j(c cVar) {
        this.f4716c = cVar;
    }

    public String a(int i2) {
        return i2 == 1 ? "DIRECT" : i2 == 2 ? "CENTER" : i2 == 3 ? "MATCH" : i2 == 4 ? "CHAIN" : i2 == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public void a(j jVar, float f2) {
        if (this.f4726b == 0 || !(this.f4719f == jVar || this.f4720g == f2)) {
            this.f4719f = jVar;
            this.f4720g = f2;
            if (this.f4726b == 1) {
                b();
            }
            a();
        }
    }

    public void d() {
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z = true;
        if (this.f4726b != 1 && this.f4721h != 4) {
            k kVar = this.f4723j;
            if (kVar != null) {
                if (kVar.f4726b == 1) {
                    this.f4718e = ((float) this.k) * kVar.f4724c;
                } else {
                    return;
                }
            }
            k kVar2 = this.l;
            if (kVar2 != null) {
                if (kVar2.f4726b == 1) {
                    float f6 = kVar2.f4724c;
                } else {
                    return;
                }
            }
            if (this.f4721h == 1) {
                j jVar = this.f4717d;
                if (jVar == null || jVar.f4726b == 1) {
                    j jVar2 = this.f4717d;
                    if (jVar2 == null) {
                        this.f4719f = this;
                        this.f4720g = this.f4718e;
                    } else {
                        this.f4719f = jVar2.f4719f;
                        this.f4720g = jVar2.f4720g + this.f4718e;
                    }
                    a();
                }
            }
            if (this.f4721h == 2) {
                j jVar3 = this.f4717d;
                if (jVar3 != null && jVar3.f4726b == 1) {
                    j jVar4 = this.f4722i;
                    if (jVar4 != null) {
                        j jVar5 = jVar4.f4717d;
                        if (jVar5 != null && jVar5.f4726b == 1) {
                            this.f4719f = jVar3.f4719f;
                            jVar4.f4719f = jVar5.f4719f;
                            C0033c cVar = this.f4716c.f4666c;
                            int i2 = 0;
                            if (!(cVar == C0033c.RIGHT || cVar == C0033c.BOTTOM)) {
                                z = false;
                            }
                            if (z) {
                                f3 = this.f4717d.f4720g;
                                f2 = this.f4722i.f4717d.f4720g;
                            } else {
                                f3 = this.f4722i.f4717d.f4720g;
                                f2 = this.f4717d.f4720g;
                            }
                            float f7 = f3 - f2;
                            c cVar2 = this.f4716c;
                            C0033c cVar3 = cVar2.f4666c;
                            if (cVar3 == C0033c.LEFT || cVar3 == C0033c.RIGHT) {
                                f5 = f7 - ((float) this.f4716c.f4665b.h());
                                f4 = this.f4716c.f4665b.V;
                            } else {
                                f5 = f7 - ((float) cVar2.f4665b.c());
                                f4 = this.f4716c.f4665b.W;
                            }
                            int a2 = this.f4716c.a();
                            int a3 = this.f4722i.f4716c.a();
                            if (this.f4716c.f4667d == this.f4722i.f4716c.f4667d) {
                                f4 = 0.5f;
                                a3 = 0;
                            } else {
                                i2 = a2;
                            }
                            float f8 = (float) i2;
                            float f9 = (float) a3;
                            float f10 = (f5 - f8) - f9;
                            if (z) {
                                j jVar6 = this.f4722i;
                                jVar6.f4720g = (f10 * f4) + jVar6.f4717d.f4720g + f9;
                                this.f4720g = (this.f4717d.f4720g - f8) - ((1.0f - f4) * f10);
                            } else {
                                this.f4720g = (f10 * f4) + this.f4717d.f4720g + f8;
                                j jVar7 = this.f4722i;
                                jVar7.f4720g = (jVar7.f4717d.f4720g - f9) - ((1.0f - f4) * f10);
                            }
                            a();
                            this.f4722i.a();
                        }
                    }
                }
            }
            if (this.f4721h == 3) {
                j jVar8 = this.f4717d;
                if (jVar8 != null && jVar8.f4726b == 1) {
                    j jVar9 = this.f4722i;
                    if (jVar9 != null) {
                        j jVar10 = jVar9.f4717d;
                        if (jVar10 != null && jVar10.f4726b == 1) {
                            this.f4719f = jVar8.f4719f;
                            jVar9.f4719f = jVar10.f4719f;
                            this.f4720g = jVar8.f4720g + this.f4718e;
                            jVar9.f4720g = jVar10.f4720g + jVar9.f4718e;
                            a();
                            this.f4722i.a();
                        }
                    }
                }
            }
            if (this.f4721h == 5) {
                this.f4716c.f4665b.l();
            }
        }
    }

    public void e() {
        this.f4726b = 0;
        this.f4725a.clear();
        this.f4717d = null;
        this.f4718e = 0.0f;
        this.f4723j = null;
        this.k = 1;
        this.l = null;
        this.m = 1;
        this.f4719f = null;
        this.f4720g = 0.0f;
        this.f4722i = null;
        this.f4721h = 0;
    }

    public String toString() {
        if (this.f4726b == 1) {
            String str = ", RESOLVED: ";
            String str2 = "[";
            if (this.f4719f == this) {
                StringBuilder a2 = a.a(str2);
                a2.append(this.f4716c);
                a2.append(str);
                a2.append(this.f4720g);
                a2.append("]  type: ");
                a2.append(a(this.f4721h));
                return a2.toString();
            }
            StringBuilder a3 = a.a(str2);
            a3.append(this.f4716c);
            a3.append(str);
            a3.append(this.f4719f);
            a3.append(Config.TRACE_TODAY_VISIT_SPLIT);
            a3.append(this.f4720g);
            a3.append("] type: ");
            a3.append(a(this.f4721h));
            return a3.toString();
        }
        StringBuilder a4 = a.a("{ ");
        a4.append(this.f4716c);
        a4.append(" UNRESOLVED} type: ");
        a4.append(a(this.f4721h));
        return a4.toString();
    }

    public void a(int i2, j jVar, int i3) {
        this.f4721h = i2;
        this.f4717d = jVar;
        this.f4718e = (float) i3;
        jVar.f4725a.add(this);
    }

    public void a(j jVar, int i2) {
        this.f4717d = jVar;
        this.f4718e = (float) i2;
        jVar.f4725a.add(this);
    }

    public void a(j jVar, int i2, k kVar) {
        this.f4717d = jVar;
        jVar.f4725a.add(this);
        this.f4723j = kVar;
        this.k = i2;
        kVar.f4725a.add(this);
    }

    public void a(e eVar) {
        g gVar = this.f4716c.f4672i;
        j jVar = this.f4719f;
        if (jVar == null) {
            eVar.a(gVar, (int) (this.f4720g + 0.5f));
        } else {
            eVar.a(gVar, eVar.a((Object) jVar.f4716c), (int) (this.f4720g + 0.5f), 6);
        }
    }
}
