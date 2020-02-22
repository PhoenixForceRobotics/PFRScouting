package edu.phoenixforce.scouting.mobile.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.phoenixforce.scouting.mobile.database.Daos.BallDao;

@Database(entities = {Scores.class}, version = 1, exportSchema = false)
public abstract class ScoreDataBase extends RoomDatabase {
    public abstract BallDao ballDao();



    }









