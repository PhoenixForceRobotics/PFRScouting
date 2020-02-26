package edu.phoenixforce.scouting.mobile.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

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


@Database(entities = {Scores.class, AutoData.class, Team.class, TeleData.class, DevId.class} , version = 1, exportSchema = false)
public abstract class ScoreDataBase extends RoomDatabase {
    public abstract BallDao ballDao();
    public abstract AutoDao autoDao();
    public abstract TeleDao teleDao();
    public abstract TeamDao teamDao();
    public abstract DevDao devIdDao();





    }









