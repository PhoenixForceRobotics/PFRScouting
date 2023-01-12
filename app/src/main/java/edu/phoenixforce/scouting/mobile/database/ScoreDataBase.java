package edu.phoenixforce.scouting.mobile.database;

import android.app.Application;
import static edu.phoenixforce.scouting.mobile.layouts.team_select.teamNum;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.phoenixforce.scouting.mobile.database.daos.GameDao;
import edu.phoenixforce.scouting.mobile.database.daos.PitDao;
import edu.phoenixforce.scouting.mobile.database.entities.GameData;


import edu.phoenixforce.scouting.mobile.database.daos.TeleDao;
import edu.phoenixforce.scouting.mobile.database.entities.PitData;
import edu.phoenixforce.scouting.mobile.database.entities.TeleData;

//Main DB File for the app, finicky

@Database(entities = {TeleData.class, GameData.class, PitData.class} , version = 9, exportSchema = false)
public abstract class ScoreDataBase extends RoomDatabase {

    private static volatile ScoreDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 8;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static final String DBNAME = "ScoreDatabase";


    public abstract TeleDao teleDao();

    public abstract GameDao gameDao();
    public abstract PitDao pitDao();

    public static ScoreDataBase getDatabase(final Context context) {

        if (INSTANCE == null) {
            synchronized (ScoreDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ScoreDataBase.class,
                            DBNAME).addCallback(RoomDatabaseCallBack).allowMainThreadQueries().fallbackToDestructiveMigration().build();
                                                //allowMainThreadQueries is not best practice but it works
                                                //barook was here
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
                GameDao dao2 = INSTANCE.gameDao();
                PitDao dao3 = INSTANCE.pitDao();

                //new PopulateDbAsyncTask(INSTANCE).execute(); //99% chance that this line is useless

                //dao1.nukeTable();
                //TeleData teleData = new TeleData("hi", "hui", "lkdbnc", "csvs", "scdsv", "cvsdv", "svdvs", "vcsdvsdv","yeet","csdghci");
                //dao1.insert(teleData);

                //unless you want something to happen when the application opens, dont mess with this
                //To clarify, in this case do NOT add nuke-table calls or it will all break.
            });
        }
    };


    //99% chance that this line is useless as well
    /*private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        PopulateDbAsyncTask(ScoreDataBase INSTANCE) {
            GameDao gameDao = INSTANCE.gameDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    } */
}









