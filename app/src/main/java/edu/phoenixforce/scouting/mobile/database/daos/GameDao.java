package edu.phoenixforce.scouting.mobile.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.GameData;


@Dao //data access object



public interface GameDao {

    @Query("SELECT * FROM gameData")
    LiveData<List<GameData>> getAllScores();


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(GameData gameData);


    @Query("DELETE FROM GameData")
    void nukeTable();
}