package com.billbook.ui.fragments.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<List<String>> mList;
    private List<String> lstMenuList;

    public DashboardViewModel() {
        mList = new MutableLiveData<>();
        lstMenuList = new ArrayList<>();
        lstMenuList.add("Shop Details");
        lstMenuList.add("Stock List");
        lstMenuList.add("Item Register");
        lstMenuList.add("Employee List");
        lstMenuList.add("Employee's Sales");
        lstMenuList.add("Shop Sales");
        lstMenuList.add("Sales Analysis");
        lstMenuList.add("Tax");

        mList.setValue(lstMenuList);
    }

    public LiveData<List<String>> getText() {
        return mList;
    }
}