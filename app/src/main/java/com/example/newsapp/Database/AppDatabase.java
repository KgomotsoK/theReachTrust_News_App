package com.example.newsapp.Database;
/**
 * Simple implementation of Room Database
 * Code from developers.android.com
 */

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class}, version  = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    /*
     * Updates the database when there has been new input
     * The initial database used "userId" as key but the app failed to run
     * so instead of delating the already created table
     * The user key is now updated to "uid"
     */
    static final Migration MIGRATION_1_2= new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE user RENAME COLUMN userId TO uid");
        }
    };

    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context) {

        if (INSTANCE == null) {

            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "USERS")
                    .allowMainThreadQueries().addMigrations(MIGRATION_1_2)
                    .build();

        }
        return INSTANCE;
    }
}