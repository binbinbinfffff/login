package com.example.zhuzzzzzzx.android1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Found extends AppCompatActivity implements View.OnClickListener {
    private Button exit,send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);
        exit = (Button) findViewById(R.id.button5);
        exit.setOnClickListener(this);
        send = (Button) findViewById(R.id.button4);
        send.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button5:
            finish();
            break;
            case R.id.button4:
                Toast.makeText(Found.this, "收不到的", Toast.LENGTH_SHORT).show();
        }
    }
}
