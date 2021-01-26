package com.baidu.sapi2.share;

import com.baidu.sapi2.share.ShareStorage.StorageModel;
import com.baidu.sapi2.share.ShareStorage.a;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;

/* compiled from: ShareStorage */
public class t implements a {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ShareStorage f2971a;

    public t(ShareStorage shareStorage) {
        this.f2971a = shareStorage;
    }

    public void a(StorageModel storageModel) {
        ThreadPoolService.getInstance().run(new TPRunnable(new s(this, storageModel)));
    }
}
