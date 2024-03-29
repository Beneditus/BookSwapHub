package com.example.bookswaphub;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class, BookEntity.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static final String DB_NAME = "user_database";
    private static UserDatabase instance;

    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            UserDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract UserDao userDao();

    public static synchronized UserDatabase getUserDatabase(Context context) {
        if (instance == null) {
            instance = getInstance(context);
        }
        return instance;
    }
}
