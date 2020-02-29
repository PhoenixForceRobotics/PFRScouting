package edu.phoenixforce.scouting.mobile.database.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.Team;


@Dao //data access object

public interface TeamDao {
    @Query("SELECT * FROM team")
    List<Team> getAllScores();


    @Insert
    void insertAll(Team team);

    @Query("DELETE FROM Team")
    void nukeTable();

}


