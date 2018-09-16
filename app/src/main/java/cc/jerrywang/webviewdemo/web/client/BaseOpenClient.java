package cc.jerrywang.webviewdemo.web.client;

import android.content.Context;
import android.webkit.WebView;

public class BaseOpenClient {

    private Context context;
    private WebView webView;

    public BaseOpenClient(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
    }

    public void openUrl(String url) {
        webView.loadUrl(url);
    }

    // TODO : 驗證url字串
    private String checkUrl(String url) {

        if (url.isEmpty()) {
            return "INDEX";
        }
        return "";
    }

    private void loadUrl(String url) {
        webView.loadUrl(url);
    }
}
