package edu.phoenixforce.scouting.mobile.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.TeleData;


@Dao //data access object


//Legacy (2021 game)
public interface TeleDao {

    @Query("SELECT * FROM teleData")
    LiveData<List<TeleData>> getAllScores();


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TeleData teleData);


    @Query("DELETE FROM TeleData")
    void nukeTable();
}
