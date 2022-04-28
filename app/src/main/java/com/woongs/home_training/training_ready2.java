package com.woongs.home_training;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class training_ready2 extends AppCompatActivity {

    ImageView imageView;
    TextView training_name2;
    Button start;

    RadioGroup ready2_radiogroup;
    int pos;
    GlobalVariables globalVariables = new GlobalVariables();
    NestedScrollView nestedScrollView;

    RecyclerView recyclerView2;
    RecyclerAdapter2 recyclerAdapter2;
    ArrayList<ready2_listitem> items = new ArrayList<ready2_listitem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_ready2);

        recyclerView2 = findViewById(R.id.ready2_recyclerview);
        recyclerAdapter2 = new RecyclerAdapter2(items);
        recyclerView2.setAdapter(recyclerAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        RecyclerDecoration heightspaceDecoration = new RecyclerDecoration(10);
        recyclerView2.addItemDecoration(heightspaceDecoration);

        imageView = (ImageView) findViewById(R.id.ready2_imageview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.ready2_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nestedScrollView = (NestedScrollView) findViewById(R.id.nested2);
        nestedScrollView.setNestedScrollingEnabled(true);

        training_name2 = (TextView) findViewById(R.id.training_name2);
        start = (Button) findViewById(R.id.ready2_start);

        switch (globalVariables.getImage()){
            case 2:
                Glide.with(this).load(R.raw.crunch).centerCrop().into(imageView);
                training_name2.setText("크런치");
                break;
            case 3:
                Glide.with(this).load(R.raw.mountain_climer).centerCrop().into(imageView);
                training_name2.setText("마운틴 클라이머");
                break;
            case 4:
                Glide.with(this).load(R.raw.bicycle_maneuver).centerCrop().into(imageView);
                training_name2.setText("바이시클 메뉴버");
                break;
            case 5:
                Glide.with(this).load(R.raw.pushup).centerCrop().into(imageView);
                training_name2.setText("팔굽혀펴기");
                break;
            case 6:
                Glide.with(this).load(R.raw.singleleg_pushup).centerCrop().into(imageView);
                training_name2.setText("싱글레그푸쉬업");
                break;
            case 7:
                Glide.with(this).load(R.raw.incline_pushup).centerCrop().into(imageView);
                training_name2.setText("인클라인푸쉬업");
                break;
            case 8:
                Glide.with(this).load(R.raw.decline_pushup).centerCrop().into(imageView);
                training_name2.setText("디클라인푸쉬업");
                break;
            case 9:
                Glide.with(this).load(R.raw.lying_extension).centerCrop().into(imageView);
                training_name2.setText("라잉익스텐션");
                break;
            case 10:
                Glide.with(this).load(R.raw.kickback).centerCrop().into(imageView);
                training_name2.setText("킥백");
                break;
            case 11:
                Glide.with(this).load(R.raw.deeps).centerCrop().into(imageView);
                training_name2.setText("딥스");
                break;
            case 12:
                Glide.with(this).load(R.raw.dumbellcurl).centerCrop().into(imageView);
                training_name2.setText("덤벨컬");
                break;
            case 13:
                Glide.with(this).load(R.raw.squat).centerCrop().into(imageView);
                training_name2.setText("스쿼트");
                break;
            case 14:
                Glide.with(this).load(R.raw.runge).centerCrop().into(imageView);
                training_name2.setText("런지");
                break;
            case 15:
                Glide.with(this).load(R.raw.skate).centerCrop().into(imageView);
                training_name2.setText("측면운동");
                break;
            case 16:
                Glide.with(this).load(R.raw.side_legrase).centerCrop().into(imageView);
                training_name2.setText("사이드레그레이즈");
                break;
            default:
                return;
        }

        ready2_radiogroup = (RadioGroup) findViewById(R.id.ready2_radiogroup);
        ready2_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (group == ready2_radiogroup){
                    if(checkedId == R.id.ready2_radiobtn01){
                        globalVariables.setRadionum(1);
                        recyclerAdapter2.recycleritem2.clear();
                        recyclerView2.setAdapter(recyclerAdapter2);
                        recyclerAdapter2.addItem(new ready2_listitem("1","16"));
                        recyclerAdapter2.notifyDataSetChanged();
                    }

                    if(checkedId == R.id.ready2_radiobtn02){
                        globalVariables.setRadionum(2);
                        recyclerAdapter2.recycleritem2.clear();
                        recyclerView2.setAdapter(recyclerAdapter2);
                        recyclerAdapter2.addItem(new ready2_listitem("1","16"));
                        recyclerAdapter2.addItem(new ready2_listitem("2","16"));
                        recyclerAdapter2.notifyDataSetChanged();
                    }

                    if(checkedId == R.id.ready2_radiobtn03){
                        globalVariables.setRadionum(3);
                        recyclerAdapter2.recycleritem2.clear();
                        recyclerView2.setAdapter(recyclerAdapter2);
                        recyclerAdapter2.addItem(new ready2_listitem("1","16"));
                        recyclerAdapter2.addItem(new ready2_listitem("2","16"));
                        recyclerAdapter2.addItem(new ready2_listitem("3","16"));
                        recyclerAdapter2.notifyDataSetChanged();
                    }

                    if(checkedId == R.id.ready2_radiobtn04){
                        globalVariables.setRadionum(4);
                        recyclerAdapter2.recycleritem2.clear();
                        recyclerView2.setAdapter(recyclerAdapter2);
                        recyclerAdapter2.addItem(new ready2_listitem("1","16"));
                        recyclerAdapter2.addItem(new ready2_listitem("2","16"));
                        recyclerAdapter2.addItem(new ready2_listitem("3","16"));
                        recyclerAdapter2.addItem(new ready2_listitem("4","16"));
                        recyclerAdapter2.notifyDataSetChanged();
                    }

                    if(checkedId == R.id.ready2_radiobtn05){
                        globalVariables.setRadionum(5);
                        recyclerAdapter2.recycleritem2.clear();
                        recyclerView2.setAdapter(recyclerAdapter2);
                        recyclerAdapter2.addItem(new ready2_listitem("1","16"));
                        recyclerAdapter2.addItem(new ready2_listitem("2","16"));
                        recyclerAdapter2.addItem(new ready2_listitem("3","16"));
                        recyclerAdapter2.addItem(new ready2_listitem("4","16"));
                        recyclerAdapter2.addItem(new ready2_listitem("5","16"));
                        recyclerAdapter2.notifyDataSetChanged();
                    }
                }
            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date currenttime = Calendar.getInstance().getTime();
                String date_text = new SimpleDateFormat("MM월 dd일 HH:mm", Locale.getDefault()).format(currenttime);
                globalVariables.setDatetime(date_text);

                switch (ready2_radiogroup.getCheckedRadioButtonId()){
                    case R.id.ready2_radiobtn01:
                        Intent intent = new Intent(training_ready2.this,five_seconds.class);
                        intent.putExtra("5seconds",2);
                        globalVariables.setSetnumber1(Integer.parseInt("1"));
                        globalVariables.setSetnumber2(Integer.parseInt("1"));
                        globalVariables.setPos1_count(recyclerAdapter2.recycleritem2.get(0).getCount());
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.ready2_radiobtn02:
                        Intent intent2 = new Intent(training_ready2.this,five_seconds.class);
                        intent2.putExtra("5seconds",2);
                        globalVariables.setSetnumber1(Integer.parseInt("1"));
                        globalVariables.setSetnumber2(Integer.parseInt("2"));
                        globalVariables.setPos1_count(recyclerAdapter2.recycleritem2.get(0).getCount());
                        globalVariables.setPos2_count(recyclerAdapter2.recycleritem2.get(1).getCount());
                        startActivity(intent2);
                        finish();
                        break;
                    case R.id.ready2_radiobtn03:
                        Intent intent3 = new Intent(training_ready2.this,five_seconds.class);
                        intent3.putExtra("5seconds",2);
                        globalVariables.setSetnumber1(Integer.parseInt("1"));
                        globalVariables.setSetnumber2(Integer.parseInt("3"));
                        globalVariables.setPos1_count(recyclerAdapter2.recycleritem2.get(0).getCount());
                        globalVariables.setPos2_count(recyclerAdapter2.recycleritem2.get(1).getCount());
                        globalVariables.setPos3_count(recyclerAdapter2.recycleritem2.get(2).getCount());
                        startActivity(intent3);
                        finish();
                        break;
                    case R.id.ready2_radiobtn04:
                        Intent intent4 = new Intent(training_ready2.this,five_seconds.class);
                        intent4.putExtra("5seconds",2);
                        globalVariables.setSetnumber1(Integer.parseInt("1"));
                        globalVariables.setSetnumber2(Integer.parseInt("4"));
                        globalVariables.setPos1_count(recyclerAdapter2.recycleritem2.get(0).getCount());
                        globalVariables.setPos2_count(recyclerAdapter2.recycleritem2.get(1).getCount());
                        globalVariables.setPos3_count(recyclerAdapter2.recycleritem2.get(2).getCount());
                        globalVariables.setPos4_count(recyclerAdapter2.recycleritem2.get(3).getCount());
                        startActivity(intent4);
                        finish();
                        break;
                    case R.id.ready2_radiobtn05:
                        Intent intent5 = new Intent(training_ready2.this,five_seconds.class);
                        intent5.putExtra("5seconds",2);
                        globalVariables.setSetnumber1(Integer.parseInt("1"));
                        globalVariables.setSetnumber2(Integer.parseInt("5"));
                        globalVariables.setPos1_count(recyclerAdapter2.recycleritem2.get(0).getCount());
                        globalVariables.setPos2_count(recyclerAdapter2.recycleritem2.get(1).getCount());
                        globalVariables.setPos3_count(recyclerAdapter2.recycleritem2.get(2).getCount());
                        globalVariables.setPos4_count(recyclerAdapter2.recycleritem2.get(3).getCount());
                        globalVariables.setPos5_count(recyclerAdapter2.recycleritem2.get(4).getCount());
                        startActivity(intent5);
                        finish();
                        break;
                    default:
                        Toast.makeText(training_ready2.this, "세트를선택해주십시오", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openExamplePopup(View v){
        Intent intent = new Intent(training_ready2.this,training_example.class);
        intent.putExtra("tag",2);
        startActivity(intent);
    }
}