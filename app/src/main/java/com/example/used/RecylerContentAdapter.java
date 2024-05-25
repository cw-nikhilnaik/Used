package com.example.used;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecylerContentAdapter extends RecyclerView.Adapter<RecylerContentAdapter.ViewHolder> {

    Context context;
    ArrayList<UsedCarDetails>arrayList;
    RecylerContentAdapter(Context context, ArrayList<UsedCarDetails>arrayList){

        this.context = context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public RecylerContentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.used_list_card , parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerContentAdapter.ViewHolder holder, int position) {
        holder.carName.setText(arrayList.get(position).carName);
        holder.formattedPrice.setText(arrayList.get(position).price);

        Glide.with(context).load(arrayList.get(position).imageUrl).into(holder.carImage);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView carName, formattedPrice;
        ImageView carImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.carName);
            formattedPrice = itemView.findViewById((R.id.formattedPrice));
            carImage = itemView.findViewById(R.id.carImage);
        }
    }
}
