package edu.phoenixforce.scouting.mobile.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.GameData;
import edu.phoenixforce.scouting.mobile.database.entities.PitData;


@Dao //data access object



public interface PitDao {

    @Query("SELECT * FROM pitData")
    LiveData<List<PitData>> getAllScores();


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(PitData pitData);


    @Query("DELETE FROM PitData")
    void nukeTable();
}