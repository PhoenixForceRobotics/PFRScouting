package edu.phoenixforce.scouting.mobile.database;

import android.app.Application;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.phoenixforce.scouting.mobile.database.Repositories.TeleRepo;
import edu.phoenixforce.scouting.mobile.database.daos.BallDao;
import edu.phoenixforce.scouting.mobile.database.entities.AutoData;
import edu.phoenixforce.scouting.mobile.database.entities.DevId;
import edu.phoenixforce.scouting.mobile.database.entities.Scores;


import edu.phoenixforce.scouting.mobile.database.daos.DevDao;
import edu.phoenixforce.scouting.mobile.database.daos.TeamDao;
import edu.phoenixforce.scouting.mobile.database.daos.TeleDao;
import edu.phoenixforce.scouting.mobile.database.daos.AutoDao;
import edu.phoenixforce.scouting.mobile.database.entities.Team;
import edu.phoenixforce.scouting.mobile.database.entities.TeleData;
import edu.phoenixforce.scouting.mobile.layouts.TeleScore;


@Database(entities = {Scores.class, AutoData.class, Team.class, TeleData.class, DevId.class} , version = 2, exportSchema = false)
public abstract class ScoreDataBase extends RoomDatabase {

    private static volatile ScoreDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 8;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static final String DBNAME = "ScoreDatabase";

    public abstract BallDao ballDao();

    public abstract AutoDao autoDao();

    public abstract TeleDao teleDao();

    public abstract TeamDao teamDao();

    public abstract DevDao devIdDao();

    public static ScoreDataBase getDatabase(final Context context) {

        if (INSTANCE == null) {
            synchronized (ScoreDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ScoreDataBase.class,
                            DBNAME).addCallback(RoomDatabaseCallBack).build();
                }
            }
        }
        return INSTANCE;
    }


    private static ScoreDataBase.Callback RoomDatabaseCallBack = new ScoreDataBase.Callback(){
        @Override
        public void onOpen(@NotNull SupportSQLiteDatabase db){
            super.onOpen(db);
            databaseWriteExecutor.execute(() -> {

                TeleDao dao1 = INSTANCE.teleDao();
                //dao1.nukeTable();
                //TeleData teleData = new TeleData("hi", "hui", "lkdbnc", "csvs", "scdsv", "cvsdv", "svdvs", "vcsdvsdv");
                //dao1.insert(teleData);

                //unless you want something to happen when the application opens, dont mess with this
            });
        }
    };
}









