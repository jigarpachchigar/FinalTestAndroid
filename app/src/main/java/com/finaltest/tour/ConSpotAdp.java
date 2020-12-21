package com.finaltest.tour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ConSpotAdp extends BaseAdapter {

    private ArrayList<Spot> spots;
    LayoutInflater lyinf;

    public ConSpotAdp(Context context, ArrayList<Spot>spots){
        this.spots =spots;
        lyinf =LayoutInflater.from(context);
    }
    static class ViewHolder{
        ImageView img;
        TextView spname,spfare;

    }

    @Override
    public int getCount() {
        return spots.size();
    }

    @Override
    public Object getItem(int position) {
        return spots.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();

        if(convertView == null) {

            convertView = lyinf.inflate(R.layout.list_row, null);
            holder.img = convertView.findViewById(R.id.ivspot);
            holder.spname = convertView.findViewById(R.id.tvspname);
            holder.spfare = convertView.findViewById(R.id.tvspfare);
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag();
        int id = convertView.getResources().getIdentifier(spots.get(position).getSpotimg(),"drawable",convertView.getContext().getPackageName());
        holder.img.setImageResource(id);
        holder.spname.setText(spots.get(position).getSpotname());
        holder.spfare.setText(String.valueOf(spots.get(position).getSpotfare()));

        return convertView;
    }


}
