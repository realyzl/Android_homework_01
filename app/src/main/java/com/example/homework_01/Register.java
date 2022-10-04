package com.example.homework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    String sex = "";
    String cities = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }
    private void init(){    //初始化按钮
        Button but_Register = findViewById(R.id.but_Register);
        but_Register.setOnClickListener(this);
        RadioGroup radioGroup = findViewById(R.id.rg1);
        radioGroup.setOnCheckedChangeListener(this);
        CheckBox cb_bj = findViewById(R.id.checkBox_BJ);
        CheckBox cb_sh = findViewById(R.id.checkBox_SH);
        CheckBox cb_gz = findViewById(R.id.checkBox_GZ);
        CheckBox cb_sz = findViewById(R.id.checkBox_SZ);
        cb_bj.setOnCheckedChangeListener(this);
        cb_sh.setOnCheckedChangeListener(this);
        cb_gz.setOnCheckedChangeListener(this);
        cb_sz.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {    //点击事件
        EditText editText = findViewById(R.id.editText_Name);
        String account = editText.getText().toString();
        if(account.equals("")){
            Toast.makeText(Register.this, "姓名不能为空！", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.but_Register){
            Toast.makeText(Register.this, "注册成功！", Toast.LENGTH_SHORT).show();
            Intent intent_Friends = new Intent(this, Friends.class);
            Bundle bundle = new Bundle();
            bundle.putString("account", account);
            bundle.putString("sex", sex);
            bundle.putString("cities",cities);
            intent_Friends.putExtras(bundle);
            startActivity(intent_Friends);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.man){
            sex = "先生";
        }else {
            sex = "女士";
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String city = compoundButton.getText().toString();
        if (b){
            if(!cities.contains(city)){
                cities = cities + city;
            }
        }else{
            if(cities.contains(city)){
                cities = cities.replace(city,"");
            }
        }
    }
}