package edu.phoenixforce.scouting.mobile.database.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.Scores;

@Dao //data access object
public interface BallDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
   @Query("SELECT * FROM scores")
   List<Scores> getAllData();


   @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Scores scores);

    @Query("DELETE FROM Scores")
    void nukeTable();




}
