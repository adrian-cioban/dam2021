package com.example.adidas;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Account.class}, version = 1, exportSchema = false)
public abstract class DatabaseAccounts extends RoomDatabase {
    public abstract AccountDAO accountDAO();
}
