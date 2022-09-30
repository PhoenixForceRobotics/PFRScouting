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

    //Used to write a new collum into the entities in TeleScore
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(GameData gameData);

    @Query("SELECT Scout FROM gameData")
    List<String> getScout();

    @Query("SELECT DevNum FROM gameData")
    List<String> getDevNum();

    @Query("SELECT MatchNum FROM gameData")
    List<String> getMatchNum();

    @Query("SELECT TeamNum FROM gameData")
    List<String> getTeamNum();

    @Query("SELECT Moved FROM gameData")
    List<String> getMoved();

    @Query("SELECT Stalled FROM gameData")
    List<String> getStalled();

    @Query("SELECT ClimbLevel FROM gameData")
    List<String> getClimbLevel();

    @Query("SELECT BallLow FROM gameData")
    List<String> getBallLow();

    @Query("SELECT BallHigh FROM gameData")
    List<String> getBallHigh();

    @Query("SELECT AutoBalLLow FROM gameData")
    List<String> getAutoBallLow();

    @Query("SELECT AutoBallHigh FROM gameData")
    List<String> getAutoBallHigh();

    @Query("SELECT AutoBallCollected FROM gameData")
    List<String> getAutoBallCollected();

    @Query("SELECT AutoBallMissed FROM gameData")
    List<String> getAutoBallMissed();

    @Query("SELECT Collected FROM gameData")
    List<String> getCollected();

    @Query("SELECT Dropped FROM gameData")
    List<String> getDropped();

    @Query("SELECT Missed FROM gameData")
    List<String> getMissed();

    @Query("SELECT TeleMoved FROM gameData")
    List<String> getTeleMoved();

    @Query("SELECT NoShow FROM gameData")
    List<String> getNoShow();

    //used by Admin to clear data after a pull.
    @Query("DELETE FROM GameData")
    void nukeTable();
}