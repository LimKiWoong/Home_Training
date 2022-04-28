package com.woongs.home_training;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment01 extends Fragment {

    TextView challenge;
    ProgressBar progressBar;
    TextView todaymin;
    TextView todaysec;
    TextView yesterdaymin;
    TextView yesterdaysec;
    int challenge10min;
    GlobalVariables globalVariables = new GlobalVariables();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View convertview;
        convertview = inflater.inflate(R.layout.fragment01,container,false);

        challenge = (TextView) convertview.findViewById(R.id.challenge10min);
        progressBar = (ProgressBar) convertview.findViewById(R.id.progressbar);
        todaymin = (TextView) convertview.findViewById(R.id.today_min);
        todaysec = (TextView) convertview.findViewById(R.id.today_sec);
        yesterdaymin = (TextView) convertview.findViewById(R.id.yesterdaymin);
        yesterdaysec = (TextView) convertview.findViewById(R.id.yesterdaysec);

        challenge10min = Integer.parseInt(globalVariables.getTodaymin());
        if(challenge10min >= 10){
            challenge10min = 10;
            challenge.setTextColor(Color.parseColor("#0000ff"));
        } else{

        }

        challenge.setText(String.valueOf(challenge10min));
        progressBar.setProgress(challenge10min);
        todaymin.setText(globalVariables.getTodaymin());
        todaysec.setText(globalVariables.getTodaysec());
        yesterdaymin.setText(globalVariables.getYesterdaymin());
        yesterdaysec.setText(globalVariables.getYesterdaysec());

//        Date now = Calendar.getInstance().getTime();
//        String now_text = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm", Locale.getDefault()).format(now);
//        nowt.setText(now_text);



        return convertview;
    }
}
