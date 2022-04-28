package com.woongs.home_training;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Popup_bmi extends AppCompatActivity {

    double weight,height,bmi;
    String status;
    EditText popup_weight;
    EditText popup_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_bmi);

////        //타이틀바 없애기
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        popup_weight = (EditText) findViewById(R.id.popup_weight);
        popup_height = (EditText) findViewById(R.id.popup_height);

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

    public void popup_ok(View v){
        Intent intent = new Intent();
        weight = Double.parseDouble(popup_weight.getText().toString());
        height = Double.parseDouble(popup_height.getText().toString());
        bmi = (height/100)*(height/100);
        bmi = weight/bmi;
        bmi = Double.parseDouble(String.format("%.2f",bmi));
        //bmi 계산법 = kg / (키m X 키m)
        if(bmi > 0 && bmi <=18.5){
            status = "저체중";
        } else if(bmi > 18.5 && bmi<=23){
            status = "정상";
        } else if(bmi> 23 && bmi<=25){
            status = "과체중";
        } else if(bmi > 25 && bmi<=30){
            status = "비만";
        } else if(bmi > 30){
            status = "고도비만";
        } else {
            status ="X";
        }
        intent.putExtra("bmi_number",bmi);
        intent.putExtra("status_",status);
        setResult(2000,intent);
        finish();
    }

    public void popup_cancel(View v){
        Intent intent = new Intent();
        setResult(1500,intent);
        finish();
    }
}