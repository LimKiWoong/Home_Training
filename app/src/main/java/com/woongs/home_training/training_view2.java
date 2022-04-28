package com.woongs.home_training;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class training_view2 extends AppCompatActivity {

    TextView training_name3;
    GlobalVariables globalVariables = new GlobalVariables();
    TextView setnumber1;
    TextView setnumber2;
    TextView count;
    Button stop;
    Button complete;
    String getcount = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_view2);

        long start = System.currentTimeMillis();

//        Toolbar toolbar = (Toolbar) findViewById(R.id.training_toolbar2);
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        ImageView imageView = (ImageView) findViewById(R.id.training_imageview2);
        training_name3 = (TextView) findViewById(R.id.training_name3);
        switch (globalVariables.getImage()){
            case 2:
                Glide.with(this).load(R.raw.crunch).centerCrop().into(imageView);
                training_name3.setText("크런치");
                break;
            case 3:
                Glide.with(this).load(R.raw.mountain_climer).centerCrop().into(imageView);
                training_name3.setText("마운틴 클라이머");
                break;
            case 4:
                Glide.with(this).load(R.raw.bicycle_maneuver).centerCrop().into(imageView);
                training_name3.setText("바이시클 메뉴버");
                break;
            case 5:
                Glide.with(this).load(R.raw.pushup).centerCrop().into(imageView);
                training_name3.setText("팔굽혀펴기");
                break;
            case 6:
                Glide.with(this).load(R.raw.singleleg_pushup).centerCrop().into(imageView);
                training_name3.setText("싱글레그푸쉬업");
                break;
            case 7:
                Glide.with(this).load(R.raw.incline_pushup).centerCrop().into(imageView);
                training_name3.setText("인클라인푸쉬업");
                break;
            case 8:
                Glide.with(this).load(R.raw.decline_pushup).centerCrop().into(imageView);
                training_name3.setText("디클라인푸쉬업");
                break;
            case 9:
                Glide.with(this).load(R.raw.lying_extension).centerCrop().into(imageView);
                training_name3.setText("라잉익스텐션");
                break;
            case 10:
                Glide.with(this).load(R.raw.kickback).centerCrop().into(imageView);
                training_name3.setText("킥백");
                break;
            case 11:
                Glide.with(this).load(R.raw.deeps).centerCrop().into(imageView);
                training_name3.setText("딥스");
                break;
            case 12:
                Glide.with(this).load(R.raw.dumbellcurl).centerCrop().into(imageView);
                training_name3.setText("덤벨컬");
                break;
            case 13:
                Glide.with(this).load(R.raw.squat).centerCrop().into(imageView);
                training_name3.setText("스쿼트");
                break;
            case 14:
                Glide.with(this).load(R.raw.runge).centerCrop().into(imageView);
                training_name3.setText("런지");
                break;
            case 15:
                Glide.with(this).load(R.raw.skate).centerCrop().into(imageView);
                training_name3.setText("측면운동");
                break;
            case 16:
                Glide.with(this).load(R.raw.side_legrase).centerCrop().into(imageView);
                training_name3.setText("사이드레그레이즈");
                break;
            default:
                return;
        }

        stop = (Button) findViewById(R.id.training_stop2);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(training_view2.this,popup_stop.class);
                intent.putExtra("tag",2);
                startActivityForResult(intent,2000);
            }
        });
        complete = (Button) findViewById(R.id.training_complete2);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long end = System.currentTimeMillis();
                long aa = (end - start)/1000;
                globalVariables.setT_time(globalVariables.getT_time() + aa);

                if(globalVariables.getSetnumber1() == globalVariables.getSetnumber2()){
                    //세트운동 다 끝나면
                    Intent intent1 = new Intent(training_view2.this,finish1.class);
                    startActivity(intent1);
                    finish();
                }else if(globalVariables.getSetnumber1() < globalVariables.getSetnumber2()){
                    Intent intent = new Intent(training_view2.this, breaktime.class);
                    intent.putExtra("training_view",2);
                    startActivity(intent);
                    finish();
                }
            }
        });

        setnumber1 = (TextView) findViewById(R.id.training_view2_setnumber1);
        setnumber1.setText(String.valueOf(globalVariables.getSetnumber1()));
        setnumber2 = (TextView) findViewById(R.id.training_view2_setnumber2);
        setnumber2.setText(String.valueOf(globalVariables.getSetnumber2()));
        count = (TextView) findViewById(R.id.training_view2_count);


        switch (globalVariables.getSetnumber1()){
            case 1:
                getcount = globalVariables.getPos1_count();
                break;
            case 2:
                getcount = globalVariables.getPos2_count();
                break;
            case 3:
                getcount = globalVariables.getPos3_count();
                break;
            case 4:
                getcount = globalVariables.getPos4_count();
                break;
            case 5:
                getcount = globalVariables.getPos5_count();
                break;
        }

        count.setText(getcount);
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

    public void openExamplePopup(View v){
        Intent intent = new Intent(training_view2.this,training_example.class);
        intent.putExtra("tag",2);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2000){
            if(resultCode == 2000){

            }
            if(resultCode == 3000){
                finish();
            }
        }
    }
}