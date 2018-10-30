package es.pue.android.webapplication;

import android.content.Intent;
import android.net.Uri;
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
        webv.setWebViewClient(new WebClient());
        btnLoad = (Button)findViewById(R.id.btnLoadURL);

        btnLoad.setOnClickListener(this);

        Intent intent = getIntent();
        if (intent != null && intent.getData() != null) {
            Uri url = intent.getData();
            webv.loadUrl(url.toString());
        }
    }

    @Override
    public void onClick(View v) {
        webv.loadUrl("http://www.google.com");
    }

    private class WebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }
    }
}
