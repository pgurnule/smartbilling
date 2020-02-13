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

import org.w3c.dom.Text;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{

    List<String> lstOrder;
    Context context;
    ItemClickListener itemClickListener;

    public OrderAdapter(List<String> lstOrder, Context context) {
        this.lstOrder = lstOrder;
        this.context = context;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_list_order,parent,false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, final int position) {
        holder.txtDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.itemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstOrder.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView txtDiscount;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDiscount = (TextView) itemView.findViewById(R.id.txt_discount);
        }
    }
}
