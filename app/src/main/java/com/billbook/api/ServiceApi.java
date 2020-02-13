package com.billbook.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anil on 8/20/2017.
 */

public class ServiceApi {

      //Api URL
      public static final String LOCAL_URL = "http://192.168.31.249:8080/smartbillingsystem/";


      // initialed logging intercepter
    protected static OkHttpClient.Builder initlog()
    {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpclient = new OkHttpClient.Builder();
        httpclient.addInterceptor(httpLoggingInterceptor).readTimeout(120, TimeUnit.SECONDS);
        return httpclient;
    }

    // initialized retrofit and set base url and converter
    protected static <S> S initRetrofitCall( Class<S> serviceclass)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LOCAL_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(initlog().build())
                .build();
        return retrofit.create(serviceclass);
    }


}
