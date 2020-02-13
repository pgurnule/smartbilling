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

public class ShopListAdapter extends RecyclerView.Adapter<ShopListAdapter.ShopViewHolder> {

    Context context;
    List<String> lstShops;
    ItemClickListener itemClickListener;

    public ShopListAdapter(Context context, List<String> lstShops) {
        this.context = context;
        this.lstShops = lstShops;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_shop_branch_list,parent,false);
        return new ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, final int position) {

        holder.txtViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.itemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstShops.size();
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder {
        TextView txtViewDetails;
        public ShopViewHolder(@NonNull View itemView) {
            super(itemView);
            txtViewDetails = (TextView) itemView.findViewById(R.id.txt_view_details);
        }
    }
}
