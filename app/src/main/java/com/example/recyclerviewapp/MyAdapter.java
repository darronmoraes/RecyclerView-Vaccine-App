package com.example.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    // 4 - Handling the click events instance
    private ItemClickListener clickListener;

    // 1 - Data Source
    private VaccineModel[] listData;

    public MyAdapter(VaccineModel[] listData) {
        this.listData = listData;
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    // 2 - View Holder Class
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Variable Initialization
        public ImageView imgView;
        public TextView txtView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // View Declaration
            this.imgView = itemView.findViewById(R.id.iv_logo);
            this.txtView = itemView.findViewById(R.id.tv_vaccine_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onClick(v, getAdapterPosition());
            }
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
