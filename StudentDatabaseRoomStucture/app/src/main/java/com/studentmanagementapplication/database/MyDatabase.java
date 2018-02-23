package com.studentmanagementapplication.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.studentmanagementapplication.Models.StudentModel;

/**
 * Created by sneha on 30/1/18.
 */

@Database(entities = {StudentModel.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract DatabaseQuery userDao();


    private static MyDatabase INSTANCE;

    public static MyDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "user-database")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
