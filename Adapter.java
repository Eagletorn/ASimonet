package com.example.antoine.projet_contact;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Antoine on 23/01/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    private ArrayList<DataModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView contact;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.Name);
            this.contact = (TextView) itemView.findViewById(R.id.Contact);
        }
    }

    public Adapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card, parent, false);

        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.name;
        TextView textViewVersion = holder.contact;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getContact().toString());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    /*public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }*/


}