package edu.phoenixforce.scouting.mobile.database.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.Scores;


@Dao //data access object
public interface BallDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
   @Query("SELECT * FROM scores")
   List<Scores> getAllScores();

   @Insert
    void insertAll(Scores scores);

    @Query("DELETE FROM Scores")
    void nukeTable();

}


