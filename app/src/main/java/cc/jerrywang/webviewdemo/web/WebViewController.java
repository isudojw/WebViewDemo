package cc.jerrywang.webviewdemo.web;

import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import cc.jerrywang.webviewdemo.MainActivity;
import cc.jerrywang.webviewdemo.R;
import cc.jerrywang.webviewdemo.web.client.BaseChromeClient;
import cc.jerrywang.webviewdemo.web.client.BaseWebClient;
import cc.jerrywang.webviewdemo.web.utils.WebSettingBuilder;

public class WebViewController {

    private MainActivity activity;
    private Context context;
    private WebView webView;
    private WebSettings webSettings;

    // =======================================================================================

    public WebViewController(MainActivity activity, WebView webView) {
        this.activity = activity;
        this.context = activity;
        this.webView = webView;

        initSetting();
        initClient();
        openIndex();
    }

    private void initSetting() {
        webSettings = new WebSettingBuilder(context, webView).getBaseSetting();
    }

    private void initClient() {
        webView.setWebChromeClient(new BaseChromeClient(context));
        webView.setWebViewClient(new BaseWebClient(context));
    }

    public WebView getWebView() {
        return webView;
    }

    // TODO : add your index url at here
    public void openIndex() {
        openUrl(R.string.url_google_tw);
    }

    // =======================================================================================

    public void openUrl(int resId) {
        this.openUrl(context.getResources().getString(resId), false);
    }

    public void openUrl(int resId, Boolean showLoadingAnimation) {
        this.openUrl(context.getResources().getString(resId), showLoadingAnimation);
    }

    public void openUrl(String url) {
        this.openUrl(url, false);
    }

    public void openUrl(String url, Boolean showLoadingAnimation) {
        activity.showLoadingAnimation(false);
        webView.loadUrl(url);
    }

    public Boolean goBack() {
        if (webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return false;
    }

    public View getDisplayView() {
        return null;
    }

    public void clearView() {
        this.openUrl("about:blank", false);
    }

    public void clearCache() {
        webView.clearCache(true);
        webView.clearHistory();
    }
}
