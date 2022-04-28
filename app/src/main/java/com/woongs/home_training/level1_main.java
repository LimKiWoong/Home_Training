package com.woongs.home_training;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

public class level1_main extends AppCompatActivity {

    NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_main);

        nestedScrollView = (NestedScrollView) findViewById(R.id.nested2);
        nestedScrollView.setNestedScrollingEnabled(true);

//        recyclerView = (RecyclerView) findViewById(R.id.recyclerview2);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        adapter = new Recycler_setAdapter(items);
//
//        recyclerView.setAdapter(adapter);
//
//        adapter.recyclersetitem.clear();
//
//        adapter.addItem(new Recycler_setitem(ContextCompat.getDrawable(this,R.drawable.ic_hamburger),
//                ContextCompat.getDrawable(this,R.drawable.ic_launcher_foreground),"운동1","시간1"));
//        adapter.addItem(new Recycler_setitem(ContextCompat.getDrawable(this,R.drawable.ic_hamburger),
//                ContextCompat.getDrawable(this,R.drawable.ic_launcher_foreground),"운동1","시간1"));
//        adapter.addItem(new Recycler_setitem(ContextCompat.getDrawable(this,R.drawable.ic_hamburger),
//                ContextCompat.getDrawable(this,R.drawable.ic_launcher_foreground),"운동1","시간1"));
//        adapter.addItem(new Recycler_setitem(ContextCompat.getDrawable(this,R.drawable.ic_hamburger),
//                ContextCompat.getDrawable(this,R.drawable.ic_launcher_foreground),"운동1","시간1"));
//        adapter.addItem(new Recycler_setitem(ContextCompat.getDrawable(this,R.drawable.ic_hamburger),
//                ContextCompat.getDrawable(this,R.drawable.ic_launcher_foreground),"운동1","시간1"));
//
//        adapter.notifyDataSetChanged();
    }
}