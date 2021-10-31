package com.rnimageview;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.ViewManager;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CustomImageViewModule extends ReactContextBaseJavaModule {

    private static final String REACT_CLASS = "CustomImageView";


    CustomImageViewModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NotNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod //JS 调用的具体方法
    public void show(String url) {
        assert getCurrentActivity() != null;
        getCurrentActivity().runOnUiThread(() ->
                CustomImageViewManager.getInstance().setUrl(url));
    }

}
