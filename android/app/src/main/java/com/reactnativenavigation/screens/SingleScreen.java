package com.reactnativenavigation.screens;

import android.content.Context;
import android.support.annotation.NonNull;

import com.reactnativenavigation.params.ScreenParams;
import com.reactnativenavigation.views.ContentView;
import com.reactnativenavigation.views.TitleBarBackButtonListener;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class SingleScreen extends Screen {

    private ContentView contentView;

    public SingleScreen(Context context, ScreenParams screenParams,
                        TitleBarBackButtonListener titleBarBarBackButtonListener) {
        super(context, screenParams, titleBarBarBackButtonListener);
    }

    @Override
    protected void createContent() {
        contentView = new ContentView(getContext(), screenParams.screenId, screenParams.passProps, screenParams.navigationParams, this);
        addView(contentView, addBelowTopBar());
        contentView.init();
    }

    @NonNull
    private LayoutParams addBelowTopBar() {
        LayoutParams params = new LayoutParams(MATCH_PARENT, MATCH_PARENT);
        if (!screenParams.styleParams.drawUnderTopBar) {
            params.addRule(BELOW, topBar.getId());
        }
        return params;
    }

    @Override
    public void ensureUnmountOnDetachedFromWindow() {
        contentView.ensureUnmountOnDetachedFromWindow();
    }

    @Override
    public void preventUnmountOnDetachedFromWindow() {
        contentView.preventUnmountOnDetachedFromWindow();
    }
}