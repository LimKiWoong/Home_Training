package com.woongs.home_training;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class level1_1 extends AppCompatActivity {

    ImageView imageView;
    Button stop;
    Button skip;

    Handler handler;
    Thread thread;
    TextView name;
    TextView setnumber1;
    TextView setnumber2;
    TextView timesec;

    int seccount = 0;
    boolean going = true;
    int order;
    GlobalVariables globalVariables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1_1);

        globalVariables = new GlobalVariables();

        long start = System.currentTimeMillis();

        imageView = (ImageView) findViewById(R.id.level1_1_image);
        name = (TextView) findViewById(R.id.level1_1_name);
        setnumber1 = (TextView) findViewById(R.id.level1_1_setnumber);
        setnumber2 = (TextView) findViewById(R.id.level1_1_setnumber2);
        stop = (Button) findViewById(R.id.level1_1_stop);
        skip = (Button) findViewById(R.id.level1_1_skip);

        timesec = (TextView) findViewById(R.id.level1_1_timesec);

        Intent intent = getIntent();
        order = intent.getIntExtra("order",0);

        switch (globalVariables.getSetlevel()){
            case "level1":
                setnumber2.setText("10");
                switch (order){
                    case 1:
                        Glide.with(this).load(R.raw.jumpingjack).centerCrop().into(imageView);
                        name.setText("팔벌려뛰기");
                        setnumber1.setText("0"+order);
                        seccount = 20;
                        break;
                    case 3:
                        Glide.with(this).load(R.drawable.plank).centerCrop().into(imageView);
                        name.setText("플랭크");
                        setnumber1.setText("0"+order);
                        seccount = 20;
                        break;
                    case 7:
                        Glide.with(this).load(R.raw.chest_stretching).centerCrop().into(imageView);
                        name.setText("가슴모아 올리기");
                        setnumber1.setText("0"+order);
                        seccount = 30;
                        break;
                    case 10:
                        Glide.with(this).load(R.drawable.cat_stretching).centerCrop().into(imageView);
                        name.setText("마무리");
                        setnumber1.setText(String.valueOf(order));
                        seccount = 30;
                        break;
                }
                break;


            case "level2":
                setnumber2.setText("14");
                switch (order){
                    case 1:
                        Glide.with(this).load(R.raw.jumpingjack).centerCrop().into(imageView);
                        name.setText("팔벌려뛰기");
                        setnumber1.setText("0"+order);
                        seccount = 20;
                        break;
                    case 4:
                        Glide.with(this).load(R.drawable.plank).centerCrop().into(imageView);
                        name.setText("플랭크");
                        setnumber1.setText("0"+order);
                        seccount = 30;
                        break;
                    case 8:
                        Glide.with(this).load(R.raw.chest_stretching).centerCrop().into(imageView);
                        name.setText("가슴모아올리기");
                        setnumber1.setText("0"+order);
                        seccount = 30;
                        break;
                    case 11:
                        Glide.with(this).load(R.raw.skate).centerCrop().into(imageView);
                        name.setText("측면운동");
                        setnumber1.setText(String.valueOf(order));
                        seccount = 30;
                        break;
                    case 12:
                        Glide.with(this).load(R.raw.side_legrase).centerCrop().into(imageView);
                        name.setText("사이드레그레이즈(왼쪽)");
                        setnumber1.setText(String.valueOf(order));
                        seccount = 20;
                        break;
                    case 13:
                        Glide.with(this).load(R.raw.side_legrase).centerCrop().into(imageView);
                        name.setText("사이드레그레이즈(오른쪽)");
                        setnumber1.setText(String.valueOf(order));
                        seccount = 20;
                        break;
                    case 14:
                        Glide.with(this).load(R.drawable.cat_stretching).centerCrop().into(imageView);
                        name.setText("마무리");
                        setnumber1.setText(String.valueOf(order));
                        seccount = 30;
                        break;

                }
                break;



            case "level3":
                setnumber2.setText("18");
                switch (order){
                    case 1:
                        Glide.with(this).load(R.raw.jumpingjack).centerCrop().into(imageView);
                        name.setText("팔벌려뛰기");
                        setnumber1.setText("0"+order);
                        seccount = 30;
                        break;
                    case 5:
                        Glide.with(this).load(R.drawable.plank).centerCrop().into(imageView);
                        name.setText("플랭크");
                        setnumber1.setText("0"+order);
                        seccount = 60;
                        break;
                    case 7:
                        Glide.with(this).load(R.drawable.cobra_stretching).centerCrop().into(imageView);
                        name.setText("코브라스트레칭");
                        setnumber1.setText("0"+order);
                        seccount = 30;
                        break;
                    case 12:
                        Glide.with(this).load(R.raw.chest_stretching).centerCrop().into(imageView);
                        name.setText("가슴모아올리기");
                        setnumber1.setText(String.valueOf(order));
                        seccount = 30;
                        break;
                    case 15:
                        Glide.with(this).load(R.raw.skate).centerCrop().into(imageView);
                        name.setText("측면운동");
                        setnumber1.setText(String.valueOf(order));
                        seccount = 60;
                        break;
                    case 16:
                        Glide.with(this).load(R.raw.side_legrase).centerCrop().into(imageView);
                        name.setText("사이드레그레이즈(왼쪽)");
                        setnumber1.setText(String.valueOf(order));
                        seccount = 30;
                        break;
                    case 17:
                        Glide.with(this).load(R.raw.side_legrase).centerCrop().into(imageView);
                        name.setText("사이드레그레이즈(오른쪽)");
                        setnumber1.setText(String.valueOf(order));
                        seccount = 30;
                        break;
                    case 18:
                        Glide.with(this).load(R.drawable.cat_stretching).centerCrop().into(imageView);
                        name.setText("마무리");
                        setnumber1.setText(String.valueOf(order));
                        seccount = 30;
                        break;

                }
                break;
        }



        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                going = false;
                Intent intent = new Intent(level1_1.this,popup_stop.class);
                intent.putExtra("count",seccount+1);
                intent.putExtra("tag",10);
                startActivityForResult(intent,10);

                handler.removeCallbacksAndMessages(null);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seccount = 0;
            }
        });


