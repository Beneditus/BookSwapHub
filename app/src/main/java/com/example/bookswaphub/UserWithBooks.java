package com.example.bookswaphub;

import androidx.room.Embedded;
import androidx.room.Relation;
import java.util.List;

public class UserWithBooks {
    @Embedded
    public UserEntity user;

    @Relation(
            parentColumn = "id",
            entityColumn = "user_id"
    )
    public List<BookEntity> books;
}
