package cc.jerrywang.webviewdemo.web.client;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import cc.jerrywang.webviewdemo.web.config.WhiteDomain;

public class BaseWebClient extends WebViewClient {

    private final String TAG = getClass().getSimpleName();

    private Context context;

    // =======================================================================================

    public BaseWebClient(Context context) {
        this.context = context;
    }

    @Override
    public void onLoadResource (WebView view, String url) {
        Log.d(TAG, url);
        super.onLoadResource(view, url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        if (url.isEmpty()) {
            return false;
        }

        // 白名單網域不需要處理,並檢查連結是否為apk檔案
        if (isWhiteDomain(url) | isApk(url)) {
            return false;
        }

        openActionView(url);
        return true;
    }

    private boolean isWhiteDomain(String url) {
        String hostUri = Uri.parse(url).getHost();
        return WhiteDomain.containsName(hostUri);
    }

    private boolean isApk(String url) {
        return url.toLowerCase().contains(".apk");
    }

    private void openActionView(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(intent);
    }

}
