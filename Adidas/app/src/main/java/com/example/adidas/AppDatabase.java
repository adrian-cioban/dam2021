package com.example.adidas;

import android.content.Context;

import androidx.room.Room;

public class AppDatabase {
    private static AppDatabase database;
    private DatabaseAccounts databaseAccounts;

    private AppDatabase(Context context) {
        databaseAccounts = Room.databaseBuilder(context, DatabaseAccounts.class, "accounts-database").build();
    }

    public static AppDatabase getInstance(Context context) {
        if (database == null) {
            database = new AppDatabase(context);
        }
        return database;
    }

    public DatabaseAccounts getDatabase() {
        return databaseAccounts;
    }
}
