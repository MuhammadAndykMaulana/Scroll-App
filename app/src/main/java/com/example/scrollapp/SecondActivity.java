package com.example.scrollapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.scrollapp.MainActivity.MESSAGE_EXTRA;

public class SecondActivity extends AppCompatActivity {
    private TextView mTextMsge;
    private EditText eMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextMsge=findViewById(R.id.txtMsg);
        eMsg=findViewById(R.id.replayMsg);

        String msg=getIntent().getStringExtra(MESSAGE_EXTRA);
        mTextMsge.setText(msg);
    }


    public void sendReply(View view) {
        Intent data=new Intent();
        data.putExtra(MESSAGE_EXTRA, eMsg.getText().toString());
        setResult(RESULT_OK,data);
        finish();

    }
}
