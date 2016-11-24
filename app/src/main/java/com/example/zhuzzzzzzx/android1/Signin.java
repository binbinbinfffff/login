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

public class Signin extends AppCompatActivity implements View.OnClickListener {
    private Button mbtnfinishsignin;
    private EditText medtphonenumber, medtpassword, medtrepassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        medtphonenumber = (EditText) findViewById(R.id.editText3);
        medtpassword = (EditText) findViewById(R.id.editText4);
        medtrepassword = (EditText) findViewById(R.id.editText5);
        mbtnfinishsignin = (Button) findViewById(R.id.button);
        mbtnfinishsignin.setOnClickListener(this);
    }

    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.button:
                String phonenumber = medtphonenumber.getText().toString();
                String Password = medtpassword.getText().toString();
                String Repassword = medtrepassword.getText().toString();
                if (phonenumber.equals("") || Password.equals("") || Repassword.equals("")) {
                    Toast.makeText(Signin.this, "手机号和密码均不能为空", Toast.LENGTH_SHORT).show();
                }
                else if (Password.equals(Repassword)) {
                    SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                    editor.putString("phonenumber", phonenumber);
                    editor.putString("Password", Password);
                    Log.d("TAG","phonenumber--->" + phonenumber);
                    Log.d("TAG","Password--->" + Password);
                    editor.commit();
                    Toast.makeText(Signin.this, "注册成功", Toast.LENGTH_SHORT).show();

                    finish();
                }
                else {
                    Toast.makeText(Signin.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
