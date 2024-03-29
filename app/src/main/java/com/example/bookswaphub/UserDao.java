package com.example.bookswaphub;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    @Query("select * from users where email = :email and password = :password")
    UserEntity getUserEP(String email, String password);

    @Query("SELECT * FROM users")
    List<UserWithBooks> getUsersWithBooks();
}
