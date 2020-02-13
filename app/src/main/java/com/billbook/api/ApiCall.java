package com.billbook.api;

import android.content.Context;


import com.billbook.model.ShopDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCall {
    private Context context;
    private RequestNotifier requestNotifier;

    public ApiCall(Context context, RequestNotifier requestNotifier) {
        this.context = context;
        this.requestNotifier = requestNotifier;
    }

    // getting user data from Api and send it to controller
    public void saveShopDetails(ShopDetails shopDetails)
    {
        ApiEndpoint apiEndPoint = ServiceApi.initRetrofitCall(ApiEndpoint.class);
        Call<String> call = apiEndPoint.saveShopDetails(shopDetails);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                requestNotifier.notifySuccess(response);
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                requestNotifier.notifyError(t);
            }
        });
    }
}
