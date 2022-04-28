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

public class finish1 extends AppCompatActivity {

    TextView finish_set;
    TextView finish_time_sec;
    TextView finish_time_min;
    Button finish_backhome;
    Button finish_record;
    GlobalVariables globalVariables = new GlobalVariables();
    int sum_sec;
    int a = 0;
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
        setContentView(R.layout.activity_finish1);


        ImageView finish = (ImageView) findViewById(R.id.finish_img);
        Glide.with(this).load(R.raw.finish).into(finish);

        finish_set = (TextView) findViewById(R.id.finish_set);
        finish_time_min = (TextView) findViewById(R.id.finish_time_min);
        finish_time_sec = (TextView) findViewById(R.id.finish_time_sec);


        finish_set.setText(String.valueOf(globalVariables.getSetnumber2()));


        double aa = globalVariables.getT_time();
        String tt = String.format("%.0f",aa);
        int it = Integer.valueOf(tt);
        if(it >= 60){
            int a = it / 60;
            finish_time_min.setText(String.valueOf(a));
            finish_time_sec.setText(String.valueOf(it - (60*a)));
        } else if (it < 60){
            finish_time_min.setText("0");
            finish_time_sec.setText(String.valueOf(it));
        }



        finish_backhome = (Button) findViewById(R.id.finish_backhome);
        finish_record = (Button) findViewById(R.id.finish_record);

        switch (globalVariables.getImage()){
            case 1:
                tname = "플랭크";
                break;
            case 2:
                tname = "크런치";
                break;
            case 3:
                tname = "마운틴클라이머";
                break;
            case 4:
                tname = "바이시클메뉴버";
                break;
            case 5:
                tname = "팔굽혀펴기";
                break;
            case 6:
                tname = "싱글레그푸쉬업";
                break;
            case 7:
                tname = "인클라인푸쉬업";
                break;
            case 8:
                tname = "디클라인푸쉬업";
                break;
            case 9:
                tname = "라잉익스텐션";
                break;
            case 10:
                tname = "킥백";
                break;
            case 11:
                tname = "딥스";
                break;
            case 12:
                tname = "덤벨컬";
                break;
            case 13:
                tname = "스쿼트";
                break;
            case 14:
                tname = "런지";
                break;
            case 15:
                tname = "측면운동";
                break;
            case 16:
                tname = "사이드레그레이즈";
                break;
        }
        dbtime = (finish_time_min.getText().toString() + "분" +
                finish_time_sec.getText().toString() + "초");

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

        //Toast.makeText(finish1.this, datetime + "\n" + tname + "\n" + dbtime, Toast.LENGTH_LONG).show();



        resetData();

        finish_backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(finish1.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        finish_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(finish1.this,record.class);
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

        globalVariables.setT_time(0);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}