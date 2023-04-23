package com.example.uniapp;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uniapp.fragments.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<PDFmodel> dataList;

    public RecyclerViewAdapter(Context context, List<PDFmodel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recTitle.setText(dataList.get(position).getTitle());
        //holder.recCard.setOnClickListener(new View.OnClickListener() {
        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ListFragment.class);
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getTitle());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public void searchDataList(ArrayList<PDFmodel> searchList){
        dataList = searchList;
        notifyDataSetChanged();
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{
    //ImageView recImage;
    TextView recTitle, recDesc, recLang;
    CardView recCard;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        //recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recTitle = itemView.findViewById(R.id.recitem_title);
    }
}