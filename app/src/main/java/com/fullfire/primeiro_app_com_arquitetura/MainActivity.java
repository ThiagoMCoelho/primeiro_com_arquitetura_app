package com.fullfire.primeiro_app_com_arquitetura;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fullfire.primeiro_app_com_arquitetura.ViewModels.UserViewModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


public class MainActivity extends AppCompatActivity {

   UserViewModel userViewModel;
    EditText editname,editlastName,editage;
   TextView textname, textlastname, textage;
   Button write;
    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        editname = findViewById(R.id.tname);
        editlastName = findViewById(R.id.tlastname);
        editage = findViewById(R.id.tage);
        textname = findViewById(R.id.txtname);
        textlastname = findViewById(R.id.txtlastname);
        textage = findViewById(R.id.txtage);
        write = findViewById(R.id.btnwrite);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setId(0);
                user.setName(editname.getText().toString());
                user.setLastName(editlastName.getText().toString());
                user.setAge(Integer.valueOf(editage.getText().toString()));
                userViewModel.getUser().setValue(user);
            }
        });


        final Observer<User> userObserver = user -> {

            textname.setText(user.getName());
            textlastname.setText(user.getLastName());
            textage.setText(String.valueOf(user.getAge()));
        };


        userViewModel.getUser().observe(this, userObserver);

    }
}
