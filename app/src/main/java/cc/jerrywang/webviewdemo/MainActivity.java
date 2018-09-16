package cc.jerrywang.webviewdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

import cc.jerrywang.webviewdemo.view.utils.TopActionBar;
import cc.jerrywang.webviewdemo.web.WebViewController;
import cc.jerrywang.webviewdemo.view.utils.BottomNavigationBuilder;

/**
 * 負責顯示畫面(view)
 */
public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private ActionBar actionBar;
    private BottomNavigationView bottomNavigation;
    private WebViewController webViewController;

    private Boolean fullScreenMode = false;

    // =======================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);
        setDebugMode();
        setItemId();
        setView();
    }

    private void setDebugMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    private void setItemId() {
        webView = findViewById(R.id.webView);
        bottomNavigation = findViewById(R.id.bottomNavigation);
    }

    private void setView() {
        initActionBar();
        initNavigationView();
        initWebViewController();
    }

    private void initActionBar() {
        actionBar = new TopActionBar(getSupportActionBar())
                        .setHideWithAnimation(true)
                        .getActionBar();
    }

    private void initNavigationView() {
        bottomNavigation = new BottomNavigationBuilder(this, bottomNavigation)
                                .setBaseConfig()
                                .getBottomNavigation();
    }

    private void initWebViewController() {
        webViewController = new WebViewController(this, webView);
    }

    // =======================================================================================

    public void setWebView(WebView webView) {
        this.webView = webView;
    }

    public void setFullScreenView(View view) {
        bottomNavigation.setVisibility(View.INVISIBLE);
        // TODO : need finish full screen function
        setFullScreenMode(true);
    }

    public void exitFullScreenView() {
        setFullScreenMode(false);
    }

    private void setFullScreenMode(Boolean enable) {
        fullScreenMode = enable;
    }

    public void showLoadingAnimation(Boolean enable) {
        // TODO : need finish this function
    }

    private Boolean isFullScreenMode() {
        return fullScreenMode;
    }

    // =======================================================================================

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            return webViewController.goBack();
        }
        return super.onKeyDown(keyCode, event);
    }

    // =======================================================================================

    @Override
    protected void onStop() {
        release();
        super.onStop();
    }

    private void release() {
        webView.destroy();
    }
}
