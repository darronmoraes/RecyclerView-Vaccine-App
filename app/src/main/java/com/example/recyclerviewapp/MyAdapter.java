package com.example.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    // 1 - Data Source
    private VaccineModel[] listData;

    public MyAdapter(VaccineModel[] listData) {
        this.listData = listData;
    }

    // 2 - View Holder Class
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // Variable Initialization
        public ImageView imgView;
        public TextView txtView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // View Declaration
            this.imgView = itemView.findViewById(R.id.iv_logo);
            this.txtView = itemView.findViewById(R.id.tv_vaccine_name);
        }
    }

    // 3 - Implementing Methods
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(
                R.layout.recyclerview_item,
                parent,
                false
        );
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final VaccineModel myData = listData[position];
        holder.txtView.setText(listData[position].getTitle());
        holder.imgView.setImageResource(listData[position].getImage());
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }
}
