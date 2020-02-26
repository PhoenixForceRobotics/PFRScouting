package edu.phoenixforce.scouting.mobile.database;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ClimberScore.class, color_wheel.class}, version = 1, exportSchema = false)
public abstract class TheRoomDataBase extends RoomDatabase {

    public abstract Color_Wheel_Dao RoomDao();
    public abstract ClimberScoreDao RoomIIDao();

    private static volatile TheRoomDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TheRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TheRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TheRoomDataBase.class,
                            "RoomDatabase").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            databaseWriteExecutor.execute(() -> {
                Color_Wheel_Dao dao = INSTANCE.RoomDao();
                ClimberScoreDao dao1 = INSTANCE.RoomIIDao();
                //-------------------------------------------------------------------------------------------------
                //-------------------------------------------------------------------------------------------------
                //-------------------------------------------------------------------------------------------------
                //-------------------------------------------------------------------------------------------------
                dao.deleteAll();//<--------------------------THIS IS ONLY FOR TESTING PURPOSES ONLY----------------
                dao1.deleteAll();//<--------------------------THIS IS ONLY FOR TESTING PURPOSES ONLY---------------
                //-------------------------------------------------------------------------------------------------
                //-------------------------------------------------------------------------------------------------
                //-------------------------------------------------------------------------------------------------
                //-------------------------------------------------------------------------------------------------
            });
        }
    };
}