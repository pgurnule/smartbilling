package com.billbook.ui.fragments.dashboard;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.billbook.R;
import com.billbook.adapter.MenuAdapter;
import com.billbook.listneres.ItemClickListener;
import com.billbook.ui.activity.EmployeeListActivity;
import com.billbook.ui.activity.EmployeeSalesActivity;
import com.billbook.ui.activity.ItemRegisterActivity;
import com.billbook.ui.activity.ShopBranchActivity;
import com.billbook.ui.activity.ShopSalesActivity;
import com.billbook.ui.activity.StockListActivity;
import com.billbook.ui.fragment_dialog.CustomerDetailDialog;
import com.billbook.ui.fragment_dialog.UsersDetails;

import java.util.List;

public class DashboardFragment extends Fragment implements ItemClickListener {

    private DashboardViewModel dashboardViewModel;
    private RecyclerView rcMenu;
    private MenuAdapter menuAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        rcMenu = (RecyclerView)root.findViewById(R.id.rc_menu);
        rcMenu.setLayoutManager(new LinearLayoutManager(getActivity()));

        dashboardViewModel.getText().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> lstMenu) {
                menuAdapter = new MenuAdapter(lstMenu,getActivity());
                rcMenu.setAdapter(menuAdapter);
                rcMenu.addItemDecoration(new DividerItemDecoration(rcMenu.getContext(), DividerItemDecoration.VERTICAL));
                menuAdapter.setItemClickListener(DashboardFragment.this);
            }
        });

        root.findViewById(R.id.txt_view_details).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            userDetailDialog();
            }
        });
        return root;
    }

    @Override
    public void itemClicked(int position) {
        if(position == 0){
            Intent intent = new Intent(getActivity(), ShopBranchActivity.class);
            startActivity(intent);
        }
        if(position == 1){
            Intent intent = new Intent(getActivity(), StockListActivity.class);
            startActivity(intent);
        }
        if(position == 2){
            Intent intent = new Intent(getActivity(), ItemRegisterActivity.class);
            startActivity(intent);
        }
        if(position == 3){
            Intent intent = new Intent(getActivity(), EmployeeListActivity.class);
            startActivity(intent);
        }if(position == 4){
            Intent intent = new Intent(getActivity(), EmployeeSalesActivity.class);
            startActivity(intent);
        }
        if(position == 5){
            Intent intent = new Intent(getActivity(), ShopSalesActivity.class);
            startActivity(intent);
        }
    }

    public void userDetailDialog() {
        FragmentManager manager = getActivity().getFragmentManager();
        /**Instantiating the DialogFragment class*/
        UsersDetails alert = new UsersDetails();
        /**Creating a bundle object to store the selected item's index*/
        Bundle b = new Bundle();
        /**Storing the selected item's index in the bundle object */
        alert.setArguments(b);
        alert.show(manager, "alert_dialog_radio");
    }
}