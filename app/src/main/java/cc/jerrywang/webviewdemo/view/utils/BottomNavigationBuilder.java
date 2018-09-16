package cc.jerrywang.webviewdemo.view.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;

import cc.jerrywang.webviewdemo.R;


public class BottomNavigationBuilder {

    private Context context;
    private BottomNavigationView bottomNavigation;

    // =======================================================================================

    public BottomNavigationBuilder(Context context, BottomNavigationView findViewById) {
        this.context = context;
        this.bottomNavigation = findViewById;
    }

    public BottomNavigationBuilder setBaseConfig() {
        setTextVisible();
        setSelectedListener();
        return this;
    }

    // 設定item文字為永久可見
    private void setTextVisible() {
        bottomNavigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
    }

    // 設定item選擇事件監聽
    private void setSelectedListener() {
        BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    String url;

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        // TODO : rewrite web_menu.xml and case function
                        switch (item.getItemId()) {

                            case R.id.web_menu_home:
                                url = context.getResources().getString(R.string.url_google_tw);
                                break;

                            case R.id.web_menu_promise:
                                url = context.getResources().getString(R.string.url_google_tw);
                                break;

                            case R.id.web_menu_contact:
                                url = context.getResources().getString(R.string.url_google_tw);
                                break;

                            case R.id.web_menu_download:
                                url = context.getResources().getString(R.string.url_google_tw);
                                break;

                            case R.id.web_menu_try_now:
                                url = context.getResources().getString(R.string.url_google_tw);
                                break;

                            default:
                                url = context.getResources().getString(R.string.url_google_tw);
                        }
                        // TODO openUrl or some function
                        return true;
                    }
                };
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }

    public BottomNavigationView getBottomNavigation() {
        return bottomNavigation;
    }
}
