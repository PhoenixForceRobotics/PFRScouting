/* package edu.phoenixforce.scouting.mobile.database.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.DevId;


@Dao //data access object

public interface DevDao {

    @Query("SELECT * FROM devId")
    List<DevId> getAllScores();


    @Insert
    void insertAll(DevId devId);

    @Query("DELETE FROM DevId")
    void nukeTable();
}

 */
