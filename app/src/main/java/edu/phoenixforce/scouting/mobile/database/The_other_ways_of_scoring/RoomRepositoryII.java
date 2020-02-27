package edu.phoenixforce.scouting.mobile.database.The_other_ways_of_scoring;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RoomRepositoryII {

    private ClimberScoreDao mWordDao;
    private LiveData<List<ClimberScore>> mAllWords;

    RoomRepositoryII(Application application) {
        TheRoomDataBase db = TheRoomDataBase.getDatabase(application);
        mWordDao = db.RoomIIDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    LiveData<List<ClimberScore>> getAllWords() {
        return mAllWords;
    }
    void insert(ClimberScore climberScore) {
        TheRoomDataBase.databaseWriteExecutor.execute(() -> {
            mWordDao.Insert(climberScore);
        });
    }
}
