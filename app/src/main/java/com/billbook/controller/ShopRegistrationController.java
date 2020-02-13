package com.billbook.controller;

import android.content.Context;

import com.billbook.api.ApiCall;
import com.billbook.api.RequestNotifier;
import com.billbook.model.ShopDetails;
import com.billbook.observer.ShopRegistrationObserver;

import retrofit2.Response;

public class ShopRegistrationController implements RequestNotifier {

    private Context context;
    private ShopRegistrationObserver shopRegistrationObserver;
    private ApiCall apiCall;

    public ShopRegistrationController(Context context, ShopRegistrationObserver shopRegistrationObserver) {
        this.context = context;
        this.shopRegistrationObserver = shopRegistrationObserver;
        apiCall = new ApiCall(context,this);
    }

    public void sendDataToServer(ShopDetails shopDetails){
        apiCall.saveShopDetails(shopDetails);
    }

    @Override
    public void notifySuccess(Response<?> response) {

        if(response.isSuccessful())
        shopRegistrationObserver.onSuccess();
        else
            shopRegistrationObserver.onError();
    }

    @Override
    public void notifyError(Throwable error) {
        shopRegistrationObserver.onError();
    }
}
