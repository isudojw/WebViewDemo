package cc.jerrywang.webviewdemo.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import cc.jerrywang.webviewdemo.R;

public class FullScreenView extends Fragment {

    private View fullScreenView;
    private WebView fullScreenWebView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.webview_fullscreen, container, false);
        setItemId(view);
        return view;
    }

    private void setScreenOrientation(int orientation) {
        if (getActivity().getRequestedOrientation() != orientation) {
            getActivity().setRequestedOrientation(orientation);
        }
    }

    private void setItemId(View view) {
        fullScreenView = view.findViewById(R.id.fullScreen_view);
        fullScreenWebView = view.findViewById(R.id.fullScreen_webview);
    }

    private void setView(WebView webView) {
        fullScreenView = webView;
    }




    public static class exitBox extends DialogFragment {

    }

}
