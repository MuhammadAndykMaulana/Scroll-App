package com.example.scrollapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mInputMsg;
    private TextView textReplayAc2;
    public static  final String MESSAGE_EXTRA="TEXT_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInputMsg=findViewById(R.id.editText);
        textReplayAc2=findViewById(R.id.txtReplyAct1);
        Log.i("MainActivity","onCreate");
        if(savedInstanceState!=null){
            String replyMessage=savedInstanceState.getString("REPLY_TEXT_SAVED");
            textReplayAc2.setText(replyMessage);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("MainActivity","onSaveInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity","onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity","onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity","onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity", "onRestart");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode==RESULT_OK && data!=null) {
            String replyMsg = data.getStringExtra(MESSAGE_EXTRA);
            textReplayAc2.setText(replyMsg);
        }
    }

    public void openSecondActivity(View view) {
        Intent secondIntent=new Intent(this, SecondActivity.class);
        secondIntent.putExtra(MESSAGE_EXTRA,mInputMsg.getText().toString());
        startActivityForResult(secondIntent,0);
    }
}
