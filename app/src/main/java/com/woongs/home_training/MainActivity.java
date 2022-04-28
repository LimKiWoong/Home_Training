package com.woongs.home_training;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    public NavigationView navigationView;
    public DrawerLayout drawerLayout;
    public View drawerView;
    public TabLayout tabLayout;
    public ViewPager viewPager;
    public FragmentPagerAdapter mFragmentPagerAdapter;
    public Context context;
    Button bmi_input;
    TextView bmi_shownumber;
    GlobalVariables globalVariables = new GlobalVariables();
    ProgressBar progressBar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    AppBarLayout appBarLayout;

    SQLiteDatabase ReadDB;
    private final String dbName = "record";
    private final String tableName = "items";
    private static final String TAG_DATE = "date";
    int summin =0,sumsec =0;
    String summin1,sumsec1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todaydata();
        yesterdaydata();
        globalVariables.setT_time(0);

        //Toast.makeText(MainActivity.this, summin1+"분"+sumsec1+"초", Toast.LENGTH_SHORT).show();

        bmi_input = (Button) findViewById(R.id.bmi_input);
        bmi_shownumber = (TextView) findViewById(R.id.bmi_shownumber);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collaping);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(scrollRange == -1){
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if(scrollRange + verticalOffset <= 130){
                    collapsingToolbarLayout.setTitle("즐겁게홈트레이닝");
                    isShow = true;
                } else if(isShow){
                    collapsingToolbarLayout.setTitle(" ");
                    isShow = false;
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_hamburger2);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigationview);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,R.string.nav_app_bar_open_drawer_description,R.string.nav_app_bar_navigate_up_description);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_record:
                        Intent intent1 = new Intent(MainActivity.this,record.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_option:
                        Intent intent2 = new Intent(MainActivity.this,option.class);
                        startActivity(intent2);
                        break;
                }

                //item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("홈"));
        tabLayout.addTab(tabLayout.newTab().setText("단일"));
        tabLayout.addTab(tabLayout.newTab().setText("종합"));

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(mFragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                //탭이선택되었을떄호출
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //탭이선택되지않았을때호출
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //탭이다시선택되었을때호출
            }
        });


        progressBar = (ProgressBar) findViewById(R.id.progressbar);




    }


    protected void todaydata() {
        summin = 0;
        sumsec = 0;
        summin1 = "0";
        sumsec1 = "0";
        try {
            Date currenttime = Calendar.getInstance().getTime();
            String today = new SimpleDateFormat("MM월 dd일", Locale.getDefault()).format(currenttime);

            ReadDB = openOrCreateDatabase(dbName, MODE_PRIVATE, null);

            ReadDB.execSQL("CREATE TABLE IF NOT EXISTS " + tableName
                    + " (date VARCHAR(20), name VARCHAR(20) , time VARCHAR(20) );");

            Cursor cursor = ReadDB.rawQuery("SELECT * FROM "+tableName+ " where date like '"+today+"%'", null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        String time = cursor.getString(cursor.getColumnIndex("time"));
                        int idx = time.indexOf("분");
                        int idx2 = time.indexOf("초");
                        String min = time.substring(0,idx);
                        String sec = time.substring(idx+1,idx2);
                        int min1 = Integer.parseInt(min);
                        int sec1 = Integer.parseInt(sec);
                        summin += min1;
                        sumsec += sec1;
                        String a = String.valueOf(summin);
                        String b = String.valueOf(sumsec);
                    } while (cursor.moveToNext());
                }
            }
            if(sumsec >= 60){
                int getmin = sumsec / 60;

                sumsec = sumsec - getmin*60;
                summin = summin + getmin;
            }else{

            }
            summin1 = String.valueOf(summin);
            sumsec1 = String.valueOf(sumsec);

            globalVariables.setTodaymin(summin1);
            globalVariables.setTodaysec(sumsec1);

            cursor.close();
            ReadDB.close();

        } catch (SQLiteException e){
            Toast.makeText(getApplicationContext(),  e.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("",e.getMessage());
        }
    }

    protected void yesterdaydata() {
        summin = 0;
        sumsec = 0;
        summin1 = "0";
        sumsec1 = "0";
        try {
            SimpleDateFormat date = new SimpleDateFormat("MM월 dd일");
            Calendar calendar = Calendar.getInstance();
            calendar.add(calendar.DATE,-1);
            String yesterday = date.format(calendar.getTime());

            ReadDB = openOrCreateDatabase(dbName, MODE_PRIVATE, null);

            Cursor cursor = ReadDB.rawQuery("SELECT * FROM "+tableName+ " where date like '"+yesterday+"%'", null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        String time = cursor.getString(cursor.getColumnIndex("time"));
                        int idx = time.indexOf("분");
                        int idx2 = time.indexOf("초");
                        String min = time.substring(0,idx);
                        String sec = time.substring(idx+1,idx2);
                        int min1 = Integer.parseInt(min);
                        int sec1 = Integer.parseInt(sec);
                        summin += min1;
                        sumsec += sec1;
                        String a = String.valueOf(summin);
                        String b = String.valueOf(sumsec);
                    } while (cursor.moveToNext());
                }
            }
            if(sumsec >= 60){
                int getmin = sumsec / 60;

                sumsec = sumsec - getmin*60;
                summin = summin + getmin;
            }else{

            }
            summin1 = String.valueOf(summin);
            sumsec1 = String.valueOf(sumsec);

            globalVariables.setYesterdaymin(summin1);
            globalVariables.setYesterdaysec(sumsec1);

            cursor.close();
            ReadDB.close();

        } catch (SQLiteException e){
            Toast.makeText(getApplicationContext(),  e.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("",e.getMessage());
        }
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openBmiPopup(View v){
        Intent intent = new Intent(this,Popup_bmi.class);
        intent.putExtra("bmi_number",R.id.bmi_shownumber);
        startActivityForResult(intent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if(resultCode == 1500){
                return;
            }
            if (resultCode == 2000) {
                Double number = data.getDoubleExtra("bmi_number",0.0);
                String status = data.getStringExtra("status_");
                bmi_shownumber = (TextView) findViewById(R.id.bmi_shownumber);
                bmi_shownumber.setText(String.valueOf(number));
            }
        }

    }

    public void onImageClick(View view){
        switch (view.getId()){
            case R.id.frag02_1_1 :
                globalVariables.setImage(1);
                Intent intent = new Intent(this, training_ready.class);
                startActivity(intent);
                break;
            case R.id.frag02_1_2 :
                globalVariables.setImage(2);
                Intent intent2 = new Intent(this, training_ready2.class);
                startActivity(intent2);
                break;
            case R.id.frag02_1_3 :
                globalVariables.setImage(3);
                Intent intent3 = new Intent(this, training_ready2.class);
                startActivity(intent3);
                break;
            case R.id.frag02_1_4 :
                globalVariables.setImage(4);
                Intent intent4 = new Intent(this, training_ready2.class);
                startActivity(intent4);
                break;
            case R.id.frag02_2_1 :
                globalVariables.setImage(5);
                Intent intent5 = new Intent(this, training_ready2.class);
                startActivity(intent5);
                break;
            case R.id.frag02_2_2 :
                globalVariables.setImage(6);
                Intent intent6 = new Intent(this, training_ready2.class);
                startActivity(intent6);
                break;
            case R.id.frag02_2_3 :
                globalVariables.setImage(7);
                Intent intent7 = new Intent(this, training_ready2.class);
                startActivity(intent7);
                break;
            case R.id.frag02_2_4 :
                globalVariables.setImage(8);
                Intent intent8 = new Intent(this, training_ready2.class);
                startActivity(intent8);
                break;
            case R.id.frag02_3_1 :
                globalVariables.setImage(9);
                Intent intent9 = new Intent(this, training_ready2.class);
                startActivity(intent9);
                break;
            case R.id.frag02_3_2 :
                globalVariables.setImage(10);
                Intent intent10 = new Intent(this, training_ready2.class);
                startActivity(intent10);
                break;
            case R.id.frag02_3_3 :
                globalVariables.setImage(11);
                Intent intent11 = new Intent(this, training_ready2.class);
                startActivity(intent11);
                break;
            case R.id.frag02_3_4 :
                globalVariables.setImage(12);
                Intent intent12 = new Intent(this, training_ready2.class);
                startActivity(intent12);
                break;
            case R.id.frag02_4_1 :
                globalVariables.setImage(13);
                Intent intent13 = new Intent(this, training_ready2.class);
                startActivity(intent13);
                break;
            case R.id.frag02_4_2 :
                globalVariables.setImage(14);
                Intent intent14 = new Intent(this, training_ready2.class);
                startActivity(intent14);
                break;
            case R.id.frag02_4_3 :
                globalVariables.setImage(15);
                Intent intent15 = new Intent(this, training_ready2.class);
                startActivity(intent15);
                break;
            case R.id.frag02_4_4 :
                globalVariables.setImage(16);
                Intent intent16 = new Intent(this, training_ready2.class);
                startActivity(intent16);
                break;



            case R.id.frag03_level1 :
                globalVariables.setImage(100);
                Intent intent_level1 = new Intent(this, training_level1_ready.class);
                startActivity(intent_level1);
                break;
            case R.id.frag03_level2 :
                globalVariables.setImage(101);
                Intent intent_level2 = new Intent(this, training_level1_ready.class);
                startActivity(intent_level2);
                break;
            case R.id.frag03_level3 :
                globalVariables.setImage(102);
                Intent intent_level3 = new Intent(this, training_level1_ready.class);
                startActivity(intent_level3);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 1:
                refresh();
                break;
        }

    }

    private void refresh(){
        mFragmentPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

//    @Override
//    public void onBackPressed() {
//        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            //super.onBackPressed();
//        }
//    }

}