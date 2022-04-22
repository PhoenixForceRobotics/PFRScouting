package edu.phoenixforce.scouting.mobile.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.GameData;


@Dao //data access object


// This dao was used to save gameplay specific data for the 2022 season
//This dao should be moved to the legacy folder with the GameData entity
public interface GameDao {

    //Unused, could be used to display info in the app
    @Query("SELECT * FROM gameData")
    LiveData<List<GameData>> getAllScores();

    //Used to write a new colum into the entities in TeleScore
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(GameData gameData);

    //used by Admin to clear data after a pull.
    @Query("DELETE FROM GameData")
    void nukeTable();
}