package com.example.user.hyunseo__shop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

//FragmentTwo은 fragment를 사용해야 하기 때문에 상속받아야 함
public class FragmentTwo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_layout_2, container, false);

        //프레그먼트에서는 getApplicationContext() 그대로 쓰면 안되고  getActivity().getApplicationContext(); 로 써야함
        final DBHelper dbHelper = new DBHelper( getActivity().getApplicationContext(), "MONEYBOOK.db", null, 1);

        // 테이블에 있는 모든 데이터 출력
        final TextView result = (TextView) v.findViewById(R.id.result);
        final EditText etDate = (EditText) v.findViewById(R.id.date);
        final EditText etitem = (EditText) v.findViewById(R.id.item);
        final EditText etprice = (EditText) v.findViewById(R.id.price);



        // 날짜는 현재 날짜로 고정 ,현재 시간 구하기
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        // 출력될 포맷 설정
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        etDate.setText(simpleDateFormat.format(date));


        // DB에 데이터 추가
        Button insert = (Button) v.findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = etDate.getText().toString();
                String item = etitem.getText().toString();
                int price = Integer.parseInt(etprice.getText().toString());

                dbHelper.insert(date, item, price);
                result.setText(dbHelper.getResult());
            }
        });



        // DB에 있는 데이터 삭제
        Button delete = (Button) v.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etitem.getText().toString();

                dbHelper.delete(name);
                result.setText(dbHelper.getResult());
            }
        });

        return v;
    }

}