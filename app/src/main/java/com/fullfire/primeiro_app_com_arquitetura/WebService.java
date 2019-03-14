package com.fullfire.primeiro_app_com_arquitetura;

import com.fullfire.primeiro_app_com_arquitetura.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {

    @GET("/users/{user}")
    Call<User> getUser(@Path("user") int userId);
}
