package com.arashivision.graphicpath.lifecycle;

import com.arashivision.insbase.arlog.Log;
import com.arashivision.insbase.nativeref.NativeObjectRef;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public class RenderLifecycle implements Lifecycle {
    public final ArrayList<ObserverItem> mObserverList = new ArrayList<>();
    public volatile boolean mRenderDeInited;
    public volatile boolean mRenderInited;
    public volatile long mRenderThreadId;
    public volatile boolean mRenderTickTriggered;

    public static class ObserverItem {
        public RenderLifecycleObserver observer;
        public volatile boolean remove;
        public volatile boolean renderInited;

        public ObserverItem(RenderLifecycleObserver renderLifecycleObserver) {
            this.observer = renderLifecycleObserver;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0057, code lost:
        if (isInsideRenderThread() == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0059, code lost:
        r0.renderInited = true;
        r7.onRenderInited();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0061, code lost:
        if (r6.mRenderTickTriggered == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0063, code lost:
        r7.onRenderTick();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0066, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addRenderLifecycleObserver(com.arashivision.graphicpath.lifecycle.RenderLifecycleObserver r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.util.ArrayList<com.arashivision.graphicpath.lifecycle.RenderLifecycle$ObserverItem> r1 = r6.mObserverList
            monitor-enter(r1)
            java.util.ArrayList<com.arashivision.graphicpath.lifecycle.RenderLifecycle$ObserverItem> r2 = r6.mObserverList     // Catch:{ all -> 0x0067 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0067 }
        L_0x000d:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0046
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0067 }
            com.arashivision.graphicpath.lifecycle.RenderLifecycle$ObserverItem r3 = (com.arashivision.graphicpath.lifecycle.RenderLifecycle.ObserverItem) r3     // Catch:{ all -> 0x0067 }
            com.arashivision.graphicpath.lifecycle.RenderLifecycleObserver r4 = r3.observer     // Catch:{ all -> 0x0067 }
            if (r4 != r7) goto L_0x0023
            boolean r0 = r3.renderInited     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x0045
            monitor-exit(r1)     // Catch:{ all -> 0x0067 }
            return
        L_0x0023:
            boolean r4 = r7 instanceof com.arashivision.insbase.nativeref.NativeObjectRef     // Catch:{ all -> 0x0067 }
            if (r4 == 0) goto L_0x000d
            com.arashivision.graphicpath.lifecycle.RenderLifecycleObserver r4 = r3.observer     // Catch:{ all -> 0x0067 }
            boolean r4 = r4 instanceof com.arashivision.insbase.nativeref.NativeObjectRef     // Catch:{ all -> 0x0067 }
            if (r4 == 0) goto L_0x000d
            r4 = r7
            com.arashivision.insbase.nativeref.NativeObjectRef r4 = (com.arashivision.insbase.nativeref.NativeObjectRef) r4     // Catch:{ all -> 0x0067 }
            com.arashivision.graphicpath.lifecycle.RenderLifecycleObserver r5 = r3.observer     // Catch:{ all -> 0x0067 }
            boolean r4 = r4.hasSameNativeObject(r5)     // Catch:{ all -> 0x0067 }
            if (r4 == 0) goto L_0x000d
            boolean r0 = r3.renderInited     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x003e
            monitor-exit(r1)     // Catch:{ all -> 0x0067 }
            return
        L_0x003e:
            java.lang.String r0 = "ins"
            java.lang.String r2 = "addRenderLifecycleObserver: observer has same native object with one added"
            com.arashivision.insbase.arlog.Log.i(r0, r2)     // Catch:{ all -> 0x0067 }
        L_0x0045:
            r0 = r3
        L_0x0046:
            if (r0 != 0) goto L_0x0052
            com.arashivision.graphicpath.lifecycle.RenderLifecycle$ObserverItem r0 = new com.arashivision.graphicpath.lifecycle.RenderLifecycle$ObserverItem     // Catch:{ all -> 0x0067 }
            r0.<init>(r7)     // Catch:{ all -> 0x0067 }
            java.util.ArrayList<com.arashivision.graphicpath.lifecycle.RenderLifecycle$ObserverItem> r2 = r6.mObserverList     // Catch:{ all -> 0x0067 }
            r2.add(r0)     // Catch:{ all -> 0x0067 }
        L_0x0052:
            monitor-exit(r1)     // Catch:{ all -> 0x0067 }
            boolean r1 = r6.isInsideRenderThread()
            if (r1 == 0) goto L_0x0066
            r1 = 1
            r0.renderInited = r1
            r7.onRenderInited()
            boolean r0 = r6.mRenderTickTriggered
            if (r0 == 0) goto L_0x0066
            r7.onRenderTick()
        L_0x0066:
            return
        L_0x0067:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0067 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.graphicpath.lifecycle.RenderLifecycle.addRenderLifecycleObserver(com.arashivision.graphicpath.lifecycle.RenderLifecycleObserver):void");
    }

    public boolean isInsideRenderThread() {
        if (this.mRenderThreadId != Thread.currentThread().getId()) {
            StringBuilder a2 = a.a(" Thread.currentThread().getId() ");
            a2.append(Thread.currentThread().getId());
            a2.append(" mRenderThreadId ");
            a2.append(this.mRenderThreadId);
            a2.append(" mRenderInited ");
            a2.append(this.mRenderInited);
            Log.e("RenderLifeCycle", a2.toString());
        }
        return Thread.currentThread().getId() == this.mRenderThreadId;
    }

    public void onRenderInited() {
        ArrayList arrayList;
        boolean z;
        if (!this.mRenderDeInited) {
            this.mRenderThreadId = Thread.currentThread().getId();
            this.mRenderInited = true;
            do {
                synchronized (this.mObserverList) {
                    arrayList = new ArrayList(this.mObserverList);
                }
                z = false;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ObserverItem observerItem = (ObserverItem) it.next();
                    if (!observerItem.renderInited) {
                        observerItem.renderInited = true;
                        observerItem.observer.onRenderInited();
                        if (this.mRenderTickTriggered) {
                            observerItem.observer.onRenderTick();
                        }
                        z = true;
                    }
                }
            } while (z);
            return;
        }
        Log.e("ins", "render inited again after de-inited?");
        throw new RuntimeException("render inited again after de-inited");
    }

    public void onRenderTick() {
        if (this.mRenderInited) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.mObserverList) {
                Iterator it = this.mObserverList.iterator();
                while (it.hasNext()) {
                    ObserverItem observerItem = (ObserverItem) it.next();
                    arrayList.add(observerItem);
                    if (observerItem.remove) {
                        it.remove();
                    }
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ObserverItem observerItem2 = (ObserverItem) it2.next();
                if (!observerItem2.renderInited) {
                    observerItem2.renderInited = true;
                    observerItem2.observer.onRenderInited();
                }
            }
            this.mRenderTickTriggered = true;
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                ((ObserverItem) it3.next()).observer.onRenderTick();
            }
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                ObserverItem observerItem3 = (ObserverItem) it4.next();
                if (observerItem3.remove) {
                    observerItem3.observer.onRenderWillDeinit();
                }
            }
        }
    }

    public void onRenderWillDeinit() {
        ArrayList arrayList;
        this.mRenderTickTriggered = false;
        this.mRenderInited = false;
        synchronized (this.mObserverList) {
            arrayList = new ArrayList(this.mObserverList);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ObserverItem observerItem = (ObserverItem) it.next();
            if (observerItem.renderInited) {
                observerItem.renderInited = false;
                observerItem.observer.onRenderWillDeinit();
            }
        }
        synchronized (this.mObserverList) {
            this.mObserverList.clear();
        }
        this.mRenderDeInited = true;
    }

    public void removeRenderLifecycleObserver(RenderLifecycleObserver renderLifecycleObserver) {
        boolean z;
        if (renderLifecycleObserver != null) {
            ObserverItem observerItem = null;
            synchronized (this.mObserverList) {
                int i2 = 0;
                z = false;
                while (true) {
                    if (i2 >= this.mObserverList.size()) {
                        break;
                    }
                    observerItem = (ObserverItem) this.mObserverList.get(i2);
                    if (observerItem.observer == renderLifecycleObserver) {
                        z = true;
                    }
                    if ((renderLifecycleObserver instanceof NativeObjectRef) && (observerItem.observer instanceof NativeObjectRef) && ((NativeObjectRef) renderLifecycleObserver).hasSameNativeObject(observerItem.observer)) {
                        z = true;
                    }
                    if (z) {
                        observerItem.remove = true;
                        if (isInsideRenderThread()) {
                            this.mObserverList.remove(i2);
                        }
                    } else {
                        i2++;
                    }
                }
            }
            if (z && isInsideRenderThread()) {
                if (!observerItem.renderInited) {
                    observerItem.observer.onRenderInited();
                    if (this.mRenderTickTriggered) {
                        observerItem.observer.onRenderTick();
                    }
                }
                renderLifecycleObserver.onRenderWillDeinit();
            }
        }
    }
}
