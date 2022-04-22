package edu.phoenixforce.scouting.mobile.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.PitData;


@Dao //data access object


//dao used to save pit collected data - can be reused
public interface PitDao {

    //could return all columns
    @Query("SELECT * FROM pitData")
    List<PitData> getAllScores();

    //Was used to add a row to the DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(PitData pitData);

    //could be used to clear all data
    @Query("DELETE FROM PitData")
    void nukeTable();

    //used to get team specifc data
    @Query("Select * FROM pitData WHERE teamNum = :idInt")
    List<PitData> findTeam(int idInt);

    //Used to collect a list of team numbers in the pit database
    @Query("Select teamNum FROM PitData")
    List<String> getTeams();
}