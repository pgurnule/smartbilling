package com.billbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.billbook.R;
import com.billbook.listneres.ItemClickListener;

import java.util.List;

public class StockListAdapter extends RecyclerView.Adapter<StockListAdapter.StockHolder> {

    Context context;
    List<String> lstStock;

    ItemClickListener itemClickListener;
    public StockListAdapter(Context context, List<String> lstStock) {
        this.context = context;
        this.lstStock = lstStock;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public StockHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_stock_list,parent,false);
        return new StockHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockHolder holder, final int position) {

        holder.txtItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.itemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstStock.size();
    }

    public class StockHolder extends RecyclerView.ViewHolder{

        TextView txtItemList;
        public StockHolder(@NonNull View itemView) {
            super(itemView);
            txtItemList = (TextView) itemView.findViewById(R.id.txt_item_list);
        }
    }
}
