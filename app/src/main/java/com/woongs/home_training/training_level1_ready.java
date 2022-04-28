package com.woongs.home_training;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class training_level1_ready extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;
    AppBarLayout appBarLayout;

    Recycler_setAdapter adapter;
    RecyclerView recyclerView;

    TextView getcount;
    TextView gettime;
    Button button;
    Context context;

    ArrayList<Recycler_setitem> items =new ArrayList<Recycler_setitem>();
    GlobalVariables globalVariables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_level1_ready);

        globalVariables = new GlobalVariables();

        Toolbar toolbar = (Toolbar) findViewById(R.id.level1_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imageView = (ImageView) findViewById(R.id.training_ready_level1_image);

        final View include = findViewById(R.id.level1_include);
        recyclerView = (RecyclerView) include.findViewById(R.id.recyclerview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getcount = (TextView) include.findViewById(R.id.itemcount);
        gettime = (TextView) include.findViewById(R.id.gettime);
        button = (Button) include.findViewById(R.id.getstart);


        adapter = new Recycler_setAdapter(items);

        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new RecyclerDecoration(10));






        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.level1_collapsing);
        //collapsingToolbarLayout.setExpandedTitleTextColor(ColorStateList.valueOf(Color.rgb(255,193,7)));
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        appBarLayout = (AppBarLayout) findViewById(R.id.level1_appbar);


        switch (globalVariables.getImage()){
            case 100:
                imageView.setImageResource(R.drawable.level1);
                actionBar.setTitle("초급");
                getcount.setText("10");
                gettime.setText("8");

                adapter.recyclersetitem.clear();


                adapter.addItem(new Recycler_setitem("1",
                        ContextCompat.getDrawable(this,R.drawable.jumpingjack),"팔벌려뛰기","00:20"));
                adapter.addItem(new Recycler_setitem("2",
                        ContextCompat.getDrawable(this,R.drawable.mountain_climer),"마운틴 클라이머","X12"));
                adapter.addItem(new Recycler_setitem("3",
                        ContextCompat.getDrawable(this,R.drawable.plank),"플랭크","00:20"));
                adapter.addItem(new Recycler_setitem("4",
                        ContextCompat.getDrawable(this,R.drawable.crunch),"크런치","X12"));
                adapter.addItem(new Recycler_setitem("5",
                        ContextCompat.getDrawable(this,R.drawable.knee_pushup),"무릎대고 팔굽혀펴기","X12"));
                adapter.addItem(new Recycler_setitem("6",
                        ContextCompat.getDrawable(this,R.drawable.incline_pushup),"인클라인푸쉬업","X8"));
                adapter.addItem(new Recycler_setitem("7",
                        ContextCompat.getDrawable(this,R.drawable.chest_stretching),"가슴모아 올리기","00:30"));
                adapter.addItem(new Recycler_setitem("8",
                        ContextCompat.getDrawable(this,R.drawable.squat),"스쿼트","X12"));
                adapter.addItem(new Recycler_setitem("9",
                        ContextCompat.getDrawable(this,R.drawable.runge),"런지","X12"));
                adapter.addItem(new Recycler_setitem("10",
                        ContextCompat.getDrawable(this,R.drawable.cat_stretching),"마무리","00:30"));

                adapter.notifyDataSetChanged();
                break;
            case 101:
                imageView.setImageResource(R.drawable.level2);
                actionBar.setTitle("중급");
                getcount.setText("14");
                gettime.setText("12");

                adapter.recyclersetitem.clear();

                adapter.addItem(new Recycler_setitem("1",
                        ContextCompat.getDrawable(this,R.drawable.jumpingjack),"팔벌려뛰기","00:20"));
                adapter.addItem(new Recycler_setitem("2",
                        ContextCompat.getDrawable(this,R.drawable.bicycle_menuber),"바이시클 메뉴버","X20"));
                adapter.addItem(new Recycler_setitem("3",
                        ContextCompat.getDrawable(this,R.drawable.mountain_climer),"마운틴 클라이머","X20"));
                adapter.addItem(new Recycler_setitem("4",
                        ContextCompat.getDrawable(this,R.drawable.plank),"플랭크","00:30"));
                adapter.addItem(new Recycler_setitem("5",
                        ContextCompat.getDrawable(this,R.drawable.crunch),"크런치","X20"));
                adapter.addItem(new Recycler_setitem("6",
                        ContextCompat.getDrawable(this,R.drawable.pushup),"팔굽혀펴기","X10"));
                adapter.addItem(new Recycler_setitem("7",
                        ContextCompat.getDrawable(this,R.drawable.singleleg_pushup),"싱글레그푸쉬업","X6"));
                adapter.addItem(new Recycler_setitem("8",
                        ContextCompat.getDrawable(this,R.drawable.chest_stretching),"가슴모아 올리기","00:30"));
                adapter.addItem(new Recycler_setitem("9",
                        ContextCompat.getDrawable(this,R.drawable.squat),"스쿼트","X20"));
                adapter.addItem(new Recycler_setitem("10",
                        ContextCompat.getDrawable(this,R.drawable.runge),"런지","X20"));
                adapter.addItem(new Recycler_setitem("11",
                        ContextCompat.getDrawable(this,R.drawable.skate),"측면운동","00:30"));
                adapter.addItem(new Recycler_setitem("12",
                        ContextCompat.getDrawable(this,R.drawable.side_legrase),"사이드레그레이즈(왼쪽)","00:20"));
                adapter.addItem(new Recycler_setitem("13",
                        ContextCompat.getDrawable(this,R.drawable.side_legrase),"사이드레그레이즈(오른쪽)","00:20"));
                adapter.addItem(new Recycler_setitem("14",
                        ContextCompat.getDrawable(this,R.drawable.cat_stretching),"마무리","00:30"));

                adapter.notifyDataSetChanged();
                break;
            case 102:
                imageView.setImageResource(R.drawable.level3);
                actionBar.setTitle("상급");
                getcount.setText("18");
                gettime.setText("16");

                adapter.recyclersetitem.clear();

                adapter.addItem(new Recycler_setitem("1",
                        ContextCompat.getDrawable(this,R.drawable.jumpingjack),"팔벌려뛰기","00:30"));
                adapter.addItem(new Recycler_setitem("2","윗몸일으키기","X20"));
                adapter.addItem(new Recycler_setitem("3",
                        ContextCompat.getDrawable(this,R.drawable.bicycle_menuber),"바이시클 메뉴버","X24"));
                adapter.addItem(new Recycler_setitem("4",
                        ContextCompat.getDrawable(this,R.drawable.mountain_climer),"마운틴 클라이머","X30"));
                adapter.addItem(new Recycler_setitem("5",
                        ContextCompat.getDrawable(this,R.drawable.plank),"플랭크","01:00"));
                adapter.addItem(new Recycler_setitem("6",
                        ContextCompat.getDrawable(this,R.drawable.crunch),"크런치","X28"));
                adapter.addItem(new Recycler_setitem("7",
                        ContextCompat.getDrawable(this,R.drawable.cobra_stretching),"코브라스트레칭","00:30"));
                adapter.addItem(new Recycler_setitem("8",
                        ContextCompat.getDrawable(this,R.drawable.pushup),"팔굽혀펴기","X12"));
                adapter.addItem(new Recycler_setitem("9",
                        ContextCompat.getDrawable(this,R.drawable.singleleg_pushup),"싱글레그푸쉬업","X8"));
                adapter.addItem(new Recycler_setitem("10",
                        ContextCompat.getDrawable(this,R.drawable.decline_pushup),"디클라인푸쉬업","X12"));
                adapter.addItem(new Recycler_setitem("11",
                        ContextCompat.getDrawable(this,R.drawable.bupee),"버피","X10"));
                adapter.addItem(new Recycler_setitem("12",
                        ContextCompat.getDrawable(this,R.drawable.chest_stretching),"가슴모아 올리기","00:30"));
                adapter.addItem(new Recycler_setitem("13",
                        ContextCompat.getDrawable(this,R.drawable.squat),"스쿼트","X30"));
                adapter.addItem(new Recycler_setitem("14",
                        ContextCompat.getDrawable(this,R.drawable.runge),"런지","X30"));
                adapter.addItem(new Recycler_setitem("15",
                        ContextCompat.getDrawable(this,R.drawable.skate),"측면운동","01:00"));
                adapter.addItem(new Recycler_setitem("16",
                        ContextCompat.getDrawable(this,R.drawable.side_legrase),"사이드레그레이즈(왼쪽)","00:30"));
                adapter.addItem(new Recycler_setitem("17",
                        ContextCompat.getDrawable(this,R.drawable.side_legrase),"사이드레그레이즈(오른쪽)","00:30"));
                adapter.addItem(new Recycler_setitem("18",
                        ContextCompat.getDrawable(this,R.drawable.cat_stretching),"마무리","00:30"));
                adapter.notifyDataSetChanged();
                break;
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date currenttime = Calendar.getInstance().getTime();
                String date_text = new SimpleDateFormat("MM월 dd일 HH:mm", Locale.getDefault()).format(currenttime);
                globalVariables.setDatetime(date_text);

                switch (globalVariables.getImage()){
                    case 100:
                        globalVariables.setSetlevel("level1");
                        Intent intent = new Intent(training_level1_ready.this,five_seconds.class);
                        intent.putExtra("5seconds",10);
                        intent.putExtra("order",1);
                        startActivity(intent);
                        finish();
                        break;
                    case 101:
                        globalVariables.setSetlevel("level2");
                        Intent intent2 = new Intent(training_level1_ready.this,five_seconds.class);
                        intent2.putExtra("5seconds",11);
                        intent2.putExtra("order",1);
                        startActivity(intent2);
                        finish();
                        break;
                    case 102:
                        globalVariables.setSetlevel("level3");
                        Intent intent3 = new Intent(training_level1_ready.this,five_seconds.class);
                        intent3.putExtra("5seconds",10);
                        intent3.putExtra("order",1);
                        startActivity(intent3);
                        finish();
                        break;
                }
            }
        });

        adapter.setOnItemClickListener11(new Recycler_setAdapter.OnItemClickInterface() {
            @Override
            public void onItemClick(View v, int position) {
                if(globalVariables.getImage() == 100) {

                    switch (position) {

                        case 0:
                            Intent intent0 = new Intent(training_level1_ready.this,training_example.class);
                            intent0.putExtra("pos",position);
                            startActivity(intent0);
                            break;
                        case 1:
                            Intent intent1 = new Intent(training_level1_ready.this,training_example.class);
                            intent1.putExtra("pos",position);
                            startActivity(intent1);
                            break;
                        case 2:
                            Intent intent2 = new Intent(training_level1_ready.this,training_example.class);
                            intent2.putExtra("pos",position);
                            startActivity(intent2);
                            break;
                        case 3:
                            Intent intent3 = new Intent(training_level1_ready.this,training_example.class);
                            intent3.putExtra("pos",position);
                            startActivity(intent3);
                            break;
                        case 4:
                            Intent intent4 = new Intent(training_level1_ready.this,training_example.class);
                            intent4.putExtra("pos",position);
                            startActivity(intent4);
                            break;
                        case 5:
                            Intent intent5 = new Intent(training_level1_ready.this,training_example.class);
                            intent5.putExtra("pos",position);
                            startActivity(intent5);
                            break;
                        case 6:
                            Intent intent6 = new Intent(training_level1_ready.this,training_example.class);
                            intent6.putExtra("pos",position);
                            startActivity(intent6);
                            break;
                        case 7:
                            Intent intent7 = new Intent(training_level1_ready.this,training_example.class);
                            intent7.putExtra("pos",position);
                            startActivity(intent7);
                            break;
                        case 8:
                            Intent intent8 = new Intent(training_level1_ready.this,training_example.class);
                            intent8.putExtra("pos",position);
                            startActivity(intent8);
                            break;
                        case 9:
                            Intent intent9 = new Intent(training_level1_ready.this,training_example.class);
                            intent9.putExtra("pos",position);
                            startActivity(intent9);
                            break;
                    }
                }

                if(globalVariables.getImage() == 101) {

                    switch (position) {

                        case 0:
                            Intent intent0 = new Intent(training_level1_ready.this,training_example.class);
                            intent0.putExtra("pos",position);
                            startActivity(intent0);
                            break;
                        case 1:
                            Intent intent1 = new Intent(training_level1_ready.this,training_example.class);
                            intent1.putExtra("pos",position);
                            startActivity(intent1);
                            break;
                        case 2:
                            Intent intent2 = new Intent(training_level1_ready.this,training_example.class);
                            intent2.putExtra("pos",position);
                            startActivity(intent2);
                            break;
                        case 3:
                            Intent intent3 = new Intent(training_level1_ready.this,training_example.class);
                            intent3.putExtra("pos",position);
                            startActivity(intent3);
                            break;
                        case 4:
                            Intent intent4 = new Intent(training_level1_ready.this,training_example.class);
                            intent4.putExtra("pos",position);
                            startActivity(intent4);
                            break;
                        case 5:
                            Intent intent5 = new Intent(training_level1_ready.this,training_example.class);
                            intent5.putExtra("pos",position);
                            startActivity(intent5);
                            break;
                        case 6:
                            Intent intent6 = new Intent(training_level1_ready.this,training_example.class);
                            intent6.putExtra("pos",position);
                            startActivity(intent6);
                            break;
                        case 7:
                            Intent intent7 = new Intent(training_level1_ready.this,training_example.class);
                            intent7.putExtra("pos",position);
                            startActivity(intent7);
                            break;
                        case 8:
                            Intent intent8 = new Intent(training_level1_ready.this,training_example.class);
                            intent8.putExtra("pos",position);
                            startActivity(intent8);
                            break;
                        case 9:
                            Intent intent9 = new Intent(training_level1_ready.this,training_example.class);
                            intent9.putExtra("pos",position);
                            startActivity(intent9);
                            break;
                        case 10:
                            Intent intent10 = new Intent(training_level1_ready.this,training_example.class);
                            intent10.putExtra("pos",position);
                            startActivity(intent10);
                            break;
                        case 11:
                            Intent intent11 = new Intent(training_level1_ready.this,training_example.class);
                            intent11.putExtra("pos",position);
                            startActivity(intent11);
                            break;
                        case 12:
                            Intent intent12 = new Intent(training_level1_ready.this,training_example.class);
                            intent12.putExtra("pos",position);
                            startActivity(intent12);
                            break;
                        case 13:
                            Intent intent13 = new Intent(training_level1_ready.this,training_example.class);
                            intent13.putExtra("pos",position);
                            startActivity(intent13);
                            break;
                    }
                }



                if(globalVariables.getImage() == 102) {

                    switch (position) {

                        case 0:
                            Intent intent0 = new Intent(training_level1_ready.this,training_example.class);
                            intent0.putExtra("pos",position);
                            startActivity(intent0);
                            break;
                        case 1:
                            Intent intent1 = new Intent(training_level1_ready.this,training_example.class);
                            intent1.putExtra("pos",position);
                            startActivity(intent1);
                            break;
                        case 2:
                            Intent intent2 = new Intent(training_level1_ready.this,training_example.class);
                            intent2.putExtra("pos",position);
                            startActivity(intent2);
                            break;
                        case 3:
                            Intent intent3 = new Intent(training_level1_ready.this,training_example.class);
                            intent3.putExtra("pos",position);
                            startActivity(intent3);
                            break;
                        case 4:
                            Intent intent4 = new Intent(training_level1_ready.this,training_example.class);
                            intent4.putExtra("pos",position);
                            startActivity(intent4);
                            break;
                        case 5:
                            Intent intent5 = new Intent(training_level1_ready.this,training_example.class);
                            intent5.putExtra("pos",position);
                            startActivity(intent5);
                            break;
                        case 6:
                            Intent intent6 = new Intent(training_level1_ready.this,training_example.class);
                            intent6.putExtra("pos",position);
                            startActivity(intent6);
                            break;
                        case 7:
                            Intent intent7 = new Intent(training_level1_ready.this,training_example.class);
                            intent7.putExtra("pos",position);
                            startActivity(intent7);
                            break;
                        case 8:
                            Intent intent8 = new Intent(training_level1_ready.this,training_example.class);
                            intent8.putExtra("pos",position);
                            startActivity(intent8);
                            break;
                        case 9:
                            Intent intent9 = new Intent(training_level1_ready.this,training_example.class);
                            intent9.putExtra("pos",position);
                            startActivity(intent9);
                            break;
                        case 10:
                            Intent intent10 = new Intent(training_level1_ready.this,training_example.class);
                            intent10.putExtra("pos",position);
                            startActivity(intent10);
                            break;
                        case 11:
                            Intent intent11 = new Intent(training_level1_ready.this,training_example.class);
                            intent11.putExtra("pos",position);
                            startActivity(intent11);
                            break;
                        case 12:
                            Intent intent12 = new Intent(training_level1_ready.this,training_example.class);
                            intent12.putExtra("pos",position);
                            startActivity(intent12);
                            break;
                        case 13:
                            Intent intent13 = new Intent(training_level1_ready.this,training_example.class);
                            intent13.putExtra("pos",position);
                            startActivity(intent13);
                            break;
                        case 14:
                            Intent intent14 = new Intent(training_level1_ready.this,training_example.class);
                            intent14.putExtra("pos",position);
                            startActivity(intent14);
                            break;
                        case 15:
                            Intent intent15 = new Intent(training_level1_ready.this,training_example.class);
                            intent15.putExtra("pos",position);
                            startActivity(intent15);
                            break;
                        case 16:
                            Intent intent16 = new Intent(training_level1_ready.this,training_example.class);
                            intent16.putExtra("pos",position);
                            startActivity(intent16);
                            break;
                        case 17:
                            Intent intent17 = new Intent(training_level1_ready.this,training_example.class);
                            intent17.putExtra("pos",position);
                            startActivity(intent17);
                            break;
                        case 18:
                            Intent intent18 = new Intent(training_level1_ready.this,training_example.class);
                            intent18.putExtra("pos",position);
                            startActivity(intent18);
                            break;
                    }
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
}