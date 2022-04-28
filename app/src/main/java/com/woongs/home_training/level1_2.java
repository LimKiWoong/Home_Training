package com.woongs.home_training;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class level1_2 extends AppCompatActivity {

    ImageView imageView;
    Button stop;
    Button complete;
    TextView name;
    TextView setnumber;
    TextView setnumber2;
    TextView count;

    int order;
    GlobalVariables globalVariables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1_2);

        long start = System.currentTimeMillis();

        globalVariables = new GlobalVariables();

        name = (TextView) findViewById(R.id.level1_2_name);
        setnumber = (TextView) findViewById(R.id.level1_2_setnumber);
        setnumber2 = (TextView) findViewById(R.id.level1_2_setnumber2);
        count = (TextView) findViewById(R.id.level1_2_count);
        imageView = (ImageView) findViewById(R.id.level1_2_image);

        Intent intent = getIntent();
        order = intent.getIntExtra("order",0);

        switch (globalVariables.getSetlevel()){
            case "level1":
                setnumber2.setText("10");
                switch (order){
                    case 2:
                        Glide.with(this).load(R.raw.mountain_climer).centerCrop().into(imageView);
                        name.setText("마운틴 클라이머");
                        setnumber.setText("0" + order);
                        count.setText("X12");
                        break;
                    case 4:
                        Glide.with(this).load(R.raw.crunch).centerCrop().into(imageView);
                        name.setText("크런치");
                        setnumber.setText("0" + order);
                        count.setText("X12");
                        break;
                    case 5:
                        Glide.with(this).load(R.raw.knee_pushup).centerCrop().into(imageView);
                        name.setText("무릎대고 팔굽혀펴기");
                        setnumber.setText("0" + order);
                        count.setText("X12");
                        break;
                    case 6:
                        Glide.with(this).load(R.raw.incline_pushup).centerCrop().into(imageView);
                        name.setText("인클라인푸쉬업");
                        setnumber.setText("0" + order);
                        count.setText("X8");
                        break;
                    case 8:
                        Glide.with(this).load(R.raw.squat).centerCrop().into(imageView);
                        name.setText("스쿼트");
                        setnumber.setText("0" + order);
                        count.setText("X12");
                        break;
                    case 9:
                        Glide.with(this).load(R.raw.runge).centerCrop().into(imageView);
                        name.setText("런지");
                        setnumber.setText("0" + order);
                        count.setText("X12");
                        break;
                }
                break;



            case "level2":
                setnumber2.setText("14");
                switch (order){
                    case 2:
                        Glide.with(this).load(R.raw.bicycle_maneuver).centerCrop().into(imageView);
                        name.setText("바이시클메뉴버");
                        setnumber.setText("0" + order);
                        count.setText("X20");
                        break;
                    case 3:
                        Glide.with(this).load(R.raw.mountain_climer).centerCrop().into(imageView);
                        name.setText("마운틴 클라이머");
                        setnumber.setText("0" + order);
                        count.setText("X20");
                        break;
                    case 5:
                        Glide.with(this).load(R.raw.crunch).centerCrop().into(imageView);
                        name.setText("크런치");
                        setnumber.setText("0" + order);
                        count.setText("X20");
                        break;
                    case 6:
                        Glide.with(this).load(R.raw.pushup).centerCrop().into(imageView);
                        name.setText("팔굽혀펴기");
                        setnumber.setText("0" + order);
                        count.setText("X10");
                        break;
                    case 7:
                        Glide.with(this).load(R.raw.singleleg_pushup).centerCrop().into(imageView);
                        name.setText("싱글레그푸쉬업");
                        setnumber.setText("0" + order);
                        count.setText("X6");
                        break;
                    case 9:
                        Glide.with(this).load(R.raw.squat).centerCrop().into(imageView);
                        name.setText("스쿼트");
                        setnumber.setText("0" + order);
                        count.setText("X20");
                        break;
                    case 10:
                        Glide.with(this).load(R.raw.runge).centerCrop().into(imageView);
                        name.setText("런지");
                        setnumber.setText(String.valueOf(order));
                        count.setText("X20");
                        break;
                }
                break;




            case "level3":
                setnumber2.setText("18");
                switch (order){
                    case 2:
                        name.setText("윗몸일으키기");
                        setnumber.setText("0" + order);
                        count.setText("X20");
                        break;
                    case 3:
                        Glide.with(this).load(R.raw.bicycle_maneuver).centerCrop().into(imageView);
                        name.setText("바이시클메뉴버");
                        setnumber.setText("0" + order);
                        count.setText("X24");
                        break;
                    case 4:
                        Glide.with(this).load(R.raw.mountain_climer).centerCrop().into(imageView);
                        name.setText("마운틴 클라이머");
                        setnumber.setText("0" + order);
                        count.setText("X30");
                        break;
                    case 6:
                        Glide.with(this).load(R.raw.crunch).centerCrop().into(imageView);
                        name.setText("크런치");
                        setnumber.setText("0" + order);
                        count.setText("X28");
                        break;
                    case 8:
                        Glide.with(this).load(R.raw.pushup).centerCrop().into(imageView);
                        name.setText("팔굽혀펴기");
                        setnumber.setText("0" + order);
                        count.setText("X12");
                        break;
                    case 9:
                        Glide.with(this).load(R.raw.singleleg_pushup).centerCrop().into(imageView);
                        name.setText("싱글레그푸쉬업");
                        setnumber.setText("0" + order);
                        count.setText("X8");
                        break;
                    case 10:
                        Glide.with(this).load(R.raw.decline_pushup).centerCrop().into(imageView);
                        name.setText("디클라인푸쉬업");
                        setnumber.setText(String.valueOf(order));
                        count.setText("X12");
                        break;
                    case 11:
                        Glide.with(this).load(R.raw.burpee).centerCrop().into(imageView);
                        name.setText("버피");
                        setnumber.setText(String.valueOf(order));
                        count.setText("X10");
                        break;
                    case 13:
                        Glide.with(this).load(R.raw.squat).centerCrop().into(imageView);
                        name.setText("스쿼트");
                        setnumber.setText(String.valueOf(order));
                        count.setText("X30");
                        break;
                    case 14:
                        Glide.with(this).load(R.raw.runge).centerCrop().into(imageView);
                        name.setText("런지");
                        setnumber.setText(String.valueOf(order));
                        count.setText("X30");
                        break;
                }
                break;

        }

        stop = (Button) findViewById(R.id.level1_2_stop);
        complete = (Button) findViewById(R.id.level1_2_complete);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(level1_2.this,popup_stop.class);
                intent.putExtra("tag",11);
                startActivityForResult(intent,11);

            }
        });

        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long end = System.currentTimeMillis();
                long aa = (end - start)/1000;
                globalVariables.setT_time(globalVariables.getT_time() + aa);


                switch (globalVariables.getSetlevel()){
                    case "level1":
                        switch (order){
                            case 2:
                                Intent intent = new Intent(level1_2.this,breaktime.class);
                                intent.putExtra("training_view",11);
                                intent.putExtra("order",3);
                                startActivity(intent);
                                finish();
                                break;
                            case 4:
                                Intent intent2 = new Intent(level1_2.this,breaktime.class);
                                intent2.putExtra("training_view",13);
                                intent2.putExtra("order",5);
                                startActivity(intent2);
                                finish();
                                break;
                            case 5:
                                Intent intent3 = new Intent(level1_2.this,breaktime.class);
                                intent3.putExtra("training_view",14);
                                intent3.putExtra("order",6);
                                startActivity(intent3);
                                finish();
                                break;
                            case 6:
                                Intent intent4 = new Intent(level1_2.this,breaktime.class);
                                intent4.putExtra("training_view",15);
                                intent4.putExtra("order",7);
                                startActivity(intent4);
                                finish();
                                break;
                            case 8:
                                Intent intent5 = new Intent(level1_2.this,breaktime.class);
                                intent5.putExtra("training_view",17);
                                intent5.putExtra("order",9);
                                startActivity(intent5);
                                finish();
                                break;
                            case 9:
                                Intent intent6 = new Intent(level1_2.this,breaktime.class);
                                intent6.putExtra("training_view",18);
                                intent6.putExtra("order",10);
                                startActivity(intent6);
                                finish();
                                break;
                        }
                        break;



                    case "level2":
                        switch (order){
                            case 2:
                                Intent intent2 = new Intent(level1_2.this,breaktime.class);
                                intent2.putExtra("training_view",11);
                                intent2.putExtra("order",3);
                                startActivity(intent2);
                                finish();
                                break;
                            case 3:
                                Intent intent3 = new Intent(level1_2.this,breaktime.class);
                                intent3.putExtra("training_view",12);
                                intent3.putExtra("order",4);
                                startActivity(intent3);
                                finish();
                                break;
                            case 5:
                                Intent intent5 = new Intent(level1_2.this,breaktime.class);
                                intent5.putExtra("training_view",14);
                                intent5.putExtra("order",6);
                                startActivity(intent5);
                                finish();
                                break;
                            case 6:
                                Intent intent6 = new Intent(level1_2.this,breaktime.class);
                                intent6.putExtra("training_view",15);
                                intent6.putExtra("order",7);
                                startActivity(intent6);
                                finish();
                                break;
                            case 7:
                                Intent intent7 = new Intent(level1_2.this,breaktime.class);
                                intent7.putExtra("training_view",16);
                                intent7.putExtra("order",8);
                                startActivity(intent7);
                                finish();
                                break;
                            case 9:
                                Intent intent9 = new Intent(level1_2.this,breaktime.class);
                                intent9.putExtra("training_view",18);
                                intent9.putExtra("order",10);
                                startActivity(intent9);
                                finish();
                                break;
                            case 10:
                                Intent intent10 = new Intent(level1_2.this,breaktime.class);
                                intent10.putExtra("training_view",19);
                                intent10.putExtra("order",11);
                                startActivity(intent10);
                                finish();
                                break;
                        }
                        break;




                    case "level3":
                        switch (order){
                            case 2:
                                Intent intent2 = new Intent(level1_2.this,breaktime.class);
                                intent2.putExtra("training_view",11);
                                intent2.putExtra("order",3);
                                startActivity(intent2);
                                finish();
                                break;
                            case 3:
                                Intent intent3 = new Intent(level1_2.this,breaktime.class);
                                intent3.putExtra("training_view",12);
                                intent3.putExtra("order",4);
                                startActivity(intent3);
                                finish();
                                break;
                            case 4:
                                Intent intent4 = new Intent(level1_2.this,breaktime.class);
                                intent4.putExtra("training_view",13);
                                intent4.putExtra("order",5);
                                startActivity(intent4);
                                finish();
                                break;
                            case 6:
                                Intent intent6 = new Intent(level1_2.this,breaktime.class);
                                intent6.putExtra("training_view",15);
                                intent6.putExtra("order",7);
                                startActivity(intent6);
                                finish();
                                break;
                            case 8:
                                Intent intent8 = new Intent(level1_2.this,breaktime.class);
                                intent8.putExtra("training_view",17);
                                intent8.putExtra("order",9);
                                startActivity(intent8);
                                finish();
                                break;
                            case 9:
                                Intent intent9 = new Intent(level1_2.this,breaktime.class);
                                intent9.putExtra("training_view",18);
                                intent9.putExtra("order",10);
                                startActivity(intent9);
                                finish();
                                break;
                            case 10:
                                Intent intent10 = new Intent(level1_2.this,breaktime.class);
                                intent10.putExtra("training_view",19);
                                intent10.putExtra("order",11);
                                startActivity(intent10);
                                finish();
                                break;
                            case 11:
                                Intent intent11 = new Intent(level1_2.this,breaktime.class);
                                intent11.putExtra("training_view",20);
                                intent11.putExtra("order",12);
                                startActivity(intent11);
                                finish();
                                break;
                            case 13:
                                Intent intent13 = new Intent(level1_2.this,breaktime.class);
                                intent13.putExtra("training_view",22);
                                intent13.putExtra("order",14);
                                startActivity(intent13);
                                finish();
                                break;
                            case 14:
                                Intent intent14 = new Intent(level1_2.this,breaktime.class);
                                intent14.putExtra("training_view",23);
                                intent14.putExtra("order",15);
                                startActivity(intent14);
                                finish();
                                break;
                        }
                        break;
                }

            }
        });

//        Toolbar toolbar = (Toolbar) findViewById(R.id.level1_2_toolbar);
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void openExamplePopup(View v){
        Intent intent = new Intent(level1_2.this,training_example.class);
        intent.putExtra("tag",11);
        intent.putExtra("pos",order-1);
        startActivityForResult(intent,11);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 11){
            if(resultCode == 11){

            }
            if(resultCode == 3000){
                finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}