package com.example.user.hyunseo__shop;

import java.util.Locale;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //activity_main.xml에 있는 세 개의 버튼 클릭시 불러옴
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.Frist).setOnClickListener(this);
        findViewById(R.id.Second).setOnClickListener(this);
        findViewById(R.id.Third).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Frist:
                getSupportFragmentManager()
                        .beginTransaction()

                        //new FragmentOne에서
                        .replace(R.id.frag_container_, new FragmentOne())
                        .commit();
                break;
            case R.id.Second:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frag_container_, new FragmentTwo())
                        .commit();
                break;
            case R.id.Third:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frag_container_, new FragmentThree())
                        .commit();
                break;
        }
    }
}
