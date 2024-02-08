package com.example.bookswaphub;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {

    @Insert
    void insertBook(BookEntity book);

    @Query("SELECT * FROM books")
    List<BookEntity> getAllBooks();

    @Query("SELECT * FROM books WHERE user_id = :userId")
    List<BookEntity> getBooksByUserId(int userId);


}
