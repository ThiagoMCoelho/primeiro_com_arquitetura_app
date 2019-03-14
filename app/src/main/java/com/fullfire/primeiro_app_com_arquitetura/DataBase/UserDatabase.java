package com.fullfire.primeiro_app_com_arquitetura.DataBase;

import com.fullfire.primeiro_app_com_arquitetura.DAO.UserDAO;
import com.fullfire.primeiro_app_com_arquitetura.User;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    UserDAO userDAO() {
        return null;
    }
}
