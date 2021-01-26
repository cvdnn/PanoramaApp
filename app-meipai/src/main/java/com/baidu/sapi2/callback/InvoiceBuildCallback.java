package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.InvoiceBuildResult;

public interface InvoiceBuildCallback {
    void onFinish(InvoiceBuildResult invoiceBuildResult);
}
