package com.billbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.billbook.R;
import com.billbook.listneres.ItemClickListener;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder>{
    List<String> lstMenuTitle;
    Context context;
    ItemClickListener itemClickListener;

    public MenuAdapter(List<String> lstMenuTitle, Context context) {
        this.lstMenuTitle = lstMenuTitle;
        this.context = context;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_list_menu,parent,false);
        return new MenuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, final int position) {
       holder.txtMenuTitle.setText(lstMenuTitle.get(position));
       holder.rlParent.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               itemClickListener.itemClicked(position);
           }
       });
    }

    @Override
    public int getItemCount() {
        return lstMenuTitle.size();
    }


    public class MenuHolder extends RecyclerView.ViewHolder {
        TextView txtMenuTitle;
        RelativeLayout rlParent;
        public MenuHolder(@NonNull View itemView) {
            super(itemView);
            txtMenuTitle = (TextView)itemView.findViewById(R.id.txt_menu_title);
            rlParent = (RelativeLayout) itemView.findViewById(R.id.rl_item);
        }
    }
}
