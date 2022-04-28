package com.woongs.home_training;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class training_view extends AppCompatActivity {

    TextView training_name2;
    GlobalVariables globalVariables = new GlobalVariables();
    TextView setnumber1;
    TextView setnumber2;
    TextView training_time_min;
    TextView training_time_sec;
    Button training_stop;
    Button training_skip;
    Handler handler;
    Thread thread;
    boolean going;
    int seccount = 30;
    int mincount = 0;
    int start = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_view);

        long start = System.currentTimeMillis();

        training_name2 = (TextView) findViewById(R.id.training_name2);
        switch (globalVariables.getImage()){
            case 1:
                training_name2.setText("플랭크");
                break;
        }

        going = true;

        setnumber1 = (TextView) findViewById(R.id.setnumber_1);
        setnumber1.setText(String.valueOf(globalVariables.getSetnumber1()));
        setnumber2 = (TextView) findViewById(R.id.setnumber_2);
        setnumber2.setText(String.valueOf(globalVariables.getSetnumber2()));
        training_time_min = (TextView) findViewById(R.id.training_time_min);
        training_time_sec = (TextView) findViewById(R.id.training_time_sec);
        training_stop = (Button) findViewById(R.id.training_stop);
        training_skip = (Button) findViewById(R.id.training_skip);

        training_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seccount = 0;
                mincount = 0;
            }
        });
        training_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                going = false;
                Intent intent = new Intent(training_view.this,popup_stop.class);
                intent.putExtra("count",seccount+1);
                intent.putExtra("tag",1);
                startActivityForResult(intent,1000);

                handler.removeCallbacksAndMessages(null);
            }
        });

//        Toolbar toolbar = (Toolbar) findViewById(R.id.training_toolbar);
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        ImageView imageView = (ImageView) findViewById(R.id.training_imageview);
        switch (globalVariables.getImage()) {
            case 1:
                Glide.with(this).load(R.drawable.plank).centerCrop().into(imageView);
                break;
        }


        switch (globalVariables.getSetnumber1()){
            case 1:
                seccount = globalVariables.getPos1_sec_time();
                mincount = globalVariables.getPos1_min_time();
                break;
            case 2:
                seccount = globalVariables.getPos2_sec_time();
                mincount = globalVariables.getPos2_min_time();
                break;
            case 3:
                seccount = globalVariables.getPos3_sec_time();
                mincount = globalVariables.getPos3_min_time();
                break;
            case 4:
                seccount = globalVariables.getPos4_sec_time();
                mincount = globalVariables.getPos4_min_time();
                break;
            case 5:
                seccount = globalVariables.getPos5_sec_time();
                mincount = globalVariables.getPos5_min_time();
                break;
        }


        handler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                training_time_min.setText("0" + msg.arg2);

                if (seccount < 9 || seccount == 59) {
                    training_time_sec.setText("0" + String.valueOf(msg.arg1));
                } else {
                    training_time_sec.setText(String.valueOf(msg.arg1));
                }

                if (Integer.parseInt(training_time_sec.getText().toString()) <= 0 && Integer.parseInt(training_time_min.getText().toString()) == 0) {

                    long end = System.currentTimeMillis();
                    long aa = (end - start)/1000;
                    globalVariables.setT_time(globalVariables.getT_time() + aa);

                    if(globalVariables.getSetnumber1() == globalVariables.getSetnumber2()){
                        //세트운동 다 끝나면
                        Intent intent1 = new Intent(training_view.this,finish1.class);
                        startActivity(intent1);
                        handler.removeCallbacksAndMessages(null);
                        finish();
                    }else if(globalVariables.getSetnumber1() < globalVariables.getSetnumber2()){
                        Intent intent = new Intent(training_view.this, breaktime.class);
                        intent.putExtra("training_view",1);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        };

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (going) {
                    Message msg = handler.obtainMessage();
                    msg.arg1 = seccount;
                    msg.arg2 = mincount;
                    handler.sendMessage(msg);
                    if(seccount <= 0){
                        if(mincount > 0){
                            mincount = mincount -1;
                            seccount = 60;
                        }
                    }
                    seccount = seccount -1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(seccount <= -1 && mincount <= 0){
                        going = false;
                    }
                }
            }
        });thread.start();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    public void openExamplePopup(View v){

        going = false;
        Intent intent = new Intent(training_view.this,training_example.class);
        intent.putExtra("count",seccount+1);
        intent.putExtra("tag",1);
        startActivityForResult(intent,1000);

        handler.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1000){
            if(resultCode == 1000){
                int a = data.getIntExtra("start",0);
                if(a == 1){
                    start = a;
                    seccount = data.getIntExtra("getcount",1);
                    going = true;
                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (going) {
                                Message msg = handler.obtainMessage();
                                msg.arg1 = seccount;
                                msg.arg2 = mincount;
                                handler.sendMessage(msg);
                                if(seccount <= 0){
                                    if(mincount > 0){
                                        mincount = mincount -1;
                                        seccount = 60;
                                    }
                                }
                                seccount = seccount -1;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if(seccount <= -1 && mincount <= 0){
                                    going = false;
                                }
                            }
                        }
                    });thread.start();
                }
            }
            if(resultCode == 3000){
                going = false;
                finish();
            }
        }
    }
}