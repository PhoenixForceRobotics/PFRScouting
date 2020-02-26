package edu.phoenixforce.scouting.mobile.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Color_Wheel_Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void Insert(color_wheel color_wheel);

    @Query("DELETE FROM `Color Wheel`")
    void deleteAll();

    @Query("SELECT * from `color wheel`")
    LiveData<List<color_wheel>> getAlphabetizedWords();

}
