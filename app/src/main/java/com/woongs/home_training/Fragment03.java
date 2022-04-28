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

public class Fragment03 extends Fragment {

    ImageView img_level1,img_level2,img_level3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View convertview;
        convertview = inflater.inflate(R.layout.fragment03,container,false);


        img_level1 = (ImageView) convertview.findViewById(R.id.frag03_level1);
        img_level2 = (ImageView) convertview.findViewById(R.id.frag03_level2);
        img_level3 = (ImageView) convertview.findViewById(R.id.frag03_level3);

        Glide.with(convertview).load(R.drawable.level1).into(img_level1);
        Glide.with(convertview).load(R.drawable.level2).into(img_level2);
        Glide.with(convertview).load(R.drawable.level3).into(img_level3);
//        img_level1.setImageResource(R.drawable.level1);
//        img_level2.setImageResource(R.drawable.level2);
//        img_level3.setImageResource(R.drawable.level3);

        return convertview;
    }
}
