package com.billbook.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.billbook.R;
import com.billbook.listneres.ItemClickListener;

import java.util.List;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.OrderHistoryHolder> {

    Context context;
    List<String> lstOrderHistory;
    ItemClickListener itemClickListener;

    public OrderHistoryAdapter(Context context, List<String> lstOrderHistory) {
        this.context = context;
        this.lstOrderHistory = lstOrderHistory;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public OrderHistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.layout_order_history_list,parent,false);
       return new OrderHistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryHolder holder, final int position) {

        if(position == 0){

            holder.txtCompStatus.setBackgroundResource(R.drawable.textview_rounded_corner_layout);
            Drawable img = ContextCompat.getDrawable(context,R.drawable.ic_tick);
            holder.txtCompStatus.setCompoundDrawablesWithIntrinsicBounds(img,null,null,null);
            holder.txtCompStatus.setText("Completed");
        }else{
            holder.txtCompStatus.setText("In Queue");
            Drawable img = ContextCompat.getDrawable(context,R.drawable.ic_warning);
            holder.txtCompStatus.setCompoundDrawablesWithIntrinsicBounds(img,null,null,null);
            holder.txtCompStatus.setBackgroundResource(R.drawable.layout_rounded_not_completed);
        }
        holder.crdOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.itemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstOrderHistory.size();
    }

    public class OrderHistoryHolder extends RecyclerView.ViewHolder {
        private TextView txtCompStatus;
        private CardView crdOrder;
        public OrderHistoryHolder(@NonNull View itemView) {
            super(itemView);
            txtCompStatus = (TextView)itemView.findViewById(R.id.txt_completed);
            crdOrder = (CardView) itemView.findViewById(R.id.crd_order);
        }
    }
}
