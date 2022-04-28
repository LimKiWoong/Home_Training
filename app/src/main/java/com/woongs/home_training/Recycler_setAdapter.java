package com.woongs.home_training;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class Recycler_setAdapter extends RecyclerView.Adapter<Recycler_setAdapter.ViewHolder>{


    public ArrayList<Recycler_setitem> recyclersetitem = null;
    Context context;

    Recycler_setAdapter(ArrayList<Recycler_setitem> list) {
        recyclersetitem = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recyclerview_set,parent,false);
        Recycler_setAdapter.ViewHolder viewHolder = new Recycler_setAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Recycler_setitem item = recyclersetitem.get(position);

        //ImageView imageView = ((ViewHolder)holder).img2;

        String a = "R.raw.bicycle_maneuver";
        //holder.img1.setImageDrawable(item.getImg1());
        holder.setnum.setText(item.getNum());
        holder.img2.setImageDrawable(item.getImg2());
        //Glide.with(context).load(a).into(holder.img2);
        holder.text1.setText(item.getText1());
        holder.text2.setText(item.getText2());

    }

    @Override
    public int getItemCount() {
        return recyclersetitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //ImageView img1;
        TextView setnum;
        ImageView img2;
        TextView text1;
        TextView text2;

        public ViewHolder(View itemView) {
            super(itemView);

            setnum = itemView.findViewById(R.id.setnum);
            img2 = itemView.findViewById(R.id.set_img2);
            text1 = itemView.findViewById(R.id.set_text1);
            text2 = itemView.findViewById(R.id.set_text2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        if(mListener != null){
                            mListener.onItemClick(v,pos);
                        }
                    }
                }
            });
        }
    }

    private OnItemClickInterface mListener;

    public void setOnItemClickListener11(OnItemClickInterface listener){
        this.mListener = listener;
    }
    public interface OnItemClickInterface {
        void onItemClick(View v, int position);
    }


    public void addItem(Recycler_setitem listItem){
        recyclersetitem.add(listItem);
    }
}
