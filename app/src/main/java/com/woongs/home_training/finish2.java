package com.woongs.home_training;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;

public class finish2 extends AppCompatActivity {

    TextView finish2_itemcount;
    TextView finish2_level;
    Button finish_backhome;
    Button finish_record;
    TextView finish2_time_min;
    TextView finish2_time_sec;
    GlobalVariables globalVariables = new GlobalVariables();

    String tname;
    String dbtime;

    private final String dbName = "record";
    private final String tableName = "items";

    private static final String TAG_DATE = "date";
    private static final String TAG_name = "name";
    private static final String TAG_time = "time";
    SQLiteDatabase database = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish2);

        ImageView finish = (ImageView) findViewById(R.id.finish_img2);
        Glide.with(this).load(R.raw.finish).into(finish);

        finish2_level = (TextView) findViewById(R.id.finish2_level);
        finish2_itemcount = (TextView) findViewById(R.id.finish2_itemcount);
        finish2_time_min = (TextView) findViewById(R.id.finish2_time_min);
        finish2_time_sec = (TextView) findViewById(R.id.finish2_time_sec);

        double aa = globalVariables.getT_time();
        String tt = String.format("%.0f",aa);
        int it = Integer.valueOf(tt);
        if(it >= 60){
            int a = it / 60;
            finish2_time_min.setText(String.valueOf(a));
            finish2_time_sec.setText(String.valueOf(it - (60*a)));
        } else if (it < 60){
            finish2_time_min.setText("0");
            finish2_time_sec.setText(String.valueOf(it));
        }

        switch (globalVariables.getSetlevel()){
            case "level1":
                finish2_level.setText("초급");
                finish2_itemcount.setText("10");
                break;
            case "level2":
                finish2_level.setText("중급");
                finish2_itemcount.setText("14");
                break;
            case "level3":
                finish2_level.setText("상급");
                finish2_itemcount.setText("18");
                break;
        }

        switch (globalVariables.getImage()){
            case 100:
                tname = "초급";
                break;
            case 101:
                tname = "중급";
                break;
            case 102:
                tname = "상급";
                break;
        }
        dbtime = (finish2_time_min.getText().toString() + "분" +
                finish2_time_sec.getText().toString() + "초");

        String datetime = globalVariables.getDatetime();

        try {
            database = openOrCreateDatabase(dbName,MODE_PRIVATE,null);

            database.execSQL("CREATE TABLE IF NOT EXISTS " + tableName
                    + " (date VARCHAR(20), name VARCHAR(20) , time VARCHAR(20) );");

            //database.execSQL("DELETE FROM "+tableName);

            database.execSQL("INSERT INTO "+tableName+" (date,name,time) VALUES ("+"'"+datetime+"',"+"'"+tname+"',"+"'"+dbtime+"'"+");");

            database.close();

        } catch (SQLiteException e){
            Log.e("",e.getMessage());
        }

        //Toast.makeText(finish2.this, datetime + "\n" + tname + "\n" + dbtime, Toast.LENGTH_LONG).show();



        finish_backhome = (Button) findViewById(R.id.finish_backhome2);
        finish_record = (Button) findViewById(R.id.finish_record2);



        resetData();

        finish_backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(finish2.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        finish_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(finish2.this,record.class);
                startActivity(intent2);
                finish();
            }
        });
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

        globalVariables.setSetlevel("0");
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}