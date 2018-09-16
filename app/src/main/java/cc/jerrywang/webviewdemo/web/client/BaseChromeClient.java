package cc.jerrywang.webviewdemo.web.client;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;

import cc.jerrywang.webviewdemo.MainActivity;

public class BaseChromeClient extends WebChromeClient {

    private Context context;

    public BaseChromeClient(Context context) {
        this.context = context;
    }

    // 使用全螢幕時呼叫
    @Override
    public void onShowCustomView(View view, CustomViewCallback callback) {

    }

    // 退出全螢幕時呼叫
    @Override
    public void onHideCustomView() {

    }
}
