package com.example.bookswaphub;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    @Query("select * from users where email = :email and password = :password")
    UserEntity getUserByEmailAndPassword(String email, String password);
}
