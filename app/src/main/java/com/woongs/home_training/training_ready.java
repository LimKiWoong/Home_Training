package com.woongs.home_training;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
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

public class training_ready extends AppCompatActivity{

    ImageView imageView;
    TextView training_name1;
    Button popup_example;

    RadioGroup frag02_radiogroup;
    //ListView listView;
    //Frag02_ListViewAdapter adapter;
    int pos;
    GlobalVariables globalVariables = new GlobalVariables();
    NestedScrollView nestedScrollView;

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ArrayList<Frag02_ListItem> items =new ArrayList<Frag02_ListItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_ready);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerAdapter = new RecyclerAdapter(items);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerDecoration heightspaceDecoration = new RecyclerDecoration(10);
        recyclerView.addItemDecoration(heightspaceDecoration);

        nestedScrollView = (NestedScrollView) findViewById(R.id.nested);
        nestedScrollView.setNestedScrollingEnabled(true);

        imageView = (ImageView) findViewById(R.id.frag02_imageview);
        training_name1 = (TextView) findViewById(R.id.training_name1);
        ImageView imageView = (ImageView) findViewById(R.id.frag02_imageview);

        switch (globalVariables.getImage()){
            case 1:
                Glide.with(this).load(R.drawable.plank).centerCrop().into(imageView);
                training_name1.setText("플랭크");
                break;
        }

        popup_example = (Button) findViewById(R.id.popup_example);

        //listView = (ListView) findViewById(R.id.frag02_listview);
        //adapter = new Frag02_ListViewAdapter();

        frag02_radiogroup = (RadioGroup) findViewById(R.id.frag02_radiogroup);
        RadioButton frag02_radiobtn01 = (RadioButton) findViewById(R.id.frag02_radiobtn01);
        RadioButton frag02_radiobtn02 = (RadioButton) findViewById(R.id.frag02_radiobtn02);
        RadioButton frag02_radiobtn03 = (RadioButton) findViewById(R.id.frag02_radiobtn03);
        RadioButton frag02_radiobtn04 = (RadioButton) findViewById(R.id.frag02_radiobtn04);
        RadioButton frag02_radiobtn05 = (RadioButton) findViewById(R.id.frag02_radiobtn05);

//            listView.setAdapter(adapter);
            //adapter.notifyDataSetChanged();


        frag02_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group == frag02_radiogroup){
                    if(checkedId == R.id.frag02_radiobtn01){
                        globalVariables.setRadionum(1);
                        recyclerAdapter.recycleritem.clear();
                        recyclerView.setAdapter(recyclerAdapter);
                        recyclerAdapter.addItem(new Frag02_ListItem("1","00","30"));
                        recyclerAdapter.notifyDataSetChanged();
                    }
                    if(checkedId == R.id.frag02_radiobtn02){
                        globalVariables.setRadionum(2);
                        recyclerAdapter.recycleritem.clear();
                        recyclerView.setAdapter(recyclerAdapter);
                        recyclerAdapter.addItem(new Frag02_ListItem("1","00","30"));
                        recyclerAdapter.addItem(new Frag02_ListItem("2","00","30"));
                        recyclerAdapter.notifyDataSetChanged();
                    }
                    if(checkedId == R.id.frag02_radiobtn03){
                        globalVariables.setRadionum(3);
                        recyclerAdapter.recycleritem.clear();
                        recyclerView.setAdapter(recyclerAdapter);
                        recyclerAdapter.addItem(new Frag02_ListItem("1","00","30"));
                        recyclerAdapter.addItem(new Frag02_ListItem("2","00","30"));
                        recyclerAdapter.addItem(new Frag02_ListItem("3","00","30"));
                        recyclerAdapter.notifyDataSetChanged();
                    }
                    if(checkedId == R.id.frag02_radiobtn04){
                        globalVariables.setRadionum(4);
                        recyclerAdapter.recycleritem.clear();
                        recyclerView.setAdapter(recyclerAdapter);
                        recyclerAdapter.addItem(new Frag02_ListItem("1","00","30"));
                        recyclerAdapter.addItem(new Frag02_ListItem("2","00","30"));
                        recyclerAdapter.addItem(new Frag02_ListItem("3","00","30"));
                        recyclerAdapter.addItem(new Frag02_ListItem("4","00","30"));
                        recyclerAdapter.notifyDataSetChanged();
                    }
                    if(checkedId == R.id.frag02_radiobtn05){
                        globalVariables.setRadionum(5);
                        recyclerAdapter.recycleritem.clear();
                        recyclerView.setAdapter(recyclerAdapter);
                        recyclerAdapter.addItem(new Frag02_ListItem("1","00","30"));
                        recyclerAdapter.addItem(new Frag02_ListItem("2","00","30"));
                        recyclerAdapter.addItem(new Frag02_ListItem("3","00","30"));
                        recyclerAdapter.addItem(new Frag02_ListItem("4","00","30"));
                        recyclerAdapter.addItem(new Frag02_ListItem("5","00","30"));
                        recyclerAdapter.notifyDataSetChanged();
                    }
                }
            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.frag02_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button start = (Button) findViewById(R.id.frag02_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date currenttime = Calendar.getInstance().getTime();
                String date_text = new SimpleDateFormat("MM월 dd일 HH:mm", Locale.getDefault()).format(currenttime);
                globalVariables.setDatetime(date_text);

                switch (frag02_radiogroup.getCheckedRadioButtonId()){
                    case R.id.frag02_radiobtn01 :
                        Intent intent1 = new Intent(training_ready.this,five_seconds.class);
                        intent1.putExtra("5seconds",1);
                        globalVariables.setSetnumber1(Integer.parseInt("1"));
                        globalVariables.setSetnumber2(Integer.parseInt("1"));


                        if(recyclerAdapter.recycleritem.get(0).getMin().isEmpty()){
                            globalVariables.setPos1_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos1_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(0).getMin()));
                        }
                        globalVariables.setPos1_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(0).getSec()));
                        startActivity(intent1);
                        finish();
                        break;
