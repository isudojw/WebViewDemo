package cc.jerrywang.webviewdemo.web.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebSettingBuilder {

    private Context context;
    private WebSettings webSettings;

    public WebSettingBuilder(Context context, WebView webView) {
        this.context = context;
        this.webSettings = webView.getSettings();
    }

    // http 與 https 混合模式
    public WebSettingBuilder setMixedContentMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        return this;
    }

    public WebSettingBuilder setLoadWithOverviewMode() {
        webSettings.setLoadWithOverviewMode(false);
        return this;
    }

    @SuppressLint("SetJavaScriptEnabled")
    public WebSettingBuilder setJsEnabled() {
        webSettings.setJavaScriptEnabled(true);
        return this;
    }

    public WebSettingBuilder setZoomControls() {
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        return this;
    }

    public WebSettingBuilder setCache() {
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCachePath(context.getCacheDir().getPath());
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        return this;
    }

    public WebSettingBuilder setDomStorage() {
        webSettings.setDomStorageEnabled(true);
        return this;
    }

    public WebSettingBuilder setMultipleWindows() {
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setSupportMultipleWindows(true);
        return this;
    }

    public WebSettings build() {
        return webSettings;
    }

    // =======================================================================================

    public WebSettings getBaseSetting() {
        return this
                .setMixedContentMode()
                .setJsEnabled()
                .setZoomControls()
                .setCache()
                .setDomStorage()
                .setMultipleWindows()
                .setLoadWithOverviewMode()
                .build();
    }

}
