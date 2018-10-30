package es.pue.android.webapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    WebView webv;
    Button btnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webv = (WebView)findViewById(R.id.webV);
        btnLoad = (Button)findViewById(R.id.btnLoadURL);

        btnLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        webv.setWebViewClient(new WebClient());
        webv.loadUrl("http://www.google.com");
    }

    private class WebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }
    }
}
