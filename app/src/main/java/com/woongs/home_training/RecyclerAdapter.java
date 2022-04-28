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

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Button time_minus;
    Button time_plus;
    TextView time_sec;
    TextView time_min;
    Button allinput;
    Context context;
    GlobalVariables globalVariables = new GlobalVariables();

    public ArrayList<Frag02_ListItem> recycleritem = null;

    RecyclerAdapter(ArrayList<Frag02_ListItem> list) {
        recycleritem = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.frag02_listview,parent,false);
        RecyclerAdapter.ViewHolder viewHolder = new RecyclerAdapter.ViewHolder(view);

        time_minus = (Button) view.findViewById(R.id.time_minus);
        time_sec = (TextView) view.findViewById(R.id.time_sec);
        time_plus = (Button) view.findViewById(R.id.time_plus);
        time_min = (TextView) view.findViewById(R.id.time_min);
        allinput = (Button) view.findViewById(R.id.allinput);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        allinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String min = recycleritem.get(position).getMin();
                String sec = recycleritem.get(position).getSec();

                switch (globalVariables.getRadionum()){
                    case 1:
                        for (int i=0 ; i<1 ; i++){
                            recycleritem.get(i).setMin(min);
                            recycleritem.get(i).setSec(sec);
                        }
                        break;

                    case 2:
                        for (int i=0 ; i<2 ; i++){
                            recycleritem.get(i).setMin(min);
                            recycleritem.get(i).setSec(sec);
                        }
                        break;

                    case 3 :
                        for (int i=0 ; i<3 ; i++){
                            recycleritem.get(i).setMin(min);
                            recycleritem.get(i).setSec(sec);
                        }
                        break;

                    case 4 :
                        for (int i=0 ; i<4 ; i++){
                            recycleritem.get(i).setMin(min);
                            recycleritem.get(i).setSec(sec);
                        }
                        break;

                    case 5 :
                        for (int i=0 ; i<5 ; i++){
                            recycleritem.get(i).setMin(min);
                            recycleritem.get(i).setSec(sec);
                        }
                        break;
                }
                time_min.setText(min);
                time_sec.setText(sec);
                notifyDataSetChanged();
            }
        });

        time_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notifyDataSetChanged();
                String t1 = recycleritem.get(position).getSec();
                Integer time1 = Integer.parseInt(t1);
                if(Integer.valueOf(recycleritem.get(position).getMin()) <= 0 && time1 <= 5){
                    return;
                } else if(Integer.valueOf(recycleritem.get(position).getMin()) <= 0 && time1 > 5){
                    Integer result = time1-5;

                    if(result < 10){
                        recycleritem.get(position).setSec("0"+String.valueOf(result));
                        time_sec.setText(String.valueOf(recycleritem.get(position).getSec()));
                    }else{
                        recycleritem.get(position).setSec(String.valueOf(result));
                        time_sec.setText(String.valueOf(recycleritem.get(position).getSec()));
                    }
                } else if(Integer.valueOf(recycleritem.get(position).getMin()) != 0 ){
                    Integer result = time1-5;

                    if(result < 10){
                        if(result < 0){
                            recycleritem.get(position).setMin("0" + String.valueOf(Integer.parseInt(recycleritem.get(position).getMin()) - 1));
                            time_min.setText(String.valueOf(recycleritem.get(position).getMin()));
                            result = 55;
                            recycleritem.get(position).setSec(String.valueOf(result));
                            time_sec.setText(String.valueOf(recycleritem.get(position).getSec()));

                        }else if(result == 5 || result == 0){
                            recycleritem.get(position).setSec("0" + String.valueOf(result));
                            time_sec.setText(String.valueOf(recycleritem.get(position).getSec()));
                        }
                    }else if(result >= 10){
                        recycleritem.get(position).setSec(String.valueOf(result));
                        time_sec.setText(String.valueOf(recycleritem.get(position).getSec()));
                    }
                }

                notifyDataSetChanged();
            }
        });

        time_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyDataSetChanged();
                String t2 = recycleritem.get(position).getSec();
                Integer time2 = Integer.parseInt(t2);
//                if(time2 >= 55){
//                    return;
//                }
                Integer result2 = time2+5;

                if(Integer.parseInt(recycleritem.get(position).getMin()) < 5){
                    if(result2 > 55) {
                        result2 = 0;
                        recycleritem.get(position).setSec("0" + result2);
                        recycleritem.get(position).setMin("0" + String.valueOf(Integer.parseInt(recycleritem.get(position).getMin()) + 1));
                        time_sec.setText(String.valueOf(recycleritem.get(position).getSec()));
                        time_min.setText(String.valueOf(recycleritem.get(position).getMin()));
                    }else if (result2 < 10){
                        recycleritem.get(position).setSec("0"+result2);
                        time_sec.setText(String.valueOf(recycleritem.get(position).getSec()));
                    }else{
                        recycleritem.get(position).setSec(String.valueOf(result2));
                        time_sec.setText(String.valueOf(recycleritem.get(position).getSec()));
                    }
                    //recycleritem.get(position).setMin("0" + recycleritem.get(position).getMin());
                    //time_min.setText(String.valueOf(recycleritem.get(position).getMin()));
                }



                notifyDataSetChanged();
            }
        });

        Frag02_ListItem item = recycleritem.get(position);

        holder.num.setText(item.getNum());
        holder.min.setText(item.getMin());
        holder.sec.setText(item.getSec());

    }

    @Override
    public int getItemCount() {
        return recycleritem.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView num;
        TextView min;
        TextView sec;

        public ViewHolder(View itemView) {
            super(itemView);

            num = itemView.findViewById(R.id.listnumber);
            min = itemView.findViewById(R.id.time_min);
            sec = itemView.findViewById(R.id.time_sec);
        }
    }

    public void addItem(Frag02_ListItem listItem){
        recycleritem.add(listItem);
    }
}
