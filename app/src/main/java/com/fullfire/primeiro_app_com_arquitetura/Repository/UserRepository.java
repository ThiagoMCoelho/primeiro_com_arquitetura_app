package com.fullfire.primeiro_app_com_arquitetura.Repository;

import com.fullfire.primeiro_app_com_arquitetura.DAO.UserDAO;
import com.fullfire.primeiro_app_com_arquitetura.User;
import com.fullfire.primeiro_app_com_arquitetura.WebService;
import com.fullfire.primeiro_app_com_arquitetura.WebServiceClient;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class UserRepository {

    WebService webService;
    Executor executor;
    UserDAO userDAO;

    @Inject
    public UserRepository(WebService webService, Executor executor, UserDAO userDAO) {
        this.webService = webService;
        this.executor = executor;
        this.userDAO = userDAO;
    }



    public MutableLiveData<User> getUser(int userId){
        final MutableLiveData<User> data = new MutableLiveData<>();
        webService.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        return data;
    }
}
