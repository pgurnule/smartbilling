package com.billbook.adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.billbook.R;

import java.util.List;

public class ItemListAdapter  extends RecyclerView.Adapter<ItemListAdapter.ItemHolder> {

    List<String> lstItems;
    Context context;

    public ItemListAdapter(List<String> lstItems, Context context) {
        this.lstItems = lstItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_list,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lstItems.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
