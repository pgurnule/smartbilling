package com.billbook.api;

import com.billbook.model.request.Login;
import com.billbook.model.request.ShopDetails;
import com.billbook.model.response.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiEndpoint {

    // Api end point for getting user profile
    @POST("shop/saveShopDetails")
    Call<String> saveShopDetails(@Body ShopDetails shopDetails);

    Call<ResponseLogin> login (@Body Login login);
}
