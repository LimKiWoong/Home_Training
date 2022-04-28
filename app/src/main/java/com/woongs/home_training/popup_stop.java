package com.woongs.home_training;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class popup_stop extends AppCompatActivity {

    Button keepgoing;
    Button backhome2;
    GlobalVariables globalVariables;
    int getcount = 1;
    int tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_stop);


        Intent intent = getIntent();
        getcount = intent.getIntExtra("count",1);
        tag = intent.getIntExtra("tag",1);

        globalVariables = new GlobalVariables();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        keepgoing = (Button) findViewById(R.id.keepgoing);
        backhome2 = (Button) findViewById(R.id.backhome2);

        Handler handler = new Handler();


        keepgoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (tag){
                    case 2:
                        setResult(2000,intent);
                        finish();
                        break;
                    case 11:
                        setResult(11,intent);
                        finish();
                        break;
                }

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        switch (tag){
                            case 1:
                                intent.putExtra("start",1);
                                intent.putExtra("getcount",getcount);
                                setResult(1000,intent);
                                finish();
                                break;

                            case 10:
                                intent.putExtra("getcount",getcount);
                                setResult(10,intent);
                                finish();
                                break;

                        }

                    }
                }, 1000);

            }
        });

        backhome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (tag){
                    case 1:
                        Intent intent = new Intent(popup_stop.this,training_view.class);
                        resetData();
                        setResult(3000,intent);
                        finish();
                        break;
                    case 2:
                        Intent intent2 = new Intent(popup_stop.this,training_view2.class);
                        resetData();
                        setResult(3000,intent2);
                        finish();
                        break;
                    case 10:
                        Intent intent3 = new Intent(popup_stop.this,level1_1.class);
                        resetData();
                        setResult(3000,intent3);
                        finish();
                        break;
                    case 11:
                        Intent intent4 = new Intent(popup_stop.this,level1_2.class);
                        resetData();
                        setResult(3000,intent4);
                        finish();
                        break;
                }

            }
        });
    }

    //바깥레이어 클릭시 안닫히게
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    //안드로이드 백버튼 막기
    @Override
    public void onBackPressed() {
        return;
    }

    public void resetData(){
        globalVariables.setImage(0);
        globalVariables.setSetnumber1(0);
        globalVariables.setSetnumber2(0);
        globalVariables.setPos1_min_time(0);
        globalVariables.setPos1_sec_time(0);

        globalVariables.setPos2_min_time(0);
        globalVariables.setPos2_sec_time(0);

        globalVariables.setPos3_min_time(0);
        globalVariables.setPos3_sec_time(0);

        globalVariables.setPos4_min_time(0);
        globalVariables.setPos4_sec_time(0);

        globalVariables.setPos5_min_time(0);
        globalVariables.setPos5_sec_time(0);

        globalVariables.setPos1_count("0");
        globalVariables.setPos2_count("0");
        globalVariables.setPos3_count("0");
        globalVariables.setPos4_count("0");
        globalVariables.setPos5_count("0");

        globalVariables.setT_time(0);
        globalVariables.setSetlevel("0");
    }
}