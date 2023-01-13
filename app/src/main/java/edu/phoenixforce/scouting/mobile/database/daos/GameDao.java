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

    @Query("SELECT TBox1 FROM gameData")
    List<String> getTBox1();

    @Query("SELECT TBox2 FROM gameData")
    List<String> getTBox2();

    @Query("SELECT TBox3 FROM gameData")
    List<String> getTBox3();

    @Query("SELECT TBox4 FROM gameData")
    List<String> getTBox4();

    @Query("SELECT TBox5 FROM gameData")
    List<String> getTBox5();

    @Query("SELECT TBox6 FROM gameData")
    List<String> getTBox6();

    @Query("SELECT TBox7 FROM gameData")
    List<String> getTBox7();

    @Query("SELECT TBox8 FROM gameData")
    List<String> getTBox8();

    @Query("SELECT TBox9 FROM gameData")
    List<String> getTBox9();

    @Query("SELECT MBox1 FROM gameData")
    List<String> getMBox1();

    @Query("SELECT MBox2 FROM gameData")
    List<String> getMBox2();

    @Query("SELECT MBox3 FROM gameData")
    List<String> getMBox3();

    @Query("SELECT MBox4 FROM gameData")
    List<String> getMBox4();

    @Query("SELECT MBox5 FROM gameData")
    List<String> getMBox5();

    @Query("SELECT MBox6 FROM gameData")
    List<String> getMBox6();

    @Query("SELECT MBox7 FROM gameData")
    List<String> getMBox7();

    @Query("SELECT MBox8 FROM gameData")
    List<String> getMBox8();

    @Query("SELECT MBox9 FROM gameData")
    List<String> getMBox9();

    @Query("SELECT BBox1 FROM gameData")
    List<String> getBBox1();

    @Query("SELECT BBox2 FROM gameData")
    List<String> getBBox2();

    @Query("SELECT BBox3 FROM gameData")
    List<String> getBBox3();

    @Query("SELECT BBox4 FROM gameData")
    List<String> getBBox4();

    @Query("SELECT BBox5 FROM gameData")
    List<String> getBBox5();

    @Query("SELECT BBox6 FROM gameData")
    List<String> getBBox6();

    @Query("SELECT BBox7 FROM gameData")
    List<String> getBBox7();

    @Query("SELECT BBox8 FROM gameData")
    List<String> getBBox8();

    @Query("SELECT BBox9 FROM gameData")
    List<String> getBBox9();


    //used by Admin to clear data after a pull.
    @Query("DELETE FROM GameData")
    void nukeTable();
}