package com.example.homework_01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Login extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    private void init(){    //初始化按钮
        Button but_login = findViewById(R.id.but_login);
        but_login.setOnClickListener(this);
        Button but_skip = findViewById(R.id.but_skip);
        but_skip.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {    //点击事件
        switch (view.getId()){
            case R.id.but_skip: //跳转注册界面
                Intent intent_Register = new Intent(this, Register.class);
                startActivity(intent_Register);
                break;
            case  R.id.but_login:   //判断登录
                EditText editText_account = findViewById(R.id.editText_Account);
                String account = editText_account.getText().toString();
                EditText editText_password = findViewById(R.id.editText_Password);
                String password = editText_password.getText().toString();
                if(account.equals("") || password.equals("")){  //如果账号或密码为空
                    Toast.makeText(Login.this, "账号和密码不能为空！", Toast.LENGTH_SHORT).show();
                }else if (account.equals("admin") && password.equals("abc123")){    //如果账号密码正确
                    Toast.makeText(Login.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                    Intent intent_Friends = new Intent(this, Friends.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("account", account);
                    bundle.putString("sex", "");
                    bundle.putString("cities","");
                    intent_Friends.putExtras(bundle);
                    startActivity(intent_Friends);
                }else{  //如果账号密码错误
                    Toast.makeText(Login.this, "账号或密码错误！", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}