package com.fullfire.primeiro_app_com_arquitetura.DAO;

import com.fullfire.primeiro_app_com_arquitetura.User;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDAO {
    @Insert(onConflict = REPLACE)
    void save(User user);
    @Query("SELECT * FROM User WHERE id = :userId")
    LiveData<User> load(int userId);
}
