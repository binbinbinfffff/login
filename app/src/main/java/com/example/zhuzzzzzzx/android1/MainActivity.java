package com.example.zhuzzzzzzx.android1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.zhuzzzzzzx.android1.R.id.editText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username,password;
    private Button login,singin,forget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.button1);
        login.setOnClickListener(this);
        singin = (Button) findViewById(R.id.button2);
        singin.setOnClickListener(this);
        singin = (Button) findViewById(R.id.button3);
        singin.setOnClickListener(this);
        password=(EditText) findViewById(editText);
        username=(EditText) findViewById(R.id.editText2);
    }

    public void onClick(View v) {
        String musername = username.getText().toString();
        String mpassword = password.getText().toString();


        switch (v.getId()) {
            case R.id.button2:
                SharedPreferences get=getSharedPreferences("data",MODE_PRIVATE);
                String Username=get.getString("phonenumber","");
                String Password=get.getString("Password","");
                Log.d("TAG","Username--->" + Username);
                Log.d("TAG","Password--->" + Password);
                if(musername.equals(Username)&&mpassword.equals(Password)){
                    Intent intent = new Intent(MainActivity.this, LoginSucceed.class);
                    startActivity(intent);
                }
                else if(musername.equals("")||mpassword.equals("")){
                    Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button1:
                Intent intent = new Intent(MainActivity.this, Found.class);
                startActivity(intent);
                break;
            case R.id.button3:
                Intent intent1 = new Intent(MainActivity.this, Signin.class);
                startActivity(intent1);
                break;
        }
    }
}
