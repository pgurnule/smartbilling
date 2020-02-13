package com.billbook.ui.fragments.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.billbook.R;
import com.billbook.adapter.OrderHistoryAdapter;
import com.billbook.listneres.ItemClickListener;
import com.billbook.ui.activity.OrderActivity;
import com.billbook.ui.activity.OrderHistoryActivity;

import java.util.List;

public class HomeFragment extends Fragment implements ItemClickListener {

    private HomeViewModel homeViewModel;
    private RecyclerView rcOrderHistory;
    private OrderHistoryAdapter orderHistoryAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        rcOrderHistory = (RecyclerView)root.findViewById(R.id.rc_order_history);
        rcOrderHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        homeViewModel.getText().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> lstOrders) {
                orderHistoryAdapter = new OrderHistoryAdapter(getActivity(),lstOrders);
                rcOrderHistory.setAdapter(orderHistoryAdapter);
                orderHistoryAdapter.setItemClickListener(HomeFragment.this);
            }
        });

        root.findViewById(R.id.btn_new_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void itemClicked(int position) {
        Intent intent = new Intent(getActivity(), OrderActivity.class);
        getActivity().startActivity(intent);
    }
}