//        Toolbar toolbar = (Toolbar) findViewById(R.id.level1_1_toolbar);
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        handler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                if (seccount < 9 ) {
                    timesec.setText("0" + String.valueOf(msg.arg1));
                } else if(seccount >= 9){
                    timesec.setText(String.valueOf(msg.arg1));
                }

                if (Integer.parseInt(timesec.getText().toString()) <= 0 ) {

                    long end = System.currentTimeMillis();
                    long aa = (end - start)/1000;
                    globalVariables.setT_time(globalVariables.getT_time() + aa);

                    switch (globalVariables.getSetlevel()){
                        case "level1":
                            switch (order){
                                case 1:
                                    Intent intent = new Intent(level1_1.this, breaktime.class);
                                    intent.putExtra("order",2);
                                    intent.putExtra("training_view",10);
                                    startActivity(intent);
                                    finish();
                                    break;
                                case 3:
                                    Intent intent2 = new Intent(level1_1.this, breaktime.class);
                                    intent2.putExtra("order",4);
                                    intent2.putExtra("training_view",12);
                                    startActivity(intent2);
                                    finish();
                                    break;
                                case 7:
                                    Intent intent3 = new Intent(level1_1.this, breaktime.class);
                                    intent3.putExtra("order",8);
                                    intent3.putExtra("training_view",16);
                                    startActivity(intent3);
                                    finish();
                                    break;
                                case 10:
                                    Intent intent4 = new Intent(level1_1.this, finish2.class);
                                    startActivity(intent4);
                                    finish();
                                    break;

                            }
                            break;


                        case "level2":
                            switch (order){
                                case 1:
                                    Intent intent = new Intent(level1_1.this, breaktime.class);
                                    intent.putExtra("order",2);
                                    intent.putExtra("training_view",10);
                                    startActivity(intent);
                                    finish();
                                    break;
                                case 4:
                                    Intent intent4 = new Intent(level1_1.this, breaktime.class);
                                    intent4.putExtra("order",5);
                                    intent4.putExtra("training_view",13);
                                    startActivity(intent4);
                                    finish();
                                    break;
                                case 8:
                                    Intent intent8 = new Intent(level1_1.this, breaktime.class);
                                    intent8.putExtra("order",9);
                                    intent8.putExtra("training_view",17);
                                    startActivity(intent8);
                                    finish();
                                    break;
                                case 11:
                                    Intent intent11 = new Intent(level1_1.this, breaktime.class);
                                    intent11.putExtra("order",12);
                                    intent11.putExtra("training_view",20);
                                    startActivity(intent11);
                                    finish();
                                    break;
                                case 12:
                                    Intent intent12 = new Intent(level1_1.this, breaktime.class);
                                    intent12.putExtra("order",13);
                                    intent12.putExtra("training_view",21);
                                    startActivity(intent12);
                                    finish();
                                    break;
                                case 13:
                                    Intent intent13 = new Intent(level1_1.this, breaktime.class);
                                    intent13.putExtra("order",14);
                                    intent13.putExtra("training_view",22);
                                    startActivity(intent13);
                                    finish();
                                    break;
                                case 14:
                                    Intent intent14 = new Intent(level1_1.this, finish2.class);
                                    startActivity(intent14);
                                    finish();
                                    break;
                            }
                            break;




                        case "level3":
                            switch (order){
                                case 1:
                                    Intent intent = new Intent(level1_1.this, breaktime.class);
                                    intent.putExtra("order",2);
                                    intent.putExtra("training_view",10);
                                    startActivity(intent);
                                    finish();
                                    break;
                                case 5:
                                    Intent intent4 = new Intent(level1_1.this, breaktime.class);
                                    intent4.putExtra("order",6);
                                    intent4.putExtra("training_view",14);
                                    startActivity(intent4);
                                    finish();
                                    break;
                                case 7:
                                    Intent intent8 = new Intent(level1_1.this, breaktime.class);
                                    intent8.putExtra("order",8);
                                    intent8.putExtra("training_view",16);
                                    startActivity(intent8);
                                    finish();
                                    break;
                                case 12:
                                    Intent intent11 = new Intent(level1_1.this, breaktime.class);
                                    intent11.putExtra("order",13);
                                    intent11.putExtra("training_view",21);
                                    startActivity(intent11);
                                    finish();
                                    break;
                                case 15:
                                    Intent intent12 = new Intent(level1_1.this, breaktime.class);
                                    intent12.putExtra("order",16);
                                    intent12.putExtra("training_view",24);
                                    startActivity(intent12);
                                    finish();
                                    break;
                                case 16:
                                    Intent intent13 = new Intent(level1_1.this, breaktime.class);
                                    intent13.putExtra("order",17);
                                    intent13.putExtra("training_view",25);
                                    startActivity(intent13);
                                    finish();
                                    break;
                                case 17:
                                    Intent intent14 = new Intent(level1_1.this, breaktime.class);
                                    intent14.putExtra("order",18);
                                    intent14.putExtra("training_view",26);
                                    startActivity(intent14);
                                    finish();
                                    break;
                                case 18:
                                    Intent intent15 = new Intent(level1_1.this, finish2.class);
                                    startActivity(intent15);
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
                while (going) {
                    Message msg = handler.obtainMessage();
                    msg.arg1 = seccount;
                    handler.sendMessage(msg);

                    seccount = seccount -1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(seccount <= -1 ){
                        going = false;
                    }
                }
            }
        });thread.start();
    }

    public void openExamplePopup(View v){
        going = false;
        Intent intent = new Intent(level1_1.this,training_example.class);
        intent.putExtra("count",seccount+1);
        intent.putExtra("tag",10);
        intent.putExtra("pos",order-1);
        startActivityForResult(intent,10);

        handler.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10) {
            if (resultCode == 10) {

                seccount = data.getIntExtra("getcount", 1);
                going = true;
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (going) {
                            Message msg = handler.obtainMessage();
                            msg.arg1 = seccount;
                            handler.sendMessage(msg);

                            seccount = seccount - 1;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (seccount <= -1) {
                                going = false;
                            }
                        }
                    }
                });
                thread.start();
                }
                if (resultCode == 3000) {
                    going = false;
                    finish();
                }
            }
        }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}