package com.example.homework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Friends extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        //接受账号名
        Bundle bundle = getIntent().getExtras();
        String account = bundle.getString("account");
        String sex = bundle.getString("sex");
        String cities = bundle.getString("cities");

        TextView textView = findViewById(R.id.textView);

        String hello = "Hello," + account + "!";
        textView.setText(hello);
        String hello1 = "Hello," + account + "!";
        String hello2 = "Hello," + account + sex + "!";
        String hello3 = "Hello,\n" + "去过" + cities + "的\n" + account + "!";
        String hello4 = "Hello,\n" + "去过" + cities + "的\n" + account + sex + "!";

        if (sex.equals("") && cities.equals("")){
            textView.setText(hello1);
        }else if(sex.equals("")){
            textView.setText(hello3);
        }else if(cities.equals("")){
            textView.setText(hello2);
        }else {
            textView.setText(hello4);
        }
    }
}