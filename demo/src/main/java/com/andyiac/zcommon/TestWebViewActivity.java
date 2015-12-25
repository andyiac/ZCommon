package com.andyiac.zcommon;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by andyiac
 * Date 15/12/24
 * web view 加载 js文件
 */
public class TestWebViewActivity extends Activity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_webview_activity);

        mWebView = (WebView) findViewById(R.id.id_test_web_view);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());

        String html = "<html>\n" +
                "<head>\n" +
                "<script src='http://7xn2nd.com2.z0.glb.qiniucdn.com/test.js' type='text/javascript'></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "aadafdsfasdf\n" +
                "\n" +
                "bbb" +
                "\n" +
                "</body>\n" +
                "</html>";
        mWebView.loadDataWithBaseURL("blarg://ignored", html, "text/html", "utf-8", "");
//        mWebView.loadData(html, "text/html;charset=UTF-8", null);
    }
}
