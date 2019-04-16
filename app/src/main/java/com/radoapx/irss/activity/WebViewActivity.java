package com.radoapx.irss.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.radoapx.irss.R;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    private FloatingActionButton fab;
    private Intent intent;
    private int isStared;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        intent = getIntent();
        initView();
        openWeb();
    }

    private void initView(){
        webView=findViewById(R.id.web_view);
        fab=findViewById(R.id.fab);
        isStared=intent.getIntExtra("isStared",-1);
        if(isStared!=0&&isStared!=1) {
            Log.e("webview", "initView: "+"获取收藏情况出错" );
            Toast.makeText(this,"获取收藏情况出错",Toast.LENGTH_SHORT).show();
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isStared==1){
                    fab.setImageResource(R.drawable.star_b);
                    isStared=0;
                    Snackbar.make(v, "取收成功", Snackbar.LENGTH_SHORT)
                            .show();
                }else{
                    fab.setImageResource(R.drawable.star_a);
                    isStared=1;
                    Snackbar.make(v, "收藏成功", Snackbar.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

    private void openWeb(){
        Uri uri = intent.getData();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(uri+"");
    }

    @Override
    protected void onDestroy() {
        Intent intent=new Intent();
        intent.putExtra("isStared",isStared);
        intent.putExtra("position",intent.getIntExtra("position",-1));
        setResult(RESULT_OK,intent);
        super.onDestroy();
    }
}