//--------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------

                    case R.id.frag02_radiobtn02 :
                        Intent intent2 = new Intent(training_ready.this,five_seconds.class);
                        intent2.putExtra("5seconds",1);
                        globalVariables.setSetnumber1(Integer.parseInt("1"));
                        globalVariables.setSetnumber2(Integer.parseInt("2"));


                        if(recyclerAdapter.recycleritem.get(0).getMin().isEmpty()){
                            globalVariables.setPos1_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos1_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(0).getMin()));
                        }
                        globalVariables.setPos1_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(0).getSec()));


                        if(recyclerAdapter.recycleritem.get(1).getMin().isEmpty()){
                            globalVariables.setPos2_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos2_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(1).getMin()));
                        }
                        globalVariables.setPos2_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(1).getSec()));
                        startActivity(intent2);
                        finish();
                        break;

//--------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------

                    case R.id.frag02_radiobtn03 :
                        Intent intent3 = new Intent(training_ready.this,five_seconds.class);
                        intent3.putExtra("5seconds",1);
                        globalVariables.setSetnumber1(Integer.parseInt("1"));
                        globalVariables.setSetnumber2(Integer.parseInt("3"));


                        if(recyclerAdapter.recycleritem.get(0).getMin().isEmpty()){
                            globalVariables.setPos1_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos1_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(0).getMin()));
                        }
                        globalVariables.setPos1_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(0).getSec()));



                        if(recyclerAdapter.recycleritem.get(1).getMin().isEmpty()){
                            globalVariables.setPos2_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos2_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(1).getMin()));
                        }
                        globalVariables.setPos2_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(1).getSec()));


                        if(recyclerAdapter.recycleritem.get(2).getMin().isEmpty()){
                            globalVariables.setPos3_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos3_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(2).getMin()));
                        }
                        globalVariables.setPos3_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(2).getSec()));
                        startActivity(intent3);
                        finish();
                        break;
//--------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------

                    case R.id.frag02_radiobtn04 :
                        Intent intent4 = new Intent(training_ready.this,five_seconds.class);
                        intent4.putExtra("5seconds",1);
                        globalVariables.setSetnumber1(Integer.parseInt("1"));
                        globalVariables.setSetnumber2(Integer.parseInt("4"));


                        if(recyclerAdapter.recycleritem.get(0).getMin().isEmpty()){
                            globalVariables.setPos1_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos1_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(0).getMin()));
                        }
                        globalVariables.setPos1_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(0).getSec()));


                        if(recyclerAdapter.recycleritem.get(1).getMin().isEmpty()){
                            globalVariables.setPos2_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos2_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(1).getMin()));
                        }
                        globalVariables.setPos2_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(1).getSec()));


                        if(recyclerAdapter.recycleritem.get(2).getMin().isEmpty()){
                            globalVariables.setPos3_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos3_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(2).getMin()));
                        }
                        globalVariables.setPos3_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(2).getSec()));


                        if(recyclerAdapter.recycleritem.get(3).getMin().isEmpty()){
                            globalVariables.setPos4_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos4_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(3).getMin()));
                        }
                        globalVariables.setPos4_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(3).getSec()));
                        startActivity(intent4);
                        finish();
                        break;
//--------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------

                    case R.id.frag02_radiobtn05 :
                        Intent intent5 = new Intent(training_ready.this,five_seconds.class);
                        intent5.putExtra("5seconds",1);
                        globalVariables.setSetnumber1(Integer.parseInt("1"));
                        globalVariables.setSetnumber2(Integer.parseInt("5"));

                        if(recyclerAdapter.recycleritem.get(0).getMin().isEmpty()){
                            globalVariables.setPos1_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos1_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(0).getMin()));
                        }
                        globalVariables.setPos1_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(0).getSec()));


                        if(recyclerAdapter.recycleritem.get(1).getMin().isEmpty()){
                            globalVariables.setPos2_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos2_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(1).getMin()));
                        }
                        globalVariables.setPos2_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(1).getSec()));


                        if(recyclerAdapter.recycleritem.get(2).getMin().isEmpty()){
                            globalVariables.setPos3_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos3_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(2).getMin()));
                        }
                        globalVariables.setPos3_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(2).getSec()));


                        if(recyclerAdapter.recycleritem.get(3).getMin().isEmpty()){
                            globalVariables.setPos4_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos4_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(3).getMin()));
                        }
                        globalVariables.setPos4_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(3).getSec()));


                        if(recyclerAdapter.recycleritem.get(4).getMin().isEmpty()){
                            globalVariables.setPos5_min_time(Integer.parseInt("00"));
                        }else {
                            globalVariables.setPos5_min_time(Integer.parseInt(recyclerAdapter.recycleritem.get(4).getMin()));
                        }
                        globalVariables.setPos5_sec_time(Integer.parseInt(recyclerAdapter.recycleritem.get(4).getSec()));
                        startActivity(intent5);
                        finish();
                        break;
                    default:
                        Toast.makeText(training_ready.this, "세트를선택해주십시오", Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(training_ready.this,training_example.class);
        startActivity(intent);
    }



}