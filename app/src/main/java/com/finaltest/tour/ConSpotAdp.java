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

    private ArrayList<Capital> places;
    LayoutInflater inflater;

    public ConSpotAdp(Context context, ArrayList<Capital>places){
        this.places=places;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int position) {
        return places.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, null);
            holder.img = convertView.findViewById(R.id.ivflag);
            holder.placeName = convertView.findViewById(R.id.txtName);
            holder.placeRate = convertView.findViewById(R.id.txtPrice);
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag();
        int id = convertView.getResources().getIdentifier(places.get(position).getConimg(),"drawable",convertView.getContext().getPackageName());
        holder.img.setImageResource(id);
        holder.placeName.setText(places.get(position).getConname());
        holder.placeRate.setText(String.valueOf(places.get(position).getPlaceRate()));

        return convertView;
    }

    static class ViewHolder{
        ImageView img;
        TextView placeName,placeRate;
    }
}
