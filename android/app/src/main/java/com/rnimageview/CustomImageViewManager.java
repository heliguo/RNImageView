package com.rnimageview;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

/**
 * @author lgh on 2021/10/30 20:18
 * @description
 */
public class CustomImageViewManager extends SimpleViewManager<CustomImageView> {

    private static final String REACT_CLASS = "CustomImageView";

    @Nullable
    private RequestManager requestManager = null;

    private CustomImageView mCustomImageView;

    private static CustomImageViewManager INSTANCE;

    public CustomImageViewManager() {
        INSTANCE = this;
    }

    @NonNull
    @NotNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @NotNull
    @Override
    protected CustomImageView createViewInstance(@NonNull ThemedReactContext reactContext) {
        if (ActivityUtils.isValidContextForGlide(reactContext)) {
            requestManager = Glide.with(reactContext);
        }
        mCustomImageView = new CustomImageView(reactContext);
        return mCustomImageView;
    }

    /**
     * ���䱳��ɫ����
     */
    @ReactProp(name = "url")
    public void setUrl(CustomImageView view, String url) {
        if (requestManager != null && !TextUtils.isEmpty(url)) {
            requestManager.load(url).into(view);
        }
    }

    public static CustomImageViewManager getInstance() {
        return INSTANCE;
    }

    public void setUrl(String url) {
        if (requestManager != null && !TextUtils.isEmpty(url) && mCustomImageView != null) {
            requestManager.load(url).into(mCustomImageView);
        }
    }

}
