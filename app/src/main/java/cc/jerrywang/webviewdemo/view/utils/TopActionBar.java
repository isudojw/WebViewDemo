package cc.jerrywang.webviewdemo.view.utils;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;

public class TopActionBar {

    private ActionBar actionBar;

    public TopActionBar(ActionBar actionBar) {
        this.actionBar = actionBar;
    }

    @SuppressLint("RestrictedApi")
    public TopActionBar setHideWithAnimation(Boolean withAnimation) {
        actionBar.setShowHideAnimationEnabled(withAnimation);
        actionBar.hide();
        return this;
    }

    public ActionBar getActionBar() {
        return actionBar;
    }


}
