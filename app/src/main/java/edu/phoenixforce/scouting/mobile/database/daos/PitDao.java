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



public interface PitDao {

    @Query("SELECT * FROM pitData")
    List<PitData> getAllScores();




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(PitData pitData);


    @Query("DELETE FROM PitData")
    void nukeTable();

    @Query("Select * FROM pitData WHERE teamNum = :idInt")
    List<PitData> findTeam(int idInt);

    @Query("Select teamNum FROM PitData")
    List<String> getTeams();
}