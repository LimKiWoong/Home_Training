package com.woongs.home_training;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

public class record extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase ReadDB;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> item = null;
    ListAdapter adapter;

    private final String dbName = "record";
    private final String tableName = "items";

    private static final String TAG_DATE = "date";
    private static final String TAG_name = "name";
    private static final String TAG_time = "time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        listView = (ListView) findViewById(R.id.record_listview);

        showlist();

    }

    protected void showlist(){
        try {

            ReadDB = openOrCreateDatabase(dbName, MODE_PRIVATE, null);

            Cursor cursor = ReadDB.rawQuery("SELECT * FROM "+tableName, null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        String Date = cursor.getString(cursor.getColumnIndex("date"));
                        String Name = cursor.getString(cursor.getColumnIndex("name"));
                        String Time = cursor.getString(cursor.getColumnIndex("time"));

                        item = new HashMap<String, String>();
                        item.put(TAG_DATE, Date);
                        item.put(TAG_name, Name);
                        item.put(TAG_time, Time);
                        arrayList.add(item);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            ReadDB.close();

            adapter = new SimpleAdapter(
                    this, arrayList, R.layout.record_listview,
                    new String[]{"date", "name", "time"},
                    new int[]{R.id.record_date, R.id.record_name, R.id.record_time}
            );

            listView.setAdapter(adapter);
        } catch (SQLiteException e){
            Toast.makeText(getApplicationContext(),  e.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("",e.getMessage());
        }
    }
}