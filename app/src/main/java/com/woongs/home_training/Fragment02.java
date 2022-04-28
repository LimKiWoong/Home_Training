package com.woongs.home_training;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment02 extends Fragment {

    ImageView frag2_1_1,frag2_1_2,frag2_1_3,frag2_1_4,
            frag2_2_1,frag2_2_2,frag2_2_3,frag2_2_4,
            frag2_3_1,frag2_3_2,frag2_3_3,frag2_3_4,
            frag2_4_1,frag2_4_2,frag2_4_3,frag2_4_4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View convertview;
        convertview = inflater.inflate(R.layout.fragment02,container,false);

        frag2_1_1 = (ImageView) convertview.findViewById(R.id.frag02_1_1);
        Glide.with(convertview).load(R.drawable.plank).centerCrop().into(frag2_1_1);
        frag2_1_2 = (ImageView) convertview.findViewById(R.id.frag02_1_2);
        Glide.with(convertview).load(R.raw.crunch).centerCrop().into(frag2_1_2);
        frag2_1_3 = (ImageView) convertview.findViewById(R.id.frag02_1_3);
        Glide.with(convertview).load(R.raw.mountain_climer).centerCrop().into(frag2_1_3);
        frag2_1_4 = (ImageView) convertview.findViewById(R.id.frag02_1_4);
        Glide.with(convertview).load(R.raw.bicycle_maneuver).centerCrop().into(frag2_1_4);

        frag2_2_1 = (ImageView) convertview.findViewById(R.id.frag02_2_1);
        Glide.with(convertview).load(R.raw.pushup).centerCrop().into(frag2_2_1);
        frag2_2_2 = (ImageView) convertview.findViewById(R.id.frag02_2_2);
        Glide.with(convertview).load(R.raw.singleleg_pushup).centerCrop().into(frag2_2_2);
        frag2_2_3 = (ImageView) convertview.findViewById(R.id.frag02_2_3);
        Glide.with(convertview).load(R.raw.incline_pushup).centerCrop().into(frag2_2_3);
        frag2_2_4 = (ImageView) convertview.findViewById(R.id.frag02_2_4);
        Glide.with(convertview).load(R.raw.decline_pushup).centerCrop().into(frag2_2_4);

        frag2_3_1 = (ImageView) convertview.findViewById(R.id.frag02_3_1);
        Glide.with(convertview).load(R.raw.lying_extension).centerCrop().into(frag2_3_1);
        frag2_3_2 = (ImageView) convertview.findViewById(R.id.frag02_3_2);
        Glide.with(convertview).load(R.raw.kickback).centerCrop().into(frag2_3_2);
        frag2_3_3 = (ImageView) convertview.findViewById(R.id.frag02_3_3);
        Glide.with(convertview).load(R.raw.deeps).centerCrop().into(frag2_3_3);
        frag2_3_4 = (ImageView) convertview.findViewById(R.id.frag02_3_4);
        Glide.with(convertview).load(R.raw.dumbellcurl).centerCrop().into(frag2_3_4);

        frag2_4_1 = (ImageView) convertview.findViewById(R.id.frag02_4_1);
        Glide.with(convertview).load(R.raw.squat).centerCrop().into(frag2_4_1);
        frag2_4_2 = (ImageView) convertview.findViewById(R.id.frag02_4_2);
        Glide.with(convertview).load(R.raw.runge).centerCrop().into(frag2_4_2);
        frag2_4_3 = (ImageView) convertview.findViewById(R.id.frag02_4_3);
        Glide.with(convertview).load(R.raw.skate).centerCrop().into(frag2_4_3);
        frag2_4_4 = (ImageView) convertview.findViewById(R.id.frag02_4_4);
        Glide.with(convertview).load(R.raw.side_legrase).centerCrop().into(frag2_4_4);

        return convertview;
    }
}
