package com.example.user.hyunseo__shop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;




//FragmentOne은 fragment를 사용해야 하기 때문에 상속받아야 함
public class FragmentOne extends android.support.v4.app.Fragment {

    //스레드 변수 선언
    int mainValue = 0;
    int backValue = 0;
    TextView mainText;
    TextView backText;
    Button increaseButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //밑에 오류 해결하기 위해 View객체로 생성
        View v = inflater.inflate(R.layout.frag_layout_1, container, false);

        //Fragment에서 바인딩을 위해 findViewById() 함수를 사용한다면 다음과 같은 오류가 발생합니다.
        //이유는 아직 inflation 이전의 View에 컴포넌트를 부르는 함수를 호출하기 때문에 널 포인터 오류가 나는 것 입니다.

        mainText = (TextView)v.findViewById(R.id.FristValue);
        backText = (TextView)v.findViewById(R.id.SecondValue);
        increaseButton = (Button)v.findViewById(R.id.UP);

        //backThread thread = new backThread();
        BackRunnable runnable = new BackRunnable();
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();

        increaseButton.setOnClickListener(new OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                mainValue++;
                mainText.setText("첫번째 값 : "+mainValue);
                backText.setText("두번째 값 : "+backValue);
            }
        });
        return v;
    }

    class BackRunnable implements Runnable{
        public void run(){
            while(true){
                backValue++;
                //backText.setText("BackValue : "+backValue);
                try {
                    //1초동안 쉰다.
                    Thread.sleep(1000);
                    //스레도 예외처리 (자바시간에 배움)
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
