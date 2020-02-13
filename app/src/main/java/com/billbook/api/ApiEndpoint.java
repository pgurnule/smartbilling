package com.billbook.api;

import com.billbook.model.ShopDetails;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiEndpoint {

    // Api end point for getting user profile
    @POST("shop/saveShopDetails")
    Call<String> saveShopDetails(@Body ShopDetails shopDetails);
}
