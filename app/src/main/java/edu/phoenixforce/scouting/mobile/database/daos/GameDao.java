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

    @Query("SELECT AutoTopCones FROM gameData")
    List<String> getAutoTopCones();

    @Query("SELECT AutoMidCones FROM gameData")
    List<String> getAutoMidCones();

    @Query("SELECT AutoBottomCones FROM gameData")
    List<String> getAutoBottomCones();

    @Query("SELECT TeleTopCones FROM gameData")
    List<String> getTeleTopCones();

    @Query("SELECT TeleMidCones FROM gameData")
    List<String> getTeleMidCones();

    @Query("SELECT TeleBottomCones FROM gameData")
    List<String> getTeleBottomCones();

    @Query("SELECT AutoTopCubes FROM gameData")
    List<String> getAutoTopCubes();

    @Query("SELECT AutoMidCubes FROM gameData")
    List<String> getAutoMidCubes();

    @Query("SELECT AutoBottomCubes FROM gameData")
    List<String> getAutoBottomCubes();

    @Query("SELECT TeleTopCubes FROM gameData")
    List<String> getTeleTopCubes();

    @Query("SELECT TeleMidCubes FROM gameData")
    List<String> getTeleMidCubes();

    @Query("SELECT TeleBottomCubes FROM gameData")
    List<String> getTeleBottomCubes();

    @Query("SELECT Defence FROM gameData")
    List<String> getDefence();

    @Query("SELECT AutoMoved FROM gameData")
    List<String> getAutoMoved();

    @Query("SELECT TeleMoved FROM gameData")
    List<String> getTeleMoved();

    @Query("SELECT AutoLeftCommunity FROM gameData")
    List<String> getAutoLeftCommunity();

    @Query("SELECT AutoOnStation FROM gameData")
    List<String> getAutoOnStation();

    @Query("SELECT AutoLevelOnStation FROM gameData")
    List<String> getAutoLevelOnStation();

    @Query("SELECT TeleOnStation FROM gameData")
    List<String> getTeleOnStation();

    @Query("SELECT TeleLevelOnStation FROM gameData")
    List<String> getTeleLevelOnStation();

    @Query("SELECT TeleBroke FROM gameData")
    List<String> getTeleBroke();

    @Query("SELECT TeleNoShow FROM gameData")
    List<String> getTeleNoShow();

    @Query("SELECT TBoxOne FROM gameData")
    List<String> getTBoxOne();

    @Query("SELECT TBoxTwo FROM gameData")
    List<String> getTBoxTwo();

    @Query("SELECT TBoxThree FROM gameData")
    List<String> getTBoxThree();

    @Query("SELECT TBoxFour FROM gameData")
    List<String> getTBoxFour();

    @Query("SELECT TBoxFive FROM gameData")
    List<String> getTBoxFive();

    @Query("SELECT TBoxSix FROM gameData")
    List<String> getTBoxSix();

    @Query("SELECT TBoxSeven FROM gameData")
    List<String> getTBoxSeven();

    @Query("SELECT TBoxEight FROM gameData")
    List<String> getTBoxEight();

    @Query("SELECT TBoxNine FROM gameData")
    List<String> getTBoxNine();

    @Query("SELECT MBoxOne FROM gameData")
    List<String> getMBoxOne();

    @Query("SELECT MBoxTwo FROM gameData")
    List<String> getMBoxTwo();

    @Query("SELECT MBoxThree FROM gameData")
    List<String> getMBoxThree();

    @Query("SELECT MBoxFour FROM gameData")
    List<String> getMBoxFour();

    @Query("SELECT MBoxFive FROM gameData")
    List<String> getMBoxFive();

    @Query("SELECT MBoxSix FROM gameData")
    List<String> getMBoxSix();

    @Query("SELECT MBoxSeven FROM gameData")
    List<String> getMBoxSeven();

    @Query("SELECT MBoxEight FROM gameData")
    List<String> getMBoxEight();

    @Query("SELECT MBoxNine FROM gameData")
    List<String> getMBoxNine();

    @Query("SELECT BBoxOne FROM gameData")
    List<String> getBBoxOne();

    @Query("SELECT BBoxTwo FROM gameData")
    List<String> getBBoxTwo();

    @Query("SELECT BBoxThree FROM gameData")
    List<String> getBBoxThree();

    @Query("SELECT BBoxFour FROM gameData")
    List<String> getBBoxFour();

    @Query("SELECT BBoxFive FROM gameData")
    List<String> getBBoxFive();

    @Query("SELECT BBoxSix FROM gameData")
    List<String> getBBoxSix();

    @Query("SELECT BBoxSeven FROM gameData")
    List<String> getBBoxSeven();

    @Query("SELECT BBoxEight FROM gameData")
    List<String> getBBoxEight();

    @Query("SELECT BBoxNine FROM gameData")
    List<String> getBBoxNine();


    //used by Admin to clear data after a pull.
    @Query("DELETE FROM GameData")
    void nukeTable();
}