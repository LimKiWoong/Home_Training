package com.woongs.home_training;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ViewHolder> {

    TextView countnum;
    Button count_minus;
    Button count_plus;
    Button allinput;
    GlobalVariables globalVariables = new GlobalVariables();

    Context context;

    public ArrayList<ready2_listitem> recycleritem2 = null;

    RecyclerAdapter2(ArrayList<ready2_listitem> list) {
        recycleritem2 = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.ready2_listitem,parent,false);
        RecyclerAdapter2.ViewHolder viewHolder = new RecyclerAdapter2.ViewHolder(view);

        countnum = (TextView) view.findViewById(R.id.count);
        count_minus = (Button) view.findViewById(R.id.count_minus);
        count_plus = (Button) view.findViewById(R.id.count_plus);
        allinput = (Button) view.findViewById(R.id.allinput2);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        allinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String count = recycleritem2.get(position).getCount();

                switch (globalVariables.getRadionum()){
                    case 1:
                        for (int i=0 ; i<1 ; i++){
                            recycleritem2.get(i).setCount(count);
                        }
                        break;

                    case 2:
                        for (int i=0 ; i<2 ; i++){
                            recycleritem2.get(i).setCount(count);
                        }
                        break;

                    case 3 :
                        for (int i=0 ; i<3 ; i++){
                            recycleritem2.get(i).setCount(count);
                        }
                        break;

                    case 4 :
                        for (int i=0 ; i<4 ; i++){
                            recycleritem2.get(i).setCount(count);
                        }
                        break;

                    case 5 :
                        for (int i=0 ; i<5 ; i++){
                            recycleritem2.get(i).setCount(count);
                        }
                        break;
                }
                countnum.setText(count);
                notifyDataSetChanged();
            }
        });

        count_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyDataSetChanged();
                if(Integer.valueOf(recycleritem2.get(position).getCount()) <= 5){
                    return;
                } else if( Integer.valueOf(recycleritem2.get(position).getCount()) > 5) {
                    recycleritem2.get(position).setCount(String.valueOf(Integer.valueOf(recycleritem2.get(position).getCount()) - 1));
                    countnum.setText(recycleritem2.get(position).getCount());
                }
                notifyDataSetChanged();
            }
        });

        count_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyDataSetChanged();
                if (Integer.valueOf(recycleritem2.get(position).getCount()) >= 50){
                    return;
                } else if(Integer.valueOf(recycleritem2.get(position).getCount()) < 50){
                    recycleritem2.get(position).setCount(String.valueOf(Integer.valueOf(recycleritem2.get(position).getCount()) + 1));
                    countnum.setText(recycleritem2.get(position).getCount());
                }
                notifyDataSetChanged();
            }
        });

        ready2_listitem item = recycleritem2.get(position);

        holder.num.setText(item.getNum());
        holder.count.setText(item.getCount());


    }

    @Override
    public int getItemCount() {
        return recycleritem2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView num;
        TextView count;


        public ViewHolder(View itemView) {
            super(itemView);

            num = itemView.findViewById(R.id.listnumber2);
            count = itemView.findViewById(R.id.count);
        }
    }

    public void addItem(ready2_listitem listItem2){
        recycleritem2.add(listItem2);
    }
}

