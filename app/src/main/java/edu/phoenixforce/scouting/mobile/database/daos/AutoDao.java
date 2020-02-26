package edu.phoenixforce.scouting.mobile.database.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.AutoData;



@Dao //data access object

public interface AutoDao {

    @Query("SELECT * FROM autoData")
    List<AutoData> getAllScores();


    @Insert
    void insertAll(AutoData autoData);

    @Query("DELETE FROM AutoData")
    void nukeTable();
}
