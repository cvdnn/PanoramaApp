package com.cvdnn.panorama;

import android.frame.context.FrameActivity;
import android.os.Bundle;

import com.cvdnn.panorama.databinding.ActWebviewBinding;
import com.cvdnn.panorama.model.WebViewModel;

public class WebViewActivity extends FrameActivity<ActWebviewBinding> {

    private final WebViewModel mWebModel = new WebViewModel();

    @Override
    protected ActWebviewBinding onViewBinding() {
        return ActWebviewBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mWebModel.onBind(this);
    }
}