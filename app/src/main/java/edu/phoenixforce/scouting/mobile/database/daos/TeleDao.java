package edu.phoenixforce.scouting.mobile.database.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.TeleData;


@Dao //data access object



public interface TeleDao {

    @Query("SELECT * FROM teleData")
    List<TeleData> getAllScores();


    @Insert
    void insertAll(TeleData teleData);

    @Query("DELETE FROM TeleData")
    void nukeTable();
}
