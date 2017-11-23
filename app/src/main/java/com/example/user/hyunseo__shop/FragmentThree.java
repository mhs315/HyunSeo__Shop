package com.example.user.hyunseo__shop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;


//FragmentThree은 fragment를 사용해야 하기 때문에 상속받아야 함
public class FragmentThree extends android.support.v4.app.Fragment {
    private WebView mWebView; //웹뷰 선언
    private WebSettings mWebSetting; //웹뷰 세팅



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_layout_3, container, false);

        //레이어와 연결
       mWebView = (WebView)v.findViewById(R.id.webview);
        //클릭시 새로운 창 띄우지 않음
        mWebView.setWebViewClient(new WebViewClient());
        //세부 세팅 등록
        mWebSetting = mWebView.getSettings();
        //자바스크립트 사용 허용
        mWebSetting.setJavaScriptEnabled(true);
        //원하는 홈페이지
        mWebView.loadUrl("https://github.com/mhs315");


        return v;
    }
}
