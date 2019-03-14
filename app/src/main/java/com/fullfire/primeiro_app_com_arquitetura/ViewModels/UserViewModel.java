package com.fullfire.primeiro_app_com_arquitetura.ViewModels;

import com.fullfire.primeiro_app_com_arquitetura.Repository.UserRepository;
import com.fullfire.primeiro_app_com_arquitetura.User;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {

    private MutableLiveData<User> user;
    private UserRepository userRepository;

   // private UserRepository userRepository;

    public UserViewModel(){    }

    @Inject
    public UserViewModel(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public MutableLiveData<User> getUser(){
        if (user == null){
           user = new MutableLiveData<User>();
        }
        return user;
    }

  public void init(int userId){
        if (this.user != null){
            return;
        }
        user = userRepository.getUser(userId);
    }
}
