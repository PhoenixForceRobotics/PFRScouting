package edu.phoenixforce.scouting.mobile.database.The_other_ways_of_scoring;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ClimberScoreDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void Insert(ClimberScore ClimberScore);

    @Query("DELETE FROM `Climber Scores`")
    void deleteAll();

    @Query("SELECT * from `Climber Scores`")
    LiveData<List<ClimberScore>> getAlphabetizedWords();


}
