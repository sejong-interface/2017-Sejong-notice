package project.a3team.com.a2teamtest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by helio on 2017-12-07.
 */

public class third2th extends AppCompatActivity {
    private WebView wv13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2th);
        wv13 = (WebView)findViewById(R.id.MapView13);
        wv13.loadUrl("https://www.google.com/maps/search/%EC%A4%91%EA%B3%A13%EB%8F%99+ATM/@37.5541274,127.0625652,3670m/data=!3m2!1e3!4b1?hl=k");
        wv13.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // 전화걸기 (퍼미션설정) Intent.ACTION_CALL , Intent.ACTION_DIAL
                if (url.contains("tel:")) {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(url)));
                    return true;
                }
                // 메일 보내기 Intent.ACTION_SENDTO
                else if (url.contains("mailto:")) {
                    startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse(url)));
                    return true;
                }
                // 웹 화면 띄우기
                else {
                    view.loadUrl(url);
                    return true;
                }
            }
        });

        wv13.getSettings().setLoadWithOverviewMode(true);
        wv13.getSettings().setUseWideViewPort(true);
        wv13.getSettings().setBuiltInZoomControls(true);
        wv13.getSettings().setDisplayZoomControls(false); //줌인아웃 가능
        wv13.getSettings().setJavaScriptEnabled(true);
        // webView.getSettings().setDefaultFontSize(30);
        // webView.getSettings().setTextZoom(100);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv13.canGoBack()) {
            wv13.goBack();
            return true;
        }


        return super.onKeyDown(keyCode, event);

    }
}
