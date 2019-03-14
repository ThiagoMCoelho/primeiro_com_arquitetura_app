package com.fullfire.primeiro_app_com_arquitetura;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceClient {

    public  static final String BASE_URL="http://localhost/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        if (retrofit == null) {

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }

    public static Retrofit getApiClientsemGson(){
        if (retrofit == null) {

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).build();
        }

        return retrofit;
    }
}
