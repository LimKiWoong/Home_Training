package com.woongs.home_training;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Frag02_ListViewAdapter extends BaseAdapter {
    ArrayList<Frag02_ListItem> items = new ArrayList<Frag02_ListItem>();
    Context context;
    TextView time_sec;
    TextView time_min;
    Button time_minus;
    Button time_plus;
    Button allinput;
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        Frag02_ListItem listItem = items.get(position);
        final int pos = position;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.frag02_listview,parent,false);

            time_minus = (Button) convertView.findViewById(R.id.time_minus);
            View finalConvertView = convertView;
            time_minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notifyDataSetChanged();
                    String t1 = items.get(position).getSec();
                    Integer time1 = Integer.parseInt(t1);
                    if(time1 <= 5){
                        return;
                    }
                    Integer result = time1-5;
                    if(result < 10){
                        items.get(position).setSec("0"+String.valueOf(result));
                    }else{
                        items.get(position).setSec(String.valueOf(result));
                    }
                    time_sec = (TextView) finalConvertView.findViewById(R.id.time_sec);
                    time_sec.setText(String.valueOf(items.get(position).getSec()));
                    notifyDataSetChanged();
                }
            });
            time_plus = (Button) convertView.findViewById(R.id.time_plus);

            time_plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notifyDataSetChanged();
                    String t2 = items.get(position).getSec();
                    Integer time2 = Integer.parseInt(t2);
                    if(time2 >= 55){
                        return;
                    }
                    Integer result2 = time2+5;
                    items.get(position).setSec(String.valueOf(result2));
                    time_sec = (TextView) finalConvertView.findViewById(R.id.time_sec);
                    time_sec.setText(String.valueOf(items.get(position).getSec()));
                    notifyDataSetChanged();
                }
            });

            allinput = (Button) convertView.findViewById(R.id.allinput);



            TextView textView = (TextView) convertView.findViewById(R.id.listnumber);
            time_min = (TextView) convertView.findViewById(R.id.time_min);
//            time_min.setFilters(new InputFilter[]{new InputFilterMinMax("0","60")});
            time_sec = (TextView) convertView.findViewById(R.id.time_sec);
//            time_sec.setFilters(new InputFilter[]{new InputFilterMinMax("5","59")});

            textView.setText(listItem.getNum());
            time_min.setText(listItem.getMin());
            time_sec.setText(listItem.getSec());
        }
        return convertView;
    }

    public void addItem(Frag02_ListItem listItem){
        items.add(listItem);
    }
}
