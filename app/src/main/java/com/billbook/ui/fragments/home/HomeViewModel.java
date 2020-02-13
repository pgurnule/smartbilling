package com.billbook.ui.fragments.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<String>> lstmOrders;
    private List<String> lstOrderHistory;

    public HomeViewModel() {
        lstmOrders = new MutableLiveData<>();
        lstOrderHistory = new ArrayList<>();
        lstOrderHistory.add("");
        lstOrderHistory.add("");
        lstOrderHistory.add("");
        lstOrderHistory.add("");
        lstOrderHistory.add("");
        lstOrderHistory.add("");
        lstmOrders.setValue(lstOrderHistory);
    }

    public LiveData<List<String>> getText() {
        return lstmOrders;
    }
}