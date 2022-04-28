package com.woongs.home_training;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class breaktime extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Handler handler;
    Thread thread;
    TextView breaktime1;

    int count;
    boolean going = true;
    GlobalVariables globalVariables = new GlobalVariables();
    int a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breaktime);

        long start = System.currentTimeMillis();

        sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        String value = sharedPreferences.getString("breaktime_value","20");

        count = Integer.parseInt(value);

        Intent intent1 = getIntent();
        a = intent1.getIntExtra("training_view",0);
        b = intent1.getIntExtra("order",0);


        Button skip = (Button) findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
            }
        });

        breaktime1 = (TextView) findViewById(R.id.breaktime_textview);

        handler = new Handler(Looper.myLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                breaktime1.setText(String.valueOf(msg.arg1));
                if(Integer.parseInt(breaktime1.getText().toString()) == 0){

                    long end = System.currentTimeMillis();
                    long aa = (end - start)/1000;
                    globalVariables.setT_time(globalVariables.getT_time() + aa);

                    switch (a){
                        case 1:
                            globalVariables.setSetnumber1(globalVariables.getSetnumber1()+1);
                            Intent intent = new Intent(breaktime.this,training_view.class);
                            startActivity(intent);
                            handler.removeCallbacksAndMessages(null);
                            finish();
                            break;
                        case 2:
                            globalVariables.setSetnumber1(globalVariables.getSetnumber1()+1);
                            Intent intent_2 = new Intent(breaktime.this,training_view2.class);
                            startActivity(intent_2);
                            handler.removeCallbacksAndMessages(null);
                            finish();
                            break;
                    }


                    switch (globalVariables.getSetlevel()){
                        case "level1":
                            switch (a){
                                case 10:
                                    Intent intent1 = new Intent(breaktime.this,level1_2.class);
                                    intent1.putExtra("order",b);
                                    startActivity(intent1);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 11:
                                    Intent intent2 = new Intent(breaktime.this,level1_1.class);
                                    intent2.putExtra("order",b);
                                    startActivity(intent2);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 12:
                                    Intent intent3 = new Intent(breaktime.this,level1_2.class);
                                    intent3.putExtra("order",b);
                                    startActivity(intent3);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 13:
                                    Intent intent4 = new Intent(breaktime.this,level1_2.class);
                                    intent4.putExtra("order",b);
                                    startActivity(intent4);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 14:
                                    Intent intent5 = new Intent(breaktime.this,level1_2.class);
                                    intent5.putExtra("order",b);
                                    startActivity(intent5);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 15:
                                    Intent intent6 = new Intent(breaktime.this,level1_1.class);
                                    intent6.putExtra("order",b);
                                    startActivity(intent6);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 16:
                                    Intent intent7 = new Intent(breaktime.this,level1_2.class);
                                    intent7.putExtra("order",b);
                                    startActivity(intent7);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 17:
                                    Intent intent8 = new Intent(breaktime.this,level1_2.class);
                                    intent8.putExtra("order",b);
                                    startActivity(intent8);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 18:
                                    Intent intent9 = new Intent(breaktime.this,level1_1.class);
                                    intent9.putExtra("order",b);
                                    startActivity(intent9);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                            }
                            break;


                        case "level2":
                            switch (a){
                                case 10:
                                    Intent intent1 = new Intent(breaktime.this,level1_2.class);
                                    intent1.putExtra("order",b);
                                    startActivity(intent1);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 11:
                                    Intent intent2 = new Intent(breaktime.this,level1_2.class);
                                    intent2.putExtra("order",b);
                                    startActivity(intent2);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 12:
                                    Intent intent3 = new Intent(breaktime.this,level1_1.class);
                                    intent3.putExtra("order",b);
                                    startActivity(intent3);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 13:
                                    Intent intent4 = new Intent(breaktime.this,level1_2.class);
                                    intent4.putExtra("order",b);
                                    startActivity(intent4);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 14:
                                    Intent intent5 = new Intent(breaktime.this,level1_2.class);
                                    intent5.putExtra("order",b);
                                    startActivity(intent5);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 15:
                                    Intent intent6 = new Intent(breaktime.this,level1_2.class);
                                    intent6.putExtra("order",b);
                                    startActivity(intent6);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 16:
                                    Intent intent7 = new Intent(breaktime.this,level1_1.class);
                                    intent7.putExtra("order",b);
                                    startActivity(intent7);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 17:
                                    Intent intent8 = new Intent(breaktime.this,level1_2.class);
                                    intent8.putExtra("order",b);
                                    startActivity(intent8);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 18:
                                    Intent intent9 = new Intent(breaktime.this,level1_2.class);
                                    intent9.putExtra("order",b);
                                    startActivity(intent9);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 19:
                                    Intent intent10 = new Intent(breaktime.this,level1_1.class);
                                    intent10.putExtra("order",b);
                                    startActivity(intent10);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 20:
                                    Intent intent11 = new Intent(breaktime.this,level1_1.class);
                                    intent11.putExtra("order",b);
                                    startActivity(intent11);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 21:
                                    Intent intent12 = new Intent(breaktime.this,level1_1.class);
                                    intent12.putExtra("order",b);
                                    startActivity(intent12);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 22:
                                    Intent intent13 = new Intent(breaktime.this,level1_1.class);
                                    intent13.putExtra("order",b);
                                    startActivity(intent13);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                            }
                            break;




                        case "level3":
                            switch (a){
                                case 10:
                                    Intent intent1 = new Intent(breaktime.this,level1_2.class);
                                    intent1.putExtra("order",b);
                                    startActivity(intent1);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 11:
                                    Intent intent2 = new Intent(breaktime.this,level1_2.class);
                                    intent2.putExtra("order",b);
                                    startActivity(intent2);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 12:
                                    Intent intent3 = new Intent(breaktime.this,level1_2.class);
                                    intent3.putExtra("order",b);
                                    startActivity(intent3);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 13:
                                    Intent intent4 = new Intent(breaktime.this,level1_1.class);
                                    intent4.putExtra("order",b);
                                    startActivity(intent4);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 14:
                                    Intent intent5 = new Intent(breaktime.this,level1_2.class);
                                    intent5.putExtra("order",b);
                                    startActivity(intent5);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 15:
                                    Intent intent6 = new Intent(breaktime.this,level1_1.class);
                                    intent6.putExtra("order",b);
                                    startActivity(intent6);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 16:
                                    Intent intent7 = new Intent(breaktime.this,level1_2.class);
                                    intent7.putExtra("order",b);
                                    startActivity(intent7);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 17:
                                    Intent intent8 = new Intent(breaktime.this,level1_2.class);
                                    intent8.putExtra("order",b);
                                    startActivity(intent8);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 18:
                                    Intent intent9 = new Intent(breaktime.this,level1_2.class);
                                    intent9.putExtra("order",b);
                                    startActivity(intent9);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 19:
                                    Intent intent10 = new Intent(breaktime.this,level1_2.class);
                                    intent10.putExtra("order",b);
                                    startActivity(intent10);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 20:
                                    Intent intent11 = new Intent(breaktime.this,level1_1.class);
                                    intent11.putExtra("order",b);
                                    startActivity(intent11);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 21:
                                    Intent intent12 = new Intent(breaktime.this,level1_2.class);
                                    intent12.putExtra("order",b);
                                    startActivity(intent12);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 22:
                                    Intent intent13 = new Intent(breaktime.this,level1_2.class);
                                    intent13.putExtra("order",b);
                                    startActivity(intent13);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 23:
                                    Intent intent14 = new Intent(breaktime.this,level1_1.class);
                                    intent14.putExtra("order",b);
                                    startActivity(intent14);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 24:
                                    Intent intent15 = new Intent(breaktime.this,level1_1.class);
                                    intent15.putExtra("order",b);
                                    startActivity(intent15);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 25:
                                    Intent intent16 = new Intent(breaktime.this,level1_1.class);
                                    intent16.putExtra("order",b);
                                    startActivity(intent16);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                                case 26:
                                    Intent intent17 = new Intent(breaktime.this,level1_1.class);
                                    intent17.putExtra("order",b);
                                    startActivity(intent17);
                                    handler.removeCallbacksAndMessages(null);
                                    finish();
                                    break;
                            }
                            break;
                    }

                }
            }
        };
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (going){
                    Message msg = handler.obtainMessage();
                    msg.arg1 = count;
                    handler.sendMessage(msg);
                    count = count-1;
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    if(count == -1 || count < 0){
                        going = false;
                    }
                }
            }
        });
        thread.start();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}