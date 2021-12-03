package com.example.adidas;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AccountDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Account... accounts);

    @Delete
    void delete(Account account);

    @Query("SELECT * FROM accounts")
    public List<Account> getAccounts();
}
