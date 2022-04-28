package com.woongs.home_training;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class five_seconds extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView counttext;
    Handler handler;
    int count;
    boolean going;
    Thread thread;
    int a,order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_seconds);

        sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        String value = sharedPreferences.getString("ready_value","5");

        count = Integer.parseInt(value)+1;

        Intent intent1 = getIntent();
        a = intent1.getIntExtra("5seconds",0);
        order = intent1.getIntExtra("order",0);

        going = true;
        counttext = (TextView) findViewById(R.id.counttext);

        handler = new Handler(Looper.myLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                counttext.setText(String.valueOf(msg.arg1));

                if(Integer.parseInt(counttext.getText().toString()) == 0) {
                    switch (a){
                        case 1:
                            Intent intent = new Intent(five_seconds.this, training_view.class);
                            startActivity(intent);
                            handler.removeCallbacksAndMessages(null);
                            finish();
                            break;
                        case 2:
                            Intent intent2 = new Intent(five_seconds.this,training_view2.class);
                            startActivity(intent2);
                            handler.removeCallbacksAndMessages(null);
                            finish();
                            break;
                        case 10:
                            Intent intent1 = new Intent(five_seconds.this, level1_1.class);
                            intent1.putExtra("order",order);
                            startActivity(intent1);
                            handler.removeCallbacksAndMessages(null);
                            finish();
                            break;
                        case 11:
                            Intent intent11 = new Intent(five_seconds.this, level1_1.class);
                            intent11.putExtra("order",order);
                            startActivity(intent11);
                            handler.removeCallbacksAndMessages(null);
                            finish();
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
                    count = count-1;
                    msg.arg1 = count;
                    handler.sendMessage(msg);
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    if(count == 0){
                        going = false;
                    }
                }
            }
        }); thread.start();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}